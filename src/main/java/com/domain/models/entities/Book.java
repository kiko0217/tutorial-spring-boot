package com.domain.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import lombok.Data;

@Entity
@Table(name="tbl_books")
@SQLDelete(sql = "UPDATE tbl_books SET deleted = true WHERE id=?")
// @Where(clause = "deleted=false")
@FilterDef(name = "deletedBookFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedBookFilter", condition = "deleted = :isDeleted")
public @Data class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private String title;
    @Column(length = 255, nullable = false)
    private String description;
    @Column(length = 12)
    private double price;

    private boolean deleted = Boolean.FALSE;
    
}
