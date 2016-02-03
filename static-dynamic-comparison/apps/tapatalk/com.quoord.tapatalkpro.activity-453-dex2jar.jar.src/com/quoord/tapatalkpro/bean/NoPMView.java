package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import java.io.Serializable;

public class NoPMView
        extends BaseBean
        implements Serializable {
    public View getItemView(Activity paramActivity) {
        return paramActivity.getLayoutInflater().inflate(2130903293, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/NoPMView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */