package com.aibisaseg.aidemo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="T_MESSAGES")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
