package com.jaysquared.games.whereishd;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.jaysquared.games.whereishd.utils.DisplaySize;
import com.jaysquared.games.whereishd.utils.DistanceUnit;
import com.jaysquared.games.whereishd.utils.GameDifficulty;
import com.jaysquared.games.whereishd.utils.GamePlayMode;
import com.jaysquared.games.whereishd.utils.GuessTimer;
import com.jaysquared.games.whereishd.utils.Language;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import com.jaysquared.games.whereishd.utils.SystemHelper;
import java.util.Locale;

public class GameManager
{
  private static final String LOG_TAG = GameManager.class.getSimpleName();
  private static final String TYPEFACE = "Dimbo Regular.ttf";
  private final Context applicationContext;
  private float displayDensity;
  private Point displayResolution;
  private DisplaySize displaySize;
  private GamePlayMode gamePlayMode;
  private final PersistantSettings settings;
  private boolean shouldResetLearning;
  private Typeface typeface;
  
  public GameManager(Context paramContext, PersistantSettings paramPersistantSettings)
  {
    this.applicationContext = paramContext.getApplicationContext();
    this.settings = paramPersistantSettings;
    this.typeface = null;
    this.displaySize = DisplaySize.UNDEFINED;
    this.displayResolution = null;
    this.displayDensity = Float.MIN_VALUE;
    setGamePlayMode(GamePlayMode.UNSET);
    prepareGame();
  }
  
  private Display getDisplay()
  {
    return ((WindowManager)this.applicationContext.getSystemService("window")).getDefaultDisplay();
  }
  
  private void initializeDefaultSettings(PersistantSettings paramPersistantSettings)
  {
    paramPersistantSettings.setVersionCode(SystemHelper.getVersionCode(this.applicationContext));
    paramPersistantSettings.setPayStatus(ReleaseConfiguration.PAY_STATUS);
    if (ReleaseConfiguration.PAY_STATUS == PayStatus.NOADS) {
      paramPersistantSettings.setGameDifficulty(GameDifficulty.HD);
    }
    for (;;)
    {
      paramPersistantSettings.setTimer(GuessTimer.OFF);
      paramPersistantSettings.setNumerOfRounds(0);
      paramPersistantSettings.setPlay(false);
      Language localLanguage = Language.matchSystemLangauge(Locale.getDefault().getLanguage());
      paramPersistantSettings.setLanguage(localLanguage);
      if (!localLanguage.equals(Language.EN)) {
        break;
      }
      paramPersistantSettings.setDistanceUnit(DistanceUnit.MILES);
      return;
      paramPersistantSettings.setGameDifficulty(GameDifficulty.EASY);
    }
    paramPersistantSettings.setDistanceUnit(DistanceUnit.KILOMETERS);
  }
  
  private void prepareGame()
  {
    if (this.settings.getVersionCode() < 0)
    {
      SLog.i(LOG_TAG, "Preferences have never been initialized before. Doing it now...");
      initializeDefaultSettings(this.settings);
    }
    this.settings.setPayStatus(ReleaseConfiguration.PAY_STATUS);
  }
  
  public Context getApplicationContext()
  {
    return this.applicationContext;
  }
  
  public float getDisplayDensity()
  {
    if (this.displayDensity == Float.MIN_VALUE)
    {
      this.displayDensity = this.applicationContext.getResources().getDisplayMetrics().density;
      SLog.d(LOG_TAG, "Display density: " + this.displayDensity);
    }
    return this.displayDensity;
  }
  
  @TargetApi(13)
  public Point getDisplayResolution()
  {
    Point localPoint;
    if (this.displayResolution == null)
    {
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 13) {
        break label70;
      }
      getDisplay().getSize(localPoint);
    }
    for (;;)
    {
      this.displayResolution = localPoint;
      SLog.d(LOG_TAG, "Display resolution: " + this.displayResolution);
      return this.displayResolution;
      label70:
      localPoint.x = getDisplay().getWidth();
      localPoint.y = getDisplay().getHeight();
    }
  }
  
  public DisplaySize getDisplaySize()
  {
    float f1;
    float f2;
    if (this.displaySize == DisplaySize.UNDEFINED)
    {
      f1 = getDisplayResolution().x / getDisplayDensity();
      f2 = getDisplayResolution().y / getDisplayDensity();
      if ((f1 <= 960.0F) || (f2 <= 720.0F)) {
        break label95;
      }
      this.displaySize = DisplaySize.XLARGE;
    }
    for (;;)
    {
      SLog.d(LOG_TAG, "Display size: " + this.displaySize);
      return this.displaySize;
      label95:
      if ((f1 > 640.0F) && (f2 > 480.0F)) {
        this.displaySize = DisplaySize.LARGE;
      } else if ((f1 > 470.0F) && (f2 > 320.0F)) {
        this.displaySize = DisplaySize.NORMAL;
      } else {
        this.displaySize = DisplaySize.SMALL;
      }
    }
  }
  
  public GamePlayMode getGamePlayMode()
  {
    return this.gamePlayMode;
  }
  
  public Typeface getTypeface()
  {
    if (this.typeface == null) {
      this.typeface = Typeface.createFromAsset(this.applicationContext.getAssets(), "Dimbo Regular.ttf");
    }
    return this.typeface;
  }
  
  public boolean isShouldResetLearning()
  {
    return this.shouldResetLearning;
  }
  
  public boolean isTablet()
  {
    return SystemHelper.isTablet(this.applicationContext);
  }
  
  public void setGamePlayMode(GamePlayMode paramGamePlayMode)
  {
    this.gamePlayMode = paramGamePlayMode;
  }
  
  public void setShouldResetLearning(boolean paramBoolean)
  {
    this.shouldResetLearning = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/GameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */