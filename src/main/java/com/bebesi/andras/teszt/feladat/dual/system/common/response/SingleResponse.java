package com.bebesi.andras.teszt.feladat.dual.system.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleResponse<T> {
   private T item;
}
