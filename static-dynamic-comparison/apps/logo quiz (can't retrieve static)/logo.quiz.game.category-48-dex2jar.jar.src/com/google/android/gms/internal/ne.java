package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;

public class ne
  implements nf.a
{
  private final nf aks;
  private boolean akt;
  
  public ne(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, null);
  }
  
  public ne(Context paramContext, int paramInt, String paramString)
  {
    this(paramContext, paramInt, paramString, null, true);
  }
  
  public ne(Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.aks = new nf(paramContext, paramInt, paramString1, paramString2, this, paramBoolean);
    this.akt = true;
  }
  
  private void mR()
  {
    if (!this.akt) {
      throw new IllegalStateException("Cannot reuse one-time logger after sending.");
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    mR();
    this.aks.b(paramString, paramArrayOfByte, paramVarArgs);
  }
  
  public void b(PendingIntent paramPendingIntent)
  {
    Log.w("OneTimePlayLogger", "logger connection failed: " + paramPendingIntent);
  }
  
  public void mS()
  {
    this.aks.stop();
  }
  
  public void mT()
  {
    Log.w("OneTimePlayLogger", "logger connection failed");
  }
  
  public void send()
  {
    mR();
    this.aks.start();
    this.akt = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */