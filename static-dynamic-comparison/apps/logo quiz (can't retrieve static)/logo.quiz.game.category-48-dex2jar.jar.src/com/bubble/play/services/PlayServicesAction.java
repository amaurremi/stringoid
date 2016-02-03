package com.bubble.play.services;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluebird.mobile.tools.activities.ActivityAction;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import com.google.example.games.basegameutils.GameHelper.SignInFailureReason;

public class PlayServicesAction
  implements ActivityAction, GameHelper.GameHelperListener
{
  public static final int CLIENT_ALL = 15;
  public static final int CLIENT_APPFOLDER = 8;
  public static final int CLIENT_APPSTATE = 4;
  public static final int CLIENT_GAMES = 1;
  public static final int CLIENT_PLUS = 2;
  public static final String IS_USER_SIGNED_IN_KEY = "isUserSignedIn";
  public static final String SETTINGS_FILE = "SETTINGS_FILE";
  private static final String TAG = "BaseGameActivity";
  protected Activity activity;
  protected GameHelper.GameHelperListener gameHelperListener;
  protected GameSaveStateListener gameSaveStateListener;
  protected boolean mDebugLog = false;
  protected GameHelper mHelper;
  protected ProgressDialog mLoadingDialog = null;
  protected int mRequestedClients = 7;
  
  protected PlayServicesAction(int paramInt, Activity paramActivity)
  {
    setRequestedClients(paramInt);
    this.activity = paramActivity;
  }
  
  protected PlayServicesAction(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  private boolean isUserSignedIn()
  {
    return this.activity.getSharedPreferences("SETTINGS_FILE", 0).getBoolean("isUserSignedIn", false);
  }
  
  protected void beginUserInitiatedSignIn()
  {
    this.mHelper.beginUserInitiatedSignIn();
  }
  
  protected void enableDebugLog(boolean paramBoolean)
  {
    this.mDebugLog = true;
    if (this.mHelper != null) {
      this.mHelper.enableDebugLog(paramBoolean);
    }
  }
  
  protected GoogleApiClient getApiClient()
  {
    return this.mHelper.getApiClient();
  }
  
  public GameHelper getGameHelper()
  {
    if (this.mHelper == null)
    {
      this.mHelper = new GameHelper(this.activity, this.mRequestedClients);
      this.mHelper.enableDebugLog(this.mDebugLog);
    }
    return this.mHelper;
  }
  
  protected String getInvitationId()
  {
    return this.mHelper.getInvitationId();
  }
  
  protected GameHelper.SignInFailureReason getSignInError()
  {
    return this.mHelper.getSignInError();
  }
  
  protected boolean hasSignInError()
  {
    return this.mHelper.hasSignInError();
  }
  
  protected boolean isSignedIn()
  {
    return this.mHelper.isSignedIn();
  }
  
  public void onActivityResultAction(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mHelper.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressedAction()
  {
    return false;
  }
  
  public void onCreateAction()
  {
    if (this.mHelper == null) {
      getGameHelper();
    }
    try
    {
      this.mHelper.setup(this);
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
  }
  
  public void onDestroyAction() {}
  
  public void onPauseAction() {}
  
  public void onResumeAction() {}
  
  public void onSignInFailed()
  {
    if (this.mLoadingDialog != null) {
      this.mLoadingDialog.dismiss();
    }
    if (this.gameHelperListener != null) {
      this.gameHelperListener.onSignInFailed();
    }
  }
  
  public void onSignInSucceeded()
  {
    if (this.mLoadingDialog != null) {
      this.mLoadingDialog.dismiss();
    }
    SharedPreferences.Editor localEditor = this.activity.getSharedPreferences("SETTINGS_FILE", 0).edit();
    localEditor.putBoolean("isUserSignedIn", true);
    localEditor.commit();
    if (this.gameHelperListener != null) {
      this.gameHelperListener.onSignInSucceeded();
    }
    if (this.gameSaveStateListener != null) {
      this.gameSaveStateListener.loadAppState();
    }
  }
  
  public void onStartAction()
  {
    if (!isUserSignedIn()) {
      this.mHelper.setConnectOnStart(false);
    }
    this.mLoadingDialog = new ProgressDialog(this.activity);
    this.mLoadingDialog.setMessage("Loading");
    this.mHelper.onStart(this.activity);
    if (this.gameSaveStateListener != null) {
      this.gameSaveStateListener.loadAppState();
    }
  }
  
  public void onStopAction()
  {
    if (this.mLoadingDialog != null)
    {
      this.mLoadingDialog.dismiss();
      this.mLoadingDialog = null;
    }
    this.mHelper.onStop();
  }
  
  protected void reconnectClient()
  {
    this.mHelper.reconnectClient();
  }
  
  public void setGameHelperListener(GameHelper.GameHelperListener paramGameHelperListener)
  {
    this.gameHelperListener = paramGameHelperListener;
  }
  
  public void setGameSaveStateListener(GameSaveStateListener paramGameSaveStateListener)
  {
    this.gameSaveStateListener = paramGameSaveStateListener;
  }
  
  protected void setRequestedClients(int paramInt)
  {
    this.mRequestedClients = paramInt;
  }
  
  protected void showAlert(String paramString)
  {
    this.mHelper.makeSimpleDialog(paramString).show();
  }
  
  protected void showAlert(String paramString1, String paramString2)
  {
    this.mHelper.makeSimpleDialog(paramString1, paramString2).show();
  }
  
  protected void signOut()
  {
    this.mHelper.signOut();
  }
  
  public static abstract interface GameSaveStateListener
  {
    public abstract void loadAppState();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/play/services/PlayServicesAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */