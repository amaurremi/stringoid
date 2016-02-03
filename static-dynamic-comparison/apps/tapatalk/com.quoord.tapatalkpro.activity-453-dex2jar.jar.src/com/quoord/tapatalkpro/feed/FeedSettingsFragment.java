package com.quoord.tapatalkpro.feed;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.bean.FeedForum;
import com.quoord.tapatalkpro.bean.FeedShowNum;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tools.ImageTools;
import com.quoord.tools.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class FeedSettingsFragment
        extends QuoordFragment
        implements ExpandableListView.OnChildClickListener {
    private static final int default_show_num_select = 1;
    public FeedSettingsAdapter adapter;
    private ArrayList<FeedShowNum> feedShowNum = new ArrayList();
    private ArrayList<TapatalkForum> forumDatas = new ArrayList();
    private ArrayList<Object> forumId = new ArrayList();
    public ArrayList<FeedForum> forumListDatas = new ArrayList();
    private SectionTitleListView forumsList;
    public boolean isShowPhotoOnly = false;
    private ArrayList<FeedForum> nofeedForumDatas = new ArrayList();
    private SharedPreferences prefs;
    private ArrayList<Object> settingsDatas = new ArrayList();
    private int[] showAccount;
    private TapatalkId tapatalkId;
    private ImageView userArrow;
    private RoundedImageView userIcon;
    private RelativeLayout userInfo_layout;
    private TextView userName;

    public static FeedSettingsFragment newInstance(ArrayList<TapatalkForum> paramArrayList) {
        FeedSettingsFragment localFeedSettingsFragment = new FeedSettingsFragment();
        localFeedSettingsFragment.forumDatas = paramArrayList;
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("forumsdata", paramArrayList);
        localFeedSettingsFragment.setArguments(localBundle);
        return localFeedSettingsFragment;
    }

    public void addForumListDatas(ArrayList<TapatalkForum> paramArrayList) {
        this.nofeedForumDatas.clear();
        this.forumListDatas.clear();
        this.forumId.clear();
        int i = 0;
        if (i >= paramArrayList.size()) {
            this.forumListDatas.addAll(this.nofeedForumDatas);
            return;
        }
        FeedForum localFeedForum;
        if (!this.forumId.contains(((TapatalkForum) paramArrayList.get(i)).getId())) {
            this.forumId.add(((TapatalkForum) paramArrayList.get(i)).getId());
            localFeedForum = new FeedForum();
            localFeedForum.setName(((TapatalkForum) paramArrayList.get(i)).getName());
            localFeedForum.setFeed(((TapatalkForum) paramArrayList.get(i)).isFeed());
            localFeedForum.setForumid(((TapatalkForum) paramArrayList.get(i)).getId().intValue());
            if (!localFeedForum.isFeed()) {
                break label221;
            }
            if (this.prefs != null) {
                localFeedForum.setSelect(this.prefs.getBoolean(this.prefs.getInt("tapatalk_auid", -1) + "|" + localFeedForum.getForumid(), true));
            }
            this.forumListDatas.add(localFeedForum);
        }
        for (; ; ) {
            i += 1;
            break;
            label221:
            this.nofeedForumDatas.add(localFeedForum);
        }
    }

    public void initSettingsDatas() {
        this.settingsDatas.clear();
        this.feedShowNum.clear();
        this.settingsDatas.add("UNREADNOTIFICATION");
        int i = 0;
        if (i >= this.showAccount.length) {
            this.settingsDatas.addAll(this.feedShowNum);
            this.settingsDatas.add("SHOW");
            this.settingsDatas.add("SHOWALLPOST");
            this.settingsDatas.add("SHOWALLFORUMS");
            addForumListDatas(this.forumDatas);
            return;
        }
        FeedShowNum localFeedShowNum = new FeedShowNum();
        localFeedShowNum.setNum(getActivity().getResources().getString(this.showAccount[i]));
        if (this.prefs == null) {
            this.prefs = Prefs.get(getActivity());
        }
        if (this.prefs.getInt("default_show_num_select", 1) == i) {
            localFeedShowNum.setSelect(true);
        }
        for (; ; ) {
            this.feedShowNum.add(localFeedShowNum);
            i += 1;
            break;
            localFeedShowNum.setSelect(false);
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        if (SettingsFragment.isLightTheme(getActivity())) {
            getView().setBackgroundResource(2131165611);
        }
        if ((getArguments() != null) && (getArguments().containsKey("forumsdata"))) {
            this.forumDatas = ((ArrayList) getArguments().get("forumsdata"));
        }
        updateFromCache();
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(getActivity());
        this.showAccount = new int[]{2131100682, 2131100684, 2131100686};
        initSettingsDatas();
        this.forumsList.setGroupIndicator(null);
        this.forumsList.setSelector(2131165212);
        this.forumsList.setFeedSettings(true);
        this.forumsList.setOnChildClickListener(this);
        this.forumsList.setHeaderView(getActivity().getLayoutInflater().inflate(2130903161, null, false));
        this.adapter = new FeedSettingsAdapter(getActivity(), this.forumsList);
        this.adapter.groupList.add(this.adapter.myForumGroupBean);
        this.adapter.groupList.add(this.adapter.feedSettingGroupBean);
        this.adapter.myForumGroupBean.setChildrenList(this.forumDatas);
        this.adapter.feedSettingGroupBean.setChildrenList(this.settingsDatas);
        this.forumsList.setAdapter(this.adapter);
        int i = 0;
        for (; ; ) {
            if (i >= this.adapter.getGroupCount()) {
                setUpdate(getActivity(), this.forumDatas);
                return;
            }
            this.forumsList.expandGroup(i);
            i += 1;
        }
    }

    public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong) {
        if ((this.adapter.getChild(paramInt1, paramInt2) instanceof TapatalkForum)) {
            ((TapatalkForum) this.adapter.getChild(paramInt1, paramInt2)).openTapatalkForum(getActivity(), false);
        }
        return true;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903163, paramViewGroup, false);
        this.forumsList = ((SectionTitleListView) paramLayoutInflater.findViewById(2131231081));
        this.userIcon = ((RoundedImageView) paramLayoutInflater.findViewById(2131231022));
        this.userName = ((TextView) paramLayoutInflater.findViewById(2131231024));
        this.userInfo_layout = ((RelativeLayout) paramLayoutInflater.findViewById(2131231079));
        this.userArrow = ((ImageView) paramLayoutInflater.findViewById(2131231080));
        return paramLayoutInflater;
    }

    public void setUpdate(Activity paramActivity, ArrayList<TapatalkForum> paramArrayList) {
        this.prefs = Prefs.get(paramActivity);
        if (this.userIcon != null) {
            ImageTools.glideLoad(this.prefs.getString("tapatalk_avatar", ""), this.userIcon, 2130837858);
        }
        if (this.userName != null) {
            if ((this.tapatalkId.getAuid() == -1) || (!this.tapatalkId.isTapatalkIdLogin())) {
                break label233;
            }
            if (this.userName != null) {
                if ((this.tapatalkId.getUsername() == null) || (this.tapatalkId.getUsername().equals(""))) {
                    break label214;
                }
                this.userName.setText(this.tapatalkId.getUsername());
            }
            if (this.userArrow != null) {
                this.userArrow.setVisibility(8);
                this.userInfo_layout.setEnabled(false);
            }
        }
        for (; ; ) {
            if (paramArrayList == null) {
                updateFromCache();
                setUpdate(paramActivity, this.forumDatas);
            }
            if ((this.adapter != null) && (this.adapter.myForumGroupBean != null)) {
                this.forumDatas = paramArrayList;
                this.adapter.myForumGroupBean.setChildrenList(this.forumDatas);
                initSettingsDatas();
                this.adapter.notifyDataSetChanged();
            }
            return;
            label214:
            this.userName.setText(this.tapatalkId.getTapatalkIdEmail());
            break;
            label233:
            if (this.userName != null) {
                this.userName.setText(getActivity().getResources().getString(2131100194));
            }
            if (this.userArrow != null) {
                this.userArrow.setBackgroundDrawable(getActivity().getResources().getDrawable(ThemeUtil.getDrawableIDByPicName("feed_arrow_guest", getActivity())));
            }
            this.userInfo_layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.setClass(FeedSettingsFragment.this.getActivity(), ObEntryActivity.class);
                    paramAnonymousView.putExtra("accountPage", true);
                    paramAnonymousView.putExtra("guestLogin", true);
                    FeedSettingsFragment.this.getActivity().startActivityForResult(paramAnonymousView, 37);
                }
            });
        }
    }

    public void updateFromCache() {
        this.forumDatas = TapatalkAccountAction.getCurrnentAllAccount(getActivity());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/feed/FeedSettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */