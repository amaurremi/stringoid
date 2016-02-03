package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;

public final class Status
  implements Result, SafeParcelable
{
  public static final StatusCreator CREATOR = new StatusCreator();
  public static final Status nA = new Status(0, null, null);
  public static final Status nB = new Status(14, null, null);
  public static final Status nC = new Status(15, null, null);
  private final int kg;
  private final int mC;
  private final PendingIntent mPendingIntent;
  private final String nD;
  
  public Status(int paramInt)
  {
    this(1, paramInt, null, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.kg = paramInt1;
    this.mC = paramInt2;
    this.nD = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String bh()
  {
    if (this.nD != null) {
      return this.nD;
    }
    return CommonStatusCodes.getStatusCodeString(this.mC);
  }
  
  PendingIntent bs()
  {
    return this.mPendingIntent;
  }
  
  String bt()
  {
    return this.nD;
  }
  
  @Deprecated
  public ConnectionResult bu()
  {
    return new ConnectionResult(this.mC, this.mPendingIntent);
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
    } while ((this.kg != ((Status)paramObject).kg) || (this.mC != ((Status)paramObject).mC) || (!ee.equal(this.nD, ((Status)paramObject).nD)) || (!ee.equal(this.mPendingIntent, ((Status)paramObject).mPendingIntent)));
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
    return this.mC;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { Integer.valueOf(this.kg), Integer.valueOf(this.mC), this.nD, this.mPendingIntent });
  }
  
  public boolean isInterrupted()
  {
    return this.mC == 14;
  }
  
  public boolean isSuccess()
  {
    return this.mC <= 0;
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
    return ee.e(this).a("statusCode", bh()).a("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StatusCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */