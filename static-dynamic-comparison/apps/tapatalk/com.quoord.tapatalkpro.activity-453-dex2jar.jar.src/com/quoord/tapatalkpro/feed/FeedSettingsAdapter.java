package com.quoord.tapatalkpro.feed;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.bean.FeedForum;
import com.quoord.tapatalkpro.bean.FeedShowNum;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tapatalkpro.view.SectionTitleListView.IphoneTreeHeaderAdapter;
import com.quoord.tools.ImageTools;

import java.util.ArrayList;

public class FeedSettingsAdapter
        extends BaseExpandableListAdapter
        implements SectionTitleListView.IphoneTreeHeaderAdapter {
    public static final String FEEDSETTINGS_PHOTOSONLY = "feedsettings_photosonly";
    public SharedPreferences.Editor editor;
    public GroupBean feedSettingGroupBean;
    public ArrayList<GroupBean> groupList;
    public SparseIntArray groupStatusMap;
    public SectionTitleListView groupTreeView;
    ViewHolder holder;
    private boolean isChecked = false;
    public Activity mContext;
    public GroupBean myForumGroupBean;
    public SharedPreferences prefs;

    public FeedSettingsAdapter(Activity paramActivity, SectionTitleListView paramSectionTitleListView) {
        this.mContext = paramActivity;
        initGroup();
        this.groupTreeView = paramSectionTitleListView;
        this.prefs = Prefs.get(this.mContext);
        this.editor = this.prefs.edit();
    }

    public void configureTreeHeader(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
            paramInt2 = 0;
        }
        TextView localTextView1 = (TextView) paramView.findViewById(2131231075);
        TextView localTextView2 = (TextView) paramView.findViewById(2131231020);
        localTextView1.setText(((GroupBean) this.groupList.get(paramInt2)).getTitle());
        localTextView1.setTextColor(this.mContext.getResources().getColor(Util.setThemeBg(this.mContext, 2131165610, 2131165608)));
        paramView.setBackgroundResource(Util.setThemeBg(this.mContext, 2131165604, 2131165609));
    }

    public Object getChild(int paramInt1, int paramInt2) {
        int i = paramInt2;
        if (paramInt2 < 0) {
            i = 0;
        }
        return ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(i);
    }

    public long getChildId(int paramInt1, int paramInt2) {
        return paramInt1 * 100 + paramInt2;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        if ((paramInt2 < 0) || (((GroupBean) this.groupList.get(paramInt1)).getChildrenList().size() <= 0)) {
            return null;
        }
        final Object localObject1 = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
        if ((localObject1 != null) && ((localObject1 instanceof TapatalkForum))) {
            paramView = getForumView((TapatalkForum) localObject1, paramInt2, paramView, paramViewGroup);
        }
        for (; ; ) {
            return paramView;
            if (localObject1.equals("UNREADNOTIFICATION")) {
                paramView = LayoutInflater.from(this.mContext).inflate(2130903155, null);
                paramViewGroup = (TextView) paramView.findViewById(2131231042);
            } else {
                Object localObject3;
                final Object localObject2;
                if ((localObject1 instanceof FeedShowNum)) {
                    localObject1 = (FeedShowNum) localObject1;
                    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903152, null);
                    paramView = (LinearLayout) paramViewGroup.findViewById(2131231036);
                    localObject3 = (RelativeLayout) paramViewGroup.findViewById(2131231037);
                    localObject2 = (TextView) paramViewGroup.findViewById(2131231020);
                    if (paramInt2 == 1) {
                        ((TextView) localObject2).setVisibility(8);
                        if (SettingsFragment.isLightTheme(this.mContext)) {
                            paramView = this.mContext.getResources().getDrawable(2130838773);
                            label220:
                            ((RelativeLayout) localObject3).setBackgroundDrawable(paramView);
                            paramView = (TextView) paramViewGroup.findViewById(2131231039);
                            paramView.setText(((FeedShowNum) localObject1).getNum());
                            localObject3 = (ImageView) paramViewGroup.findViewById(2131231038);
                            if (!((FeedShowNum) localObject1).isSelect()) {
                                break label463;
                            }
                            ((ImageView) localObject3).setVisibility(0);
                            paramView.setTextColor(this.mContext.getResources().getColor(Util.setThemeBg(this.mContext, 2131165213, 2131165224)));
                        }
                    }
                    for (; ; ) {
                        ((TextView) localObject2).setBackgroundResource(Util.setThemeBg(this.mContext, 2131165607, 2131165612));
                        paramViewGroup.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View paramAnonymousView) {
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        int j = 1;
                                        boolean bool = Boolean.valueOf(this.val$showNum.isSelect()).booleanValue();
                                        if (!bool) {
                                            i = 0;
                                            if (i < FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().size()) {
                                                break label156;
                                            }
                                            localObject = this.val$showNum;
                                            if (!bool) {
                                                break label210;
                                            }
                                        }
                                        label156:
                                        label210:
                                        for (bool = false; ; bool = true) {
                                            ((FeedShowNum) localObject).setSelect(bool);
                                            FeedSettingsAdapter.this.notifyDataSetChanged();
                                            if (!FeedSettingsAdapter.this.mContext.getResources().getString(2131100682).equals(this.val$showNum.getNum())) {
                                                break label215;
                                            }
                                            FeedSettingsAdapter.this.editor.putInt("default_notification_num", 0);
                                            FeedSettingsAdapter.this.editor.putInt("default_show_num_select", 0);
                                            FeedSettingsAdapter.this.editor.commit();
                                            return;
                                            if ((FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().get(i) instanceof FeedShowNum)) {
                                                ((FeedShowNum) FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().get(i)).setSelect(bool);
                                            }
                                            i += 1;
                                            break;
                                        }
                                        label215:
                                        FeedSettingsAdapter.this.editor.putInt("default_notification_num", Integer.parseInt(this.val$showNum.getNum()));
                                        Object localObject = FeedSettingsAdapter.this.editor;
                                        if (this.val$showNum.getNum().equals("5")) {
                                        }
                                        for (int i = j; ; i = 2) {
                                            ((SharedPreferences.Editor) localObject).putInt("default_show_num_select", i);
                                            break;
                                        }
                                    }
                                }, 300L);
                            }
                        });
                        paramView = paramViewGroup;
                        break;
                        paramView = this.mContext.getResources().getDrawable(2130838772);
                        break label220;
                        if (paramInt2 == 3) {
                            if (SettingsFragment.isLightTheme(this.mContext)) {
                            }
                            for (paramView = this.mContext.getResources().getDrawable(2130838769); ; paramView = this.mContext.getResources().getDrawable(2130838771)) {
                                ((RelativeLayout) localObject3).setBackgroundDrawable(paramView);
                                break;
                            }
                        }
                        if (SettingsFragment.isLightTheme(this.mContext)) {
                        }
                        for (paramView = this.mContext.getResources().getDrawable(2130838768); ; paramView = this.mContext.getResources().getDrawable(2130838770)) {
                            ((RelativeLayout) localObject3).setBackgroundDrawable(paramView);
                            break;
                        }
                        label463:
                        ((ImageView) localObject3).setVisibility(8);
                    }
                }
                if (localObject1.equals("SHOW")) {
                    paramView = LayoutInflater.from(this.mContext).inflate(2130903154, null);
                    paramViewGroup = (TextView) paramView.findViewById(2131231041);
                } else {
                    if (localObject1.equals("SHOWALLPOST")) {
                        paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903150, null);
                        localObject1 = (Button) paramViewGroup.findViewById(2131231030);
                        localObject2 = (Button) paramViewGroup.findViewById(2131231031);
                        if (this.prefs.getBoolean("feedsettings_photosonly", false)) {
                            if (SettingsFragment.isLightTheme(this.mContext)) {
                                paramView = this.mContext.getResources().getDrawable(2130837671);
                                label601:
                                ((Button) localObject1).setBackgroundDrawable(paramView);
                                if (!SettingsFragment.isLightTheme(this.mContext)) {
                                    break label698;
                                }
                            }
                            label698:
                            for (paramView = this.mContext.getResources().getDrawable(2130837674); ; paramView = this.mContext.getResources().getDrawable(2130837675)) {
                                ((Button) localObject2).setBackgroundDrawable(paramView);
                                ((Button) localObject1).setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View paramAnonymousView) {
                                        Button localButton = localObject1;
                                        if (SettingsFragment.isLightTheme(FeedSettingsAdapter.this.mContext)) {
                                            paramAnonymousView = FeedSettingsAdapter.this.mContext.getResources().getDrawable(2130837669);
                                            localButton.setBackgroundDrawable(paramAnonymousView);
                                            localButton = localObject2;
                                            if (!SettingsFragment.isLightTheme(FeedSettingsAdapter.this.mContext)) {
                                                break label115;
                                            }
                                        }
                                        label115:
                                        for (paramAnonymousView = FeedSettingsAdapter.this.mContext.getResources().getDrawable(2130837676); ; paramAnonymousView = FeedSettingsAdapter.this.mContext.getResources().getDrawable(2130837677)) {
                                            localButton.setBackgroundDrawable(paramAnonymousView);
                                            ((AccountEntryActivity) FeedSettingsAdapter.this.mContext).feedSettingsFragment.isShowPhotoOnly = false;
                                            return;
                                            paramAnonymousView = FeedSettingsAdapter.this.mContext.getResources().getDrawable(2130837670);
                                            break;
                                        }
                                    }
                                });
                                ((Button) localObject2).setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View paramAnonymousView) {
                                        Button localButton = localObject1;
                                        if (SettingsFragment.isLightTheme(FeedSettingsAdapter.this.mContext)) {
                                            paramAnonymousView = FeedSettingsAdapter.this.mContext.getResources().getDrawable(2130837671);
                                            localButton.setBackgroundDrawable(paramAnonymousView);
                                            localButton = localObject2;
                                            if (!SettingsFragment.isLightTheme(FeedSettingsAdapter.this.mContext)) {
                                                break label115;
                                            }
                                        }
                                        label115:
                                        for (paramAnonymousView = FeedSettingsAdapter.this.mContext.getResources().getDrawable(2130837674); ; paramAnonymousView = FeedSettingsAdapter.this.mContext.getResources().getDrawable(2130837675)) {
                                            localButton.setBackgroundDrawable(paramAnonymousView);
                                            ((AccountEntryActivity) FeedSettingsAdapter.this.mContext).feedSettingsFragment.isShowPhotoOnly = true;
                                            return;
                                            paramAnonymousView = FeedSettingsAdapter.this.mContext.getResources().getDrawable(2130837672);
                                            break;
                                        }
                                    }
                                });
                                paramView = paramViewGroup;
                                break;
                                paramView = this.mContext.getResources().getDrawable(2130837672);
                                break label601;
                            }
                        }
                        if (SettingsFragment.isLightTheme(this.mContext)) {
                            paramView = this.mContext.getResources().getDrawable(2130837669);
                            label741:
                            ((Button) localObject1).setBackgroundDrawable(paramView);
                            if (!SettingsFragment.isLightTheme(this.mContext)) {
                                break label801;
                            }
                        }
                        label801:
                        for (paramView = this.mContext.getResources().getDrawable(2130837676); ; paramView = this.mContext.getResources().getDrawable(2130837677)) {
                            ((Button) localObject2).setBackgroundDrawable(paramView);
                            break;
                            paramView = this.mContext.getResources().getDrawable(2130837670);
                            break label741;
                        }
                    }
                    TextView localTextView;
                    if (localObject1.equals("SHOWALLFORUMS")) {
                        int j = 0;
                        int i = 0;
                        paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903151, null);
                        localObject3 = (RelativeLayout) paramViewGroup.findViewById(2131231032);
                        localObject1 = (ImageView) paramViewGroup.findViewById(2131231034);
                        localTextView = (TextView) paramViewGroup.findViewById(2131231033);
                        localObject2 = (TextView) paramViewGroup.findViewById(2131231035);
                        if (paramInt2 == 6) {
                            if (SettingsFragment.isLightTheme(this.mContext)) {
                                paramView = this.mContext.getResources().getDrawable(2130839304);
                                label935:
                                ((RelativeLayout) localObject3).setBackgroundDrawable(paramView);
                            }
                        } else {
                            paramInt1 = j;
                            if (this.mContext != null) {
                                paramInt1 = j;
                                if (((AccountEntryActivity) this.mContext).feedSettingsFragment != null) {
                                    paramInt1 = j;
                                    if (((AccountEntryActivity) this.mContext).feedSettingsFragment.forumListDatas != null) {
                                        paramInt2 = 0;
                                        paramInt1 = i;
                                        label992:
                                        if (paramInt2 < ((AccountEntryActivity) this.mContext).feedSettingsFragment.forumListDatas.size()) {
                                            break label1119;
                                        }
                                    }
                                }
                            }
                            if (paramInt1 != ((AccountEntryActivity) this.mContext).feedSettingsFragment.forumListDatas.size()) {
                                break label1181;
                            }
                            localTextView.setText(this.mContext.getString(2131100674));
                            if (!SettingsFragment.isLightTheme(this.mContext)) {
                                break label1163;
                            }
                        }
                        label1119:
                        label1163:
                        for (paramView = this.mContext.getResources().getDrawable(2130838835); ; paramView = this.mContext.getResources().getDrawable(2130838836)) {
                            ((ImageView) localObject1).setImageDrawable(paramView);
                            paramViewGroup.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View paramAnonymousView) {
                                    if (((AccountEntryActivity) FeedSettingsAdapter.this.mContext).feedSettingsFragment.forumListDatas.size() >= 0) {
                                        localObject2.setVisibility(8);
                                    }
                                    FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().remove("SHOWALLFORUMS");
                                    FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().add("SHOWSELECTFORUMS");
                                    FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().addAll(((AccountEntryActivity) FeedSettingsAdapter.this.mContext).feedSettingsFragment.forumListDatas);
                                    FeedSettingsAdapter.this.notifyDataSetChanged();
                                }
                            });
                            paramView = paramViewGroup;
                            break;
                            paramView = this.mContext.getResources().getDrawable(2130839305);
                            break label935;
                            i = paramInt1;
                            if (((FeedForum) ((AccountEntryActivity) this.mContext).feedSettingsFragment.forumListDatas.get(paramInt2)).isSelect()) {
                                i = paramInt1 + 1;
                            }
                            paramInt2 += 1;
                            paramInt1 = i;
                            break label992;
                        }
                        label1181:
                        localTextView.setText("From " + paramInt1 + " forums");
                        if (SettingsFragment.isLightTheme(this.mContext)) {
                        }
                        for (paramView = this.mContext.getResources().getDrawable(2130838835); ; paramView = this.mContext.getResources().getDrawable(2130838836)) {
                            ((ImageView) localObject1).setImageDrawable(paramView);
                            break;
                        }
                    }
                    if (localObject1.equals("SHOWSELECTFORUMS")) {
                        paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903151, null);
                        localObject3 = (RelativeLayout) paramViewGroup.findViewById(2131231032);
                        localTextView = (TextView) paramViewGroup.findViewById(2131231033);
                        localObject1 = (ImageView) paramViewGroup.findViewById(2131231034);
                        localObject2 = (TextView) paramViewGroup.findViewById(2131231035);
                        ((TextView) localObject2).setVisibility(8);
                        if ((((AccountEntryActivity) this.mContext).feedSettingsFragment != null) && (this.feedSettingGroupBean != null) && (this.feedSettingGroupBean.getChildrenList() != null) && (this.feedSettingGroupBean.getChildrenList().size() <= 0)) {
                            this.feedSettingGroupBean.getChildrenList().addAll(((AccountEntryActivity) this.mContext).feedSettingsFragment.forumListDatas);
                        }
                        if (paramInt2 == 6) {
                            if (SettingsFragment.isLightTheme(this.mContext)) {
                                paramView = this.mContext.getResources().getDrawable(2130839306);
                                label1446:
                                ((RelativeLayout) localObject3).setBackgroundDrawable(paramView);
                            }
                        } else {
                            if (((AccountEntryActivity) this.mContext).feedSettingsFragment.forumListDatas.size() == 0) {
                                if (!SettingsFragment.isLightTheme(this.mContext)) {
                                    break label1599;
                                }
                                paramView = this.mContext.getResources().getDrawable(2130839304);
                                label1497:
                                ((RelativeLayout) localObject3).setBackgroundDrawable(paramView);
                            }
                            localTextView.setText(this.mContext.getString(2131100673));
                            ((ImageView) localObject1).setBackgroundResource(2130839298);
                            if (!SettingsFragment.isLightTheme(this.mContext)) {
                                break label1617;
                            }
                        }
                        label1599:
                        label1617:
                        for (paramView = this.mContext.getResources().getDrawable(2130839298); ; paramView = this.mContext.getResources().getDrawable(2130839299)) {
                            ((ImageView) localObject1).setImageDrawable(paramView);
                            paramViewGroup.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View paramAnonymousView) {
                                    localObject2.setVisibility(0);
                                    FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().add("SHOWALLFORUMS");
                                    FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().remove("SHOWSELECTFORUMS");
                                    FeedSettingsAdapter.this.feedSettingGroupBean.getChildrenList().removeAll(((AccountEntryActivity) FeedSettingsAdapter.this.mContext).feedSettingsFragment.forumListDatas);
                                    FeedSettingsAdapter.this.notifyDataSetChanged();
                                }
                            });
                            paramView = paramViewGroup;
                            break;
                            paramView = this.mContext.getResources().getDrawable(2130839307);
                            break label1446;
                            paramView = this.mContext.getResources().getDrawable(2130839305);
                            break label1497;
                        }
                    }
                    if ((localObject1 instanceof FeedForum)) {
                        localObject1 = (FeedForum) localObject1;
                        paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903147, null);
                        paramView = (TextView) paramViewGroup.findViewById(2131231019);
                        localTextView = (TextView) paramViewGroup.findViewById(2131231020);
                        ImageView localImageView = (ImageView) paramViewGroup.findViewById(2131231017);
                        localObject2 = (ImageView) paramViewGroup.findViewById(2131231018);
                        localObject3 = (RelativeLayout) paramViewGroup.findViewById(2131231016);
                        paramView.setText(((FeedForum) localObject1).getName());
                        if (Boolean.valueOf(((FeedForum) localObject1).isSelect()).booleanValue()) {
                            localImageView.setVisibility(0);
                            label1760:
                            if (paramInt2 == ((GroupBean) this.groupList.get(1)).getSize() - 1) {
                                ((RelativeLayout) localObject3).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839303));
                            }
                            paramView.setTextColor(this.mContext.getResources().getColor(Util.setThemeBg(this.mContext, 2131165214, 2131165213)));
                            localTextView.setBackgroundResource(Util.setThemeBg(this.mContext, 2131165606, 2131165613));
                            if (!SettingsFragment.isLightTheme(this.mContext)) {
                                break label1906;
                            }
                        }
                        label1906:
                        for (paramView = this.mContext.getResources().getDrawable(2130838774); ; paramView = this.mContext.getResources().getDrawable(2130838775)) {
                            ((RelativeLayout) localObject3).setBackgroundDrawable(paramView);
                            if (((FeedForum) localObject1).isFeed()) {
                                break label1924;
                            }
                            ((ImageView) localObject2).setVisibility(0);
                            paramView = paramViewGroup;
                            break;
                            localImageView.setVisibility(8);
                            break label1760;
                        }
                        label1924:
                        ((ImageView) localObject2).setVisibility(8);
                        paramViewGroup.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View paramAnonymousView) {
                                boolean bool2 = false;
                                boolean bool3 = Boolean.valueOf(localObject1.isSelect()).booleanValue();
                                paramAnonymousView = localObject1;
                                String str;
                                if (bool3) {
                                    bool1 = false;
                                    paramAnonymousView.setSelect(bool1);
                                    paramAnonymousView = FeedSettingsAdapter.this.editor;
                                    str = FeedSettingsAdapter.this.prefs.getInt("tapatalk_auid", -1) + "|" + localObject1.getForumid();
                                    if (!bool3) {
                                        break label130;
                                    }
                                }
                                label130:
                                for (boolean bool1 = bool2; ; bool1 = true) {
                                    paramAnonymousView.putBoolean(str, bool1);
                                    FeedSettingsAdapter.this.editor.commit();
                                    FeedSettingsAdapter.this.notifyDataSetChanged();
                                    return;
                                    bool1 = true;
                                    break;
                                }
                            }
                        });
                        paramView = paramViewGroup;
                    }
                }
            }
        }
    }

    public int getChildrenCount(int paramInt) {
        if (paramInt < 0) {
            return 0;
        }
        return ((GroupBean) this.groupList.get(paramInt)).getChildrenList().size();
    }

    public ArrayList<TapatalkForum> getData(ArrayList<TapatalkForum> paramArrayList) {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        if (i >= paramArrayList.size()) {
            return localArrayList;
        }
        int k = 0;
        int j = 0;
        for (; ; ) {
            if (j >= localArrayList.size()) {
            }
            for (j = k; ; j = 1) {
                if (j == 0) {
                    localArrayList.add((TapatalkForum) paramArrayList.get(i));
                }
                i += 1;
                break;
                if (((TapatalkForum) paramArrayList.get(i)).getId().intValue() != ((TapatalkForum) localArrayList.get(j)).getId().intValue()) {
                    break label101;
                }
            }
            label101:
            j += 1;
        }
    }

    public View getForumView(TapatalkForum paramTapatalkForum, int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof ViewHolder))) {
            this.holder = new ViewHolder(null);
            paramViewGroup = this.mContext.getLayoutInflater().inflate(2130903162, null);
            this.holder.forumIcon = ((ImageView) paramViewGroup.findViewById(2131231076));
            this.holder.forumName = ((TextView) paramViewGroup.findViewById(2131231077));
            this.holder.noFeedText = ((TextView) paramViewGroup.findViewById(2131231078));
            this.holder.divice = ((TextView) paramViewGroup.findViewById(2131231020));
            this.holder.forumIcon.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", this.mContext));
            this.holder.divice.setBackgroundResource(Util.setThemeBg(this.mContext, 2131165606, 2131165613));
            if (SettingsFragment.isLightTheme(this.mContext)) {
                paramView = this.mContext.getResources().getDrawable(2130838766);
                paramViewGroup.setBackgroundDrawable(paramView);
                paramViewGroup.setTag(this.holder);
                paramView = paramViewGroup;
                label205:
                this.holder.forumName.setText(paramTapatalkForum.getName());
                if ((paramTapatalkForum.getUserName() == null) || (paramTapatalkForum.getUserName().equals(""))) {
                    break label318;
                }
                this.holder.noFeedText.setVisibility(0);
                this.holder.noFeedText.setText(paramTapatalkForum.getUserName());
            }
        }
        for (; ; ) {
            if (paramTapatalkForum.getIconUrl() != null) {
                ImageTools.glideLoad(paramTapatalkForum.getIconUrl(), this.holder.forumIcon);
            }
            return paramView;
            paramView = this.mContext.getResources().getDrawable(2130838767);
            break;
            this.holder = ((ViewHolder) paramView.getTag());
            break label205;
            label318:
            this.holder.noFeedText.setVisibility(8);
        }
    }

    public Object getGroup(int paramInt) {
        return ((GroupBean) this.groupList.get(paramInt)).getTitle();
    }

    public int getGroupCount() {
        return this.groupList.size();
    }

    public long getGroupId(int paramInt) {
        return paramInt * 100;
    }

    public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        if (paramView == null) {
            paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130903161, null);
        }
        paramView = (TextView) paramViewGroup.findViewById(2131231075);
        TextView localTextView = (TextView) paramViewGroup.findViewById(2131231020);
        paramView.setText(((GroupBean) this.groupList.get(paramInt)).getTitle());
        paramView.setTextColor(this.mContext.getResources().getColor(Util.setThemeBg(this.mContext, 2131165610, 2131165608)));
        paramViewGroup.setBackgroundResource(Util.setThemeBg(this.mContext, 2131165604, 2131165609));
        paramViewGroup.setClickable(false);
        return paramViewGroup;
    }

    public int getHeadViewClickStatus(int paramInt) {
        if (this.groupStatusMap.get(paramInt) != 0) {
            return this.groupStatusMap.get(paramInt);
        }
        return 0;
    }

    public Object getItem(int paramInt1, int paramInt2) {
        try {
            Object localObject = ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
            return localObject;
        } catch (Exception localException) {
        }
        return null;
    }

    public int getTreeHeaderState(int paramInt1, int paramInt2) {
        if (paramInt2 == getChildrenCount(paramInt1) - 1) {
            return 2;
        }
        if ((paramInt2 == -1) && (!this.groupTreeView.isGroupExpanded(paramInt1))) {
            return 0;
        }
        return 1;
    }

    public boolean hasStableIds() {
        return false;
    }

    public void initGroup() {
        if (this.groupList == null) {
            this.groupList = new ArrayList();
        }
        this.groupList.clear();
        this.feedSettingGroupBean = new GroupBean(this.mContext.getString(2131100676));
        this.myForumGroupBean = new GroupBean(this.mContext.getString(2131100921));
    }

    public boolean isChildSelectable(int paramInt1, int paramInt2) {
        return true;
    }

    public void onHeadViewClick(int paramInt1, int paramInt2) {
        this.groupStatusMap.put(paramInt1, paramInt2);
    }

    private static class ViewHolder {
        TextView divice;
        ImageView forumIcon;
        TextView forumName;
        TextView noFeedText;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/feed/FeedSettingsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */