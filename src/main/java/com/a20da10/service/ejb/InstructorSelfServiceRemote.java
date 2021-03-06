package com.a20da10.service.ejb;

import com.a20da10.Entity.ejb.EJBInstructorEntity;
import com.a20da10.Entity.spring.CourseEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface InstructorSelfServiceRemote {
    EJBInstructorEntity getMyInfo ();
    List<CourseEntity> getCoursesOfMine ();
    void insertInstructor(String firstName, String lasttName, String email, String password, String instructorNumber);
    void updateInstructor(EJBInstructorEntity instructorEntity);
    void deleteInstructorByInsId(int insId);
    void addNewCourse(CourseEntity courseEntity);
    void deleteCourse(int courseId);
    void updateCourseInfo(CourseEntity courseEntity);
    void setInsId(int id);
    int getInsId();
}
