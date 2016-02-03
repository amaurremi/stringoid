package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

import java.io.Serializable;

public class ThreadPageView
        implements Serializable {
    public View setTextView(ThreadOuterFragment paramThreadOuterFragment, Activity paramActivity, int paramInt) {
        LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903393, null);
        TextView localTextView = (TextView) localLinearLayout.findViewById(2131230919);
        if (!SettingsFragment.isLightTheme(paramActivity)) {
            localTextView.setTextColor(paramActivity.getResources().getColor(2131165468));
        }
        if (paramThreadOuterFragment.mTopicController.getTotal_post_num() == 1) {
            localTextView.setText(paramActivity.getResources().getString(2131100555));
        }
        do {
            return localLinearLayout;
            if (paramThreadOuterFragment.mTopicController.getPageNum() > 1) {
                if (paramInt == paramThreadOuterFragment.mTopicController.getPageNum() - 1) {
                    localTextView.setText(paramActivity.getResources().getString(2131100556));
                    return localLinearLayout;
                }
                localTextView.setText(String.format(paramActivity.getResources().getString(2131100557), new Object[]{Integer.valueOf(paramThreadOuterFragment.mTopicController.getTotal_post_num() - (paramInt + 1) * paramThreadOuterFragment.mTopicController.getCountPerPage())}));
                return localLinearLayout;
            }
        } while (paramInt != paramThreadOuterFragment.mTopicController.getPageNum() - 1);
        localTextView.setText(paramActivity.getResources().getString(2131100556));
        return localLinearLayout;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ThreadPageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */