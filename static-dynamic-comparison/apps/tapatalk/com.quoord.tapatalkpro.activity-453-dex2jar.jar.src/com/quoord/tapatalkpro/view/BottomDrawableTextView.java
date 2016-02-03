package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;

public class BottomDrawableTextView
        extends TextView {
    private int textColor = -1;

    public BottomDrawableTextView(Context paramContext) {
        super(paramContext);
        init(paramContext);
    }

    public BottomDrawableTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext);
    }

    public BottomDrawableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext);
    }

    private void init(Context paramContext) {
        this.textColor = paramContext.getResources().getColor(2131165283);
        setTextColor(this.textColor);
    }

    public void changeTextColor(int paramInt) {
        if (paramInt != this.textColor) {
            this.textColor = paramInt;
            setTextColor(paramInt);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/BottomDrawableTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */