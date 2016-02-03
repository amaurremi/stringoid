package com.quoord.tapatalkpro;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.quoord.tapatalkpro.util.CustomTracker;

import java.util.ArrayList;

public class TapatalkApp
        extends Application {
    public static String APP_KEY;
    private static final String PROPERTY_ID = "UA-36039391-5";
    public static final String SENDER_ID = "608452217441";
    public static int adDisplay = 0;
    public static ArrayList<String> adGroupId;
    public static String database_name;
    public static String database_version;
    public static String google_api_key_for_free = "AIzaSyD2WDTF_pQAyLPL2H-s69mhefJQlw9n_1s";
    public static String google_api_key_for_pro = "AIzaSyBi3DNJOJSx5VfnhSCYbOdeU10wFrhdpzw";
    public static String ics_default_color;
    public static boolean needDFP = false;
    public static int powerBy = 1;
    public static final String quantcastID = "";
    public static String rate_url;
    public static String rebranding_aid;
    public static String rebranding_id;
    public static String rebranding_name;
    public static String rebranding_url;
    public static int signatureType;
    public static String singatureString;
    public static String vig_link_key;
    Tracker mTracker;

    static {
        // todo keys stored in fields
        database_name = "tapatalknew.db";
        database_version = "1";
        vig_link_key = "";
        rate_url = "market://details?id=";
        rebranding_name = "rebranding";
        rebranding_url = "https://support.tapatalk.com";
        rebranding_aid = "210";
        rebranding_id = "231";
        needDFP = true;
        APP_KEY = "app_key=hdp3jtrujmsUis3r&app_id=4";
        ics_default_color = "";
        singatureString = "";
        signatureType = 1;
        adGroupId = new ArrayList();
    }

    public Tracker getTracker() {
        try {
            if (this.mTracker == null) {
                this.mTracker = GoogleAnalytics.getInstance(this).newTracker("UA-36039391-5");
            }
            Tracker localTracker = this.mTracker;
            return localTracker;
        } finally {
        }
    }

    public void onCreate() {
        super.onCreate();
        CustomTracker.setComScoreContext(getApplicationContext());
        if (getResources().getBoolean(2131558404)) {
            rate_url = "http://www.amazon.com/gp/mas/dl/android?p=com.quoord.tapatalkpro.activity";
            return;
        }
        rate_url = "market://details?id=" + getApplicationContext().getPackageName();
    }

    public void onTerminate() {
    }

    public static enum TrackerName {
        APP_TRACKER, GLOBAL_TRACKER, ECOMMERCE_TRACKER;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/TapatalkApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */