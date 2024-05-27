package com.example.bread.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 회원 정보
 */
@Getter
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;      //아이디

    @Column(name = "pwd")
    private String pwd;    //비밀번호

    @Column(name = "name")
    private String name;        //이름

    @Column(name = "age")
    private String age;       //나이

    @Column(name = "phone")
    private String phone; //전화번호(010-0000-0000)

    @Column(name = "address")
    private String address;     //주소
}
