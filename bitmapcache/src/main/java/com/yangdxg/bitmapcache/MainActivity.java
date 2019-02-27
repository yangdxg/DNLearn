package com.yangdxg.bitmapcache;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;

import java.io.File;
import java.io.IOException;

import static android.os.Environment.isExternalStorageRemovable;

public class MainActivity extends AppCompatActivity {

    private LruCache<String, Bitmap> mLruCache;
    private static final long DISK_CACHE_SIZE = 1024 * 1024 * 50;
    private static final String DISK_CACHE_SUBDIR = "thumbnails";
    private DiskLruCache mDiskLruCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取虚拟机提供的最大内存，超出报OOM
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //使用1/8内存作内存缓存
        int cacheSize = maxMemory / 8;
        mLruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //计算缓存容量的大小
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
        //添加缓存
        //mLruCache.put();
        //获取缓存
        //mLruCache.get();
        //删除缓存
        //mLruCache.remove();

        File diskCacheDir = getDiskCacheDir(this, DISK_CACHE_SUBDIR);
        if (!diskCacheDir.exists()){
            diskCacheDir.mkdirs();
        }
        try {
            mDiskLruCache = DiskLruCache.open(diskCacheDir, 1, 1, DISK_CACHE_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //缓存添加由Editer操作
//        mDiskLruCache.edit("")
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        int inSampleSize = calulateInSampleSize(options, reqWidth, reqHeight);
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(res, resId, options);
        return bitmap;
    }

    public static int calulateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int outHeight = options.outHeight;
        int outWidth = options.outWidth;
        int inSampleSize = 1;
        if (outHeight > reqHeight || outWidth > reqWidth) {
            int halfHeight = outHeight / 2;
            int halfWidth = outWidth / 2;
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public File getDiskCacheDir(Context context, String uniqueName){
        //优先使用外缓存路径，否则使用内缓存路径
        final String cachePath =
                Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
                        !isExternalStorageRemovable() ?getExternalCacheDir().getPath():context.getCacheDir().getPath();

        return new File(cachePath + File.separator + uniqueName);  }

    /**
     * BitmapFactory加载图片的四类方法
     * 1。decodeFile 文件
     * 2。decodeResource 资源
     * 3。decodeStream输入流
     * 4。decodeByteArray字节数组
     *
     * 通过BitmapFactory.Options来缩放图片，使用inSampleSize（采样率）参数
     * inSampleSize=1 原始大小，inSampleSize=2宽高均为原始图片的1/2，像素为1/4，inSampleSize为2的指数
     * 如果传递参数不是2的指数，向下取整选择最接近2的指数替代
     *
     * 获取采样率
     * 1。BitmapFactory.Options的inJustDecodeBounds设置为true并加载图片（只会得到图片的原始宽高，不会真正加载图片）
     * 2。取出原始宽高信息outWidth，outHeight
     * 3。根据规则计算采样率大小
     * 4。inJustDecodeBounds设置为false并重新加载
     *
     * 程序先从内存中获取，再从存储设备中获取，最后从网络中获取
     *
     * Lru缓存
     * LruCache内存缓存（一个缓存类）：泛型类采用LinkedHashMap以强引用方式存储，提供get和put方法，线程安全的
     * DiskLruCache存储设备缓存
     *
     * 强引用：直接的对象引用
     * 软引用：当一个对象只有软引用存在时，内存不足时此对象会被gc回收
     * 若引用：此对象会随时被gc回收
     */
}
