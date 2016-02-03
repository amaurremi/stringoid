package com.wbtech.ums.dao;

import android.content.Context;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.wbtech.ums.common.NetworkUitlity;
import com.wbtech.ums.common.UmsConstants;
import com.wbtech.ums.objects.MyMessage;

import java.io.File;
import java.io.FileInputStream;

public class GetInfoFromFile
        extends Thread {
    public static Context context;

    public GetInfoFromFile(Context paramContext) {
        context = paramContext;
    }

    public void run() {
        for (; ; ) {
            StringBuffer localStringBuffer;
            byte[] arrayOfByte;
            int i;
            try {
                Object localObject = new File(AppCacheManager.getBaseCacheDir(context) + "mobclick_agent_cached_" + context.getPackageName());
                if (!((File) localObject).exists()) {
                    return;
                }
                localObject = new FileInputStream((File) localObject);
                localStringBuffer = new StringBuffer();
                arrayOfByte = new byte['က'];
                i = ((FileInputStream) localObject).read(arrayOfByte);
                if (i == -1) {
                    if (!NetworkUitlity.post(UmsConstants.preUrl + "/ums/uploadLog", localStringBuffer.toString()).isFlag()) {
                        break;
                    }
                    new File(AppCacheManager.getBaseCacheDir(context) + "mobclick_agent_cached_" + context.getPackageName()).delete();
                    return;
                }
            } catch (Exception localException) {
                localException.printStackTrace();
                return;
            }
            localStringBuffer.append(new String(arrayOfByte, 0, i));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/dao/GetInfoFromFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */