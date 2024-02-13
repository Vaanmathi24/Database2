package com.example3.database2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {

  @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findStudentByAgeBetween(Integer age1, Integer age2) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.age BETWEEN :age1 AND :age2", Student.class)
                .setParameter("age1", age1)
                .setParameter("age2", age2)
                .getResultList();
    }
    @Override
    @Transactional
    public int updateStudentsByName(String oldName, String newName) {
        return entityManager.createQuery("UPDATE Student s SET s.name = :newName WHERE s.name = :oldName")
                .setParameter("oldName", oldName)
                .setParameter("newName", newName)
                .executeUpdate();
    }

    @Override
    @Transactional
    public int deleteStudentsByAge(Integer age) {
        return entityManager.createQuery("DELETE FROM Student s WHERE s.age = :age")
                .setParameter("age", age)
                .executeUpdate();
    }
}

//    List<Student> findByAge(int age)

//    @Modifying
//    @Transactional
//    default void updateStudentsAgeToNewAge(int newAge) {
//        List<Student> studentsToUpdate = findByAge(23);
//        for (Student student : studentsToUpdate) {
//            student.setAge(newAge);
//            save(student);
//        }
