package com.lautadev.autores.service;

import com.lautadev.autores.model.Autores;
import com.lautadev.autores.repository.IAutoresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoresService implements IAutoresService {
    @Autowired
    private IAutoresRepository autorRepo;

    @Override
    public void saveAutor(Autores autor) {
        autorRepo.save(autor);
    }

    @Override
    public List<Autores> getAutores() {
        return autorRepo.findAll();
    }

    @Override
    public Autores findAutor(Long id) {
        return autorRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteAutor(Long id) {
        autorRepo.deleteById(id);
    }

    @Override
    public void editAutor(Long id, Autores autor) {
        Autores autorEdit = this.findAutor(id);
        autorEdit.setNombre_completo(autor.getNombre_completo());
        autorEdit.setNacionalidad(autor.getNacionalidad());
        autorEdit.setFecha_nacimiento(autor.getFecha_nacimiento());
        autorEdit.setLibros_escritos(autor.getLibros_escritos());
        
        this.saveAutor(autorEdit);
    }

    @Override
    public List<Autores> getAutoresByLibro(String libro) {
        List<Autores> listaAutores = autorRepo.findByLibro(libro);
        return listaAutores;
    }
}
