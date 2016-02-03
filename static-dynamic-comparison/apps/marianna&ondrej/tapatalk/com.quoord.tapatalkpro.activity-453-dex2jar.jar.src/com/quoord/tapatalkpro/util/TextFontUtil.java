package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

public class TextFontUtil {
    public static void setRobotoFont(TextView paramTextView, Activity paramActivity) {
        paramTextView.setTypeface(Typeface.createFromAsset(paramActivity.getAssets(), "font/Roboto_Condensed.ttf"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/TextFontUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */