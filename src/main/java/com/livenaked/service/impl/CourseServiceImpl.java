package com.livenaked.service.impl;

import com.livenaked.dao.intf.CourseDaoIntf;
import com.livenaked.model.PCourse;
import com.livenaked.service.intf.CourseServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseServiceIntf {
    @Autowired
    private CourseDaoIntf courseDaoIntf;

    @Override
    public PCourse findCourse(Long courseId) {
        return courseDaoIntf.findCourse(courseId);
    }
}
