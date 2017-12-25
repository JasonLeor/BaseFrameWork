package com.livenaked.model;

import com.fasterxml.jackson.databind.ser.Serializers;
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
@Table(name = "user_function")
public class PUserFunction extends Serializers.Base {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "function_id")
    private Long functionId;
}
