package com.quoord.tools;

import android.app.Activity;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;

public class IgnoreBlurTool {
    private static String capitalize(String paramString) {
        String str;
        if ((paramString == null) || (paramString.length() == 0)) {
            str = "";
        }
        char c;
        do {
            return str;
            c = paramString.charAt(0);
            str = paramString;
        } while (Character.isUpperCase(c));
        return Character.toUpperCase(c) + paramString.substring(1);
    }

    public static String getDeviceName() {
        String str1 = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str1)) {
            return capitalize(str2);
        }
        return capitalize(str1) + " " + str2;
    }

    public static boolean needHidenBlur(Activity paramActivity) {
        paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
        int i = paramActivity.getWidth();
        int j = paramActivity.getHeight();
        if ((i == 540) && (j == 888)) {
        }
        while ((Build.VERSION.SDK_INT < 18) || (getDeviceName().contains("ONEPLUS"))) {
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/IgnoreBlurTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */