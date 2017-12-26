package com.livenaked.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "teacher")
public class PTeacher extends BaseModel {
    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(name = "background_picture")
    private String backgroundPicture;
    @Column(name = "description")
    private String description;
    @Column(name = "basic_rate")
    private BigDecimal basicRate;
    @Column(name = "refer_rate")
    private BigDecimal referRate;
    @Column(name = "is_valid")
    private Integer isValid;
    @Column(name = "is_disabled")
    private Integer isDisabled;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private PUser user;
}
