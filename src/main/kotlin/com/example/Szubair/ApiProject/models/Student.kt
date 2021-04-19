package com.example.Szubair.ApiProject.models

import java.time.LocalDate
import java.time.Period
import javax.persistence.*

@Entity
@Table(name="student")
class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            )

    public var id:Int
    public var name:String
    public set(value) {
            field=value
        }
    public var email:String
    public  set(value) {
            field=value
        }
    public var dob:LocalDate
    @Transient
    public var age:Int
    get() {
      return  Period.between(this.dob,LocalDate.now()).years
    }
    public set(value) {
        field=value
    }

    constructor(id:Int, name:String, email:String, dob:LocalDate)
    {
        this.id =id
        this.name = name
        this.email = email
        this.dob = dob
        this.age = Period.between(this.dob,LocalDate.now()).years

    }

}