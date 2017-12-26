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
@Table(name = "owner")
public class POwner extends BaseModel {
    @Id
    @GeneratedValue
    @Column(name = "owner_id")
    private Long ownerId;
    @Column(name = "is_disabled")
    private Integer isDisabled;
    @Column(name = "is_valid")
    private Integer isValid;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private PUser user;
}
