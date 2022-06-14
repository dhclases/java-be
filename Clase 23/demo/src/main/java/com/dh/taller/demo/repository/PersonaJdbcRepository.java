package com.dh.taller.demo.repository;

import com.dh.taller.demo.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Persona buscarPorId(long id) {
        return jdbcTemplate.query("SELECT * FROM PERSONA WHERE ID=?", new PersonaRowMapper(), id).get(0);

    }
}
