package com.quoord.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Prefs;

public class UserBehavior {
    public static void logFirstSession(Context paramContext) {
        paramContext = Prefs.get(paramContext);
        if (!paramContext.getBoolean("log__first_session", false)) {
            CustomTracker.flurryTrackEvent("new_session_start");
            paramContext.edit().putBoolean("log__first_session", true).commit();
        }
    }

    public static void logNOBAddForums(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_Add_Forums", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_Add_Forums");
            localSharedPreferences.edit().putBoolean("NOB_Add_Forums", true).commit();
        }
    }

    public static void logNOBEmailSingUp(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_Email_Signup", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_Email_Signup");
            localSharedPreferences.edit().putBoolean("NOB_Email_Signup", true).commit();
        }
    }

    public static void logNOBFacebookSSO(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_Facebook_SSO", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_Facebook_SSO");
            localSharedPreferences.edit().putBoolean("NOB_Facebook_SSO", true).commit();
        }
    }

    public static void logNOBGoogleSSO(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_Google_SSO", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_Google_SSO");
            localSharedPreferences.edit().putBoolean("NOB_Google_SSO", true).commit();
        }
    }

    public static void logNOBLetsStarted(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_LetsStarted", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_LetsStarted");
            localSharedPreferences.edit().putBoolean("NOB_LetsStarted", true).commit();
        }
    }

    public static void logNOBLogin(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_Login", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_Login");
            localSharedPreferences.edit().putBoolean("NOB_Login", true).commit();
        }
    }

    public static void logNOBMainPage(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_MainPage", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_MainPage");
            localSharedPreferences.edit().putBoolean("NOB_MainPage", true).commit();
        }
    }

    public static void logNOBSearchCategories(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_Search_Categories", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_Search_Categories");
            localSharedPreferences.edit().putBoolean("NOB_Search_Categories", true).commit();
        }
    }

    public static void logNOBSearchReslut(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_Search_Results", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_Search_Results");
            localSharedPreferences.edit().putBoolean("NOB_Search_Results", true).commit();
        }
    }

    public static void logNOBWelcome(Context paramContext) {
        SharedPreferences localSharedPreferences = Prefs.get(paramContext);
        if (!localSharedPreferences.getBoolean("NOB_Welcome", false)) {
            CustomTracker.flurryTrackEvent(paramContext, "NOB_Welcome");
            localSharedPreferences.edit().putBoolean("NOB_Welcome", true).commit();
        }
    }

    public static void logUserAddForum(Context paramContext) {
        paramContext = Prefs.get(paramContext);
        boolean bool1 = paramContext.getBoolean("old_tapatalkid", false);
        boolean bool2 = paramContext.getBoolean("log_add_first_forum", false);
        if ((!bool1) && (!bool2)) {
            CustomTracker.flurryTrackEvent("Forum_First_Account");
            paramContext.edit().putBoolean("log_add_first_forum", true).commit();
        }
    }

    public static void logUserRegistTid(Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {
        paramContext = Prefs.get(paramContext);
        if ((paramBoolean1) && (!paramBoolean2) && (!paramContext.getBoolean("log_new_tapatalkid", false))) {
            CustomTracker.flurryTrackEvent("Tapatalk_ID_New_Register");
            paramContext.edit().putBoolean("log_new_tapatalkid", true).commit();
            return;
        }
        paramContext.edit().putBoolean("old_tapatalkid", true).commit();
    }

    public static void logUserShareForum(Context paramContext) {
        paramContext = Prefs.get(paramContext);
        boolean bool1 = paramContext.getBoolean("old_tapatalkid", false);
        boolean bool2 = paramContext.getBoolean("log_share_first_photo", false);
        if ((!bool1) && (!bool2)) {
            CustomTracker.flurryTrackEvent("Photo_First_Share");
            paramContext.edit().putBoolean("log_share_first_photo", true).commit();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/UserBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */