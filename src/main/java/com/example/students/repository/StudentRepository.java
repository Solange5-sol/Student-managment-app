package com.example.students.repository;

import com.example.students.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Students, Long>
{
    List<Students> findByNameContainingIgnoreCase(String name);
}
