package com.example.demo.domain.application.domain.entry;

import com.example.demo.domain.application.domain.util.Major;
import com.example.demo.domain.application.domain.util.GraduationStatus;
import com.example.demo.domain.application.domain.util.Name;
import com.example.demo.domain.application.domain.util.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "entry_info")  // TODO 이름 생각해보기
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class EntryInfo {

    @Id
    @Column(name = "application_personal_id")
    private Long id;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "applicant_name"))
    private Name applicantName;

    private String applicantGender; //Enum 사용

    private LocalDate applicantBrith;

    private String address;

    private String detailAddress;

    private String telephone; // TODO 이거 Optional임? 뭐지

    @Embedded
    @AttributeOverride(name = "phoneNumber", column = @Column(name = "applicant_phone_number"))
    private PhoneNumber applicantPhoneNumber;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "guardian_name"))
    private Name guardianName;

    private String relationWithApplicant;

    @Embedded
    @AttributeOverride(name = "phoneNumber", column = @Column(name = "guardian_phone_number"))
    private PhoneNumber guardianPhoneNumber;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "teacher_name"))
    private Name teacherName;

    @Embedded
    @AttributeOverride(name = "phoneNumber", column = @Column(name = "teacher_phone_number"))
    private PhoneNumber teacherPhoneNumber;

    @Size(min=3, max=3)
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(
            name = "desired_departments",
            joinColumns = @JoinColumn(name = "application_id")
    )
    private Map<Integer, Major> desiredMajors;  // 이부분 좀 애매

    private GraduationStatus graduationStatus;
}
