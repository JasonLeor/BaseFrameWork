package com.livenaked.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "role_function")
public class PRoleFunction extends BaseModel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "function_id")
    private Long functionId;
}
