package br.com.hrs.core.common.key;

import java.io.Serializable;

public interface BaseKey<ID> extends Serializable {

    ID getId();
}
