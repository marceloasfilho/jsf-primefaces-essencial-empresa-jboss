package com.github.marceloasfilho.jsfprimefacesessencialempresajboss.controller;

import com.github.marceloasfilho.jsfprimefacesessencialempresajboss.model.Empresa;
import com.github.marceloasfilho.jsfprimefacesessencialempresajboss.repository.EmpresaRepository;
import lombok.Getter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Getter
@Named
@ViewScoped
public class CadastroEmpresaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresaRepository empresaRepository;

    private List<Empresa> todasEmpresas;

    public void todasEmpresas() {
        this.todasEmpresas = this.empresaRepository.findAll();
    }
}