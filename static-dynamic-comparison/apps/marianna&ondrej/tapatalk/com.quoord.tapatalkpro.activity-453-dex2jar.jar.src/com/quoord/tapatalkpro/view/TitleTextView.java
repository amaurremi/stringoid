package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class TitleTextView
        extends BaseTextView {
    private Context mContext;
    private int paintFlags;

    public TitleTextView(Context paramContext) {
        super(paramContext);
        this.mContext = paramContext;
        initView();
    }

    public TitleTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        initView();
    }

    public TitleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.mContext = paramContext;
        initView();
    }

    private void initView() {
        if (SettingsFragment.isLightTheme(this.mContext)) {
            setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165310));
        }
        for (; ; ) {
            this.paintFlags = getPaintFlags();
            setTypeface(Typeface.defaultFromStyle(1), 1);
            return;
            setTextColor(-1);
        }
    }

    public void initial(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        if (paramBoolean1) {
            setPaintFlags(this.paintFlags | 0x10);
            if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
                setTextColor(-7829368);
            }
            for (; ; ) {
                setFocus(paramBoolean2, paramBoolean3);
                return;
                setTextColor(-1);
            }
        }
        setPaintFlags(this.paintFlags);
        if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
            setTextColor(-7829368);
        }
        for (; ; ) {
            setFocus(paramBoolean2, paramBoolean3);
            return;
            setTextColor(-1);
        }
    }

    public void isRead(boolean paramBoolean) {
        if (paramBoolean) {
            if (!SettingsFragment.isLightTheme(this.mContext)) {
                setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165213));
                return;
            }
            setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165279));
            return;
        }
        if (!SettingsFragment.isLightTheme(getContext())) {
            setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165276));
            return;
        }
        setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165283));
    }

    public void setAdapterColor(boolean paramBoolean) {
        if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
            if (paramBoolean) {
                setTextColor(-1);
                return;
            }
            setTextColor(this.mContext.getResources().getColor(2131165459));
            return;
        }
        setTextColor(-1);
    }

    public void setFocus(boolean paramBoolean1, boolean paramBoolean2) {
        super.setFocus(paramBoolean1, paramBoolean2);
        if (paramBoolean1) {
            setTextColor(-1);
            return;
        }
        isRead(paramBoolean2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/TitleTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */