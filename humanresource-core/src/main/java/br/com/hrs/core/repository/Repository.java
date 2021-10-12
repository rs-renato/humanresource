package br.com.hrs.core.repository;

import br.com.hrs.core.common.key.BaseKey;
import br.com.hrs.core.common.operation.BaseOperation;

public interface Repository<E extends BaseKey<ID>, ID> extends BaseOperation<E, ID> {
}