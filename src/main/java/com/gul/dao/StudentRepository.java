package com.gul.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
