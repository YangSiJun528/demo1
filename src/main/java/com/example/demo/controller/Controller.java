package com.example.demo.controller;

import com.example.demo.domain.application.domain.Application;
import com.example.demo.domain.application.domain.entry.EntryInfo;
import com.example.demo.domain.application.domain.score.GedRecord;
import com.example.demo.domain.application.domain.score.GraduateRecord;
import com.example.demo.domain.application.domain.score.MiddleGradeBook;
import com.example.demo.domain.application.domain.status.Status;
import com.example.demo.domain.application.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class Controller {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/adduser")
    public ResponseEntity adduser() {

        EntryInfo entryInfo = EntryInfo.builder()
                .id(1L)
                .build();

        Status status = Status.builder()
                .id(1L)
                .build();

        GraduateRecord record = GraduateRecord.builder()
                .id(1L)
                .totalScore(BigDecimal.valueOf(3))
                .artistic(BigDecimal.valueOf(1))
                .grade2_1st(BigDecimal.valueOf(1))
                .grade1_2st(BigDecimal.valueOf(1))
                .build();

        MiddleGradeBook middleGradeBook = MiddleGradeBook.builder()
                .id(1L)
                .gradebook("JSON-STRING")
                .build();

        Application application1 = Application.builder()
                .id(1L)
                .entryInfo(entryInfo)
                .record(record)
                .middleGradeBook(middleGradeBook)
                .status(status)
                .build();

        EntryInfo entryInfo2 = EntryInfo.builder()
                .id(2L)
                .build();

        Status status2 = Status.builder()
                .id(2L)
                .build();

        GedRecord record2 = GedRecord.builder()
                .id(2L)
                .totalScore(BigDecimal.valueOf(1))
                .rankPer(BigDecimal.valueOf(2))
                .build();

        MiddleGradeBook middleGradeBook2 = MiddleGradeBook.builder()
                .id(2L)
                .gradebook("JSON-STIRNG")
                .build();

        Application application2 = Application.builder()
                .id(2L)
                .entryInfo(entryInfo2)
                .record(record2)
                .middleGradeBook(middleGradeBook2)
                .status(status2)
                .build();
        applicationRepository.save(application2);
        applicationRepository.save(application1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
