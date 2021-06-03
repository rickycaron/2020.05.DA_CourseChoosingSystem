package com.a20da10.service.ejb;

import com.a20da10.Entity.ejb.EJBInstructorEntity;
import com.a20da10.Entity.spring.CourseEntity;
import com.a20da10.Entity.spring.CourseTypeEnum;
import com.a20da10.dao.ejb.InstructorDao;

import javax.inject.Inject;
import java.util.List;

public class InstructorSelfServiceImpl implements InstructorSelfServiceLocal,InstructorSelfServiceRemote{

    int instructorId;

    int testInt = 0;
    @Inject
    private InstructorDao dao;

    @Override
    public List<CourseEntity> getCoursesOfMine(int insId) {
        return null;
    }
    @Override
    public void insertInstructor(String firstName, String lasttName, String email, String password) {
        dao.create(new EJBInstructorEntity(firstName, lasttName, email, password));
    }

    @Override
    public void updateInstructor(int insId, String firstName, String lasttName, String email){
        dao.updateById(insId, firstName, lasttName, email);
    }

    @Override
    public void deleteInstructorByInsId(int insId) {
        dao.deleteById(insId);
    }

    @Override
    public void updateCourseInfo(int courseId, String name, int instructorId, CourseTypeEnum type) {
        dao.updateCourseInfo(courseId, name, instructorId, type);
    }

    @Override
    public void addNewCourse(String name, int instructorId, CourseTypeEnum type){
        dao.addNewCourse(name, instructorId, type);
    }

    @Override
    public void deleteCourse(int courseId){
        dao.deleteCourse(courseId);
    }

    public int incrementTestInt (){
        testInt++;
        return testInt;
    }

}
