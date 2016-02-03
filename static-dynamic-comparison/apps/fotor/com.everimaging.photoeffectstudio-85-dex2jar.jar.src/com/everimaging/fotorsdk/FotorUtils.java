package com.everimaging.fotorsdk;

import android.content.Context;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;

import java.security.MessageDigest;

public class FotorUtils {
    private static final String TAG = FotorUtils.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);

    private static void appendHex(StringBuffer paramStringBuffer, byte paramByte) {
        paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramByte & 0xF));
    }

    public static String generateSessionId(Context paramContext) {
        paramContext = PackageManagerUtils.getApikey(paramContext);
        try {
            Object localObject = MessageDigest.getInstance("MD5");
            long l = System.currentTimeMillis();
            logger.c(new Object[]{"api key:" + paramContext + "|ms:" + l});
            ((MessageDigest) localObject).update((paramContext + String.valueOf(l)).getBytes("UTF-8"));
            localObject = toHex(((MessageDigest) localObject).digest());
            paramContext = (Context) localObject;
        } catch (Exception localException) {
            for (; ; ) {
                logger.e(new Object[]{"generation session id ocur error:" + localException.getMessage()});
            }
        }
        logger.c(new Object[]{"session id:" + paramContext});
        return paramContext;
    }

    public static String toHex(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return "";
        }
        StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
        int i = 0;
        while (i < paramArrayOfByte.length) {
            appendHex(localStringBuffer, paramArrayOfByte[i]);
            i += 1;
        }
        return localStringBuffer.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/FotorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */