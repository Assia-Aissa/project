package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String email;
   ;
    @Column(nullable = false)
    private String password;

    private String roles;
   /* @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name ="userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<Roles> roles;
*/

}
