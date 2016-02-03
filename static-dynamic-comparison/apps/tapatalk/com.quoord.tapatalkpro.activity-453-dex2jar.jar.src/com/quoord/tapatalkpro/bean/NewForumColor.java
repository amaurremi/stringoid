package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

import java.io.Serializable;

public class NewForumColor
        extends BaseBean
        implements Serializable {
    private static final long serialVersionUID = 7404141534147654272L;
    private String color1;
    private String color2;
    private String color3;

    public String getHighLightColor() {
        if (this.color3 != null) {
            return "#" + this.color3;
        }
        return null;
    }

    public String getSectionTitleColor() {
        if (this.color1 != null) {
            return "#" + this.color1;
        }
        return null;
    }

    public StateListDrawable getTabIndicatorColor(Activity paramActivity) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        try {
            Object localObject = paramActivity.getResources().getDrawable(2131165212);
            localStateListDrawable.addState(new int[]{16842919}, (Drawable) localObject);
            localObject = paramActivity.getResources().getDrawable(2131165212);
            localStateListDrawable.addState(new int[]{16842908}, (Drawable) localObject);
            localObject = new ColorDrawable(Color.parseColor(getSectionTitleColor()));
            localStateListDrawable.addState(new int[]{16842913}, (Drawable) localObject);
            paramActivity = paramActivity.getResources().getDrawable(2131165212);
            localStateListDrawable.addState(new int[0], paramActivity);
            return localStateListDrawable;
        } catch (Exception paramActivity) {
            paramActivity.printStackTrace();
        }
        return localStateListDrawable;
    }

    public String getTextColor() {
        if (this.color2 != null) {
            return "#" + this.color2;
        }
        return null;
    }

    public void setColor1(String paramString) {
        this.color1 = paramString;
    }

    public void setColor2(String paramString) {
        this.color2 = paramString;
    }

    public void setColor3(String paramString) {
        this.color3 = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/NewForumColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */