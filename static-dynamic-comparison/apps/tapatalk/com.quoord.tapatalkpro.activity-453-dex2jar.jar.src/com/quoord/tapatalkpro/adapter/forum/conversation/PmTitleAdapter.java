package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.Prefs;

import java.util.ArrayList;

public class PmTitleAdapter
        extends BaseAdapter {
    private int isCustom;
    private Activity mActivity;
    private ArrayList<String> mData = new ArrayList();
    private SharedPreferences prefs = null;

    public PmTitleAdapter(Activity paramActivity, ArrayList<String> paramArrayList) {
        this.mData = paramArrayList;
        this.mActivity = paramActivity;
        this.prefs = Prefs.get(paramActivity);
        this.isCustom = this.prefs.getInt("ics_custom_select_position", 0);
    }

    public int getCount() {
        return this.mData.size();
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = LayoutInflater.from(this.mActivity).inflate(2130903317, null);
        ((TextView) paramView.findViewById(2131231516)).setText((CharSequence) this.mData.get(paramInt));
        return paramView;
    }

    public Object getItem(int paramInt) {
        return this.mData.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = LayoutInflater.from(this.mActivity).inflate(2130903316, null);
        paramViewGroup = (TextView) paramView.findViewById(2131231516);
        if ((!SettingsFragment.isLightTheme(this.mActivity)) || (this.isCustom != 0) || (this.prefs.contains("primary_color")) || (this.mActivity.getResources().getBoolean(2131558411))) {
            paramViewGroup.setTextColor(this.mActivity.getResources().getColor(2131165213));
        }
        paramViewGroup.setText((CharSequence) this.mData.get(paramInt));
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/PmTitleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */