package com.example.Szubair.ApiProject.Controller

import com.example.Szubair.ApiProject.Service.StudentService
import com.example.Szubair.ApiProject.models.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("api/students")
class StudentController {

          var studentService: StudentService
          @Autowired
            constructor(studentService: StudentService){
                this.studentService= studentService
            }
    @GetMapping
    fun getStudents():Collection<Student>{
      return this.studentService.getStudents()
    }

    @PostMapping
    fun RegisterStudent(@RequestBody student:Student):Unit {
        studentService.addNewStudent(student)
        //return "New Student"
    }

    @DeleteMapping("/{studentID}")
    fun deleteStudent(@PathVariable studentID:Int):Unit{
        studentService.deleteStudent(studentID)
    }

    @PutMapping("/{studentID}")
    fun updateStudent(@PathVariable studentID:Int, @RequestParam(required=false)name:String,@RequestParam(required=false)email:String):Unit{
        studentService.updateStudent(studentID,name,email)
    }


}