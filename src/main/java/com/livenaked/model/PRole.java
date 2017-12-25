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
@Table(name = "role")
public class PRole extends BaseModel {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "is_valid")
    private Integer isValid;

}
