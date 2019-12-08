package io.mbab.sda.sdajpa17.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractCustomCrudRepository<T, ID> implements CustomCrudRepository<T, ID> {

    protected EntityManager em;
    private Class<T> clazz;

    public AbstractCustomCrudRepository(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> from = query.from(clazz);

        return em.createQuery(query.select(from))
                .getResultList();
    }

    @Override
    public T findById(ID id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> from = query.from(clazz);

        return em.createQuery(
                query.select(from)
                        .where(criteriaBuilder.equal(from.get("id"), id)))
                .getSingleResult();
    }

    @Override
    @Transactional
    public T create(T obj) {
        em.persist(obj);

        return obj;
    }

    @Override
    @Transactional
    public T update(T obj) {
        return em.merge(obj);
    }

    @Override
    @Transactional
    public void deleteById(ID id) {

        em.createQuery("DELETE FROM " + clazz.getSimpleName() + " WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
