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
@Table(name = "course_picture")
public class PCoursePicture extends BaseModel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private PCourse course;
    @Column(name = "url")
    private String url;
}
