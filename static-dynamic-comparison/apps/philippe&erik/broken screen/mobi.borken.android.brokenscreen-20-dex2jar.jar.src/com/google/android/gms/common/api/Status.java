package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class Status
  implements Result, SafeParcelable
{
  public static final StatusCreator CREATOR = new StatusCreator();
  public static final Status Ek = new Status(0);
  public static final Status El = new Status(14);
  public static final Status Em = new Status(8);
  public static final Status En = new Status(15);
  public static final Status Eo = new Status(16);
  private final int CQ;
  private final String Ep;
  private final PendingIntent mPendingIntent;
  private final int xJ;
  
  public Status(int paramInt)
  {
    this(1, paramInt, null, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.xJ = paramInt1;
    this.CQ = paramInt2;
    this.Ep = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String es()
  {
    if (this.Ep != null) {
      return this.Ep;
    }
    return CommonStatusCodes.getStatusCodeString(this.CQ);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  PendingIntent eL()
  {
    return this.mPendingIntent;
  }
  
  @Deprecated
  public ConnectionResult eM()
  {
    return new ConnectionResult(this.CQ, this.mPendingIntent);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((this.xJ != ((Status)paramObject).xJ) || (this.CQ != ((Status)paramObject).CQ) || (!hl.equal(this.Ep, ((Status)paramObject).Ep)) || (!hl.equal(this.mPendingIntent, ((Status)paramObject).mPendingIntent)));
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
    return this.CQ;
  }
  
  public String getStatusMessage()
  {
    return this.Ep;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.xJ), Integer.valueOf(this.CQ), this.Ep, this.mPendingIntent });
  }
  
  public boolean isCanceled()
  {
    return this.CQ == 16;
  }
  
  public boolean isInterrupted()
  {
    return this.CQ == 14;
  }
  
  public boolean isSuccess()
  {
    return this.CQ <= 0;
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
    return hl.e(this).a("statusCode", es()).a("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StatusCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */