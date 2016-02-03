package com.quoord.tapatalkpro.action;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.activity.forum.CreateTopicActivity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.ads.AdBean;
import com.quoord.tapatalkpro.ads.AdsService;
import com.quoord.tapatalkpro.bean.Banner;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicParser;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.topics.TopicImageAction;
import com.quoord.tapatalkpro.ics.topics.TopicImageAction.TopicImageCallBack;
import com.quoord.tapatalkpro.ui.NewTopicView;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.net.HashUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class GetTopicAction
        implements TryTwiceCallBackInterface, TopicImageAction.TopicImageCallBack {
    private ArrayList<Object> annDatas = new ArrayList();
    public boolean canPost = false;
    public boolean canUpload = true;
    public TapatalkEngine engine = null;
    public ForumStatus forumStatus;
    private GetAnnTopicAction getAnnTopicAction;
    private GetStickTopicAction getStickTopicAction;
    protected boolean isOpCancel = false;
    private boolean isSaxCall = false;
    private boolean isShowMerge = false;
    public boolean loadingMore = false;
    public ArrayList<Forum> mChildForums = new ArrayList();
    private Activity mContext;
    private int mCountPerpage = 20;
    private ArrayList<Object> mDatas = new ArrayList();
    private Forum mForum;
    public ArrayList<HashMap<String, Object>> mPrefixes = new ArrayList();
    public int mStart = 0;
    private NewTopicView newTopicView;
    public Boolean requiredPrefix = Boolean.valueOf(false);
    public boolean showNewMenu = false;
    private ArrayList<Object> stickyDatas = new ArrayList();
    public int title;
    private ArrayList<Object> topicDatas = new ArrayList();
    private ArrayList<String> topicIds = new ArrayList();
    private TopicImageAction topicImageCall;
    public int total_topic_num;
    private Boolean tryTwice = Boolean.valueOf(false);
    private UpdateTopic updateTopic;
    private String userNameCacheAddress = "";
    public HashMap<String, String> userNameList;

    public GetTopicAction(Activity paramActivity, ForumStatus paramForumStatus, Forum paramForum, boolean paramBoolean, UpdateTopic paramUpdateTopic) {
        this.mContext = paramActivity;
        this.mForum = paramForum;
        this.forumStatus = paramForumStatus;
        this.updateTopic = paramUpdateTopic;
        this.isShowMerge = paramBoolean;
        if (this.forumStatus.getApiLevel() >= 4) {
            this.canPost = false;
        }
        this.newTopicView = new NewTopicView();
        this.userNameCacheAddress = AppCacheManager.getForumUseNameUrl(paramActivity, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getLowerUserName());
        paramForumStatus = AppCacheManager.getCacheData(this.userNameCacheAddress);
        if (paramForumStatus == null) {
            this.userNameList = new HashMap();
            this.engine = new TapatalkEngine(this, this.forumStatus, paramActivity);
            getSubForums();
            if ((this.mForum == null) || (this.mForum.isSubOnly())) {
                break label344;
            }
            getTopics();
        }
        for (; ; ) {
            this.topicImageCall = new TopicImageAction(paramActivity, this);
            return;
            if ((paramForumStatus instanceof HashMap)) {
                this.userNameList = ((HashMap) paramForumStatus);
                break;
            }
            this.userNameList = new HashMap();
            break;
            label344:
            this.updateTopic.update(this.mDatas, true);
        }
    }

    public static ArrayList<HashMap<String, String>> getPrefixForCreateTopic(Context paramContext, ArrayList<HashMap<String, Object>> paramArrayList, boolean paramBoolean) {
        ArrayList localArrayList = new ArrayList();
        Object localObject;
        if (!paramBoolean) {
            localObject = new HashMap();
            paramContext = paramContext.getString(2131099967);
            ((HashMap) localObject).put("prefix_id", paramContext);
            ((HashMap) localObject).put("prefix_name", paramContext);
            localArrayList.add(localObject);
        }
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                return localArrayList;
            }
            localObject = (HashMap) paramArrayList.get(i);
            paramContext = HashUtil.getString(((HashMap) localObject).get("prefix_display_name"), "");
            localObject = HashUtil.getString(((HashMap) localObject).get("prefix_id"), "");
            HashMap localHashMap = new HashMap();
            localHashMap.put("prefix_id", localObject);
            localHashMap.put("prefix_name", paramContext);
            localArrayList.add(localHashMap);
            i += 1;
        }
    }

    private void newTopic(int paramInt) {
        Intent localIntent = new Intent(this.mContext, CreateTopicActivity.class);
        localIntent.setAction("android.intent.action.PICK");
        localIntent.putExtra("forumStatus", this.forumStatus);
        localIntent.putExtra("forumid", this.mForum.getId());
        localIntent.putExtra("canUpload", this.canUpload);
        if (hasPrefix()) {
            localIntent.putExtra("prefixes", getPrefixForCreateTopic(this.mContext, this.mPrefixes, this.requiredPrefix.booleanValue()));
            if (paramInt != -1) {
                localIntent.putExtra("prefixIndex", paramInt);
            }
        }
        this.mContext.startActivityForResult(localIntent, 1);
    }

    public void addBanner(Activity paramActivity, ArrayList<Object> paramArrayList) {
        if ((this.forumStatus != null) && (this.forumStatus.isAdShow()) && (this.forumStatus.getRebrandingConfig() != null) && (((this.forumStatus.getRebrandingConfig().getDfp_320x50() != null) && (!this.forumStatus.getRebrandingConfig().getDfp_320x50().equals(""))) || ((this.forumStatus.getRebrandingConfig().getAdmobId() != null) && (!this.forumStatus.getRebrandingConfig().getAdmobId().equals(""))))) {
            Banner.addBanner(paramActivity, paramArrayList);
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        final Object localObject = paramEngineResponse.getMethod();
        if ((paramEngineResponse.isSuccess()) && (((String) localObject).equals("get_topic"))) {
            this.topicDatas.clear();
            this.loadingMore = false;
            this.mStart += this.mCountPerpage;
            localObject = (HashMap) paramEngineResponse.getResponse();
            paramEngineResponse = (Object[]) ((HashMap) localObject).get("topics");
            i = ((Integer) ((HashMap) localObject).get("total_topic_num")).intValue();
            this.total_topic_num = (this.annDatas.size() + i + this.stickyDatas.size());
        }
        try {
            if (((HashMap) localObject).containsKey("require_prefix")) {
                if (!((Boolean) ((HashMap) localObject).get("require_prefix")).booleanValue()) {
                    break label502;
                }
                this.requiredPrefix = Boolean.valueOf(true);
            }
        } catch (Exception localException2) {
            try {
                if (((HashMap) localObject).containsKey("can_post")) {
                    if (!((Boolean) ((HashMap) localObject).get("can_post")).booleanValue()) {
                        break label518;
                    }
                    this.canPost = true;
                }
            } catch (Exception localException2) {
                try {
                    label175:
                    if (((HashMap) localObject).containsKey("can_upload")) {
                        if (!((Boolean) ((HashMap) localObject).get("can_upload")).booleanValue()) {
                            break label531;
                        }
                        this.canUpload = true;
                        if (this.forumStatus != null) {
                            this.forumStatus.setCan_upload_attachment_post(true);
                        }
                    }
                    for (; ; ) {
                        try {
                            if (!((HashMap) localObject).containsKey("prefixes")) {
                                continue;
                            }
                            arrayOfObject = (Object[]) ((HashMap) localObject).get("prefixes");
                            if (this.mPrefixes.size() <= 0) {
                                continue;
                            }
                            this.mPrefixes.clear();
                        } catch (Exception localException4) {
                            Object[] arrayOfObject;
                            int j;
                            label502:
                            label518:
                            label531:
                            AdBean localAdBean;
                            continue;
                            i = 0;
                            continue;
                        }
                        j = arrayOfObject.length;
                        if (i < j) {
                            continue;
                        }
                        if (((HashMap) localObject).containsKey("forum_name")) {
                            localObject = new String((byte[]) ((HashMap) localObject).get("forum_name"));
                            new Handler().postAtTime(new Runnable() {
                                public void run() {
                                    GetTopicAction.this.mContext.getActionBar().setTitle(localObject);
                                }
                            }, 300L);
                        }
                        if ((paramEngineResponse != null) && (paramEngineResponse.length > 0)) {
                            i = 0;
                            if (i < paramEngineResponse.length) {
                                continue;
                            }
                        }
                        if (this.forumStatus.tapatalkForum.isHasImage()) {
                            if (Util.is2GState(this.mContext)) {
                                continue;
                            }
                            if (SettingsFragment.isEnableTopicImg(this.mContext)) {
                                this.topicImageCall.getTopicImgUrl(this.forumStatus.tapatalkForum.getId().toString(), this.topicIds);
                                this.topicIds.clear();
                            }
                        }
                        AppCacheManager.cacheData(this.userNameCacheAddress, this.userNameList);
                        if ((paramEngineResponse != null) && (paramEngineResponse.length > 0) && (this.topicDatas.size() > 0)) {
                            this.mDatas.addAll(this.topicDatas);
                        }
                        if ((this.canPost) && (!this.mDatas.contains(this.newTopicView))) {
                            this.mDatas.add(0, this.newTopicView);
                        }
                        this.updateTopic.update(this.mDatas, true);
                        return;
                        this.requiredPrefix = Boolean.valueOf(false);
                        break;
                        localException1 = localException1;
                        break;
                        this.canPost = false;
                        break label175;
                        localException2 = localException2;
                        break label175;
                        this.canUpload = false;
                        if (this.forumStatus != null) {
                            this.forumStatus.setCan_upload_attachment_post(false);
                        }
                    }
                } catch (Exception localException3) {
                    for (; ; ) {
                        continue;
                        this.mPrefixes.add((HashMap) localException3[i]);
                        i += 1;
                        continue;
                        localObject = TopicParser.createTopicBean((HashMap) paramEngineResponse[i], this.mForum.getName(), this.mContext, this.forumStatus);
                        if (AdsService.isAddon) {
                            if (AdsService.showAdmode(this.mContext) != AdsService.SHOWNATIVE) {
                                break label704;
                            }
                            if (this.topicDatas.size() % AdsService.perAds == 1) {
                                localAdBean = AdsService.getAdBean(this.forumStatus.tapatalkForum.getId().intValue());
                                if (localAdBean != null) {
                                    this.topicDatas.add(localAdBean);
                                }
                            }
                        }
                        for (; ; ) {
                            this.topicIds.add(((Topic) localObject).getId());
                            this.topicDatas.add(localObject);
                            i += 1;
                            break;
                            label704:
                            if ((this.topicDatas != null) && (this.topicDatas.size() == 1)) {
                                addBanner(this.mContext, this.topicDatas);
                            }
                        }
                        if (SettingsFragment.isEnableTopicImgWithSlowConn(this.mContext)) {
                            this.topicImageCall.getTopicImgUrl(this.forumStatus.tapatalkForum.getId().toString(), this.topicIds);
                            this.topicIds.clear();
                        }
                    }
                }
            }
        }
    }

    public boolean canPost() {
        return this.canPost;
    }

    public boolean canUpload() {
        return this.canUpload;
    }

    public void cleanNewPost() {
        int i = 0;
        for (; ; ) {
            if (i >= this.mDatas.size()) {
                return;
            }
            if ((this.mDatas.get(i) instanceof Topic)) {
                ((Topic) this.mDatas.get(i)).setNewPost(false);
            }
            i += 1;
        }
    }

    public void clear() {
        this.mDatas.clear();
        this.annDatas.clear();
        this.stickyDatas.clear();
        this.topicDatas.clear();
        this.topicIds.clear();
    }

    public Forum getForum() {
        return this.mForum;
    }

    public DialogFragment getPrefixDialog() {
        final String[] arrayOfString1 = new String[this.mPrefixes.size()];
        String[] arrayOfString2 = new String[this.mPrefixes.size()];
        int i = 0;
        for (; ; ) {
            if (i >= this.mPrefixes.size()) {
                new DialogFragment() {
                    public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                        new AlertDialog.Builder(GetTopicAction.this.mContext).setTitle(GetTopicAction.this.mContext.getString(2131099897)).setItems(arrayOfString1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                GetTopicAction.this.newTopic(paramAnonymous2Int);
                            }
                        }).create();
                    }
                };
            }
            HashMap localHashMap = (HashMap) this.mPrefixes.get(i);
            try {
                String str1 = new String((byte[]) localHashMap.get("prefix_display_name"), "UTF-8");
                arrayOfString1[i] = str1;
                arrayOfString2[i] = ((String) localHashMap.get("prefix_id"));
                i += 1;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                    String str2 = new String((byte[]) localHashMap.get("prefix_display_name"));
                }
            }
        }
    }

    public boolean getSaxCall() {
        return this.isSaxCall;
    }

    public void getStickAndNormalTopic() {
        this.getStickTopicAction = new GetStickTopicAction(this.forumStatus, this.mContext);
        this.getStickTopicAction.getStickTopic(this.mForum.getId(), new GetStickTopicAction.ActionCallBack() {
            public void actionCallBack(EngineResponse paramAnonymousEngineResponse) {
                int i;
                if (paramAnonymousEngineResponse.isSuccess()) {
                    paramAnonymousEngineResponse = (Object[]) ((HashMap) paramAnonymousEngineResponse.getResponse()).get("topics");
                    if ((paramAnonymousEngineResponse != null) && (paramAnonymousEngineResponse.length > 0)) {
                        i = 0;
                    }
                }
                for (; ; ) {
                    if (i >= paramAnonymousEngineResponse.length) {
                        GetTopicAction.this.mDatas.addAll(GetTopicAction.this.stickyDatas);
                        GetTopicAction.this.updateTopic.update(GetTopicAction.this.mDatas, false);
                        GetTopicAction.this.getTopic();
                        return;
                    }
                    Topic localTopic = TopicParser.createTopicBean((HashMap) paramAnonymousEngineResponse[i], GetTopicAction.this.mForum.getName(), GetTopicAction.this.mContext, GetTopicAction.this.forumStatus);
                    GetTopicAction.this.stickyDatas.add(localTopic);
                    i += 1;
                }
            }
        });
    }

    public void getSubForums() {
        this.mChildForums.clear();
        int i;
        if ((this.mForum != null) && (this.mForum.getChildForums() != null) && (this.mForum.getChildForums().size() > 0)) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.mForum.getChildForums().size()) {
                if ((this.mChildForums != null) && (!this.isShowMerge)) {
                    this.mDatas.addAll(this.mChildForums);
                    this.updateTopic.update(this.mDatas, false);
                }
                return;
            }
            Forum localForum = (Forum) this.mForum.getChildForums().get(i);
            this.mChildForums.add(localForum);
            i += 1;
        }
    }

    public void getTopic() {
        if ((this.mStart >= this.total_topic_num) && (this.mStart != 0)) {
            return;
        }
        this.loadingMore = true;
        setTryTwice(false);
        setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mForum.getId());
        localArrayList.add(Integer.valueOf(this.mStart));
        localArrayList.add(Integer.valueOf(this.mStart + this.mCountPerpage - 1));
        this.engine.call("get_topic", localArrayList);
    }

    public void getTopics() {
        if (SettingsFragment.isShowUnreadStick(this.mContext)) {
            if (this.forumStatus.isAnnouncement()) {
                this.getAnnTopicAction = new GetAnnTopicAction(this.forumStatus, this.mContext);
                this.getAnnTopicAction.getAnnTopic(this.mForum.getId(), new GetAnnTopicAction.ActionCallBack() {
                    public void actionCallBack(EngineResponse paramAnonymousEngineResponse) {
                        int i;
                        if (paramAnonymousEngineResponse.isSuccess()) {
                            paramAnonymousEngineResponse = (Object[]) ((HashMap) paramAnonymousEngineResponse.getResponse()).get("topics");
                            if ((paramAnonymousEngineResponse != null) && (paramAnonymousEngineResponse.length > 0)) {
                                i = 0;
                            }
                        }
                        for (; ; ) {
                            if (i >= paramAnonymousEngineResponse.length) {
                                GetTopicAction.this.mDatas.addAll(GetTopicAction.this.annDatas);
                                GetTopicAction.this.updateTopic.update(GetTopicAction.this.mDatas, false);
                                GetTopicAction.this.getStickAndNormalTopic();
                                return;
                            }
                            Topic localTopic = TopicParser.createTopicBean((HashMap) paramAnonymousEngineResponse[i], GetTopicAction.this.mForum.getName(), GetTopicAction.this.mContext, GetTopicAction.this.forumStatus);
                            localTopic.setAnn(true);
                            GetTopicAction.this.annDatas.add(localTopic);
                            i += 1;
                        }
                    }
                });
                return;
            }
            getStickAndNormalTopic();
            return;
        }
        getTopic();
    }

    public boolean getTryTwice() {
        return this.tryTwice.booleanValue();
    }

    public boolean hasPrefix() {
        return this.mPrefixes.size() > 0;
    }

    public void imageLoad(JSONObject paramJSONObject, AjaxStatus paramAjaxStatus) {
        int i;
        if (paramJSONObject != null) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.mDatas.size()) {
                return;
            }
            if ((this.mDatas.get(i) instanceof Topic)) {
                paramAjaxStatus = ((Topic) this.mDatas.get(i)).getId();
                if (!paramJSONObject.has(paramAjaxStatus)) {
                }
            }
            try {
                paramAjaxStatus = paramJSONObject.getString(paramAjaxStatus);
                if ((paramAjaxStatus != null) && (!paramAjaxStatus.equals(""))) {
                    ((Topic) this.mDatas.get(i)).setTopicImgUrl(paramAjaxStatus);
                }
            } catch (JSONException paramAjaxStatus) {
                for (; ; ) {
                    paramAjaxStatus.printStackTrace();
                }
            }
            i += 1;
        }
    }

    public boolean isFootNeeded() {
        return this.mStart < this.total_topic_num;
    }

    public boolean isOpCancel() {
        return this.isOpCancel;
    }

    public boolean requiredPrefix() {
        return this.requiredPrefix.booleanValue();
    }

    public void setOpCancel(boolean paramBoolean) {
        this.isOpCancel = paramBoolean;
    }

    public void setSaxCall(boolean paramBoolean) {
        this.isSaxCall = paramBoolean;
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = Boolean.valueOf(paramBoolean);
    }

    public void startNewTopic() {
        if ((this.mPrefixes == null) || (this.mPrefixes.size() == 0)) {
            this.requiredPrefix = Boolean.valueOf(false);
        }
        if (requiredPrefix()) {
            getPrefixDialog().show(this.mContext.getFragmentManager(), "dialog");
            return;
        }
        newTopic(-1);
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface UpdateTopic {
        public abstract void update(ArrayList<Object> paramArrayList, boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetTopicAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */