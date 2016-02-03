package com.quoord.tapatalkpro.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class ResizeLayout
        extends LinearLayout {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    private static final String TAG = ResizeLayout.class.getSimpleName();
    private boolean mHasInit;
    private boolean mHasKeybord;
    private int mHeight;
    private onKybdsChangeListener mListener;

    public ResizeLayout(Context paramContext) {
        super(paramContext);
    }

    public ResizeLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public ResizeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mHeight = paramInt4;
            if (this.mListener != null) {
                this.mListener.onKeyBoardStateChange(-1);
            }
            if ((this.mHasInit) && (this.mHeight > paramInt4)) {
                this.mHasKeybord = true;
                if (this.mListener != null) {
                    this.mListener.onKeyBoardStateChange(-3);
                }
                Log.w(TAG, "show keyboard.......");
            }
            if ((this.mHasInit) && (this.mHasKeybord) && (this.mHeight == paramInt4)) {
                this.mHasKeybord = false;
                if (this.mListener != null) {
                    this.mListener.onKeyBoardStateChange(-2);
                }
                Log.w(TAG, "hide keyboard.......");
            }
            return;
        }
        if (this.mHeight < paramInt4) {
        }
        for (paramInt1 = paramInt4; ; paramInt1 = this.mHeight) {
            this.mHeight = paramInt1;
            break;
        }
    }

    public void setOnkbdStateListener(onKybdsChangeListener paramonKybdsChangeListener) {
        this.mListener = paramonKybdsChangeListener;
    }

    public static abstract interface onKybdsChangeListener {
        public abstract void onKeyBoardStateChange(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ResizeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */