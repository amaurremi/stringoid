package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.ah;
import com.google.android.gms.drive.internal.v;
import com.google.android.gms.internal.pl;
import com.google.android.gms.internal.pm;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new c();
  final int BR;
  final String Na;
  final long Nb;
  final long Nc;
  private volatile String Nd = null;
  
  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.BR = paramInt;
    this.Na = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      n.K(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      n.K(bool1);
      this.Nb = paramLong1;
      this.Nc = paramLong2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2)
  {
    this(1, paramString, paramLong1, paramLong2);
  }
  
  public static DriveId bg(String paramString)
  {
    n.i(paramString);
    return new DriveId(paramString, -1L, -1L);
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    n.b(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
    return f(Base64.decode(paramString.substring("DriveId:".length()), 10));
  }
  
  static DriveId f(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      ah localah;
      try
      {
        localah = ah.g(paramArrayOfByte);
        if ("".equals(localah.Pd))
        {
          paramArrayOfByte = null;
          return new DriveId(localah.versionCode, paramArrayOfByte, localah.Pe, localah.Pf);
        }
      }
      catch (pl paramArrayOfByte)
      {
        throw new IllegalArgumentException();
      }
      paramArrayOfByte = localah.Pd;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.Nd == null)
    {
      String str = Base64.encodeToString(hN(), 10);
      this.Nd = ("DriveId:" + str);
    }
    return this.Nd;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      return false;
      paramObject = (DriveId)paramObject;
      if (((DriveId)paramObject).Nc != this.Nc)
      {
        v.p("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((((DriveId)paramObject).Nb == -1L) && (this.Nb == -1L)) {
        return ((DriveId)paramObject).Na.equals(this.Na);
      }
    } while (((DriveId)paramObject).Nb != this.Nb);
    return true;
  }
  
  public String getResourceId()
  {
    return this.Na;
  }
  
  final byte[] hN()
  {
    ah localah = new ah();
    localah.versionCode = this.BR;
    if (this.Na == null) {}
    for (String str = "";; str = this.Na)
    {
      localah.Pd = str;
      localah.Pe = this.Nb;
      localah.Pf = this.Nc;
      return pm.f(localah);
    }
  }
  
  public int hashCode()
  {
    if (this.Nb == -1L) {
      return this.Na.hashCode();
    }
    return (String.valueOf(this.Nc) + String.valueOf(this.Nb)).hashCode();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */