package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class NoTopicView
        extends BaseBean
        implements Serializable {
    public View getItemView(Activity paramActivity) {
        return paramActivity.getLayoutInflater().inflate(2130903295, null);
    }

    public View getItemView(Activity paramActivity, String paramString) {
        paramActivity = paramActivity.getLayoutInflater().inflate(2130903295, null);
        ((TextView) paramActivity.findViewById(2131230763)).setText(paramString);
        return paramActivity;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/NoTopicView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */