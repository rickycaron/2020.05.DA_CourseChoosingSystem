package com.a20da10.service.spring;


import com.a20da10.Entity.spring.CourseEntity;
import com.a20da10.Entity.spring.StudentEntity;
import com.a20da10.dao.spring.CourseDao;
import com.a20da10.dao.spring.MessageDao;
import com.a20da10.dao.spring.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Scope("prototype")
public class StudentGeneralServiceImpl implements StudentGeneralService {
    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    MessageDao messageDao;

    @Override
    @Transactional
    public StudentEntity getSingleStudent(Integer id) {

        return studentDao.getStudentEntity(id);
    }

    @Override
    @Transactional
    public List<StudentEntity> getAllStudent() {
        return studentDao.getAllStudents();
    }

    @Override
    @Transactional
    public void saveStudent(StudentEntity studentEntity) {
        //because here we use the auto checking duplicating function of spring s]]
        studentDao.updateStudent(studentEntity);
    }

    @Override
    @Transactional
    public void updateStudent(StudentEntity studentEntity) {
        studentDao.updateStudent(studentEntity);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        studentDao.deleteStudent(id);
    }

    @Override
    @Transactional
    public void persistTextMessge(Integer senderId, Integer receriverId, String txt, Date date) {
        messageDao.persistTextMessge(senderId,receriverId,txt,date);
        System.out.println("service persiste message");
    }

    @Override
    @Transactional
    public List<CourseEntity> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    @Transactional
    public CourseEntity getCourseById(Integer course) {
        return courseDao.getCourseEntity(course);
    }

}
