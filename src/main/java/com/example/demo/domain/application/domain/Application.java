package com.example.demo.domain.application.domain;


import com.example.demo.domain.application.domain.util.GraduationStatus;
import com.example.demo.domain.application.domain.entry.EntryInfo;
import com.example.demo.domain.application.domain.score.GedRecord;
import com.example.demo.domain.application.domain.score.GraduateRecord;
import com.example.demo.domain.application.domain.score.Record;
import com.example.demo.domain.application.domain.score.MiddleGradeBook;
import com.example.demo.domain.application.domain.status.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Application {

    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, optional=false)
    private EntryInfo entryInfo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, optional=false)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, optional=false)
    private MiddleGradeBook middleGradeBook;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, optional=false)
    private Record record;

    public Application(Long id, EntryInfo entryInfo, Status status, MiddleGradeBook middleGradeBook, Record record) {
        this.id = id;
        this.entryInfo = entryInfo;
        this.status = status;
        this.middleGradeBook = middleGradeBook;
        this.record = record;
        validate();
    }

    private void validate() {
        GraduationStatus graduationStatus = entryInfo.getGraduationStatus();
        boolean isGedGraduationStatus = graduationStatus.equals(GraduationStatus.GED);
        boolean isGraduateOrCandidateGraduationStatus = graduationStatus.equals(GraduationStatus.GRADUATE)
                || graduationStatus.equals(GraduationStatus.CANDIDATE);

        boolean isGedRecord = record instanceof GedRecord;
        boolean isGraduateRecord = record instanceof GraduateRecord;

        if ((isGedGraduationStatus && !isGedRecord) && (isGraduateOrCandidateGraduationStatus && !isGraduateRecord)) {
            throw new RuntimeException("entryInfo의 graduationStatus와 Record의 형식? 이 맞지 않음");
        }
    }
}