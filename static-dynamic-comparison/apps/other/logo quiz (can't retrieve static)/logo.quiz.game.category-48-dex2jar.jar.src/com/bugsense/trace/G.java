package com.bugsense.trace;

import java.util.ArrayList;

public class G
{
  protected static String ANALYTICS_URL;
  protected static String ANDROID_VERSION;
  protected static String API_KEY;
  protected static String APPS_RUNNING = "unknown";
  protected static String APP_PACKAGE;
  protected static String APP_VERSION;
  protected static String APP_VERSIONCODE;
  protected static final String BUGSENSE_VERSION = "3.6.1";
  protected static String FILES_PATH = null;
  protected static boolean HAS_ROOT = false;
  protected static int IS_GPS_ON = 0;
  protected static int IS_MOBILENET_ON = 0;
  protected static int IS_WIFI_ON = 0;
  protected static String LOCALE;
  protected static String LOG_FILTER;
  protected static int LOG_LINES = 0;
  protected static final int MAX_BREADCRUMBS = 16;
  protected static String PHONE_BRAND;
  protected static String PHONE_MODEL;
  protected static String[] SCREEN_PROPS;
  protected static boolean SEND_LOG;
  protected static String TAG;
  protected static long TIMESTAMP;
  protected static String UID;
  protected static String URL;
  protected static ArrayList<String> breadcrumbs;
  protected static boolean proxyEnabled;
  protected static boolean sendOnlyWiFi;
  protected static String userIdentifier;
  
  static
  {
    APP_VERSION = "unknown";
    APP_VERSIONCODE = "unknown";
    APP_PACKAGE = "unknown";
    URL = "https://bugsense.appspot.com/api/errors";
    ANALYTICS_URL = "https://ticks2.bugsense.com/api/ticks/";
    TAG = "BugSenseHandler";
    ANDROID_VERSION = "unknown";
    PHONE_MODEL = "unknown";
    PHONE_BRAND = "unknown";
    API_KEY = "unknown";
    HAS_ROOT = false;
    LOCALE = "unknown";
    UID = "";
    breadcrumbs = new ArrayList(16);
    SEND_LOG = false;
    LOG_FILTER = "";
    LOG_LINES = 5000;
    TIMESTAMP = 0L;
    proxyEnabled = false;
    IS_WIFI_ON = 2;
    IS_MOBILENET_ON = 2;
    IS_GPS_ON = 2;
    SCREEN_PROPS = new String[] { "unknown", "unknown", "unknown", "unknown", "unknown", "unknown" };
    sendOnlyWiFi = false;
    userIdentifier = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bugsense/trace/G.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */