package com.example.demo.domain.application.domain.status;

import com.example.demo.domain.application.domain.util.Major;
import com.example.demo.domain.application.domain.util.Result;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Status {

    @Id
    @Column(name = "application_status_id")
    private Long id;

    Boolean isFinalSubmitted;

    Result firstEvaluation;

    Result secondEvaluation;

    Boolean isPrintsArrived; // 관리자서 실물 서류로 받았는지?

    private Major finalMajor;

    public Boolean isFinalSubmitted() {
        return isFinalSubmitted;
    }

    public Boolean isPrintsArrived() {
        return isPrintsArrived;
    }
}