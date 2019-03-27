package com.example.lemplayer.adapter;

/**
 * Created by z4414 on 2016/8/12.
 */
public interface MultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}
