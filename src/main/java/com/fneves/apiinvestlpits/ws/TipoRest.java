package com.fneves.apiinvestlpits.ws;

import com.fneves.apiinvestlpits.classes.Tipo;
import com.fneves.apiinvestlpits.dao.TipoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo")
public class TipoRest {

    @Autowired
    private TipoDao tipoDao;

    @GetMapping
    public List<Tipo> get(){
        return tipoDao.findAll();
    }

    @GetMapping("/{id}")
    public Object tipo (@PathVariable("id") Integer id){
        return tipoDao.findById(id);
    }

    @PostMapping
    public void post(@RequestBody Tipo tipo){
        tipoDao.save(tipo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        tipoDao.deleteById(id);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") Integer id, @RequestBody Tipo tipo){
        tipo.setId(id);
        tipoDao.save(tipo);
    }
}
