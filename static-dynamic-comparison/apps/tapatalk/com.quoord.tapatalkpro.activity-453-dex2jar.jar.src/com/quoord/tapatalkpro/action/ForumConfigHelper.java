package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.forum.ConfigAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ForumCookiesCache;
import com.quoord.tapatalkpro.cache.ForumStatusCache;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;

public class ForumConfigHelper {
    private ActionCallBack actionCallBack;
    private Activity activity;
    private ForumStatus forumStatus;
    private ForumLoginOrSignAction loginOrSignAction;
    private boolean needTryLogin;
    private SharedPreferences prefs;
    private TapatalkForum tapatalkForum;

    public ForumConfigHelper(Activity paramActivity, TapatalkForum paramTapatalkForum) {
        this.activity = paramActivity;
        this.tapatalkForum = paramTapatalkForum;
        this.forumStatus = new ForumStatus(this.activity);
        this.forumStatus.tapatalkForum = this.tapatalkForum;
        this.prefs = Prefs.get(paramActivity);
    }

    public static void cacheForumStatus(Activity paramActivity, ForumStatus paramForumStatus) {
        try {
            localObject = AppCacheManager.getCookieCacheUrl(paramActivity, paramForumStatus.getUrl(), paramForumStatus.tapatalkForum.getCacheUsernameDir());
            ForumCookiesCache localForumCookiesCache = new ForumCookiesCache();
            localForumCookiesCache.writeTime = System.currentTimeMillis();
            localForumCookiesCache.saveForTime = 1800000L;
            localForumCookiesCache.cookies = paramForumStatus.cookies;
            AppCacheManager.cacheForumCookiesData((String) localObject, localForumCookiesCache);
            if ((paramForumStatus == null) || (!paramForumStatus.isLogin())) {
            }
        } catch (Exception localException1) {
            try {
                Object localObject = new ForumStatusCache();
                ((ForumStatusCache) localObject).writeTime = System.currentTimeMillis();
                ((ForumStatusCache) localObject).saveForTime = 86400000L;
                ((ForumStatusCache) localObject).forumStatus = paramForumStatus;
                AppCacheManager.cacheForumStatusData(AppCacheManager.getForumStatusCacheUrl(paramActivity, paramForumStatus.getUrl(), paramForumStatus.tapatalkForum.getCacheUsernameDir()), localObject);
                localObject = Prefs.get(paramActivity).edit();
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
                new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).saveFavoriate(paramForumStatus.tapatalkForum);
                ((SharedPreferences.Editor) localObject).commit();
                return;
                localException1 = localException1;
                localException1.printStackTrace();
            } catch (Exception localException2) {
                for (; ; ) {
                    localException2.printStackTrace();
                }
            }
        }
    }

    private void getRemoteForumStatus() {
        new ForumConfigAction(this.activity, this.forumStatus).getConfig(new ForumConfigAction.ActionCallBack() {
            public void actionErrorBack(String paramAnonymousString) {
                ForumConfigHelper.this.actionCallBack.actionErrorBack(paramAnonymousString);
            }

            public void actionSuccessBack(ForumStatus paramAnonymousForumStatus) {
                ForumConfigHelper.this.forumStatus = paramAnonymousForumStatus;
                if (ForumConfigHelper.this.needTryLogin) {
                    ForumConfigHelper.this.loginOrSignAction = new ForumLoginOrSignAction(ForumConfigHelper.this.activity, ForumConfigHelper.this.forumStatus);
                    if (((ForumConfigHelper.this.forumStatus.isSsoSign()) || (ForumConfigHelper.this.forumStatus.isSsoLogin())) && (ForumConfigHelper.this.forumStatus.tapatalkForum.getUserName() != null) && (ForumConfigHelper.this.forumStatus.tapatalkForum.getUserName().length() > 0) && (!ForumConfigHelper.this.forumStatus.tapatalkForum.hasPassword())) {
                        ForumConfigHelper.this.loginOrSignAction.signForum(ForumConfigHelper.this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), null, true, true, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                            public void actionErrorBack(String paramAnonymous2String1, String paramAnonymous2String2) {
                                ForumConfigHelper.this.actionCallBack.actionBack(ForumConfigHelper.this.forumStatus);
                            }

                            public void actionSuccessBack(ForumStatus paramAnonymous2ForumStatus) {
                                ForumConfigHelper.this.actionCallBack.actionBack(paramAnonymous2ForumStatus);
                                ForumConfigHelper.cacheForumStatus(ForumConfigHelper.this.activity, paramAnonymous2ForumStatus);
                            }
                        });
                        return;
                    }
                    if ((ForumConfigHelper.this.forumStatus.tapatalkForum.getUserName() != null) && (ForumConfigHelper.this.forumStatus.tapatalkForum.getUserName().length() > 0) && (ForumConfigHelper.this.forumStatus.tapatalkForum.hasPassword())) {
                        ForumConfigHelper.this.loginOrSignAction.loginForum(ForumConfigHelper.this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), ForumConfigHelper.this.forumStatus.tapatalkForum.getPassword(), true, false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                            public void actionErrorBack(String paramAnonymous2String1, String paramAnonymous2String2) {
                                ForumConfigHelper.this.actionCallBack.actionBack(ForumConfigHelper.this.forumStatus);
                            }

                            public void actionSuccessBack(ForumStatus paramAnonymous2ForumStatus) {
                                ForumConfigHelper.this.actionCallBack.actionBack(paramAnonymous2ForumStatus);
                                ForumConfigHelper.cacheForumStatus(ForumConfigHelper.this.activity, paramAnonymous2ForumStatus);
                            }
                        });
                        return;
                    }
                    ForumConfigHelper.this.actionCallBack.actionBack(ForumConfigHelper.this.forumStatus);
                    return;
                }
                ForumConfigHelper.this.actionCallBack.actionBack(ForumConfigHelper.this.forumStatus);
                ForumConfigHelper.cacheForumStatus(ForumConfigHelper.this.activity, ForumConfigHelper.this.forumStatus);
            }
        });
    }

    public void getForumStatusAndTryLogin(boolean paramBoolean1, boolean paramBoolean2, ActionCallBack paramActionCallBack) {
        this.actionCallBack = paramActionCallBack;
        this.needTryLogin = paramBoolean2;
        paramActionCallBack = AppCacheManager.getForumStatusCacheUrl(this.activity, this.tapatalkForum.getUrl(), this.tapatalkForum.getCacheUsernameDir());
        if (AppCacheManager.checkFile(paramActionCallBack)) {
            if (paramBoolean1) {
                paramActionCallBack = AppCacheManager.getForumStatusDataIgnoreCacheTime(paramActionCallBack);
            }
        }
        for (; ; ) {
            if ((paramActionCallBack != null) && (paramActionCallBack.forumStatus != null) && (Util.isLoginedUser(this.activity, this.tapatalkForum))) {
                this.forumStatus = paramActionCallBack.forumStatus;
                ForumCookiesCache localForumCookiesCache = AppCacheManager.getForumCookiesData(AppCacheManager.getCookieCacheUrl(this.activity, this.tapatalkForum.getUrl(), this.tapatalkForum.getCacheUsernameDir()));
                if ((localForumCookiesCache != null) && (localForumCookiesCache.cookies != null)) {
                    this.forumStatus.cookies = localForumCookiesCache.cookies;
                    this.forumStatus.loginExpire = false;
                }
                if ((!this.forumStatus.isSsoLogin()) && (!this.forumStatus.isSsoSign())) {
                    if (this.forumStatus.isSupportAppSignin()) {
                        this.forumStatus.setSsoLogin(true);
                        this.forumStatus.setSsoSign(true);
                    }
                } else {
                    label186:
                    if ((!this.forumStatus.isSsoRegist()) && (!this.forumStatus.isNativeRegist())) {
                        if (!this.forumStatus.isSupportAppSignin()) {
                            break label802;
                        }
                        this.forumStatus.setSsoRegist(false);
                        this.forumStatus.setNativeRegist(true);
                    }
                    label232:
                    if (System.currentTimeMillis() - paramActionCallBack.writeTime > 1800000L) {
                        ConfigAdapter.logForumUsage(this.activity, this.forumStatus);
                    }
                    if (!this.forumStatus.loginExpire) {
                    }
                }
            }
            try {
                this.forumStatus.tapatalkForum.setApiLevel(this.prefs.getInt(this.forumStatus.getForumId() + "|api_level", 3));
                this.forumStatus.setZip(this.prefs.getBoolean(this.forumStatus.getForumId() + "|response_zip", true));
                this.forumStatus.setAgent(this.prefs.getBoolean(this.forumStatus.getForumId() + "|agent", false));
                this.forumStatus.setRequestZip(this.prefs.getBoolean(this.forumStatus.getForumId() + "|request_zip", false));
                this.forumStatus.setContentType(this.prefs.getBoolean(this.forumStatus.getForumId() + "|content_type", true));
                this.forumStatus.setDfp(this.prefs.getInt(this.forumStatus.getForumId() + "|dfp", 0));
                this.prefs.getInt(this.forumStatus.getForumId() + "|sigType", 1);
                if (this.prefs.contains(this.forumStatus.getForumId() + "|sigType")) {
                    this.forumStatus.tapatalkForum.setSignatureType(this.prefs.getInt(this.forumStatus.getForumId() + "|sigType", 1));
                }
                this.forumStatus.setTheme(SettingsFragment.isLightTheme(this.activity));
                if (Prefs.get(this.activity).contains(this.forumStatus.getForumId() + "goto_unread")) {
                    this.forumStatus.setSupportGoUnread(true);
                }
                if (Prefs.get(this.activity).contains(this.forumStatus.getForumId() + "goto_post")) {
                    this.forumStatus.setSupportGoPost(true);
                }
                this.actionCallBack.actionBack(this.forumStatus);
                return;
                paramActionCallBack = AppCacheManager.getForumStatusData(paramActionCallBack);
                continue;
                this.forumStatus.setSsoLogin(false);
                this.forumStatus.setSsoSign(false);
                break label186;
                label802:
                this.forumStatus.setSsoRegist(false);
                this.forumStatus.setNativeRegist(false);
                break label232;
                getRemoteForumStatus();
                return;
                getRemoteForumStatus();
                return;
            } catch (Exception paramActionCallBack) {
                for (; ; ) {
                }
            }
        }
    }

    public static abstract interface ActionCallBack {
        public abstract void actionBack(ForumStatus paramForumStatus);

        public abstract void actionErrorBack(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/ForumConfigHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */