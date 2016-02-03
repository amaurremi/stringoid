package com.quoord.tapatalkpro.resourcefactory.backlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.quoord.tapatalkpro.resourcefactory.AbsColorRender;
import com.quoord.tapatalkpro.util.Prefs;

public class BackListItemBackDarkColorRender
        implements AbsColorRender {
    private int backColorResource = -1;
    private int clickColorResource = -1;
    private int defaultColorResource = -1;
    private int selectedColorResource = -1;

    public BackListItemBackDarkColorRender(Context paramContext) {
        initBackColorProduct(paramContext);
    }

    private void initBackColorProduct(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        int i = localSharedPreferences.getInt("ics_custom_colorstyle", 0);
        int j = localSharedPreferences.getInt("ics_custom_select_position", 0);
        setBackColor(paramContext.getResources().getColor(2131165533));
        setDefaultColor(paramContext.getResources().getColor(2131165533));
        if (j == 0) {
            setSelectedColor(paramContext.getResources().getColor(2131165472));
            setClickColor(paramContext.getResources().getColor(2131165472));
            return;
        }
        setSelectedColor(i);
        setClickColor(i);
    }

    public int getBackColor() {
        return this.backColorResource;
    }

    public int getClickedColor() {
        return this.clickColorResource;
    }

    public int getDefaultColor() {
        return this.defaultColorResource;
    }

    public int getSelectedColor() {
        return this.selectedColorResource;
    }

    void setBackColor(int paramInt) {
        this.backColorResource = paramInt;
    }

    void setClickColor(int paramInt) {
        this.clickColorResource = paramInt;
    }

    void setDefaultColor(int paramInt) {
        this.defaultColorResource = paramInt;
    }

    void setSelectedColor(int paramInt) {
        this.selectedColorResource = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/resourcefactory/backlist/BackListItemBackDarkColorRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */