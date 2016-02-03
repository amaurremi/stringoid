package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;

public final class Status
  implements f, SafeParcelable
{
  public static final Status rc = new Status(0, null, null);
  public static final Status rd = new Status(14, null, null);
  public static final Status re = new Status(15, null, null);
  public static final i rf = new i();
  private final int qh;
  private final PendingIntent qw;
  private final int qx;
  private final String rg;
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.qh = paramInt1;
    this.qx = paramInt2;
    this.rg = paramString;
    this.qw = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String mi()
  {
    if (this.rg != null) {
      return this.rg;
    }
    return b.bk(this.qx);
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
    } while ((this.qh != ((Status)paramObject).qh) || (this.qx != ((Status)paramObject).qx) || (!cz.b(this.rg, ((Status)paramObject).rg)) || (!cz.b(this.qw, ((Status)paramObject).qw)));
    return true;
  }
  
  public int getStatusCode()
  {
    return this.qx;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { Integer.valueOf(this.qh), Integer.valueOf(this.qx), this.rg, this.qw });
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public Status mq()
  {
    return this;
  }
  
  PendingIntent ms()
  {
    return this.qw;
  }
  
  String mt()
  {
    return this.rg;
  }
  
  public boolean mu()
  {
    return this.qx <= 0;
  }
  
  public String toString()
  {
    return cz.M(this).a("statusCode", mi()).a("resolution", this.qw).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */