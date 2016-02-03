package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class AuthorView
        extends BaseTextView {
    private ColorStateList colorState;
    private Context mContext;
    private int paintFlags;

    public AuthorView(Context paramContext) {
        super(paramContext);
        this.mContext = paramContext;
        initView();
    }

    public AuthorView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        initView();
    }

    public AuthorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.mContext = paramContext;
        initView();
    }

    private void initView() {
        this.colorState = getTextColors();
        this.paintFlags = getPaintFlags();
        setPaintFlags(this.paintFlags);
        setTextSize(this.mContext.getResources().getDimensionPixelOffset(2131427349));
        if (!this.mContext.getResources().getBoolean(2131558408)) {
            setTextColor(getAuthorNameColor(this.mContext));
            if (!SettingsFragment.isLightTheme(this.mContext)) {
                setTextColor(getAuthorNameColor(this.mContext));
            }
            return;
        }
        if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
            setTextColor(this.mContext.getResources().getColor(2131165275));
            return;
        }
        setTextColor(this.mContext.getResources().getColor(2131165460));
    }

    public int getAuthorNameColor(Context paramContext) {
        switch (ThemeUtil.getIndex(paramContext)) {
        }
        return 2131165344;
    }

    public void isDelete(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        if (!this.mContext.getResources().getBoolean(2131558408)) {
            if (paramBoolean1) {
                setPaintFlags(this.paintFlags | 0x10);
            }
            do {
                return;
                setPaintFlags(this.paintFlags);
            } while (SettingsFragment.isLightTheme(this.mContext));
            setTextColor(this.mContext.getResources().getColor(2131165461));
            return;
        }
        if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
            if (paramBoolean1) {
                setPaintFlags(this.paintFlags | 0x10);
            }
            for (; ; ) {
                setFocus(paramBoolean2, paramBoolean3);
                return;
                setPaintFlags(this.paintFlags);
                setTextColor(this.mContext.getResources().getColor(2131165460));
            }
        }
        if (paramBoolean1) {
            setPaintFlags(this.paintFlags | 0x10);
            setTextColor(-1);
        }
        for (; ; ) {
            setFocus(paramBoolean2, paramBoolean3);
            return;
            setPaintFlags(this.paintFlags);
            setTextColor(this.mContext.getResources().getColor(2131165460));
        }
    }

    public void isRead(boolean paramBoolean) {
        setTextColor(this.mContext.getResources().getColor(2131165460));
    }

    public void setAdapterColor(boolean paramBoolean) {
        if (paramBoolean) {
            if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
                setTextColor(this.mContext.getResources().getColor(2131165462));
                return;
            }
            setTextColor(this.mContext.getResources().getColor(2131165463));
            return;
        }
        setTextColor(this.mContext.getResources().getColor(2131165460));
    }

    public void setFocus(boolean paramBoolean1, boolean paramBoolean2) {
        super.setFocus(paramBoolean1, paramBoolean2);
        if (paramBoolean1) {
            if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
                setTextColor(this.mContext.getResources().getColor(2131165462));
                return;
            }
            setTextColor(this.mContext.getResources().getColor(2131165463));
            return;
        }
        isRead(paramBoolean2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/AuthorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */