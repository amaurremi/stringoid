package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.LoginHandle;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.HashMap;

public class ConfigAdapter
        extends ForumRootAdapter {
    public static final String canUseTapatalkidLoginValue = "1";
    public static final String supprtTapatalidLoginValue = "1";
    public static final String useEmailTrue = "1";
    private Boolean guest_okay;
    private Boolean is_open;
    private Activity mContext;
    public LoginHandle mLoginFragment;
    private String registerUrl;
    private boolean support = false;

    public ConfigAdapter(Activity paramActivity, String paramString) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        setOpCancel(false);
    }

    public static void logForumUsage(Context paramContext, ForumStatus paramForumStatus) {
        for (; ; ) {
            try {
                if (!paramContext.getApplicationContext().getResources().getBoolean(2131558401)) {
                    Object localObject1 = new StringBuilder(String.valueOf(TapatalkJsonEngine.NEW_SESSION)).append("?").append("device_id=").append(Util.getMD5(Util.getMacAddress(paramContext))).append("&device_type=").append(Util.getDeviceName()).append("&fid=").append(paramForumStatus.getForumId()).append("&is_member=");
                    if (Util.isLoginedUser(paramContext, paramForumStatus.tapatalkForum)) {
                        i = 1;
                        localObject1 = i;
                        if ((paramForumStatus.tapatalkForum.getUserId() != null) && (!paramForumStatus.tapatalkForum.getUserId().equals(""))) {
                            localObject1 = localObject1 + "&user_id=" + paramForumStatus.tapatalkForum.getUserId();
                            Object localObject2 = localObject1;
                            if (paramForumStatus.tapatalkForum.getUserName() != null) {
                                localObject2 = localObject1;
                                if (!paramForumStatus.tapatalkForum.getUserName().equals("")) {
                                    localObject2 = localObject1 + "&username=" + paramForumStatus.tapatalkForum.getUserName();
                                }
                            }
                            TapatalkJsonEngine.callLogin(paramContext, (String) localObject2);
                            return;
                        }
                        localObject1 = localObject1 + "&user_id=0";
                        continue;
                    }
                } else {
                    return;
                }
            } catch (Exception paramContext) {
                paramContext.printStackTrace();
            }
            int i = 0;
        }
    }

    public void clearAll() {
    }

    public int getCount() {
        return 0;
    }

    public Object getItem(int paramInt) {
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public String getRegUrl() {
        return this.registerUrl;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return null;
    }

    public void get_config() {
        ArrayList localArrayList = new ArrayList();
        setOpCancel(false);
        this.engine.call("get_config", localArrayList);
    }

    public void login_fail(String paramString) {
    }

    public void login_mod(String paramString) {
        ArrayList localArrayList = new ArrayList();
        setOpCancel(false);
        localArrayList.add(this.forumStatus.tapatalkForum.getUserName().getBytes());
        localArrayList.add(paramString.getBytes());
        this.engine.call("login_mod", localArrayList);
    }

    public void logout_user() {
        ArrayList localArrayList = new ArrayList();
        setOpCancel(false);
        this.mStatus.updateUI(9, null);
        this.engine.call("logout_user", localArrayList);
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        String str = paramEngineResponse.getMethod();
        Boolean localBoolean = Boolean.valueOf(paramEngineResponse.isSuccess());
        Object localObject;
        if ((localBoolean.booleanValue()) && (str.equals("get_config"))) {
            localObject = PreferenceManager.getDefaultSharedPreferences(this.baseContext).edit();
            ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|response_zip", this.forumStatus.getUseZip());
            ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|agent", this.forumStatus.isAgent());
            ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|request_zip", this.forumStatus.isRequestZip());
            ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|content_type", this.forumStatus.isContentType());
            ((SharedPreferences.Editor) localObject).commit();
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            if (paramEngineResponse.containsKey("is_open")) {
                this.is_open = ((Boolean) paramEngineResponse.get("is_open"));
            }
            if (paramEngineResponse.containsKey("guest_okay")) {
                this.guest_okay = ((Boolean) paramEngineResponse.get("guest_okay"));
            }
            if (paramEngineResponse.containsKey("guest_search")) {
                if (!(paramEngineResponse.get("guest_search") instanceof String)) {
                    break label2913;
                }
                if (((String) paramEngineResponse.get("guest_search")).equalsIgnoreCase("1")) {
                    this.forumStatus.setGuestSearch(true);
                }
            }
        }
        for (; ; ) {
            if ((paramEngineResponse.containsKey("support_md5")) && (((String) paramEngineResponse.get("support_md5")).equalsIgnoreCase("1"))) {
                this.forumStatus.setMD5(true);
            }
            if (paramEngineResponse.containsKey("version")) {
                this.forumStatus.tapatalkForum.setmVersion((String) paramEngineResponse.get("version"), this.baseContext);
            }
            try {
                if (paramEngineResponse.containsKey("min_search_length")) {
                    this.forumStatus.setMinSearchLength(Integer.parseInt(paramEngineResponse.get("min_search_length").toString()));
                }
                if (paramEngineResponse.containsKey("reg_url")) {
                    this.registerUrl = ((String) paramEngineResponse.get("reg_url"));
                    this.forumStatus.setRegUrl(this.registerUrl);
                }
                this.forumStatus.setGuestOkay(this.guest_okay.booleanValue());
                if ((paramEngineResponse.containsKey("goto_unread")) && (((String) paramEngineResponse.get("goto_unread")).equalsIgnoreCase("1"))) {
                    Prefs.get(this.mContext).edit().putBoolean(this.forumStatus.getForumId() + "goto_unread", true).commit();
                    this.forumStatus.setSupportGoUnread(true);
                }
                if ((paramEngineResponse.containsKey("conversation")) && (((String) paramEngineResponse.get("conversation")).equalsIgnoreCase("1"))) {
                    this.forumStatus.tapatalkForum.setSupportConve(true);
                }
                if ((!this.mContext.getResources().getBoolean(2131558404)) && (!this.mContext.getResources().getBoolean(2131558405)) && (!this.mContext.getResources().getBoolean(2131558406))) {
                    if (!paramEngineResponse.containsKey("push")) {
                        break label2940;
                    }
                    this.forumStatus.tapatalkForum.setHasPushKey(true);
                    if (((String) paramEngineResponse.get("push")).equalsIgnoreCase("1")) {
                        this.forumStatus.tapatalkForum.setPush(true);
                    }
                    label687:
                    if (!paramEngineResponse.containsKey("push_type")) {
                        break label2954;
                    }
                    localObject = (String) paramEngineResponse.get("push_type");
                    if (((String) localObject).contains("quote")) {
                        this.forumStatus.tapatalkForum.setPushQuote(true);
                    }
                    if (((String) localObject).contains("pm")) {
                        this.forumStatus.tapatalkForum.setPushPM(true);
                    }
                    if (((String) localObject).contains("conv")) {
                        this.forumStatus.tapatalkForum.setPushConv(true);
                    }
                    if (((String) localObject).contains("sub")) {
                        this.forumStatus.tapatalkForum.setPushSub(true);
                    }
                    if (((String) localObject).contains("tag")) {
                        this.forumStatus.tapatalkForum.setPushTag(true);
                    }
                    if (((String) localObject).contains("like")) {
                        this.forumStatus.tapatalkForum.setPushLike(true);
                    }
                    if (((String) localObject).contains("thank")) {
                        this.forumStatus.tapatalkForum.setPushThank(true);
                    }
                    if (((String) localObject).contains("newtopic")) {
                        this.forumStatus.tapatalkForum.setPushNewTopic(true);
                    }
                }
                label876:
                if (paramEngineResponse.containsKey("default_smilies")) {
                    if (((String) paramEngineResponse.get("default_smilies")).equalsIgnoreCase("1")) {
                        this.forumStatus.setDefaultSmilies(true);
                    }
                } else {
                    label912:
                    if (paramEngineResponse.containsKey("advanced_search")) {
                        if (!((String) paramEngineResponse.get("advanced_search")).equalsIgnoreCase("1")) {
                            break label3003;
                        }
                        this.forumStatus.setAdvancedSearch(true);
                    }
                    label948:
                    if (paramEngineResponse.containsKey("subscribe_forum")) {
                        if (!((String) paramEngineResponse.get("subscribe_forum")).equalsIgnoreCase("1")) {
                            break label3014;
                        }
                        this.forumStatus.setSubscribeForum(true);
                    }
                    label984:
                    if ((paramEngineResponse.containsKey("goto_post")) && (((String) paramEngineResponse.get("goto_post")).equalsIgnoreCase("1"))) {
                        Prefs.get(this.mContext).edit().putBoolean(this.forumStatus.getForumId() + "goto_post", true).commit();
                        this.forumStatus.setSupportGoPost(true);
                    }
                    if ((paramEngineResponse.containsKey("subscribe_load")) && (((String) paramEngineResponse.get("subscribe_load")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setSubscribeLoad(true);
                    }
                    if ((paramEngineResponse.containsKey("pm_load")) && (((String) paramEngineResponse.get("pm_load")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setPmLoad(true);
                    }
                    if ((paramEngineResponse.containsKey("get_latest_topic")) && (((String) paramEngineResponse.get("get_latest_topic")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setSupportGetLatest(true);
                    }
                    if ((paramEngineResponse.containsKey("advanced_online_users")) && (((String) paramEngineResponse.get("advanced_online_users")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setAdvancedOnlineUsers(true);
                    }
                    if ((paramEngineResponse.containsKey("avatar")) && (((String) paramEngineResponse.get("avatar")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setSupport_avatar(true);
                    }
                    if ((paramEngineResponse.containsKey("disable_latest")) && (((String) paramEngineResponse.get("disable_latest")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setDisableLatest(true);
                    }
                    if ((paramEngineResponse.containsKey("disable_bbcode")) && (((String) paramEngineResponse.get("disable_bbcode")).equalsIgnoreCase("0"))) {
                        this.forumStatus.setSupprotBBcode(true);
                    }
                    if ((paramEngineResponse.containsKey("mark_forum")) && (((String) paramEngineResponse.get("mark_forum")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setMarkSubForum(true);
                    }
                    if ((paramEngineResponse.containsKey("disable_search")) && (((String) paramEngineResponse.get("disable_search")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setDisableSearch(true);
                    }
                    if ((paramEngineResponse.containsKey("disable_pm")) && (((String) paramEngineResponse.get("disable_pm")).equalsIgnoreCase("1"))) {
                        this.forumStatus.tapatalkForum.setPMEnable(false);
                    }
                    if (paramEngineResponse.containsKey("searchid")) {
                        if (!((String) paramEngineResponse.get("searchid")).equalsIgnoreCase("1")) {
                            break label3025;
                        }
                        this.forumStatus.setIsSearchIDEnabled(true);
                    }
                    label1470:
                    if (paramEngineResponse.containsKey("anonymous")) {
                        if (!((String) paramEngineResponse.get("anonymous")).equalsIgnoreCase("1")) {
                            break label3036;
                        }
                        this.forumStatus.setSupportAnonymous(true);
                    }
                    label1506:
                    if (paramEngineResponse.containsKey("no_refresh_on_post")) {
                        if (!((String) paramEngineResponse.get("no_refresh_on_post")).equalsIgnoreCase("1")) {
                            break label3047;
                        }
                        this.forumStatus.setNoRerefreshPost(true);
                    }
                    label1542:
                    if (paramEngineResponse.containsKey("inappreg")) {
                        localObject = (String) paramEngineResponse.get("inappreg");
                        if ((localObject == null) || (!((String) localObject).equals("0"))) {
                            break label3058;
                        }
                        this.forumStatus.setRegister(false);
                    }
                    label1585:
                    if ((paramEngineResponse.containsKey("advanced_delete")) && (((String) paramEngineResponse.get("advanced_delete")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setAdvanceDelete(true);
                    }
                    localObject = PreferenceManager.getDefaultSharedPreferences(this.baseContext);
                    if (!paramEngineResponse.containsKey("api_level")) {
                        break label3069;
                    }
                    this.forumStatus.tapatalkForum.setApiLevel(Integer.parseInt((String) paramEngineResponse.get("api_level")));
                    label1662:
                    if ((paramEngineResponse.containsKey("report_post")) && (((String) paramEngineResponse.get("report_post")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setReportPost(true);
                    }
                    if ((paramEngineResponse.containsKey("report_pm")) && (((String) paramEngineResponse.get("report_pm")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setReportPm(true);
                    }
                    if (paramEngineResponse.containsKey("mark_pm_unread")) {
                        if (!((String) paramEngineResponse.get("mark_pm_unread")).equalsIgnoreCase("0")) {
                            break label3083;
                        }
                        this.forumStatus.setMarkPmUnread(false);
                    }
                    label1771:
                    if (paramEngineResponse.containsKey("mark_pm_unread")) {
                        if (!((String) paramEngineResponse.get("mark_pm_unread")).equalsIgnoreCase("0")) {
                            break label3094;
                        }
                        this.forumStatus.setMarkCsUnread(false);
                    }
                    label1808:
                    if (!paramEngineResponse.containsKey("mod_report")) {
                        break label3116;
                    }
                    if (!((String) paramEngineResponse.get("mod_report")).equalsIgnoreCase("0")) {
                        break label3105;
                    }
                    this.forumStatus.setModReport(false);
                    label1845:
                    if ((!paramEngineResponse.containsKey("mod_delete")) && (!paramEngineResponse.containsKey("mode_approve")) && (!paramEngineResponse.containsKey("mod_report"))) {
                        break label3167;
                    }
                    this.forumStatus.setVersionSupportMod(true);
                    label1883:
                    if (!paramEngineResponse.containsKey("mod_approve")) {
                        break label3230;
                    }
                    if (!((String) paramEngineResponse.get("mod_approve")).equalsIgnoreCase("0")) {
                        break label3219;
                    }
                    this.forumStatus.setModApprove(false);
                    label1920:
                    if (!paramEngineResponse.containsKey("mod_delete")) {
                        break label3292;
                    }
                    if (!((String) paramEngineResponse.get("mod_delete")).equalsIgnoreCase("0")) {
                        break label3281;
                    }
                    this.forumStatus.setModDelete(false);
                    label1957:
                    if (paramEngineResponse.containsKey("delete_reason")) {
                        if (!((String) paramEngineResponse.get("delete_reason")).equalsIgnoreCase("0")) {
                            break label3343;
                        }
                        this.forumStatus.setDeleteReason(false);
                    }
                    label1994:
                    if (paramEngineResponse.containsKey("user_id")) {
                        if (!((String) paramEngineResponse.get("user_id")).equalsIgnoreCase("1")) {
                            break label3354;
                        }
                        this.forumStatus.setSupportUserId(true);
                    }
                    label2030:
                    if (paramEngineResponse.containsKey("announcement")) {
                        if (!((String) paramEngineResponse.get("announcement")).equalsIgnoreCase("1")) {
                            break label3365;
                        }
                        this.forumStatus.setAnnouncement(true);
                    }
                    label2066:
                    if (paramEngineResponse.containsKey("can_unread")) {
                        if (!((String) paramEngineResponse.get("can_unread")).equalsIgnoreCase("1")) {
                            break label3376;
                        }
                        this.forumStatus.setCanUnread(true);
                    }
                    label2102:
                    if (paramEngineResponse.containsKey("multi_quote")) {
                        if (!((String) paramEngineResponse.get("multi_quote")).equalsIgnoreCase("0")) {
                            break label3387;
                        }
                        this.forumStatus.setMultiQuote(false);
                    }
                    label2139:
                    if (paramEngineResponse.containsKey("alert")) {
                        if (!((String) paramEngineResponse.get("alert")).equalsIgnoreCase("0")) {
                            break label3398;
                        }
                        this.forumStatus.setAlert(false);
                    }
                    label2176:
                    if (paramEngineResponse.containsKey("sign_in")) {
                        if (!"1".equals((String) paramEngineResponse.get("sign_in"))) {
                            break label3409;
                        }
                        this.forumStatus.setSupportAppSignin(true);
                    }
                    label2212:
                    if (paramEngineResponse.containsKey("sso_login")) {
                        if (!((String) paramEngineResponse.get("sso_login")).equals("1")) {
                            break label3420;
                        }
                        this.forumStatus.setSsoLogin(true);
                    }
                    label2248:
                    if (paramEngineResponse.containsKey("sso_signin")) {
                        if (!((String) paramEngineResponse.get("sso_signin")).equals("1")) {
                            break label3431;
                        }
                        this.forumStatus.setSsoSign(true);
                    }
                    label2284:
                    if (paramEngineResponse.containsKey("sso_register")) {
                        if (!((String) paramEngineResponse.get("sso_register")).equals("1")) {
                            break label3442;
                        }
                        this.forumStatus.setSsoRegist(true);
                    }
                    label2320:
                    if (paramEngineResponse.containsKey("native_register")) {
                        if (!((String) paramEngineResponse.get("native_register")).equals("1")) {
                            break label3453;
                        }
                        this.forumStatus.setNativeRegist(true);
                    }
                    label2356:
                    if ((!paramEngineResponse.containsKey("sso_login")) && (!paramEngineResponse.containsKey("sso_signin"))) {
                        if (!this.forumStatus.isSupportAppSignin()) {
                            break label3464;
                        }
                        this.forumStatus.setSsoLogin(true);
                        this.forumStatus.setSsoSign(true);
                    }
                    label2402:
                    if ((!paramEngineResponse.containsKey("sso_register")) && (!paramEngineResponse.containsKey("native_register"))) {
                        if (!this.forumStatus.isSupportAppSignin()) {
                            break label3483;
                        }
                        this.forumStatus.setSsoRegist(false);
                        this.forumStatus.setNativeRegist(true);
                    }
                    label2448:
                    if (paramEngineResponse.containsKey("ban_delete_type")) {
                        if (!((String) paramEngineResponse.get("ban_delete_type")).equalsIgnoreCase("none")) {
                            break label3502;
                        }
                        this.forumStatus.setBan_delete_type(true);
                    }
                    label2485:
                    if (paramEngineResponse.containsKey("mark_topic_read")) {
                        if (!((String) paramEngineResponse.get("mark_topic_read")).equalsIgnoreCase("0")) {
                            break label3513;
                        }
                        this.forumStatus.setMarkTopicRead(false);
                    }
                    label2522:
                    if (paramEngineResponse.containsKey("emoji_support")) {
                        if (!((String) paramEngineResponse.get("emoji_support")).equalsIgnoreCase("0")) {
                            break label3524;
                        }
                        this.forumStatus.setIsSupportEmoji(false);
                    }
                    label2559:
                    if (paramEngineResponse.containsKey("ban_expires")) {
                        if (!((String) paramEngineResponse.get("ban_expires")).equalsIgnoreCase("0")) {
                            break label3535;
                        }
                        this.forumStatus.setBanExpires(false);
                    }
                    label2596:
                    logForumUsage(this.mContext, this.forumStatus);
                    if (!this.is_open.booleanValue()) {
                        break label3738;
                    }
                    if (!isOpCancel()) {
                        PreferenceManager.getDefaultSharedPreferences(this.baseContext);
                        if (((!this.forumStatus.isSsoSign()) && (!this.forumStatus.isSsoLogin())) || (this.forumStatus.tapatalkForum.getUserName() == null) || (this.forumStatus.tapatalkForum.getUserName().length() <= 0) || (this.forumStatus.tapatalkForum.hasPassword())) {
                            break label3546;
                        }
                        if ((this.baseContext instanceof SlidingMenuActivity)) {
                            ((SlidingMenuActivity) this.baseContext).needLogSign = true;
                        }
                    }
                    label2715:
                    if ((this.forumStatus != null) && (this.forumStatus.isGuestOkay()) && ((this.forumStatus.tapatalkForum.getPassword() == null) || (this.forumStatus.tapatalkForum.getPassword().length() == 0)) && ((!this.forumStatus.tapatalkForum.isCanSignInWithTapatalkId(this.baseContext)) || (this.forumStatus.tapatalkForum.hasPassword()))) {
                        new ForumAdapter(this.mContext, this.forumStatus.getUrl(), true).updateForum();
                    }
                    if ((this.forumStatus.isSsoSign()) && (this.forumStatus.tapatalkForum.getUserName() != null) && (this.forumStatus.tapatalkForum.getUserName().length() > 0) && (!this.forumStatus.tapatalkForum.hasPassword())) {
                        this.shouldShowError = false;
                    }
                }
                for (; ; ) {
                    if ((!localBoolean.booleanValue()) && (str.equals("get_config"))) {
                        AppCacheManager.clearForumCache(this.mContext, this.forumStatus.getUrl());
                        ((SlidingMenuActivity) this.baseContext).showView();
                    }
                    return;
                    label2913:
                    if (!((Boolean) paramEngineResponse.get("guest_search")).booleanValue()) {
                        break;
                    }
                    this.forumStatus.setGuestSearch(true);
                    break;
                    label2940:
                    this.forumStatus.tapatalkForum.setHasPushKey(false);
                    break label687;
                    label2954:
                    if (!this.forumStatus.tapatalkForum.isPush()) {
                        break label876;
                    }
                    this.forumStatus.tapatalkForum.setPushPM(true);
                    this.forumStatus.tapatalkForum.setPushSub(true);
                    break label876;
                    this.forumStatus.setDefaultSmilies(false);
                    break label912;
                    label3003:
                    this.forumStatus.setAdvancedSearch(false);
                    break label948;
                    label3014:
                    this.forumStatus.setSubscribeForum(false);
                    break label984;
                    label3025:
                    this.forumStatus.setIsSearchIDEnabled(false);
                    break label1470;
                    label3036:
                    this.forumStatus.setSupportAnonymous(false);
                    break label1506;
                    label3047:
                    this.forumStatus.setNoRerefreshPost(false);
                    break label1542;
                    label3058:
                    this.forumStatus.setRegister(true);
                    break label1585;
                    label3069:
                    this.forumStatus.tapatalkForum.setApiLevel(0);
                    break label1662;
                    label3083:
                    this.forumStatus.setMarkPmUnread(true);
                    break label1771;
                    label3094:
                    this.forumStatus.setMarkCsUnread(true);
                    break label1808;
                    label3105:
                    this.forumStatus.setModReport(true);
                    break label1845;
                    label3116:
                    if (!paramEngineResponse.containsKey("m_report")) {
                        break label1845;
                    }
                    if (((String) paramEngineResponse.get("m_report")).equalsIgnoreCase("0")) {
                        this.forumStatus.setModReport(false);
                        break label1845;
                    }
                    this.forumStatus.setModReport(true);
                    break label1845;
                    label3167:
                    if ((paramEngineResponse.containsKey("m_delete")) || (paramEngineResponse.containsKey("m_approve")) || (paramEngineResponse.containsKey("m_report"))) {
                        this.forumStatus.setVersionSupportMod(true);
                        break label1883;
                    }
                    this.forumStatus.setVersionSupportMod(false);
                    break label1883;
                    label3219:
                    this.forumStatus.setModApprove(true);
                    break label1920;
                    label3230:
                    if (!paramEngineResponse.containsKey("m_approve")) {
                        break label1920;
                    }
                    if (((String) paramEngineResponse.get("m_approve")).equalsIgnoreCase("0")) {
                        this.forumStatus.setModApprove(false);
                        break label1920;
                    }
                    this.forumStatus.setModApprove(true);
                    break label1920;
                    label3281:
                    this.forumStatus.setModDelete(true);
                    break label1957;
                    label3292:
                    if (!paramEngineResponse.containsKey("m_delete")) {
                        break label1957;
                    }
                    if (((String) paramEngineResponse.get("m_delete")).equalsIgnoreCase("0")) {
                        this.forumStatus.setModDelete(false);
                        break label1957;
                    }
                    this.forumStatus.setModDelete(true);
                    break label1957;
                    label3343:
                    this.forumStatus.setDeleteReason(true);
                    break label1994;
                    label3354:
                    this.forumStatus.setSupportUserId(false);
                    break label2030;
                    label3365:
                    this.forumStatus.setAnnouncement(false);
                    break label2066;
                    label3376:
                    this.forumStatus.setCanUnread(false);
                    break label2102;
                    label3387:
                    this.forumStatus.setMultiQuote(true);
                    break label2139;
                    label3398:
                    this.forumStatus.setAlert(true);
                    break label2176;
                    label3409:
                    this.forumStatus.setSupportAppSignin(false);
                    break label2212;
                    label3420:
                    this.forumStatus.setSsoLogin(false);
                    break label2248;
                    label3431:
                    this.forumStatus.setSsoSign(false);
                    break label2284;
                    label3442:
                    this.forumStatus.setSsoRegist(false);
                    break label2320;
                    label3453:
                    this.forumStatus.setNativeRegist(false);
                    break label2356;
                    label3464:
                    this.forumStatus.setSsoLogin(false);
                    this.forumStatus.setSsoSign(false);
                    break label2402;
                    label3483:
                    this.forumStatus.setSsoRegist(false);
                    this.forumStatus.setNativeRegist(false);
                    break label2448;
                    label3502:
                    this.forumStatus.setBan_delete_type(false);
                    break label2485;
                    label3513:
                    this.forumStatus.setMarkTopicRead(true);
                    break label2522;
                    label3524:
                    this.forumStatus.setIsSupportEmoji(true);
                    break label2559;
                    label3535:
                    this.forumStatus.setBanExpires(true);
                    break label2596;
                    label3546:
                    if ((this.forumStatus.tapatalkForum.getUserName() != null) && (this.forumStatus.tapatalkForum.getUserName().length() > 0) && (this.forumStatus.tapatalkForum.hasPassword())) {
                        break label2715;
                    }
                    boolean bool = ((SharedPreferences) localObject).getBoolean("login", false);
                    paramEngineResponse = ((SharedPreferences) localObject).getString("status", "0");
                    localObject = ((SharedPreferences) localObject).getString("email", "");
                    if (((this.mContext instanceof SlidingMenuActivity)) && (this.forumStatus.isSsoLogin()) && (bool) && (paramEngineResponse.equals("1")) && (Util.checkString((String) localObject))) {
                        if (!this.forumStatus.tapatalkForum.getUserName().equals("")) {
                            break label2715;
                        }
                        ((SlidingMenuActivity) this.mContext).callPrefechAccount(this.forumStatus);
                        break label2715;
                    }
                    if (this.guest_okay.booleanValue()) {
                        ((SlidingMenuActivity) this.baseContext).showView();
                        break label2715;
                    }
                    ((SlidingMenuActivity) this.baseContext).showSelectView(1027);
                    break label2715;
                    label3738:
                    this.mContext.finish();
                    break label2715;
                    if (!str.equals("logout_user")) {
                        if (str.equalsIgnoreCase(this.forumStatus.getUrl())) {
                            get_config();
                        } else if ("prefetch_account".equals(str)) {
                            this.mStatus.closeProgress();
                            if (localBoolean.booleanValue()) {
                                paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                            }
                        } else if (str.equals("login")) {
                            this.mStatus.closeProgress();
                            localObject = (HashMap) paramEngineResponse.getResponse();
                            paramEngineResponse = (String) ((HashMap) localObject).get("status");
                            try {
                                paramEngineResponse = new String((byte[]) ((HashMap) localObject).get("result_text"), "UTF-8");
                                if (paramEngineResponse.equals("")) {
                                    continue;
                                }
                                Toast.makeText(this.mContext, paramEngineResponse, 1).show();
                            } catch (Exception paramEngineResponse) {
                                for (; ; ) {
                                    paramEngineResponse = new String((byte[]) ((HashMap) localObject).get("result_text"));
                                }
                            }
                        } else if ((str.equals("sign_in")) && (this.mLoginFragment != null)) {
                            HashMap localHashMap = (HashMap) paramEngineResponse.getResponse();
                            if (!((Boolean) localHashMap.get("result")).booleanValue()) {
                                paramEngineResponse = "";
                                if (localHashMap.containsKey("status")) {
                                    paramEngineResponse = (String) localHashMap.get("status");
                                }
                                if (paramEngineResponse.equals("2")) {
                                    this.mLoginFragment.showLoginErrorDialog4HasStatus(paramEngineResponse);
                                } else {
                                    localObject = new String((byte[]) localHashMap.get("result_text"));
                                    Toast.makeText(this.baseContext, (CharSequence) localObject, 1).show();
                                    if ((Util.checkString(paramEngineResponse)) && (localHashMap.containsKey("status")) && ("1".equals(paramEngineResponse))) {
                                        this.mStatus.closeProgress();
                                        paramEngineResponse = (EngineResponse) localObject;
                                        if (!Util.checkString((String) localObject)) {
                                            paramEngineResponse = String.format(this.mContext.getString(2131100532), new Object[]{this.mLoginFragment.getNeededString(1)});
                                        }
                                        this.mLoginFragment.showSignErrorDialog(paramEngineResponse);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
        }
    }

    public void refresh() {
        setOpCancel(false);
    }

    public void setFragment(LoginHandle paramLoginHandle) {
        this.mLoginFragment = paramLoginHandle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ConfigAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */