package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class TimeStampView
        extends BaseTextView {
    private Context mContext;
    private int paintFlags = 0;

    public TimeStampView(Context paramContext) {
        super(paramContext);
        this.mContext = paramContext;
        initView();
    }

    public TimeStampView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        initView();
    }

    public TimeStampView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.mContext = paramContext;
        initView();
    }

    private void initView() {
        setTextColor(-7829368);
        this.paintFlags = getPaintFlags();
        setTextSize(this.mContext.getResources().getDimensionPixelOffset(2131427351));
    }

    public void isDelete(boolean paramBoolean1, boolean paramBoolean2) {
        if (paramBoolean1) {
            setPaintFlags(this.paintFlags | 0x10);
            setTextColor(-7829368);
            return;
        }
        setPaintFlags(this.paintFlags);
        if (!this.mContext.getResources().getBoolean(2131558408)) {
            setTextColor(-7829368);
            return;
        }
        setTextColor(this.mContext.getResources().getColor(2131165460));
        setFocus(paramBoolean2, false);
    }

    public void setAdapterColor(boolean paramBoolean, View paramView) {
        if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
            if (paramBoolean) {
                setTextColor(this.mContext.getResources().getColor(2131165462));
                return;
            }
            setTextColor(this.mContext.getResources().getColor(2131165460));
            return;
        }
        if (paramBoolean) {
            setTextColor(this.mContext.getResources().getColor(2131165463));
            return;
        }
        setTextColor(this.mContext.getResources().getColor(2131165460));
    }

    public void setContentColor(int paramInt) {
        super.setContentColor(paramInt);
    }

    public void setFocus(boolean paramBoolean1, boolean paramBoolean2) {
        super.setFocus(paramBoolean1, paramBoolean2);
        if (paramBoolean1) {
            if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
                setTextColor(this.mContext.getResources().getColor(2131165462));
            }
        } else {
            return;
        }
        setTextColor(this.mContext.getResources().getColor(2131165463));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/TimeStampView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */