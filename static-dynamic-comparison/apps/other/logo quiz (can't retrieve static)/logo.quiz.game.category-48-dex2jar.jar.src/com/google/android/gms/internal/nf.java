package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class nf
{
  private final nn aku;
  private nl akv;
  
  public nf(Context paramContext, int paramInt, String paramString1, String paramString2, a parama, boolean paramBoolean)
  {
    String str = paramContext.getPackageName();
    try
    {
      int j = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.wtf("PlayLogger", "This can't happen.");
      }
    }
    this.akv = new nl(str, i, paramInt, paramString1, paramString2, paramBoolean);
    this.aku = new nn(paramContext, new nk(parama));
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    this.aku.b(this.akv, new nh(paramLong, paramString, paramArrayOfByte, paramVarArgs));
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    a(System.currentTimeMillis(), paramString, paramArrayOfByte, paramVarArgs);
  }
  
  public void start()
  {
    this.aku.start();
  }
  
  public void stop()
  {
    this.aku.stop();
  }
  
  public static abstract interface a
  {
    public abstract void b(PendingIntent paramPendingIntent);
    
    public abstract void mS();
    
    public abstract void mT();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */