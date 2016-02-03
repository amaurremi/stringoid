package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class go
  implements SafeParcelable, Geofence
{
  public static final gp CREATOR = new gp();
  private final int kg;
  private final int xA;
  private final String xs;
  private final int xt;
  private final short xv;
  private final double xw;
  private final double xx;
  private final float xy;
  private final int xz;
  private final long ye;
  
  public go(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    ap(paramString);
    b(paramFloat);
    a(paramDouble1, paramDouble2);
    paramInt2 = aV(paramInt2);
    this.kg = paramInt1;
    this.xv = paramShort;
    this.xs = paramString;
    this.xw = paramDouble1;
    this.xx = paramDouble2;
    this.xy = paramFloat;
    this.ye = paramLong;
    this.xt = paramInt2;
    this.xz = paramInt3;
    this.xA = paramInt4;
  }
  
  public go(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
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
  
  private static int aV(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  private static String aW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  private static void ap(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
  }
  
  private static void b(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
    }
  }
  
  public static go f(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.ai(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public short dK()
  {
    return this.xv;
  }
  
  public float dL()
  {
    return this.xy;
  }
  
  public int dM()
  {
    return this.xt;
  }
  
  public int dN()
  {
    return this.xA;
  }
  
  public int describeContents()
  {
    gp localgp = CREATOR;
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
      if (!(paramObject instanceof go)) {
        return false;
      }
      paramObject = (go)paramObject;
      if (this.xy != ((go)paramObject).xy) {
        return false;
      }
      if (this.xw != ((go)paramObject).xw) {
        return false;
      }
      if (this.xx != ((go)paramObject).xx) {
        return false;
      }
    } while (this.xv == ((go)paramObject).xv);
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.ye;
  }
  
  public double getLatitude()
  {
    return this.xw;
  }
  
  public double getLongitude()
  {
    return this.xx;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.xz;
  }
  
  public String getRequestId()
  {
    return this.xs;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.xw);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.xx);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.xy)) * 31 + this.xv) * 31 + this.xt;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { aW(this.xv), this.xs, Integer.valueOf(this.xt), Double.valueOf(this.xw), Double.valueOf(this.xx), Float.valueOf(this.xy), Integer.valueOf(this.xz / 1000), Integer.valueOf(this.xA), Long.valueOf(this.ye) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gp localgp = CREATOR;
    gp.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */