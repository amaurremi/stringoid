package com.quoord.tapatalkpro.resourcefactory.backlist;

import android.content.Context;
import android.content.res.Resources;
import com.quoord.tapatalkpro.resourcefactory.AbsColorRender;

public class BackListItemCharacterDrakColorRender
        implements AbsColorRender {
    private int backColorResource = -1;
    private int clickColorResource = -1;
    private int defaultColorResource = -1;
    private int selectedColorResource = -1;

    public BackListItemCharacterDrakColorRender(Context paramContext) {
        initCharacterColorProduct(paramContext);
    }

    private void initCharacterColorProduct(Context paramContext) {
        setBackColor(paramContext.getResources().getColor(2131165213));
        setDefaultColor(paramContext.getResources().getColor(2131165213));
        setSelectedColor(paramContext.getResources().getColor(2131165213));
        setClickColor(paramContext.getResources().getColor(2131165213));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/resourcefactory/backlist/BackListItemCharacterDrakColorRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */