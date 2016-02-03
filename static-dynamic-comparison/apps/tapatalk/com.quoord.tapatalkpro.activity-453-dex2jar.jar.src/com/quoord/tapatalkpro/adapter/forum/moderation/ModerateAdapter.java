package com.quoord.tapatalkpro.adapter.forum.moderation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.DialogUtil.DialogUtil;
import com.quoord.tapatalkpro.action.GetTopicAction;
import com.quoord.tapatalkpro.action.GetTopicAction.UpdateTopic;
import com.quoord.tapatalkpro.activity.forum.CategoryActivity;
import com.quoord.tapatalkpro.activity.forum.CreateTopicActivity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.moderation.MergeTopicSettingActivity;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateActivity;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateFragment;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ForumCookiesCache;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;

public class ModerateAdapter
        extends SectionTitleListViewAdapter
        implements ExpandableListView.OnChildClickListener, TryTwiceCallBackInterface, ModerationInterface {
    public static final int flatten = 1;
    public static final int hierarchical = 0;
    private String AllForumTitle = null;
    private String RecentTitile = null;
    public String cacheFile;
    Comparator<Object> comp = new Mycomparator(null);
    private String cookieCacheUrl = null;
    public Forum currentForum;
    private TapatalkEngine engine;
    private ArrayList<Forum> flattenForumList = new ArrayList();
    public HashMap<Object, Object> forumDatas = new HashMap();
    private GroupBean forumGroupBean;
    public Stack<ArrayList> forumStack = new Stack();
    private ForumStatus forumStatus;
    public ArrayList<String> forum_id = new ArrayList();
    public GetTopicAction getTopicAction = null;
    private Boolean guest_okay;
    public boolean isLoadmore = false;
    private boolean isMergeOpenThread = false;
    protected boolean isOpCancel = false;
    public boolean isRedirect = true;
    private Boolean is_flatten = Boolean.valueOf(false);
    public ArrayList<Object> list = new ArrayList();
    private ArrayList<Forum> mDatas = new ArrayList();
    private GroupBean mergePostGroupBean;
    private GroupBean mergeTopicGroupBean;
    public String mergedForumId;
    public Topic mergedTopic = null;
    private String mergedTopicId;
    public String newTopicName;
    private String postListTitle = null;
    public String recentCacheFile;
    public ArrayList<Forum> recentDatas = new ArrayList();
    public ArrayList<Forum> recentForums = new ArrayList();
    public ArrayList<String> sectionTitle = new ArrayList();
    public String targetForumId;
    public String targetForumName;
    private String title;
    private String topicListTitle = null;
    private String topicTitle = null;
    private Boolean tryTwice = Boolean.valueOf(false);

    public ModerateAdapter(Activity paramActivity, SectionTitleListView paramSectionTitleListView, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        this.groupTreeView = paramSectionTitleListView;
        this.forumStatus = paramForumStatus;
        this.cacheFile = AppCacheManager.getForumCacheUrl(paramActivity, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
        this.recentCacheFile = AppCacheManager.getRecentForumCacheUrl(paramActivity, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
        this.forum_id.clear();
        this.AllForumTitle = this.mContext.getResources().getString(2131100747);
        this.RecentTitile = this.mContext.getResources().getString(2131100748);
        this.topicListTitle = this.mContext.getResources().getString(2131100750);
        this.postListTitle = this.mContext.getResources().getString(2131100751);
        this.cookieCacheUrl = AppCacheManager.getModerateCookieCacheUrl(this.mContext, this.forumStatus.tapatalkForum.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
        paramActivity = AppCacheManager.getForumCookiesData(this.cookieCacheUrl);
        if ((paramActivity != null) && (paramActivity.cookies != null)) {
            this.forumStatus.cookies = paramActivity.cookies;
            this.forumStatus.loginExpire = false;
        }
        int i;
        if (((this.mContext instanceof ModerateActivity)) && (((ModerateActivity) this.mContext).select_forum_action == 4)) {
            initMergeTopicGroup();
            this.groupStatusMap = new SparseIntArray();
            this.groupTreeView.setOnChildClickListener(this);
            this.engine = new TapatalkEngine(this, this.forumStatus, this.mContext);
            this.groupTreeView.setAdapter(this);
            i = 0;
        }
        for (; ; ) {
            if (i >= getGroupCount()) {
                return;
                if (((this.mContext instanceof ModerateActivity)) && (((ModerateActivity) this.mContext).select_forum_action == 5)) {
                    initMergePostGroup();
                    break;
                }
                initGroup();
                break;
            }
            this.groupTreeView.expandGroup(i);
            i += 1;
        }
    }

    public void backToTopLevel() {
        this.forum_id.clear();
        this.mDatas = ((ArrayList) this.forumStack.pop());
        int i;
        if (!this.sectionTitle.isEmpty()) {
            this.sectionTitle.remove(this.sectionTitle.size() - 1);
            this.title = ((String) this.sectionTitle.get(this.sectionTitle.size() - 1));
            this.groupList.clear();
            if (this.sectionTitle.size() <= 1) {
                getRecentForum();
            }
            GroupBean localGroupBean = new GroupBean(this.title);
            this.groupList.add(localGroupBean);
            ((GroupBean) this.groupList.get(this.groupList.size() - 1)).setChildrenList(this.mDatas);
            i = 0;
        }
        for (; ; ) {
            if (i >= getGroupCount()) {
                notifyDataSetChanged();
                return;
                this.title = this.AllForumTitle;
                break;
            }
            this.groupTreeView.expandGroup(i);
            i += 1;
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
        if (((String) localObject).equals("m_move_topic")) {
            ((ForumActivityStatus) this.mContext).closeProgress();
            if (paramEngineResponse != null) {
                retryLogin(paramEngineResponse);
                if (!((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                    break label202;
                }
                Util.showToastDialog(this.mContext, this.mContext.getResources().getString(2131100064));
                if (this.isMergeOpenThread) {
                    if (!paramEngineResponse.containsKey("topic_id")) {
                        break label184;
                    }
                    localObject = new Topic();
                    ((Topic) localObject).setTitle(this.topicTitle);
                    ((Topic) localObject).setId((String) paramEngineResponse.get("topic_id"));
                    ((Topic) localObject).setForumId(this.mergedForumId);
                    ((Topic) localObject).openThread(this.mContext, this.forumStatus);
                }
                paramEngineResponse = new Intent();
                paramEngineResponse.putExtra("forum_name", getTargetForumName());
                this.mContext.setResult(-1, paramEngineResponse);
                this.mContext.finish();
            }
        }
        label184:
        label202:
        label416:
        label701:
        do {
            do {
                do {
                    return;
                    this.mergedTopic.openThread(this.mContext, this.forumStatus);
                    break;
                    paramEngineResponse = new String((byte[]) paramEngineResponse.get("result_text")).toString();
                    Toast.makeText(this.mContext, paramEngineResponse, 1).show();
                    return;
                    if (!((String) localObject).equals("m_move_post")) {
                        break label416;
                    }
                    ((ForumActivityStatus) this.mContext).closeProgress();
                } while (paramEngineResponse == null);
                retryLogin(paramEngineResponse);
                if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                    Util.showToastDialog(this.mContext, this.mContext.getResources().getString(2131100064));
                    if (paramEngineResponse.containsKey("topic_id")) {
                        localObject = new Topic();
                        ((Topic) localObject).setTitle(this.topicTitle);
                        ((Topic) localObject).setId((String) paramEngineResponse.get("topic_id"));
                        ((Topic) localObject).openThread(this.mContext, this.forumStatus);
                    }
                    paramEngineResponse = new Intent();
                    this.mContext.setResult(902, paramEngineResponse);
                    this.mContext.finish();
                    return;
                }
                paramEngineResponse = new String((byte[]) paramEngineResponse.get("result_text")).toString();
                Toast.makeText(this.mContext, paramEngineResponse, 1).show();
                return;
                if (!((String) localObject).equals("m_merge_topic")) {
                    break label701;
                }
            } while (paramEngineResponse == null);
            retryLogin(paramEngineResponse);
            ((ForumActivityStatus) this.mContext).closeProgress();
            if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                this.isMergeOpenThread = true;
                if ((this.newTopicName != null) && (!this.newTopicName.equals(""))) {
                    renameTopic();
                }
                for (; ; ) {
                    Util.showToastDialog(this.mContext, this.mContext.getResources().getString(2131100755));
                    return;
                    if (this.mergedForumId.equals(((ModerateActivity) this.mContext).mTopic.getForumId())) {
                        break;
                    }
                    moveTopic(this.mergedTopicId, this.mergedForumId);
                }
                if (paramEngineResponse.containsKey("topic_id")) {
                    localObject = new Topic();
                    ((Topic) localObject).setTitle(this.topicTitle);
                    ((Topic) localObject).setId((String) paramEngineResponse.get("topic_id"));
                    ((Topic) localObject).setForumId(this.mergedForumId);
                    ((Topic) localObject).openThread(this.mContext, this.forumStatus);
                }
                for (; ; ) {
                    paramEngineResponse = new Intent();
                    this.mContext.setResult(-1, paramEngineResponse);
                    this.mContext.finish();
                    break;
                    this.mergedTopic.setForumId(this.mergedForumId);
                    this.mergedTopic.openThread(this.mContext, this.forumStatus);
                }
            }
            paramEngineResponse = new String((byte[]) paramEngineResponse.get("result_text")).toString();
            Toast.makeText(this.mContext, paramEngineResponse, 1).show();
            return;
        } while (!((String) localObject).equals("m_rename_topic"));
        retryLogin(paramEngineResponse);
        ((ForumActivityStatus) this.mContext).closeProgress();
        Util.showToastDialog(this.mContext, this.mContext.getResources().getString(2131100274));
        if (!this.mergedForumId.equals(((ModerateActivity) this.mContext).mTopic.getForumId())) {
            moveTopic(this.mergedTopicId, this.mergedForumId);
            return;
        }
        paramEngineResponse = new Intent();
        this.mContext.setResult(-1, paramEngineResponse);
        this.mContext.finish();
    }

    public void clearAll() {
        this.mDatas.clear();
        notifyDataSetChanged();
    }

    public void deleteForums(int paramInt1, int paramInt2) {
        this.recentDatas.remove(paramInt2);
        if (this.recentDatas.size() > 0) {
            ((GroupBean) this.groupList.get(paramInt1)).setChildrenList(this.recentDatas);
        }
        for (; ; ) {
            AppCacheManager.cacheData(this.recentCacheFile, this.recentDatas);
            notifyDataSetChanged();
            return;
            this.groupList.remove(0);
        }
    }

    public String getCacheFile() {
        return this.cacheFile;
    }

    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
        Object localObject;
        if ((((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2) instanceof Forum)) {
            localObject = (Forum) ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
            if ((this.groupList.size() > 1) && (paramInt1 == 0)) {
                paramViewGroup = getView((Forum) localObject, paramInt1, paramInt2, paramView, paramViewGroup, true);
                paramViewGroup.setPadding(0, 0, 0, 20);
            }
        }
        do {
            return paramViewGroup;
            return getView((Forum) localObject, paramInt1, paramInt2, paramView, paramViewGroup, false);
            if ((((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2) instanceof Topic)) {
                paramViewGroup = (Topic) ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
                localObject = new HashMap();
                ((HashMap) localObject).put("showForumName", Boolean.valueOf(false));
                ((HashMap) localObject).put("isSubscribedTab", Boolean.valueOf(false));
                return paramViewGroup.createView((HashMap) localObject, paramView, (ModerateActivity) this.mContext);
            }
            paramViewGroup = paramView;
        } while (!(((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2) instanceof PostData));
        paramViewGroup = (PostData) ((GroupBean) this.groupList.get(paramInt1)).getChildrenList().get(paramInt2);
        return paramView;
    }

    public void getFlattenList(ArrayList<Forum> paramArrayList) {
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                return;
            }
            if ((((Forum) paramArrayList.get(i)).getChildForums() != null) && (((Forum) paramArrayList.get(i)).getChildForums().size() > 0)) {
                getFlattenList(((Forum) paramArrayList.get(i)).getChildForums());
            }
            if ((!((Forum) paramArrayList.get(i)).isSubOnly()) && ((((Forum) paramArrayList.get(i)).getUrl() == null) || (((Forum) paramArrayList.get(i)).getUrl().length() <= 0))) {
                this.flattenForumList.add((Forum) paramArrayList.get(i));
            }
            i += 1;
        }
    }

    public View getForumViewForMove(int paramInt1, Forum paramForum, View paramView, boolean paramBoolean, final int paramInt2, final int paramInt3) {
        ForumViewHolderMove localForumViewHolderMove;
        if (paramView == null) {
            paramView = LayoutInflater.from(this.mContext).inflate(2130903169, null);
            localForumViewHolderMove = new ForumViewHolderMove(null);
            localForumViewHolderMove.layout = ((RelativeLayout) paramView.findViewById(2131230840));
            localForumViewHolderMove.diver = ((ImageView) paramView.findViewById(2131230776));
            localForumViewHolderMove.icon = ((ImageView) paramView.findViewById(2131231103));
            localForumViewHolderMove.text = ((TextView) paramView.findViewById(2131231104));
            localForumViewHolderMove.delete = ((ImageView) paramView.findViewById(2131231106));
            localForumViewHolderMove.deleteLayout = ((LinearLayout) paramView.findViewById(2131231105));
            paramView.setTag(localForumViewHolderMove);
            if ((!(this.mContext instanceof ModerateActivity)) || (((ModerateActivity) this.mContext).mTopic == null)) {
                break label437;
            }
            if (!paramForum.getName().equalsIgnoreCase(((ModerateActivity) this.mContext).mTopic.getForumName())) {
                break label409;
            }
            localForumViewHolderMove.text.setTextColor(-7829368);
            label182:
            if (!this.forumStatus.checkNewPost(paramForum.getId())) {
                break label465;
            }
            localForumViewHolderMove.text.setTypeface(null, 1);
            label206:
            localForumViewHolderMove.text.setText(paramForum.getName());
            localForumViewHolderMove.delete.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("delete_forum", this.mContext));
            if (!paramBoolean) {
                break label478;
            }
            localForumViewHolderMove.deleteLayout.setVisibility(0);
            label250:
            localForumViewHolderMove.deleteLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    ModerateAdapter.this.deleteForums(paramInt2, paramInt3);
                }
            });
            if ((paramForum.getLocalIconUri() == null) || (paramForum.getLocalIconUri().length() <= 0)) {
                break label491;
            }
            if (paramForum.getIcon() == null) {
                paramForum.setIcon(Util.getRemotePic(paramForum.getLocalIconUri()));
            }
            localForumViewHolderMove.icon.setImageBitmap(paramForum.getIcon());
        }
        for (; ; ) {
            if (paramInt1 != Forum.TOP_FORUM_ITEM) {
                break label505;
            }
            localForumViewHolderMove.layout.setBackgroundResource(ThemeUtil.getMoveToDrawableId("forum_top_item_bg", this.mContext));
            localForumViewHolderMove.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mContext));
            localForumViewHolderMove.diver.setVisibility(0);
            localForumViewHolderMove.icon.setPadding(0, 12, 0, 0);
            localForumViewHolderMove.delete.setPadding(0, 25, 0, 0);
            return paramView;
            localForumViewHolderMove = (ForumViewHolderMove) paramView.getTag();
            break;
            label409:
            localForumViewHolderMove.text.setTextColor(this.mContext.getResources().getColor(ThemeUtil.getTextColor(this.mContext)));
            break label182;
            label437:
            localForumViewHolderMove.text.setTextColor(this.mContext.getResources().getColor(ThemeUtil.getTextColor(this.mContext)));
            break label182;
            label465:
            localForumViewHolderMove.text.setTypeface(null, 0);
            break label206;
            label478:
            localForumViewHolderMove.deleteLayout.setVisibility(8);
            break label250;
            label491:
            localForumViewHolderMove.icon.setImageResource(2130837860);
        }
        label505:
        if (paramInt1 == Forum.BOTTOM_FORUM_ITEM) {
            localForumViewHolderMove.layout.setBackgroundResource(ThemeUtil.getMoveToDrawableId("forum_bottom_item_bg", this.mContext));
            localForumViewHolderMove.diver.setVisibility(8);
            return paramView;
        }
        localForumViewHolderMove.layout.setBackgroundResource(ThemeUtil.getMoveToDrawableId("forum_mid_item_bg", this.mContext));
        localForumViewHolderMove.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mContext));
        localForumViewHolderMove.diver.setVisibility(0);
        localForumViewHolderMove.icon.setPadding(0, 8, 0, 0);
        localForumViewHolderMove.delete.setPadding(0, 3, 0, 0);
        return paramView;
    }

    public Forum getParentForum(Forum paramForum) {
        if (paramForum.getParentForum() != null) {
            getParentForum(paramForum.getParentForum());
        }
        return paramForum;
    }

    public void getRecentForum() {
        this.recentDatas = ((ArrayList) AppCacheManager.getCacheData(this.recentCacheFile));
        if ((this.recentDatas != null) && (this.recentDatas.size() > 0)) {
            GroupBean localGroupBean = new GroupBean(this.RecentTitile);
            this.groupList.add(0, localGroupBean);
            ((GroupBean) this.groupList.get(0)).setChildrenList(this.recentDatas);
        }
        notifyDataSetChanged();
    }

    public boolean getSaxCall() {
        return false;
    }

    public String getTargetForumId() {
        return this.targetForumId;
    }

    public String getTargetForumName() {
        return this.targetForumName;
    }

    public boolean getTryTwice() {
        return this.tryTwice.booleanValue();
    }

    public View getView(Forum paramForum, int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {
        if (paramInt2 == 0) {
            return getForumViewForMove(Forum.TOP_FORUM_ITEM, (Forum) getChild(paramInt1, paramInt2), paramView, paramBoolean, paramInt1, paramInt2);
        }
        if (paramInt2 == getChildrenCount(paramInt1) - 1) {
            return getForumViewForMove(Forum.BOTTOM_FORUM_ITEM, (Forum) getChild(paramInt1, paramInt2), paramView, paramBoolean, paramInt1, paramInt2);
        }
        return getForumViewForMove(Forum.MID_FORUM_ITEM, paramForum, paramView, paramBoolean, paramInt1, paramInt2);
    }

    public void initGroup() {
        if (this.groupList == null) {
            this.groupList = new ArrayList();
        }
        this.groupList.clear();
        getRecentForum();
        GroupBean localGroupBean = new GroupBean(this.AllForumTitle);
        this.groupList.add(localGroupBean);
        this.sectionTitle.add(this.AllForumTitle);
    }

    public void initMergePostGroup() {
        if (this.groupList == null) {
            this.groupList = new ArrayList();
        }
        this.groupList.clear();
        this.mergePostGroupBean = new GroupBean(this.postListTitle);
        this.groupTreeView.setmHeaderViewVisible(false);
        this.sectionTitle.add(this.postListTitle);
    }

    public void initMergeTopicGroup() {
        if (this.groupList == null) {
            this.groupList = new ArrayList();
        }
        this.groupList.clear();
        this.mergeTopicGroupBean = new GroupBean(this.topicListTitle);
        this.groupTreeView.setmHeaderViewVisible(false);
        this.sectionTitle.add(this.topicListTitle);
    }

    public boolean isForumGuestOk() {
        return this.guest_okay.booleanValue();
    }

    public boolean isOpCancel() {
        return this.isOpCancel;
    }

    public void mergeTopic(String paramString1, String paramString2) {
        if ((this.forumStatus.isSMF()) || (this.forumStatus.isSMF1()) || (this.forumStatus.isSMF2()) || (this.forumStatus.isIP())) {
            if (Integer.parseInt(paramString1) > Integer.parseInt(paramString2)) {
                this.mergedTopicId = paramString2;
            }
        }
        for (; ; ) {
            setTryTwice(false);
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramString1);
            localArrayList.add(paramString2);
            if (this.forumStatus.isSupportAdvanceMerge()) {
                localArrayList.add(Boolean.valueOf(this.isRedirect));
            }
            this.engine.call("m_merge_topic", localArrayList);
            notifyDataSetChanged();
            return;
            this.mergedTopicId = paramString1;
            continue;
            this.mergedTopicId = paramString2;
        }
    }

    public void movePost(String paramString1, String paramString2, String paramString3) {
        this.topicTitle = paramString3;
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString1);
        localArrayList.add("");
        localArrayList.add(paramString3.getBytes());
        localArrayList.add(paramString2);
        this.engine.call("m_move_post", localArrayList);
        notifyDataSetChanged();
    }

    public void moveTopic(String paramString1, String paramString2) {
        ArrayList localArrayList = new ArrayList();
        setTryTwice(false);
        localArrayList.add(paramString1);
        localArrayList.add(paramString2);
        this.engine.call("m_move_topic", localArrayList);
        notifyDataSetChanged();
    }

    public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong) {
        if ((paramInt1 == 3) && (paramInt2 >= this.forumGroupBean.getChildrenList().size())) {
        }
        label149:
        do {
            do {
                return true;
                if (!(getChild(paramInt1, paramInt2) instanceof Forum)) {
                    break label149;
                }
                paramExpandableListView = (Forum) getChild(paramInt1, paramInt2);
                this.currentForum = paramExpandableListView;
                this.forum_id.add(paramExpandableListView.getId());
                this.forumDatas.put("forumId|" + paramExpandableListView.getId(), paramExpandableListView);
                if (paramInt1 != this.groupList.size() - 1) {
                    break;
                }
                setOnItemClick(paramExpandableListView);
            }
            while ((!(this.mContext instanceof SlidingMenuActivity)) || (!((SlidingMenuActivity) this.mContext).isShare));
            this.mContext.invalidateOptionsMenu();
            return true;
            setNoChildFroumsClick(paramExpandableListView);
            return true;
        } while (!(getChild(paramInt1, paramInt2) instanceof Topic));
        paramExpandableListView = (Topic) getChild(paramInt1, paramInt2);
        paramView = new Intent(this.mContext, MergeTopicSettingActivity.class);
        paramView.putExtra("first_topic", ((ModerateActivity) this.mContext).mTopic);
        paramView.putExtra("forum_name", paramExpandableListView.getForumName());
        paramView.putExtra("second_topic", paramExpandableListView);
        paramView.putExtra("forumStatus", this.forumStatus);
        this.mContext.startActivityForResult(paramView, 601);
        return true;
    }

    public void recallAfterLoginMod() {
        if (this.engine != null) {
            ((ForumActivityStatus) this.mContext).showProgress();
            ForumCookiesCache localForumCookiesCache = new ForumCookiesCache();
            localForumCookiesCache.writeTime = System.currentTimeMillis();
            localForumCookiesCache.saveForTime = 1800000L;
            localForumCookiesCache.cookies = this.forumStatus.cookies;
            AppCacheManager.cacheForumCookiesData(this.cookieCacheUrl, localForumCookiesCache);
            this.engine.reCall();
        }
    }

    public void renameTopic() {
        ArrayList localArrayList = new ArrayList();
        if ((this.forumStatus.isSMF()) || (this.forumStatus.isSMF1()) || (this.forumStatus.isSMF2()) || (this.forumStatus.isIP())) {
            localArrayList.add(this.mergedTopicId);
        }
        for (; ; ) {
            localArrayList.add(this.newTopicName.getBytes());
            this.engine.call("m_rename_topic", localArrayList);
            ((ForumActivityStatus) this.mContext).showProgress();
            notifyDataSetChanged();
            return;
            localArrayList.add(this.mergedTopic.getId());
        }
    }

    public void retryLogin(HashMap paramHashMap) {
        if ((paramHashMap.containsKey("is_login_mod")) && (!((Boolean) paramHashMap.get("is_login_mod")).booleanValue())) {
            DialogUtil.getLoginModDialog(this.mContext, this.forumStatus, this).show();
        }
    }

    public void saveRecentForums() {
        int i = 0;
        for (; ; ) {
            if (i >= this.recentForums.size()) {
                AppCacheManager.cacheData(this.recentCacheFile, this.recentDatas);
                return;
            }
            Forum localForum = getParentForum((Forum) this.recentForums.get(i));
            if (this.recentDatas == null) {
                this.recentDatas = new ArrayList();
            }
            if ((this.recentDatas != null) && (!this.recentDatas.contains(localForum))) {
                this.recentDatas.add(localForum);
            }
            i += 1;
        }
    }

    public void setNoChildFroumsClick(Forum paramForum) {
        if ((this.mContext instanceof ModerateActivity)) {
            if (((ModerateActivity) this.mContext).select_forum_action == 0) {
                startNewTopic(paramForum);
                this.recentForums.add(paramForum);
                saveRecentForums();
            }
        }
        do {
            do {
                do {
                    return;
                    if (((ModerateActivity) this.mContext).select_forum_action == 2) {
                        setTargetForumName(paramForum.getName());
                        setTargetForumId(paramForum.getId());
                        this.groupTreeView.invalidate();
                        this.mContext.showDialog(80);
                        return;
                    }
                    if (((ModerateActivity) this.mContext).select_forum_action == 3) {
                        setTargetForumName(paramForum.getName());
                        setTargetForumId(paramForum.getId());
                        this.groupTreeView.invalidate();
                        this.mContext.showDialog(81);
                        return;
                    }
                } while (((ModerateActivity) this.mContext).select_forum_action != 6);
                setTargetForumName(paramForum.getName());
                setTargetForumId(paramForum.getId());
                this.groupTreeView.invalidate();
                this.mContext.showDialog(82);
                return;
                if (!(this.mContext instanceof SlidingMenuActivity)) {
                    break;
                }
            } while (!((SlidingMenuActivity) this.mContext).isShare);
            startNewTopic(paramForum);
            this.mContext.finish();
            return;
        } while (!(this.mContext instanceof CategoryActivity));
        Bundle localBundle = new Bundle();
        localBundle.putString("forum_name", paramForum.getName());
        localBundle.putString("forum_id", paramForum.getId());
        paramForum = this.mContext.getIntent();
        paramForum.putExtras(localBundle);
        this.mContext.setResult(-1, paramForum);
        this.mContext.finish();
    }

    public void setOnItemClick(Forum paramForum) {
        Object localObject1;
        int i;
        Object localObject2;
        if ((paramForum.getChildForums() != null) && (paramForum.getChildForums().size() > 0)) {
            this.forumStack.push(this.mDatas);
            this.sectionTitle.add(paramForum.getName());
            this.mDatas = paramForum.getChildForums();
            localObject1 = new ArrayList();
            i = 0;
            if (i >= this.mDatas.size()) {
                this.groupList.clear();
                localObject2 = new GroupBean(paramForum.getName());
                this.groupList.add(localObject2);
                ((GroupBean) this.groupList.get(this.groupList.size() - 1)).setChildrenList((ArrayList) localObject1);
                if ((this.mContext instanceof CategoryActivity)) {
                    setTargetForumName(paramForum.getName());
                    setTargetForumId(paramForum.getId());
                    ((CategoryActivity) this.mContext).setTargetForum(paramForum.getName());
                }
                notifyDataSetChanged();
                label167:
                if (!(this.mContext instanceof ModerateActivity)) {
                    break label450;
                }
                if ((!paramForum.isSubOnly()) && (((ModerateActivity) this.mContext).mTopic != null)) {
                    if (paramForum.getName().equalsIgnoreCase(((ModerateActivity) this.mContext).mTopic.getForumName())) {
                        break label430;
                    }
                    setTargetForumName(paramForum.getName());
                    ((ModerateActivity) this.mContext).setTargetForum(getTargetForumName());
                    setTargetForumId(paramForum.getId());
                }
            }
        }
        label430:
        label450:
        while (!(this.mContext instanceof SlidingMenuActivity)) {
            for (; ; ) {
                return;
                if ((((Forum) this.mDatas.get(i)).getUrl() == null) || (((Forum) this.mDatas.get(i)).getUrl().length() <= 0)) {
                    ((ArrayList) localObject1).add((Forum) this.mDatas.get(i));
                }
                i += 1;
                break;
                if ((this.mContext instanceof CategoryActivity)) {
                    localObject1 = new Bundle();
                    ((Bundle) localObject1).putString("forum_name", paramForum.getName());
                    ((Bundle) localObject1).putString("forum_id", paramForum.getId());
                    localObject2 = this.mContext.getIntent();
                    ((Intent) localObject2).putExtras((Bundle) localObject1);
                    this.mContext.setResult(-1, (Intent) localObject2);
                    this.mContext.finish();
                    break label167;
                }
                if (!(this.mContext instanceof ModerateActivity)) {
                    break label167;
                }
                setTargetForumName(paramForum.getName());
                setTargetForumId(paramForum.getId());
                ((ModerateActivity) this.mContext).setTargetForum(getTargetForumName());
                break label167;
                setTargetForumName(((ModerateActivity) this.mContext).mTopic.getForumName());
            }
        }
        if ((((SlidingMenuActivity) this.mContext).currentFragment instanceof ModerateFragment)) {
            ((ModerateFragment) ((SlidingMenuActivity) this.mContext).currentFragment).textView.setVisibility(0);
            ((ModerateFragment) ((SlidingMenuActivity) this.mContext).currentFragment).textView.setText(this.mContext.getApplicationContext().getString(2131100585) + paramForum.getName());
        }
        setTargetForumName(paramForum.getName());
        setTargetForumId(paramForum.getId());
    }

    public void setOpCancel(boolean paramBoolean) {
        this.isOpCancel = paramBoolean;
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTargetForumId(String paramString) {
        this.targetForumId = paramString;
    }

    public void setTargetForumName(String paramString) {
        this.targetForumName = paramString;
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = Boolean.valueOf(paramBoolean);
    }

    public void startNewTopic(Forum paramForum) {
        if (paramForum != null) {
            Intent localIntent = new Intent(this.mContext, CreateTopicActivity.class);
            localIntent.setAction("android.intent.action.PICK");
            localIntent.putExtra("forumStatus", this.forumStatus);
            localIntent.putExtra("forumid", paramForum.getId());
            localIntent.putExtra("canUpload", true);
            localIntent.putExtra("forum", this.forumStatus.tapatalkForum);
            if ((this.mContext instanceof SlidingMenuActivity)) {
                localIntent.putExtra("isShare", ((SlidingMenuActivity) this.mContext).isShare);
            }
            this.mContext.startActivityForResult(localIntent, 1);
        }
    }

    public void tabChange(int paramInt) {
        if ((paramInt == 0) && (this.is_flatten.booleanValue())) {
            GoogleAnalyticsTools.trackPageView(this.mContext, "forum/all", this.forumStatus.getForumId(), this.forumStatus.getUrl());
            this.is_flatten = Boolean.valueOf(false);
            ((GroupBean) this.groupList.get(this.groupList.size() - 1)).setChildrenList(this.mDatas);
            notifyDataSetChanged();
        }
        while ((paramInt != 1) || (this.is_flatten.booleanValue())) {
            return;
        }
        GoogleAnalyticsTools.trackPageView(this.mContext, "forum/name", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        this.is_flatten = Boolean.valueOf(true);
        ((GroupBean) this.groupList.get(this.groupList.size() - 1)).setChildrenList(this.flattenForumList);
        notifyDataSetChanged();
    }

    public void tryFailed(String paramString) {
    }

    public void updateForum() {
        this.forum_id.clear();
        if (AppCacheManager.checkFile(this.cacheFile)) {
        }
        try {
            localArrayList = (ArrayList) AppCacheManager.getCacheData(this.cacheFile);
            i = 0;
            if (i < localArrayList.size()) {
                break label117;
            }
            if (this.mDatas != null) {
                getFlattenList(this.mDatas);
            }
            Collections.sort(this.flattenForumList, this.comp);
            ((GroupBean) this.groupList.get(this.groupList.size() - 1)).setChildrenList(this.mDatas);
            ((ForumActivityStatus) this.mContext).closeProgress();
            notifyDataSetChanged();
        } catch (Exception localException) {
            ArrayList localArrayList;
            int i;
            label117:
            for (; ; ) {
            }
        }
        i = 0;
        for (; ; ) {
            if (i >= getGroupCount()) {
                return;
                if ((((Forum) localArrayList.get(i)).getUrl() == null) || (((Forum) localArrayList.get(i)).getUrl().length() <= 0)) {
                    this.mDatas.add((Forum) localArrayList.get(i));
                }
                i += 1;
                break;
            }
            this.groupTreeView.expandGroup(i);
            i += 1;
        }
    }

    public void updatePostDatas(ArrayList<PostData> paramArrayList) {
        this.mergePostGroupBean.setChildrenList(paramArrayList);
        int i = 0;
        for (; ; ) {
            if (i >= getGroupCount()) {
                notifyDataSetChanged();
                this.groupTreeView.setLoadingMoreEnabled(false);
                return;
            }
            this.groupTreeView.expandGroup(i);
            i += 1;
        }
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateTopicDatas() {
        Forum localForum = ((ModerateActivity) this.mContext).mTopic.getForum();
        this.isLoadmore = true;
        this.getTopicAction = new GetTopicAction(this.mContext, this.forumStatus, localForum, true, new GetTopicAction.UpdateTopic() {
            public void update(ArrayList<Object> paramAnonymousArrayList, boolean paramAnonymousBoolean) {
                ModerateAdapter.this.isLoadmore = false;
                ModerateAdapter.this.list = new ArrayList();
                int i = 0;
                if (i >= paramAnonymousArrayList.size()) {
                    if (paramAnonymousArrayList.size() <= 0) {
                        break label242;
                    }
                    if (!ModerateAdapter.this.groupList.contains(ModerateAdapter.this.mergeTopicGroupBean)) {
                        ModerateAdapter.this.groupList.add(ModerateAdapter.this.mergeTopicGroupBean);
                    }
                    ((ModerateActivity) ModerateAdapter.this.mContext).fragment.noResultDatas.setVisibility(8);
                    label98:
                    ModerateAdapter.this.mergeTopicGroupBean.setChildrenList(ModerateAdapter.this.list);
                    i = 0;
                }
                for (; ; ) {
                    if (i >= ModerateAdapter.this.getGroupCount()) {
                        ModerateAdapter.this.notifyDataSetChanged();
                        ModerateAdapter.this.groupTreeView.setLoadingMoreEnabled(false);
                        return;
                        if (((paramAnonymousArrayList.get(i) instanceof Topic)) && (((Topic) paramAnonymousArrayList.get(i)).isCanMerge()) && (!((Topic) paramAnonymousArrayList.get(i)).getId().equals(((ModerateActivity) ModerateAdapter.this.mContext).mTopic.getId())) && (!((Topic) paramAnonymousArrayList.get(i)).isRedirect())) {
                            ModerateAdapter.this.list.add(paramAnonymousArrayList.get(i));
                        }
                        i += 1;
                        break;
                        label242:
                        if (!(ModerateAdapter.this.mContext instanceof ModerateActivity)) {
                            break label98;
                        }
                        ((ModerateActivity) ModerateAdapter.this.mContext).fragment.noResultDatas.setVisibility(0);
                        break label98;
                    }
                    ModerateAdapter.this.groupTreeView.expandGroup(i);
                    i += 1;
                }
            }
        });
    }

    private static class ForumViewHolderMove {
        ImageView delete;
        LinearLayout deleteLayout;
        ImageView diver;
        ImageView icon;
        RelativeLayout layout;
        TextView text;
    }

    private class Mycomparator
            implements Comparator<Object> {
        private Mycomparator() {
        }

        public int compare(Forum paramForum1, Forum paramForum2) {
            return paramForum1.getName().compareTo(paramForum2.getName());
        }

        public int compare(Object paramObject1, Object paramObject2) {
            return ((Forum) paramObject1).getName().compareTo(((Forum) paramObject2).getName());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/moderation/ModerateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */