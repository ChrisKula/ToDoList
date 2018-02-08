package com.christiankula.todolist.utils;


import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    private ListUtils() {

    }

    /**
     * Retrieves a {@link SparseArray} as a List. The order of the returned List is same as the SparseArray order
     *
     * @param sparseArray the SparseArray to turn into a List
     * @param <E>         Type of Object contained by the SparseArray
     */
    public static <E> List<E> asList(SparseArray<E> sparseArray) {
        if (sparseArray == null) {
            return null;
        }

        List<E> arrayList = new ArrayList<>(sparseArray.size());

        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.valueAt(i));
        }

        return arrayList;
    }
}
