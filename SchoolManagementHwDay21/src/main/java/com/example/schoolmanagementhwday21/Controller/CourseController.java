package com.example.schoolmanagementhwday21.Controller;

import com.example.schoolmanagementhwday21.ApiResponse.ApiResponse;
import com.example.schoolmanagementhwday21.Model.Course;
import com.example.schoolmanagementhwday21.Model.Teacher;
import com.example.schoolmanagementhwday21.Service.CourseService;
import com.example.schoolmanagementhwday21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {


    private final TeacherService teacherService;

    private final CourseService courseService ;

    @GetMapping("/get")
    public ResponseEntity getAllCourse(){

        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody @Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }


    @PostMapping("/{Cid}/assing/{Tid}")
    public ResponseEntity Assing(@PathVariable Integer Tid , @PathVariable Integer Cid){
        courseService.assingCoursetoTeacher(Cid,Tid);
        return ResponseEntity.status(200).body("assign");
    }


    @GetMapping("/getbyid/{CouersID}")
    public ResponseEntity getTeacherbyCouersid(Integer CouersID){
        String s=courseService.findTeacherbycouersID(CouersID);
        return ResponseEntity.status(200).body(s);
    }





}
