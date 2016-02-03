package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateTopicActionbarAdapter
        extends BaseAdapter {
    private Activity mActivity;
    private ArrayList<HashMap<String, String>> mData = new ArrayList();
    private String mTitleString = null;

    public CreateTopicActionbarAdapter(Activity paramActivity, ArrayList<HashMap<String, String>> paramArrayList) {
        this.mData = paramArrayList;
        this.mActivity = paramActivity;
    }

    public CreateTopicActionbarAdapter(Activity paramActivity, ArrayList<HashMap<String, String>> paramArrayList, String paramString) {
        this.mData = paramArrayList;
        this.mActivity = paramActivity;
        this.mTitleString = paramString;
    }

    public int getCount() {
        return this.mData.size();
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = LayoutInflater.from(this.mActivity).inflate(2130903287, null);
        ((TextView) paramView.findViewById(2131231429)).setText((CharSequence) ((HashMap) this.mData.get(paramInt)).get("prefix_name"));
        return paramView;
    }

    public Object getItem(int paramInt) {
        return this.mData.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = LayoutInflater.from(this.mActivity).inflate(2130903288, null);
        if (!Util.isEmpty(this.mTitleString)) {
            ((TextView) paramView.findViewById(2131231430)).setText(this.mTitleString);
        }
        paramViewGroup = (TextView) paramView.findViewById(2131231431);
        if (((String) ((HashMap) this.mData.get(paramInt)).get("prefix_id")).equalsIgnoreCase(this.mActivity.getString(2131099967))) {
            paramViewGroup.setText((CharSequence) ((HashMap) this.mData.get(paramInt)).get("prefix_name"));
            return paramView;
        }
        paramViewGroup.setText(this.mActivity.getString(2131100011) + " " + (String) ((HashMap) this.mData.get(paramInt)).get("prefix_name"));
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/CreateTopicActionbarAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */