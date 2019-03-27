package com.example.lemplayer.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by z4414 on 2016/6/26.
 */
public interface OnItemClickListener<T>
{
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}
