package com.example.demo.domain.application.domain.score;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public abstract class Record {

    @Id
    protected Long id;

    protected BigDecimal totalScore;

    protected BigDecimal rankPer;

}
