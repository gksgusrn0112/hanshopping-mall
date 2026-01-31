package com.hanshop.hanshopping_mall.domain;  // 👈 여기가 네 프로젝트 경로랑 맞아야 해!

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor // 기본 생성자 (JPA 필수)
@Table(name = "users") // DB 테이블 이름을 'users'로 지정
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true) // 소셜 로그인은 비번 없음
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @CreationTimestamp // 가입 시간 자동 저장
    private LocalDateTime createdAt;

    // 생성자
    public User(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }
}