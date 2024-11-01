package com.example.bread.web.user.entiry;

import jakarta.persistence.*;
import lombok.*;

/**
 * 관리자 정보
 */
@Getter
@Entity
@Table(name = "user_info")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;      //아이디

    @Column(name = "password")
    private String password;    //비밀번호

    @Column(name = "name")
    private String name;        //이름

    @Column(name = "email")
    private String email;       //이메일

    @Column(name = "nick_name")
    private String nickName;    //닉네임

    @Column(name = "birth_date")
    private String birthDate;   //생년월일(yyyy-mm-dd)

    @Column(name = "phone_number")
    private String phoneNumber; //전화번호(010-0000-0000)

    @Column(name = "address")
    private String address;     //주소

    @Column(name = "role")
    private String role;        //권한 (기본은 guest)
}
