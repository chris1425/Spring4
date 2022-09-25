package com.example.proyecto3.Controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto3.Modelo.Transaccion;
import com.example.proyecto3.Repositorios.TransaccionRepositorio;

@RestController
@RequestMapping("/Transaccion")
public class TransaccionControlador {

    @Autowired
    private TransaccionRepositorio repositorioTransaccion;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Transaccion> listar() {
        return repositorioTransaccion.findAll();

    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Transaccion obtenerId(@PathVariable Long id) {
        return repositorioTransaccion.findById(id).get();

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Transaccion agregaTransaccion(@RequestBody Transaccion Transaccion) {
        return repositorioTransaccion.save(Transaccion);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.PATCH)
    public Transaccion patch(@RequestBody Transaccion Transaccion, @PathVariable Long id) {
        return repositorioTransaccion.save(Transaccion);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void eliminarTransaccion(@PathVariable Long id) {
       repositorioTransaccion.deleteById(id);

    }
    

}
