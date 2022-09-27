package com.example.proyecto3.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto3.Modelo.Movimientos;
import com.example.proyecto3.Repositorios.MovimientosRepositorio;

@Service
public class MovimientosServicios {
    
    @Autowired
    private MovimientosRepositorio repositorio;

	public MovimientosServicios(MovimientosRepositorio repositorio){
		this.repositorio = repositorio;
	}

	public Movimientos create(Movimientos transaccion){
		return repositorio.save(transaccion);
	}

	public Movimientos update(Movimientos transaccion){
		return repositorio.save(transaccion);
	}

	
	public void delete(Movimientos transaccion){
		repositorio.delete(transaccion);
	}

	public Optional<Movimientos> porId(Long id){
		return repositorio.findById(id);

	}
	public List<Movimientos> listarMovimientos(){
		return repositorio.findAll();
	}

	
}
