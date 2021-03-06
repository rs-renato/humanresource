package br.com.hrs.core.common.operation;

import br.com.hrs.core.common.key.BaseKey;
import br.com.hrs.core.repository.pagination.Pagination;

import java.util.List;
import java.util.Optional;

public interface BaseOperation<E extends BaseKey<ID>, ID> {

    Optional<E> findById(ID id);

    E save(E entity);

    void update(E entity);

    List<E> findAll();

    List<E> findAll(Pagination pagination);

    void deleteById(ID id);

    boolean existsById(ID id);

    long count();
}