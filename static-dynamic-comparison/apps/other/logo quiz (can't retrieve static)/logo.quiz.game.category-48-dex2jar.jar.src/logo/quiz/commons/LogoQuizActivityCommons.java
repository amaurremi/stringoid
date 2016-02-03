package logo.quiz.commons;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.bluebird.mobile.tools.activities.ActivityAction;
import com.bluebird.mobile.tools.rate.AppRate;
import com.bluebird.mobile.tools.rate.AppRateConfiguration;
import com.bubble.adserwer.HouseAd;
import com.bubble.bugsense.BugSense;
import com.bubble.play.services.PlayServicesAction.GameSaveStateListener;
import com.bubble.play.services.PlayServicesActionHelper;
import com.bubble.play.services.cloud.state.CloudResultCallback;
import com.bubble.tapjoy.TapjoyAction;
import com.bubble.tapjoy.TapjoySupport;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import java.util.ArrayList;
import java.util.List;
import logo.quiz.commons.cloud.save.SameGameState;
import logo.quiz.commons.cloud.save.SaveGame;
import logo.quiz.commons.inapp.InAppProduct;
import logo.quiz.commons.tapjoy.TapjoyEarnedPointsNotifierImpl;
import logo.quiz.commons.utils.DeviceUtils;
import logo.quiz.commons.utils.hints.HintsService;
import logo.quiz.commons.utils.hints.HintsServiceFactory;
import logo.quiz.commons.utils.score.ScoreService;

public abstract class LogoQuizActivityCommons
  extends LogoQuizAbstractActivity
{
  public static final int LAST_GAME_STATE_KEY = 0;
  final int RC_RESOLVE = 5000;
  final int RC_UNUSED = 5001;
  private List<InAppProduct> gameInAppProducts;
  protected InAppHelper inAppHelper;
  protected InAppListener inAppListener;
  Activity myActivity;
  protected PlayServicesActionHelper playServicesActionHelper;
  private TapjoySupport tapjoySupport;
  
  private int getHintsBuyLeft()
  {
    int i = getHintsService().getAvailibleHintsCount(getApplicationContext());
    int j = InAppHelper.getBuyHintsCount(getApplicationContext());
    if (i > j) {
      return j;
    }
    return i;
  }
  
  private HintsService getHintsService()
  {
    return HintsServiceFactory.getInstance();
  }
  
  public static void openShop(Context paramContext)
  {
    try
    {
      Intent localIntent1 = new Intent(paramContext, DeviceUtilCommons.getClassByName(paramContext, "GetHintsActivity"));
      localIntent1.setFlags(872415232);
      paramContext.startActivity(localIntent1);
      return;
    }
    catch (ClassNotFoundRuntimeException localClassNotFoundRuntimeException)
    {
      for (;;)
      {
        Intent localIntent2 = new Intent(paramContext, DeviceUtilCommons.getClassByName(paramContext, "FreeHintsActivity"));
      }
    }
  }
  
  protected SameGameState createSaveGame(int paramInt)
  {
    return new SaveGame(paramInt, getScoreUtilProvider(), getScoreService(), getApplicationContext());
  }
  
  protected SameGameState createSaveGame(byte[] paramArrayOfByte)
  {
    return new SaveGame(paramArrayOfByte, getScoreUtilProvider(), getScoreService());
  }
  
  protected abstract ConstantsProvider getConstants();
  
  public void getFreeHints(View paramView)
  {
    openShop(getApplicationContext());
  }
  
  public List<InAppProduct> getGameInAppProducts()
  {
    return new ArrayList();
  }
  
  protected int getGuessedLogosCount()
  {
    return getScoreService().getCompletedLogosCount(getApplicationContext());
  }
  
  public InAppListener getInAppListener()
  {
    return this.inAppListener;
  }
  
  protected String getLeaderboardIdKey()
  {
    int i = getResources().getIdentifier("leaderboard", "string", getPackageName());
    if (i == 0) {
      return null;
    }
    return getResources().getString(i);
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
  protected void loadGameStateFromCloud()
  {
    this.playServicesActionHelper.setLoginCheck(false);
    this.playServicesActionHelper.loadCloud(0, new CloudResultCallback()
    {
      public void processStateConflict(AppStateManager.StateConflictResult paramAnonymousStateConflictResult)
      {
        Object localObject2 = paramAnonymousStateConflictResult.getServerData();
        Object localObject1 = paramAnonymousStateConflictResult.getLocalData();
        localObject2 = LogoQuizActivityCommons.this.createSaveGame((byte[])localObject2);
        SameGameState localSameGameState = LogoQuizActivityCommons.this.createSaveGame((byte[])localObject1);
        int k = LogoQuizActivityCommons.this.getGuessedLogosCount();
        int j = k;
        int i = LogoQuizActivityCommons.this.getHintsService().getAvailibleHintsCount(LogoQuizActivityCommons.this.getApplicationContext());
        localObject1 = LogoQuizActivityCommons.this.createSaveGame(i);
        int m = localSameGameState.getGuessedLogosCount(LogoQuizActivityCommons.this.getApplicationContext());
        i = j;
        if (m > j)
        {
          i = m;
          localObject1 = localSameGameState;
        }
        m = ((SameGameState)localObject2).getGuessedLogosCount(LogoQuizActivityCommons.this.getApplicationContext());
        j = i;
        if (m > i)
        {
          j = m;
          localObject1 = localObject2;
        }
        ((SameGameState)localObject1).processStateConflict(localSameGameState, (SameGameState)localObject2, LogoQuizActivityCommons.this.getApplicationContext());
        if ((j > k) && (localObject1 != null))
        {
          LogoQuizActivityCommons.this.getHintsService().setHints(((SameGameState)localObject1).getHintsCount() + LogoQuizActivityCommons.this.getHintsBuyLeft(), LogoQuizActivityCommons.this.getApplicationContext());
          ((SameGameState)localObject1).loadState(LogoQuizActivityCommons.this.getApplicationContext());
          LogoQuizActivityCommons.this.restartScoreUtil();
          LogoQuizActivityCommons.this.playServicesActionHelper.setLeaderboardScore(LogoQuizActivityCommons.this.getGuessedLogosCount());
        }
        LogoQuizActivityCommons.this.playServicesActionHelper.resolveCloudConflict(0, paramAnonymousStateConflictResult.getResolvedVersion(), ((SameGameState)localObject1).getBytes());
      }
      
      public void processStateLoaded(AppStateManager.StateLoadedResult paramAnonymousStateLoadedResult)
      {
        paramAnonymousStateLoadedResult = paramAnonymousStateLoadedResult.getLocalData();
        paramAnonymousStateLoadedResult = LogoQuizActivityCommons.this.createSaveGame(paramAnonymousStateLoadedResult);
        int i = LogoQuizActivityCommons.this.getGuessedLogosCount();
        int j = paramAnonymousStateLoadedResult.getGuessedLogosCount(LogoQuizActivityCommons.this.getApplicationContext());
        paramAnonymousStateLoadedResult.loadPurchase(LogoQuizActivityCommons.this.getApplicationContext());
        if (j > i)
        {
          LogoQuizActivityCommons.this.getHintsService().setHints(paramAnonymousStateLoadedResult.getHintsCount() + LogoQuizActivityCommons.this.getHintsBuyLeft(), LogoQuizActivityCommons.this.getApplicationContext());
          paramAnonymousStateLoadedResult.loadState(LogoQuizActivityCommons.this.getApplicationContext());
          LogoQuizActivityCommons.this.restartScoreUtil();
          LogoQuizActivityCommons.this.playServicesActionHelper.setLeaderboardScore(LogoQuizActivityCommons.this.getGuessedLogosCount());
        }
      }
    });
    this.playServicesActionHelper.setLoginCheck(true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.inAppHelper != null) && (this.inAppHelper.isInAppResult(paramInt1, paramInt2, paramIntent))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(0, 0);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle, R.layout.main);
    this.playServicesActionHelper = new PlayServicesActionHelper(this);
    this.playServicesActionHelper.setGameSaveStateListener(new PlayServicesAction.GameSaveStateListener()
    {
      public void loadAppState()
      {
        LogoQuizActivityCommons.this.loadGameStateFromCloud();
      }
    });
    this.tapjoySupport = new TapjoySupport(new TapjoyEarnedPointsNotifierImpl(getMenuService(), this), this);
    this.tapjoySupport.enableTapjoy();
    addActivityActions(new ActivityAction[] { this.playServicesActionHelper, new TapjoyAction(this.tapjoySupport) });
    this.myActivity = this;
    int i = DeviceUtilCommons.getDrawableIdByName("logo", getApplicationContext());
    if (i != 0)
    {
      paramBundle = (ImageView)findViewById(R.id.logoBottom);
      paramBundle.setVisibility(0);
      paramBundle.setImageResource(i);
    }
    i = DeviceUtilCommons.getDrawableIdByName("logo_left", getApplicationContext());
    if (i != 0)
    {
      paramBundle = (ImageView)findViewById(R.id.logoLeftBottom);
      paramBundle.setVisibility(0);
      paramBundle.setImageResource(i);
    }
    i = DeviceUtilCommons.getDrawableIdByName("logo_right", getApplicationContext());
    if (i != 0)
    {
      paramBundle = (ImageView)findViewById(R.id.logoRightBottom);
      paramBundle.setVisibility(0);
      paramBundle.setImageResource(i);
    }
    paramBundle = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    if (!paramBundle.getBoolean("ad999", false)) {
      AppRate.show(this, new AppRateConfiguration(null, 0, 6, true, null));
    }
    getScoreUtilProvider().initLogos(this);
    if (paramBundle.getInt("allHints", -1) == -1) {
      getHintsService().setHints(getResources().getInteger(R.integer.hintsOnStart), getApplicationContext());
    }
    try
    {
      this.inAppHelper = new InAppHelper(getConstants().getInAppPublicKey(), getInAppListener(), this, getGameInAppProducts());
      try
      {
        paramBundle = findViewById(R.id.subtitle);
        if (paramBundle != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.setMargins(DeviceUtilCommons.dip(getApplicationContext().getResources().getInteger(R.integer.sublogoMarginLeft), getApplicationContext()), 0, 0, 0);
          paramBundle.setLayoutParams(localLayoutParams);
        }
      }
      catch (NoSuchFieldError paramBundle)
      {
        for (;;) {}
      }
      if (!DeviceUtils.isFirstRun(getApplicationContext()))
      {
        if (getScoreUtilProvider().getNewLogosCount() > 0)
        {
          Toast.makeText(this, getString(R.string.x_new_logos_to_guess, new Object[] { Integer.valueOf(getScoreUtilProvider().getNewLogosCount()) }), 1).show();
          getScoreUtilProvider().setNewLogosCount(0);
        }
        new HouseAd(this.adserwer, this).showAdForHints(0, true);
      }
      DeviceUtils.turnOffFirstRun(getApplicationContext());
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("LogoQuizActivityCommons", "Init inAppHelper error");
        paramBundle.printStackTrace();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.inAppHelper != null) {
      this.inAppHelper.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = findViewById(R.id.signInPopUp);
      if ((paramKeyEvent != null) && (paramKeyEvent.getVisibility() == 0))
      {
        this.playServicesActionHelper.hideSignInPopUp();
        return true;
      }
      new AlertDialog.Builder(this).setIcon(17301552).setTitle(getString(R.string.exit)).setMessage(getString(R.string.are_you_sure_to_leave)).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          LogoQuizActivityCommons.this.moveTaskToBack(true);
        }
      }).show();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    this.bugSense.addCrashExtraData("activity", getClass().getSimpleName());
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void options(View paramView)
  {
    paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "OptionsActivity"));
    paramView.setFlags(603979776);
    startActivity(paramView);
  }
  
  public void otherApps(View paramView)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      paramView = "market://search?q=pub:bubble quiz games";
      if ("market://details?id=".contains("amazon")) {
        paramView = "market://details?id=logo.quiz.music.bands.game&showAll=1";
      }
      localIntent.setData(Uri.parse(paramView));
      localIntent.addFlags(1073741824);
      startActivity(localIntent);
      return;
    }
    catch (Exception paramView)
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/developer?id=bubble%20quiz%20games")));
    }
  }
  
  public void play(View paramView)
  {
    LevelUtil.setActiveLevel(getApplicationContext(), 1);
    paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "LevelsActivity"));
    paramView.setFlags(603979776);
    startActivity(paramView);
  }
  
  protected void restartScoreUtil()
  {
    getScoreService().reset();
    getScoreUtilProvider().setActiveBrandsLevel(null);
    getScoreUtilProvider().initLogos(this);
  }
  
  public void showLeaderboards(View paramView)
  {
    paramView = getLeaderboardIdKey();
    if (paramView != null)
    {
      this.playServicesActionHelper.setLoginCheck(true);
      this.playServicesActionHelper.showAndSubmitLeaderBoard(paramView, getGuessedLogosCount());
      this.playServicesActionHelper.setLoginCheck(false);
    }
  }
  
  public void stats(View paramView)
  {
    paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "StatisticsActivity"));
    paramView.setFlags(603979776);
    startActivity(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/LogoQuizActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */