package com.bebesi.andras.teszt.feladat.dual.system.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleRequest<T> {
   private T item;
}
