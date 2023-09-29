package com.github.marceloasfilho.jsfprimefacesessencialempresajboss.repository;

import com.github.marceloasfilho.jsfprimefacesessencialempresajboss.model.Empresa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class EmpresaRepository {
    @PersistenceUnit(unitName = "pu-empresa")
    private EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

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
