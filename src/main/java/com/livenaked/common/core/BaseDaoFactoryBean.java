package com.livenaked.common.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 自定义工厂 bean
 *
 * @param <R>
 * @param <ID>
 */
public class BaseDaoFactoryBean<R extends JpaRepository<S, ID>, S, ID extends Serializable>
        extends JpaRepositoryFactoryBean<R, S, ID> {

    public BaseDaoFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }


    @SuppressWarnings("rawtypes")
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new BaseDaoFactory(entityManager);
    }


}
