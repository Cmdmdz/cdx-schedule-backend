package com.cdx.schedulebackend.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoRepositoryBean
public class CourseRequest {
    @NotBlank
    private String courseName;
    @NotBlank
    private String lecturer;
    private String studyTime;
    private String studyDate;

}
