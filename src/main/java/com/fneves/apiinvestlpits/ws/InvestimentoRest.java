package com.fneves.apiinvestlpits.ws;

import com.fneves.apiinvestlpits.classes.Investimento;
import com.fneves.apiinvestlpits.dao.InvestimentoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimento")
public class InvestimentoRest {

    @Autowired
    private InvestimentoDao investimentoDao;

    @GetMapping
    public List<Investimento> get(){
        return investimentoDao.findAll();
    }

    @GetMapping("/{id}")
    public Object investimento (@PathVariable("id") Integer id){
        return investimentoDao.findById(id);
    }

    @PostMapping
    public void post(@RequestBody Investimento investimento){
        investimentoDao.save(investimento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        investimentoDao.deleteById(id);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") Integer id, @RequestBody Investimento investimento){
        investimento.setId(id);
        investimentoDao.save(investimento);
    }

}
