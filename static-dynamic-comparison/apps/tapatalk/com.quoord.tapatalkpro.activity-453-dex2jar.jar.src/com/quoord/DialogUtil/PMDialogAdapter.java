package com.quoord.DialogUtil;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class PMDialogAdapter
        extends BaseAdapter {
    private ArrayList<String> mArray = new ArrayList();
    private Activity mContext;

    public PMDialogAdapter(Activity paramActivity, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        if (paramForumStatus.isCanSendPm()) {
            this.mArray.add(this.mContext.getString(2131099816));
            this.mArray.add(this.mContext.getString(2131099817));
            return;
        }
        this.mArray.add(this.mContext.getString(2131099817));
    }

    public PMDialogAdapter(Activity paramActivity, ForumStatus paramForumStatus, String paramString) {
        this.mContext = paramActivity;
        this.mArray.add(this.mContext.getString(2131099817));
    }

    public PMDialogAdapter(Activity paramActivity, PrivateMessage paramPrivateMessage, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        if (paramForumStatus.isCanSendPm()) {
            this.mArray.add(this.mContext.getString(2131099815));
            this.mArray.add(this.mContext.getString(2131099816));
            if (!paramForumStatus.getAppVersion(paramActivity).equals("proboards")) {
                this.mArray.add(this.mContext.getString(2131099817));
            }
            if ((paramForumStatus.isMarkPmUnread()) && (paramPrivateMessage.getMsgState() != 1)) {
                this.mArray.add(this.mContext.getString(2131099818));
            }
            this.mArray.add(this.mContext.getString(2131099811));
            return;
        }
        this.mArray.add(this.mContext.getString(2131099817));
        this.mArray.add(this.mContext.getString(2131099811));
    }

    public int getCount() {
        return this.mArray.size();
    }

    public String getItem(int paramInt) {
        return (String) this.mArray.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
        paramView.setText((CharSequence) this.mArray.get(paramInt));
        paramView.setCompoundDrawablePadding(5);
        if (((String) this.mArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099815))) {
            paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_reply", this.mContext), 0, 0, 0);
        }
        do {
            return paramView;
            if (((String) this.mArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099816))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_forward", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099817))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_delete", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099811))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_viewuser", this.mContext), 0, 0, 0);
                return paramView;
            }
        } while (!((String) this.mArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099818)));
        paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_mark_unread", this.mContext), 0, 0, 0);
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/PMDialogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */