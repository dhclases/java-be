package com.dh.institute.repository;

import com.dh.institute.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    @Query("from Student s where s.lastname like ?1")
    Set<Student> getStudentByLastnameLike(@Param("lastname") String lastname);

}
