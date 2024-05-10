package com.lautadev.autores.service;

import com.lautadev.autores.model.Autores;
import java.util.List;

public interface IAutoresService {
    
    public void saveAutor(Autores autor);
    public List<Autores> getAutores();
    public Autores findAutor(Long id);
    public void deleteAutor(Long id);
    public void editAutor(Long id, Autores autor);
    public List<Autores> getAutoresByLibro(String libro);
       
}
