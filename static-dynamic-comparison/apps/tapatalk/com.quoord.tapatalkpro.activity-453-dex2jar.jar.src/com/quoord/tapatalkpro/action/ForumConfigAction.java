package com.quoord.tapatalkpro.action;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tools.net.HashUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumConfigAction
        implements TryTwiceCallBackInterface {
    private ActionCallBack actionCallBack;
    private Context context;
    private TapatalkEngine engine;
    private ForumStatus forumStatus;
    private String resultTex;
    private int retryCount = 0;
    private boolean tryTwice = true;

    public ForumConfigAction(Context paramContext, ForumStatus paramForumStatus) {
        this.context = paramContext;
        this.forumStatus = paramForumStatus;
        this.engine = new TapatalkEngine(this, this.forumStatus, this.context);
    }

    public void analyticResult(HashMap paramHashMap) {
        Object localObject = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
        ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|response_zip", this.forumStatus.getUseZip());
        ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|agent", this.forumStatus.isAgent());
        ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|request_zip", this.forumStatus.isRequestZip());
        ((SharedPreferences.Editor) localObject).putBoolean(this.forumStatus.getForumId() + "|content_type", this.forumStatus.isContentType());
        ((SharedPreferences.Editor) localObject).commit();
        if (paramHashMap.containsKey("is_open")) {
            this.forumStatus.isOpen = ((Boolean) paramHashMap.get("is_open")).booleanValue();
        }
        if (paramHashMap.containsKey("guest_okay")) {
            this.forumStatus.setGuestOkay(((Boolean) paramHashMap.get("guest_okay")).booleanValue());
        }
        if (paramHashMap.containsKey("guest_search")) {
            if (!(paramHashMap.get("guest_search") instanceof String)) {
                break label2779;
            }
            if (((String) paramHashMap.get("guest_search")).equalsIgnoreCase("1")) {
                this.forumStatus.setGuestSearch(true);
            }
        }
        for (; ; ) {
            if ((paramHashMap.containsKey("support_md5")) && (((String) paramHashMap.get("support_md5")).equalsIgnoreCase("1"))) {
                this.forumStatus.setMD5(true);
            }
            if (paramHashMap.containsKey("version")) {
                this.forumStatus.tapatalkForum.setmVersion((String) paramHashMap.get("version"), this.context);
            }
            try {
                if (paramHashMap.containsKey("min_search_length")) {
                    this.forumStatus.setMinSearchLength(Integer.parseInt(paramHashMap.get("min_search_length").toString()));
                }
                if (paramHashMap.containsKey("reg_url")) {
                    this.forumStatus.setRegUrl((String) paramHashMap.get("reg_url"));
                }
                if ((paramHashMap.containsKey("goto_unread")) && (((String) paramHashMap.get("goto_unread")).equalsIgnoreCase("1"))) {
                    Prefs.get(this.context).edit().putBoolean(this.forumStatus.getForumId() + "goto_unread", true).commit();
                    this.forumStatus.setSupportGoUnread(true);
                }
                if ((paramHashMap.containsKey("conversation")) && (((String) paramHashMap.get("conversation")).equalsIgnoreCase("1"))) {
                    this.forumStatus.tapatalkForum.setSupportConve(true);
                }
                if ((!this.context.getResources().getBoolean(2131558404)) && (!this.context.getResources().getBoolean(2131558405)) && (!this.context.getResources().getBoolean(2131558406))) {
                    if (!paramHashMap.containsKey("push")) {
                        break label2805;
                    }
                    this.forumStatus.tapatalkForum.setHasPushKey(true);
                    if (((String) paramHashMap.get("push")).equalsIgnoreCase("1")) {
                        this.forumStatus.tapatalkForum.setPush(true);
                    }
                    label610:
                    if (!paramHashMap.containsKey("push_type")) {
                        break label2819;
                    }
                    localObject = (String) paramHashMap.get("push_type");
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
                label792:
                if (paramHashMap.containsKey("default_smilies")) {
                    if (((String) paramHashMap.get("default_smilies")).equalsIgnoreCase("1")) {
                        this.forumStatus.setDefaultSmilies(true);
                    }
                } else {
                    label828:
                    if (paramHashMap.containsKey("advanced_search")) {
                        if (!((String) paramHashMap.get("advanced_search")).equalsIgnoreCase("1")) {
                            break label2868;
                        }
                        this.forumStatus.setAdvancedSearch(true);
                    }
                    label864:
                    if (paramHashMap.containsKey("subscribe_forum")) {
                        if (!((String) paramHashMap.get("subscribe_forum")).equalsIgnoreCase("1")) {
                            break label2879;
                        }
                        this.forumStatus.setSubscribeForum(true);
                    }
                    label900:
                    if ((paramHashMap.containsKey("goto_post")) && (((String) paramHashMap.get("goto_post")).equalsIgnoreCase("1"))) {
                        Prefs.get(this.context).edit().putBoolean(this.forumStatus.getForumId() + "goto_post", true).commit();
                        this.forumStatus.setSupportGoPost(true);
                    }
                    if ((paramHashMap.containsKey("subscribe_load")) && (((String) paramHashMap.get("subscribe_load")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setSubscribeLoad(true);
                    }
                    if ((paramHashMap.containsKey("pm_load")) && (((String) paramHashMap.get("pm_load")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setPmLoad(true);
                    }
                    if ((paramHashMap.containsKey("get_latest_topic")) && (((String) paramHashMap.get("get_latest_topic")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setSupportGetLatest(true);
                    }
                    if ((paramHashMap.containsKey("advanced_online_users")) && (((String) paramHashMap.get("advanced_online_users")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setAdvancedOnlineUsers(true);
                    }
                    if ((paramHashMap.containsKey("avatar")) && (((String) paramHashMap.get("avatar")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setSupport_avatar(true);
                    }
                    if ((paramHashMap.containsKey("disable_latest")) && (((String) paramHashMap.get("disable_latest")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setDisableLatest(true);
                    }
                    if ((paramHashMap.containsKey("disable_bbcode")) && (((String) paramHashMap.get("disable_bbcode")).equalsIgnoreCase("0"))) {
                        this.forumStatus.setSupprotBBcode(true);
                    }
                    if ((paramHashMap.containsKey("mark_forum")) && (((String) paramHashMap.get("mark_forum")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setMarkSubForum(true);
                    }
                    if ((paramHashMap.containsKey("disable_search")) && (((String) paramHashMap.get("disable_search")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setDisableSearch(true);
                    }
                    if ((paramHashMap.containsKey("disable_pm")) && (((String) paramHashMap.get("disable_pm")).equalsIgnoreCase("1"))) {
                        this.forumStatus.tapatalkForum.setPMEnable(false);
                    }
                    if (paramHashMap.containsKey("searchid")) {
                        if (!((String) paramHashMap.get("searchid")).equalsIgnoreCase("1")) {
                            break label2890;
                        }
                        this.forumStatus.setIsSearchIDEnabled(true);
                    }
                    label1386:
                    if (paramHashMap.containsKey("anonymous")) {
                        if (!((String) paramHashMap.get("anonymous")).equalsIgnoreCase("1")) {
                            break label2901;
                        }
                        this.forumStatus.setSupportAnonymous(true);
                    }
                    label1422:
                    if (paramHashMap.containsKey("no_refresh_on_post")) {
                        if (!((String) paramHashMap.get("no_refresh_on_post")).equalsIgnoreCase("1")) {
                            break label2912;
                        }
                        this.forumStatus.setNoRerefreshPost(true);
                    }
                    label1458:
                    if (paramHashMap.containsKey("inappreg")) {
                        localObject = (String) paramHashMap.get("inappreg");
                        if ((localObject == null) || (!((String) localObject).equals("0"))) {
                            break label2923;
                        }
                        this.forumStatus.setRegister(false);
                    }
                    label1501:
                    if ((paramHashMap.containsKey("advanced_delete")) && (((String) paramHashMap.get("advanced_delete")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setAdvanceDelete(true);
                    }
                    PreferenceManager.getDefaultSharedPreferences(this.context);
                    if (!paramHashMap.containsKey("api_level")) {
                        break label2934;
                    }
                    this.forumStatus.tapatalkForum.setApiLevel(Integer.parseInt((String) paramHashMap.get("api_level")));
                    label1578:
                    if ((paramHashMap.containsKey("report_post")) && (((String) paramHashMap.get("report_post")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setReportPost(true);
                    }
                    if ((paramHashMap.containsKey("report_pm")) && (((String) paramHashMap.get("report_pm")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setReportPm(true);
                    }
                    if (paramHashMap.containsKey("mark_pm_unread")) {
                        if (!((String) paramHashMap.get("mark_pm_unread")).equalsIgnoreCase("0")) {
                            break label2948;
                        }
                        this.forumStatus.setMarkPmUnread(false);
                    }
                    label1687:
                    if (paramHashMap.containsKey("mark_pm_unread")) {
                        if (!((String) paramHashMap.get("mark_pm_unread")).equalsIgnoreCase("0")) {
                            break label2959;
                        }
                        this.forumStatus.setMarkCsUnread(false);
                    }
                    label1724:
                    if (!paramHashMap.containsKey("mod_report")) {
                        break label2981;
                    }
                    if (!((String) paramHashMap.get("mod_report")).equalsIgnoreCase("0")) {
                        break label2970;
                    }
                    this.forumStatus.setModReport(false);
                    label1761:
                    if ((!paramHashMap.containsKey("mod_delete")) && (!paramHashMap.containsKey("mode_approve")) && (!paramHashMap.containsKey("mod_report"))) {
                        break label3032;
                    }
                    this.forumStatus.setVersionSupportMod(true);
                    label1799:
                    if (!paramHashMap.containsKey("mod_approve")) {
                        break label3095;
                    }
                    if (!((String) paramHashMap.get("mod_approve")).equalsIgnoreCase("0")) {
                        break label3084;
                    }
                    this.forumStatus.setModApprove(false);
                    label1836:
                    if (!paramHashMap.containsKey("mod_delete")) {
                        break label3157;
                    }
                    if (!((String) paramHashMap.get("mod_delete")).equalsIgnoreCase("0")) {
                        break label3146;
                    }
                    this.forumStatus.setModDelete(false);
                    label1873:
                    if (paramHashMap.containsKey("advanced_merge")) {
                        if (!((String) paramHashMap.get("advanced_merge")).equalsIgnoreCase("0")) {
                            break label3208;
                        }
                        this.forumStatus.setSupportAdvanceMerge(false);
                    }
                    label1910:
                    if (paramHashMap.containsKey("advanced_move")) {
                        if (!((String) paramHashMap.get("advanced_move")).equalsIgnoreCase("0")) {
                            break label3219;
                        }
                        this.forumStatus.setSupportAdvanceMove(false);
                    }
                    label1947:
                    if (paramHashMap.containsKey("delete_reason")) {
                        if (!((String) paramHashMap.get("delete_reason")).equalsIgnoreCase("0")) {
                            break label3230;
                        }
                        this.forumStatus.setDeleteReason(false);
                    }
                    label1984:
                    if (paramHashMap.containsKey("user_id")) {
                        if (!((String) paramHashMap.get("user_id")).equalsIgnoreCase("1")) {
                            break label3241;
                        }
                        this.forumStatus.setSupportUserId(true);
                    }
                    label2020:
                    if (paramHashMap.containsKey("announcement")) {
                        if (!((String) paramHashMap.get("announcement")).equalsIgnoreCase("1")) {
                            break label3252;
                        }
                        this.forumStatus.setAnnouncement(true);
                    }
                    label2056:
                    if (paramHashMap.containsKey("can_unread")) {
                        if (!((String) paramHashMap.get("can_unread")).equalsIgnoreCase("1")) {
                            break label3263;
                        }
                        this.forumStatus.setCanUnread(true);
                    }
                    label2092:
                    if (paramHashMap.containsKey("multi_quote")) {
                        if (!((String) paramHashMap.get("multi_quote")).equalsIgnoreCase("0")) {
                            break label3274;
                        }
                        this.forumStatus.setMultiQuote(false);
                    }
                    label2129:
                    if (paramHashMap.containsKey("alert")) {
                        if (!((String) paramHashMap.get("alert")).equalsIgnoreCase("0")) {
                            break label3285;
                        }
                        this.forumStatus.setAlert(false);
                    }
                    label2166:
                    if (paramHashMap.containsKey("sign_in")) {
                        if (!((String) paramHashMap.get("sign_in")).equals("1")) {
                            break label3296;
                        }
                        this.forumStatus.setSupportAppSignin(true);
                    }
                    label2202:
                    if (paramHashMap.containsKey("sso_login")) {
                        if (!((String) paramHashMap.get("sso_login")).equals("1")) {
                            break label3307;
                        }
                        this.forumStatus.setSsoLogin(true);
                    }
                    label2238:
                    if (paramHashMap.containsKey("sso_signin")) {
                        if (!((String) paramHashMap.get("sso_signin")).equals("1")) {
                            break label3318;
                        }
                        this.forumStatus.setSsoSign(true);
                    }
                    label2274:
                    if (paramHashMap.containsKey("sso_register")) {
                        if (!((String) paramHashMap.get("sso_register")).equals("1")) {
                            break label3329;
                        }
                        this.forumStatus.setSsoRegist(true);
                    }
                    label2310:
                    if (paramHashMap.containsKey("native_register")) {
                        if (!((String) paramHashMap.get("native_register")).equals("1")) {
                            break label3340;
                        }
                        this.forumStatus.setNativeRegist(true);
                    }
                    label2346:
                    if ((!paramHashMap.containsKey("sso_login")) && (!paramHashMap.containsKey("sso_signin"))) {
                        if (!this.forumStatus.isSupportAppSignin()) {
                            break label3351;
                        }
                        this.forumStatus.setSsoLogin(true);
                        this.forumStatus.setSsoSign(true);
                    }
                    label2392:
                    if ((!paramHashMap.containsKey("sso_register")) && (!paramHashMap.containsKey("native_register"))) {
                        if (!this.forumStatus.isRegister()) {
                            break label3370;
                        }
                        this.forumStatus.setSsoRegist(false);
                        this.forumStatus.setNativeRegist(true);
                    }
                    label2438:
                    if (paramHashMap.containsKey("ban_delete_type")) {
                        if (!((String) paramHashMap.get("ban_delete_type")).equalsIgnoreCase("none")) {
                            break label3389;
                        }
                        this.forumStatus.setBan_delete_type(true);
                    }
                    label2475:
                    if (paramHashMap.containsKey("mark_topic_read")) {
                        if (!((String) paramHashMap.get("mark_topic_read")).equalsIgnoreCase("0")) {
                            break label3400;
                        }
                        this.forumStatus.setMarkTopicRead(false);
                    }
                    label2512:
                    if (paramHashMap.containsKey("emoji_support")) {
                        if (!((String) paramHashMap.get("emoji_support")).equalsIgnoreCase("0")) {
                            break label3411;
                        }
                        this.forumStatus.setIsSupportEmoji(false);
                    }
                    label2549:
                    if (!paramHashMap.containsKey("result_text")) {
                    }
                }
                try {
                    this.resultTex = new String((byte[]) paramHashMap.get("result_text"));
                    if ((paramHashMap.containsKey("get_contact")) && (((String) paramHashMap.get("get_contact")).equalsIgnoreCase("1"))) {
                        this.forumStatus.setSupportGetContact(true);
                    }
                    if (paramHashMap.containsKey("ban_expires")) {
                        if (((String) paramHashMap.get("ban_expires")).equalsIgnoreCase("0")) {
                            this.forumStatus.setBanExpires(false);
                        }
                    } else {
                        label2653:
                        if (paramHashMap.containsKey("unban")) {
                            if (!((String) paramHashMap.get("unban")).equalsIgnoreCase("0")) {
                                break label3433;
                            }
                            this.forumStatus.setUnban(false);
                        }
                    }
                    for (; ; ) {
                        if (paramHashMap.containsKey("ads_disabled_group")) {
                            this.forumStatus.setAdsDisabledGroup(HashUtil.getString(paramHashMap.get("ads_disabled_group")));
                        }
                        if (paramHashMap.containsKey("guest_group_id")) {
                            this.forumStatus.setGuestGroupId(HashUtil.getString(paramHashMap.get("guest_group_id")));
                        }
                        if (paramHashMap.containsKey("prefix_edit")) {
                            this.forumStatus.setCanEditPrefix(HashUtil.getBoolean(paramHashMap.get("prefix_edit"), Boolean.valueOf(false)).booleanValue());
                        }
                        return;
                        label2779:
                        if (!((Boolean) paramHashMap.get("guest_search")).booleanValue()) {
                            break;
                        }
                        this.forumStatus.setGuestSearch(true);
                        break;
                        label2805:
                        this.forumStatus.tapatalkForum.setHasPushKey(false);
                        break label610;
                        label2819:
                        if (!this.forumStatus.tapatalkForum.isPush()) {
                            break label792;
                        }
                        this.forumStatus.tapatalkForum.setPushPM(true);
                        this.forumStatus.tapatalkForum.setPushSub(true);
                        break label792;
                        this.forumStatus.setDefaultSmilies(false);
                        break label828;
                        label2868:
                        this.forumStatus.setAdvancedSearch(false);
                        break label864;
                        label2879:
                        this.forumStatus.setSubscribeForum(false);
                        break label900;
                        label2890:
                        this.forumStatus.setIsSearchIDEnabled(false);
                        break label1386;
                        label2901:
                        this.forumStatus.setSupportAnonymous(false);
                        break label1422;
                        label2912:
                        this.forumStatus.setNoRerefreshPost(false);
                        break label1458;
                        label2923:
                        this.forumStatus.setRegister(true);
                        break label1501;
                        label2934:
                        this.forumStatus.tapatalkForum.setApiLevel(0);
                        break label1578;
                        label2948:
                        this.forumStatus.setMarkPmUnread(true);
                        break label1687;
                        label2959:
                        this.forumStatus.setMarkCsUnread(true);
                        break label1724;
                        label2970:
                        this.forumStatus.setModReport(true);
                        break label1761;
                        label2981:
                        if (!paramHashMap.containsKey("m_report")) {
                            break label1761;
                        }
                        if (((String) paramHashMap.get("m_report")).equalsIgnoreCase("0")) {
                            this.forumStatus.setModReport(false);
                            break label1761;
                        }
                        this.forumStatus.setModReport(true);
                        break label1761;
                        label3032:
                        if ((paramHashMap.containsKey("m_delete")) || (paramHashMap.containsKey("m_approve")) || (paramHashMap.containsKey("m_report"))) {
                            this.forumStatus.setVersionSupportMod(true);
                            break label1799;
                        }
                        this.forumStatus.setVersionSupportMod(false);
                        break label1799;
                        label3084:
                        this.forumStatus.setModApprove(true);
                        break label1836;
                        label3095:
                        if (!paramHashMap.containsKey("m_approve")) {
                            break label1836;
                        }
                        if (((String) paramHashMap.get("m_approve")).equalsIgnoreCase("0")) {
                            this.forumStatus.setModApprove(false);
                            break label1836;
                        }
                        this.forumStatus.setModApprove(true);
                        break label1836;
                        label3146:
                        this.forumStatus.setModDelete(true);
                        break label1873;
                        label3157:
                        if (!paramHashMap.containsKey("m_delete")) {
                            break label1873;
                        }
                        if (((String) paramHashMap.get("m_delete")).equalsIgnoreCase("0")) {
                            this.forumStatus.setModDelete(false);
                            break label1873;
                        }
                        this.forumStatus.setModDelete(true);
                        break label1873;
                        label3208:
                        this.forumStatus.setSupportAdvanceMerge(true);
                        break label1910;
                        label3219:
                        this.forumStatus.setSupportAdvanceMove(true);
                        break label1947;
                        label3230:
                        this.forumStatus.setDeleteReason(true);
                        break label1984;
                        label3241:
                        this.forumStatus.setSupportUserId(false);
                        break label2020;
                        label3252:
                        this.forumStatus.setAnnouncement(false);
                        break label2056;
                        label3263:
                        this.forumStatus.setCanUnread(false);
                        break label2092;
                        label3274:
                        this.forumStatus.setMultiQuote(true);
                        break label2129;
                        label3285:
                        this.forumStatus.setAlert(true);
                        break label2166;
                        label3296:
                        this.forumStatus.setSupportAppSignin(false);
                        break label2202;
                        label3307:
                        this.forumStatus.setSsoLogin(false);
                        break label2238;
                        label3318:
                        this.forumStatus.setSsoSign(false);
                        break label2274;
                        label3329:
                        this.forumStatus.setSsoRegist(false);
                        break label2310;
                        label3340:
                        this.forumStatus.setNativeRegist(false);
                        break label2346;
                        label3351:
                        this.forumStatus.setSsoLogin(false);
                        this.forumStatus.setSsoSign(false);
                        break label2392;
                        label3370:
                        this.forumStatus.setSsoRegist(false);
                        this.forumStatus.setNativeRegist(false);
                        break label2438;
                        label3389:
                        this.forumStatus.setBan_delete_type(false);
                        break label2475;
                        label3400:
                        this.forumStatus.setMarkTopicRead(true);
                        break label2512;
                        label3411:
                        this.forumStatus.setIsSupportEmoji(true);
                        break label2549;
                        this.forumStatus.setBanExpires(true);
                        break label2653;
                        label3433:
                        this.forumStatus.setUnban(true);
                    }
                } catch (Exception localException1) {
                    for (; ; ) {
                    }
                }
            } catch (Exception localException2) {
                for (; ; ) {
                }
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        boolean bool = paramEngineResponse.isSuccess();
        if (!bool) {
            if (this.retryCount < 4) {
                if (this.retryCount == 0) {
                    this.forumStatus.setAgent(true);
                    getConfig();
                    this.retryCount += 1;
                }
            }
        }
        for (; ; ) {
            return;
            if (this.retryCount == 1) {
                this.forumStatus.setZip(false);
                getConfig();
                this.retryCount += 1;
                return;
            }
            if (this.retryCount == 2) {
                this.forumStatus.setContentType(false);
                getConfig();
                this.retryCount += 1;
                return;
            }
            if (this.retryCount == 3) {
                this.forumStatus.setContentType(true);
                getConfig();
                this.retryCount += 1;
                return;
                this.retryCount = 0;
                SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                localEditor.remove(this.forumStatus.getForumId() + "|response_zip");
                localEditor.remove(this.forumStatus.getForumId() + "|agent");
                localEditor.remove(this.forumStatus.getForumId() + "|request_zip");
                localEditor.remove(this.forumStatus.getForumId() + "|content_type");
                localEditor.commit();
                paramEngineResponse.setErrorMessage(this.context.getString(2131100071));
            }
            while (this.actionCallBack != null) {
                if ((!bool) || (!this.forumStatus.isOpen)) {
                    break label356;
                }
                this.actionCallBack.actionSuccessBack(this.forumStatus);
                return;
                analyticResult((HashMap) paramEngineResponse.getResponse());
            }
        }
        label356:
        if (!this.forumStatus.isOpen) {
            if ((this.resultTex == null) || (this.resultTex.equals(""))) {
                this.resultTex = this.context.getString(2131100071);
            }
            this.actionCallBack.actionErrorBack(this.resultTex);
            this.resultTex = "";
            return;
        }
        if ((paramEngineResponse.getErrorMessage() == null) || (paramEngineResponse.getErrorMessage().equals(""))) {
            paramEngineResponse.setErrorMessage(this.context.getString(2131100071));
        }
        this.actionCallBack.actionErrorBack(paramEngineResponse.getErrorMessage());
    }

    public void getConfig() {
        setTryTwice(true);
        ArrayList localArrayList = new ArrayList();
        this.engine.call("get_config", localArrayList);
    }

    public void getConfig(ActionCallBack paramActionCallBack) {
        this.actionCallBack = paramActionCallBack;
        getConfig();
    }

    public void getLocalConfig() {
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

    public static abstract interface ActionCallBack {
        public abstract void actionErrorBack(String paramString);

        public abstract void actionSuccessBack(ForumStatus paramForumStatus);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/ForumConfigAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */