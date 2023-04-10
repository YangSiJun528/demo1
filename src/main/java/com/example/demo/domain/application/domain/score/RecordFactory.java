package com.example.demo.domain.application.domain.score;


import com.example.demo.domain.application.domain.util.GraduationStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecordFactory {

    public static Record create(GraduationStatus graduationStatus, MiddleGradeBook middleGradeBook) {
        if(graduationStatus.equals(GraduationStatus.CANDIDATE) || graduationStatus.equals(GraduationStatus.GRADUATE)) {
            return new GraduateRecord(middleGradeBook);
        }
        else if(graduationStatus.equals(GraduationStatus.GED)) {
            return new GedRecord(middleGradeBook);
        }
        else {
            throw new RuntimeException("지원하는 graduationStatus이 아님");
        }
    }
}