package com.example.quote.service.common;

import com.example.quote.exception.EntityNotDeleteException;
import com.example.quote.exception.EntityNotSaveOrUpdateException;
import com.example.quote.model.common.AbstractEntity;
import com.example.quote.repository.common.AbstractRepository;
import com.example.quote.utils.PageSetting;
import com.example.quote.utils.Utils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractService<T extends AbstractEntity, R extends AbstractRepository<T>> {
    protected final R repository;

    public T getEntityById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Entity with identifier %s does not exist", id)));
    }

    public Page<T> getAllEntities(PageSetting pageSetting) {
        return repository.findAll(pageSetting.getPageable());
    }

    public T createEntity(T entity) {
        try {
            return repository.save(entity);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new EntityNotSaveOrUpdateException("Entity was not saved or updated");
        }
    }

    public void deleteEntityById(Long id) {
        try {
            repository.delete(getEntityById(id));
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new EntityNotDeleteException("Entity was not deleted");
        }
    }

    public T updateEntityById(Long id, T entity, String... ignoredFields) {
        T entityUpdate = getEntityById(id);
        Utils.copyNonNullProperties(entity, entityUpdate, ignoredFields);
        return createEntity(entityUpdate);
    }
}