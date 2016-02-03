package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class hj
  implements SafeParcelable
{
  public static final ep Na = new ep();
  private final long MS;
  private final short MT;
  private final double MU;
  private final double MV;
  private final float MW;
  private final int MX;
  private final int MY;
  private final int MZ;
  private final int qh;
  private final String wF;
  
  public hj(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    aX(paramString);
    h(paramFloat);
    a(paramDouble1, paramDouble2);
    paramInt2 = cT(paramInt2);
    this.qh = paramInt1;
    this.MT = paramShort;
    this.wF = paramString;
    this.MU = paramDouble1;
    this.MV = paramDouble2;
    this.MW = paramFloat;
    this.MS = paramLong;
    this.MX = paramInt2;
    this.MY = paramInt3;
    this.MZ = paramInt4;
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
  
  private static void aX(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
  }
  
  private static int cT(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  private static String cU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  private static void h(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
    }
  }
  
  public int describeContents()
  {
    ep localep = Na;
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
      if (!(paramObject instanceof hj)) {
        return false;
      }
      paramObject = (hj)paramObject;
      if (this.MW != ((hj)paramObject).MW) {
        return false;
      }
      if (this.MU != ((hj)paramObject).MU) {
        return false;
      }
      if (this.MV != ((hj)paramObject).MV) {
        return false;
      }
    } while (this.MT == ((hj)paramObject).MT);
    return false;
  }
  
  public double getLatitude()
  {
    return this.MU;
  }
  
  public double getLongitude()
  {
    return this.MV;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.MY;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.MU);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.MV);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.MW)) * 31 + this.MT) * 31 + this.MX;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public String oE()
  {
    return this.wF;
  }
  
  public short ri()
  {
    return this.MT;
  }
  
  public float rj()
  {
    return this.MW;
  }
  
  public long rk()
  {
    return this.MS;
  }
  
  public int rl()
  {
    return this.MX;
  }
  
  public int rm()
  {
    return this.MZ;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { cU(this.MT), this.wF, Integer.valueOf(this.MX), Double.valueOf(this.MU), Double.valueOf(this.MV), Float.valueOf(this.MW), Integer.valueOf(this.MY / 1000), Integer.valueOf(this.MZ), Long.valueOf(this.MS) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ep localep = Na;
    ep.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */