package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.al;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.gj;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new l();
  final int qh;
  final String sQ;
  final long sR;
  final long sS;
  private volatile String sT = null;
  
  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.qh = paramInt;
    this.sQ = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      dc.I(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      dc.I(bool1);
      this.sR = paramLong1;
      this.sS = paramLong2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2)
  {
    this(1, paramString, paramLong1, paramLong2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      return false;
      paramObject = (DriveId)paramObject;
      if (((DriveId)paramObject).sS != this.sS)
      {
        Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((((DriveId)paramObject).sR == -1L) && (this.sR == -1L)) {
        return ((DriveId)paramObject).sQ.equals(this.sQ);
      }
    } while (((DriveId)paramObject).sR != this.sR);
    return true;
  }
  
  public int hashCode()
  {
    if (this.sR == -1L) {
      return this.sQ.hashCode();
    }
    return (String.valueOf(this.sS) + String.valueOf(this.sR)).hashCode();
  }
  
  public final String mT()
  {
    if (this.sT == null)
    {
      String str = Base64.encodeToString(mU(), 10);
      this.sT = ("DriveId:" + str);
    }
    return this.sT;
  }
  
  final byte[] mU()
  {
    al localal = new al();
    localal.versionCode = this.qh;
    if (this.sQ == null) {}
    for (String str = "";; str = this.sQ)
    {
      localal.tU = str;
      localal.tV = this.sR;
      localal.tW = this.sS;
      return gj.c(localal);
    }
  }
  
  public String toString()
  {
    return mT();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */