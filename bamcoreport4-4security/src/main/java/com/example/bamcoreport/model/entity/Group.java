package com.example.bamcoreport.model.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "groupe")
@ToString
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 125)
    private String name;

    @Column(name = "parentpath")
    private String parentPath;

    @Column(name = "displayname")
    private String displayName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    @ManyToOne()
    @JoinColumn(name = "createdby", referencedColumnName = "id", updatable = false)
    private User createdBy;

    @CreationTimestamp
    @Column(name = "creationdate")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "lastupdate")
    private LocalDateTime lastUpdate;


}
