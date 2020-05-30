package com.fneves.apiinvestlpits.dao;

import com.fneves.apiinvestlpits.classes.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentoDao extends JpaRepository<Investimento, Integer>{

}


