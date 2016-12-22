package org.nozzle.dao;

import org.nozzle.domain.DomainObject;

import javax.validation.constraints.NotNull;

public interface AbstractDao<T extends DomainObject> {

    void save(@NotNull T object);

    void update(@NotNull T object);

    void delete(@NotNull T object);

}
