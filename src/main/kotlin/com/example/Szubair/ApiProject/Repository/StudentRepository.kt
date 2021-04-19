package com.example.Szubair.ApiProject.Repository

import com.example.Szubair.ApiProject.models.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository:JpaRepository<Student,Int> {

    @Query("Select s From Student s where s.email=?1")
    fun findStudentByEmail(email:String): Optional<Student>
}