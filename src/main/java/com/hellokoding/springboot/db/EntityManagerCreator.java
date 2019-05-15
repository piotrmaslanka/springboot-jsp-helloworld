package com.hellokoding.springboot.db;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
@Scope(value="singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EntityManagerCreator {

    EntityManagerFactory emf;

    @PostConstruct
    public void on_create() {
        emf = Persistence.createEntityManagerFactory("mydb");
    }

    public EntityManager create() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public void close(EntityManager em) {
        em.getTransaction().commit();
        em.close();
    }

    @PreDestroy
    public void on_destroy() {
        emf.close();
    }
}
