package org.ngarcia.webapp.jaxws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.ngarcia.webapp.jaxws.models.Curso;
import org.ngarcia.webapp.jaxws.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class CursoServiceImpl implements CursoService {

    @Inject
    private CursoRepository repository;

    @Override
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    public Curso guardar(Curso curso) {
        System.out.println("CURSO GUARDAR " + curso.getNombre());
        return repository.guardar(curso);
    }

    @Override
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
