package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

import java.io.Serializable;

public class ForumColor
        extends BaseBean
        implements Serializable {
    public static final int invalidColor = -1;
    private static final long serialVersionUID = 7404141534147654272L;
    private String backgroundColor;
    private String dateColor;
    private String highLightColor;
    private String sectionTitleColor;
    private String subBackgroundColor;

    public String getBackgroundColor() {
        if (this.backgroundColor != null) {
            return "#" + this.backgroundColor;
        }
        return null;
    }

    public String getDateColor() {
        if (this.dateColor != null) {
            return "#" + this.dateColor;
        }
        return null;
    }

    public String getHighLightColor() {
        if (this.sectionTitleColor != null) {
            return "#" + this.highLightColor;
        }
        return null;
    }

    public String getSectionTitleColor() {
        if (this.sectionTitleColor != null) {
            return "#" + this.sectionTitleColor;
        }
        return null;
    }

    public String getSubBackgroundColor() {
        return "#" + this.subBackgroundColor;
    }

    public StateListDrawable getTabIndicatorColor(Activity paramActivity) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        Object localObject = paramActivity.getResources().getDrawable(2131165212);
        localStateListDrawable.addState(new int[]{16842919}, (Drawable) localObject);
        localObject = paramActivity.getResources().getDrawable(2131165212);
        localStateListDrawable.addState(new int[]{16842908}, (Drawable) localObject);
        localObject = new ColorDrawable(Color.parseColor(getSectionTitleColor()));
        localStateListDrawable.addState(new int[]{16842913}, (Drawable) localObject);
        paramActivity = paramActivity.getResources().getDrawable(2131165212);
        localStateListDrawable.addState(new int[0], paramActivity);
        return localStateListDrawable;
    }

    public void setBackgroundColor(String paramString) {
        this.backgroundColor = paramString;
    }

    public void setDateColor(String paramString) {
        this.dateColor = paramString;
    }

    public void setHighLightColor(String paramString) {
        this.highLightColor = paramString;
    }

    public void setSectionTitleColor(String paramString) {
        this.sectionTitleColor = paramString;
    }

    public void setSubBackgroundColor(String paramString) {
        this.subBackgroundColor = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ForumColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */