package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class PatchedTextView
        extends TextView {
    public PatchedTextView(Context paramContext) {
        super(paramContext);
    }

    public PatchedTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public PatchedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        try {
            super.onMeasure(paramInt1, paramInt2);
            return;
        } catch (Exception localException) {
            setText(getText().toString());
            super.onMeasure(paramInt1, paramInt2);
        }
    }

    public void setGravity(int paramInt) {
        try {
            super.setGravity(paramInt);
            return;
        } catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {
            setText(getText().toString());
            super.setGravity(paramInt);
        }
    }

    public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
        try {
            super.setText(paramCharSequence, paramBufferType);
            return;
        } catch (Exception paramBufferType) {
            setText(paramCharSequence.toString());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/PatchedTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */