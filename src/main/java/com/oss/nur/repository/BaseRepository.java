package com.oss.nur.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BaseRepository {
    protected EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("nur_db");
    protected EntityManager entityManager= entityManagerFactory.createEntityManager();
    protected void beginTransaction() {
        entityManager.getTransaction().begin();
    }
    protected void commitTransaction() {
        entityManager.getTransaction().commit();
    }
    protected void rollbackTransaction() {
        entityManager.getTransaction().rollback();
    }
}
