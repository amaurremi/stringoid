package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.ads.AdsService;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.saxparser.TopicSaxParser;
import com.quoord.tapatalkpro.saxparser.TopicSaxParser.ICallback;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class LatestTopicAction
        implements TryTwiceCallBackInterface {
    public static String LATEST = "latest";
    public static String PARTICIPATED = "participated";
    public static int SAX_CLOSE_PROGRESS = 0;
    public static int SAX_DISPLAY_ERROR = 0;
    public static int SAX_UPDATE_BEGIN = 0;
    public static int SAX_UPDATE_END = 0;
    public static int SAX_UPDATE_ITEM = 1;
    public static String UNREAD;
    public static final int latestTabId = 1;
    protected TapatalkEngine engine = null;
    private ForumStatus forumStatus = null;
    private String forumUrl = null;
    public boolean isSaxCall;
    public boolean loadingMoreLatest = false;
    private Activity mContext = null;
    public int mCountPerpage = 20;
    private String mFlag = null;
    public int mLastStart = 0;
    public TopicSaxParser mTopicParser;
    protected Handler mUIHandler;
    public String searchId = null;
    public int total_num = 0;
    private boolean tryTwice;
    private String userNameCacheAddress;
    public HashMap<String, String> userNameList;
    private String user_name = null;

    static {
        SAX_UPDATE_END = 2;
        SAX_UPDATE_BEGIN = 3;
        SAX_DISPLAY_ERROR = 4;
        UNREAD = "unread";
    }

    public LatestTopicAction(Activity paramActivity, String paramString1, String paramString2, String paramString3, ForumStatus paramForumStatus, Handler paramHandler) {
        this.mContext = paramActivity;
        this.forumUrl = paramString1;
        this.mFlag = paramString2;
        this.user_name = paramString3;
        this.forumStatus = paramForumStatus;
        this.mUIHandler = paramHandler;
        this.engine = new TapatalkEngine(this, this.forumStatus, this.mContext);
        this.userNameCacheAddress = AppCacheManager.getForumUseNameUrl(this.mContext, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getLowerUserName());
        paramActivity = AppCacheManager.getCacheData(this.userNameCacheAddress);
        if (paramActivity == null) {
            this.userNameList = new HashMap();
        }
        for (; ; ) {
            initialLatestTopicParser();
            getTopic();
            getAds();
            return;
            if ((paramActivity instanceof HashMap)) {
                this.userNameList = ((HashMap) paramActivity);
            } else {
                this.userNameList = new HashMap();
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        CallBackChecker.checkCallBack(paramEngineResponse, this.mContext, this.forumStatus, this.engine, isOpCancel(), this);
    }

    public void getAds() {
        if (this.forumStatus != null) {
            if (!this.forumStatus.isLogin()) {
                break label189;
            }
        }
        label189:
        for (; ; ) {
            if (this.forumStatus.tapatalkForum.isPRSupport().intValue() > 0) {
                int i = this.forumStatus.tapatalkForum.getIsPT();
                if ((this.mFlag != null) && (this.mFlag.equals(UNREAD))) {
                    AdsService.addAdsByPt(this.mContext, "latest", i, this.forumStatus.tapatalkForum.getId().intValue(), true, this.forumStatus);
                }
                if ((this.mFlag != null) && (this.mFlag.equals(LATEST))) {
                    AdsService.addAdsByPt(this.mContext, "latest", i, this.forumStatus.tapatalkForum.getId().intValue(), false, this.forumStatus);
                }
                if ((this.mFlag != null) && (this.mFlag.equals(PARTICIPATED))) {
                    AdsService.addAdsByPt(this.mContext, "latest", i, this.forumStatus.tapatalkForum.getId().intValue(), false, this.forumStatus);
                }
            }
            return;
        }
    }

    public boolean getSaxCall() {
        return this.isSaxCall;
    }

    public void getTopic() {
        if ((this.forumStatus != null) && (!this.forumUrl.endsWith("/"))) {
            this.forumUrl += "/";
        }
        this.loadingMoreLatest = true;
        ArrayList localArrayList = new ArrayList();
        if ((this.mFlag != null) && (this.mFlag.equals(PARTICIPATED))) {
            localArrayList.add(this.forumStatus.getCurrentUserName().getBytes());
        }
        localArrayList.add(Integer.valueOf(this.mLastStart));
        localArrayList.add(Integer.valueOf(this.mLastStart + this.mCountPerpage - 1));
        if ((this.forumStatus.isSearchIDEnabled()) && (this.searchId != null) && (this.searchId.length() > 0)) {
            localArrayList.add(this.searchId);
        }
        for (; ; ) {
            if ((this.mFlag != null) && (this.mFlag.equals(PARTICIPATED)) && (this.forumStatus.isSupportUserId()) && (this.forumStatus.getUserId() != null) && (!this.forumStatus.getUserId().equals(""))) {
                localArrayList.add(this.forumStatus.getUserId());
            }
            setTryTwice(false);
            setOpCancel(false);
            if ((this.mFlag != null) && (this.mFlag.equals(UNREAD))) {
                this.engine.saxcall(this.mTopicParser, "get_unread_topic", localArrayList);
            }
            if ((this.mFlag != null) && (this.mFlag.equals(LATEST))) {
                this.engine.saxcall(this.mTopicParser, "get_latest_topic", localArrayList);
            }
            if ((this.mFlag != null) && (this.mFlag.equals(PARTICIPATED))) {
                this.engine.saxcall(this.mTopicParser, "get_participated_topic", localArrayList);
            }
            return;
            if ((this.forumStatus.isSearchIDEnabled()) && (this.mFlag.equals(PARTICIPATED))) {
                localArrayList.add("");
            }
        }
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    protected void initialLatestTopicParser() {
        this.mTopicParser = new TopicSaxParser(this.mContext, this.forumStatus);
        this.mTopicParser.setCallback(new TopicSaxParser.ICallback() {
            public void onAddItem(Topic paramAnonymousTopic) {
                Message localMessage = LatestTopicAction.this.mUIHandler.obtainMessage();
                localMessage.what = LatestTopicAction.SAX_UPDATE_ITEM;
                localMessage.obj = paramAnonymousTopic;
                if ((paramAnonymousTopic.getAuthorDisplayName() != null) && (paramAnonymousTopic.getAuthorDisplayName().length() > 0)) {
                    LatestTopicAction.this.userNameList.put(paramAnonymousTopic.getAuthorName(), paramAnonymousTopic.getAuthorDisplayName());
                }
                for (; ; ) {
                    LatestTopicAction.this.mUIHandler.sendMessage(localMessage);
                    return;
                    LatestTopicAction.this.userNameList.put(paramAnonymousTopic.getAuthorName(), paramAnonymousTopic.getAuthorName());
                }
            }

            public void onDocBegin() {
                Message localMessage = LatestTopicAction.this.mUIHandler.obtainMessage();
                localMessage.what = LatestTopicAction.SAX_UPDATE_BEGIN;
                LatestTopicAction.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocEnd() {
                Message localMessage = LatestTopicAction.this.mUIHandler.obtainMessage();
                localMessage.what = LatestTopicAction.SAX_UPDATE_END;
                AppCacheManager.cacheData(LatestTopicAction.this.userNameCacheAddress, LatestTopicAction.this.userNameList);
                LatestTopicAction localLatestTopicAction = LatestTopicAction.this;
                localLatestTopicAction.mLastStart += LatestTopicAction.this.mCountPerpage;
                LatestTopicAction.this.mUIHandler.sendMessage(localMessage);
            }

            public void onGetResultText(String paramAnonymousString) {
                Message localMessage = LatestTopicAction.this.mUIHandler.obtainMessage();
                localMessage.what = LatestTopicAction.SAX_DISPLAY_ERROR;
                localMessage.obj = paramAnonymousString;
                LatestTopicAction.this.mUIHandler.sendMessage(localMessage);
            }

            public void onGetSearchID(String paramAnonymousString) {
                LatestTopicAction.this.searchId = paramAnonymousString;
            }

            public void onGetTopicNum(int paramAnonymousInt) {
                LatestTopicAction.this.total_num = paramAnonymousInt;
                Message localMessage = LatestTopicAction.this.mUIHandler.obtainMessage();
                localMessage.what = LatestTopicAction.SAX_CLOSE_PROGRESS;
                localMessage.obj = Integer.valueOf(LatestTopicAction.this.total_num);
                LatestTopicAction.this.mUIHandler.sendMessage(localMessage);
            }
        });
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
        this.isSaxCall = paramBoolean;
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/LatestTopicAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */