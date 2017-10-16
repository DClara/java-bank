package org.academiadecodigo.javabank.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

// responsible for managing the Session lifecycle
public class JpaSessionManager {

        private EntityManagerFactory emf;
        private EntityManager currentSession;


    public JpaSessionManager (EntityManagerFactory emf) {
        this.emf = emf;
        }

        public void startSession() {

            if (currentSession == null) {
                currentSession = emf.createEntityManager();
            }
        }

        public void stopSession() {

            if (currentSession != null) {
                currentSession.close();
            }

            currentSession = null;
        }

        public void setEm(EntityManager em) {
            this.currentSession = em;
        }


        public EntityManager getCurrentSession() {
                startSession();
                return currentSession;
            }
}

