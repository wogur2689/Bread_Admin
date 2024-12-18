package com.example.bread.web.user.entiry;

import com.example.bread.common.entity.TimeEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * 권한관리
 */
@Getter
@Entity
@Table(name = "role")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String role;        //권한 (기본은 guest)

    @Column(name = "description")
    private String description; //권한 설명
}
