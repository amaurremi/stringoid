package com.magmamobile.game.engine;

public class AppParameters
{
  public static final int FIX_GS3BLACKSCREEN_AUTO = 0;
  public static final int FIX_GS3BLACKSCREEN_OFF = 2;
  public static final int FIX_GS3BLACKSCREEN_ON = 1;
  public String ADMOB_BACKUP_ID;
  public String ADMOB_BACKUP_ID2;
  public String ADMOB_MEDIATION_ID;
  public String ADMOB_MEDIATION_ID2;
  public long ADMOB_MEDIATION_REFRESH_TIME;
  public int ADS_ALIGNEMENT = 12;
  public String ADWHIRL_DEFAULT_ADMOBKEY;
  public String ADWHIRL_DEFAULT_NID;
  public int ADWHIRL_DIP_HEIGHT = 52;
  public boolean ADWHIRL_ENABLED;
  public String ADWHIRL_ID;
  public String ADWHIRL_ID2;
  public boolean ADWHIRL_TESTING_MODE;
  public boolean ADWHIRL_VERBOSE_LOG;
  public String ANALYTICS_CHANNEL;
  public boolean ANALYTICS_ENABLED;
  public boolean ANALYTICS_LOGS_ENABLED;
  public int APP_ORIENTATION = -1;
  public boolean BACKTRACK_ENABLED = false;
  public int CHANGELOG_ABOUT;
  public int CHANGELOG_CLOSE;
  public int CHANGELOG_ICON32;
  public int CHANGELOG_LOG;
  public int CHANGELOG_NAME;
  public int CHANGELOG_TITLE;
  public boolean DEBUG_MESSAGE_ENABLED = false;
  public boolean DEBUG_MMQI_BITMAP;
  public String DEBUG_MMQI_HOST;
  public int DEBUG_MMQI_PORT;
  public boolean DEFAULT_ALIASING_ENABLED = true;
  public int DEFAULT_BUTTON_SOUND = 0;
  public int DEFAULT_BUTTON_TEXT_COLOR = -1;
  public float DEFAULT_BUTTON_TEXT_SIZE = 20.0F;
  public int DEFAULT_ENGINE_MODE = 0;
  public GameRate DEFAULT_GAMERATE = GameRate.normal;
  public boolean DEFAULT_HAPTIC_ENABLED;
  public boolean DEFAULT_KEEPSCREENON_ENABLED = true;
  public String DEFAULT_LABEL_TYPEFACE = null;
  public boolean DEFAULT_MUSIC_ENABLED = true;
  public int DEFAULT_RENDERER = 0;
  public GameRenderMode DEFAULT_RENDERMODE = GameRenderMode.Realtime;
  public boolean DEFAULT_SOUND_ENABLED = true;
  public boolean DEFAULT_STRETCH_ENABLED = true;
  public boolean DEFAULT_VIBRATE_ENABLED = true;
  public int DEFAULT_VOLUME = 15;
  public int FIX_GS3BLACKSCREEN = 0;
  public String GGADS_APP_NAME;
  public String GGADS_CHANNEL_ID;
  public String GGADS_COMPANY_NAME;
  public String GGADS_EXPAND_DIRECTION;
  public String GGADS_KEYWORDS;
  public boolean GGADS_TESTING;
  public String GOO_GL_LINK;
  public int KREACTIVE_APP_ID;
  public String LINK_MARKET_CUSTOM;
  public String MMUSIA_REF_COMPLEMENT;
  public boolean SCORELOOP_ENABLED;
  public String SCORELOOP_GAME_ID;
  public String SCORELOOP_GAME_SECRET;
  public int SOUND_MAX = 10;
  public int SOUND_QUALITY = 100;
  public boolean USE_ACTION_COUNTER = true;
  public boolean USE_DPAD_FOCUS = false;
  public boolean USE_ERROR_REPORTER = false;
  public boolean USE_RENDER_COUNTER = true;
  public boolean USE_SENSORS = false;
  
  public int getBufferHeight()
  {
    if (Game.getOrientation() == 0) {
      return 480;
    }
    return 320;
  }
  
  public int getBufferWidth()
  {
    if (Game.getOrientation() == 0) {
      return 320;
    }
    return 480;
  }
  
  public int getColorMode()
  {
    return 0;
  }
  
  public String getPack()
  {
    return "";
  }
  
  public static class AdWhirl
  {
    public static String makeJSON(String paramString1, String paramString2)
    {
      return "{\"extra\":{\"location_on\":1,\"background_color_rgb\":{\"red\":255,\"green\":255,\"blue\":255,\"alpha\":1},\"text_color_rgb\":{\"red\":0,\"green\":0,\"blue\":0,\"alpha\":1},\"cycle_time\":60,\"transition\":0},\"rations\":[{\"nid\":\"" + paramString1 + "\",\"type\":1,\"nname\":\"admob\",\"weight\":100,\"priority\":1,\"key\":\"" + paramString2 + "\"}]}";
    }
  }
  
  public static class Renderer
  {
    public static final int HARDWARE = 0;
    public static final int SOFTWARE = 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AppParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */