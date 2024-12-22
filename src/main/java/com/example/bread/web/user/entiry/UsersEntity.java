package com.example.bread.web.user.entiry;

import com.example.bread.common.entity.TimeEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * 유저관리
 */
@Getter
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UsersEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false, length = 20)
    private String userId;      //아이디

    @Column(name = "password", nullable = false, length = 20)
    private String password;    //비밀번호

    @Column(name = "name", nullable = false, length = 20)
    private String name;        //이름

    @Column(name = "email", nullable = false, length = 50)
    private String email;       //이메일

    @Column(name = "nick_name", nullable = false, length = 20)
    private String nickName;    //닉네임

    @Column(name = "birth_date", nullable = false, length = 20)
    private String birthDate;   //생년월일(yyyy-mm-dd)

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber; //전화번호(010-0000-0000)

    @Column(name = "address", nullable = false, length = 200)
    private String address;     //주소

    @Column(name = "role", nullable = false, length = 20)
    private String role;        //권한 (기본은 guest)
}
