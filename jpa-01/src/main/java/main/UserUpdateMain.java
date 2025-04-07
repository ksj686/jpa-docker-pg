package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.reserve.domain.User;

public class UserUpdateMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app_db");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, "user@user.com");	// 바꿀 데이터를 먼저 조회한다.
            if (user == null) {
                System.out.println("User 없음");
            } else {
                String newName = "이름" + (System.currentTimeMillis() % 100);
                user.setName(newName);	// 조회한 객체에서 필드를 변경해줌. 트랜젝션 범위 안에서 객체를 변경하면 자동으로 반영함.
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
