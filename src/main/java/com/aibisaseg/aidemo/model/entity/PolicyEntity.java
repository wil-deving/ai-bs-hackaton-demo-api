package com.aibisaseg.aidemo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="T_POLICY" )
public class PolicyEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @Column(name = "documentId")
    private String documentId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "plan")
    private String plan;

    @Column(name = "policyNo")
    private String policyNo;

    @Column(name = "pdfSource")
    private String pdfSource;


}
