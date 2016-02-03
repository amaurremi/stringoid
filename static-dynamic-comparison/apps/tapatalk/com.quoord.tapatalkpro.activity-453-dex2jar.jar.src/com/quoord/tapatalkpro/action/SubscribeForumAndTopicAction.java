package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.NewSubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.forum.SubForumFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ForumUrlUtil;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class SubscribeForumAndTopicAction
        implements TryTwiceCallBackInterface {
    private SubscribeForumAndTopicActionCallBack actionCallBack;
    public NewSubscribeForumAndTopicAdapter adapter;
    public String banUsername;
    public TapatalkEngine engine;
    private ForumStatus forumStatus;
    private boolean isOpCancel = false;
    private TapatalkJsonEngine jsonEngine;
    private boolean loadingMore;
    private Activity mActivity;
    public ForumActivityStatus mStatus = null;
    private String stackType;
    private Forum tempForumForLogin;
    private Boolean tryTwice = Boolean.valueOf(false);

    public SubscribeForumAndTopicAction(ForumStatus paramForumStatus, Activity paramActivity, String paramString, NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, SubscribeForumAndTopicActionCallBack paramSubscribeForumAndTopicActionCallBack) {
        this.actionCallBack = paramSubscribeForumAndTopicActionCallBack;
        this.adapter = paramNewSubscribeForumAndTopicAdapter;
        this.engine = new TapatalkEngine(this, paramForumStatus, paramActivity);
        this.stackType = paramString;
        this.forumStatus = paramForumStatus;
        this.mActivity = paramActivity;
        this.jsonEngine = new TapatalkJsonEngine(this.mActivity, this);
    }

    public void banUser(String paramString1, String paramString2, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        this.mStatus.showProgress();
        try {
            byte[] arrayOfByte1 = paramString1.getBytes("UTF-8");
            this.banUsername = paramString1;
            localArrayList.add(arrayOfByte1);
            localArrayList.add(Integer.valueOf(paramInt));
            if ((paramString2 == null) || (paramString2.length() <= 0)) {
            }
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                try {
                    paramString1 = paramString2.getBytes("UTF-8");
                    localArrayList.add(paramString1);
                    this.tryTwice = Boolean.valueOf(false);
                    this.engine.call("m_ban_user", localArrayList);
                    this.adapter.notifyDataSetChanged();
                    return;
                    localUnsupportedEncodingException = localUnsupportedEncodingException;
                    byte[] arrayOfByte2 = paramString1.getBytes();
                } catch (UnsupportedEncodingException paramString1) {
                    paramString1 = paramString2.getBytes();
                    continue;
                }
                localArrayList.add(new byte[0]);
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if ((CallBackChecker.checkCallBack(paramEngineResponse, this.mActivity, this.forumStatus, this.engine, isOpCancel(), this)) && (this.actionCallBack != null)) {
            this.actionCallBack.actionCallBack(paramEngineResponse);
        }
    }

    public void forumItemClicked(final Forum paramForum, boolean paramBoolean, SlidingMenuActivity paramSlidingMenuActivity, final String paramString) {
        if (paramForum == null) {
        }
        do {
            return;
            if ((!paramForum.isProtected()) || (paramBoolean)) {
                break;
            }
            this.tempForumForLogin = paramForum;
            paramForum = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(2130903265, null);
            paramString = (EditText) paramForum.getChildAt(0);
        }
        while ((paramSlidingMenuActivity.currentFragment == null) || (!(paramSlidingMenuActivity.currentFragment instanceof QuoordFragment)));
        new DialogFragment() {
            public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                new AlertDialog.Builder(SubscribeForumAndTopicAction.this.mActivity).setTitle(SubscribeForumAndTopicAction.this.mActivity.getString(2131099959)).setView(paramForum).setCancelable(false).setPositiveButton(SubscribeForumAndTopicAction.this.mActivity.getString(2131099972), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        SubscribeForumAndTopicAction.this.loginForum(this.val$password.getText().toString());
                        ((InputMethodManager) SubscribeForumAndTopicAction.this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.val$password.getWindowToken(), 0);
                    }
                }).setNegativeButton(SubscribeForumAndTopicAction.this.mActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        ((InputMethodManager) SubscribeForumAndTopicAction.this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.val$password.getWindowToken(), 0);
                    }
                }).create();
            }
        }.show(((QuoordFragment) paramSlidingMenuActivity.currentFragment).getFragmentManager(), "dailog");
        return;
        if (((paramForum.getChildForums() == null) || (paramForum.getChildForums().size() <= 0)) && (paramForum.getUrl() != null) && (paramForum.getUrl().length() > 0)) {
            paramSlidingMenuActivity = ForumUrlUtil.getIdFromUrl(paramForum.getUrl());
            paramString = this.forumStatus.getUrl().replace("www.", "").replace("http://", "");
            if ((paramForum.getUrl().contains(paramString)) && (paramSlidingMenuActivity.containsKey("fid"))) {
                paramSlidingMenuActivity.remove("pid");
                paramSlidingMenuActivity.remove("tid");
                ForumUrlUtil.openForumByIds(this.mActivity, this.forumStatus, paramSlidingMenuActivity, this.stackType, false);
                return;
            }
            try {
                paramSlidingMenuActivity = new Intent("android.intent.action.VIEW", Uri.parse(paramForum.getUrl()));
                this.mActivity.startActivity(paramSlidingMenuActivity);
                return;
            } catch (Exception paramSlidingMenuActivity) {
                openForum(paramForum);
                return;
            }
        }
        openForum(paramForum);
    }

    public TapatalkEngine getEngine() {
        return this.engine;
    }

    public boolean getSaxCall() {
        return false;
    }

    public void getTapatalkSubscribeForum() {
        SharedPreferences localSharedPreferences = Prefs.get(this.mActivity);
        if ((localSharedPreferences.getBoolean("login", false)) && (this.forumStatus != null) && (this.forumStatus.tapatalkForum != null)) {
            setTryTwice(false);
            this.jsonEngine.getSubscribeForum(localSharedPreferences.getInt("tapatalk_auid", 0), localSharedPreferences.getString("token", ""), this.forumStatus.tapatalkForum.getId());
        }
    }

    public boolean getTryTwice() {
        return this.tryTwice.booleanValue();
    }

    public void get_subscribe_forum() {
        if ((this.forumStatus.getApiLevel() >= 3) && (this.forumStatus.isSubscribeForum())) {
            this.loadingMore = true;
            setTryTwice(false);
            ArrayList localArrayList = new ArrayList();
            this.engine.call("get_subscribed_forum", localArrayList);
        }
    }

    public void get_subscribe_topic(int paramInt1, int paramInt2) {
        this.loadingMore = true;
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        if (this.forumStatus.isSubscribeLoad()) {
            localArrayList.add(Integer.valueOf(paramInt1));
            localArrayList.add(Integer.valueOf(paramInt1 + paramInt2 - 1));
        }
        this.engine.call("get_subscribed_topic", localArrayList);
    }

    public boolean isOpCancel() {
        return this.isOpCancel;
    }

    public void loginForum(String paramString) {
        this.tryTwice = Boolean.valueOf(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.tempForumForLogin.getId());
        localArrayList.add(paramString.getBytes());
        this.engine.call("login_forum", localArrayList);
    }

    public void openForum(Forum paramForum) {
        ((SlidingMenuActivity) this.mActivity).addFragmentToStack(SubForumFragment.newInstance(paramForum, this.stackType), this.stackType, true);
    }

    public void setOpCancel(boolean paramBoolean) {
        this.isOpCancel = this.isOpCancel;
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = Boolean.valueOf(paramBoolean);
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface SubscribeForumAndTopicActionCallBack {
        public abstract void actionCallBack(EngineResponse paramEngineResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/SubscribeForumAndTopicAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */