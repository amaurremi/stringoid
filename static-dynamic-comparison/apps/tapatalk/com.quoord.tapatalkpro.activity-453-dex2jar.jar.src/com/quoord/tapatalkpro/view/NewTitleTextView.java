package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class NewTitleTextView
        extends BaseTextView {
    private static GradientDrawable draw;
    private SharedPreferences defaultSp;
    private Context mContext;
    private int paintFlags;

    public NewTitleTextView(Context paramContext) {
        super(paramContext);
        this.mContext = paramContext;
        initView();
    }

    public NewTitleTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        initView();
    }

    public NewTitleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.mContext = paramContext;
        initView();
    }

    private void checkNeed(Context paramContext) {
        if (this.defaultSp == null) {
            this.defaultSp = Prefs.get(paramContext);
        }
        if (draw == null) {
            draw = new GradientDrawable();
            draw.setSize(this.mContext.getResources().getDimensionPixelOffset(2131427384), this.mContext.getResources().getDimensionPixelOffset(2131427385));
            draw.setColor(ThemeUtil.getAuthorColor(this.mContext));
            draw.setShape(0);
        }
    }

    private void initView() {
        if (SettingsFragment.isLightTheme(this.mContext)) {
            setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165310));
        }
        for (; ; ) {
            this.paintFlags = getPaintFlags();
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
        checkNeed(this.mContext);
        if (paramBoolean) {
            if (!SettingsFragment.isLightTheme(this.mContext)) {
                setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165213));
                if (((!this.defaultSp.getBoolean("unreadboldtitle", true)) || (!paramBoolean)) && ((!this.defaultSp.getBoolean("boldtitle", true)) || (paramBoolean))) {
                    break label287;
                }
                setTypeface(Typeface.defaultFromStyle(1), 1);
            }
        }
        for (; ; ) {
            setPadding(0, 0, 0, 0);
            if ((!this.defaultSp.getBoolean("unreadstripe", true)) || (!paramBoolean)) {
                break label299;
            }
            setCompoundDrawablesWithIntrinsicBounds(draw, null, null, null);
            setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(2131427373));
            return;
            setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165279));
            break;
            if (this.defaultSp.getBoolean("titlegrayed", true)) {
                if (!SettingsFragment.isLightTheme(getContext())) {
                    setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165276));
                    break;
                }
                setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165283));
                break;
            }
            if (!SettingsFragment.isLightTheme(getContext())) {
                setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165213));
                break;
            }
            setTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165279));
            break;
            label287:
            setTypeface(Typeface.defaultFromStyle(0), 0);
        }
        label299:
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        setPadding(this.mContext.getResources().getDimensionPixelOffset(2131427374), 0, 0, 0);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/NewTitleTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */