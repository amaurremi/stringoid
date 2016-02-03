package com.magmamobile.game.BubbleBlast.stages;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Paint;
import com.magmamobile.game.BubbleBlast.App;
import com.magmamobile.game.BubbleBlast.activities.GameFinishedActivity;
import com.magmamobile.game.BubbleBlast.activities.HintActivity;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumBackground;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumGameDifficulty;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumGameMode;
import com.magmamobile.game.BubbleBlast.engine.items.Bubble;
import com.magmamobile.game.BubbleBlast.engine.items.BubbleBackground;
import com.magmamobile.game.BubbleBlast.engine.items.BubbleMini;
import com.magmamobile.game.BubbleBlast.engine.items.layouts.CongratsPuzzleEndLayout;
import com.magmamobile.game.BubbleBlast.engine.items.layouts.GameOverArcadeLayout;
import com.magmamobile.game.BubbleBlast.engine.items.layouts.GameOverPuzzleLayout;
import com.magmamobile.game.BubbleBlast.engine.items.layouts.ScoreArcadeLayout;
import com.magmamobile.game.BubbleBlast.engine.items.layouts.ScorePuzzleLayout;
import com.magmamobile.game.BubbleBlast.engine.levels.LevelArcade;
import com.magmamobile.game.BubbleBlast.engine.levels.LevelPuzzle;
import com.magmamobile.game.BubbleBlast.engine.texts.TextImgGameOver;
import com.magmamobile.game.BubbleBlast.engine.texts.TextImgPaused;
import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.modPreferences;
import com.magmamobile.game.BubbleBlast.utils.GoogleAnalytics;
import com.magmamobile.game.engine.Button;
import com.magmamobile.game.engine.FixedBackground;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameActivity;
import com.magmamobile.game.engine.GameArray;
import com.magmamobile.game.engine.GameStage;
import com.magmamobile.game.engine.Keyboard;

public class StageGame
  extends GameStage
{
  public static int BackGroundId;
  public static int ComboBonus;
  public static int ComboCount;
  public static LevelArcade CurrentLevelArcade;
  public static int CurrentLevelArcadeIndex;
  public static LevelPuzzle CurrentLevelPuzzle;
  public static int CurrentLevelPuzzleIndex;
  public static Paint GameBasePaint;
  public static Button PauseButton;
  public static boolean PuzzleResume;
  public static int ScoreLevel;
  public static Paint ScorePaint;
  public static int ScoreTotal;
  public static GameArray<Bubble> bubbles;
  public static GameArray<BubbleBackground> bubblesBackground;
  public static GameArray<BubbleMini> bubblesMini;
  public static CongratsPuzzleEndLayout congratsPuzzleEndLayout;
  public static Enums.enumGameDifficulty gameDifficulty;
  public static Enums.enumGameMode gameMode;
  public static GameOverArcadeLayout gameOverArcadeLayout;
  public static GameOverPuzzleLayout gameOverPuzzleLayout;
  public static TextImgGameOver gameOverText;
  public static boolean isGameOver;
  private static boolean itemTouched;
  public static int itemTouchedCount;
  public static String langString = "en";
  public static int levelPackPuzzle;
  public static boolean paused;
  public static TextImgPaused pausedText;
  public static String puzzleSolution = "";
  public static boolean readyToStart;
  public static ScoreArcadeLayout scoreArcadeLayout;
  public static ScorePuzzleLayout scorePuzzleLayout;
  public static Enums.enumBackground selectedBackground = Enums.enumBackground.water;
  public static long startClock;
  public static boolean started;
  public static int touchLeftCount;
  public static int touchPossibleCount;
  public long beforeStartClock;
  public int secondsBeforeStart;
  public int secondsLeftBeforeStart;
  
  public static void ItemTouched()
  {
    ComboCount = 0;
    itemTouched = true;
    itemTouchedCount += 1;
    touchLeftCount -= 1;
  }
  
  public static void addScore(int paramInt)
  {
    ComboCount += 1;
    switch (gameMode)
    {
    }
    for (;;)
    {
      ScoreLevel += (ComboCount - 1) * paramInt / 10 + paramInt;
      return;
      if (ComboCount == 3) {
        touchLeftCount += 1;
      }
      if (ComboCount == 5) {
        touchLeftCount += 1;
      }
      if (ComboCount == 7) {
        touchLeftCount += 1;
      }
      if (ComboCount == 9) {
        touchLeftCount += 1;
      }
      if (ComboCount == 11) {
        touchLeftCount += 1;
      }
    }
  }
  
  public static void askHint()
  {
    ((StageGame)Game.getCurrentStage()).call(1);
  }
  
  public static boolean hasTouchItem()
  {
    return itemTouched;
  }
  
  public static void launchArcadeGameFinished()
  {
    Intent localIntent = new Intent(Game.getContext(), GameFinishedActivity.class);
    localIntent.putExtra("score", ScoreTotal + ScoreLevel);
    localIntent.putExtra("level", CurrentLevelArcadeIndex + 1);
    localIntent.putExtra("levelpack", 0);
    localIntent.putExtra("mode", gameMode.toString());
    modPreferences.prefVolumeLevel = Game.getVolume();
    modPreferences.savePreferences(Game.getContext());
    Game.getContext().startActivity(localIntent);
    isGameOver = true;
    Game.Quit();
    quit();
  }
  
  public static void launchNextLevel()
  {
    if (scorePuzzleLayout != null)
    {
      scorePuzzleLayout.enabled = false;
      scorePuzzleLayout = null;
      Game.hideBanner();
    }
    if (scoreArcadeLayout != null)
    {
      scoreArcadeLayout.enabled = false;
      scoreArcadeLayout = null;
      Game.hideBanner();
    }
    if (gameOverPuzzleLayout != null)
    {
      gameOverPuzzleLayout.enabled = false;
      gameOverPuzzleLayout = null;
      Game.hideBanner();
    }
    if (gameOverArcadeLayout != null)
    {
      gameOverArcadeLayout.enabled = false;
      gameOverArcadeLayout = null;
      Game.hideBanner();
    }
    ScoreLevel = 0;
    ComboCount = 0;
    itemTouchedCount = 0;
    readyToStart = true;
    switch (gameMode)
    {
    default: 
      return;
    case arcade: 
      CurrentLevelPuzzleIndex += 1;
      CurrentLevelPuzzle.nextLevel(CurrentLevelPuzzleIndex);
      CurrentLevelPuzzle.setupApp();
      try
      {
        GoogleAnalytics.trackAndDispatch("Puzzle/Pack" + levelPackPuzzle + "/Level/" + CurrentLevelPuzzleIndex);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return;
      }
    }
    CurrentLevelArcadeIndex += 1;
    CurrentLevelArcade.nextLevel();
    CurrentLevelArcade.setupApp();
    try
    {
      GoogleAnalytics.trackAndDispatch("Arcade/Level/" + CurrentLevelArcadeIndex);
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
  
  public static void launchPuzzleGameFinished()
  {
    Intent localIntent = new Intent(Game.getContext(), GameFinishedActivity.class);
    localIntent.putExtra("score", ScoreTotal);
    localIntent.putExtra("level", CurrentLevelPuzzleIndex + 1);
    localIntent.putExtra("mode", gameMode.toString());
    localIntent.putExtra("levelpack", levelPackPuzzle);
    modPreferences.prefVolumeLevel = Game.getVolume();
    modPreferences.savePreferences(Game.getContext());
    Game.getContext().startActivity(localIntent);
    isGameOver = true;
    Game.Quit();
    quit();
  }
  
  public static void onGamePause()
  {
    modCommon.Log_d("onGamePaused");
    if (pausedText == null) {
      pausedText = new TextImgPaused();
    }
    for (;;)
    {
      bubbles.onPause();
      if (gameOverText != null) {
        gameOverText.onPause();
      }
      return;
      pausedText.enabled = true;
    }
  }
  
  public static void onGameResume()
  {
    modCommon.Log_d("onGameResume");
    if (started)
    {
      if (pausedText != null) {
        pausedText.enabled = false;
      }
      bubbles.onResume();
      if (gameOverText != null) {
        gameOverText.onResume();
      }
    }
  }
  
  public static void quit()
  {
    bubbles.clear();
    if (gameOverText != null)
    {
      gameOverText.enabled = false;
      gameOverText = null;
    }
    if (pausedText != null)
    {
      pausedText.enabled = false;
      pausedText = null;
    }
    if (scorePuzzleLayout != null)
    {
      scorePuzzleLayout.enabled = false;
      scorePuzzleLayout = null;
    }
    if (scoreArcadeLayout != null)
    {
      scoreArcadeLayout.enabled = false;
      scoreArcadeLayout = null;
    }
    if (gameOverPuzzleLayout != null)
    {
      gameOverPuzzleLayout.enabled = false;
      gameOverPuzzleLayout = null;
    }
    if (gameOverArcadeLayout != null)
    {
      gameOverArcadeLayout.enabled = false;
      gameOverArcadeLayout = null;
    }
    if (congratsPuzzleEndLayout != null)
    {
      congratsPuzzleEndLayout.enabled = false;
      congratsPuzzleEndLayout = null;
    }
    App.running = false;
  }
  
  public static Enums.enumBackground randBackground()
  {
    switch ((int)(Math.random() * 4.0D))
    {
    default: 
      return Enums.enumBackground.water;
    case 0: 
      return Enums.enumBackground.brokenwindow;
    case 1: 
      return Enums.enumBackground.paper;
    case 2: 
      return Enums.enumBackground.water;
    }
    return Enums.enumBackground.waterwhite;
  }
  
  public static void setBackground()
  {
    switch (selectedBackground)
    {
    default: 
      return;
    case paper: 
      FixedBackground.onInitialize(3);
      return;
    case brokenwindow: 
      FixedBackground.onInitialize(2);
      return;
    case waterwhite: 
      FixedBackground.onInitialize(0);
      return;
    }
    FixedBackground.onInitialize(1);
  }
  
  public static void setGameDifficulty(Enums.enumGameDifficulty paramenumGameDifficulty)
  {
    if (paramenumGameDifficulty == null)
    {
      gameDifficulty = Enums.enumGameDifficulty.normal;
      return;
    }
    gameDifficulty = paramenumGameDifficulty;
  }
  
  public static void setGameMode(Enums.enumGameMode paramenumGameMode, int paramInt)
  {
    if (paramenumGameMode == null) {}
    for (gameMode = Enums.enumGameMode.puzzle;; gameMode = paramenumGameMode) {
      switch (paramenumGameMode)
      {
      default: 
        return;
      }
    }
    ScoreTotal = 0;
    CurrentLevelPuzzleIndex = 0;
    levelPackPuzzle = paramInt;
    return;
    CurrentLevelArcadeIndex = 0;
    ScoreTotal = 0;
  }
  
  public static void setPuzzleGameResume(int paramInt1, int paramInt2)
  {
    CurrentLevelPuzzleIndex = paramInt1;
    ScoreTotal = paramInt2;
    PuzzleResume = true;
  }
  
  /* Error */
  public void nextLevel()
  {
    // Byte code:
    //   0: getstatic 321	com/magmamobile/game/BubbleBlast/stages/StageGame:bubbles	Lcom/magmamobile/game/engine/GameArray;
    //   3: getfield 390	com/magmamobile/game/engine/GameArray:total	I
    //   6: ifle +4 -> 10
    //   9: return
    //   10: getstatic 232	com/magmamobile/game/BubbleBlast/stages/StageGame:scorePuzzleLayout	Lcom/magmamobile/game/BubbleBlast/engine/items/layouts/ScorePuzzleLayout;
    //   13: ifnonnull -4 -> 9
    //   16: getstatic 242	com/magmamobile/game/BubbleBlast/stages/StageGame:scoreArcadeLayout	Lcom/magmamobile/game/BubbleBlast/engine/items/layouts/ScoreArcadeLayout;
    //   19: ifnonnull -10 -> 9
    //   22: getstatic 346	com/magmamobile/game/BubbleBlast/stages/StageGame:congratsPuzzleEndLayout	Lcom/magmamobile/game/BubbleBlast/engine/items/layouts/CongratsPuzzleEndLayout;
    //   25: ifnonnull -16 -> 9
    //   28: getstatic 182	com/magmamobile/game/BubbleBlast/stages/StageGame:ScoreTotal	I
    //   31: getstatic 154	com/magmamobile/game/BubbleBlast/stages/StageGame:ScoreLevel	I
    //   34: iadd
    //   35: putstatic 182	com/magmamobile/game/BubbleBlast/stages/StageGame:ScoreTotal	I
    //   38: invokestatic 150	com/magmamobile/game/BubbleBlast/stages/StageGame:$SWITCH_TABLE$com$magmamobile$game$BubbleBlast$engine$Enums$enumGameMode	()[I
    //   41: getstatic 152	com/magmamobile/game/BubbleBlast/stages/StageGame:gameMode	Lcom/magmamobile/game/BubbleBlast/engine/Enums$enumGameMode;
    //   44: invokevirtual 119	com/magmamobile/game/BubbleBlast/engine/Enums$enumGameMode:ordinal	()I
    //   47: iaload
    //   48: tableswitch	default:+24->72, 1:+568->616, 2:+465->513
    //   72: invokestatic 150	com/magmamobile/game/BubbleBlast/stages/StageGame:$SWITCH_TABLE$com$magmamobile$game$BubbleBlast$engine$Enums$enumGameMode	()[I
    //   75: getstatic 152	com/magmamobile/game/BubbleBlast/stages/StageGame:gameMode	Lcom/magmamobile/game/BubbleBlast/engine/Enums$enumGameMode;
    //   78: invokevirtual 119	com/magmamobile/game/BubbleBlast/engine/Enums$enumGameMode:ordinal	()I
    //   81: iaload
    //   82: tableswitch	default:+22->104, 1:+23->105, 2:+755->837
    //   104: return
    //   105: getstatic 259	com/magmamobile/game/BubbleBlast/stages/StageGame:CurrentLevelPuzzleIndex	I
    //   108: iconst_1
    //   109: iadd
    //   110: getstatic 394	com/magmamobile/game/BubbleBlast/engine/levels/LevelPuzzle:lvlNfo	[Lcom/magmamobile/game/BubbleBlast/engine/levels/LevelInfo;
    //   113: arraylength
    //   114: if_icmplt +712 -> 826
    //   117: getstatic 346	com/magmamobile/game/BubbleBlast/stages/StageGame:congratsPuzzleEndLayout	Lcom/magmamobile/game/BubbleBlast/engine/items/layouts/CongratsPuzzleEndLayout;
    //   120: ifnonnull -111 -> 9
    //   123: ldc_w 396
    //   126: invokestatic 314	com/magmamobile/game/BubbleBlast/modCommon:Log_d	(Ljava/lang/String;)V
    //   129: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   132: iconst_1
    //   133: if_icmpne +13 -> 146
    //   136: iconst_1
    //   137: putstatic 399	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel002Unlocked	Z
    //   140: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   143: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   146: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   149: iconst_2
    //   150: if_icmpne +13 -> 163
    //   153: iconst_1
    //   154: putstatic 402	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel003Unlocked	Z
    //   157: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   160: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   163: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   166: iconst_3
    //   167: if_icmpne +13 -> 180
    //   170: iconst_1
    //   171: putstatic 405	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel004Unlocked	Z
    //   174: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   177: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   180: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   183: iconst_4
    //   184: if_icmpne +13 -> 197
    //   187: iconst_1
    //   188: putstatic 408	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel005Unlocked	Z
    //   191: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   194: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   197: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   200: iconst_5
    //   201: if_icmpne +13 -> 214
    //   204: iconst_1
    //   205: putstatic 411	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel006Unlocked	Z
    //   208: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   211: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   214: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   217: bipush 6
    //   219: if_icmpne +13 -> 232
    //   222: iconst_1
    //   223: putstatic 414	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel007Unlocked	Z
    //   226: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   229: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   232: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   235: bipush 7
    //   237: if_icmpne +13 -> 250
    //   240: iconst_1
    //   241: putstatic 417	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel008Unlocked	Z
    //   244: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   247: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   250: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   253: bipush 8
    //   255: if_icmpne +13 -> 268
    //   258: iconst_1
    //   259: putstatic 420	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel009Unlocked	Z
    //   262: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   265: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   268: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   271: bipush 9
    //   273: if_icmpne +13 -> 286
    //   276: iconst_1
    //   277: putstatic 423	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel010Unlocked	Z
    //   280: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   283: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   286: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   289: bipush 10
    //   291: if_icmpne +13 -> 304
    //   294: iconst_1
    //   295: putstatic 426	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel011Unlocked	Z
    //   298: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   301: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   304: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   307: bipush 11
    //   309: if_icmpne +13 -> 322
    //   312: iconst_1
    //   313: putstatic 429	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel012Unlocked	Z
    //   316: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   319: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   322: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   325: bipush 12
    //   327: if_icmpne +13 -> 340
    //   330: iconst_1
    //   331: putstatic 432	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel013Unlocked	Z
    //   334: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   337: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   340: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   343: bipush 13
    //   345: if_icmpne +13 -> 358
    //   348: iconst_1
    //   349: putstatic 435	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel014Unlocked	Z
    //   352: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   355: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   358: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   361: bipush 14
    //   363: if_icmpne +13 -> 376
    //   366: iconst_1
    //   367: putstatic 438	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel015Unlocked	Z
    //   370: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   373: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   376: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   379: bipush 15
    //   381: if_icmpne +13 -> 394
    //   384: iconst_1
    //   385: putstatic 441	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel016Unlocked	Z
    //   388: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   391: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   394: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   397: bipush 16
    //   399: if_icmpne +13 -> 412
    //   402: iconst_1
    //   403: putstatic 444	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel017Unlocked	Z
    //   406: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   409: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   412: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   415: bipush 17
    //   417: if_icmpne +13 -> 430
    //   420: iconst_1
    //   421: putstatic 447	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel018Unlocked	Z
    //   424: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   427: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   430: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   433: bipush 18
    //   435: if_icmpne +13 -> 448
    //   438: iconst_1
    //   439: putstatic 450	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel019Unlocked	Z
    //   442: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   445: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   448: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   451: bipush 19
    //   453: if_icmpne +13 -> 466
    //   456: iconst_1
    //   457: putstatic 453	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel020Unlocked	Z
    //   460: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   463: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   466: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   469: bipush 20
    //   471: if_icmpne +13 -> 484
    //   474: iconst_1
    //   475: putstatic 456	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel021Unlocked	Z
    //   478: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   481: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   484: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   487: bipush 21
    //   489: if_icmpne +13 -> 502
    //   492: iconst_1
    //   493: putstatic 459	com/magmamobile/game/BubbleBlast/modPreferences:prefPuzzleLevel022Unlocked	Z
    //   496: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   499: invokestatic 213	com/magmamobile/game/BubbleBlast/modPreferences:savePreferences	(Landroid/content/Context;)V
    //   502: new 348	com/magmamobile/game/BubbleBlast/engine/items/layouts/CongratsPuzzleEndLayout
    //   505: dup
    //   506: invokespecial 460	com/magmamobile/game/BubbleBlast/engine/items/layouts/CongratsPuzzleEndLayout:<init>	()V
    //   509: putstatic 346	com/magmamobile/game/BubbleBlast/stages/StageGame:congratsPuzzleEndLayout	Lcom/magmamobile/game/BubbleBlast/engine/items/layouts/CongratsPuzzleEndLayout;
    //   512: return
    //   513: getstatic 146	com/magmamobile/game/BubbleBlast/stages/StageGame:touchLeftCount	I
    //   516: iconst_2
    //   517: iadd
    //   518: putstatic 146	com/magmamobile/game/BubbleBlast/stages/StageGame:touchLeftCount	I
    //   521: getstatic 146	com/magmamobile/game/BubbleBlast/stages/StageGame:touchLeftCount	I
    //   524: bipush 10
    //   526: if_icmple +8 -> 534
    //   529: bipush 10
    //   531: putstatic 146	com/magmamobile/game/BubbleBlast/stages/StageGame:touchLeftCount	I
    //   534: new 271	java/lang/StringBuilder
    //   537: dup
    //   538: ldc_w 462
    //   541: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: getstatic 144	com/magmamobile/game/BubbleBlast/stages/StageGame:itemTouchedCount	I
    //   547: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: ldc_w 464
    //   553: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: getstatic 298	com/magmamobile/game/BubbleBlast/stages/StageGame:CurrentLevelArcade	Lcom/magmamobile/game/BubbleBlast/engine/levels/LevelArcade;
    //   559: invokevirtual 467	com/magmamobile/game/BubbleBlast/engine/levels/LevelArcade:getLastTableStr	()Ljava/lang/String;
    //   562: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 293	com/magmamobile/game/BubbleBlast/utils/GoogleAnalytics:trackAndDispatch	(Ljava/lang/String;)V
    //   571: new 271	java/lang/StringBuilder
    //   574: dup
    //   575: getstatic 144	com/magmamobile/game/BubbleBlast/stages/StageGame:itemTouchedCount	I
    //   578: invokestatic 473	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   581: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: ldc_w 464
    //   587: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: getstatic 298	com/magmamobile/game/BubbleBlast/stages/StageGame:CurrentLevelArcade	Lcom/magmamobile/game/BubbleBlast/engine/levels/LevelArcade;
    //   593: invokevirtual 467	com/magmamobile/game/BubbleBlast/engine/levels/LevelArcade:getLastTableStr	()Ljava/lang/String;
    //   596: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 314	com/magmamobile/game/BubbleBlast/modCommon:Log_d	(Ljava/lang/String;)V
    //   605: goto -533 -> 72
    //   608: astore_2
    //   609: aload_2
    //   610: invokevirtual 296	java/lang/Exception:printStackTrace	()V
    //   613: goto -42 -> 571
    //   616: getstatic 259	com/magmamobile/game/BubbleBlast/stages/StageGame:CurrentLevelPuzzleIndex	I
    //   619: iconst_1
    //   620: iadd
    //   621: bipush 20
    //   623: if_icmplt +7 -> 630
    //   626: iconst_1
    //   627: putstatic 476	com/magmamobile/game/BubbleBlast/modPreferences:prefArcadeUnlocked	Z
    //   630: invokestatic 173	com/magmamobile/game/engine/Game:getContext	()Lcom/magmamobile/game/engine/GameActivity;
    //   633: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   636: getstatic 259	com/magmamobile/game/BubbleBlast/stages/StageGame:CurrentLevelPuzzleIndex	I
    //   639: iconst_1
    //   640: iadd
    //   641: getstatic 182	com/magmamobile/game/BubbleBlast/stages/StageGame:ScoreTotal	I
    //   644: invokestatic 480	com/magmamobile/game/BubbleBlast/modPreferences:setLevelPuzzleInfos	(Landroid/content/Context;III)V
    //   647: getstatic 122	com/magmamobile/game/BubbleBlast/engine/Enums$enumGameMode:puzzle	Lcom/magmamobile/game/BubbleBlast/engine/Enums$enumGameMode;
    //   650: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   653: invokestatic 486	com/magmamobile/game/BubbleBlast/engine/ScoreloopUtils:getScoreloopMode	(Lcom/magmamobile/game/BubbleBlast/engine/Enums$enumGameMode;I)I
    //   656: istore_1
    //   657: getstatic 259	com/magmamobile/game/BubbleBlast/stages/StageGame:CurrentLevelPuzzleIndex	I
    //   660: iconst_1
    //   661: iadd
    //   662: getstatic 182	com/magmamobile/game/BubbleBlast/stages/StageGame:ScoreTotal	I
    //   665: i2l
    //   666: iload_1
    //   667: invokestatic 492	com/magmamobile/game/BubbleBlast/utils/ScoreloopManager:submitScore	(IJI)V
    //   670: new 271	java/lang/StringBuilder
    //   673: dup
    //   674: ldc_w 494
    //   677: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   680: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   683: invokestatic 497	com/magmamobile/game/BubbleBlast/modCommon:int2String000	(I)Ljava/lang/String;
    //   686: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: ldc_w 499
    //   692: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: getstatic 259	com/magmamobile/game/BubbleBlast/stages/StageGame:CurrentLevelPuzzleIndex	I
    //   698: iconst_1
    //   699: iadd
    //   700: invokestatic 497	com/magmamobile/game/BubbleBlast/modCommon:int2String000	(I)Ljava/lang/String;
    //   703: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: ldc_w 499
    //   709: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: getstatic 144	com/magmamobile/game/BubbleBlast/stages/StageGame:itemTouchedCount	I
    //   715: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   718: ldc_w 499
    //   721: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: getstatic 134	com/magmamobile/game/BubbleBlast/stages/StageGame:puzzleSolution	Ljava/lang/String;
    //   727: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 314	com/magmamobile/game/BubbleBlast/modCommon:Log_d	(Ljava/lang/String;)V
    //   736: new 271	java/lang/StringBuilder
    //   739: dup
    //   740: ldc_w 494
    //   743: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   746: getstatic 278	com/magmamobile/game/BubbleBlast/stages/StageGame:levelPackPuzzle	I
    //   749: invokestatic 497	com/magmamobile/game/BubbleBlast/modCommon:int2String000	(I)Ljava/lang/String;
    //   752: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: ldc_w 499
    //   758: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: getstatic 259	com/magmamobile/game/BubbleBlast/stages/StageGame:CurrentLevelPuzzleIndex	I
    //   764: iconst_1
    //   765: iadd
    //   766: invokestatic 497	com/magmamobile/game/BubbleBlast/modCommon:int2String000	(I)Ljava/lang/String;
    //   769: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: ldc_w 499
    //   775: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: getstatic 144	com/magmamobile/game/BubbleBlast/stages/StageGame:itemTouchedCount	I
    //   781: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: ldc_w 499
    //   787: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: getstatic 134	com/magmamobile/game/BubbleBlast/stages/StageGame:puzzleSolution	Ljava/lang/String;
    //   793: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 293	com/magmamobile/game/BubbleBlast/utils/GoogleAnalytics:trackAndDispatch	(Ljava/lang/String;)V
    //   802: ldc -124
    //   804: putstatic 134	com/magmamobile/game/BubbleBlast/stages/StageGame:puzzleSolution	Ljava/lang/String;
    //   807: goto -735 -> 72
    //   810: astore_2
    //   811: aload_2
    //   812: invokevirtual 296	java/lang/Exception:printStackTrace	()V
    //   815: goto -743 -> 72
    //   818: astore_2
    //   819: aload_2
    //   820: invokevirtual 296	java/lang/Exception:printStackTrace	()V
    //   823: goto -21 -> 802
    //   826: new 234	com/magmamobile/game/BubbleBlast/engine/items/layouts/ScorePuzzleLayout
    //   829: dup
    //   830: invokespecial 500	com/magmamobile/game/BubbleBlast/engine/items/layouts/ScorePuzzleLayout:<init>	()V
    //   833: putstatic 232	com/magmamobile/game/BubbleBlast/stages/StageGame:scorePuzzleLayout	Lcom/magmamobile/game/BubbleBlast/engine/items/layouts/ScorePuzzleLayout;
    //   836: return
    //   837: new 244	com/magmamobile/game/BubbleBlast/engine/items/layouts/ScoreArcadeLayout
    //   840: dup
    //   841: invokespecial 501	com/magmamobile/game/BubbleBlast/engine/items/layouts/ScoreArcadeLayout:<init>	()V
    //   844: putstatic 242	com/magmamobile/game/BubbleBlast/stages/StageGame:scoreArcadeLayout	Lcom/magmamobile/game/BubbleBlast/engine/items/layouts/ScoreArcadeLayout;
    //   847: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	848	0	this	StageGame
    //   656	11	1	i	int
    //   608	2	2	localException1	Exception
    //   810	2	2	localException2	Exception
    //   818	2	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   534	571	608	java/lang/Exception
    //   647	736	810	java/lang/Exception
    //   802	807	810	java/lang/Exception
    //   819	823	810	java/lang/Exception
    //   736	802	818	java/lang/Exception
  }
  
  public void onAction()
  {
    boolean bool = false;
    App.SoundBubble001Playing = false;
    App.SoundPop004Playing = false;
    switch (gameMode)
    {
    default: 
      if ((bubbles.total > 0) && (bubblesMini.total == 0) && (touchLeftCount == 0) && (!isGameOver))
      {
        modCommon.Log_d("bubbles.total:" + bubbles.total + " bubblesMini.total:" + bubblesMini.total + " touchLeftCount:" + touchLeftCount + " isGameOver:" + isGameOver);
        modCommon.Log_d("GAME OVER !!!");
        isGameOver = true;
        puzzleSolution = "";
      }
      switch (gameMode)
      {
      default: 
        label184:
        if (scorePuzzleLayout != null) {
          scorePuzzleLayout.onAction();
        }
        if (scoreArcadeLayout != null) {
          scoreArcadeLayout.onAction();
        }
        if (gameOverPuzzleLayout != null) {
          gameOverPuzzleLayout.onAction();
        }
        if (gameOverArcadeLayout != null) {
          gameOverArcadeLayout.onAction();
        }
        if (congratsPuzzleEndLayout != null) {
          congratsPuzzleEndLayout.onAction();
        }
        if (Keyboard.isDown(0))
        {
          if (!paused)
          {
            paused = true;
            onGamePause();
            PauseButton.setIcon(Game.getBitmap(54));
          }
          call(0);
        }
        break;
      }
      break;
    }
    do
    {
      return;
      if ((bubbles.total != 0) || (scorePuzzleLayout != null)) {
        break;
      }
      nextLevel();
      break;
      if ((bubbles.total != 0) || (scoreArcadeLayout != null)) {
        break;
      }
      nextLevel();
      break;
      if (gameOverPuzzleLayout != null) {
        break label184;
      }
      gameOverPuzzleLayout = new GameOverPuzzleLayout();
      break label184;
      if (gameOverArcadeLayout != null) {
        break label184;
      }
      gameOverArcadeLayout = new GameOverArcadeLayout();
      break label184;
      PauseButton.onAction();
      if (PauseButton.onClick)
      {
        if (paused) {}
        for (;;)
        {
          paused = bool;
          if (!paused) {
            break;
          }
          onGamePause();
          PauseButton.setIcon(Game.getBitmap(54));
          return;
          bool = true;
        }
        onGameResume();
        PauseButton.setIcon(Game.getBitmap(53));
        return;
      }
    } while (paused);
    bubbles.onAction();
    bubblesMini.onAction();
    bubblesBackground.onAction();
  }
  
  public void onCall(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      modCommon.Log_d("run back button !");
      localObject = new AlertDialog.Builder(Game.getContext());
      ((AlertDialog.Builder)localObject).setCancelable(true);
      ((AlertDialog.Builder)localObject).setIcon(2130837518);
      ((AlertDialog.Builder)localObject).setTitle(Game.getContext().getString(2131034168));
      ((AlertDialog.Builder)localObject).setPositiveButton(Game.getContext().getString(2131034113), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          StageGame.isGameOver = true;
          Game.Quit();
          StageGame.quit();
          switch (StageGame.gameMode)
          {
          default: 
            return;
          }
          StageGame.launchArcadeGameFinished();
        }
      });
      ((AlertDialog.Builder)localObject).setNegativeButton(Game.getContext().getString(2131034114), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          StageGame.paused = false;
          StageGame.onGameResume();
          StageGame.PauseButton.setIcon(Game.getBitmap(53));
        }
      });
      ((AlertDialog.Builder)localObject).show();
      return;
    }
    modCommon.Log_d("run hint button !");
    Object localObject = new Intent(Game.getContext(), HintActivity.class);
    ((Intent)localObject).putExtra("packNum", levelPackPuzzle);
    ((Intent)localObject).putExtra("levelNum", CurrentLevelPuzzleIndex + 1);
    Game.getContext().startActivity((Intent)localObject);
  }
  
  public void onInitialize()
  {
    modCommon.Log_d("onInitialize StageGame");
    modCommon.Log_d("running :: " + App.running);
    if (App.running)
    {
      onGameResume();
      return;
    }
    langString = Game.getContext().getString(2131034112);
    isGameOver = false;
    paused = false;
    GameBasePaint = new Paint();
    GameBasePaint.setAntiAlias(Game.getAliasing());
    GameBasePaint.setFilterBitmap(Game.getAliasing());
    ScorePaint = new Paint();
    ScorePaint.setColor(-65281);
    ScorePaint.setAntiAlias(Game.getAliasing());
    ScorePaint.setFilterBitmap(Game.getAliasing());
    Game.hideBanner();
    ScoreLevel = 0;
    if (!PuzzleResume) {
      ScoreTotal = 0;
    }
    ComboCount = 0;
    ComboBonus = 1;
    itemTouchedCount = 0;
    touchPossibleCount = 0;
    touchLeftCount = 0;
    puzzleSolution = "";
    setBackground();
    bubbles = new GameArray(40)
    {
      public Bubble[] createArray(int paramAnonymousInt)
      {
        return new Bubble[paramAnonymousInt];
      }
      
      public Bubble createObject()
      {
        return new Bubble();
      }
    };
    bubblesBackground = new GameArray(5)
    {
      public BubbleBackground[] createArray(int paramAnonymousInt)
      {
        return new BubbleBackground[paramAnonymousInt];
      }
      
      public BubbleBackground createObject()
      {
        return new BubbleBackground();
      }
    };
    bubblesBackground.allocate();
    bubblesBackground.allocate();
    bubblesBackground.allocate();
    bubblesBackground.allocate();
    bubblesBackground.allocate();
    bubblesMini = new GameArray(150)
    {
      public BubbleMini[] createArray(int paramAnonymousInt)
      {
        return new BubbleMini[paramAnonymousInt];
      }
      
      public BubbleMini createObject()
      {
        return new BubbleMini();
      }
    };
    PauseButton = new Button(280, 0, 40, 40, true, "", Game.getBitmap(53), null, null, null, 0);
    started = false;
    readyToStart = false;
    this.secondsBeforeStart = 3;
    Game.setBmpTextBitmap(Game.getBitmap(49));
    Game.setBmpTextSize(16, 16, 16, 16);
    if (scorePuzzleLayout != null)
    {
      scorePuzzleLayout.enabled = false;
      scorePuzzleLayout = null;
    }
    if (scoreArcadeLayout != null)
    {
      scoreArcadeLayout.enabled = false;
      scoreArcadeLayout = null;
    }
    if (gameOverPuzzleLayout != null)
    {
      gameOverPuzzleLayout.enabled = false;
      gameOverPuzzleLayout = null;
    }
    if (gameOverArcadeLayout != null)
    {
      gameOverArcadeLayout.enabled = false;
      gameOverArcadeLayout = null;
    }
    if (congratsPuzzleEndLayout != null)
    {
      congratsPuzzleEndLayout.enabled = false;
      congratsPuzzleEndLayout = null;
    }
    if (gameMode == null)
    {
      Game.Quit();
      quit();
      return;
    }
    modCommon.Log_d(gameMode.toString());
    switch (gameMode)
    {
    }
    for (;;)
    {
      started = true;
      App.running = true;
      return;
      CurrentLevelPuzzle = null;
      if (!PuzzleResume) {
        CurrentLevelPuzzleIndex = 0;
      }
      CurrentLevelPuzzle = new LevelPuzzle(Enums.enumBackground.waterwhite, levelPackPuzzle);
      CurrentLevelPuzzle.setupApp();
      PuzzleResume = true;
      continue;
      CurrentLevelArcade = null;
      CurrentLevelArcadeIndex = 0;
      CurrentLevelArcade = new LevelArcade();
      CurrentLevelArcade.nextLevel();
      CurrentLevelArcade.setupApp();
      touchLeftCount = 10;
    }
  }
  
  public void onRender()
  {
    if (paused)
    {
      PauseButton.onRender();
      if (pausedText != null) {
        pausedText.onRender();
      }
      return;
    }
    FixedBackground.onRender();
    bubblesBackground.onRender();
    bubbles.onRender();
    bubblesMini.onRender();
    Game.drawBitmap(Game.getBitmap(57), 0, 0, 320, 40, GameBasePaint);
    Game.setBmpTextBitmap(Game.getBitmap(49));
    Game.setBmpTextSize(16, 16, 16, 16);
    if ((scorePuzzleLayout != null) || (congratsPuzzleEndLayout != null) || (scoreArcadeLayout != null))
    {
      Game.drawBmpText(10, 0, "SCORE:" + ScoreTotal, ScorePaint);
      label129:
      Game.drawBmpText(10, 20, "TOUCH LEFT:" + touchLeftCount, ScorePaint);
      Game.drawBitmap(Game.getBitmap(57), 0, 440, 320, 40, GameBasePaint);
      Game.drawBmpText(10, 440, "TOUCH:" + itemTouchedCount, ScorePaint);
      Game.drawBmpText(10, 464, "COMBO:" + ComboCount, ScorePaint);
      switch (gameMode)
      {
      }
    }
    for (;;)
    {
      PauseButton.onRender();
      if (PauseButton.onClick) {
        modCommon.Log_i("BubbleBlast", "Pause Click");
      }
      if ((started) && (gameOverText != null)) {
        gameOverText.onRender();
      }
      if (scorePuzzleLayout != null) {
        scorePuzzleLayout.onRender();
      }
      if (scoreArcadeLayout != null) {
        scoreArcadeLayout.onRender();
      }
      if (gameOverPuzzleLayout != null) {
        gameOverPuzzleLayout.onRender();
      }
      if (gameOverArcadeLayout != null) {
        gameOverArcadeLayout.onRender();
      }
      if (congratsPuzzleEndLayout == null) {
        break;
      }
      congratsPuzzleEndLayout.onRender();
      return;
      Game.drawBmpText(10, 0, "SCORE:" + (ScoreTotal + ScoreLevel), ScorePaint);
      break label129;
      Game.drawBmpText(160, 440, "LEVEL:" + (CurrentLevelPuzzleIndex + 1), ScorePaint);
      continue;
      Game.drawBmpText(160, 440, "LEVEL:" + (CurrentLevelArcadeIndex + 1), ScorePaint);
    }
  }
  
  public void onTerminate() {}
  
  public void removeAll()
  {
    int i = 0;
    int j = bubbles.total;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ((Bubble[])bubbles.array)[i].enabled = false;
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/stages/StageGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */