package com.example.proyecto3.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto3.Modelo.Transaccion;
import com.example.proyecto3.Servicios.TransaccionServicios;

@RestController
@RequestMapping("/transacciones")
public class TransaccionControlador {

    @Autowired
    private TransaccionServicios servicios;

    public TransaccionControlador(TransaccionServicios servicios){
        this.servicios = servicios;

    }
    @PostMapping
    private Transaccion guardar(@RequestBody Transaccion transaccion){
        return this.servicios.create(transaccion);
    }

    @GetMapping("/listas_transacciones")
    public List<Transaccion> listas_transacciones(){
        return this.servicios.getAllTransacciones();
    }
    @PutMapping
    public Transaccion actualizar(@RequestBody Transaccion transaccion){
        return this.servicios.update(transaccion);
    }
    @DeleteMapping
    public void eliminar(@RequestBody Transaccion transaccion){
        this.servicios.delete(transaccion);
    }

    @GetMapping(value = "/{id}")
    public Optional<Transaccion>listaPorId(@PathVariable ("id") Long id){
        return this.servicios.porId(id);
    }
}
