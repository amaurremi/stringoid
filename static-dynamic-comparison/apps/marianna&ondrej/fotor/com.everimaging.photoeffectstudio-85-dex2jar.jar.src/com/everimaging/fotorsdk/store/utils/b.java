package com.everimaging.fotorsdk.store.utils;

import android.content.Context;
import com.everimaging.fotorsdk.utils.FotorIOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class b {
    public static boolean a(Context paramContext, String paramString1, String paramString2, byte[] paramArrayOfByte) {
        try {
            paramContext = paramContext.getDir(paramString1, 0).getAbsolutePath();
            paramContext = new FileOutputStream(paramContext + File.separator + paramString2);
            paramContext.write(paramArrayOfByte);
            FotorIOUtils.closeSilently(paramContext);
            return true;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
        return false;
    }

    public static byte[] a(Context paramContext, String paramString1, String paramString2) {
        try {
            paramContext = paramContext.getDir(paramString1, 0).getAbsolutePath();
            paramString1 = new FileInputStream(paramContext + File.separator + paramString2);
            paramString2 = new ByteArrayOutputStream();
            paramContext = new byte['Ѐ'];
            for (; ; ) {
                int i = paramString1.read(paramContext);
                if (i == -1) {
                    break;
                }
                paramString2.write(paramContext, 0, i);
            }
            paramString1.printStackTrace();
        } catch (Exception paramString1) {
            paramContext = null;
        }
        for (; ; ) {
            return paramContext;
            paramContext = paramString2.toByteArray();
            try {
                FotorIOUtils.closeSilently(paramString1);
                FotorIOUtils.closeSilently(paramString2);
                return paramContext;
            } catch (Exception paramString1) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */