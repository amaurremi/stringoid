package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class VideoAndPhotoDialogHelperAdapter
        extends BaseAdapter {
    private ArrayList<String> mAttachArray = new ArrayList();
    private Activity mContext;

    public VideoAndPhotoDialogHelperAdapter(Activity paramActivity, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        this.mAttachArray.add(paramActivity.getString(2131099996));
        if (paramForumStatus.isHasCamera()) {
            this.mAttachArray.add(paramActivity.getString(2131100928));
            this.mAttachArray.add(paramActivity.getString(2131100929));
        }
    }

    public int getCount() {
        return this.mAttachArray.size();
    }

    public String getItem(int paramInt) {
        return (String) this.mAttachArray.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
        paramView.setText((CharSequence) this.mAttachArray.get(paramInt));
        if (((String) this.mAttachArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099996))) {
            paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDrawableByPicName("gallery", this.mContext), null, null, null);
            paramView.setCompoundDrawablePadding(10);
            return paramView;
        }
        if (((String) this.mAttachArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100928))) {
            paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDrawableByPicName("camera_photo", this.mContext), null, null, null);
            paramView.setCompoundDrawablePadding(10);
            return paramView;
        }
        paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDrawableByPicName("camera_video", this.mContext), null, null, null);
        paramView.setCompoundDrawablePadding(10);
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/VideoAndPhotoDialogHelperAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */