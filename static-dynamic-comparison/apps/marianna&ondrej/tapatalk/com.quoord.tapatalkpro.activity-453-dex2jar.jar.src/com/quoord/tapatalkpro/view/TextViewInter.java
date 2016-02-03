package com.quoord.tapatalkpro.view;

import android.graphics.drawable.Drawable;

public abstract interface TextViewInter {
    public static final int StyleBlack = 2;
    public static final int StyleWhite = 1;
    public static final int bottom = 6;
    public static final boolean focus = true;
    public static final int left = 3;
    public static final int right = 4;
    public static final int top = 5;
    public static final boolean unFocus = false;

    public abstract void setBack(Drawable paramDrawable);

    public abstract void setBackColor(int paramInt);

    public abstract void setContent(String paramString);

    public abstract void setContentColor(int paramInt);

    public abstract void setDraw(Drawable paramDrawable, int paramInt);

    public abstract void setFocus(boolean paramBoolean1, boolean paramBoolean2);

    public abstract void setSize(int paramInt);

    public abstract void setStyle(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/TextViewInter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */