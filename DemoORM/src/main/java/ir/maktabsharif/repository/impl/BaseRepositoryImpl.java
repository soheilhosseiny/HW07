package ir.maktabsharif.repository.impl;


import ir.maktabsharif.repository.BaseRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class BaseRepositoryImpl<T> implements BaseRepository<T> {

    private EntityManagerProvider entityManagerProvider;

    public BaseRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public void saveOrUpdate(T t) {

        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(t);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            entityManager.close();
        }

        /*EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerProvider.getEntityManager()){
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(t);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }*/

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Set getAll() {
        return Collections.emptySet();
    }
}
