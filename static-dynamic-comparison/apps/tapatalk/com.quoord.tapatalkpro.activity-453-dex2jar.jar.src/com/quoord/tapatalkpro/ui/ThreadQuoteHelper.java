package com.quoord.tapatalkpro.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.CallBackChecker;
import com.quoord.tapatalkpro.action.DeletePostAction;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadPagerAdapter;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateActivity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ThreadQuoteHelper
        implements TryTwiceCallBackInterface {
    String currentQuoteContent = "";
    private TapatalkEngine engine;
    int firstQuotePosition = 0;
    private ForumStatus forumStatus;
    private boolean isFirst = true;
    private ThreadOuterFragment mContext;
    public ActionMode mMode = null;
    public ArrayList<PostData> multiQuoteIds = new ArrayList();
    public ActionMode singleActionmMode = null;
    private boolean tryTwice;

    public ThreadQuoteHelper(ThreadOuterFragment paramThreadOuterFragment, ForumStatus paramForumStatus) {
        this.mContext = paramThreadOuterFragment;
        this.engine = new TapatalkEngine(this, paramForumStatus, this.mContext.getActivity());
        this.forumStatus = paramForumStatus;
    }

    public void actionFinish() {
        this.multiQuoteIds.clear();
        if (this.mMode != null) {
            this.mMode.finish();
        }
        if (this.singleActionmMode != null) {
            this.singleActionmMode.finish();
        }
        this.mMode = null;
        this.singleActionmMode = null;
        if ((this.mContext.pagerAdapter != null) && (this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()) != null) && (this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()).mThreadAdapter != null)) {
            this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()).mThreadAdapter.notifyDataSetChanged();
        }
        showReplyBar();
        this.mContext.closeProgress();
    }

    public void actionMulti(final ForumStatus paramForumStatus, final PostData paramPostData) {
        PostData localPostData = null;
        int i;
        if (paramPostData != null) {
            i = 0;
            if (i >= this.multiQuoteIds.size()) {
                if (localPostData != null) {
                    break label269;
                }
                this.multiQuoteIds.add(paramPostData);
            }
        } else {
            label34:
            new Handler();
            if (this.multiQuoteIds.size() <= 1) {
                break label282;
            }
            if (this.mMode == null) {
                this.mMode = this.mContext.getActivity().startActionMode(new AnActionMode(null));
            }
            this.mMode.setTitle(String.format(this.mContext.getString(2131100157), new Object[]{Integer.valueOf(this.multiQuoteIds.size())}));
        }
        for (; ; ) {
            if ((this.mContext.pagerAdapter != null) && (this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()) != null) && (this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()).mThreadAdapter != null)) {
                this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()).mThreadAdapter.notifyDataSetChanged();
            }
            if (this.multiQuoteIds.size() <= 1) {
                break label391;
            }
            this.mContext.bottomView.setVisibility(8);
            return;
            if (((PostData) this.multiQuoteIds.get(i)).getPostId() == paramPostData.getPostId()) {
                localPostData = (PostData) this.multiQuoteIds.get(i);
            }
            i += 1;
            break;
            label269:
            this.multiQuoteIds.remove(localPostData);
            break label34;
            label282:
            if (this.multiQuoteIds.size() == 1) {
                paramPostData = (PostData) this.multiQuoteIds.get(0);
                if (this.mMode != null) {
                    this.mMode.finish();
                }
                if (this.singleActionmMode != null) {
                    this.singleActionmMode.finish();
                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if ((paramPostData != null) && (paramPostData.getPostId() != null)) {
                            paramPostData.showQuickAction(paramForumStatus, paramPostData.getPostId());
                        }
                    }
                }, 100L);
            } else {
                if (this.mMode != null) {
                    this.mMode.finish();
                }
                if (this.singleActionmMode != null) {
                    this.singleActionmMode.finish();
                }
            }
        }
        label391:
        showReplyBar();
    }

    public void actionSelect(PostData paramPostData) {
        PostData localPostData = null;
        int i;
        if (paramPostData != null) {
            i = 0;
            if (i < this.multiQuoteIds.size()) {
                break label55;
            }
            if (localPostData != null) {
                break label95;
            }
            this.multiQuoteIds.add(paramPostData);
        }
        for (; ; ) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if ((ThreadQuoteHelper.this.mContext.pagerAdapter != null) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()) != null) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter != null)) {
                        ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter.notifyDataSetChanged();
                    }
                }
            }, 100L);
            return;
            label55:
            if (((PostData) this.multiQuoteIds.get(i)).getPostId() == paramPostData.getPostId()) {
                localPostData = (PostData) this.multiQuoteIds.get(i);
            }
            i += 1;
            break;
            label95:
            this.multiQuoteIds.remove(paramPostData);
        }
    }

    public void actionSelectPostId(PostData paramPostData) {
        PostData localPostData = null;
        int i;
        if (paramPostData != null) {
            i = 0;
            if (i < this.multiQuoteIds.size()) {
                break label55;
            }
            if (localPostData != null) {
                break label95;
            }
            this.multiQuoteIds.add(paramPostData);
        }
        for (; ; ) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if ((ThreadQuoteHelper.this.mContext.pagerAdapter != null) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()) != null) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter != null)) {
                        ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter.notifyDataSetChanged();
                    }
                }
            }, 100L);
            return;
            label55:
            if (((PostData) this.multiQuoteIds.get(i)).getPostId() == paramPostData.getPostId()) {
                localPostData = (PostData) this.multiQuoteIds.get(i);
            }
            i += 1;
            break;
            label95:
            this.multiQuoteIds.remove(localPostData);
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (CallBackChecker.checkCallBack(paramEngineResponse, this.mContext.getActivity(), this.forumStatus, this.engine, isOpCancel(), this)) {
            if (!paramEngineResponse.isSuccess()) {
                if (this.multiQuoteIds != null) {
                    this.multiQuoteIds.clear();
                }
                this.mContext.closeProgress();
                Util.startReplyActivity(this.mContext, this.forumStatus, this.mContext.mTopic, null, this.currentQuoteContent, 0, this.mContext.mThreadAdapter.isCanUpload(), this.mContext.getCountdownNumber());
                actionFinish();
            }
        } else {
            return;
        }
        HashMap localHashMap = (HashMap) paramEngineResponse.getResponse();
        for (; ; ) {
            try {
                paramEngineResponse = new String((byte[]) localHashMap.get("post_title"), "UTF-8");
                paramEngineResponse = new String((byte[]) localHashMap.get("post_title"));
            } catch (UnsupportedEncodingException paramEngineResponse) {
                try {
                    str = new String(Util.parseByteArray((byte[]) localHashMap.get("post_content")), "UTF-8");
                    if ((this.multiQuoteIds == null) || (this.multiQuoteIds.size() <= 0)) {
                        break;
                    }
                    if ((this.currentQuoteContent == null) || (this.currentQuoteContent.length() <= 0)) {
                        break label301;
                    }
                    this.currentQuoteContent += "\r\n\r\n\r\n";
                    this.currentQuoteContent += str;
                    getQuotePost(((PostData) this.multiQuoteIds.get(0)).getPostId());
                    return;
                } catch (UnsupportedEncodingException paramEngineResponse) {
                    String str;
                    for (; ; ) {
                    }
                }
                paramEngineResponse = paramEngineResponse;
            }
            str = new String((byte[]) localHashMap.get("post_content"));
            continue;
            label301:
            this.firstQuotePosition = str.length();
        }
        if ((this.currentQuoteContent != null) && (this.currentQuoteContent.length() > 0)) {
            this.currentQuoteContent += "\r\n\r\n\r\n";
        }
        this.currentQuoteContent += str;
        if (this.multiQuoteIds != null) {
            this.multiQuoteIds.clear();
        }
        if (this.mMode != null) {
            this.mMode.finish();
        }
        if (this.singleActionmMode != null) {
            this.singleActionmMode.finish();
        }
        this.mContext.closeProgress();
        Util.startReplyActivity(this.mContext, this.forumStatus, this.mContext.mTopic, paramEngineResponse, this.currentQuoteContent, this.firstQuotePosition, this.mContext.mThreadAdapter.isCanUpload(), this.mContext.getCountdownNumber());
        actionFinish();
        this.currentQuoteContent = "";
    }

    public void getQuotePost(String paramString) {
        this.tryTwice = false;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        this.engine.call("get_quote_post", localArrayList);
        int i = 0;
        for (; ; ) {
            if (i >= this.multiQuoteIds.size()) {
                return;
            }
            if (((PostData) this.multiQuoteIds.get(i)).getPostId().equals(paramString)) {
                this.multiQuoteIds.remove(i);
            }
            i += 1;
        }
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

    public void showReplyBar() {
        if ((Prefs.get(this.mContext.getActivity()).getBoolean("showQuick_replay", true)) && (this.mContext.pagerAdapter != null) && (this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()) != null) && (this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()).mThreadAdapter != null) && (this.mContext.pagerAdapter.getFragment(this.mContext.mPager.getCurrentItem()).mThreadAdapter.canReply)) {
            this.mContext.bottomView.setVisibility(0);
        }
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
                int i;
                if (ThreadQuoteHelper.this.isFirst) {
                    ThreadQuoteHelper.this.isFirst = false;
                    if (!ThreadQuoteHelper.this.forumStatus.isMultiQuote()) {
                        break label250;
                    }
                    paramActionMode = new StringBuilder();
                    paramMenuItem = new ArrayList();
                    i = 0;
                    label115:
                    if (i < ThreadQuoteHelper.this.multiQuoteIds.size()) {
                        break label186;
                    }
                    paramMenuItem = paramMenuItem.iterator();
                    label134:
                    if (paramMenuItem.hasNext()) {
                        break label215;
                    }
                    ThreadQuoteHelper.this.mContext.showProgress();
                    ThreadQuoteHelper.this.multiQuoteIds.clear();
                    ThreadQuoteHelper.this.getQuotePost(paramActionMode.toString());
                }
                for (; ; ) {
                    ThreadQuoteHelper.this.showReplyBar();
                    break;
                    label186:
                    paramMenuItem.add(((PostData) ThreadQuoteHelper.this.multiQuoteIds.get(i)).getPostId());
                    i += 1;
                    break label115;
                    label215:
                    String str = (String) paramMenuItem.next();
                    if (paramActionMode.length() != 0) {
                        paramActionMode.append("-");
                    }
                    paramActionMode.append(str);
                    break label134;
                    label250:
                    ThreadQuoteHelper.this.mContext.showProgress();
                    ThreadQuoteHelper.this.getQuotePost(((PostData) ThreadQuoteHelper.this.multiQuoteIds.get(0)).getPostId());
                }
                ThreadQuoteHelper.this.multiQuoteIds.clear();
                if ((ThreadQuoteHelper.this.mContext.pagerAdapter != null) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()) != null) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter != null)) {
                    ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter.notifyDataSetChanged();
                }
                paramActionMode.finish();
                ThreadQuoteHelper.this.showReplyBar();
                continue;
                if ((ThreadQuoteHelper.this.forumStatus.isSMF()) || (ThreadQuoteHelper.this.forumStatus.isSMF1()) || (ThreadQuoteHelper.this.forumStatus.isSMF2())) {
                    new AlertDialog.Builder(ThreadQuoteHelper.this.mContext.getActivity()).setTitle("Move Post").setPositiveButton(2131100062, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            paramAnonymousDialogInterface = (LinearLayout) LayoutInflater.from(ThreadQuoteHelper.this.mContext.getActivity()).inflate(2130903274, null);
                            final EditText localEditText = (EditText) paramAnonymousDialogInterface.findViewById(2131231392);
                            localEditText.setSingleLine();
                            localEditText.setText(ThreadQuoteHelper.this.mContext.mTopic.getTitle());
                            new AlertDialog.Builder(ThreadQuoteHelper.this.mContext.getActivity()).setView(paramAnonymousDialogInterface).setTitle(2131100754).setPositiveButton(2131099792, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                    if (!localEditText.getText().toString().equals("")) {
                                        ThreadQuoteHelper.this.mContext.showProgress();
                                        return;
                                    }
                                    Toast.makeText(ThreadQuoteHelper.this.mContext.getActivity(), ThreadQuoteHelper.this.mContext.getResources().getString(2131100827), 1).show();
                                }
                            }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                    ((ViewGroup) localEditText.getParent()).removeAllViews();
                                }
                            }).create().show();
                        }
                    }).setNegativeButton(2131099974, null).create().show();
                }
                for (; ; ) {
                    paramActionMode.finish();
                    ThreadQuoteHelper.this.showReplyBar();
                    break;
                    paramMenuItem = new Intent(ThreadQuoteHelper.this.mContext.getActivity(), ModerateActivity.class);
                    paramMenuItem.putExtra("forumStatus", ThreadQuoteHelper.this.forumStatus);
                    paramMenuItem.putExtra("post_list", ThreadQuoteHelper.this.multiQuoteIds);
                    paramMenuItem.putExtra("topic", ThreadQuoteHelper.this.mContext.mTopic);
                    paramMenuItem.putExtra("select_forum_action", 3);
                    ThreadQuoteHelper.this.mContext.getActivity().startActivityForResult(paramMenuItem, 901);
                }
                if ((ThreadQuoteHelper.this.forumStatus.isXF()) || (ThreadQuoteHelper.this.forumStatus.isPB()) || (ThreadQuoteHelper.this.forumStatus.isVB()) || (ThreadQuoteHelper.this.forumStatus.isVB3()) || (ThreadQuoteHelper.this.forumStatus.isVB4()) || (ThreadQuoteHelper.this.forumStatus.isVB5())) {
                    paramActionMode = new Intent(ThreadQuoteHelper.this.mContext.getActivity(), ModerateActivity.class);
                    paramActionMode.putExtra("forumStatus", ThreadQuoteHelper.this.forumStatus);
                    paramActionMode.putExtra("post_list", ThreadQuoteHelper.this.multiQuoteIds);
                    paramActionMode.putExtra("topic", ThreadQuoteHelper.this.mContext.mTopic);
                    paramActionMode.putExtra("select_forum_action", 5);
                    ThreadQuoteHelper.this.mContext.getActivity().startActivity(paramActionMode);
                } else if (!ThreadQuoteHelper.this.forumStatus.isIP()) {
                    ThreadQuoteHelper.this.forumStatus.isMB();
                    continue;
                    new DeletePostAction(ThreadQuoteHelper.this.mContext.getActivity(), ThreadQuoteHelper.this.forumStatus, ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter, ThreadQuoteHelper.this.multiQuoteIds, ThreadQuoteHelper.this.mContext.mTopic);
                    ThreadQuoteHelper.this.showReplyBar();
                    paramActionMode.finish();
                    continue;
                    paramActionMode = new Intent();
                    paramActionMode.setClass(ThreadQuoteHelper.this.mContext.getActivity(), ModerateActivity.class);
                    paramActionMode.putExtra("forumStatus", ThreadQuoteHelper.this.forumStatus);
                    paramActionMode.putExtra("topic", ThreadQuoteHelper.this.mContext.mTopic);
                    paramActionMode.putExtra("select_forum_action", 4);
                    ThreadQuoteHelper.this.mContext.startActivityForResult(paramActionMode, 601);
                }
            }
        }

        public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
            paramActionMode.setTitle(String.format(ThreadQuoteHelper.this.mContext.getString(2131100157), new Object[]{Integer.valueOf(ThreadQuoteHelper.this.multiQuoteIds.size())}));
            if (((!ThreadQuoteHelper.this.mContext.mTopic.isAnn()) || (!ThreadQuoteHelper.this.forumStatus.isVB())) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter.isCanReply())) {
                paramMenu.add(0, 1051, 0, ThreadQuoteHelper.this.mContext.getString(2131100156)).setIcon(ThemeUtil.getDrawableIdByPicName("bubble_quote", ThreadQuoteHelper.this.mContext.getActivity())).setShowAsAction(1);
            }
            int j = 1;
            int i = 0;
            if (i >= ThreadQuoteHelper.this.multiQuoteIds.size()) {
                if (j != 0) {
                    paramMenu.add(0, 5000, 0, ThreadQuoteHelper.this.mContext.getString(2131100822)).setIcon(ThemeUtil.getDrawableIdByPicName("bubble_move", ThreadQuoteHelper.this.mContext.getActivity())).setShowAsAction(1);
                }
                j = 1;
                i = 0;
            }
            for (; ; ) {
                if (i >= ThreadQuoteHelper.this.multiQuoteIds.size()) {
                    if (j != 0) {
                        paramMenu.add(0, 1102, 0, ThreadQuoteHelper.this.mContext.getString(2131100016)).setIcon(ThemeUtil.getDrawableIdByPicName("bubble_delete", ThreadQuoteHelper.this.mContext.getActivity())).setShowAsAction(1);
                    }
                    return true;
                    if (!((PostData) ThreadQuoteHelper.this.multiQuoteIds.get(i)).canMove) {
                        j = 0;
                    }
                    i += 1;
                    break;
                }
                if ((((PostData) ThreadQuoteHelper.this.multiQuoteIds.get(i)).isDeleted()) || (!((PostData) ThreadQuoteHelper.this.multiQuoteIds.get(i)).canDelete)) {
                    j = 0;
                }
                i += 1;
            }
        }

        public void onDestroyActionMode(ActionMode paramActionMode) {
            ThreadQuoteHelper.this.multiQuoteIds.clear();
            if ((ThreadQuoteHelper.this.mContext.pagerAdapter != null) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()) != null) && (ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter != null)) {
                ThreadQuoteHelper.this.showReplyBar();
                ThreadQuoteHelper.this.mContext.pagerAdapter.getFragment(ThreadQuoteHelper.this.mContext.mPager.getCurrentItem()).mThreadAdapter.notifyDataSetChanged();
            }
            ThreadQuoteHelper.this.mMode = null;
            ThreadQuoteHelper.this.singleActionmMode = null;
        }

        public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
            return false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/ThreadQuoteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */