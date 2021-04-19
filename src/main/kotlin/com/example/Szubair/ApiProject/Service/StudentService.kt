package com.example.Szubair.ApiProject.Service

import com.example.Szubair.ApiProject.Repository.StudentRepository
import com.example.Szubair.ApiProject.models.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.bind.Bindable.listOf
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*
import javax.transaction.Transactional

@Service
class StudentService {


   //var StudentList= mutableListOf<Student>()
    var  studentRepository:StudentRepository

            @Autowired
            constructor(studentRepository:StudentRepository ){
                this.studentRepository=studentRepository
            }

    fun getStudents():Collection<Student>{
      //StudentList.add(Student(1,"zubair","szubair1833@gmail.com", LocalDate.now(),24))
       // StudentList.add(Student(1,"adil","szubair1833@gmail.com", LocalDate.now(),24))


        //studentList.add(student1)
        return studentRepository.findAll()
       // return this.StudentList
    }

    fun addNewStudent(student:Student){
        var studentByEmail= studentRepository.findStudentByEmail(student.email)
        if(studentByEmail.isPresent)
       {

            throw IllegalStateException("EMAIL TAKEN")
        }else{

            studentRepository.save(student)
        }
    }

    fun deleteStudent(studentID: Int)
    {
        var exists = studentRepository.existsById(studentID)
        if(exists){
            studentRepository.deleteById(studentID)
        }
        else{
            throw IllegalStateException("ID does not exits")
        }
    }
    @Transactional
    fun updateStudent(id:Int,name:String,email:String):Unit{
        var student = studentRepository.findById(id)
        //return student
        //student.name=name
        //student.email=email
    }
}