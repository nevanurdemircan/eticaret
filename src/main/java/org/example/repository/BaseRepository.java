package org.example.repository;

import org.example.entity.BaseEntity;

public interface BaseRepository<T extends BaseEntity, ID> {
    T save(T entity);
    T findById(ID id);
}
