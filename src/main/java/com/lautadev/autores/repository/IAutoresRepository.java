package com.lautadev.autores.repository;

import com.lautadev.autores.model.Autores;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoresRepository extends JpaRepository<Autores,Long>{
    
    @Query("SELECT autor FROM Autores autor WHERE :libro MEMBER OF autor.libros_escritos")
    List<Autores> findByLibro(String libro);
    
}
