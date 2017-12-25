package com.livenaked.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "function")
public class PFunction extends BaseModel {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "function_name")
    private String functionName;
    @Column(name = "route")
    private String route;
    @Column(name = "level")
    private String level;
    @Column(name = "status")
    private Integer status;
    @Column(name = "is_valid")
    private Integer isValid;
}
