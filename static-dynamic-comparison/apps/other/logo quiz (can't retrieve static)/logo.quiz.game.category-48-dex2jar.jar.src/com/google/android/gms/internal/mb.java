package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class mb
  implements SafeParcelable, Geofence
{
  public static final mc CREATOR = new mc();
  private final int BR;
  private final String Xr;
  private final int adW;
  private final short adY;
  private final double adZ;
  private final double aea;
  private final float aeb;
  private final int aec;
  private final int aed;
  private final long afb;
  
  public mb(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    bV(paramString);
    b(paramFloat);
    a(paramDouble1, paramDouble2);
    paramInt2 = ej(paramInt2);
    this.BR = paramInt1;
    this.adY = paramShort;
    this.Xr = paramString;
    this.adZ = paramDouble1;
    this.aea = paramDouble2;
    this.aeb = paramFloat;
    this.afb = paramLong;
    this.adW = paramInt2;
    this.aec = paramInt3;
    this.aed = paramInt4;
  }
  
  public mb(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }
  
  private static void a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    }
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
    }
  }
  
  private static void b(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
    }
  }
  
  private static void bV(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
  }
  
  private static int ej(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  private static String ek(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  public static mb h(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.cw(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int describeContents()
  {
    mc localmc = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof mb)) {
        return false;
      }
      paramObject = (mb)paramObject;
      if (this.aeb != ((mb)paramObject).aeb) {
        return false;
      }
      if (this.adZ != ((mb)paramObject).adZ) {
        return false;
      }
      if (this.aea != ((mb)paramObject).aea) {
        return false;
      }
    } while (this.adY == ((mb)paramObject).adY);
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.afb;
  }
  
  public double getLatitude()
  {
    return this.adZ;
  }
  
  public double getLongitude()
  {
    return this.aea;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.aec;
  }
  
  public String getRequestId()
  {
    return this.Xr;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.adZ);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.aea);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.aeb)) * 31 + this.adY) * 31 + this.adW;
  }
  
  public short lY()
  {
    return this.adY;
  }
  
  public float lZ()
  {
    return this.aeb;
  }
  
  public int ma()
  {
    return this.adW;
  }
  
  public int mb()
  {
    return this.aed;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { ek(this.adY), this.Xr, Integer.valueOf(this.adW), Double.valueOf(this.adZ), Double.valueOf(this.aea), Float.valueOf(this.aeb), Integer.valueOf(this.aec / 1000), Integer.valueOf(this.aed), Long.valueOf(this.afb) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mc localmc = CREATOR;
    mc.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */