package com.example.demo.dao.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    EntityManager en;
    EntityTransaction tran;
    public StudentDAOImpl(){
        en = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }

    @Override
    public void createStudent(StudentDAO student) {
        try {
            tran.begin();
            en.persist(student);
            tran.commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            tran.rollback();
        }
    }

    @Override
    public List<StudentDAO> getAllStudent() {
        List<StudentDAO> students = new ArrayList<>();
        try{
            Query query = en.createQuery("select s from StudentEntity s");
            return query.getResultList();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return students;
    }
}
