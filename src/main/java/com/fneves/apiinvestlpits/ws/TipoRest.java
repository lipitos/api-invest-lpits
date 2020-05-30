package com.fneves.apiinvestlpits.ws;

import com.fneves.apiinvestlpits.classes.Tipo;
import com.fneves.apiinvestlpits.dao.TipoDao;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo")
public class TipoRest {

    @Autowired
    private TipoDao tipoDao;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna os tipos de investimentos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message =  "Foi gerada uma exceção no servidor"),
    })

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
