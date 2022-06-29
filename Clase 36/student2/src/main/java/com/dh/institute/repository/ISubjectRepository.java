package com.dh.institute.repository;

import com.dh.institute.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectRepository extends JpaRepository<Subject, Long> {

}
