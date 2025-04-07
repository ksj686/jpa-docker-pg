package jpabasic.reserve.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")	// 어떤 테이블과 매핑할지 설정해줌. name을 생략하면 클래스명과 동일한 이름으로 매핑해줌.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id // 식별자에 대응. 보통 PK에 매핑하는 컬럼에 붙임. 필드명과 같은 이름을 갖는 테이블 컬럼과 매핑됨
    private String email;
    private String name;

    @Column(name = "create_date") // 필드명과 컬럼명이 다르면 Column 어노테이션을 붙임
    private LocalDateTime createDate;

//    protected User() {
//    }

//    public User(String email, String name, LocalDateTime createDate) {
//        this.email = email;
//        this.name = name;
//        this.createDate = createDate;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public LocalDateTime getCreateDate() {
//        return createDate;
//    }

//    public void changeName(String newName) {
//        this.name = newName;
//    }
}