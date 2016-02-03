package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ji
  implements SafeParcelable, Geofence
{
  public static final jj CREATOR = new jj();
  private final String Oy;
  private final int UX;
  private final short UZ;
  private final long VW;
  private final double Va;
  private final double Vb;
  private final float Vc;
  private final int Vd;
  private final int Ve;
  private final int xJ;
  
  public ji(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    bq(paramString);
    b(paramFloat);
    a(paramDouble1, paramDouble2);
    paramInt2 = cM(paramInt2);
    this.xJ = paramInt1;
    this.UZ = paramShort;
    this.Oy = paramString;
    this.Va = paramDouble1;
    this.Vb = paramDouble2;
    this.Vc = paramFloat;
    this.VW = paramLong;
    this.UX = paramInt2;
    this.Vd = paramInt3;
    this.Ve = paramInt4;
  }
  
  public ji(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
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
  
  public static ji h(byte[] paramArrayOfByte)
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
    jj localjj = CREATOR;
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
      if (!(paramObject instanceof ji)) {
        return false;
      }
      paramObject = (ji)paramObject;
      if (this.Vc != ((ji)paramObject).Vc) {
        return false;
      }
      if (this.Va != ((ji)paramObject).Va) {
        return false;
      }
      if (this.Vb != ((ji)paramObject).Vb) {
        return false;
      }
    } while (this.UZ == ((ji)paramObject).UZ);
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.VW;
  }
  
  public double getLatitude()
  {
    return this.Va;
  }
  
  public double getLongitude()
  {
    return this.Vb;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.Vd;
  }
  
  public String getRequestId()
  {
    return this.Oy;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.Va);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.Vb);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.Vc)) * 31 + this.UZ) * 31 + this.UX;
  }
  
  public short iV()
  {
    return this.UZ;
  }
  
  public float iW()
  {
    return this.Vc;
  }
  
  public int iX()
  {
    return this.UX;
  }
  
  public int iY()
  {
    return this.Ve;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { cN(this.UZ), this.Oy, Integer.valueOf(this.UX), Double.valueOf(this.Va), Double.valueOf(this.Vb), Float.valueOf(this.Vc), Integer.valueOf(this.Vd / 1000), Integer.valueOf(this.Ve), Long.valueOf(this.VW) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jj localjj = CREATOR;
    jj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */