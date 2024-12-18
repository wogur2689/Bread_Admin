package com.example.bread.web.user.entiry;

import jakarta.persistence.*;
import lombok.*;

/**
 * 사용자 권한관리
 */
@Getter
@Entity
@Table(name = "user_role")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;      //아이디

    @Column(name = "role")
    private String role;        //권한 (기본은 guest)
}
