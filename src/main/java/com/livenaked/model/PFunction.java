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
@Table(name = "function")
public class PFunction extends BaseModel {
    @Id
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private PFunction parent;
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
