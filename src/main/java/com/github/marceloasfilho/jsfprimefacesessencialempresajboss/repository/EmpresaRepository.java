package com.github.marceloasfilho.jsfprimefacesessencialempresajboss.repository;

import com.github.marceloasfilho.jsfprimefacesessencialempresajboss.model.Empresa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class EmpresaRepository {
    @PersistenceContext(unitName = "pu-empresa")
    private EntityManager entityManager;

    public Empresa findById(Long id) {
        return this.entityManager.find(Empresa.class, id);
    }

    public List<Empresa> findAllByName(String nome) {
        TypedQuery<Empresa> query = this.entityManager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
        query.setParameter("nomeFantasia", nome.concat("%"));
        return query.getResultList();
    }

    public List<Empresa> findAll() {
        TypedQuery<Empresa> query = this.entityManager.createQuery("from Empresa", Empresa.class);
        return query.getResultList();
    }

    public Empresa save(Empresa empresa) {
        return this.entityManager.merge(empresa);
    }

    public void delete(Empresa empresa) {
        Empresa empresaById = this.findById(empresa.getId());
        this.entityManager.remove(empresaById);
    }
}
