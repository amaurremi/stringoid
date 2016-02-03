package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.quoord.tapatalkpro.bean.Alert;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class ShortContentView
        extends BaseTextView {
    private ColorStateList colorState;
    private Context mContext;
    private int paintFlags;

    public ShortContentView(Context paramContext) {
        super(paramContext);
        this.mContext = paramContext;
        initView();
    }

    public ShortContentView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        initView();
    }

    public ShortContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.mContext = paramContext;
        initView();
    }

    private void initView() {
        this.colorState = getTextColors();
        this.paintFlags = getPaintFlags();
        setTextColor(this.mContext.getResources().getColor(ThemeUtil.getTextColor(this.mContext)));
    }

    public void isDelete(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        if (paramBoolean1) {
            setPaintFlags(this.paintFlags | 0x10);
            setTextColor(this.mContext.getResources().getColor(2131165283));
            setFocus(paramBoolean2, paramBoolean3);
            return;
        }
        setPaintFlags(this.paintFlags);
        setTextColor(this.mContext.getResources().getColor(2131165283));
        if (!SettingsFragment.isLightTheme(this.mContext)) {
            setTextColor(this.mContext.getResources().getColor(2131165461));
        }
        setFocus(paramBoolean2, paramBoolean3);
    }

    public void isRead(boolean paramBoolean) {
        if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
            setTextColor(this.mContext.getResources().getColor(2131165283));
            return;
        }
        setTextColor(this.mContext.getResources().getColor(2131165458));
    }

    public void setAdapterColor(boolean paramBoolean) {
        if (paramBoolean) {
            setTextColor(-1);
            return;
        }
        if (!SettingsFragment.getColorMode(this.mContext).booleanValue()) {
            setTextColor(this.mContext.getResources().getColor(2131165457));
            return;
        }
        setTextColor(this.mContext.getResources().getColor(2131165465));
    }

    public void setAlertColor(boolean paramBoolean, Alert paramAlert) {
        if (SettingsFragment.getColorMode(this.mContext).booleanValue()) {
            if (paramBoolean) {
                setText(paramAlert.getAlertString(this.mContext.getResources().getColor(2131165463)));
                setTextColor(-1);
                return;
            }
            setText(paramAlert.getAlertString(this.mContext.getResources().getColor(2131165460)));
            setTextColor(this.mContext.getResources().getColor(2131165458));
            return;
        }
        if (paramBoolean) {
            setText(paramAlert.getAlertString(this.mContext.getResources().getColor(2131165462)));
            setTextColor(-1);
            return;
        }
        setText(paramAlert.getAlertString(this.mContext));
        setTextColor(this.mContext.getResources().getColor(2131165464));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/ShortContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */