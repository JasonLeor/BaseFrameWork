package com.livenaked.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "user")
public class PUser extends BaseModel implements Serializable {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "phone")
    private String phone;
    @Column(name = "lang")
    private String lang;
    @Column(name = "refer_code")
    private String referCode;
    @Column(name = "is_valid")
    private Integer isValid;
    @Column(name = "is_disabled")
    private Integer isDisabled;
    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

}
