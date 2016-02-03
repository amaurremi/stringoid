package com.quoord.newonboarding;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.util.Util;

public class ObWelcomeCardview
        extends Fragment {
    public static final int CARD_ACCESS = 2;
    public static final int CARD_DISCOVER = 3;
    public static final int CARD_JOIN = 4;
    public static final int CARD_NEW = 5;
    public static final int CARD_TAPATALKLOGO = 1;
    private Activity activity;
    private TextView content;
    private ImageView tapatalkLogo;
    private LinearLayout textLayout;
    private TextView title;
    private View view = null;
    private int witchCard = 1;

    public static ObWelcomeCardview newInstance(int paramInt, Activity paramActivity) {
        ObWelcomeCardview localObWelcomeCardview = new ObWelcomeCardview();
        localObWelcomeCardview.witchCard = paramInt;
        localObWelcomeCardview.activity = paramActivity;
        return localObWelcomeCardview;
    }

    public void initFont() {
        try {
            Typeface localTypeface = Typeface.createFromAsset(getActivity().getAssets(), "font/S-Core - Core Circus.ttf");
            this.title.setTypeface(localTypeface);
            localTypeface = Typeface.createFromAsset(getActivity().getAssets(), "font/KlinicSlabBoldIt.ttf");
            this.content.setTypeface(localTypeface);
            return;
        } catch (Exception localException) {
        }
    }

    public void initText(String paramString1, String paramString2) {
        this.tapatalkLogo.setVisibility(8);
        this.textLayout.setVisibility(0);
        this.title.setText(paramString1);
        this.content.setText(paramString2);
    }

    public void initView() {
        switch (this.witchCard) {
            default:
                return;
            case 1:
                this.tapatalkLogo.setVisibility(0);
                this.textLayout.setVisibility(8);
                if (Util.isHDDevice(getActivity())) {
                    this.tapatalkLogo.setBackgroundResource(2130839188);
                    return;
                }
                this.tapatalkLogo.setBackgroundResource(2130839187);
                return;
            case 2:
                initText(getString(2131100901), getString(2131100817));
                return;
            case 3:
                initText(getString(2131100902), getString(2131100818));
                return;
            case 4:
                initText(getString(2131100903), getString(2131100819));
                return;
        }
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        localLayoutParams.width = 60;
        this.view.setLayoutParams(localLayoutParams);
        initText("", "");
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        if (paramBundle != null) {
            this.witchCard = paramBundle.getInt("witchCard");
        }
        initFont();
        initView();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.view = null;
        if (Util.isHDDevice(getActivity())) {
        }
        for (this.view = paramLayoutInflater.inflate(2130903251, null); ; this.view = paramLayoutInflater.inflate(2130903250, null)) {
            this.tapatalkLogo = ((ImageView) this.view.findViewById(2131231334));
            this.content = ((TextView) this.view.findViewById(2131230778));
            this.title = ((TextView) this.view.findViewById(2131230769));
            this.textLayout = ((LinearLayout) this.view.findViewById(2131231335));
            return this.view;
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("witchCard", this.witchCard);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObWelcomeCardview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */