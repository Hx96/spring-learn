package com.hx.springcloud.dao;

import com.hx.springcloud.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentDaoTypeOne extends MongoRepository<Student, String> {
    Student getAllByStudentName(String godfery1);
    Student getAllByStudentAge(Integer studentAge);
}
