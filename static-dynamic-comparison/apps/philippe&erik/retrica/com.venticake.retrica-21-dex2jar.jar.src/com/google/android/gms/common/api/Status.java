package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;

public final class Status
  implements Result, SafeParcelable
{
  public static final StatusCreator CREATOR = new StatusCreator();
  public static final Status En = new Status(0);
  public static final Status Eo = new Status(14);
  public static final Status Ep = new Status(8);
  public static final Status Eq = new Status(15);
  public static final Status Er = new Status(16);
  private final int CT;
  private final String Es;
  private final PendingIntent mPendingIntent;
  private final int xM;
  
  public Status(int paramInt)
  {
    this(1, paramInt, null, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.xM = paramInt1;
    this.CT = paramInt2;
    this.Es = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String ex()
  {
    if (this.Es != null) {
      return this.Es;
    }
    return CommonStatusCodes.getStatusCodeString(this.CT);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  PendingIntent eQ()
  {
    return this.mPendingIntent;
  }
  
  @Deprecated
  public ConnectionResult eR()
  {
    return new ConnectionResult(this.CT, this.mPendingIntent);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((this.xM != ((Status)paramObject).xM) || (this.CT != ((Status)paramObject).CT) || (!hk.equal(this.Es, ((Status)paramObject).Es)) || (!hk.equal(this.mPendingIntent, ((Status)paramObject).mPendingIntent)));
    return true;
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
    return this.CT;
  }
  
  public String getStatusMessage()
  {
    return this.Es;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.xM), Integer.valueOf(this.CT), this.Es, this.mPendingIntent });
  }
  
  public boolean isCanceled()
  {
    return this.CT == 16;
  }
  
  public boolean isInterrupted()
  {
    return this.CT == 14;
  }
  
  public boolean isSuccess()
  {
    return this.CT <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    return hk.e(this).a("statusCode", ex()).a("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StatusCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */