package com.github.marceloasfilho.jsfprimefacesessencialempresajboss.service;

import com.github.marceloasfilho.jsfprimefacesessencialempresajboss.model.Empresa;
import com.github.marceloasfilho.jsfprimefacesessencialempresajboss.repository.EmpresaRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;

public class EmpresaService {
    @Inject
    private EmpresaRepository empresaRepository;

    @Transactional
    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    public void delete(Empresa empresa) {
        this.empresaRepository.delete(empresa);
    }
}
