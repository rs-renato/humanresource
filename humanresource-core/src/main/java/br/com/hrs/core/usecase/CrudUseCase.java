package br.com.hrs.core.usecase;

import br.com.hrs.core.common.key.BaseKey;
import br.com.hrs.core.common.operation.BaseOperation;

public interface CrudUseCase<E extends BaseKey<ID>, ID> extends BaseOperation<E, ID> {

}
