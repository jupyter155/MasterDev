package com.example.api_springboot.model;

import javax.persistence.Entity;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "password", length = 255)
    private String password;
}

