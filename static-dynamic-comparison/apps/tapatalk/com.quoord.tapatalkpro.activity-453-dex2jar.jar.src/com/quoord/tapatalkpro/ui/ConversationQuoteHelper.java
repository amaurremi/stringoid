package com.quoord.tapatalkpro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.quoord.tapatalkpro.action.CallBackChecker;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.conversation.ConversationOuterFragment;
import com.quoord.tapatalkpro.activity.forum.conversation.CreateOrReplyConversationActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.TabConvDetailFragment;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvDetailAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvPagerAdapter;
import com.quoord.tapatalkpro.bean.ConversationData;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Participant;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class ConversationQuoteHelper
        implements TryTwiceCallBackInterface {
    private String conversationId;
    private TapatalkEngine engine;
    private ForumStatus forumStatus;
    private boolean isFirst = true;
    private boolean isQuote = false;
    private ConversationOuterFragment mContext;
    public ActionMode mMode = null;
    public ArrayList<ConversationData> multiQuoteIds = new ArrayList();
    private boolean tryTwice;

    public ConversationQuoteHelper(ConversationOuterFragment paramConversationOuterFragment, ForumStatus paramForumStatus) {
        this.mContext = paramConversationOuterFragment;
        this.engine = new TapatalkEngine(this, paramForumStatus, this.mContext.getActivity());
        this.forumStatus = paramForumStatus;
    }

    public void actionFinish() {
        this.multiQuoteIds.clear();
        if (this.mMode != null) {
            this.mMode.finish();
        }
        this.mMode = null;
        if ((this.mContext.pagerAdapter != null) && (((TabConvDetailFragment) this.mContext.pagerAdapter.getItem(this.mContext.mPager.getCurrentItem())).tabConvDetailAdapter != null)) {
            ((TabConvDetailFragment) this.mContext.pagerAdapter.getItem(this.mContext.mPager.getCurrentItem())).tabConvDetailAdapter.notifyDataSetChanged();
        }
        this.mContext.closeProgress();
    }

    public void actionMulti(ForumStatus paramForumStatus, ConversationData paramConversationData) {
        if (paramConversationData != null) {
            if (this.multiQuoteIds.contains(paramConversationData)) {
                this.multiQuoteIds.remove(paramConversationData);
            }
        } else {
            this.conversationId = paramConversationData.getConv_id();
            new Handler();
            if (this.multiQuoteIds.size() != 1) {
                break label203;
            }
            if (this.mMode == null) {
                this.mMode = this.mContext.getActivity().startActionMode(new AnActionMode(null));
            }
            if (this.multiQuoteIds.size() > 0) {
                this.mMode.setTitle(((ConversationData) this.multiQuoteIds.get(0)).getParticipant().getUserName());
            }
        }
        for (; ; ) {
            if ((this.mContext.pagerAdapter != null) && (((TabConvDetailFragment) this.mContext.pagerAdapter.getItem(this.mContext.mPager.getCurrentItem())).tabConvDetailAdapter != null)) {
                ((TabConvDetailFragment) this.mContext.pagerAdapter.getItem(this.mContext.mPager.getCurrentItem())).tabConvDetailAdapter.notifyDataSetChanged();
            }
            return;
            this.multiQuoteIds.clear();
            this.multiQuoteIds.add(paramConversationData);
            break;
            label203:
            if (this.mMode != null) {
                this.mMode.finish();
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (CallBackChecker.checkCallBack(paramEngineResponse, this.mContext.getActivity(), this.forumStatus, this.engine, isOpCancel(), this)) {
            if ((!paramEngineResponse.isSuccess()) || (paramEngineResponse == null)) {
                if (this.multiQuoteIds != null) {
                    this.multiQuoteIds.clear();
                }
                this.mContext.closeProgress();
                actionFinish();
            }
        } else {
            return;
        }
        Object localObject = (HashMap) paramEngineResponse.getResponse();
        paramEngineResponse = "";
        try {
            localObject = new String(Util.parseByteArray((byte[]) ((HashMap) localObject).get("text_body")), "UTF-8");
            paramEngineResponse = (EngineResponse) localObject;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }
        if (this.mMode != null) {
            this.mMode.finish();
        }
        localObject = new Intent(this.mContext.getActivity(), CreateOrReplyConversationActivity.class);
        new Bundle();
        ((Intent) localObject).putExtra("conv_content", paramEngineResponse);
        ((Intent) localObject).putExtra("conv_id", this.conversationId);
        ((Intent) localObject).putExtra("conv", this.mContext.conversation);
        ((Intent) localObject).putExtra("forumStatus", this.forumStatus);
        ((Intent) localObject).putExtra("can_upload", this.mContext.tabConvDetailAdapter.can_upload);
        this.isQuote = true;
        ((Intent) localObject).putExtra("is_quote", this.isQuote);
        this.mContext.startActivityForResult((Intent) localObject, 53);
        this.mContext.closeProgress();
        actionFinish();
    }

    public void getQuoteConversation(ConversationData paramConversationData) {
        this.tryTwice = false;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramConversationData.getConv_id());
        localArrayList.add(paramConversationData.getMsg_id());
        this.engine.call("get_quote_conversation", localArrayList);
        this.multiQuoteIds.clear();
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setFirst(boolean paramBoolean) {
        this.isFirst = paramBoolean;
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

    private final class AnActionMode
            implements ActionMode.Callback {
        private AnActionMode() {
        }

        public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
            switch (paramMenuItem.getItemId()) {
            }
            for (; ; ) {
                return true;
                if (ConversationQuoteHelper.this.isFirst) {
                    ConversationQuoteHelper.this.isFirst = false;
                    ConversationQuoteHelper.this.mContext.showProgress();
                    if (ConversationQuoteHelper.this.multiQuoteIds.size() > 0) {
                        ConversationQuoteHelper.this.getQuoteConversation((ConversationData) ConversationQuoteHelper.this.multiQuoteIds.get(0));
                        continue;
                        ConversationQuoteHelper.this.multiQuoteIds.clear();
                        if ((ConversationQuoteHelper.this.mContext.pagerAdapter != null) && (((TabConvDetailFragment) ConversationQuoteHelper.this.mContext.pagerAdapter.getItem(ConversationQuoteHelper.this.mContext.mPager.getCurrentItem())).tabConvDetailAdapter != null)) {
                            ((TabConvDetailFragment) ConversationQuoteHelper.this.mContext.pagerAdapter.getItem(ConversationQuoteHelper.this.mContext.mPager.getCurrentItem())).tabConvDetailAdapter.notifyDataSetChanged();
                        }
                        paramActionMode.finish();
                    }
                }
            }
        }

        public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
            paramMenu.add(0, 1051, 0, ConversationQuoteHelper.this.mContext.getString(2131100156)).setIcon(ThemeUtil.getDrawableIdByPicName("bubble_reply", ConversationQuoteHelper.this.mContext.getActivity())).setShowAsAction(1);
            return true;
        }

        public void onDestroyActionMode(ActionMode paramActionMode) {
            ConversationQuoteHelper.this.multiQuoteIds.clear();
            if ((ConversationQuoteHelper.this.mContext.pagerAdapter != null) && (((TabConvDetailFragment) ConversationQuoteHelper.this.mContext.pagerAdapter.getItem(ConversationQuoteHelper.this.mContext.mPager.getCurrentItem())).tabConvDetailAdapter != null)) {
                ((TabConvDetailFragment) ConversationQuoteHelper.this.mContext.pagerAdapter.getItem(ConversationQuoteHelper.this.mContext.mPager.getCurrentItem())).tabConvDetailAdapter.notifyDataSetChanged();
            }
            ConversationQuoteHelper.this.mMode = null;
            ConversationQuoteHelper.this.mContext.closeProgress();
        }

        public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
            return false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ConversationQuoteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */