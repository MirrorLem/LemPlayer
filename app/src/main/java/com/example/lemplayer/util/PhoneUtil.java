package com.example.lemplayer.util;

import android.content.Context;
import android.os.Environment;

public class PhoneUtil {
    /**
     * 获取根目录(应用cache 或者 SD卡)
     * <br>
     * <br>
     * 优先获取SD卡根目录[/storage/sdcard0]
     * <br>
     * <br>
     * 应用缓存目录[/data/data/应用包名/cache]
     * <br>
     *
     * @param context 上下文
     * @return
     */
    public static String getRootDir(Context context)
    {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            // 优先获取SD卡根目录[/storage/sdcard0]
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        } else
        {
            // 应用缓存目录[/data/data/应用包名/cache]
            return context.getCacheDir().getAbsolutePath();
        }
    }
}
