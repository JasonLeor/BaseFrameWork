package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDaoIntf extends BaseDao<PCourse, Long> {
    @Query(value = "select course from PCourse course where course.isValid=1 and course.id=?1")
    PCourse findCourse(Long courseId);
}
