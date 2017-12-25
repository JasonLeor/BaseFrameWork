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
@Table(name = "user_role")
public class PUserRole extends BaseModel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private PRole role;
    @Column(name = "is_valid")
    private Integer isValid;
}
