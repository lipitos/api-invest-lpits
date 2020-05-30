package com.fneves.apiinvestlpits.dao;

import com.fneves.apiinvestlpits.classes.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDao extends JpaRepository<Tipo, Integer> {
}
