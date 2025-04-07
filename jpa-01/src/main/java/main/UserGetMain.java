package main;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.reserve.domain.User;

public class UserGetMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app_db");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, "user@user.com");	// 첫번째 인자로 class, 두번째 인자로 PK의 값 전달
            // 만약 첫번째 인자로 @Entity로 지정하지 않은 클래스를 전달하거나, 식별자 타입과 같지 않은 타입을 전달하면 Exception 발생! 
            if (user == null) {
                System.out.println("User 없음");
            } else {
                System.out.printf("User 있음: email=%s, name=%s, createDate=%s\n",
                        user.getEmail(), user.getName(), user.getCreateDate());
            }
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
