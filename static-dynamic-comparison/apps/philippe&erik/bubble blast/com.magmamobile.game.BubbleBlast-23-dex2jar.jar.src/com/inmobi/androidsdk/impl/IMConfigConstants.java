package com.inmobi.androidsdk.impl;

public final class IMConfigConstants
{
  protected static final String CELL = "a";
  protected static final int CELL_CDMA = 2;
  protected static final int CELL_GSM = 1;
  protected static final String CELL_ID = "d-n-cell";
  protected static final String CELL_SERVINGID = "a2";
  protected static final String CELL_TYPE = "a1";
  protected static final Long MIN_NICE_RETRY_INERVAL = Long.valueOf(3L);
  public static final String MSG_AD_ACTIVE = "Interstitial ad is in ACTIVE state. Try again after sometime.";
  public static final String MSG_AD_BUSY = "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.";
  public static final String MSG_AD_CLICK = "Ad click in progress. Your request cannot be processed at this time. Try again later.";
  public static final String MSG_AD_DOWNLOAD = "Ad download in progress. Your request cannot be processed at this time. Try again later.";
  public static final String MSG_AD_FOCUS = "Activity is not in the foreground. New ad will not be loaded.";
  public static final String MSG_AD_INVENTORY = "Ad request successful, but no ad was returned due to lack of ad inventory.";
  public static final String MSG_AD_SIZE = "Invalid Ad Size. Please provide a valid adSize.";
  public static final String MSG_AD_STATE = "Current Ad State is neither default nor loading. New ad will not be shown.";
  public static final String MSG_CALL_BACK = "IMAdView not sending callback because the view is not added to any window.";
  public static final String MSG_EMPTY_KEY_VALUE = "Key or Value cannot be empty";
  public static final String MSG_INTERSTITIAL_AD_DISPLAYED = "Ad cannot be loaded.Interstitial Ad is displayed.";
  public static final String MSG_INVALID_AD_CONFIG = "Interstitial ad is in ACTIVE state. Try again after sometime.";
  public static final String MSG_INVALID_AD_SIZE = "Invalid Ad Size. Please provide a valid Ad Size. If Ad Size is declared in the layout XML, please provide a valid 'adSize' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, adSize=\"yourAdSize\"";
  public static final String MSG_INVALID_APP_ID = "Your App Id may be invalid or inactive. Please verify the app ID";
  public static final String MSG_INVALID_APP_ID_PARAM = "APP ID cannot be empty.Please provide a valid APP ID. If APP ID is declared in the layout XML, please provide a valid 'appId' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, appId=\"yourAppId\"";
  public static final String MSG_INVALID_COLOR_FORMAT = "Invalid color format.Color should be of the format #rgb or #rrggbb ";
  public static final String MSG_MISSING_ACTIVITY_DECLARATION = "IMBrowserActivity not declared in the manifest. Please declare it in the app manifest";
  public static final String MSG_MISSING_CONFIG_CHANGES = "IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest";
  public static final String MSG_MISSING_CONFIG_KEYBOARD = "Missing Config keyboard from android:configChangesof IMBRowserActivity";
  public static final String MSG_MISSING_CONFIG_KEYBOARDHIDDEN = "Missing Config keyboardHidden from android:configChangesof IMBRowserActivity";
  public static final String MSG_MISSING_CONFIG_ORIENTATION = "Missing Config orientation from android:configChangesof IMBRowserActivity";
  public static final String MSG_MISSING_CONFIG_SCREENSIZE = "Missing Config screenSize from android:configChangesof IMBRowserActivity";
  public static final String MSG_MISSING_CONFIG_SMALLEST_SCREENSIZE = "Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity";
  public static final String MSG_MISSING_PERMISSION = "App does not have INTERNET permissions. Please provide INTERNET permissions";
  public static final String MSG_NIL_ACTIVITY = "Activity cannot be null";
  public static final String MSG_NIL_APP_ID = "APP ID cannot be null";
  public static final String MSG_NIL_COLOR = "Color cannot be null";
  public static final String MSG_NIL_KEY_VALUE = "Key or Value cannot be null";
  public static final String MSG_REFRESH = "Ad cannot be refreshed now, as the minimum refresh interval is";
  public static final String MSG_RELEASE_VERSION_MISMATCH = "SDK Bundle mismatch. InMobiAdNetwork version : 3.6.1, InMobiCommons version : 3.6.1.Please add InMobiAdNetwork and InMobiCommons SDK jars from the latest bundle";
  protected static final int MSG_UPLOAD_NICE_PARAM = 1;
  protected static final String NICE_RETRY_INTERVAL = "x-retry-count";
  protected static final String NICE_SERVER_URL = "x-inmobi-ph-url";
  protected static final String NICE_UPLOAD_DURATION = "x-inmobi-ph-lse-sec";
  protected static final String NICE_UPLOAD_INTERVAL = "x-inmobi-ph-intvl-sec";
  protected static final String PARAM_RSA_VERSION = "u-key-ver";
  protected static final String PARAM_UID_KEY = "u-id-key";
  protected static final String PARAM_UID_MAP = "u-id-map";
  public static final int REFRESH_AUTO = 1;
  public static final int REFRESH_DEFAULT = -1;
  public static final int REFRESH_MANUAL = 0;
  protected static final String REQUEST_NICE_PARAM = "x-inmobi-ph-enable";
  protected static final String SIM = "b";
  protected static final String SIM_ID = "d-n-sim";
  protected static final String SIM_OP = "b1";
  public static final String TAP_OFFSET = "u-tap-o";
  public static final String TAP_SIZE = "u-tap-size";
  protected static final String TIME = "d";
  protected static final String TIMESTAMP = "d-n-time";
  protected static final String TIME_UTC = "d1";
  protected static final String TIME_ZONE_OFFSET = "d2";
  protected static final String WIFI = "c";
  protected static final String WIFI_AP = "c1";
  protected static final String WIFI_BSSID = "c1b";
  protected static final String WIFI_ID = "d-n-wifi";
  protected static final String WIFI_LEVEL = "c1c";
  protected static final String WIFI_SSID = "c1a";
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/impl/IMConfigConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */