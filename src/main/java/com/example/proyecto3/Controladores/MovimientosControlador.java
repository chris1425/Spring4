package com.example.proyecto3.Controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto3.Modelo.Movimientos;
import com.example.proyecto3.Repositorios.MovimientosRepositorio;

@RestController
@RequestMapping("/movimientos")
public class MovimientosControlador {

    @Autowired
    private MovimientosRepositorio repositorioTransaccion;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Movimientos> listar() {
        return repositorioTransaccion.findAll();

    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Movimientos obtenerId(@PathVariable Long id) {
        return repositorioTransaccion.findById(id).get();

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Movimientos agregaTransaccion(@RequestBody Movimientos Transaccion) {
        return repositorioTransaccion.save(Transaccion);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.PATCH)
    public Movimientos patch(@RequestBody Movimientos Transaccion, @PathVariable Long id) {
        return repositorioTransaccion.save(Transaccion);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void eliminarTransaccion(@PathVariable Long id) {
       repositorioTransaccion.deleteById(id);

    }
    

}
