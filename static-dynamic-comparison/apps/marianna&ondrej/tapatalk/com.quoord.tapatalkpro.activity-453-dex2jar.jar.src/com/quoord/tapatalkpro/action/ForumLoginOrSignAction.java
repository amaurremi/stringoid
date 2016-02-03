package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.log.LogNewSession;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ForumStatusCache;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.net.HashUtil;
import com.quoord.tools.net.TapatalkAjaxLogAction;
import com.quoord.tools.net.TapatalkLogUrlUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class ForumLoginOrSignAction
        implements TryTwiceCallBackInterface {
    private ActionCallBack actionCallBack;
    private Context context;
    private TapatalkEngine engine;
    private String errorMsg = "";
    private String forceViewThreadId;
    private ForumStatus forumStatus;
    private boolean isNewLogin = false;
    private boolean isRegister = false;
    private boolean needAddAccount = false;
    private boolean needLog = false;
    private int postCount = 0;
    private String status = "0";
    private boolean tryTwice = true;
    private ActionFoceViewAThread viewThreadAction;

    public ForumLoginOrSignAction(Context paramContext, ForumStatus paramForumStatus) {
        this.context = paramContext;
        this.forumStatus = paramForumStatus;
        this.engine = new TapatalkEngine(this, this.forumStatus, this.context);
    }

    public void addAccount() {
        label269:
        for (; ; ) {
            try {
                Object localObject1 = this.forumStatus.getRegister_email();
                Object localObject2 = TapatalkIdFactory.getTapatalkId(this.context).getTapatalkIdEmail();
                String str1 = this.forumStatus.tapatalkForum.getFromByoAccountChannel();
                int i = TapatalkAccountAction.getCurrentForumOrder(this.context, this.forumStatus.tapatalkForum);
                if ((localObject1 != null) && (!((String) localObject1).equals(localObject2)) && (this.forumStatus.isSsoLogin())) {
                    localObject2 = this.context;
                    str2 = this.forumStatus.tapatalkForum.getId();
                    str3 = this.forumStatus.tapatalkForum.getUserNameOrDisplayName();
                    str4 = this.forumStatus.tapatalkForum.getDisplayNameOrUsername();
                    String str5 = this.forumStatus.tapatalkForum.getUserId();
                    if (str1 != null) {
                        break label269;
                    }
                    str1 = "account";
                    TapatalkJsonEngine.auAddAccount((Context) localObject2, str2, str3, str4, str5, "0", str1, (String) localObject1, i, this.postCount);
                    return;
                }
                localObject1 = this.context;
                localObject2 = this.forumStatus.tapatalkForum.getId();
                String str2 = this.forumStatus.tapatalkForum.getUserNameOrDisplayName();
                String str3 = this.forumStatus.tapatalkForum.getDisplayNameOrUsername();
                String str4 = this.forumStatus.tapatalkForum.getUserId();
                if (str1 == null) {
                    str1 = "account";
                    TapatalkJsonEngine.auAddAccount((Context) localObject1, (String) localObject2, str2, str3, str4, "1", str1, "", i, this.postCount);
                    return;
                }
            } catch (Exception localException) {
                return;
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        boolean bool = paramEngineResponse.isSuccess();
        String str = paramEngineResponse.getMethod();
        if (bool) {
            if ((str.equalsIgnoreCase("sign_in")) || (str.equals(this.forumStatus.getAuthroizeUserFunction()))) {
                paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                bool = ((Boolean) paramEngineResponse.get("result")).booleanValue();
                if (!bool) {
                    break label451;
                }
                if ((paramEngineResponse.containsKey("result_text")) && (paramEngineResponse.get("result_text") != null)) {
                    this.forumStatus.setBanedTips(new String((byte[]) paramEngineResponse.get("result_text")).toString());
                }
                setLoginData(paramEngineResponse, this.forumStatus, this.context);
                if (str.equalsIgnoreCase("sign_in")) {
                    this.forumStatus.setSignInForumUser(this.context);
                    this.isRegister = ((Boolean) paramEngineResponse.get("register")).booleanValue();
                }
                if (this.actionCallBack != null) {
                    this.actionCallBack.actionSuccessBack(this.forumStatus);
                }
                if ((this.viewThreadAction != null) && (this.forceViewThreadId != null) && (!this.forceViewThreadId.equals(""))) {
                    this.viewThreadAction.actionViewThread(this.forceViewThreadId);
                }
                paramEngineResponse = Prefs.get(this.context).edit();
                paramEngineResponse.putBoolean(Util.getSignOutKey(this.context, this.forumStatus.tapatalkForum), false);
            }
        }
        label450:
        label451:
        label559:
        do {
            paramEngineResponse.commit();
            break label450;
            if ((this.needAddAccount) && (bool)) {
                Util.saveFavoriate(this.context, this.forumStatus.tapatalkForum, "search", false);
                if (Util.isFavoriate(this.context, this.forumStatus.tapatalkForum.getId().intValue())) {
                    addAccount();
                }
            }
            if (this.needLog) {
                if (bool) {
                    new LogNewSession(this.context, this.forumStatus).log(this.isRegister, this.isNewLogin, false);
                }
                if (str.equalsIgnoreCase("sign_in")) {
                    paramEngineResponse = new TapatalkAjaxLogAction(this.context);
                    i = 0;
                    if (!this.isRegister) {
                        break label559;
                    }
                    if (bool) {
                        i = 1;
                    }
                    if (bool) {
                    }
                }
            }
            for (int i = -1; ; i = 0) {
                if ((this.status != null) && (!this.status.equals("1"))) {
                    paramEngineResponse.logTapatalkLog(TapatalkLogUrlUtil.getAuLogSignLogUrl(this.context, this.forumStatus, bool, i, this.status, this.errorMsg));
                }
                this.isNewLogin = false;
                this.isRegister = false;
                return;
                if (this.actionCallBack == null) {
                    break;
                }
                if (paramEngineResponse.containsKey("result_text")) {
                }
                try {
                    this.errorMsg = new String((byte[]) paramEngineResponse.get("result_text"), "UTF-8");
                    if (paramEngineResponse.containsKey("status")) {
                        this.status = ((String) paramEngineResponse.get("status"));
                    }
                    this.actionCallBack.actionErrorBack(this.errorMsg, this.status);
                } catch (Exception localException) {
                    for (; ; ) {
                        this.errorMsg = new String((byte[]) paramEngineResponse.get("result_text"));
                    }
                }
            }
            str = paramEngineResponse.getErrorMessage();
            if (str != null) {
                paramEngineResponse = str;
                if (!str.equals("")) {
                }
            } else {
                paramEngineResponse = this.context.getString(2131100071);
            }
        } while (this.actionCallBack == null);
        this.actionCallBack.actionErrorBack(paramEngineResponse, "0");
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

    public void loginForum(String paramString1, String paramString2) {
        loginForum(paramString1, paramString2, false, false, false, null);
    }

    public void loginForum(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
        loginForum(paramString1, paramString2, paramBoolean1, false, paramBoolean2, null);
    }

    public void loginForum(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ActionCallBack paramActionCallBack) {
        loginForum(paramString1, paramString2, paramBoolean1, paramBoolean2, false, paramBoolean3, paramActionCallBack);
    }

    public void loginForum(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ActionCallBack paramActionCallBack) {
        loginForum(paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramActionCallBack, null);
    }

    public void loginForum(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ActionCallBack paramActionCallBack, ActionFoceViewAThread paramActionFoceViewAThread) {
        this.needLog = paramBoolean1;
        this.isNewLogin = paramBoolean2;
        this.isRegister = paramBoolean3;
        this.needAddAccount = paramBoolean4;
        this.actionCallBack = paramActionCallBack;
        this.viewThreadAction = paramActionFoceViewAThread;
        paramActionFoceViewAThread = new ArrayList();
        try {
            paramActionCallBack = paramString1.trim().getBytes("UTF-8");
            paramString1 = paramActionCallBack;
        } catch (UnsupportedEncodingException paramActionCallBack) {
            for (; ; ) {
                try {
                    paramString1 = paramString2.getBytes("UTF-8");
                    paramActionFoceViewAThread.add(paramString1);
                    if (this.forumStatus.tapatalkForum.isPush()) {
                        paramActionFoceViewAThread.add(Boolean.valueOf(false));
                        paramActionFoceViewAThread.add("1");
                    }
                    this.engine.call(this.forumStatus.getAuthroizeUserFunction(), paramActionFoceViewAThread);
                    return;
                    paramActionCallBack = paramActionCallBack;
                    paramString1 = paramString1.trim().getBytes();
                } catch (UnsupportedEncodingException paramString1) {
                    paramString1 = paramString2.getBytes();
                    continue;
                }
                paramActionFoceViewAThread.add(paramString1);
                paramActionFoceViewAThread.add(paramString2);
            }
        }
        if (this.forumStatus.getApiLevel() >= 3) {
            paramActionFoceViewAThread.add(paramString1);
        }
    }

    public void savePassWord(ForumStatus paramForumStatus, Context paramContext) {
        try {
            Object localObject = AppCacheManager.getForumStatusCacheUrl(paramContext, paramForumStatus.getUrl(), paramForumStatus.tapatalkForum.getCacheUsernameDir());
            ForumStatusCache localForumStatusCache = new ForumStatusCache();
            localForumStatusCache.writeTime = System.currentTimeMillis();
            localForumStatusCache.saveForTime = 86400000L;
            localForumStatusCache.forumStatus = paramForumStatus;
            AppCacheManager.cacheForumStatusData((String) localObject, localForumStatusCache);
            localObject = Prefs.get(paramContext).edit();
            long l = System.currentTimeMillis();
            ((SharedPreferences.Editor) localObject).putLong(paramForumStatus.getForumId() + "|last_visit_time_new", Long.valueOf(l).longValue());
            ((SharedPreferences.Editor) localObject).putInt(paramForumStatus.getForumId() + "|api_level", paramForumStatus.getApiLevel());
            ((SharedPreferences.Editor) localObject).putString(paramForumStatus.getForumId() + "|version", paramForumStatus.tapatalkForum.getVersion());
            ((SharedPreferences.Editor) localObject).putBoolean(paramForumStatus.getForumId() + "|anonymous", paramForumStatus.isSupportAnonymous());
            if ((paramForumStatus.isLogin()) && (paramForumStatus.tapatalkForum.getUserName() != null) && (paramForumStatus.tapatalkForum.hasPassword())) {
                ((SharedPreferences.Editor) localObject).putString(paramForumStatus.getForumId() + "|version", paramForumStatus.tapatalkForum.getVersion());
                ((SharedPreferences.Editor) localObject).putBoolean(paramForumStatus.getForumId() + "|canpm", paramForumStatus.isCanPm());
                ((SharedPreferences.Editor) localObject).putBoolean(paramForumStatus.getForumId() + "|supportunread", paramForumStatus.isSupportGoUnread());
            }
            paramContext = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
            if (paramForumStatus.isLogin()) {
                paramContext.saveFavoriate(paramForumStatus.tapatalkForum);
            }
            ((SharedPreferences.Editor) localObject).commit();
            return;
        } catch (Exception localException) {
            for (; ; ) {
                localException.printStackTrace();
            }
        }
    }

    public void setLoginData(HashMap paramHashMap, ForumStatus paramForumStatus, Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (paramHashMap.containsKey("post_count")) {
        }
        try {
            this.postCount = ((Integer) paramHashMap.get("post_count")).intValue();
            if (paramHashMap.containsKey("display_thread_id")) {
            }
            try {
                this.forceViewThreadId = ((String) paramHashMap.get("display_thread_id"));
                if (paramHashMap.containsKey("user_type")) {
                    paramForumStatus.setUserType(new String((byte[]) paramHashMap.get("user_type")));
                }
                if (paramHashMap.containsKey("can_pm")) {
                    paramForumStatus.setCanPm(((Boolean) paramHashMap.get("can_pm")).booleanValue());
                    paramForumStatus.tapatalkForum.setPMEnable(((Boolean) paramHashMap.get("can_pm")).booleanValue());
                }
                for (; ; ) {
                    if (paramHashMap.containsKey("can_send_pm")) {
                        paramForumStatus.setCanSendPm(((Boolean) paramHashMap.get("can_send_pm")).booleanValue());
                        label162:
                        if (!paramHashMap.containsKey("max_attachment")) {
                            break label1035;
                        }
                        paramForumStatus.setMaxAttachments(((Integer) paramHashMap.get("max_attachment")).intValue());
                        paramForumStatus.setHaveMaxAttachmentKey(true);
                        label194:
                        if (!paramHashMap.containsKey("max_jpg_size")) {
                        }
                    }
                    try {
                        paramForumStatus.setMaxJpgSize(((Integer) paramHashMap.get("max_jpg_size")).intValue());
                        if (paramHashMap.containsKey("max_png_size")) {
                        }
                        try {
                            paramForumStatus.setMaxJpgSize(((Integer) paramHashMap.get("max_png_size")).intValue());
                            if (paramHashMap.containsKey("can_moderate")) {
                                paramForumStatus.setCanModerate(((Boolean) paramHashMap.get("can_moderate")).booleanValue());
                            }
                            if (paramHashMap.containsKey("username")) {
                                paramForumStatus.tapatalkForum.setDisplayName(HashUtil.getString(paramHashMap.get("username")));
                            }
                            if (paramHashMap.containsKey("login_name")) {
                                paramForumStatus.tapatalkForum.setUserName(HashUtil.getString(paramHashMap.get("login_name")));
                            }
                            if (paramHashMap.containsKey("can_upload_avatar")) {
                                paramForumStatus.setSupportUploadAvatar(((Boolean) paramHashMap.get("can_upload_avatar")).booleanValue());
                            }
                            Object localObject;
                            if (paramHashMap.containsKey("email")) {
                                paramForumStatus.setRegister_email(new String((byte[]) paramHashMap.get("email")));
                                localObject = localSharedPreferences.edit();
                                ((SharedPreferences.Editor) localObject).putString("register_email", new String((byte[]) paramHashMap.get("email")));
                                ((SharedPreferences.Editor) localObject).commit();
                            }
                            if (paramHashMap.containsKey("can_search")) {
                                paramForumStatus.setCanSearch(((Boolean) paramHashMap.get("can_search")).booleanValue());
                            }
                            if (paramHashMap.containsKey("can_whosonline")) {
                                paramForumStatus.setCanWhoOnline(((Boolean) paramHashMap.get("can_whosonline")).booleanValue());
                            }
                            label539:
                            int i;
                            if (paramHashMap.containsKey("user_id")) {
                                if ((paramHashMap.get("user_id") instanceof Integer)) {
                                    paramForumStatus.tapatalkForum.setUserId((Integer) paramHashMap.get("user_id"));
                                }
                            } else {
                                if (paramHashMap.containsKey("icon_url")) {
                                    paramForumStatus.setAvatarUrl((String) paramHashMap.get("icon_url"));
                                    if (!Util.isEmpty((String) paramHashMap.get("icon_url"))) {
                                        paramForumStatus.tapatalkForum.setUserIconUrl((String) paramHashMap.get("icon_url"));
                                    }
                                }
                                paramForumStatus.clearUserGroupId();
                                if (paramHashMap.containsKey("usergroup_id")) {
                                    localObject = (Object[]) paramHashMap.get("usergroup_id");
                                    AppCacheManager.cacheData(AppCacheManager.getGroupUrl(paramContext), localObject);
                                    i = 0;
                                    label634:
                                    if (i < localObject.length) {
                                        break label1063;
                                    }
                                }
                                if (!paramHashMap.containsKey("allowed_extensions")) {
                                }
                            }
                            try {
                                paramForumStatus.setAllowed_extensions((String) paramHashMap.get("allowed_extensions"));
                                if (paramHashMap.containsKey("max_attachment_size")) {
                                }
                                try {
                                    paramForumStatus.setMax_attachment_size(((Integer) paramHashMap.get("max_attachment_size")).intValue());
                                    if (paramHashMap.containsKey("post_countdown")) {
                                    }
                                    try {
                                        paramForumStatus.setPost_countdown(((Integer) paramHashMap.get("post_countdown")).intValue());
                                        if ((paramForumStatus.getMax_attachment_size() == 0) && (paramForumStatus.getAllowed_extensions() != null)) {
                                            if (!paramForumStatus.getAllowed_extensions().contains(",")) {
                                                break label1150;
                                            }
                                            localObject = paramForumStatus.getAllowed_extensions().split(",");
                                            i = 0;
                                            label762:
                                            if (i < localObject.length) {
                                                break label1084;
                                            }
                                        }
                                        for (; ; ) {
                                            paramForumStatus.setLogin(true);
                                            long l1 = localSharedPreferences.getLong("update_new_login" + new StringBuilder().append(paramForumStatus.tapatalkForum.getId()).append(paramForumStatus.tapatalkForum.getUserId()).toString().hashCode(), 0L);
                                            long l2 = System.currentTimeMillis();
                                            if ((l2 - l1) / 86400000L > 6L) {
                                                new LogNewLogin(paramContext, paramForumStatus).log();
                                                localSharedPreferences.edit().putFloat("update_new_login" + new StringBuilder().append(paramForumStatus.tapatalkForum.getId()).append(paramForumStatus.tapatalkForum.getUserId()).toString().hashCode(), (float) l2);
                                                localSharedPreferences.edit().commit();
                                            }
                                            new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
                                            if (paramForumStatus.isLogin()) {
                                                i = TapatalkAccountAction.getCurrentForumOrder(this.context, paramForumStatus.tapatalkForum);
                                                paramHashMap = TapatalkAccountAction.getCurrnentAllAccount((Activity) this.context);
                                                paramContext = AppCacheManager.getCloudAccountUrl(this.context);
                                                paramHashMap.add(i, paramForumStatus.tapatalkForum);
                                                AppCacheManager.cacheData(paramContext, paramHashMap);
                                            }
                                            return;
                                            paramForumStatus.setCanPm(true);
                                            break;
                                            paramForumStatus.setCanSendPm(true);
                                            break label162;
                                            label1035:
                                            paramForumStatus.setHaveMaxAttachmentKey(false);
                                            break label194;
                                            paramForumStatus.tapatalkForum.setUserId((String) paramHashMap.get("user_id"));
                                            break label539;
                                            label1063:
                                            paramForumStatus.setUserGroupId((String) localObject[i]);
                                            i += 1;
                                            break label634;
                                            label1084:
                                            int j = ((Integer) paramHashMap.get("max_" + localObject[i] + "_size")).intValue();
                                            paramForumStatus.getEach_extension_size().put(localObject[i], Integer.valueOf(j));
                                            i += 1;
                                            break label762;
                                            label1150:
                                            paramForumStatus.getEach_extension_size().put(paramForumStatus.getAllowed_extensions(), (Integer) paramHashMap.get(paramForumStatus.getAllowed_extensions()));
                                        }
                                    } catch (Exception localException1) {
                                        for (; ; ) {
                                        }
                                    }
                                } catch (Exception localException2) {
                                    for (; ; ) {
                                    }
                                }
                            } catch (Exception localException3) {
                                for (; ; ) {
                                }
                            }
                        } catch (Exception localException4) {
                            for (; ; ) {
                            }
                        }
                    } catch (Exception localException5) {
                        for (; ; ) {
                        }
                    }
                }
            } catch (Exception localException6) {
                for (; ; ) {
                }
            }
        } catch (Exception localException7) {
            for (; ; ) {
            }
        }
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void signForum(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ActionCallBack paramActionCallBack) {
        signForum(paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, false, paramActionCallBack, null);
    }

    /* Error */
    public void signForum(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, HashMap paramHashMap, boolean paramBoolean4, ActionCallBack paramActionCallBack, ActionFoceViewAThread paramActionFoceViewAThread) {
        // Byte code:
        //   0: aload_0
        //   1: iload_3
        //   2: putfield 43	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:needLog	Z
        //   5: aload_0
        //   6: iload 4
        //   8: putfield 47	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:isNewLogin	Z
        //   11: aload_0
        //   12: aload 8
        //   14: putfield 212	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:actionCallBack	Lcom/quoord/tapatalkpro/action/ForumLoginOrSignAction$ActionCallBack;
        //   17: aload_0
        //   18: iload 5
        //   20: putfield 45	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:needAddAccount	Z
        //   23: aload_0
        //   24: iload 7
        //   26: putfield 49	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:isRegister	Z
        //   29: aload_0
        //   30: aload 9
        //   32: putfield 218	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:viewThreadAction	Lcom/quoord/tapatalkpro/action/ForumLoginOrSignAction$ActionFoceViewAThread;
        //   35: aload_0
        //   36: getfield 61	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:context	Landroid/content/Context;
        //   39: invokestatic 86	com/quoord/tapatalkpro/ics/tapatalkid/TapatalkIdFactory:getTapatalkId	(Landroid/content/Context;)Lcom/quoord/tapatalkpro/bean/TapatalkId;
        //   42: astore 8
        //   44: new 118	java/lang/StringBuilder
        //   47: dup
        //   48: invokespecial 119	java/lang/StringBuilder:<init>	()V
        //   51: aload_0
        //   52: getfield 63	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   55: getfield 95	com/quoord/tapatalkpro/bean/ForumStatus:tapatalkForum	Lcom/quoord/tapatalkpro/bean/TapatalkForum;
        //   58: invokevirtual 123	com/quoord/tapatalkpro/bean/TapatalkForum:getId	()Ljava/lang/Integer;
        //   61: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   64: ldc_w 684
        //   67: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   70: aload 8
        //   72: invokeinterface 687 1 0
        //   77: invokevirtual 630	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   80: ldc_w 684
        //   83: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   86: aload 8
        //   88: invokeinterface 91 1 0
        //   93: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   96: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   99: invokestatic 691	com/quoord/tapatalkpro/util/Util:getMD5	(Ljava/lang/String;)Ljava/lang/String;
        //   102: astore 9
        //   104: aload 8
        //   106: invokeinterface 694 1 0
        //   111: astore 10
        //   113: new 326	java/util/ArrayList
        //   116: dup
        //   117: invokespecial 327	java/util/ArrayList:<init>	()V
        //   120: astore 8
        //   122: aload 8
        //   124: aload 10
        //   126: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   129: pop
        //   130: aload_0
        //   131: getfield 63	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   134: getfield 95	com/quoord/tapatalkpro/bean/ForumStatus:tapatalkForum	Lcom/quoord/tapatalkpro/bean/TapatalkForum;
        //   137: invokevirtual 139	com/quoord/tapatalkpro/bean/TapatalkForum:getUserId	()Ljava/lang/String;
        //   140: ifnull +190 -> 330
        //   143: aload_0
        //   144: getfield 63	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   147: getfield 95	com/quoord/tapatalkpro/bean/ForumStatus:tapatalkForum	Lcom/quoord/tapatalkpro/bean/TapatalkForum;
        //   150: invokevirtual 139	com/quoord/tapatalkpro/bean/TapatalkForum:getUserId	()Ljava/lang/String;
        //   153: ldc 55
        //   155: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   158: ifne +172 -> 330
        //   161: aload_0
        //   162: getfield 63	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   165: getfield 95	com/quoord/tapatalkpro/bean/ForumStatus:tapatalkForum	Lcom/quoord/tapatalkpro/bean/TapatalkForum;
        //   168: invokevirtual 139	com/quoord/tapatalkpro/bean/TapatalkForum:getUserId	()Ljava/lang/String;
        //   171: ldc 51
        //   173: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   176: ifne +154 -> 330
        //   179: aload 8
        //   181: new 118	java/lang/StringBuilder
        //   184: dup
        //   185: aload 9
        //   187: invokestatic 397	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   190: invokespecial 399	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   193: ldc_w 696
        //   196: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   199: aload_0
        //   200: getfield 63	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   203: getfield 95	com/quoord/tapatalkpro/bean/ForumStatus:tapatalkForum	Lcom/quoord/tapatalkpro/bean/TapatalkForum;
        //   206: invokevirtual 139	com/quoord/tapatalkpro/bean/TapatalkForum:getUserId	()Ljava/lang/String;
        //   209: invokevirtual 404	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   212: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   215: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   218: pop
        //   219: aload_2
        //   220: invokestatic 699	com/quoord/tapatalkpro/util/Util:checkString	(Ljava/lang/String;)Z
        //   223: ifeq +128 -> 351
        //   226: aload_2
        //   227: invokevirtual 702	java/lang/String:toLowerCase	()Ljava/lang/String;
        //   230: astore 9
        //   232: aload 9
        //   234: ldc_w 704
        //   237: invokevirtual 334	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   240: astore_2
        //   241: aload 8
        //   243: aload_2
        //   244: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   247: pop
        //   248: aload_1
        //   249: invokestatic 699	com/quoord/tapatalkpro/util/Util:checkString	(Ljava/lang/String;)Z
        //   252: ifeq +123 -> 375
        //   255: aload_1
        //   256: invokevirtual 330	java/lang/String:trim	()Ljava/lang/String;
        //   259: ldc_w 290
        //   262: invokevirtual 334	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   265: astore_1
        //   266: aload 8
        //   268: aload_1
        //   269: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   272: pop
        //   273: aload_0
        //   274: getfield 63	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:forumStatus	Lcom/quoord/tapatalkpro/bean/ForumStatus;
        //   277: invokevirtual 337	com/quoord/tapatalkpro/bean/ForumStatus:getApiLevel	()I
        //   280: iconst_3
        //   281: if_icmplt +117 -> 398
        //   284: bipush 12
        //   286: invokestatic 709	com/quoord/tapatalkpro/ics/tapatalkid/SignInWithOtherUtil:createDefaultPassWord	(I)Ljava/lang/String;
        //   289: astore_2
        //   290: aload_2
        //   291: ldc_w 290
        //   294: invokevirtual 334	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   297: astore_1
        //   298: aload 8
        //   300: aload_1
        //   301: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   304: pop
        //   305: aload 6
        //   307: ifnull +11 -> 318
        //   310: aload 8
        //   312: aload 6
        //   314: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   317: pop
        //   318: aload_0
        //   319: getfield 70	com/quoord/tapatalkpro/action/ForumLoginOrSignAction:engine	Lcom/quoord/tapatalkpro/util/TapatalkEngine;
        //   322: ldc -95
        //   324: aload 8
        //   326: invokevirtual 351	com/quoord/tapatalkpro/util/TapatalkEngine:call	(Ljava/lang/String;Ljava/util/ArrayList;)V
        //   329: return
        //   330: aload 8
        //   332: aload 9
        //   334: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   337: pop
        //   338: goto -119 -> 219
        //   341: astore_2
        //   342: aload 9
        //   344: invokevirtual 354	java/lang/String:getBytes	()[B
        //   347: astore_2
        //   348: goto -107 -> 241
        //   351: aload 8
        //   353: ldc 55
        //   355: invokevirtual 354	java/lang/String:getBytes	()[B
        //   358: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   361: pop
        //   362: goto -114 -> 248
        //   365: astore_1
        //   366: ldc 55
        //   368: invokevirtual 354	java/lang/String:getBytes	()[B
        //   371: astore_1
        //   372: goto -106 -> 266
        //   375: aload 8
        //   377: ldc 55
        //   379: invokevirtual 354	java/lang/String:getBytes	()[B
        //   382: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   385: pop
        //   386: goto -113 -> 273
        //   389: astore_1
        //   390: aload_2
        //   391: invokevirtual 354	java/lang/String:getBytes	()[B
        //   394: astore_1
        //   395: goto -97 -> 298
        //   398: aload 8
        //   400: bipush 12
        //   402: invokestatic 709	com/quoord/tapatalkpro/ics/tapatalkid/SignInWithOtherUtil:createDefaultPassWord	(I)Ljava/lang/String;
        //   405: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   408: pop
        //   409: goto -104 -> 305
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	412	0	this	ForumLoginOrSignAction
        //   0	412	1	paramString1	String
        //   0	412	2	paramString2	String
        //   0	412	3	paramBoolean1	boolean
        //   0	412	4	paramBoolean2	boolean
        //   0	412	5	paramBoolean3	boolean
        //   0	412	6	paramHashMap	HashMap
        //   0	412	7	paramBoolean4	boolean
        //   0	412	8	paramActionCallBack	ActionCallBack
        //   0	412	9	paramActionFoceViewAThread	ActionFoceViewAThread
        //   111	14	10	str	String
        // Exception table:
        //   from	to	target	type
        //   232	241	341	java/lang/Exception
        //   255	266	365	java/lang/Exception
        //   290	298	389	java/io/UnsupportedEncodingException
    }

    public void signForum(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ActionCallBack paramActionCallBack) {
        signForum(paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramActionCallBack, null);
    }

    public void signForum(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ActionCallBack paramActionCallBack, ActionFoceViewAThread paramActionFoceViewAThread) {
        signForum(paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, null, paramBoolean4, paramActionCallBack, paramActionFoceViewAThread);
    }

    public void signForum(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        signForum(paramString, null, this.needLog, false, paramBoolean2, false, null);
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface ActionCallBack {
        public abstract void actionErrorBack(String paramString1, String paramString2);

        public abstract void actionSuccessBack(ForumStatus paramForumStatus);
    }

    public static abstract interface ActionFoceViewAThread {
        public abstract void actionViewThread(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/ForumLoginOrSignAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */