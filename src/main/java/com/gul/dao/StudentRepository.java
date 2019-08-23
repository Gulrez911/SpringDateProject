package com.gul.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gul.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Page<Student> findAll(Pageable pageable);

	@Query(value = "select * from Student s where s.id=:id", nativeQuery = true)
	Student getDocument(@Param("id") int id);
}
