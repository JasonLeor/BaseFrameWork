package com.livenaked.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "course")
public class PCourse extends BaseModel {
    @Id
    @GeneratedValue
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "name")
    private String name;
    @Column(name = "picture")
    private String picture;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id")
    private PTeacher teacher;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "space_id")
    private PSpace space;
    @Column(name = "min")
    private Integer min;
    @Column(name = "max")
    private Integer max;
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Integer status;
    @Column(name = "is_valid")
    private Integer isValid;
    @Column(name = "is_display")
    private Integer isDisplay;
    @Column(name = "audit_status")
    private Integer auditStatus;
    @Column(name = "virtual_price")
    private BigDecimal virtualPrice;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
    private Collection<PCoursePicture> pictures;
}
