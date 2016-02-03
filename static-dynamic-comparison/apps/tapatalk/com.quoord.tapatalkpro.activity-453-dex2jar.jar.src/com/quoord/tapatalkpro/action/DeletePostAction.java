package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.app.Dialog;
import com.quoord.DialogUtil.DialogUtil;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerationInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ForumCookiesCache;
import com.quoord.tapatalkpro.ui.ThreadQuoteHelper;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class DeletePostAction
        implements TryTwiceCallBackInterface, ModerationInterface {
    private static ArrayList<PostData> Datas;
    private boolean allRecall = true;
    private int callNum = 0;
    private String cookieCacheUrl;
    private String currentPostFiles;
    private TapatalkEngine engine;
    private ForumStatus forumStatus;
    private boolean isRecall = false;
    private Activity mActivity;
    private Topic mCurrentTopic;
    private ArrayList<PostData> postDatas;
    private String reasonStr;
    private ThreadAdapter threadAdapter;
    private int type;

    public DeletePostAction(Activity paramActivity, ForumStatus paramForumStatus, ThreadAdapter paramThreadAdapter, ArrayList<PostData> paramArrayList, Topic paramTopic) {
        this.mActivity = paramActivity;
        this.forumStatus = paramForumStatus;
        this.threadAdapter = paramThreadAdapter;
        this.postDatas = paramArrayList;
        this.mCurrentTopic = paramTopic;
        this.cookieCacheUrl = AppCacheManager.getModerateCookieCacheUrl(paramActivity, this.forumStatus.tapatalkForum.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
        this.currentPostFiles = AppCacheManager.getPostDatasFile(this.mActivity);
        AppCacheManager.cacheData(this.currentPostFiles, paramArrayList);
        paramForumStatus = AppCacheManager.getForumCookiesData(this.cookieCacheUrl);
        if ((paramForumStatus != null) && (paramForumStatus.cookies != null)) {
            this.forumStatus.cookies = paramForumStatus.cookies;
            this.forumStatus.loginExpire = false;
        }
        DialogUtil.getMuitlDeletePostDialog(this.mActivity, this.forumStatus, this.mCurrentTopic, this.threadAdapter, this.postDatas, this).show();
        this.engine = new TapatalkEngine(this, this.forumStatus, paramActivity);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        paramEngineResponse.getMethod();
        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
        this.isRecall = ((Boolean) paramEngineResponse.get("result")).booleanValue();
        retryLogin(paramEngineResponse);
        if ((this.threadAdapter.mOutFragment != null) && (this.threadAdapter.mOutFragment.quoteHelper != null)) {
            this.threadAdapter.mOutFragment.quoteHelper.actionFinish();
        }
        this.callNum += 1;
        if (this.callNum == this.postDatas.size() + 1) {
            if (!this.isRecall) {
                break label146;
            }
            Util.showToastForLong(this.mActivity, this.mActivity.getString(2131100025));
        }
        for (; ; ) {
            this.threadAdapter.refresh();
            this.threadAdapter.notifyDataSetChanged();
            ((ForumActivityStatus) this.mActivity).closeProgress();
            return;
            label146:
            paramEngineResponse = new String((byte[]) paramEngineResponse.get("result_text")).toString();
            Util.showToastForLong(this.mActivity, paramEngineResponse);
        }
    }

    public void deletePost(String paramString, int paramInt, ArrayList<PostData> paramArrayList) {
        this.reasonStr = paramString;
        this.type = paramInt;
        this.postDatas = paramArrayList;
        if ((AppCacheManager.checkFile(this.currentPostFiles)) && ((this.postDatas == null) || (this.postDatas.size() <= 0))) {
            this.postDatas = ((ArrayList) AppCacheManager.getCacheData(this.currentPostFiles));
        }
        ((ForumActivityStatus) this.mActivity).showProgress();
        int i = 0;
        for (; ; ) {
            if (i >= this.postDatas.size()) {
                label83:
                return;
            }
            this.mCurrentTopic.setDeleted(true);
            paramArrayList = new ArrayList();
            paramArrayList.add(((PostData) this.postDatas.get(i)).getPostId());
            paramArrayList.add(Integer.valueOf(paramInt));
            if (paramString != null) {
            }
            try {
                paramArrayList.add(paramString.getBytes("UTF-8"));
                this.engine.call("m_delete_post", paramArrayList);
                if (!this.isRecall) {
                    break label83;
                }
                i += 1;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                    paramArrayList.add(paramString.getBytes());
                }
            }
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void recallAfterLoginMod() {
        if (this.engine != null) {
            ((ForumActivityStatus) this.mActivity).showProgress();
            ForumCookiesCache localForumCookiesCache = new ForumCookiesCache();
            localForumCookiesCache.writeTime = System.currentTimeMillis();
            localForumCookiesCache.saveForTime = 1800000L;
            localForumCookiesCache.cookies = this.forumStatus.cookies;
            AppCacheManager.cacheForumCookiesData(this.cookieCacheUrl, localForumCookiesCache);
            if ((AppCacheManager.checkFile(this.currentPostFiles)) && (Datas == null)) {
                Datas = (ArrayList) AppCacheManager.getCacheData(this.currentPostFiles);
            }
            deletePost(this.reasonStr, this.type, Datas);
        }
    }

    public void retryLogin(HashMap paramHashMap) {
        if (paramHashMap.containsKey("is_login_mod")) {
            if (!((Boolean) paramHashMap.get("is_login_mod")).booleanValue()) {
                DialogUtil.getLoginModDialog(this.mActivity, this.forumStatus, this).show();
            }
        }
        while (!this.allRecall) {
            do {
                return;
            } while (!this.allRecall);
            paramHashMap = new ArrayList();
            i = 1;
            for (; ; ) {
                if (i >= this.postDatas.size()) {
                    deletePost(this.reasonStr, this.type, paramHashMap);
                    this.allRecall = false;
                    return;
                }
                paramHashMap.add((PostData) this.postDatas.get(i));
                i += 1;
            }
        }
        paramHashMap = new ArrayList();
        int i = 1;
        for (; ; ) {
            if (i >= this.postDatas.size()) {
                deletePost(this.reasonStr, this.type, paramHashMap);
                this.allRecall = false;
                return;
            }
            paramHashMap.add((PostData) this.postDatas.get(i));
            i += 1;
        }
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/DeletePostAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */