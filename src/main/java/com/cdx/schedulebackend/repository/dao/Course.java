package com.cdx.schedulebackend.repository.dao;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String courseName;
    private String lecturer;
    private String StudyTime;
    private String studyDate;
    private String uuid;
    private String credit;


}
