package com.livenaked.task.job;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseJob {
    private String name;
    private String groupName;

    public BaseJob(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }
}
