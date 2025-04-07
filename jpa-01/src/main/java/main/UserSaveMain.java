package main;

import jakarta.persistence.*;
import jpabasic.reserve.domain.User;

import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("app_db");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = new User("user@user.com", "user", LocalDateTime.now());
            entityManager.persist(user); // persist 메소드 호출하면 파라미터가 전달한 객체가 DB에 저장됨
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}
