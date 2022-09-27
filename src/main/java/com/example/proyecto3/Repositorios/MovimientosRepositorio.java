package com.example.proyecto3.Repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.proyecto3.Modelo.Movimientos;

@Repository
public interface MovimientosRepositorio extends JpaRepository<Movimientos, Long> {
    
    /*@Modifying
    @Transactional
    @Query  */

}