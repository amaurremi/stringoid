package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.iy;
import com.google.android.gms.internal.iz;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new c();
  final int kg;
  final String qO;
  final long qP;
  final long qQ;
  private volatile String qR = null;
  
  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.kg = paramInt;
    this.qO = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      eg.r(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      eg.r(bool1);
      this.qP = paramLong1;
      this.qQ = paramLong2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2)
  {
    this(1, paramString, paramLong1, paramLong2);
  }
  
  public static DriveId ab(String paramString)
  {
    eg.f(paramString);
    return new DriveId(paramString, -1L, -1L);
  }
  
  static DriveId d(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      q localq;
      try
      {
        localq = q.e(paramArrayOfByte);
        if ("".equals(localq.rt))
        {
          paramArrayOfByte = null;
          return new DriveId(localq.versionCode, paramArrayOfByte, localq.ru, localq.rv);
        }
      }
      catch (iy paramArrayOfByte)
      {
        throw new IllegalArgumentException();
      }
      paramArrayOfByte = localq.rt;
    }
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    eg.b(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
    return d(Base64.decode(paramString.substring("DriveId:".length()), 10));
  }
  
  final byte[] cL()
  {
    q localq = new q();
    localq.versionCode = this.kg;
    if (this.qO == null) {}
    for (String str = "";; str = this.qO)
    {
      localq.rt = str;
      localq.ru = this.qP;
      localq.rv = this.qQ;
      return iz.a(localq);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.qR == null)
    {
      String str = Base64.encodeToString(cL(), 10);
      this.qR = ("DriveId:" + str);
    }
    return this.qR;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      return false;
      paramObject = (DriveId)paramObject;
      if (((DriveId)paramObject).qQ != this.qQ)
      {
        Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((((DriveId)paramObject).qP == -1L) && (this.qP == -1L)) {
        return ((DriveId)paramObject).qO.equals(this.qO);
      }
    } while (((DriveId)paramObject).qP != this.qP);
    return true;
  }
  
  public String getResourceId()
  {
    return this.qO;
  }
  
  public int hashCode()
  {
    if (this.qP == -1L) {
      return this.qO.hashCode();
    }
    return (String.valueOf(this.qQ) + String.valueOf(this.qP)).hashCode();
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */