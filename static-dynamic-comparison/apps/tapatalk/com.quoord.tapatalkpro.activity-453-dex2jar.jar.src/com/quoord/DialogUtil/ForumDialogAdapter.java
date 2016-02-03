package com.quoord.DialogUtil;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class ForumDialogAdapter
        extends BaseAdapter {
    private Activity mContext;
    private ArrayList<String> mDatas;

    public ForumDialogAdapter(Activity paramActivity) {
        this.mContext = paramActivity;
        this.mDatas = new ArrayList();
        this.mDatas.add(paramActivity.getString(2131099850));
    }

    public ForumDialogAdapter(Activity paramActivity, Forum paramForum, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        this.mDatas = new ArrayList();
        if ((!paramForum.isSubscribe()) && (!paramForumStatus.checkLocalSubscribeForum(paramForum.getId()))) {
            this.mDatas.add(paramActivity.getString(2131099849));
        }
        for (; ; ) {
            if ((!paramForum.isSubOnly()) && (!paramForumStatus.isBB())) {
                this.mDatas.add(paramActivity.getString(2131099851));
            }
            this.mDatas.add(paramActivity.getString(2131100108));
            return;
            this.mDatas.add(paramActivity.getString(2131099850));
        }
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public String getItem(int paramInt) {
        return (String) this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
        paramView.setText((CharSequence) this.mDatas.get(paramInt));
        paramView.setCompoundDrawablePadding(5);
        if (((String) this.mDatas.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099846))) {
            paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_subscribe", this.mContext), 0, 0, 0);
        }
        do {
            return paramView;
            if (((String) this.mDatas.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099847))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_subscribe", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mDatas.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099851))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_markread", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mDatas.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100108))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_shortcut", this.mContext), 0, 0, 0);
                return paramView;
            }
        } while (!((String) this.mDatas.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100155)));
        paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_change_notification", this.mContext), 0, 0, 0);
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/ForumDialogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */