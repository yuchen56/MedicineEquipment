package lib.com.hxin.utils;

import android.util.Log;

import java.io.File;

import lib.com.hxin.application.BaseApplication;

/**
 * Created by YongChen.Yu on 2017/2/20.
 * 文件工具类
 */

public class FileUtil {

    private static String DirectoryName = "XXXX";
    /**
     * @return  创建缓存目录
     */
    public static File getcacheDirectory()
    {
        File file = new File(BaseApplication.getInstance().getApplicationContext().getExternalCacheDir(), getDirectoryName());
        if(!file.exists())
        {
            boolean b = file.mkdirs();
            Log.e("file", "文件不存在 创建文件"+b);
        }else{
            Log.e("file", "文件存在");
        }
        return file;
    }

    public static String getDirectoryName() {
        return DirectoryName;
    }

    /**
     * 设置缓存文件夹的名称
     * @param directoryName
     */
    public static void setDirectoryName(String directoryName) {
        DirectoryName = directoryName;
    }
}

