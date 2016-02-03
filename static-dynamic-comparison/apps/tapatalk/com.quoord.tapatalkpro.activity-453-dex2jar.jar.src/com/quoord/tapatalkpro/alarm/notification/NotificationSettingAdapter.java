package com.quoord.tapatalkpro.alarm.notification;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class NotificationSettingAdapter
        extends BaseAdapter {
    private Activity mActivity;
    private ArrayList<NotificationSettingCheckItemBean> mList;

    public NotificationSettingAdapter(ArrayList<NotificationSettingCheckItemBean> paramArrayList, Activity paramActivity) {
        this.mList = paramArrayList;
        this.mActivity = paramActivity;
        initTestData();
    }

    private void initTestData() {
    }

    public int getCount() {
        return this.mList.size();
    }

    public Object getItem(int paramInt) {
        return this.mList.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = getItem(paramInt);
        if ((paramView instanceof NotificationSettingCheckItemBean)) {
            paramView = (RelativeLayout) ((NotificationSettingCheckItemBean) paramView).getView(this.mActivity).findViewById(2131230918);
            if (paramInt == 0) {
                if (paramInt == getCount() - 1) {
                    paramView.setBackgroundResource(2130838971);
                    return paramView;
                }
                paramView.setBackgroundResource(2130838972);
                return paramView;
            }
            if (paramInt == getCount() - 1) {
                paramView.setBackgroundResource(2130838969);
                return paramView;
            }
            paramView.setBackgroundResource(2130838970);
            return paramView;
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/NotificationSettingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */