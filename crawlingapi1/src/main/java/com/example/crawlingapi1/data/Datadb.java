package com.example.crawlingapi1.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="datadb")
public class Datadb implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String info;
    @Column(nullable = false)
    private String classification;
    @Column(nullable = false)
    private String classificationInfo;
    @Column(nullable = false)
    private String provider;
    @Column(nullable = false)
    private String providerInfo;
    @Column(nullable = false)
    private String providerdep;
    @Column(nullable = false)
    private String enrollment;
    @Column(nullable = false)
    private String enrollmentInfo;
    @Column(nullable = false)
    private String modify;
    @Column(nullable = false)
    private String modifyInfo;
    @Column(nullable = false)
    private String url;

    private Datadb(){

    }

}
