package com.quoord.DialogUtil;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class TopicDialogAdapter
        extends BaseAdapter {
    private Activity mContext;
    private ArrayList<String> mSubscribeArray = new ArrayList();
    private ArrayList<String> mTopicMenuArray = new ArrayList();
    private int mType = 5;

    public TopicDialogAdapter(Activity paramActivity, int paramInt, Topic paramTopic, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        this.mType = paramInt;
        if (!(paramActivity instanceof ThreadActivity)) {
            if (paramTopic.isCanSubscribe()) {
                if (!paramTopic.isSubscribe()) {
                    break label246;
                }
                this.mTopicMenuArray.add(this.mContext.getString(2131099847));
            }
        }
        for (; ; ) {
            this.mTopicMenuArray.add(this.mContext.getString(2131100054));
            if ((paramTopic.isCanApprove()) || (paramTopic.isCanBan()) || (paramTopic.isCanClose()) || (paramTopic.isCanDelete()) || (paramTopic.isCanStick()) || (paramTopic.isCanMove())) {
                this.mTopicMenuArray.add(this.mContext.getString(2131100067));
            }
            if (paramTopic.getNewPost()) {
                this.mTopicMenuArray.add(this.mContext.getString(2131099819));
            }
            this.mTopicMenuArray.add(this.mContext.getString(2131100092));
            if (!this.mContext.getResources().getBoolean(2131558402)) {
                this.mTopicMenuArray.add(this.mContext.getString(2131100091));
            }
            this.mTopicMenuArray.add(this.mContext.getString(2131100093));
            return;
            label246:
            this.mTopicMenuArray.add(this.mContext.getString(2131099846));
        }
    }

    public int getCount() {
        if (this.mType == 5) {
            return this.mTopicMenuArray.size();
        }
        if (this.mType == 4) {
            return this.mSubscribeArray.size();
        }
        return 0;
    }

    public String getItem(int paramInt) {
        String str = null;
        if (this.mType == 5) {
            str = (String) this.mTopicMenuArray.get(paramInt);
        }
        while (this.mType != 4) {
            return str;
        }
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = LayoutInflater.from(this.mContext).inflate(2130903284, null);
        paramViewGroup = (TextView) paramView.findViewById(2131231115);
        TextView localTextView = (TextView) paramView.findViewById(2131231020);
        if (this.mType == 5) {
            paramViewGroup.setText((CharSequence) this.mTopicMenuArray.get(paramInt));
            paramViewGroup.setCompoundDrawablePadding(5);
            if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099846))) {
                paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_subscribe", this.mContext), 0, 0, 0);
                if ((paramInt + 1 < this.mTopicMenuArray.size()) && (this.mTopicMenuArray.get(paramInt + 1) != null) && (((String) this.mTopicMenuArray.get(paramInt + 1)).equalsIgnoreCase(this.mContext.getString(2131100092)))) {
                    localTextView.setVisibility(0);
                    if (!SettingsFragment.isLightTheme(this.mContext)) {
                        break label589;
                    }
                    localTextView.setBackgroundResource(2131165286);
                }
            }
        }
        label589:
        do {
            do {
                return paramView;
                if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099847))) {
                    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_subscribe", this.mContext), 0, 0, 0);
                    break;
                }
                if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100067))) {
                    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_edit", this.mContext), 0, 0, 0);
                    break;
                }
                if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100102))) {
                    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_edit", this.mContext), 0, 0, 0);
                    break;
                }
                if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100054))) {
                    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_share", this.mContext), 0, 0, 0);
                    break;
                }
                if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100155))) {
                    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_change_notification", this.mContext), 0, 0, 0);
                    break;
                }
                if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131099819))) {
                    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_markread", this.mContext), 0, 0, 0);
                    break;
                }
                if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100093))) {
                    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_resent_post", this.mContext), 0, 0, 0);
                    break;
                }
                if (((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100091))) {
                    paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_first_unread", this.mContext), 0, 0, 0);
                    break;
                }
                if (!((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100092))) {
                    break;
                }
                paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_original_post", this.mContext), 0, 0, 0);
                break;
                localTextView.setBackgroundResource(2131165287);
                return paramView;
            } while (this.mType != 4);
            if (paramInt == 0) {
                paramViewGroup.setText((CharSequence) this.mSubscribeArray.get(0));
                paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDrawableIdByPicName("bubble_subscribe", this.mContext), 0, 0, 0);
                return paramView;
            }
        } while (!((String) this.mTopicMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100155)));
        paramViewGroup.setText((CharSequence) this.mSubscribeArray.get(1));
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_change_notification", this.mContext), 0, 0, 0);
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/TopicDialogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */