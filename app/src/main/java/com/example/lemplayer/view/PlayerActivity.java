package com.example.lemplayer.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lemplayer.widget.LemCoverVideo;
import com.example.lemplayer.R;
import com.example.lemplayer.entry.SwitchVideoModel;
import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.model.VideoOptionModel;

import java.util.ArrayList;
import java.util.List;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayerActivity extends GSYBaseActivityDetail<LemCoverVideo> {

    private LemCoverVideo detail_player;
    private String mTitle;
    private String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mTitle = getIntent().getStringExtra("title");
        imgUrl = getIntent().getStringExtra("url");

        detail_player = findViewById(R.id.detail_player);
        //增加title
        detail_player.getTitleTextView().setVisibility(View.GONE);
        detail_player.getBackButton().setVisibility(View.GONE);

        List<SwitchVideoModel> list = new ArrayList<>();
        list.add(new SwitchVideoModel("标清", imgUrl));
        list.add(new SwitchVideoModel("高清", imgUrl));
        list.add(new SwitchVideoModel("超清", imgUrl));
        list.add(new SwitchVideoModel("蓝光", imgUrl));

        detail_player.setUp(list, false, "");
        detail_player.setOpenPreView(true);

        repairRebound();
        initVideoBuilderMode();
    }

    //修正 因为ijk的FFMPEG对关键帧问题导致的拖动视屏会弹回来
    private void repairRebound(){
        VideoOptionModel videoOptionModel = new VideoOptionModel(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "enable-accurate-seek", 1);
        List<VideoOptionModel> list = new ArrayList<>();
        list.add(videoOptionModel);
        GSYVideoManager.instance().setOptionModelList(list);
    }

    @Override
    public LemCoverVideo getGSYVideoPlayer() {
        return detail_player;
    }

    @Override
    public GSYVideoOptionBuilder getGSYVideoOptionBuilder() {
        //封面
        ImageView imageView = new ImageView(this);
        Glide.with(this).load(imgUrl).into(imageView);
        return new GSYVideoOptionBuilder()
                .setThumbImageView(imageView)
                .setUrl(imgUrl)
                .setCacheWithPlay(true)
                .setVideoTitle(mTitle)
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setSeekRatio(1);
    }

    @Override
    public void clickForFullScreen() {

    }

    @Override
    public boolean getDetailOrientationRotateAuto() {
        return true;
    }
}
