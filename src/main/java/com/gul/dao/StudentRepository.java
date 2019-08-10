package com.gul.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Page<Student> findAll(Pageable pageable);
}
