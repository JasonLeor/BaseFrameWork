package com.livenaked.common.core;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * core Entity 工厂
 */
public class BaseDaoFactory<T, ID extends Serializable> extends JpaRepositoryFactory {
    public BaseDaoFactory(EntityManager entityManager) {
        super(entityManager);
    }

    @SuppressWarnings({"rawtypes", "unchecked", "hiding"})
    protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata,
                                                                                         EntityManager entityManager) {
        return new BaseDaoImpl(metadata.getDomainType(), entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return BaseDao.class;
    }
}
