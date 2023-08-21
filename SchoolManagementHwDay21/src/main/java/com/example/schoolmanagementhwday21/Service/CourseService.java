package com.example.schoolmanagementhwday21.Service;

import com.example.schoolmanagementhwday21.ApiResponse.ApiException;
import com.example.schoolmanagementhwday21.Model.Course;
import com.example.schoolmanagementhwday21.Model.Teacher;
import com.example.schoolmanagementhwday21.Repository.CourseRepository;
import com.example.schoolmanagementhwday21.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getAllCourse(){

        return courseRepository.findAll();
    }


    public void addCourse(Course course){
        courseRepository.save(course);
    }



    public void updateCourse(Integer id, Course course){
        Course oldCourse=courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("id not found");
        }

        oldCourse.setName(course.getName());


    }
    public void deleteCourse(Integer id){

        Course oldCourse=courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("id not found");
        }
        courseRepository.deleteById(id);
    }


    public void assingCoursetoTeacher(Integer CouersID , Integer TeacherId ){

        Teacher teacher = teacherRepository.findTeacherById(TeacherId);
        Course course = courseRepository.findCourseById(CouersID);

        if(teacher == null || course == null ){ throw new ApiException("can not assing id not found");}

        course.setTeacher(teacher);
        courseRepository.save(course);

    }



    public String findTeacherbycouersID(Integer CouersID){

        Course oldc = courseRepository.findCourseById(CouersID);
        if(oldc==null){
            throw new ApiException("id not found");
        }

        String in = oldc.getTeacher().getName();

        if(in == null){return "Not found";}
        return in;
    }








}
