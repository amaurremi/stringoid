package com.quoord.tapatalkpro.adapter.directory.ics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.Prefs;

import java.util.ArrayList;

public class ThreadNavigationAdapter
        extends BaseAdapter {
    private Context context;
    public ArrayList<String> data = new ArrayList();
    private LayoutInflater inflater;

    public ThreadNavigationAdapter(Context paramContext, ArrayList<String> paramArrayList) {
        this.data = paramArrayList;
        this.context = paramContext;
        this.inflater = ((LayoutInflater) paramContext.getSystemService("layout_inflater"));
    }

    public int getCount() {
        return this.data.size();
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = this.inflater.inflate(2130903218, null);
        paramViewGroup = new NavDetailHolder();
        paramViewGroup.discribe = ((TextView) paramView.findViewById(2131230832));
        paramViewGroup.point = ((ImageView) paramView.findViewById(2131231276));
        if (paramInt == 0) {
            paramViewGroup.point.setVisibility(8);
        }
        for (; ; ) {
            paramViewGroup.discribe.setText((CharSequence) this.data.get(paramInt));
            if (paramInt != 0) {
                break;
            }
            paramViewGroup.discribe.setPadding(16, 0, 0, 0);
            return paramView;
            paramViewGroup.point.setVisibility(0);
        }
        paramViewGroup.point.setPadding((paramInt - 1) * 16 + 5, 0, 0, 0);
        return paramView;
    }

    public Object getItem(int paramInt) {
        return this.data.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = Prefs.get(this.context);
        paramInt = paramView.getInt("ics_custom_select_position", 0);
        if (!this.context.getResources().getBoolean(2131558401)) {
            if (paramInt == 0) {
                paramView = this.inflater.inflate(2130903219, null);
            }
        }
        for (; ; ) {
            ((TextView) paramView.findViewById(2131230832)).setText((CharSequence) this.data.get(0));
            return paramView;
            paramView = this.inflater.inflate(2130903217, null);
            continue;
            if (SettingsFragment.isLightTheme(this.context)) {
                if (paramView.contains("primary_color")) {
                    paramView = this.inflater.inflate(2130903217, null);
                } else {
                    paramView = this.inflater.inflate(2130903219, null);
                }
            } else {
                paramView = this.inflater.inflate(2130903219, null);
            }
        }
    }

    public static class NavDetailHolder {
        TextView discribe;
        ImageView point;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ics/ThreadNavigationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */