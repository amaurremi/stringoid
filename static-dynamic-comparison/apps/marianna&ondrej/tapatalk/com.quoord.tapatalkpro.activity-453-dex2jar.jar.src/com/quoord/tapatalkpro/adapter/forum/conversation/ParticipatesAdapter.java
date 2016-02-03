package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.ParticipatesActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Participant;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ParticipatesAdapter
        extends BaseAdapter {
    ImageView avaterbg;
    ImageView diver;
    private ForumStatus forumStatus = null;
    private HashMap hashMap = null;
    GifImageView icon;
    RelativeLayout layoutView;
    private ListView listView = null;
    private Context mActivity = null;
    public ArrayList<Participant> mData = new ArrayList();
    TextView user;

    public ParticipatesAdapter(Activity paramActivity, ForumStatus paramForumStatus, ListView paramListView, HashMap paramHashMap) {
        this.mActivity = paramActivity;
        this.forumStatus = paramForumStatus;
        this.listView = paramListView;
        this.hashMap = paramHashMap;
        this.listView.setAdapter(this);
        if ((this.hashMap != null) && (this.hashMap.size() > 0)) {
            paramActivity = this.hashMap.keySet().iterator();
        }
        for (; ; ) {
            if (!paramActivity.hasNext()) {
                setListOnclick();
                return;
            }
            paramForumStatus = (String) paramActivity.next();
            paramListView = (HashMap) this.hashMap.get(paramForumStatus);
            paramHashMap = new Participant();
            paramHashMap.setUserId(paramForumStatus);
            paramHashMap.setUserName(new String((byte[]) paramListView.get("username")));
            paramHashMap.setIcon_url((String) paramListView.get("icon_url"));
            this.mData.add(paramHashMap);
        }
    }

    public int getCount() {
        return this.mData.size();
    }

    public Object getItem(int paramInt) {
        return this.mData.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getParticipatesView(int paramInt, View paramView, ViewGroup paramViewGroup, String paramString) {
        if (paramString.equals("bottom")) {
            paramView = LayoutInflater.from(this.mActivity).inflate(2130903311, null);
            this.layoutView = ((RelativeLayout) paramView.findViewById(2131231493));
            this.icon = ((GifImageView) paramView.findViewById(2131231494));
            this.avaterbg = ((ImageView) paramView.findViewById(2131230795));
            this.user = ((TextView) paramView.findViewById(2131231495));
            if ((((Participant) this.mData.get(paramInt)).getUserName() != null) && (!((Participant) this.mData.get(paramInt)).getUserName().equals(""))) {
                this.user.setText(((Participant) this.mData.get(paramInt)).getUserName());
            }
            ThemeUtil.setAuthorColor(this.mActivity, this.user);
            Util.getUserImage(this.mActivity, this.forumStatus, this.icon, ((Participant) this.mData.get(paramInt)).getIcon_url(), this.avaterbg);
            this.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", this.mActivity));
            return paramView;
        }
        if (paramString.equals("top")) {
            paramView = LayoutInflater.from(this.mActivity).inflate(2130903313, null);
            this.layoutView = ((RelativeLayout) paramView.findViewById(2131231493));
            this.icon = ((GifImageView) paramView.findViewById(2131231494));
            this.avaterbg = ((ImageView) paramView.findViewById(2131230795));
            this.user = ((TextView) paramView.findViewById(2131231495));
            this.diver = ((ImageView) paramView.findViewById(2131231496));
            this.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
            if ((((Participant) this.mData.get(paramInt)).getUserName() != null) && (!((Participant) this.mData.get(paramInt)).getUserName().equals(""))) {
                this.user.setText(((Participant) this.mData.get(paramInt)).getUserName());
            }
            ThemeUtil.setAuthorColor(this.mActivity, this.user);
            Util.getUserImage(this.mActivity, this.forumStatus, this.icon, ((Participant) this.mData.get(paramInt)).getIcon_url(), this.avaterbg);
            this.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", this.mActivity));
            return paramView;
        }
        paramView = LayoutInflater.from(this.mActivity).inflate(2130903312, null);
        this.layoutView = ((RelativeLayout) paramView.findViewById(2131231493));
        this.icon = ((GifImageView) paramView.findViewById(2131231494));
        this.avaterbg = ((ImageView) paramView.findViewById(2131230795));
        this.user = ((TextView) paramView.findViewById(2131231495));
        this.diver = ((ImageView) paramView.findViewById(2131231496));
        this.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
        if ((((Participant) this.mData.get(paramInt)).getUserName() != null) && (!((Participant) this.mData.get(paramInt)).getUserName().equals(""))) {
            this.user.setText(((Participant) this.mData.get(paramInt)).getUserName());
        }
        ThemeUtil.setAuthorColor(this.mActivity, this.user);
        Util.getUserImage(this.mActivity, this.forumStatus, this.icon, ((Participant) this.mData.get(paramInt)).getIcon_url(), this.avaterbg);
        this.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mActivity));
        return paramView;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (paramInt == 0) {
            return getParticipatesView(paramInt, paramView, paramViewGroup, "top");
        }
        if (paramInt == getCount() - 1) {
            return getParticipatesView(paramInt, paramView, paramViewGroup, "bottom");
        }
        return getParticipatesView(paramInt, paramView, paramViewGroup, "mid");
    }

    public void setListOnclick() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                try {
                    paramAnonymousAdapterView = new Intent(ParticipatesAdapter.this.mActivity, ProfilesActivity.class);
                    paramAnonymousAdapterView.putExtra("forumStatus", ParticipatesAdapter.this.forumStatus);
                    paramAnonymousAdapterView.putExtra("iconusername", ((Participant) ParticipatesAdapter.this.mData.get(paramAnonymousInt)).getUserName());
                    paramAnonymousAdapterView.putExtra("userid", ((Participant) ParticipatesAdapter.this.mData.get(paramAnonymousInt)).getUserId());
                    paramAnonymousAdapterView.putExtra("can_upload", ((ParticipatesActivity) ParticipatesAdapter.this.mActivity).can_upload);
                    ParticipatesAdapter.this.mActivity.startActivity(paramAnonymousAdapterView);
                    return;
                } catch (Exception paramAnonymousAdapterView) {
                }
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ParticipatesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */