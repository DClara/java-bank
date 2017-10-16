package org.academiadecodigo.javabank.persistence.jpa;

import org.academiadecodigo.javabank.persistence.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

// responsible for managing the Session lifecycle
public class JpaSessionManager extends SessionManager {

        private EntityManager em; // the persistence context

        public JpaSessionManager (EntityManagerFactory emf) {
            super (emf);
        }

        @Override
        public void startSession() {

            if (em == null) {
                em = emf.createEntityManager();
            }
        }

        @Override
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
}

