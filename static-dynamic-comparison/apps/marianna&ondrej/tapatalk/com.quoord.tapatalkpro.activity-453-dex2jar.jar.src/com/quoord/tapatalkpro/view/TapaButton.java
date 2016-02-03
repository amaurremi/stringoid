package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

public class TapaButton
        extends Button {
    private Context mContext;

    public TapaButton(Context paramContext) {
        super(paramContext);
        this.mContext = paramContext;
        initView();
    }

    public TapaButton(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        initView();
    }

    public TapaButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.mContext = paramContext;
        initView();
    }

    private void initView() {
        if (SettingsFragment.isLightTheme(this.mContext)) {
            setTextColor(this.mContext.getResources().getColor(2131165214));
            return;
        }
        setTextColor(this.mContext.getResources().getColor(2131165213));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/TapaButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */