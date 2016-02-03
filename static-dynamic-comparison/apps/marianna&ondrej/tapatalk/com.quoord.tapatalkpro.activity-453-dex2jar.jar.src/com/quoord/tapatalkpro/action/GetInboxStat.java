package com.quoord.tapatalkpro.action;

import android.content.res.Resources;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment.ChangeUnreadNumbers;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class GetInboxStat
        implements TryTwiceCallBackInterface {
    TapatalkEngine engine;
    ForumStatus forumStatus;
    SlidingMenuActivity mContext;
    private boolean tryTwice = false;
    int unreadPMCount;
    int unreadSubCount;

    public GetInboxStat(SlidingMenuActivity paramSlidingMenuActivity, ForumStatus paramForumStatus) {
        ArrayList localArrayList = new ArrayList();
        this.forumStatus = paramForumStatus;
        this.mContext = paramSlidingMenuActivity;
        this.engine = new TapatalkEngine(this, paramForumStatus, this.mContext);
        this.engine.call("get_inbox_stat", localArrayList);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (CallBackChecker.checkCallBack(paramEngineResponse, this.mContext, this.forumStatus, this.engine, isOpCancel(), this)) {
        }
        try {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            if (paramEngineResponse.containsKey("inbox_unread_count")) {
                this.unreadPMCount = ((Integer) paramEngineResponse.get("inbox_unread_count")).intValue();
            }
            if (paramEngineResponse.containsKey("subscribed_topic_unread_count")) {
                this.unreadSubCount = ((Integer) paramEngineResponse.get("subscribed_topic_unread_count")).intValue();
            }
            this.forumStatus.setUnreadSubScribe(this.unreadSubCount);
            this.forumStatus.setUnreadInbox(this.unreadPMCount);
            ((BackListFragment) this.mContext.getmFrag()).setChangeIngerface(new BackListFragment.ChangeUnreadNumbers() {
                public void setUnreadNumbers(BackListAdapter paramAnonymousBackListAdapter) {
                    int i;
                    if ((GetInboxStat.this.unreadPMCount >= 0) || (GetInboxStat.this.unreadSubCount >= 0)) {
                        i = 0;
                        if (i >= paramAnonymousBackListAdapter.tabItemList.size()) {
                            paramAnonymousBackListAdapter.notifyDataSetChanged();
                        }
                    } else {
                        return;
                    }
                    if ((GetInboxStat.this.mContext.getResources().getBoolean(2131558401)) && (GetInboxStat.this.forumStatus.getRebrandingConfig() != null) && (GetInboxStat.this.forumStatus.getRebrandingConfig().getOrder() != null) && (GetInboxStat.this.forumStatus.getRebrandingConfig().getOrder().size() > 0)) {
                        if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() == 1019) {
                            if (GetInboxStat.this.unreadSubCount > 0) {
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getDisplay_name() + " (" + GetInboxStat.this.unreadSubCount + ") ");
                            }
                        } else {
                            label195:
                            if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() == 1020) {
                                if (GetInboxStat.this.unreadPMCount <= 0) {
                                    break label415;
                                }
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getDisplay_name() + " (" + GetInboxStat.this.unreadPMCount + ") ");
                            }
                            label286:
                            if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() == 1021) {
                                if (GetInboxStat.this.unreadPMCount <= 0) {
                                    break label446;
                                }
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getDisplay_name() + " (" + GetInboxStat.this.unreadPMCount + ") ");
                            }
                        }
                    }
                    for (; ; ) {
                        i += 1;
                        break;
                        ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getDisplay_name());
                        break label195;
                        label415:
                        ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getDisplay_name());
                        break label286;
                        label446:
                        ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getDisplay_name());
                        continue;
                        if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() == 1019) {
                            if (GetInboxStat.this.unreadSubCount > 0) {
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(GetInboxStat.this.mContext.getString(2131100417) + " (" + GetInboxStat.this.unreadSubCount + ") ");
                            }
                        } else {
                            label566:
                            if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() == 1020) {
                                if (GetInboxStat.this.unreadPMCount <= 0) {
                                    break label776;
                                }
                                ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(GetInboxStat.this.mContext.getString(2131100422) + " (" + GetInboxStat.this.unreadPMCount + ") ");
                            }
                        }
                        for (; ; ) {
                            if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() != 1021) {
                                break label803;
                            }
                            if (GetInboxStat.this.unreadPMCount <= 0) {
                                break label805;
                            }
                            ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(GetInboxStat.this.mContext.getString(2131100432) + " (" + GetInboxStat.this.unreadPMCount + ") ");
                            break;
                            ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(GetInboxStat.this.mContext.getString(2131100417));
                            break label566;
                            label776:
                            ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(GetInboxStat.this.mContext.getString(2131100422));
                        }
                        label803:
                        continue;
                        label805:
                        ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(GetInboxStat.this.mContext.getString(2131100432));
                    }
                }
            });
            ((BackListFragment) this.mContext.getmFrag()).ChangeUnreadNumbers();
            return;
        } catch (Exception paramEngineResponse) {
            paramEngineResponse.printStackTrace();
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetInboxStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */