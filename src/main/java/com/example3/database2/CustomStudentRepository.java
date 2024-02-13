package com.example3.database2;

import java.util.List;

public interface CustomStudentRepository {
    List<Student> findStudentByAgeBetween(Integer age1,Integer age2);

    int updateStudentsByName(String oldName , String newName);
    int deleteStudentsByAge(Integer age);

}

