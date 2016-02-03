package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRecommendActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;

public class AddToFavoriate {
    public boolean isFromThread = false;
    public boolean isRecommend = false;
    public LinearLayout layout;
    private Activity mActivity;
    public ViewGroup view1;

    public AddToFavoriate(Activity paramActivity, boolean paramBoolean) {
        this.mActivity = paramActivity;
        this.isFromThread = paramBoolean;
    }

    public AddToFavoriate(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2) {
        this.mActivity = paramActivity;
        this.isFromThread = paramBoolean1;
        this.isRecommend = paramBoolean2;
    }

    public View getView(View paramView, final AddFavoriate paramAddFavoriate) {
        View localView = LayoutInflater.from(this.mActivity).inflate(2130903053, null);
        RelativeLayout localRelativeLayout = (RelativeLayout) localView.findViewById(2131230790);
        this.view1 = ((ViewGroup) localView.findViewById(2131230792));
        this.layout = ((LinearLayout) localView.findViewById(2131230791));
        if (paramView.getParent() != null) {
            ((ViewGroup) paramView.getParent()).removeView(paramView);
        }
        this.view1.addView(paramView);
        if (((this.mActivity instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) this.mActivity).isHide_addFavoriate_view)) {
            this.layout.setVisibility(8);
            if (!this.isRecommend) {
                break label152;
            }
            localRelativeLayout.setBackgroundResource(2131165281);
        }
        for (; ; ) {
            this.layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAddFavoriate.saveFavoriate();
                    if ((AddToFavoriate.this.mActivity instanceof IcsRecommendActivity)) {
                        paramAnonymousView = new Intent(AddToFavoriate.this.mActivity, AccountEntryActivity.class);
                        paramAnonymousView.putExtra("add_favoriate", true);
                        paramAnonymousView.setFlags(67108864);
                        AddToFavoriate.this.mActivity.startActivity(paramAnonymousView);
                    }
                    for (; ; ) {
                        AddToFavoriate.this.layout.setVisibility(8);
                        return;
                        if ((AddToFavoriate.this.mActivity instanceof SlidingMenuActivity)) {
                            ((SlidingMenuActivity) AddToFavoriate.this.mActivity).add_favoriate = true;
                            ((SlidingMenuActivity) AddToFavoriate.this.mActivity).isHide_addFavoriate_view = true;
                        }
                    }
                }
            });
            return localView;
            this.layout.setVisibility(0);
            break;
            label152:
            if ((SettingsFragment.isLightTheme(this.mActivity)) && (this.isFromThread)) {
                localRelativeLayout.setBackgroundResource(2131165213);
            }
        }
    }

    public static abstract interface AddFavoriate {
        public abstract void refresh();

        public abstract void saveFavoriate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/AddToFavoriate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */