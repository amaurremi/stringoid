package com.quoord.tapatalkpro.resourcefactory.backlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import com.quoord.tapatalkpro.resourcefactory.AbsColorRender;
import com.quoord.tapatalkpro.util.Prefs;

public class BackListItemRebrandCharacterRender
        implements AbsColorRender {
    private int backColorResource = -1;
    private int clickColorResource = -1;
    private int defaultColorResource = -1;
    private int selectedColorResource = -1;

    public BackListItemRebrandCharacterRender(Context paramContext) {
        initCharacterColorProduct(paramContext);
    }

    private void initCharacterColorProduct(Context paramContext) {
        try {
            paramContext = Prefs.get(paramContext).getString("primary_color", "");
            setBackColor(Color.parseColor("#" + paramContext));
            setDefaultColor(Color.parseColor("#" + paramContext));
            setSelectedColor(Color.parseColor("#33000000"));
            setClickColor(Color.parseColor("#33000000"));
            return;
        } catch (Exception paramContext) {
        }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/resourcefactory/backlist/BackListItemRebrandCharacterRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */