package com.example.lemplayer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lemplayer.R;
import com.example.lemplayer.util.PhoneUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 23) {
            int checkCallPhonePermission2 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (checkCallPhonePermission2 != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);
                return;
            }
        }

        initListening();
    }

    private void initListening(){
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("title", "测试本地视频");
                intent.putExtra("url", PhoneUtil.getRootDir(MainActivity.this) + "/DCIM/Restored/Xperia_dogsea_FHD.mp4");
                startActivity(intent);
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("title", "测试网络视频");
                intent.putExtra("url", "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
                startActivity(intent);
            }
        });
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LiveBroadcastActivity.class);
                intent.putExtra("title", "测试RTSP协议直播源");
                intent.putExtra("url", "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov");
                startActivity(intent);
            }
        });
    }
}
