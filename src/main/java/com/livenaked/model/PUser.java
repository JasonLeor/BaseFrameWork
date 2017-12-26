package com.livenaked.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.AUTO)
    @GenericGenerator(strategy = "uuid", name = "system-uuid")
    @Column(name = "user_id")
    private String userId;
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
    @Column(name = "secret_key")
    private String secretKey;
    @Column(name = "is_valid")
    private Integer isValid;
    @Column(name = "is_disabled")
    private Integer isDisabled;
    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    public PUser(String userId) {
        this.userId = userId;
    }

    public PUser() {
    }
}
