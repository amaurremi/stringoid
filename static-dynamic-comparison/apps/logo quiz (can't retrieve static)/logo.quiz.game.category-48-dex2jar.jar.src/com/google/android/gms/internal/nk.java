package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public class nk
  implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
{
  private final nf.a akE;
  private boolean akF;
  private nn aku;
  
  public nk(nf.a parama)
  {
    this.akE = parama;
    this.aku = null;
    this.akF = true;
  }
  
  public void R(boolean paramBoolean)
  {
    this.akF = paramBoolean;
  }
  
  public void a(nn paramnn)
  {
    this.aku = paramnn;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.aku.S(false);
    if ((this.akF) && (this.akE != null)) {
      this.akE.mS();
    }
    this.akF = false;
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.aku.S(true);
    if ((this.akF) && (this.akE != null))
    {
      if (!paramConnectionResult.hasResolution()) {
        break label48;
      }
      this.akE.b(paramConnectionResult.getResolution());
    }
    for (;;)
    {
      this.akF = false;
      return;
      label48:
      this.akE.mT();
    }
  }
  
  public void onDisconnected()
  {
    this.aku.S(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */