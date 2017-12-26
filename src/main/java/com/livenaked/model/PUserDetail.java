package com.livenaked.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "user_detail")
public class PUserDetail extends BaseModel implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.AUTO)
    @GenericGenerator(strategy = "uuid", name = "system-uuid")
    @Column(name = "user_id")
    private String userId;
    @Column(name = "city_id")
    private Long cityId;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "purchase_amount")
    private BigDecimal purchaseAmount;
    @Column(name = "current_balance")
    private BigDecimal currentBalance;
    @Column(name = "freeze_balance")
    private BigDecimal freezeBalance;
}
