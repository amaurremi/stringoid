package com.amazon.device.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.WindowManager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Utils {
    private static final String DISABLED_APP_SERVER_MESSAGE = "DISABLED_APP";
    private static final String LOG_TAG = Utils.class.getSimpleName();
    private static int[][] rotationArray = {{1, 0, 9, 8}, {0, 9, 8, 1}};

    public static final long convertToMillisecondsFromNanoseconds(long paramLong) {
        return paramLong / 1000000L;
    }

    public static final long convertToNsFromS(long paramLong) {
        return 1000000000L * paramLong;
    }

    public static int determineCanonicalScreenOrientation() {
        Context localContext = InternalAdRegistration.getInstance().getApplicationContext();
        int j = AndroidTargetUtils.getOrientation(((WindowManager) localContext.getSystemService("window")).getDefaultDisplay());
        int i = localContext.getResources().getConfiguration().orientation;
        if (i == 1) {
            if ((j == 0) || (j == 2)) {
                i = 1;
                if (i == 0) {
                    break label103;
                }
            }
        }
        label103:
        for (i = 0; ; i = 1) {
            return rotationArray[i][j];
            i = 0;
            break;
            if (i == 2) {
                if ((j == 1) || (j == 3)) {
                }
                for (i = 1; ; i = 0) {
                    break;
                }
            }
            i = 1;
            break;
        }
    }

    public static final String getDisabledAppServerMessage() {
        return "DISABLED_APP";
    }

    public static final String getURLDecodedString(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            String str = URLDecoder.decode(paramString, "UTF-8");
            return str;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            Log.d(LOG_TAG, "getURLDecodedString threw: %s", new Object[]{localUnsupportedEncodingException});
        }
        return paramString;
    }

    public static final String getURLEncodedString(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            String str = URLEncoder.encode(paramString, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
            return str;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            Log.d(LOG_TAG, "getURLEncodedString threw: %s", new Object[]{localUnsupportedEncodingException});
        }
        return paramString;
    }

    public static boolean isAtLeastAndroidAPI(int paramInt) {
        return Build.VERSION.SDK_INT >= paramInt;
    }

    public static final boolean isNullOrEmpty(String paramString) {
        return (paramString == null) || (paramString.equals(""));
    }

    public static final boolean isNullOrWhiteSpace(String paramString) {
        return (isNullOrEmpty(paramString)) || (paramString.trim().equals(""));
    }

    public static int parseInt(String paramString, int paramInt) {
        try {
            int i = Integer.parseInt(paramString);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return paramInt;
    }

    public static String sha1(String paramString) {
        try {
            Object localObject = MessageDigest.getInstance("SHA-1");
            ((MessageDigest) localObject).update(paramString.getBytes());
            paramString = ((MessageDigest) localObject).digest();
            localObject = new StringBuilder();
            int i = 0;
            while (i < paramString.length) {
                ((StringBuilder) localObject).append(Integer.toHexString(paramString[i] & 0xFF | 0x100).substring(1));
                i += 1;
            }
            paramString = ((StringBuilder) localObject).toString();
            return paramString;
        } catch (NoSuchAlgorithmException paramString) {
        }
        return "";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */