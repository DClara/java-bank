package org.academiadecodigo.javabank.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

// responsible for managing the Session lifecycle
public class JpaSessionManager {

        protected EntityManagerFactory emf;
        protected EntityManager em;

        public JpaSessionManager (EntityManagerFactory emf) {
            this.emf = emf;
        }

        public void startSession() {

            if (em == null) {
                em = emf.createEntityManager();
            }
        }

        public void stopSession() {

            if (em != null) {
                em.close();
            }

            em = null;
        }

        public EntityManager getCurrentSession() {
            startSession();
            return em;
        }

        public void setEm(EntityManager em) {
            this.em = em;
        }
}

