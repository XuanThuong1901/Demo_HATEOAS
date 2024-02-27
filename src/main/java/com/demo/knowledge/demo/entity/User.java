package com.demo.knowledge.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends RepresentationModel<User> {
    @Id
    @Column(name = "id_user")
    private int idUser;

    @MapsId
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user", referencedColumnName = "id_student")
    private Student student;

   @Column(name = "user_name", unique = true, nullable = false)
   private String userName;

   @Column(name = "password", nullable = false)
    private String password;
}
