package mobi.beyondpod.ui.views.notifications;

import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class NotificationPreferences
{
  public static final String NO = "0";
  public static final int TIP_ADD_REMOVE_PLAYLIST = 14;
  public static final int TIP_CATEGORIES = 2;
  public static final int TIP_CONSIDER_USING_TABLET_VERSION = 12;
  public static final int TIP_HOW_TO_CHANGE_CATEGORY = 19;
  public static final int TIP_HOW_TO_USE_DRAG_DROP_PLAYLIST = 15;
  public static final int TIP_HOW_TO_USE_FEED_CONTENT = 18;
  public static final int TIP_LONG_PRESS_SWITCH_TO_PLAYER = 9;
  public static final int TIP_MARK_READ = 8;
  public static final int TIP_NOTIFY_SLEEP_SETTING = 5;
  public static final int TIP_STARTUP_SCREEN = 6;
  public static final int TIP_STREAMING_PLAY_POSITION_NOT_SAVED = 3;
  public static final int TIP_TAP_TO_ADD_REMOVE_PLAYLIST = 16;
  public static final int TIP_VOLUME_BUTTONS = 7;
  public static final int WARN_INSTALLED_ON_SD_CARD = 10;
  public static final int WARN_MARK_ALL_READ = 11;
  public static final int WARN_MARK_SCROLLED_READ = 17;
  public static final int WARN_MOVIE_PLAY = 4;
  public static final int WARN_PLAY_EXTERNL_PLAYER = 0;
  public static final int WARN_REPLACE_PLAYLIST = 21;
  public static final int WARN_START_UPDATE_DOWNLOAD = 13;
  public static final int WARN_STREAM_EXTERNL_PLAYER = 1;
  public static final int WARN_SWITCH_TO_FEEDLY = 20;
  public static final String YES = "1";
  String[] _Prefs = new String[22];
  
  public NotificationPreferences()
  {
    ResetDefaultPrefs();
    Object localObject = Configuration.UserNotificationPreferences();
    int i;
    if (!StringUtils.IsNullOrEmpty((String)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      i = 0;
    }
    for (;;)
    {
      if (i == localObject.length) {
        return;
      }
      if (i < this._Prefs.length) {
        this._Prefs[i] = localObject[i];
      }
      i += 1;
    }
  }
  
  private void Save()
  {
    String str1 = "";
    String[] arrayOfString = this._Prefs;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        Configuration.setUserNotificationPreferences(str1);
        return;
      }
      String str2 = arrayOfString[i];
      str1 = str1 + str2 + "|";
      i += 1;
    }
  }
  
  String GetPreference(int paramInt, String paramString)
  {
    if (paramInt < this._Prefs.length) {
      paramString = this._Prefs[paramInt];
    }
    return paramString;
  }
  
  public void ResetDefaultPrefs()
  {
    this._Prefs[0] = "1";
    this._Prefs[1] = "1";
    this._Prefs[2] = "1";
    this._Prefs[3] = "1";
    this._Prefs[4] = "1";
    this._Prefs[5] = "1";
    this._Prefs[6] = "1";
    this._Prefs[7] = "1";
    this._Prefs[8] = "1";
    this._Prefs[9] = "1";
    this._Prefs[10] = "1";
    this._Prefs[11] = "1";
    this._Prefs[12] = "1";
    this._Prefs[13] = "1";
    this._Prefs[14] = "1";
    this._Prefs[15] = "1";
    this._Prefs[16] = "1";
    this._Prefs[17] = "1";
    this._Prefs[18] = "1";
    this._Prefs[19] = "1";
    this._Prefs[20] = "1";
    this._Prefs[21] = "1";
  }
  
  void SetPreference(int paramInt, String paramString)
  {
    if (paramInt < this._Prefs.length)
    {
      this._Prefs[paramInt] = paramString;
      Save();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/notifications/NotificationPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */