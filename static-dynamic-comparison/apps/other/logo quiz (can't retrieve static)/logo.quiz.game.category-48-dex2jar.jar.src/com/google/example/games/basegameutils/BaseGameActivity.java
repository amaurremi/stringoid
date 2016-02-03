package com.google.example.games.basegameutils;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;

public abstract class BaseGameActivity
  extends FragmentActivity
  implements GameHelper.GameHelperListener
{
  public static final int CLIENT_ALL = 15;
  public static final int CLIENT_APPSTATE = 4;
  public static final int CLIENT_GAMES = 1;
  public static final int CLIENT_PLUS = 2;
  private static final String TAG = "BaseGameActivity";
  protected boolean mDebugLog = false;
  protected GameHelper mHelper;
  protected int mRequestedClients = 1;
  
  protected BaseGameActivity() {}
  
  protected BaseGameActivity(int paramInt)
  {
    setRequestedClients(paramInt);
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
  
  @Deprecated
  protected void enableDebugLog(boolean paramBoolean, String paramString)
  {
    Log.w("BaseGameActivity", "BaseGameActivity.enabledDebugLog(bool,String) is deprecated. Use enableDebugLog(boolean)");
    enableDebugLog(paramBoolean);
  }
  
  protected GoogleApiClient getApiClient()
  {
    return this.mHelper.getApiClient();
  }
  
  public GameHelper getGameHelper()
  {
    if (this.mHelper == null)
    {
      this.mHelper = new GameHelper(this, this.mRequestedClients);
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mHelper.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mHelper == null) {
      getGameHelper();
    }
    this.mHelper.setup(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.mHelper.onStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mHelper.onStop();
  }
  
  protected void reconnectClient()
  {
    this.mHelper.reconnectClient();
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/example/games/basegameutils/BaseGameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */