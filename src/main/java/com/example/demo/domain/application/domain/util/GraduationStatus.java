package com.example.demo.domain.application.domain.util;


public enum GraduationStatus {
    //TODO 나중에 아래 항목을 이름 바꾸기 + 이거 위치 진짜 어디임??? 원서 점수 계산하는데, GraduationStatus가 필요함
    // 내 생각엔 presonal아래 있는게 맞음 - 계산을 위해서 사용자 정보를 보는거고, 계산 자체는 점수에서 수행되니까 단방향임
    CANDIDATE,
    GRADUATE,
    GED
}
