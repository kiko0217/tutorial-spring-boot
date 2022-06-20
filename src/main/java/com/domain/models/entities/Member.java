package com.domain.models.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import com.domain.converter.StringAttributeConverter;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_member")
@Data
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 5, name = "number", nullable = false, unique = true)
    private String memberNumber;
    @Convert(converter = StringAttributeConverter.class)
    @Column(length = 150, name = "name", nullable = false)
    private String memberName;
    @ColumnTransformer(
        read = "AES_DECRYPT(UNHEX(email), 'this-is-test-key')",
        write = "HEX(AES_ENCRYPT(?, 'this-is-test-key'))"
    )
    @Column(length = 150, name = "email", nullable = false, unique = true)
    private String memberEmail;
    @Column(length = 100, name = "password",  nullable = false)
    private String memberPassword;

}
