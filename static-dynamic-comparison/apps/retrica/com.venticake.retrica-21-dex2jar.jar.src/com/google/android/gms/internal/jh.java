package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class jh
  implements SafeParcelable, Geofence
{
  public static final ji CREATOR = new ji();
  private final String OB;
  private final long VZ;
  private final int Va;
  private final short Vc;
  private final double Vd;
  private final double Ve;
  private final float Vf;
  private final int Vg;
  private final int Vh;
  private final int xM;
  
  public jh(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    bq(paramString);
    b(paramFloat);
    a(paramDouble1, paramDouble2);
    paramInt2 = cM(paramInt2);
    this.xM = paramInt1;
    this.Vc = paramShort;
    this.OB = paramString;
    this.Vd = paramDouble1;
    this.Ve = paramDouble2;
    this.Vf = paramFloat;
    this.VZ = paramLong;
    this.Va = paramInt2;
    this.Vg = paramInt3;
    this.Vh = paramInt4;
  }
  
  public jh(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
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
  
  private static void bq(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
  }
  
  private static int cM(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  private static String cN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  public static jh h(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.bt(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int describeContents()
  {
    ji localji = CREATOR;
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
      if (!(paramObject instanceof jh)) {
        return false;
      }
      paramObject = (jh)paramObject;
      if (this.Vf != ((jh)paramObject).Vf) {
        return false;
      }
      if (this.Vd != ((jh)paramObject).Vd) {
        return false;
      }
      if (this.Ve != ((jh)paramObject).Ve) {
        return false;
      }
    } while (this.Vc == ((jh)paramObject).Vc);
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.VZ;
  }
  
  public double getLatitude()
  {
    return this.Vd;
  }
  
  public double getLongitude()
  {
    return this.Ve;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.Vg;
  }
  
  public String getRequestId()
  {
    return this.OB;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.Vd);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.Ve);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.Vf)) * 31 + this.Vc) * 31 + this.Va;
  }
  
  public short ja()
  {
    return this.Vc;
  }
  
  public float jb()
  {
    return this.Vf;
  }
  
  public int jc()
  {
    return this.Va;
  }
  
  public int jd()
  {
    return this.Vh;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { cN(this.Vc), this.OB, Integer.valueOf(this.Va), Double.valueOf(this.Vd), Double.valueOf(this.Ve), Float.valueOf(this.Vf), Integer.valueOf(this.Vg / 1000), Integer.valueOf(this.Vh), Long.valueOf(this.VZ) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ji localji = CREATOR;
    ji.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */