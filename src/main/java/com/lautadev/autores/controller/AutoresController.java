package com.lautadev.autores.controller;

import com.lautadev.autores.model.Autores;
import com.lautadev.autores.service.IAutoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutoresController {
    @Autowired
    private IAutoresService autorServ;
    
    //Endpoints
    @PostMapping("/crear")
    public String saveAutor(@RequestBody Autores autor){
        autorServ.saveAutor(autor);
        return "Autor creado";
    }
    
    @GetMapping("/traer")
    public List<Autores> getAutores(){
       return autorServ.getAutores();
    }
    
    @GetMapping("/traer/{id}")
    public Autores findAutor(@PathVariable Long id){
        return autorServ.findAutor(id);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable Long id){
        autorServ.deleteAutor(id);
        return "Autor eliminado";
    }
    
    @PutMapping("/editar")
    public Autores editarAutores(@RequestBody Autores autor){
        autorServ.editAutor(autor.getId(), autor);
        return autorServ.findAutor(autor.getId());
    }
    
    @GetMapping("/traer/autor/{libro}")
    public List<Autores> getAutoresByLibro(@PathVariable String libro){
        return autorServ.getAutores();
    }
}
