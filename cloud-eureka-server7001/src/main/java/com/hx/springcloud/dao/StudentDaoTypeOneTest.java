//package com.hx.springcloud.dao;
//
//import com.hx.springcloud.entity.Student;
//import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.List;
//
//
//@SpringBootTest
//class StudentDaoTypeOneTest {
//    @Autowired
//    private StudentDaoTypeOne studentDaoTypeOne;
//
//    @Test
//    void addOneStudent(){
////        插入10行
//        for (Integer count = 0; count < 10; count++) {
//            Student student = new Student()
//                    .setStudentId("student_"+count) //如果自己不去设置id则系统会分配给一个id
//                    .setStudentName("Godfery"+count)
//                    .setStudentAge(count)
//                    .setStudentScore(98.5-count)
//                    .setStudentBirthday(new Date());
//            studentDaoTypeOne.save(student);
//        }
//    }
//
//    @Test
//    void deleteOneStudentByStudentId(){
////        删除id为student_0的学生
//        studentDaoTypeOne.deleteById("student_0");
//    }
//
//    @Test
//    void updateOneStudent(){
////        修改姓名为Godfery1的Student年龄为22
//        Student student = studentDaoTypeOne.getAllByStudentName("Godfery1");
//        student.setStudentAge(99);
//        studentDaoTypeOne.save(student);
//        Student allByStudentAge = studentDaoTypeOne.getAllByStudentAge(99);
//        Assertions.assertEquals(99, (int) allByStudentAge.getStudentAge());
//        studentDaoTypeOne.save(student);
//
//    }
//
//    @Test
//    void getOneStudentByStudentId(){
//        System.out.println(studentDaoTypeOne.findById("student_1"));
//    }
//
//    @Test
//    void getAllStudent(){
//        List<Student> studentList = studentDaoTypeOne.findAll();
//        studentList.forEach(System.out::println);
//    }
//}