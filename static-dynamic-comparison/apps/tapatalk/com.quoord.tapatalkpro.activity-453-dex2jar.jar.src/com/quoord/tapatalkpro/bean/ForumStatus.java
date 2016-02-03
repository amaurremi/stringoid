package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.BanUserActivity;
import com.quoord.tapatalkpro.adapter.forum.ConfigAdapter;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerationInterface;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.cache.ForumCookiesCache;
import com.quoord.tapatalkpro.cache.ForumStatusCache;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.sqlhelper.SubscribeForumSqlHelper;
import com.quoord.tapatalkpro.util.PasswordCrypt;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ForumHttpStatus;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ForumStatus
        implements Serializable, ForumHttpStatus {
    public static final String AUTHORIZE_USER = "authorize_user";
    public static final String LOGIN = "login";
    public static final String SIGNIN = "sign_in";
    public static ForumStatus currentForumStatus = null;
    public static boolean isLight = true;
    public static boolean isSearch = false;
    public static String searchQuery = null;
    private static final long serialVersionUID = 1L;
    public ModerationInterface ModeInterface;
    private int adDisplay;
    private String adsDisabledGroup;
    private boolean advanceDelete = false;
    private boolean advancedOnlineUsers = false;
    private boolean advancedSearch = false;
    private String allowed_extensions;
    private boolean announcement = true;
    private String appVersion = "";
    private String avatarUrl = "";
    public BanUserActivity banUser;
    private boolean ban_delete_type = false;
    private String banedTips;
    private boolean canEditPrefix = false;
    private boolean canModerate = false;
    private boolean canPm = true;
    private boolean canSearch = true;
    private boolean canSendPm = true;
    private boolean canUnread = true;
    private boolean canWhoOnline = true;
    private boolean can_upload_attachment_conv;
    private boolean can_upload_attachment_post;
    public HashMap<String, String> cookies = new HashMap();
    private boolean defaultSmilies = true;
    private boolean deleteReason;
    private int dfp = 0;
    private boolean disableLatest = false;
    private boolean disableSearch = false;
    public String displayUserName = "";
    private HashMap<String, Integer> each_extension_size = new HashMap();
    public NewForumColor forumColor = new NewForumColor();
    private String forumName;
    private ArrayList<Forum> forums = null;
    private String guestGroupId;
    private boolean guestOkay = true;
    private boolean guestSearch = false;
    private boolean hasCamera = true;
    private boolean hasMarket = true;
    private boolean haveMaxAttachmentKey = false;
    private boolean isAgent = false;
    private boolean isAlert = false;
    private boolean isBanExpires = false;
    private boolean isContentType = true;
    private boolean isLogin = false;
    private boolean isMarkTopicRead = false;
    private boolean isMultiQuote = false;
    public boolean isOpen = true;
    private boolean isPurcased = true;
    private boolean isRegister = false;
    private boolean isRequestZip = false;
    private boolean isSearchIDEnabled = false;
    private boolean isSubscribeForum = true;
    private boolean isSupportAdvanceMerge = false;
    private boolean isSupportAdvanceMove = false;
    private boolean isSupportAnonymous = false;
    private boolean isSupportAppSignin = false;
    private boolean isSupportBlogs = false;
    private boolean isSupportEmoji = false;
    private boolean isSupportGetContact = false;
    private boolean isSupportGetLatest = false;
    private boolean isSupportGoPost = false;
    private boolean isSupportUnread = false;
    private boolean isSupportUserId = false;
    private boolean isUnban = false;
    private boolean isVersionSupportMod = false;
    public boolean is_proboards = false;
    private ArrayList<String> localSubscribeForum;
    public boolean loginExpire = true;
    public String mActionId = null;
    private String mUserNameReturn = null;
    private boolean markCsUnread = false;
    private boolean markPmUnread = false;
    private boolean markSubForum = false;
    private int maxAttachments = 0;
    private int maxJpgSize;
    private int maxPngSize;
    private int max_attachment;
    private int max_attachment_size = 0;
    private int minSearchLength = 3;
    private boolean modApprove;
    private boolean modDelete;
    private boolean modReport;
    private boolean nativeRegist = false;
    private ArrayList<String> newPostForForum = new ArrayList();
    private boolean noFreshReply = false;
    private boolean noRerefreshPost = false;
    private boolean pmLoad = false;
    private int post_countdown = 0;
    private boolean push = false;
    private HashMap<String, Boolean> readTopicMark = new HashMap();
    public RebrandingConfig rebrandingConfig;
    private String regUrl = null;
    private String register_email = null;
    private boolean reportPm = false;
    private boolean reportPost = false;
    private String signatureString = "";
    private String skimId;
    private boolean ssoLogin = false;
    private boolean ssoRegist = false;
    private boolean ssoSign = false;
    private boolean startByShortCut;
    private boolean subscribeLoad = false;
    private boolean supportUploadAvatar = false;
    private boolean support_avatar = false;
    private boolean supprotBBcode = false;
    public TapatalkForum tapatalkForum;
    public ForumRootAdapter tempAdapter;
    private int unreadInbox = 0;
    private int unreadSubScribe = 0;
    private boolean useZip = true;
    private ArrayList<String> userGroupId = new ArrayList();
    private String userType;
    private String vigLinkId;

    public ForumStatus(Context paramContext) {
        new ArrayList();
        Object localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
        ((Intent) localObject2).putExtra("android.intent.extra.videoQuality", 1);
        Object localObject1 = paramContext.getPackageManager();
        localObject2 = ((PackageManager) localObject1).queryIntentActivities((Intent) localObject2, 0);
        this.is_proboards = paramContext.getResources().getBoolean(2131558402);
        if ((localObject2 == null) || (((List) localObject2).size() == 0)) {
            setHasCamera(false);
        }
        localObject2 = new Intent("android.intent.action.VIEW");
        ((Intent) localObject2).setData(Uri.parse(TapatalkApp.rate_url));
        new ArrayList();
        localObject1 = ((PackageManager) localObject1).queryIntentActivities((Intent) localObject2, 0);
        if ((localObject1 == null) || (((List) localObject1).size() == 0)) {
            setHasMarket(false);
        }
        paramContext = AppCacheManager.getRebrandingUrl(paramContext);
        if (AppCacheManager.checkFile(paramContext)) {
            paramContext = AppCacheManager.getCacheData(paramContext);
            if ((paramContext != null) && ((paramContext instanceof RebrandingConfig))) {
                this.rebrandingConfig = ((RebrandingConfig) paramContext);
            }
        }
    }

    private boolean getForumPathById(ArrayList<Forum> paramArrayList1, String paramString, ArrayList<Forum> paramArrayList2) {
        if ((paramArrayList1 != null) && (paramArrayList1.size() != 0)) {
            int i = 0;
            for (; ; ) {
                if (i >= paramArrayList1.size()) {
                    return false;
                }
                if ((paramArrayList1.get(i) instanceof Forum)) {
                    Forum localForum = (Forum) paramArrayList1.get(i);
                    if ((localForum != null) && (localForum.getId() != null) && (localForum.getId().equalsIgnoreCase(paramString))) {
                        paramArrayList2.add(localForum);
                        return true;
                    }
                    if ((localForum.getChildForums() != null) && (localForum.getChildForums().size() != 0) && (getForumPathById(localForum.getChildForums(), paramString, paramArrayList2))) {
                        paramArrayList2.add(localForum);
                        return true;
                    }
                }
                i += 1;
            }
        }
        return false;
    }

    public static ForumStatus initialForumStatus(Activity paramActivity, String paramString1, String paramString2, String paramString3) {
        return initialForumStatus(paramActivity, new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(paramString1), paramString2, paramString3, false);
    }

    public static ForumStatus initialForumStatus(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
        return initialForumStatus(paramActivity, new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(paramString1), paramString2, paramString3, paramBoolean);
    }

    public static ForumStatus initialForumStatus(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, String paramString2) {
        return initialForumStatus(paramContext, paramTapatalkForum, paramString1, paramString2, false);
    }

    public static ForumStatus initialForumStatus(Context paramContext, TapatalkForum paramTapatalkForum, String paramString1, String paramString2, boolean paramBoolean) {
        ForumStatus localForumStatus = new ForumStatus(paramContext);
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        int i = 0;
        if (paramTapatalkForum != null) {
            localForumStatus.tapatalkForum = paramTapatalkForum;
            i = paramTapatalkForum.getId().intValue();
        }
        Object localObject;
        if (localForumStatus.tapatalkForum == null) {
            if (!paramContext.getResources().getBoolean(2131558401)) {
                break label1091;
            }
            localForumStatus.tapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById("0");
            if (localForumStatus.tapatalkForum == null) {
                localForumStatus.tapatalkForum = new TapatalkForum();
                localForumStatus.tapatalkForum.setId(Integer.valueOf(0));
                localForumStatus.tapatalkForum.setUserName(localSharedPreferences.getString(localForumStatus.getForumId() + "|username", null));
                String str = localSharedPreferences.getString(localForumStatus.getForumId() + "|password", null);
                localObject = "";
                paramString1 = (String) localObject;
                if (str != null) {
                    paramString1 = (String) localObject;
                    if (str.length() > 0) {
                        paramString1 = new PasswordCrypt();
                        paramString1.setPassword("3x5sxzdbb1s");
                        paramString1 = paramString1.decrypt(str);
                    }
                }
                localForumStatus.tapatalkForum.setPassword(paramString1);
            }
            localForumStatus.tapatalkForum.setUrl(TapatalkApp.rebranding_url);
            localForumStatus.tapatalkForum.setName(TapatalkApp.rebranding_name);
        }
        for (; ; ) {
            if (localForumStatus.tapatalkForum == null) {
                localForumStatus.tapatalkForum = new TapatalkForum();
                localForumStatus.tapatalkForum.setId(Integer.valueOf(i));
                localForumStatus.tapatalkForum.setUrl(paramString2);
            }
            paramString1 = localForumStatus;
            if (paramTapatalkForum != null) {
                localObject = AppCacheManager.getForumStatusCacheUrl(paramContext, paramTapatalkForum.getUrl(), paramTapatalkForum.getCacheUsernameDir());
                paramString1 = localForumStatus;
                if (AppCacheManager.checkFile((String) localObject)) {
                    if (!paramBoolean) {
                        break label1135;
                    }
                    localObject = AppCacheManager.getForumStatusDataIgnoreCacheTime((String) localObject);
                    label356:
                    paramString1 = localForumStatus;
                    if (localObject != null) {
                        paramString1 = localForumStatus;
                        if (((ForumStatusCache) localObject).forumStatus != null) {
                            paramString1 = localForumStatus;
                            if (Util.isLoginedUser(paramContext, paramTapatalkForum)) {
                                localForumStatus = ((ForumStatusCache) localObject).forumStatus;
                                paramString1 = AppCacheManager.getForumCookiesData(AppCacheManager.getCookieCacheUrl(paramContext, paramTapatalkForum.getUrl(), paramTapatalkForum.getCacheUsernameDir()));
                                if ((paramString1 != null) && (paramString1.cookies != null)) {
                                    localForumStatus.cookies = paramString1.cookies;
                                    localForumStatus.loginExpire = false;
                                }
                                if ((!localForumStatus.isSsoLogin()) && (!localForumStatus.isSsoSign())) {
                                    if (!localForumStatus.isSupportAppSignin()) {
                                        break label1145;
                                    }
                                    localForumStatus.setSsoLogin(true);
                                    localForumStatus.setSsoSign(true);
                                }
                                label471:
                                if ((!localForumStatus.isSsoRegist()) && (!localForumStatus.isNativeRegist())) {
                                    if (!localForumStatus.isSupportAppSignin()) {
                                        break label1160;
                                    }
                                    localForumStatus.setSsoRegist(false);
                                    localForumStatus.setNativeRegist(true);
                                }
                                label507:
                                paramString1 = localForumStatus;
                                if (System.currentTimeMillis() - ((ForumStatusCache) localObject).writeTime > 1800000L) {
                                    ConfigAdapter.logForumUsage(paramContext, localForumStatus);
                                    paramString1 = localForumStatus;
                                }
                            }
                        }
                    }
                }
            }
            if (paramString1.loginExpire) {
            }
            try {
                paramString1.tapatalkForum.setApiLevel(localSharedPreferences.getInt(paramString1.getForumId() + "|api_level", 3));
                paramString1.setZip(localSharedPreferences.getBoolean(paramString1.getForumId() + "|response_zip", true));
                paramString1.setAgent(localSharedPreferences.getBoolean(paramString1.getForumId() + "|agent", false));
                paramString1.setRequestZip(localSharedPreferences.getBoolean(paramString1.getForumId() + "|request_zip", false));
                paramString1.setContentType(localSharedPreferences.getBoolean(paramString1.getForumId() + "|content_type", true));
                paramString1.setDfp(localSharedPreferences.getInt(paramString1.getForumId() + "|dfp", 0));
                localSharedPreferences.getInt(paramString1.getForumId() + "|sigType", 1);
                if (localSharedPreferences.contains(paramString1.getForumId() + "|sigType")) {
                    paramString1.tapatalkForum.setSignatureType(localSharedPreferences.getInt(paramString1.getForumId() + "|sigType", 1));
                }
                for (; ; ) {
                    try {
                        paramTapatalkForum = AppCacheManager.getForumCookiesData(AppCacheManager.getCookieCacheUrl(paramContext, paramTapatalkForum.getUrl(), paramTapatalkForum.getCacheUsernameDir()));
                        if ((paramTapatalkForum != null) && (paramTapatalkForum.cookies != null)) {
                            paramString1.cookies.putAll(paramTapatalkForum.cookies);
                        }
                    } catch (Exception paramTapatalkForum) {
                        label1091:
                        label1135:
                        label1145:
                        label1160:
                        paramTapatalkForum.printStackTrace();
                        continue;
                    }
                    paramString1.setTheme(SettingsFragment.isLightTheme(paramContext));
                    if ((paramString2 != null) && (paramString2.trim().length() > 0)) {
                        paramString1.setStartByShortCut(true);
                    }
                    paramString1.setLocalSubscribeForum(paramContext);
                    if (paramContext.getResources().getBoolean(2131558401)) {
                        paramTapatalkForum = AppCacheManager.getColorUrl(paramContext);
                    }
                    try {
                        if (AppCacheManager.checkFile(paramTapatalkForum)) {
                            paramTapatalkForum = (NewForumColor) AppCacheManager.getCacheData(paramTapatalkForum);
                            if (paramTapatalkForum != null) {
                                paramString1.forumColor = ((NewForumColor) paramTapatalkForum);
                            }
                        }
                    } catch (Exception paramTapatalkForum) {
                        paramTapatalkForum.printStackTrace();
                        continue;
                    }
                    try {
                        paramTapatalkForum = AppCacheManager.getRebrandingUrl(paramContext);
                        if (AppCacheManager.checkFile(paramTapatalkForum)) {
                            paramTapatalkForum = AppCacheManager.getCacheData(paramTapatalkForum);
                            if ((paramTapatalkForum != null) && ((paramTapatalkForum instanceof RebrandingConfig))) {
                                paramString1.setRebrandingConfig((RebrandingConfig) paramTapatalkForum);
                            }
                        }
                    } catch (Exception paramTapatalkForum) {
                        paramTapatalkForum.printStackTrace();
                        continue;
                    }
                    if (Prefs.get(paramContext).contains(paramString1.getForumId() + "goto_unread")) {
                        paramString1.setSupportGoUnread(true);
                    }
                    if (Prefs.get(paramContext).contains(paramString1.getForumId() + "goto_post")) {
                        paramString1.setSupportGoPost(true);
                    }
                    return paramString1;
                    localForumStatus.tapatalkForum = new FavoriateSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(i);
                    break;
                    localObject = AppCacheManager.getForumStatusData((String) localObject);
                    break label356;
                    localForumStatus.setSsoLogin(false);
                    localForumStatus.setSsoSign(false);
                    break label471;
                    localForumStatus.setSsoRegist(false);
                    localForumStatus.setNativeRegist(false);
                    break label507;
                    paramString1.loginExpire = false;
                }
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
        }
    }

    public static boolean isTapatalkSignIn(Context paramContext, String paramString) {
        return TapatalkIdFactory.getTapatalkId(paramContext).isTapatalkIdLogin();
    }

    public static boolean staticCheckLocalSubscribeForum(Context paramContext, String paramString1, String paramString2) {
        paramContext = new SubscribeForumSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getIds(paramString2);
        return (paramContext != null) && (paramContext.contains(paramString1));
    }

    public void addNewPostForForum(String paramString) {
        this.newPostForForum.add(paramString);
    }

    public void addReadTopicMark(String paramString) {
        if (this.readTopicMark != null) {
            this.readTopicMark.put(paramString, Boolean.valueOf(true));
        }
    }

    public boolean checkLocalSubscribeForum(String paramString) {
        return (this.localSubscribeForum != null) && (this.localSubscribeForum.contains(paramString));
    }

    public boolean checkNewPost(String paramString) {
        return this.newPostForForum.contains(paramString);
    }

    public void cleanNewPost() {
        this.newPostForForum.clear();
    }

    public void cleanNewPost(String paramString) {
        if (this.newPostForForum != null) {
        }
        try {
            this.newPostForForum.remove(this.newPostForForum.indexOf(paramString));
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    public void clearForumCache(Context paramContext) {
        paramContext = new File(AppCacheManager.getLongtermCacheDir(paramContext) + getCachePath());
        int i;
        if (paramContext.exists()) {
            paramContext = paramContext.listFiles();
            i = 0;
            if (i < paramContext.length) {
            }
        } else {
            return;
        }
        if (this.tapatalkForum.getUserName() != null) {
            if ((paramContext[i].getName().contains("getForum")) && (!paramContext[i].getName().equals("getForum" + this.tapatalkForum.getUserName().hashCode() + ".cache"))) {
                paramContext[i].delete();
            }
        }
        for (; ; ) {
            i += 1;
            break;
            paramContext[i].delete();
        }
    }

    public void clearUserGroupId() {
        this.userGroupId.clear();
    }

    public int getAdDisplay() {
        return this.adDisplay;
    }

    public String getAdsDisabledGroup() {
        return this.adsDisabledGroup;
    }

    public String getAllowed_extensions() {
        return this.allowed_extensions;
    }

    public int getApiLevel() {
        return this.tapatalkForum.getApiLevel();
    }

    public String getAppVersion(Context paramContext) {
        if ((this.appVersion == null) || (this.appVersion.equals(""))) {
            try {
                this.appVersion = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
                return this.appVersion;
            } catch (PackageManager.NameNotFoundException paramContext) {
                for (; ; ) {
                    paramContext.printStackTrace();
                }
            }
        }
        return this.appVersion;
    }

    public String getAuthroizeUserFunction() {
        if (this.tapatalkForum.getApiLevel() >= 3) {
            return "login";
        }
        return "authorize_user";
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getBanedTips() {
        return this.banedTips;
    }

    public String getCachePath() {
        if (getUrl() != null) {
            String str2 = getUrl().replace("http://", "").replace("https://", "").replaceAll("/", "");
            String str1 = str2;
            if (this.tapatalkForum.getLowerUserName() != null) {
                str1 = str2;
                if (!this.tapatalkForum.getLowerUserName().equals("")) {
                    str1 = str2 + "-" + this.tapatalkForum.getLowerUserName();
                }
            }
            return str1;
        }
        return null;
    }

    public boolean getCanEditPrefix() {
        return this.canEditPrefix;
    }

    public String getCookie() {
        StringBuilder localStringBuilder = new StringBuilder();
        if ((this.cookies != null) && (this.cookies.size() > 0)) {
            Iterator localIterator = this.cookies.entrySet().iterator();
            for (; ; ) {
                if (!localIterator.hasNext()) {
                    return localStringBuilder.toString();
                }
                Object localObject = (Map.Entry) localIterator.next();
                String str = (String) ((Map.Entry) localObject).getKey();
                localObject = (String) ((Map.Entry) localObject).getValue();
                if ((localStringBuilder != null) && (localStringBuilder.length() != 0)) {
                    localStringBuilder.append("; ");
                }
                localStringBuilder.append(str);
                localStringBuilder.append("=");
                localStringBuilder.append((String) localObject);
            }
        }
        return "tapatalk=1";
    }

    public HashMap<String, String> getCookies() {
        return this.cookies;
    }

    public String getCurrentUserName() {
        if (this.mUserNameReturn != null) {
            return this.mUserNameReturn;
        }
        return this.tapatalkForum.getUserName();
    }

    public HashMap<String, Integer> getEach_extension_size() {
        return this.each_extension_size;
    }

    public Forum getForumById(Context paramContext, String paramString) {
        Object localObject = null;
        ArrayList localArrayList = getForumHierarch(paramContext, paramString);
        int i = 0;
        for (paramContext = (Context) localObject; ; paramContext = (Context) localObject) {
            if (i >= localArrayList.size()) {
                return paramContext;
            }
            localObject = paramContext;
            if ((localArrayList.get(i) instanceof Forum)) {
                localObject = paramContext;
                if (((Forum) localArrayList.get(i)).getId() != null) {
                    localObject = paramContext;
                    if (((Forum) localArrayList.get(i)).getId().equalsIgnoreCase(paramString)) {
                        localObject = (Forum) localArrayList.get(i);
                    }
                }
            }
            i += 1;
        }
    }

    public ArrayList<Forum> getForumHierarch(Context paramContext, String paramString) {
        if (this.forums == null) {
            this.forums = ((ArrayList) AppCacheManager.getCacheData(AppCacheManager.getForumCacheUrl(paramContext, getUrl(), this.tapatalkForum.getCacheUsernameDir())));
        }
        paramContext = new ArrayList();
        getForumPathById(this.forums, paramString, paramContext);
        return paramContext;
    }

    public String getForumId() {
        return this.tapatalkForum.getId().toString();
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getFullUploadUrl() {
        if (this.tapatalkForum.getUrl().endsWith("/")) {
            return this.tapatalkForum.getUrl() + this.tapatalkForum.getFolder() + "/upload." + this.tapatalkForum.getExt();
        }
        return this.tapatalkForum.getUrl() + "/" + this.tapatalkForum.getFolder() + "/upload." + this.tapatalkForum.getExt();
    }

    public String getFullUrl() {
        if (this.tapatalkForum.getUrl().endsWith("/")) {
            return this.tapatalkForum.getUrl() + this.tapatalkForum.getFolder() + "/mobiquo." + this.tapatalkForum.getExt();
        }
        return this.tapatalkForum.getUrl() + "/" + this.tapatalkForum.getFolder() + "/mobiquo." + this.tapatalkForum.getExt();
    }

    public String getGuestGroupId() {
        return this.guestGroupId;
    }

    public int getMaxAttachments() {
        if (this.maxAttachments == 0) {
            return 5;
        }
        return this.maxAttachments;
    }

    public int getMaxJpgSize() {
        return this.maxJpgSize;
    }

    public int getMaxPngSize() {
        return this.maxPngSize;
    }

    public int getMax_attachment_size() {
        return this.max_attachment_size;
    }

    public int getMinSearchLength() {
        return this.minSearchLength;
    }

    public String getNewTopicFunction() {
        if (this.tapatalkForum.getApiLevel() >= 3) {
            return "new_topic";
        }
        return "create_topic";
    }

    public int getPost_countdown() {
        return this.post_countdown;
    }

    public String getPrefectUrl() {
        if (this.tapatalkForum.getUrl().endsWith("/")) {
            return this.tapatalkForum.getUrl();
        }
        return this.tapatalkForum.getUrl() + "/";
    }

    public String getRawPassWord() {
        return this.tapatalkForum.getPassword();
    }

    public boolean getReadTopicMark(String paramString) {
        if (this.readTopicMark == null) {
            return false;
        }
        return this.readTopicMark.containsKey(paramString);
    }

    public RebrandingConfig getRebrandingConfig() {
        return this.rebrandingConfig;
    }

    public String getRegUrl() {
        if (this.is_proboards) {
            return "index.cgi?action=register";
        }
        return this.regUrl;
    }

    public String getRegister_email() {
        if (this.register_email == null) {
            return "";
        }
        return this.register_email;
    }

    public String getReplyPostFunction() {
        if (this.tapatalkForum.getApiLevel() >= 3) {
            return "reply_post";
        }
        return "reply_topic";
    }

    public int getSigType() {
        return this.tapatalkForum.getSignatureType();
    }

    public String getSignatureString() {
        return this.signatureString;
    }

    public String getSkimId() {
        return this.skimId;
    }

    public int getUnreadInbox() {
        return this.unreadInbox;
    }

    public int getUnreadSubScribe() {
        return this.unreadSubScribe;
    }

    public String getUrl() {
        if (this.tapatalkForum != null) {
            return this.tapatalkForum.getUrl();
        }
        return "";
    }

    public boolean getUseZip() {
        return this.useZip;
    }

    public String getUser() {
        return this.tapatalkForum.getUserName();
    }

    public ArrayList<String> getUserGroupId() {
        return this.userGroupId;
    }

    public String getUserId() {
        return this.tapatalkForum.getUserId();
    }

    public String getUserType() {
        return this.userType;
    }

    public String getVigLinkId() {
        return this.vigLinkId;
    }

    public boolean isAdShow() {
        if ((TapatalkApp.adDisplay == 1) && ((this.isLogin) || ((this.tapatalkForum.getUserName() != null) && (this.tapatalkForum.getPassword() != null)))) {
            return false;
        }
        if ((TapatalkApp.adDisplay == 0) && ((this.isLogin) || ((this.tapatalkForum.getUserName() != null) && (this.tapatalkForum.getPassword() != null)))) {
            if ((this.rebrandingConfig != null) && (TapatalkApp.adGroupId != null) && (TapatalkApp.adGroupId.size() > 0) && (this.userGroupId.size() > 0)) {
                int i = 0;
                for (; ; ) {
                    if (i >= TapatalkApp.adGroupId.size()) {
                        return true;
                    }
                    if (this.userGroupId.contains(TapatalkApp.adGroupId.get(i))) {
                        break;
                    }
                    i += 1;
                }
            }
            return true;
        }
        return true;
    }

    public boolean isAdvanceDelete() {
        return this.advanceDelete;
    }

    public boolean isAdvancedOnlineUsers() {
        return this.advancedOnlineUsers;
    }

    public boolean isAdvancedSearch() {
        return this.advancedSearch;
    }

    public boolean isAgent() {
        return this.isAgent;
    }

    public boolean isAlert() {
        return this.isAlert;
    }

    public boolean isAnnouncement() {
        return this.announcement;
    }

    public boolean isBB() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("bb")) {
            return false;
        }
        return true;
    }

    public boolean isBB11() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("bb11")) {
            return false;
        }
        return true;
    }

    public boolean isBanExpires() {
        return this.isBanExpires;
    }

    public boolean isBan_delete_type() {
        return this.ban_delete_type;
    }

    public boolean isCanModerate() {
        return this.canModerate;
    }

    public boolean isCanPm() {
        return this.canPm;
    }

    public boolean isCanSearch() {
        return this.canSearch;
    }

    public boolean isCanSendPm() {
        return this.canSendPm;
    }

    public boolean isCanUnread() {
        return this.canUnread;
    }

    public boolean isCanWhoOnline() {
        return this.canWhoOnline;
    }

    public boolean isCan_upload_attachment_conv() {
        return this.can_upload_attachment_conv;
    }

    public boolean isCan_upload_attachment_post() {
        return this.can_upload_attachment_post;
    }

    public boolean isContentType() {
        return this.isContentType;
    }

    public boolean isDefaultSmilies() {
        return this.defaultSmilies;
    }

    public boolean isDeleteReason() {
        return this.deleteReason;
    }

    public boolean isDfp() {
        return (this.dfp == 1) && (!this.isLogin);
    }

    public boolean isDisableLatest() {
        return this.disableLatest;
    }

    public boolean isDisableSearch() {
        return this.disableSearch;
    }

    public boolean isGuestOkay() {
        return this.guestOkay;
    }

    public boolean isGuestSearch() {
        return this.guestSearch;
    }

    public boolean isHasCamera() {
        return this.hasCamera;
    }

    public boolean isHasMarket() {
        return this.hasMarket;
    }

    public boolean isHaveMaxAttachmentKey() {
        return this.haveMaxAttachmentKey;
    }

    public boolean isIP() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("ip")) {
            return false;
        }
        return true;
    }

    public boolean isKN1() {
        return (this.tapatalkForum.getVersion() != null) && (this.tapatalkForum.getVersion().startsWith("kn1"));
    }

    public boolean isKN2() {
        return (this.tapatalkForum.getVersion() != null) && (this.tapatalkForum.getVersion().startsWith("kn2"));
    }

    public boolean isKN3() {
        return (this.tapatalkForum.getVersion() != null) && (this.tapatalkForum.getVersion().startsWith("kn30_"));
    }

    public boolean isLightTheme() {
        return isLight;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public boolean isMB() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("mb")) {
            return false;
        }
        return true;
    }

    public boolean isMarkCsUnread() {
        return this.markCsUnread;
    }

    public boolean isMarkPmUnread() {
        return this.markPmUnread;
    }

    public boolean isMarkSubForum() {
        return this.markSubForum;
    }

    public boolean isMarkTopicRead() {
        return this.isMarkTopicRead;
    }

    public boolean isModApprove() {
        return this.modApprove;
    }

    public boolean isModDelete() {
        return this.modDelete;
    }

    public boolean isModReport() {
        return this.modReport;
    }

    public boolean isMultiQuote() {
        return this.isMultiQuote;
    }

    public boolean isNativeRegist() {
        return this.nativeRegist;
    }

    public boolean isNoFreshReply() {
        return this.noFreshReply;
    }

    public boolean isNoRerefreshPost() {
        return this.noRerefreshPost;
    }

    public boolean isPB() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("pb")) {
            return false;
        }
        return true;
    }

    public boolean isPBS() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("proboards")) {
            return false;
        }
        return true;
    }

    public boolean isPMPlusPara() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("sm-2")) {
            return false;
        }
        return true;
    }

    public boolean isPmLoad() {
        return this.pmLoad;
    }

    public boolean isPurcased() {
        return this.isPurcased;
    }

    public boolean isPush() {
        return this.push;
    }

    public boolean isRegister() {
        return this.isRegister;
    }

    public boolean isReportPm() {
        return this.reportPm;
    }

    public boolean isReportPost() {
        return this.reportPost;
    }

    public boolean isRequestZip() {
        return this.isRequestZip;
    }

    public boolean isSMF() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("sm")) {
            return false;
        }
        return true;
    }

    public boolean isSMF1() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("sm20")) {
            return false;
        }
        return true;
    }

    public boolean isSMF2() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("sm-2")) {
            return false;
        }
        return true;
    }

    public boolean isSearchIDEnabled() {
        return this.isSearchIDEnabled;
    }

    public boolean isSignInForumUser(Context paramContext) {
        return Util.isSignedUser(paramContext, this.tapatalkForum);
    }

    public boolean isSsoLogin() {
        return this.ssoLogin;
    }

    public boolean isSsoRegist() {
        return this.ssoRegist;
    }

    public boolean isSsoSign() {
        return this.ssoSign;
    }

    public boolean isStartByShortCut() {
        return this.startByShortCut;
    }

    public boolean isSubscribeForum() {
        return this.isSubscribeForum;
    }

    public boolean isSubscribeLoad() {
        return this.subscribeLoad;
    }

    public boolean isSupportAdvanceMerge() {
        return this.isSupportAdvanceMerge;
    }

    public boolean isSupportAdvanceMove() {
        return this.isSupportAdvanceMove;
    }

    public boolean isSupportAnonymous() {
        return this.isSupportAnonymous;
    }

    public boolean isSupportAppSignin() {
        return this.isSupportAppSignin;
    }

    public boolean isSupportBlogs() {
        return this.isSupportBlogs;
    }

    public boolean isSupportEmoji() {
        return this.isSupportEmoji;
    }

    public boolean isSupportGetContact() {
        return this.isSupportGetContact;
    }

    public boolean isSupportGetLatest() {
        return this.isSupportGetLatest;
    }

    public boolean isSupportGoPost() {
        return this.isSupportGoPost;
    }

    public boolean isSupportGoUnread() {
        return this.isSupportUnread;
    }

    public boolean isSupportPartcipate() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (this.tapatalkForum.getVersion().startsWith("sm20")) {
            return false;
        }
        return true;
    }

    public boolean isSupportSignature() {
        return this.tapatalkForum.getSignatureType() != 0;
    }

    public boolean isSupportUploadAvatar() {
        return this.supportUploadAvatar;
    }

    public boolean isSupportUserId() {
        return this.isSupportUserId;
    }

    public boolean isSupport_avatar() {
        return this.support_avatar;
    }

    public boolean isSupprotBBcode() {
        return (this.supprotBBcode) || (this.noRerefreshPost);
    }

    public boolean isTapatalkSignIn(Context paramContext) {
        return TapatalkIdFactory.getTapatalkId(paramContext).isTapatalkIdLogin();
    }

    public boolean isTkUploadSupport() {
        return this.tapatalkForum.isMedia_sharing();
    }

    public boolean isUnban() {
        return this.isUnban;
    }

    public boolean isVB() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("vb")) {
            return false;
        }
        return true;
    }

    public boolean isVB3() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("vb3")) {
            return false;
        }
        return true;
    }

    public boolean isVB4() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("vb4")) {
            return false;
        }
        return true;
    }

    public boolean isVB5() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("vb5")) {
            return false;
        }
        return true;
    }

    public boolean isVersionSupportMod() {
        return this.isVersionSupportMod;
    }

    public boolean isWBB() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("wb")) {
            return false;
        }
        return true;
    }

    public boolean isXF() {
        if (this.tapatalkForum.getVersion() == null) {
        }
        while (!this.tapatalkForum.getVersion().startsWith("xf")) {
            return false;
        }
        return true;
    }

    public void removeLocalSubscribeForum(String paramString) {
        if (this.localSubscribeForum == null) {
            this.localSubscribeForum.remove(paramString);
        }
    }

    public void removeTopicMark(String paramString) {
        if (this.readTopicMark != null) {
            this.readTopicMark.remove(paramString);
        }
    }

    public void setAdDisplay(int paramInt) {
        this.adDisplay = paramInt;
    }

    public void setAdsDisabledGroup(String paramString) {
        this.adsDisabledGroup = paramString;
    }

    public void setAdvanceDelete(boolean paramBoolean) {
        this.advanceDelete = paramBoolean;
    }

    public void setAdvancedOnlineUsers(boolean paramBoolean) {
        this.advancedOnlineUsers = paramBoolean;
    }

    public void setAdvancedSearch(boolean paramBoolean) {
        this.advancedSearch = paramBoolean;
    }

    public void setAgent(boolean paramBoolean) {
        this.isAgent = paramBoolean;
    }

    public void setAlert(boolean paramBoolean) {
        this.isAlert = paramBoolean;
    }

    public void setAllowed_extensions(String paramString) {
        this.allowed_extensions = paramString;
    }

    public void setAnnouncement(boolean paramBoolean) {
        this.announcement = paramBoolean;
    }

    public void setAppVersion(String paramString) {
        this.appVersion = paramString;
    }

    public void setAvatarUrl(String paramString) {
        this.avatarUrl = paramString;
    }

    public void setBanExpires(boolean paramBoolean) {
        this.isBanExpires = paramBoolean;
    }

    public void setBan_delete_type(boolean paramBoolean) {
        this.ban_delete_type = paramBoolean;
    }

    public void setBanedTips(String paramString) {
        this.banedTips = paramString;
    }

    public void setCanEditPrefix(boolean paramBoolean) {
        this.canEditPrefix = paramBoolean;
    }

    public void setCanModerate(boolean paramBoolean) {
        this.canModerate = paramBoolean;
    }

    public void setCanPm(boolean paramBoolean) {
        this.canPm = paramBoolean;
    }

    public void setCanSearch(boolean paramBoolean) {
        this.canSearch = paramBoolean;
    }

    public void setCanSendPm(boolean paramBoolean) {
        this.canSendPm = paramBoolean;
    }

    public void setCanUnread(boolean paramBoolean) {
        this.canUnread = paramBoolean;
    }

    public void setCanWhoOnline(boolean paramBoolean) {
        this.canWhoOnline = paramBoolean;
    }

    public void setCan_upload_attachment_conv(boolean paramBoolean) {
        this.can_upload_attachment_conv = paramBoolean;
    }

    public void setCan_upload_attachment_post(boolean paramBoolean) {
        this.can_upload_attachment_post = paramBoolean;
    }

    public void setContentType(boolean paramBoolean) {
        this.isContentType = paramBoolean;
    }

    public void setDefaultSmilies(boolean paramBoolean) {
        this.defaultSmilies = paramBoolean;
    }

    public void setDeleteReason(boolean paramBoolean) {
        this.deleteReason = paramBoolean;
    }

    public void setDfp(int paramInt) {
        this.dfp = paramInt;
    }

    public void setDisableLatest(boolean paramBoolean) {
        this.disableLatest = paramBoolean;
    }

    public void setDisableSearch(boolean paramBoolean) {
        this.disableSearch = paramBoolean;
    }

    public void setEach_extension_size(HashMap<String, Integer> paramHashMap) {
        this.each_extension_size = paramHashMap;
    }

    public void setForumName(String paramString) {
        this.forumName = paramString;
    }

    public void setForums(ArrayList<Forum> paramArrayList) {
        if (this.forums == null) {
            this.forums = new ArrayList();
        }
        this.forums.clear();
        this.forums.addAll(paramArrayList);
    }

    public void setGuestGroupId(String paramString) {
        this.guestGroupId = paramString;
    }

    public void setGuestOkay(boolean paramBoolean) {
        this.guestOkay = paramBoolean;
    }

    public void setGuestSearch(boolean paramBoolean) {
        this.guestSearch = paramBoolean;
    }

    public void setHasCamera(boolean paramBoolean) {
        this.hasCamera = paramBoolean;
    }

    public void setHasMarket(boolean paramBoolean) {
        this.hasMarket = paramBoolean;
    }

    public void setHaveMaxAttachmentKey(boolean paramBoolean) {
        this.haveMaxAttachmentKey = paramBoolean;
    }

    public void setIsSearchIDEnabled(boolean paramBoolean) {
        this.isSearchIDEnabled = paramBoolean;
    }

    public void setIsSupportEmoji(boolean paramBoolean) {
        this.isSupportEmoji = paramBoolean;
    }

    public void setLocalSubscribeForum(Context paramContext) {
        this.localSubscribeForum = new SubscribeForumSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getIds(getUrl());
    }

    public void setLogin(boolean paramBoolean) {
        this.isLogin = paramBoolean;
        if ((this.tapatalkForum != null) && (this.tapatalkForum.getAccount() != null)) {
            this.tapatalkForum.getAccount().setLogin(true);
        }
    }

    public void setMD5(boolean paramBoolean) {
        this.tapatalkForum.setMD5(paramBoolean);
    }

    public void setMarkCsUnread(boolean paramBoolean) {
        this.markCsUnread = paramBoolean;
    }

    public void setMarkPmUnread(boolean paramBoolean) {
        this.markPmUnread = paramBoolean;
    }

    public void setMarkSubForum(boolean paramBoolean) {
        this.markSubForum = paramBoolean;
    }

    public void setMarkTopicRead(boolean paramBoolean) {
        this.isMarkTopicRead = paramBoolean;
    }

    public void setMaxAttachments(int paramInt) {
        this.maxAttachments = paramInt;
    }

    public void setMaxJpgSize(int paramInt) {
        this.maxJpgSize = paramInt;
    }

    public void setMaxPngSize(int paramInt) {
        this.maxPngSize = paramInt;
    }

    public void setMax_attachment_size(int paramInt) {
        this.max_attachment_size = paramInt;
    }

    public void setMinSearchLength(int paramInt) {
        this.minSearchLength = paramInt;
    }

    public void setModApprove(boolean paramBoolean) {
        this.modApprove = paramBoolean;
    }

    public void setModDelete(boolean paramBoolean) {
        this.modDelete = paramBoolean;
    }

    public void setModReport(boolean paramBoolean) {
        this.modReport = paramBoolean;
    }

    public void setMultiQuote(boolean paramBoolean) {
        this.isMultiQuote = paramBoolean;
    }

    public void setNativeRegist(boolean paramBoolean) {
        this.nativeRegist = paramBoolean;
    }

    public void setNoFreshReply(boolean paramBoolean) {
        this.noFreshReply = paramBoolean;
    }

    public void setNoRerefreshPost(boolean paramBoolean) {
        this.noRerefreshPost = paramBoolean;
    }

    public void setPmLoad(boolean paramBoolean) {
        this.pmLoad = paramBoolean;
    }

    public void setPost_countdown(int paramInt) {
        this.post_countdown = paramInt;
    }

    public void setPurcased(boolean paramBoolean) {
        this.isPurcased = paramBoolean;
    }

    public void setPush(boolean paramBoolean) {
        this.push = paramBoolean;
    }

    public void setRebrandingConfig(RebrandingConfig paramRebrandingConfig) {
        this.rebrandingConfig = paramRebrandingConfig;
        if (paramRebrandingConfig != null) {
            this.tapatalkForum.setExt(paramRebrandingConfig.getExt());
            this.tapatalkForum.setSignatureType(TapatalkApp.signatureType);
            this.tapatalkForum.setFolder(paramRebrandingConfig.getFolder());
            setAdDisplay(TapatalkApp.adDisplay);
            setVigLinkId(paramRebrandingConfig.getVigLinkId());
            setSkimId(paramRebrandingConfig.getSkimId());
        }
    }

    public void setRegUrl(String paramString) {
        this.regUrl = paramString;
    }

    public void setRegister(boolean paramBoolean) {
        this.isRegister = paramBoolean;
    }

    public void setRegister_email(String paramString) {
        this.register_email = paramString;
    }

    public void setReportPm(boolean paramBoolean) {
        this.reportPm = paramBoolean;
    }

    public void setReportPost(boolean paramBoolean) {
        this.reportPost = paramBoolean;
    }

    public void setRequestZip(boolean paramBoolean) {
        this.isRequestZip = paramBoolean;
    }

    public void setSignInForumUser(Context paramContext) {
        Object localObject = Prefs.get(paramContext);
        int i = TapatalkIdFactory.getTapatalkId(paramContext).getAuid();
        paramContext = this.tapatalkForum.getId().intValue() + i + this.tapatalkForum.getName() + "usesignin";
        String str = i + this.tapatalkForum.getId() + this.tapatalkForum.getLowerUserName() + "usesignin";
        localObject = ((SharedPreferences) localObject).edit();
        ((SharedPreferences.Editor) localObject).putString(paramContext, "usesignin");
        ((SharedPreferences.Editor) localObject).putString(str, "usesignin");
        ((SharedPreferences.Editor) localObject).commit();
    }

    public void setSignatureString(String paramString) {
        this.signatureString = paramString;
    }

    public void setSkimId(String paramString) {
        this.skimId = paramString;
    }

    public void setSsoLogin(boolean paramBoolean) {
        this.ssoLogin = paramBoolean;
    }

    public void setSsoRegist(boolean paramBoolean) {
        this.ssoRegist = paramBoolean;
    }

    public void setSsoSign(boolean paramBoolean) {
        this.ssoSign = paramBoolean;
    }

    public void setStartByShortCut(boolean paramBoolean) {
        this.startByShortCut = paramBoolean;
    }

    public void setSubscribeForum(boolean paramBoolean) {
        this.isSubscribeForum = paramBoolean;
    }

    public void setSubscribeLoad(boolean paramBoolean) {
        this.subscribeLoad = paramBoolean;
    }

    public void setSupportAdvanceMerge(boolean paramBoolean) {
        this.isSupportAdvanceMerge = paramBoolean;
    }

    public void setSupportAdvanceMove(boolean paramBoolean) {
        this.isSupportAdvanceMove = paramBoolean;
    }

    public void setSupportAnonymous(boolean paramBoolean) {
        this.isSupportAnonymous = paramBoolean;
    }

    public void setSupportAppSignin(boolean paramBoolean) {
        this.isSupportAppSignin = paramBoolean;
    }

    public void setSupportBlogs(boolean paramBoolean) {
        this.isSupportBlogs = paramBoolean;
    }

    public void setSupportGetContact(boolean paramBoolean) {
        this.isSupportGetContact = paramBoolean;
    }

    public void setSupportGetLatest(boolean paramBoolean) {
        this.isSupportGetLatest = paramBoolean;
    }

    public void setSupportGoPost(boolean paramBoolean) {
        this.isSupportGoPost = paramBoolean;
    }

    public void setSupportGoUnread(boolean paramBoolean) {
        this.isSupportUnread = paramBoolean;
    }

    public void setSupportUploadAvatar(boolean paramBoolean) {
        this.supportUploadAvatar = paramBoolean;
    }

    public void setSupportUserId(boolean paramBoolean) {
        this.isSupportUserId = paramBoolean;
    }

    public void setSupport_avatar(boolean paramBoolean) {
        this.support_avatar = paramBoolean;
    }

    public void setSupprotBBcode(boolean paramBoolean) {
        this.supprotBBcode = paramBoolean;
    }

    public void setTheme(boolean paramBoolean) {
        isLight = paramBoolean;
    }

    public void setUnban(boolean paramBoolean) {
        this.isUnban = paramBoolean;
    }

    public void setUnreadInbox(int paramInt) {
        this.unreadInbox = paramInt;
    }

    public void setUnreadSubScribe(int paramInt) {
        this.unreadSubScribe = paramInt;
    }

    public void setUserGroupId(String paramString) {
        this.userGroupId.add(paramString);
    }

    public void setUserType(String paramString) {
        this.userType = paramString;
    }

    public void setVersionSupportMod(boolean paramBoolean) {
        this.isVersionSupportMod = paramBoolean;
    }

    public void setVigLinkId(String paramString) {
        this.vigLinkId = paramString;
    }

    public void setZip(boolean paramBoolean) {
        this.useZip = paramBoolean;
    }

    public void setmUserNameReturn(String paramString) {
        this.mUserNameReturn = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ForumStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */