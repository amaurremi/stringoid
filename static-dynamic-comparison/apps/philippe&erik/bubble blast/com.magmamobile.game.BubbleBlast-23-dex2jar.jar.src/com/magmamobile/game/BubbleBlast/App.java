package com.magmamobile.game.BubbleBlast;

import com.magmamobile.game.BubbleBlast.engine.Enums.enumStageGame;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.BubbleBlast.utils.AppVars;
import com.magmamobile.game.engine.AdLayout;
import com.magmamobile.game.engine.AdLayoutAdsKit;
import com.magmamobile.game.engine.AdType;
import com.magmamobile.game.engine.AppParameters;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameApplication;
import com.magmamobile.game.engine.Sound;

public final class App
  extends GameApplication
{
  public static final int GAME_MODE_MENU = 1;
  public static Sound SoundBubble001;
  public static boolean SoundBubble001Playing;
  public static Sound SoundPop004;
  public static boolean SoundPop004Playing;
  public static StageGame currentStageGame;
  public static Enums.enumStageGame currentStageType;
  public static boolean running = false;
  
  public AdLayout onCreateAdBanner()
  {
    modCommon.Log_d("App onCreateAdBanner");
    return new AdLayoutAdsKit(AdType.BANNER, Game.getParameters().ADMOB_MEDIATION_ID, Game.getParameters().ADWHIRL_ID);
  }
  
  public AdLayout onCreateAdSquare()
  {
    modCommon.Log_d("App onCreateAdSquare");
    AdLayoutAdsKit localAdLayoutAdsKit = new AdLayoutAdsKit(AdType.SQUARE, Game.getParameters().ADMOB_MEDIATION_ID2, Game.getParameters().ADWHIRL_ID2);
    int i = (int)((Game.getDisplayWidth() - Game.dpi(300.0F)) / 2.0F);
    int j = (int)((int)((Game.getDisplayHeight() - Game.dpi(250.0F)) / 2.0F) - Game.dpi(20.0F));
    localAdLayoutAdsKit.setMarginLeft(i);
    localAdLayoutAdsKit.setMarginTop(j);
    return localAdLayoutAdsKit;
  }
  
  public AppParameters onCreateParameters()
  {
    AppParameters local1 = new AppParameters()
    {
      public int getColorMode()
      {
        if (modCommon.sdkVersion() > 4) {
          return 2;
        }
        return 1;
      }
    };
    local1.ANALYTICS_ENABLED = true;
    local1.ANALYTICS_CHANNEL = AppVars.GGAnalytics;
    local1.SCORELOOP_ENABLED = true;
    local1.SCORELOOP_GAME_ID = "a1d25c8c-7127-4e04-beaa-456d46fb290e";
    local1.SCORELOOP_GAME_SECRET = "14fMrZY6B3p+kMPNyMR0ftIHwequOf8lPTAU9nq1JsI135Nkd85JJQ==";
    local1.MMUSIA_REF_COMPLEMENT = "BubbleBlast";
    local1.LINK_MARKET_CUSTOM = "-BubbleBlast";
    local1.DEFAULT_HAPTIC_ENABLED = false;
    local1.ADMOB_MEDIATION_ID = "691d335014f64fbe";
    local1.ADMOB_MEDIATION_ID2 = "5efca3d79654418c";
    local1.ADMOB_MEDIATION_REFRESH_TIME = 45000L;
    return local1;
  }
  
  public void onEngineInitialize()
  {
    super.onEngineInitialize();
    modCommon.Log_d("onInitialize App");
    modCommon.Log_d("running :: " + running);
    if ((running) && (currentStageGame != null))
    {
      addStage(currentStageGame);
      Game.setStage(1);
      return;
    }
    modCommon.Log_d("App clearStages()");
    clearStages();
    currentStageGame = new StageGame();
    addStage(currentStageGame);
    currentStageType = Enums.enumStageGame.Game;
    Game.setStage(1);
    Game.hideBanner();
    SoundPop004 = Game.getSound(81);
    SoundBubble001 = Game.getSound(80);
    Game.setBmpTextBitmap(Game.getBitmap(49));
    Game.setBmpTextSize(16, 16, 16, 16);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/App.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */