package com.bubble.play.services;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.bubble.play.services.cloud.state.CloudResultCallback;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class PlayServicesActionHelper
  extends PlayServicesAction
  implements PlayServicesFeatures
{
  public static final String IS_CLOUD_AUTO_UPDATE = "IS_CLOUD_AUTO_UPDATE";
  public static final String LOGIN_POPUP_LAUNCH_COUNT = "login_popup_launch_count";
  final int RC_UNUSED = 5001;
  CloudResultCallback cloudResultCallback = null;
  private boolean isLoginCheck = false;
  byte[] lastClicksCloudData = null;
  int lastClicksCloudStateKey = -1;
  private String lastClicksServiceItemId;
  private ServiceType lastClicksServiceType;
  private long leaderboardScore = -1L;
  private List<LeaderBoardScore> leaderboardsScores;
  ResultCallback<AppStateManager.StateResult> resultCallback;
  private SignInPopUp signInPopUp;
  
  public PlayServicesActionHelper(int paramInt, Activity paramActivity)
  {
    super(paramInt, paramActivity);
    setGameHelperListener(getGameHelperListener());
  }
  
  public PlayServicesActionHelper(Activity paramActivity)
  {
    super(paramActivity);
    setGameHelperListener(getGameHelperListener());
  }
  
  private SignInPopUp createAndShowSignInPopUp()
  {
    return new SignInPopUp(this.mLoadingDialog, getGameHelper(), this.activity).show();
  }
  
  private GameHelper.GameHelperListener getGameHelperListener()
  {
    new GameHelper.GameHelperListener()
    {
      public void onSignInFailed() {}
      
      public void onSignInSucceeded()
      {
        if (PlayServicesActionHelper.this.lastClicksServiceType != null)
        {
          if (PlayServicesActionHelper.this.signInPopUp != null) {
            PlayServicesActionHelper.this.signInPopUp.hide();
          }
          if (!PlayServicesActionHelper.this.lastClicksServiceType.equals(ServiceType.LEADERBOARDS)) {
            break label109;
          }
          PlayServicesActionHelper.this.openLeaderBoards(PlayServicesActionHelper.this.leaderboardsScores);
        }
        for (;;)
        {
          PlayServicesActionHelper.access$002(PlayServicesActionHelper.this, null);
          SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(PlayServicesActionHelper.this.activity.getApplicationContext()).edit();
          localEditor.putLong("login_popup_launch_count", 99L);
          localEditor.commit();
          return;
          label109:
          if (PlayServicesActionHelper.this.lastClicksServiceType.equals(ServiceType.LEADERBOARD))
          {
            if (PlayServicesActionHelper.this.leaderboardScore != -1L) {
              PlayServicesActionHelper.this.submitLeaderBoardScore(PlayServicesActionHelper.this.lastClicksServiceItemId, PlayServicesActionHelper.this.leaderboardScore);
            }
            PlayServicesActionHelper.this.openLeaderBoard(PlayServicesActionHelper.this.lastClicksServiceItemId);
          }
          else if (PlayServicesActionHelper.this.lastClicksServiceType.equals(ServiceType.CLOUD_UPDATE))
          {
            if ((PlayServicesActionHelper.this.lastClicksCloudStateKey != -1) && (PlayServicesActionHelper.this.lastClicksCloudData != null)) {
              AppStateManager.update(PlayServicesActionHelper.this.getApiClient(), PlayServicesActionHelper.this.lastClicksCloudStateKey, PlayServicesActionHelper.this.lastClicksCloudData);
            }
          }
          else if (PlayServicesActionHelper.this.lastClicksServiceType.equals(ServiceType.CLOUD_LOAD))
          {
            if ((PlayServicesActionHelper.this.lastClicksCloudStateKey != -1) && (PlayServicesActionHelper.this.cloudResultCallback != null)) {
              AppStateManager.load(PlayServicesActionHelper.this.getApiClient(), PlayServicesActionHelper.this.lastClicksCloudStateKey).setResultCallback(PlayServicesActionHelper.this.getResultCallback(PlayServicesActionHelper.this.cloudResultCallback));
            }
          }
          else if (PlayServicesActionHelper.this.lastClicksServiceType.equals(ServiceType.ACHIEVMENTS))
          {
            PlayServicesActionHelper.this.openAchievements();
          }
        }
      }
    };
  }
  
  private void openAchievements()
  {
    try
    {
      this.activity.startActivityForResult(Games.Achievements.getAchievementsIntent(getApiClient()), 5001);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void openLeaderBoard(String paramString)
  {
    try
    {
      this.activity.startActivityForResult(Games.Leaderboards.getLeaderboardIntent(getApiClient(), paramString), 5001);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void openLeaderBoard(String paramString, long paramLong)
  {
    try
    {
      submitLeaderBoardScore(paramString, paramLong);
      this.activity.startActivityForResult(Games.Leaderboards.getLeaderboardIntent(getApiClient(), paramString), 5001);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void openLeaderBoards()
  {
    this.activity.startActivityForResult(Games.Leaderboards.getAllLeaderboardsIntent(getApiClient()), 5001);
  }
  
  private void openLeaderBoards(List<LeaderBoardScore> paramList)
  {
    if (paramList != null) {}
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LeaderBoardScore localLeaderBoardScore = (LeaderBoardScore)paramList.next();
        submitLeaderBoardScore(localLeaderBoardScore.getLeaderboardId(), localLeaderBoardScore.getScore());
      }
      this.leaderboardsScores = null;
      this.activity.startActivityForResult(Games.Leaderboards.getAllLeaderboardsIntent(getApiClient()), 5001);
      return;
    }
    catch (Exception paramList) {}
  }
  
  private void resetState()
  {
    this.lastClicksServiceType = null;
    this.lastClicksServiceItemId = null;
    this.leaderboardsScores = null;
    this.leaderboardScore = -1L;
    this.lastClicksCloudStateKey = -1;
    this.lastClicksCloudData = null;
    this.cloudResultCallback = null;
  }
  
  ResultCallback<AppStateManager.StateResult> getResultCallback(final CloudResultCallback paramCloudResultCallback)
  {
    if (this.resultCallback == null) {
      this.resultCallback = new ResultCallback()
      {
        public void onResult(AppStateManager.StateResult paramAnonymousStateResult)
        {
          AppStateManager.StateConflictResult localStateConflictResult = paramAnonymousStateResult.getConflictResult();
          paramAnonymousStateResult = paramAnonymousStateResult.getLoadedResult();
          if (paramAnonymousStateResult != null) {
            paramCloudResultCallback.processStateLoaded(paramAnonymousStateResult);
          }
          while (localStateConflictResult == null) {
            return;
          }
          paramCloudResultCallback.processStateConflict(localStateConflictResult);
        }
      };
    }
    return this.resultCallback;
  }
  
  public void hideSignInPopUp()
  {
    if (this.signInPopUp != null) {
      this.signInPopUp.hide();
    }
  }
  
  public void incrementAchievement(String paramString, int paramInt)
  {
    try
    {
      Games.Achievements.increment(getApiClient(), paramString, paramInt);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean isCloudAutoSync()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext()).getBoolean("IS_CLOUD_AUTO_UPDATE", true);
  }
  
  public boolean isLoginCheck()
  {
    return this.isLoginCheck;
  }
  
  public void loadCloud(int paramInt, CloudResultCallback paramCloudResultCallback)
  {
    if (isSignedIn()) {}
    for (;;)
    {
      try
      {
        AppStateManager.load(getApiClient(), paramInt).setResultCallback(getResultCallback(paramCloudResultCallback));
        return;
      }
      catch (Exception paramCloudResultCallback) {}
      if (isLoginCheck())
      {
        this.lastClicksServiceType = ServiceType.CLOUD_LOAD;
        this.lastClicksCloudStateKey = paramInt;
        this.cloudResultCallback = paramCloudResultCallback;
        this.signInPopUp = createAndShowSignInPopUp();
        return;
      }
    }
  }
  
  public void resolveCloudConflict(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      AppStateManager.resolve(getApiClient(), paramInt, paramString, paramArrayOfByte);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void setCloudAutoSync(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext()).edit();
    localEditor.putBoolean("IS_CLOUD_AUTO_UPDATE", paramBoolean);
    localEditor.commit();
  }
  
  public void setLeaderboardScore(long paramLong)
  {
    this.leaderboardScore = paramLong;
  }
  
  public void setLoginCheck(boolean paramBoolean)
  {
    this.isLoginCheck = paramBoolean;
  }
  
  public void showAchievements()
  {
    if (isSignedIn()) {}
    for (;;)
    {
      try
      {
        openAchievements();
        return;
      }
      catch (Exception localException) {}
      if (isLoginCheck())
      {
        this.lastClicksServiceType = ServiceType.ACHIEVMENTS;
        this.signInPopUp = createAndShowSignInPopUp();
        return;
      }
    }
  }
  
  public void showAndSubmitLeaderBoard(String paramString, long paramLong)
  {
    this.leaderboardScore = paramLong;
    if (isSignedIn()) {}
    for (;;)
    {
      try
      {
        openLeaderBoard(paramString, this.leaderboardScore);
        return;
      }
      catch (Exception paramString) {}
      if (isLoginCheck())
      {
        this.lastClicksServiceType = ServiceType.LEADERBOARD;
        this.lastClicksServiceItemId = paramString;
        this.signInPopUp = createAndShowSignInPopUp();
        return;
      }
    }
  }
  
  public void showAndSubmitLeaderBoards(List<LeaderBoardScore> paramList)
  {
    if (isSignedIn()) {}
    for (;;)
    {
      try
      {
        openLeaderBoards(paramList);
        return;
      }
      catch (Exception paramList) {}
      if (isLoginCheck())
      {
        this.lastClicksServiceType = ServiceType.LEADERBOARDS;
        this.leaderboardsScores = paramList;
        this.signInPopUp = createAndShowSignInPopUp();
        return;
      }
    }
  }
  
  public void showLeaderBoard(String paramString)
  {
    if (isSignedIn()) {}
    for (;;)
    {
      try
      {
        openLeaderBoard(paramString);
        return;
      }
      catch (Exception paramString) {}
      if (isLoginCheck())
      {
        this.lastClicksServiceType = ServiceType.LEADERBOARD;
        this.lastClicksServiceItemId = paramString;
        this.signInPopUp = createAndShowSignInPopUp();
        return;
      }
    }
  }
  
  public void showLeaderBoards()
  {
    if (isSignedIn()) {}
    for (;;)
    {
      try
      {
        openLeaderBoards();
        return;
      }
      catch (Exception localException) {}
      if (isLoginCheck())
      {
        this.lastClicksServiceType = ServiceType.LEADERBOARDS;
        this.signInPopUp = createAndShowSignInPopUp();
        return;
      }
    }
  }
  
  public void showLoginPopUpAfterLaunches(int paramInt)
  {
    if (!isSignedIn())
    {
      Object localObject = PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext());
      long l = ((SharedPreferences)localObject).getLong("login_popup_launch_count", 0L) + 1L;
      if (l <= paramInt)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putLong("login_popup_launch_count", l);
        ((SharedPreferences.Editor)localObject).commit();
        if (l == paramInt) {
          this.signInPopUp = createAndShowSignInPopUp();
        }
      }
    }
  }
  
  public void submitLeaderBoardScore(String paramString, long paramLong)
  {
    try
    {
      if (isSignedIn()) {
        Games.Leaderboards.submitScore(getApiClient(), paramString, paramLong);
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void unlockAchievement(String paramString)
  {
    try
    {
      Games.Achievements.unlock(getApiClient(), paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void updateCloud(int paramInt, byte[] paramArrayOfByte)
  {
    if (isSignedIn()) {}
    while (!isLoginCheck()) {
      try
      {
        AppStateManager.update(getApiClient(), paramInt, paramArrayOfByte);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        System.out.println("aa");
        return;
      }
    }
    this.lastClicksServiceType = ServiceType.CLOUD_UPDATE;
    this.lastClicksCloudStateKey = paramInt;
    this.lastClicksCloudData = paramArrayOfByte;
    this.signInPopUp = createAndShowSignInPopUp();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/play/services/PlayServicesActionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */