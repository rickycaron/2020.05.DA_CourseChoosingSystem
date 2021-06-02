package com.a20da10.dao.ejb;

import com.a20da10.Entity.spring.CourseTypeEnum;
import com.a20da10.Entity.ejb.EJBInstructorEntity;
import com.a20da10.Entity.spring.CourseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class InstructorDaoImpl implements InstructorDao {

    @PersistenceContext(name="DAPU")
    private EntityManager em;
    @Override
    @Transactional
    public void create(EJBInstructorEntity entity) {
        em.persist(entity);
    }

    @Override
    @Transactional
    public void updateById(int id, String firstName, String lasttName, String email) {
        EJBInstructorEntity i = em.find(EJBInstructorEntity.class,id);
        i.setFirstName(firstName);
        i.setLastName(lasttName);
        i.setEmail(email);
    }

    @Override
    public List<EJBInstructorEntity> getByName(String firsName, String lastName) {
        Query query =em.createQuery("SELECT i FROM  EJBInstructorEntity i WHERE i.firstName = :firstName AND i.lastName = :lastName", EJBInstructorEntity.class);
        query.setParameter("firstName",firsName);
        query.setParameter("lastName",lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public EJBInstructorEntity getById(int id) {
        EJBInstructorEntity i = em.find(EJBInstructorEntity.class,id);
        return i;
    }

    @Override
    @Transactional
    public List<EJBInstructorEntity> getAll() {
        Query query = em.createQuery("SELECT p FROM EJBInstructorEntity p");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        EJBInstructorEntity i = em.find(EJBInstructorEntity.class,id);
        em.remove(i);
    }


    @Override
    @Transactional
    public List<CourseEntity> findCoursesByInsId(int insId) {
        Query query = em.createQuery("SELECT c FROM CourseEntity c JOIN EJBInstructorEntity i WHERE i.instructorId = :insId");
        query.setParameter("insId", insId);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateCourseType(int id, CourseTypeEnum type) {
        CourseEntity c = em.find(CourseEntity.class,id);
        c.setType(type);
    }

    @Override
    @Transactional
    public EJBInstructorEntity getInstructorEntityByEmail(String email) {
        Query query =em.createQuery("SELECT i FROM  EJBInstructorEntity i WHERE i.email = :email",EJBInstructorEntity.class);
        query.setParameter("email",email);
        return (EJBInstructorEntity) query.getSingleResult();
    }

}



