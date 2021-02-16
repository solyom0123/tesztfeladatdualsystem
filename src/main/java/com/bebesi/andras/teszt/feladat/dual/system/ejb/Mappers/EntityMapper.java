package com.bebesi.andras.teszt.feladat.dual.system.ejb.Mappers;

import java.util.List;

public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtos);

    List<D> toDto(List<E> dtos);

}
