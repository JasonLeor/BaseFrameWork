package com.livenaked.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "xml")
public class SimpleEntity {
    private String data;

    public SimpleEntity(String data) {
        this.data = data;
    }
}
