package com.example.cardview;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by Administrator on 2017/11/7.
 */

public class App extends Application {
    private Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(this);
    }

    public static void initImageLoader(Context context) {
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/Image");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPoolSize(3)//线程池内加载的数量
                .threadPriority(100)
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheExtraOptions(100,100)
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCache(new UnlimitedDiskCache(file)).build();
        ImageLoader.getInstance().init(config);
    }
}
