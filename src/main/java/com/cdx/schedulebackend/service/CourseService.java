package com.cdx.schedulebackend.service;

import com.cdx.schedulebackend.model.request.CourseRequest;
import com.cdx.schedulebackend.repository.CourseRepository;
import com.cdx.schedulebackend.repository.dao.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public ResponseEntity<Course> create(CourseRequest request){
       try {
           var credit = (int) (Math.random() * 4) + 1;
           Course course = courseRepository.save(Course.builder()
                           .StudyTime(request.getStudyTime()) // ช่วงเวลา
                           .lecturer(request.getLecturer()) // อ. ผู้สอน
                           .uuid(UUID.randomUUID().toString()) // id course
                           .credit(String.valueOf(credit)) // หน่วยกิต
                           .studyDate(request.getStudyDate()) // จ-ศ
                           .courseName(request.getCourseName()) //ชื่อวิชา
                   .build());
           return new ResponseEntity<>(course, HttpStatus.CREATED);

       }catch (Exception e){

           return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
       }
    }

    public ResponseEntity<Course> update(Long id, CourseRequest request){

        Optional<Course> course = courseRepository.findById(id);

        if (course.isPresent()){
            Course courseData = course.get();
            courseData.setCourseName(request.getCourseName());
            courseData.setLecturer(request.getLecturer());
            courseData.setStudyTime(request.getStudyTime());
            return new ResponseEntity<>(courseRepository.save(courseData), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Course> findCourseById(Long id){
        Optional<Course> course = courseRepository.findById(id);
        return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<HttpStatus> deleteCourseById(Long id){
        try {
            courseRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<Course>> findAll(){
        try {
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
