package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class BaseTextView
        extends TextView
        implements TextViewInter {
    public boolean thisFocus;
    public int thisStyle;

    public BaseTextView(Context paramContext) {
        super(paramContext);
    }

    public BaseTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public BaseTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public void changeFocus(boolean paramBoolean) {
        this.thisFocus = paramBoolean;
    }

    public void initSelf() {
    }

    public void setBack(Drawable paramDrawable) {
    }

    public void setBackColor(int paramInt) {
    }

    public void setContent(String paramString) {
    }

    public void setContentColor(int paramInt) {
    }

    public void setDraw(Drawable paramDrawable, int paramInt) {
    }

    public void setFocus(boolean paramBoolean1, boolean paramBoolean2) {
        this.thisFocus = paramBoolean1;
    }

    public void setSize(int paramInt) {
    }

    public void setStyle(int paramInt) {
        this.thisStyle = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/BaseTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */