package com.example.proyecto3.ServiciosFront;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.proyecto3.Modelo.Movimientos;

import com.example.proyecto3.Repositorios.MovimientosRepositorio;

@Service
public class MovimientosServicioFront {

    @Autowired
    private MovimientosRepositorio repositorio;

    public MovimientosServicioFront(MovimientosRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Movimientos> listaMovimientos() {
        return repositorio.findAll();
    }

    public Movimientos guardaMovimientos(Movimientos movimientos) {
        return repositorio.save(movimientos);
    }

    public Movimientos obtenerMovimientosId(Long id) {
        return repositorio.findById(id).get();
    }

    public Movimientos actualizarMovimientos(Movimientos movimientos) {
        return repositorio.save(movimientos);
    }

    public void eliminarMovimientos(Long id) {
        repositorio.deleteById(id);
    }

}
