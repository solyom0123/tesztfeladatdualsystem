package com.bebesi.andras.teszt.feladat.dual.system.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRequest<T> {
   private List<T> list;
}
