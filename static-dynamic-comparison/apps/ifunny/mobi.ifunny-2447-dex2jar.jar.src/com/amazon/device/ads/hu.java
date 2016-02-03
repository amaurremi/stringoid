package com.amazon.device.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.WindowManager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class hu {
    private static final String a = hu.class.getSimpleName();
    private static int[][] b = {{1, 0, 9, 8}, {0, 9, 8, 1}};

    public static int a() {
        int j = 0;
        Context localContext = dn.i().h();
        int k = cf.a(((WindowManager) localContext.getSystemService("window")).getDefaultDisplay());
        int i = localContext.getResources().getConfiguration().orientation;
        if (i == 1) {
            if ((k == 0) || (k == 2)) {
                i = 1;
                if (i == 0) {
                    break label105;
                }
            }
        }
        label105:
        for (i = j; ; i = 1) {
            return b[i][k];
            i = 0;
            break;
            if (i == 2) {
                if ((k == 1) || (k == 3)) {
                    i = 1;
                    break;
                }
                i = 0;
                break;
            }
            i = 1;
            break;
        }
    }

    public static final long a(long paramLong) {
        return paramLong / 1000000L;
    }

    public static String a(String paramString) {
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

    public static boolean a(int paramInt) {
        return Build.VERSION.SDK_INT >= paramInt;
    }

    public static final long b(long paramLong) {
        return 1000000000L * paramLong;
    }

    public static final String b() {
        return "DISABLED_APP";
    }

    public static final String b(String paramString) {
        if (paramString == null) {
            return null;
        }
        try {
            String str = URLEncoder.encode(paramString, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
            return str;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            dv.a(a, "getURLEncodedString threw: %s", new Object[]{localUnsupportedEncodingException});
        }
        return paramString;
    }

    public static final boolean c(String paramString) {
        return (paramString == null) || (paramString.equals(""));
    }

    public static final boolean d(String paramString) {
        return (c(paramString)) || (paramString.trim().equals(""));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */