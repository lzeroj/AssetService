package com.lyj.assetService.user;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userinfo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userid;
    @Column
    private String password;
    @Column
    private String kornm;
    @Column
    private String engnm;
    @Column
    private String email;
    @Column
    private String ssn;
    @Column
    private String birthday;
    @Column
    private String telno;
}
