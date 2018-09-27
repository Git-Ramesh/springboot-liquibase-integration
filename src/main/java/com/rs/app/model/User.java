package com.rs.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "USERS")
@DynamicUpdate
@DynamicInsert
@ApiModel
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10, name = "ID")
    @Type(type = "int")
    @ApiModelProperty(name = "id" , dataType = "int")
    private Integer id;
    @Column(length = 25, name = "NAME")
    @Type(type = "string")
    @ApiModelProperty(name = "name" , dataType = "string")
    private String name;
    @Column(length = 35, name = "EMAIL")
    @Type(type = "string")
    @ApiModelProperty(name = "email" , dataType = "string")
    private String email;
    @JsonIgnore
    @Column(length = 15, name = "PASSWORD")
    @Type(type = "string")
    @ApiModelProperty(name = "password" , dataType = "string")
    private String password;
    @Transient
    @Column(length = 225, name = "COMMENT")
    @Type(type = "string")
    @ApiModelProperty(name = "comment" , dataType = "string")
    private String comment;
}
