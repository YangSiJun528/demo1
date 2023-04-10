package com.example.demo.domain.application.domain.score;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("GED")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public class GedRecord extends Record {

    private BigDecimal examTotalScore;

    private BigDecimal examMaxScore;

    public GedRecord(MiddleGradeBook middleGradeBook) {
    }
}
