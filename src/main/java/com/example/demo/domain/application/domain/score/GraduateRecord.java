package com.example.demo.domain.application.domain.score;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("GRADUATE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public class GraduateRecord extends Record {

    private BigDecimal grade1First;  // 1 grade 1 semester

    private BigDecimal grade1_2st;

    private BigDecimal grade2_1st;

    private BigDecimal grade2_2st;

    private BigDecimal grade3_1st;

    private BigDecimal artistic;

    private BigDecimal curricularSubTotal;

    private BigDecimal attendance;

    private BigDecimal volunteer;

    private BigDecimal extracurricularSubTotal;

    public GraduateRecord(MiddleGradeBook middleGradeBook) {
    }
}
