package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.quoord.DialogUtil.DialogUtil;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.activity.forum.BanUserActivity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerationInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ProtectedForumCache;
import com.quoord.tapatalkpro.ics.forum.SubForumFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ui.ThreadQuoteHelper;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ForumUrlUtil;
import com.quoord.tapatalkpro.util.JsonRpcEngine;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TapatalkLog;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ForumRootAdapter
        extends BaseAdapter
        implements TryTwiceCallBackInterface {
    private String banUsername;
    public Activity baseContext;
    public int curAction = 0;
    public TapatalkEngine engine = null;
    public ForumStatus forumStatus;
    public HashMap<String, View> icons = new HashMap();
    protected boolean isOpCancel = false;
    private boolean isSaxCall = false;
    protected JsonRpcEngine jsonEngine = null;
    public boolean loadingMore = false;
    protected Forum mForum;
    TapatalkJsonEngine mJsonEngine;
    public ListView mListView;
    public int mLongclickItemPosition = 0;
    public ForumActivityStatus mStatus = null;
    String mUsername = null;
    private SharedPreferences prefs;
    public boolean shouldShowError = true;
    SignInWithOtherUtil singInUtil;
    public String stackType;
    private boolean support = false;
    public Forum tempForumForLogin;
    private Boolean tryTwice = Boolean.valueOf(false);
    boolean tryUpdateAgain = false;
    String useAuEmail = "0";

    public ForumRootAdapter(Activity paramActivity, ForumActivityStatus paramForumActivityStatus, String paramString) {
        this.baseContext = paramActivity;
        this.mStatus = paramForumActivityStatus;
        this.forumStatus = this.mStatus.getForumStatus();
        this.prefs = Prefs.get(this.baseContext);
        this.engine = new TapatalkEngine(this, this.forumStatus, this.baseContext);
        this.jsonEngine = new JsonRpcEngine(this, this.forumStatus, this.baseContext);
    }

    public ForumRootAdapter(Activity paramActivity, String paramString) {
        this.baseContext = paramActivity;
        this.mStatus = ((ForumActivityStatus) paramActivity);
        this.forumStatus = this.mStatus.getForumStatus();
        this.prefs = Prefs.get(this.baseContext);
        this.engine = new TapatalkEngine(this, this.forumStatus, this.baseContext);
        this.jsonEngine = new JsonRpcEngine(this, this.forumStatus, this.baseContext);
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
                    notifyDataSetChanged();
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
        if ((this.mJsonEngine == null) || (this.singInUtil == null)) {
            this.mJsonEngine = new TapatalkJsonEngine(this.baseContext, this);
            this.singInUtil = new SignInWithOtherUtil(this.baseContext, this.mJsonEngine, new Handler());
        }
        try {
            bool1 = paramEngineResponse.isSuccess();
            localBoolean1 = Boolean.valueOf(bool1);
        } catch (Exception localException1) {
            do {
                do {
                    boolean bool1;
                    do {
                        for (; ; ) {
                            Boolean localBoolean1;
                            localObject1 = Boolean.valueOf(false);
                        }
                        localObject2 = localObject3;
                        if (bool1) {
                            localObject2 = localObject3;
                            if (localHashMap.containsKey("result_text")) {
                                if (!str.equals(this.forumStatus.getAuthroizeUserFunction())) {
                                    break label390;
                                }
                                if (!((Boolean) localHashMap.get("result")).booleanValue()) {
                                    this.forumStatus.setLogin(false);
                                    if (!(this.baseContext instanceof SlidingMenuActivity)) {
                                        this.baseContext.finish();
                                    }
                                }
                                parseCallBack(paramEngineResponse);
                                localObject2 = localObject3;
                            }
                        }
                        for (; ; ) {
                            if (!str.equalsIgnoreCase("login_mod")) {
                                break label603;
                            }
                            if (!((Boolean) localObject2).booleanValue()) {
                                break label580;
                            }
                            this.mStatus.closeProgress();
                            if (this.forumStatus.ModeInterface != null) {
                                this.forumStatus.ModeInterface.recallAfterLoginMod();
                                this.forumStatus.ModeInterface = null;
                                return;
                                localBoolean2 = (Boolean) localHashMap.get("result");
                                try {
                                    localObject3 = new String((byte[]) localHashMap.get("result_text"), "UTF-8");
                                    localObject2 = localBoolean2;
                                    if (localObject3 != null) {
                                        localObject2 = localBoolean2;
                                        if (((String) localObject3).length() > 0) {
                                            localObject2 = localBoolean2;
                                            if (this.shouldShowError) {
                                                localObject2 = localBoolean2;
                                                if (!"prefetch_account".equals(str)) {
                                                    localObject2 = localBoolean2;
                                                    if (!"sign_in".equals(str)) {
                                                        Toast.makeText(this.baseContext, (CharSequence) localObject3, 1).show();
                                                        localObject2 = localBoolean2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception localException2) {
                                    for (; ; ) {
                                        localObject3 = new String((byte[]) localHashMap.get("result_text"));
                                    }
                                }
                            }
                        }
                        if (this.forumStatus.tempAdapter != null) {
                            this.forumStatus.tempAdapter.recallAfterLoginMod();
                            this.forumStatus.tempAdapter = null;
                            return;
                        }
                        this.forumStatus.banUser.recallAfterLoginMod();
                        this.forumStatus.banUser = null;
                        return;
                        this.forumStatus.tempAdapter = null;
                        DialogUtil.getLoginModDialog(this.baseContext, this.forumStatus, this).show();
                    } while (!bool1);
                    if (!((Boolean) localObject1).booleanValue()) {
                        break;
                    }
                } while (isOpCancel());
                try {
                    if ((str.equalsIgnoreCase("login_forum")) || (str.equals("subscribe_topic")) || (str.equals("subscribe_forum")) || (str.equals("unsubscribe_topic")) || (str.equals("unsubscribe_forum")) || (str.equals("m_stick_topic")) || (str.equals("m_delete_topic")) || (str.equals("m_undelete_topic")) || (str.equals("m_approve_topic")) || (str.equals("m_close_topic")) || (str.equals("m_undelete_post")) || (str.equals("m_ban_user"))) {
                        parseCallBackCommonMethod(paramEngineResponse);
                        return;
                    }
                } catch (Exception paramEngineResponse) {
                    paramEngineResponse.printStackTrace();
                    return;
                }
                parseCallBack(paramEngineResponse);
                return;
                paramEngineResponse = paramEngineResponse.getErrorMessage();
                localObject1 = new HashMap();
                ((Map) localObject1).put("errormessage", this.baseContext.getString(2131100071));
                TapatalkLog.e("errormessage", "methodName " + str + "errormessage " + paramEngineResponse);
            } while (!this.shouldShowError);
            this.mStatus.updateUI(13, localObject1);
            return;
        }
        bool1 = true;
        try {
            boolean bool2 = parseCallBackPreCheck(paramEngineResponse);
            bool1 = bool2;
        } catch (RemoteException localRemoteException) {
            String str;
            Object localObject2;
            Object localObject3;
            HashMap localHashMap;
            Object localObject1;
            Boolean localBoolean2;
            for (; ; ) {
            }
        }
        str = paramEngineResponse.getMethod();
        if ((str.endsWith("get_config")) && (!localBoolean1.booleanValue()) && ((this.baseContext instanceof SlidingMenuActivity))) {
            localObject2 = paramEngineResponse.getErrorMessage();
            ((SlidingMenuActivity) this.baseContext).clearStackAndFinish();
            Toast.makeText(this.baseContext, (CharSequence) localObject2, 0).show();
        }
        localObject3 = Boolean.valueOf(false);
        localObject2 = localObject3;
        if (paramEngineResponse.getResponse() != null) {
            localObject2 = localObject3;
            if ((paramEngineResponse.getResponse() instanceof HashMap)) {
                localHashMap = (HashMap) paramEngineResponse.getResponse();
                if ((localHashMap.containsKey("is_login_mod")) && (!((Boolean) localHashMap.get("is_login_mod")).booleanValue())) {
                    this.mStatus.closeProgress();
                    DialogUtil.getLoginModDialog(this.baseContext, this.forumStatus, this).show();
                    return;
                }
            }
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
            paramForum = (LinearLayout) LayoutInflater.from(this.baseContext).inflate(2130903265, null);
            paramString = (EditText) paramForum.getChildAt(0);
        }
        while ((paramSlidingMenuActivity.currentFragment == null) || (!(paramSlidingMenuActivity.currentFragment instanceof QuoordFragment)));
        new DialogFragment() {
            public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                new AlertDialog.Builder(ForumRootAdapter.this.baseContext).setTitle(ForumRootAdapter.this.baseContext.getString(2131099959)).setView(paramForum).setCancelable(false).setPositiveButton(ForumRootAdapter.this.baseContext.getString(2131099972), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        ForumRootAdapter.this.loginForum(this.val$password.getText().toString());
                        ((InputMethodManager) ForumRootAdapter.this.baseContext.getSystemService("input_method")).hideSoftInputFromWindow(this.val$password.getWindowToken(), 0);
                    }
                }).setNegativeButton(ForumRootAdapter.this.baseContext.getString(2131099974), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        ((InputMethodManager) ForumRootAdapter.this.baseContext.getSystemService("input_method")).hideSoftInputFromWindow(this.val$password.getWindowToken(), 0);
                    }
                }).create();
            }
        }.show(((QuoordFragment) paramSlidingMenuActivity.currentFragment).getFragmentManager(), "dailog");
        return;
        if (((paramForum.getChildForums() == null) || (paramForum.getChildForums().size() <= 0)) && (paramForum.getUrl() != null) && (paramForum.getUrl().length() > 0)) {
            paramString = ForumUrlUtil.getIdFromUrl(paramForum.getUrl());
            String str = this.forumStatus.getUrl().replace("www.", "").replace("http://", "");
            if ((paramForum.getUrl().contains(str)) && (paramString.containsKey("fid"))) {
                paramString.remove("pid");
                paramString.remove("tid");
                paramSlidingMenuActivity.addFragmentToStack(SubForumFragment.newInstance(paramForum, this.stackType), this.stackType, true);
                return;
            }
            try {
                paramSlidingMenuActivity = new Intent("android.intent.action.VIEW", Uri.parse(paramForum.getUrl()));
                this.baseContext.startActivity(paramSlidingMenuActivity);
                return;
            } catch (Exception paramSlidingMenuActivity) {
                openForum(paramForum);
                return;
            }
        }
        openForum(paramForum);
    }

    public ForumActivityStatus getActivityStatus() {
        return this.mStatus;
    }

    public TapatalkEngine getEngine() {
        return this.engine;
    }

    public boolean getIsLogin(String paramString) {
        boolean bool1 = false;
        boolean bool4 = false;
        boolean bool3 = false;
        boolean bool2 = bool4;
        try {
            String str = AppCacheManager.getForumSessionProtectedUrl(this.baseContext, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
            bool2 = bool4;
            if (AppCacheManager.checkFile(str)) {
                bool2 = bool4;
                ProtectedForumCache localProtectedForumCache = AppCacheManager.getForumSessionProtected(str);
                bool1 = bool3;
                if (localProtectedForumCache != null) {
                    bool1 = bool3;
                    bool2 = bool4;
                    if (localProtectedForumCache.protects != null) {
                        bool1 = bool3;
                        bool2 = bool4;
                        if (localProtectedForumCache.protects.containsKey(paramString)) {
                            bool1 = true;
                        }
                    }
                }
                bool2 = bool1;
                localProtectedForumCache.writeTime = System.currentTimeMillis();
                bool2 = bool1;
                AppCacheManager.cacheData(str, localProtectedForumCache);
            }
            return bool1;
        } catch (Exception paramString) {
        }
        return bool2;
    }

    public View getListView() {
        return this.mListView;
    }

    public Forum getMForum() {
        return this.mForum;
    }

    public boolean getSaxCall() {
        return this.isSaxCall;
    }

    public boolean getTryTwice() {
        return this.tryTwice.booleanValue();
    }

    public int getmLongclickItemPosition() {
        return this.mLongclickItemPosition;
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
        ((SlidingMenuActivity) this.baseContext).addFragmentToStack(SubForumFragment.newInstance(paramForum, this.stackType), this.stackType, true);
    }

    public abstract void parseCallBack(EngineResponse paramEngineResponse);

    void parseCallBackCommonMethod(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
        if ((!((String) localObject1).equals("login_forum")) || (((Boolean) paramEngineResponse.get("result")).booleanValue())) {
        }
        try {
            localObject2 = AppCacheManager.getForumSessionProtectedUrl(this.baseContext, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
            if (!AppCacheManager.checkFile((String) localObject2)) {
                break label201;
            }
            localObject1 = AppCacheManager.getForumSessionProtected((String) localObject2);
            if (localObject1 == null) {
                break label153;
            }
            paramEngineResponse = (EngineResponse) localObject1;
            if (!((ProtectedForumCache) localObject1).protects.containsKey(this.tempForumForLogin.getId())) {
                ((ProtectedForumCache) localObject1).protects.put(this.tempForumForLogin.getId(), Boolean.valueOf(true));
                paramEngineResponse = (EngineResponse) localObject1;
            }
            paramEngineResponse.writeTime = System.currentTimeMillis();
            AppCacheManager.cacheData((String) localObject2, paramEngineResponse);
        } catch (Exception paramEngineResponse) {
            Object localObject2;
            label132:
            label153:
            label201:
            for (; ; ) {
            }
        }
        forumItemClicked(this.tempForumForLogin, true, (SlidingMenuActivity) this.baseContext, this.stackType);
        do {
            return;
            paramEngineResponse = new ProtectedForumCache();
            paramEngineResponse.saveForTime = 1800000L;
            paramEngineResponse.protects = new HashMap();
            paramEngineResponse.protects.put(this.tempForumForLogin.getId(), Boolean.valueOf(true));
            break;
            paramEngineResponse = new ProtectedForumCache();
            paramEngineResponse.saveForTime = 1800000L;
            paramEngineResponse.protects = new HashMap();
            paramEngineResponse.protects.put(this.tempForumForLogin.getId(), Boolean.valueOf(true));
            paramEngineResponse.writeTime = System.currentTimeMillis();
            AppCacheManager.cacheData((String) localObject2, paramEngineResponse);
            break label132;
            Toast.makeText(this.baseContext, this.baseContext.getString(2131099961), 1).show();
            return;
            if (((String) localObject1).equals("m_stick_topic")) {
                notifyDataSetChanged();
                this.mStatus.closeProgress();
                return;
            }
            if (((String) localObject1).equals("m_delete_topic")) {
                Toast.makeText(this.baseContext, this.baseContext.getString(2131100024), 1).show();
                notifyDataSetChanged();
                this.mStatus.closeProgress();
                return;
            }
            if (((String) localObject1).equals("m_undelete_topic")) {
                if ((this instanceof DeleteTopicAdapter)) {
                    ((DeleteTopicAdapter) this).refresh();
                }
                for (; ; ) {
                    notifyDataSetChanged();
                    this.mStatus.closeProgress();
                    return;
                    if ((this instanceof LatestTopicAdapter)) {
                        if (((Topic) ((LatestTopicAdapter) this).getItem(this.mLongclickItemPosition)).isDeleted()) {
                            ((Topic) getItem(this.mLongclickItemPosition)).setDeleted(false);
                            ((LatestTopicAdapter) this).removeItem(this.mLongclickItemPosition);
                            Toast.makeText(this.baseContext, this.baseContext.getString(2131100029), 1).show();
                        }
                    } else if (((this instanceof SubForumAdapter)) && (((Topic) ((SubForumAdapter) this).getItem(this.mLongclickItemPosition)).isDeleted())) {
                        ((Topic) getItem(this.mLongclickItemPosition)).setDeleted(false);
                        ((SubForumAdapter) this).removeItem(this.mLongclickItemPosition);
                        Toast.makeText(this.baseContext, this.baseContext.getString(2131100029), 1).show();
                    }
                }
            }
            if (((String) localObject1).equals("m_undelete_post")) {
                if ((this instanceof DeleteTopicAdapter)) {
                    ((DeleteTopicAdapter) this).refresh();
                }
                for (; ; ) {
                    notifyDataSetChanged();
                    this.mStatus.closeProgress();
                    return;
                    if (((this instanceof ThreadAdapter)) && ((((ThreadAdapter) this).getItem(this.mLongclickItemPosition) instanceof HashMap))) {
                        paramEngineResponse = (String) ((HashMap) ((ThreadAdapter) this).getItem(this.mLongclickItemPosition)).get("post_id");
                        ((ThreadAdapter) this).postDatas.remove(paramEngineResponse);
                        ((ThreadAdapter) this).refresh();
                    }
                }
            }
            if (((String) localObject1).equals("m_approve_topic")) {
                if ((this instanceof ModerateTopicAdapter)) {
                    ((ModerateTopicAdapter) this).refresh();
                }
                notifyDataSetChanged();
                this.mStatus.closeProgress();
                return;
            }
            if (((String) localObject1).equals("m_approve_post")) {
                notifyDataSetChanged();
                this.mStatus.closeProgress();
                return;
            }
            if (((String) localObject1).equals("m_close_topic")) {
                notifyDataSetChanged();
                this.mStatus.closeProgress();
                return;
            }
            if (((String) localObject1).equals("m_ban_user")) {
                if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
                    localObject1 = this.baseContext.getString(2131100061);
                    if ((this instanceof UserInfoAdapter)) {
                        paramEngineResponse = this.banUsername + " " + (String) localObject1;
                        Toast.makeText(this.baseContext, paramEngineResponse, 1).show();
                    }
                }
                for (; ; ) {
                    notifyDataSetChanged();
                    this.mStatus.closeProgress();
                    return;
                    localObject2 = getItem(this.mLongclickItemPosition);
                    paramEngineResponse = (EngineResponse) localObject1;
                    if (!(localObject2 instanceof Topic)) {
                        break;
                    }
                    ((Topic) localObject2).setBan(true);
                    paramEngineResponse = this.banUsername + " " + (String) localObject1;
                    break;
                    if (paramEngineResponse.get("result_text") != null) {
                        Toast.makeText(this.baseContext, new String((byte[]) paramEngineResponse.get("result_text")).toString(), 1).show();
                    }
                }
            }
        } while (!((String) localObject1).equals("m_delete_post"));
        if (((Boolean) paramEngineResponse.get("result")).booleanValue()) {
            Util.showToastForLong(this.baseContext, this.baseContext.getString(2131100025));
        }
        for (; ; ) {
            if (((this instanceof ThreadAdapter)) && (((ThreadAdapter) this).mOutFragment != null) && (((ThreadAdapter) this).mOutFragment.quoteHelper != null)) {
                ((ThreadAdapter) this).mOutFragment.quoteHelper.actionFinish();
            }
            notifyDataSetChanged();
            this.mStatus.closeProgress();
            return;
            paramEngineResponse = new String((byte[]) paramEngineResponse.get("result_text")).toString();
            Util.showToastForLong(this.baseContext, paramEngineResponse);
        }
    }

    protected boolean parseCallBackPreCheck(final EngineResponse paramEngineResponse)
            throws RemoteException {
        try {
            bool = paramEngineResponse.isSuccess();
            localBoolean = Boolean.valueOf(bool);
        } catch (Exception localException) {
            for (; ; ) {
                boolean bool;
                Boolean localBoolean;
                localObject = Boolean.valueOf(false);
            }
            paramEngineResponse.loginForum(this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), this.forumStatus.tapatalkForum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                public void actionErrorBack(String paramAnonymousString1, String paramAnonymousString2) {
                }

                public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                    if ((ForumRootAdapter.this.getTryTwice()) && (paramAnonymousForumStatus.isLogin())) {
                        if (ForumRootAdapter.this.getSaxCall()) {
                            ForumRootAdapter.this.engine.resaxcall();
                        }
                    } else {
                        return;
                    }
                    ForumRootAdapter.this.engine.reCall();
                }
            });
            return false;
        }
        if (localBoolean.booleanValue()) {
            if (isOpCancel()) {
                break label397;
            }
            paramEngineResponse = paramEngineResponse.getMethod();
            if ((this.forumStatus != null) && (!paramEngineResponse.equals(this.forumStatus.getAuthroizeUserFunction())) && (!paramEngineResponse.equals("get_config")) && (!paramEngineResponse.equals("sign_in")) && (!paramEngineResponse.equals("logout_user")) && (!paramEngineResponse.equalsIgnoreCase(this.forumStatus.getUrl()))) {
                if ((!this.forumStatus.isLogin()) || (this.engine.getLoginStatus()) || (this.tryTwice.booleanValue()) || (this.baseContext.getResources().getBoolean(2131558402))) {
                    break label397;
                }
                this.tryTwice = Boolean.valueOf(true);
                this.prefs = Prefs.get(this.baseContext);
                bool = this.forumStatus.isSignInForumUser(this.baseContext);
                paramEngineResponse = new ForumLoginOrSignAction(this.baseContext, this.forumStatus);
                if ((this.forumStatus.isTapatalkSignIn(this.baseContext)) && (bool) && (!this.forumStatus.tapatalkForum.hasPassword())) {
                    paramEngineResponse.signForum(this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), null, false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                        public void actionErrorBack(String paramAnonymousString1, String paramAnonymousString2) {
                            if ((ForumRootAdapter.this.forumStatus.tapatalkForum.getPassword() != null) && (ForumRootAdapter.this.forumStatus.tapatalkForum.getPassword().equals(""))) {
                                paramEngineResponse.loginForum(ForumRootAdapter.this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), ForumRootAdapter.this.forumStatus.tapatalkForum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                                    public void actionErrorBack(String paramAnonymous2String1, String paramAnonymous2String2) {
                                    }

                                    public void actionSuccessBack(ForumStatus paramAnonymous2ForumStatus) {
                                        if ((ForumRootAdapter.this.getTryTwice()) && (paramAnonymous2ForumStatus.isLogin())) {
                                            if (ForumRootAdapter.this.getSaxCall()) {
                                                ForumRootAdapter.this.engine.resaxcall();
                                            }
                                        } else {
                                            return;
                                        }
                                        ForumRootAdapter.this.engine.reCall();
                                    }
                                });
                            }
                        }

                        public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                            paramAnonymousForumStatus.setSignInForumUser(ForumRootAdapter.this.baseContext);
                            if ((ForumRootAdapter.this.getTryTwice()) && (paramAnonymousForumStatus.isLogin())) {
                                if (ForumRootAdapter.this.getSaxCall()) {
                                    ForumRootAdapter.this.engine.resaxcall();
                                }
                            } else {
                                return;
                            }
                            ForumRootAdapter.this.engine.reCall();
                        }
                    });
                }
            }
        }
        for (; ; ) {
            return false;
            Object localObject;
            return true;
            if (paramEngineResponse.getMethod().toString().equals(this.forumStatus.getUrl())) {
                return true;
            }
            try {
                paramEngineResponse.getErrorMessage();
                localObject = new HashMap();
                ((Map) localObject).put("errormessage", this.baseContext.getString(2131100071));
                if ((this.shouldShowError) && (paramEngineResponse.getMethod() != null) && (!paramEngineResponse.getMethod().equals("get_thread"))) {
                    this.mStatus.updateUI(13, localObject);
                    return false;
                }
            } catch (Exception paramEngineResponse) {
                paramEngineResponse.printStackTrace();
                return false;
            }
        }
        label397:
        return true;
    }

    public void recallAfterLoginMod() {
        getEngine().reCall();
    }

    public abstract void refresh();

    public void removeItem(int paramInt) {
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

    public void setmLongclickItemPosition(int paramInt) {
        this.mLongclickItemPosition = paramInt;
    }

    public void showView() {
    }

    public void tryFailed(String paramString) {
        if ((this.baseContext instanceof SlidingMenuActivity)) {
            ((SlidingMenuActivity) this.baseContext).clearStack();
            ((SlidingMenuActivity) this.baseContext).showLoginView();
        }
    }

    public void updateIcons() {
        notifyDataSetChanged();
    }

    public void updateSubclassDialog(int paramInt) {
        try {
            this.mStatus.updateDialog(paramInt);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ForumRootAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */