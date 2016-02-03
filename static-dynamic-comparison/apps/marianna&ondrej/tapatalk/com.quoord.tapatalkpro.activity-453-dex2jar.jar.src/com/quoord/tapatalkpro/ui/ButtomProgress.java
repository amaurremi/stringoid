package com.quoord.tapatalkpro.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class ButtomProgress {
    public static LinearLayout get(Activity paramActivity) {
        LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903080, null);
        ((TextView) localLinearLayout.findViewById(2131230892)).setTextColor(paramActivity.getResources().getColor(ThemeUtil.getTextColor(paramActivity)));
        return localLinearLayout;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ButtomProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */