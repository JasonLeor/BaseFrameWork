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
@Table(name = "space")
public class PSpace extends BaseModel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private POwner owner;
    @Column(name = "location_id")
    private Long locationId;
    @Column(name = "city_id")
    private Long cityId;
    @Column(name = "name")
    private String name;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "address")
    private String address;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "picture")
    private String picture;
    @Column(name = "space_type")
    private Integer spaceType;
    @Column(name = "resource_id")
    private String resourceId;
    @Column(name = "area")
    private BigDecimal area;
    @Column(name = "description")
    private String description;
    @Column(name = "is_valid")
    private Integer isValid;
}
