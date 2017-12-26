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
@Table(name = "user_follow")
public class PUserFollow extends BaseModel {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "is_cancel")
    private Integer isCancel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "focus_user_id")
    private PUser focusUser;
}
