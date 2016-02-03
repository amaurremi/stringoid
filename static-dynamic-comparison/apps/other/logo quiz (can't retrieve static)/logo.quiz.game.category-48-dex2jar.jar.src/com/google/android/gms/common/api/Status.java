package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status
  implements Result, SafeParcelable
{
  public static final StatusCreator CREATOR = new StatusCreator();
  public static final Status Jo = new Status(0);
  public static final Status Jp = new Status(14);
  public static final Status Jq = new Status(8);
  public static final Status Jr = new Status(15);
  public static final Status Js = new Status(16);
  private final int BR;
  private final int HF;
  private final String Jt;
  private final PendingIntent mPendingIntent;
  
  public Status(int paramInt)
  {
    this(1, paramInt, null, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.BR = paramInt1;
    this.HF = paramInt2;
    this.Jt = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String fY()
  {
    if (this.Jt != null) {
      return this.Jt;
    }
    return CommonStatusCodes.getStatusCodeString(this.HF);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((this.BR != ((Status)paramObject).BR) || (this.HF != ((Status)paramObject).HF) || (!m.equal(this.Jt, ((Status)paramObject).Jt)) || (!m.equal(this.mPendingIntent, ((Status)paramObject).mPendingIntent)));
    return true;
  }
  
  PendingIntent getPendingIntent()
  {
    return this.mPendingIntent;
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.HF;
  }
  
  public String getStatusMessage()
  {
    return this.Jt;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  @Deprecated
  public ConnectionResult gu()
  {
    return new ConnectionResult(this.HF, this.mPendingIntent);
  }
  
  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.BR), Integer.valueOf(this.HF), this.Jt, this.mPendingIntent });
  }
  
  public boolean isCanceled()
  {
    return this.HF == 16;
  }
  
  public boolean isInterrupted()
  {
    return this.HF == 14;
  }
  
  public boolean isSuccess()
  {
    return this.HF <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    return m.h(this).a("statusCode", fY()).a("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StatusCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */