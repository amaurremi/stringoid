package com.google.android.gms.auth.api;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

public class GoogleAuthApiException
  extends Exception
{
  private Status CM;
  private PendingIntent mPendingIntent;
  
  public GoogleAuthApiException(String paramString, Status paramStatus)
  {
    super(paramString);
    this.CM = paramStatus;
  }
  
  public GoogleAuthApiException(String paramString, Status paramStatus, PendingIntent paramPendingIntent)
  {
    super(paramString);
    this.CM = paramStatus;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public PendingIntent getPendingIntent()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this.CM;
  }
  
  public boolean isUserRecoverable()
  {
    return this.mPendingIntent != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/auth/api/GoogleAuthApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */