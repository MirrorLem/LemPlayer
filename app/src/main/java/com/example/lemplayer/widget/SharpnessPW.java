package com.example.lemplayer.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.lemplayer.R;
import com.example.lemplayer.adapter.CommonAdapter;
import com.example.lemplayer.adapter.OnItemClickListener;
import com.example.lemplayer.adapter.ViewHolder;
import com.example.lemplayer.entry.SwitchVideoModel;

import java.util.List;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SharpnessPW extends PopupWindow  {

    RecyclerView recycler_view;

    private View mMenuView;
    private CommonAdapter adapter;
    private List<SwitchVideoModel> mUrls;
    private ICallback callback;

    public SharpnessPW(Context context, List<SwitchVideoModel> urls, ICallback callback) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.popupwindow_sharpness, null);
        this.setContentView(mMenuView);
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setBackgroundDrawable(new ColorDrawable(0));
        this.setAnimationStyle(R.style.popWindow_animation);

        mUrls = urls;
        this.callback = callback;
        recycler_view = mMenuView.findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(context));
        recycler_view.setItemAnimator(new DefaultItemAnimator());

        initData(context);
    }



    private void initData(Context context){
        adapter = new CommonAdapter<SwitchVideoModel>(context, R.layout.switch_video_dialog_item, mUrls) {
            @Override
            public void convert(ViewHolder holder, SwitchVideoModel switchVideoModel) {
                holder.setText(R.id.tv, switchVideoModel.getName());
            }
        };
        adapter.setOnItemClickListener(new OnItemClickListener<SwitchVideoModel>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, SwitchVideoModel switchVideoModel, int position) {
                callback.getVideoType(switchVideoModel, position);
                dismiss();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, SwitchVideoModel switchVideoModel, int position) {
                return false;
            }
        });
        recycler_view.setAdapter(adapter);
    }

    public interface ICallback {
        void getVideoType(SwitchVideoModel switchVideoModel, int position);
    }

}
