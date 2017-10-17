package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.exception.TransactionException;
import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class JpaGenericDao <T extends AbstractModel> implements Dao <T> {

        protected JpaSessionManager sm;
        private Class<T> modelType;

        public JpaGenericDao(JpaSessionManager sm, Class<T> modelType) {
            this.sm = sm;
            this.modelType = modelType;
        }

        @Override
        public List<T> findAll() {

            EntityManager em = sm.getCurrentSession();

            try {
                CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
                Root<T> root = criteriaQuery.from(modelType);
                return em.createQuery(criteriaQuery).getResultList();
            } catch (HibernateException ex) {

                throw new TransactionException();

            }

        }

        @Override
        public T findById(Integer id) {

            try {

                EntityManager em = sm.getCurrentSession();
                return em.find(modelType, id);

            } catch (HibernateException ex) {

                throw new TransactionException();

            }

        }

        @Override
        public T saveOrUpdate(T modelObject) {

            EntityManager em = sm.getCurrentSession();

            try {

                return em.merge(modelObject);

            } catch (RollbackException ex) {

                throw new TransactionException();

            }
        }

        @Override
        public void delete(Integer id) {

            EntityManager em = sm.getCurrentSession();

            try {

                em.remove(em.find(modelType, id));

            } catch (RollbackException ex) {

                throw new TransactionException();

            }
        }
    }


