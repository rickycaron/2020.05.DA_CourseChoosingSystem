package com.a20da10.Entity.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "school")
public class CourseEntity implements Serializable {

    @Id
    private int courseId;
    private String name;
    private Integer instructorId;
    private String type;

    @Column(name = "weekDay", nullable = true)
    private Integer weekDay;
    @Column(name = "beginTime", nullable = true)
    private String beginTime;
    @Column(name = "endTime", nullable = true)
    private String endTime;

    @Column(name = "description", nullable = true,length = 1000)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }



    public CourseEntity(String name, Integer instructorId, CourseTypeEnum type) {
        this.name = name;
        this.instructorId = instructorId;
        this.type = type.toString();

    }

    public CourseEntity() {

    }

    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }

    @JsonIgnoreProperties("courseEntities")
    @ManyToMany(fetch = FetchType.EAGER,
                cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    private List<StudentEntity> studentEntities;


    @Column(name = "courseId", nullable = false)
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 95)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "instructorId", nullable = false)
    public Integer getInstructorId() {
        return instructorId;
    }
    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public CourseTypeEnum getType() {
        CourseTypeEnum enumType = CourseTypeEnum.valueOf(this.type);
        return enumType;
    }
    public void setType(CourseTypeEnum type) {
        this.type = type.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return courseId == that.courseId && Objects.equals(name, that.name) && Objects.equals(instructorId, that.instructorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, name, instructorId);
    }

    public void addStudent(StudentEntity studentEntity){
        if (studentEntities==null){
            studentEntities=new ArrayList<>();
        }
        studentEntities.add(studentEntity);
    }


    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", instructorId is=" + instructorId +
                '}';
    }
}
