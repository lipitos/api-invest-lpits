package com.fneves.apiinvestlpits.ws;

import com.fneves.apiinvestlpits.classes.Investimento;
import com.fneves.apiinvestlpits.dao.InvestimentoDao;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimento")
public class InvestimentoRest {

    @Autowired
    private InvestimentoDao investimentoDao;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de investimentos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message =  "Foi gerada uma exceção no servidor"),
    })

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
