package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.widget.TextView;

public final class Prefs {
    public static final String FIRST_ENTRY_FORUM = "first_entry_forum";
    public static final String FORUM_UID_SOTRED_TIME = "fourm_uid_stored_time_";
    public static final String INVITE_USER_BAR_SHOW_TIME = "invite_user_bar_show_time";
    public static final String LOGIN_COUNT = "logincount";
    public static final String LOG_NOB_Add_Forums = "NOB_Add_Forums";
    public static final String LOG_NOB_Email_Signup = "NOB_Email_Signup";
    public static final String LOG_NOB_Facebook_SSO = "NOB_Facebook_SSO";
    public static final String LOG_NOB_Google_SSO = "NOB_Google_SSO";
    public static final String LOG_NOB_LetsStarted = "NOB_LetsStarted";
    public static final String LOG_NOB_Login = "NOB_Login";
    public static final String LOG_NOB_MainPage = "NOB_MainPage";
    public static final String LOG_NOB_Search_Categories = "NOB_Search_Categories";
    public static final String LOG_NOB_Search_Results = "NOB_Search_Results";
    public static final String LOG_NOB_Welcome = "NOB_Welcome";
    public static final String LOG_USER_ADD_FORUM = "log_add_first_forum";
    public static final String LOG_USER_FIRST_SESSION = "log__first_session";
    public static final String LOG_USER_REGISTER_TAPATALKID = "log_new_tapatalkid";
    public static final String LOG_USER_SHARE_PHOTO = "log_share_first_photo";
    public static final String POST_COUNTDOWN_ENTER_TIME = "post_countdown_enter_time";
    public static final String POST_COUNTDOWN_FIRST_REPLY = "post_countdown_first_reply";
    public static final String POST_COUNTDOWN_NUMBER = "post_countdown_number";
    public static final String POST_COUNTDOWN_QUITE_TIME = "post_countdown_quite_time";
    public static final String PROFILE_AU_ID = "tapatalk_au_id";
    public static final String PROFILE_AVATAR = "tapatalk_avatar";
    public static final String PROFILE_AVATAR_URL = "tapatalk_avatar_url";
    public static final String PROFILE_BIRTHDAY = "tapatalk_birthday";
    public static final String PROFILE_COVER = "tapatalk_cover";
    public static final String PROFILE_DESCRIPTION = "tapatalk_description";
    public static final String PROFILE_FIRST_NAME = "tapatalk_first_name";
    public static final String PROFILE_GENDER = "tapatalk_gender";
    public static final String PROFILE_LANGUAGE = "tapatalk_language";
    public static final String PROFILE_LAST_ACTIVITY = "tapatalk_last_activity";
    public static final String PROFILE_LAST_NAME = "tapatalk_last_name";
    public static final String PROFILE_LINK = "tapatalk_link";
    public static final String PROFILE_LOCALE = "tapatalk_locale";
    public static final String PROFILE_LOCATION = "tapatalk_location";
    public static final String PROFILE_NAME = "tapatalk_name";
    public static final String PROFILE_REGISTER = "tapatalk_register";
    public static final String PROFILE_SIGNATURE = "tapatalk_signature";
    public static final String PROFILE_STATUS_MESSAGE = "tapatalk_status_message";
    public static final String PROFILE_STATUS_TWITTER_USER = "tapatalk_status_twitter_user";
    public static final String PRO_LINCENSE_CHECK = "pro_lincense_check";
    public static final String PRO_UPDATED_ACCOUNT_TIME = "pro_update_order_time";
    public static final String PRO_UPDATED_ORDER_TIME = "pro_update_order_time";
    public static final String RATEUS_OPENAPPCOUNT = "start_count_for_rate";
    public static final String RATEUS_SHOULD_RATE = "should_rate";
    public static final String REMOVE_CARD = "removecard";
    public static final String SEARCH_AD_COUNT = "search_ad_count";
    public static final String SHOW_CARD = "showcard";
    public static final String SHOW_HINTS_ISSHOW_HINITVIEW = "show_hints_isshow_hintview";
    public static final String SHOW_HINTS_OBWELCOME_COUNT = "show_hints_obwelcome_count";
    public static final String TAG_FORUM_LOGINFORUM = "loginforum";
    public static final String TAG_OLD_USER = "old_tapatalkid";
    public static final String TAG_UPDATE_NEW_LOGIN = "update_new_login";
    public static final int defaultInt = -1;
    public static final String defaultString = "";

    public static void clearAccountTime(Context paramContext) {
        get(paramContext).edit().putLong("pro_update_order_time", 0L).commit();
    }

    public static void closeHint(Activity paramActivity) {
        if (paramActivity == null) {
            return;
        }
        paramActivity = get(paramActivity).edit();
        paramActivity.putBoolean("show_hints_isshow_hintview", false);
        paramActivity.commit();
    }

    public static SharedPreferences get(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext);
    }

    public static void isShowHint(Activity paramActivity, TextView paramTextView) {
        if ((paramActivity == null) || (paramTextView == null)) {
            return;
        }
        SharedPreferences localSharedPreferences = get(paramActivity);
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        if (localSharedPreferences.getBoolean("show_hints_isshow_hintview", false)) {
            paramTextView.setVisibility(0);
        }
        try {
            paramTextView.setTypeface(Typeface.createFromAsset(paramActivity.getAssets(), "font/Bariol_Bold.ttf"));
            for (; ; ) {
                localEditor.commit();
                return;
                paramTextView.setVisibility(8);
            }
        } catch (Exception paramActivity) {
            for (; ; ) {
            }
        }
    }

    public static boolean needUpdateAccount(Context paramContext) {
        paramContext = get(paramContext);
        return System.currentTimeMillis() - paramContext.getLong("pro_update_order_time", 0L) > 86400000L;
    }

    public static boolean needUpdateOrder(Context paramContext) {
        paramContext = get(paramContext);
        return System.currentTimeMillis() - paramContext.getLong("pro_update_order_time", 0L) > 604800000L;
    }

    public static void updateAccountTime(Context paramContext) {
        paramContext = get(paramContext);
        long l = System.currentTimeMillis();
        paramContext.edit().putLong("pro_update_order_time", l).commit();
    }

    public static void updateOrderTime(Context paramContext) {
        paramContext = get(paramContext);
        long l = System.currentTimeMillis();
        paramContext.edit().putLong("pro_update_order_time", l).commit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/Prefs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */