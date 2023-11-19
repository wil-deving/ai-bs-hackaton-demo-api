package com.aibisaseg.aidemo.model.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "T_USUARIOS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String cucuToken;



}
