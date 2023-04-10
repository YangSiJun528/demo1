package com.example.demo.domain.application.domain.score;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gradebook")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MiddleGradeBook {

    @Id
    Long id;

    @Lob
    String gradebook;

    public Object calculateDerivedGrade() {
        // 도출 성적 계산 로직
        // 예: 성적에 따라 도출 성적을 계산하는 로직을 구현
        // this.score 값을 사용하여 계산
        return null;
    }

}
