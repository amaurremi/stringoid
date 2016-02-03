package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dh;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<CastDevice> CREATOR = new b();
  String kA;
  private Inet4Address kB;
  private String kC;
  private String kD;
  private String kE;
  private int kF;
  private List<WebImage> kG;
  private final int kg;
  private String kz;
  
  private CastDevice()
  {
    this(1, null, null, null, null, null, -1, new ArrayList());
  }
  
  CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList)
  {
    this.kg = paramInt1;
    this.kz = paramString1;
    this.kA = paramString2;
    if (this.kA != null) {}
    try
    {
      paramString1 = InetAddress.getByName(this.kA);
      if ((paramString1 instanceof Inet4Address)) {
        this.kB = ((Inet4Address)paramString1);
      }
      this.kC = paramString3;
      this.kD = paramString4;
      this.kE = paramString5;
      this.kF = paramInt2;
      this.kG = paramList;
      return;
    }
    catch (UnknownHostException paramString1)
    {
      for (;;)
      {
        this.kB = null;
      }
    }
  }
  
  public static CastDevice getFromBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(CastDevice.class.getClassLoader());
    return (CastDevice)paramBundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      do
      {
        return true;
        if (!(paramObject instanceof CastDevice)) {
          return false;
        }
        paramObject = (CastDevice)paramObject;
        if (getDeviceId() != null) {
          break;
        }
      } while (((CastDevice)paramObject).getDeviceId() == null);
      return false;
    } while ((dh.a(this.kz, ((CastDevice)paramObject).kz)) && (dh.a(this.kB, ((CastDevice)paramObject).kB)) && (dh.a(this.kD, ((CastDevice)paramObject).kD)) && (dh.a(this.kC, ((CastDevice)paramObject).kC)) && (dh.a(this.kE, ((CastDevice)paramObject).kE)) && (this.kF == ((CastDevice)paramObject).kF) && (dh.a(this.kG, ((CastDevice)paramObject).kG)));
    return false;
  }
  
  public String getDeviceId()
  {
    return this.kz;
  }
  
  public String getDeviceVersion()
  {
    return this.kE;
  }
  
  public String getFriendlyName()
  {
    return this.kC;
  }
  
  public WebImage getIcon(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (this.kG.isEmpty()) {
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return (WebImage)this.kG.get(0);
    }
    Iterator localIterator = this.kG.iterator();
    Object localObject2 = null;
    WebImage localWebImage;
    int i;
    int j;
    if (localIterator.hasNext())
    {
      localWebImage = (WebImage)localIterator.next();
      i = localWebImage.getWidth();
      j = localWebImage.getHeight();
      if ((i >= paramInt1) && (j >= paramInt2))
      {
        if ((localObject2 != null) && ((((WebImage)localObject2).getWidth() <= i) || (((WebImage)localObject2).getHeight() <= j))) {
          break label210;
        }
        localObject2 = localWebImage;
      }
    }
    label210:
    for (;;)
    {
      break;
      if ((i < paramInt1) && (j < paramInt2) && ((localObject1 == null) || ((((WebImage)localObject1).getWidth() < i) && (((WebImage)localObject1).getHeight() < j))))
      {
        localObject1 = localWebImage;
        continue;
        if (localObject2 != null) {}
        for (;;)
        {
          return (WebImage)localObject2;
          if (localObject1 != null) {
            localObject2 = localObject1;
          } else {
            localObject2 = (WebImage)this.kG.get(0);
          }
        }
      }
    }
  }
  
  public List<WebImage> getIcons()
  {
    return Collections.unmodifiableList(this.kG);
  }
  
  public Inet4Address getIpAddress()
  {
    return this.kB;
  }
  
  public String getModelName()
  {
    return this.kD;
  }
  
  public int getServicePort()
  {
    return this.kF;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public boolean hasIcons()
  {
    return !this.kG.isEmpty();
  }
  
  public int hashCode()
  {
    if (this.kz == null) {
      return 0;
    }
    return this.kz.hashCode();
  }
  
  public boolean isSameDevice(CastDevice paramCastDevice)
  {
    if (paramCastDevice == null) {}
    do
    {
      return false;
      if (getDeviceId() != null) {
        break;
      }
    } while (paramCastDevice.getDeviceId() != null);
    return true;
    return dh.a(getDeviceId(), paramCastDevice.getDeviceId());
  }
  
  public void putInBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
  }
  
  public String toString()
  {
    return String.format("\"%s\" (%s)", new Object[] { this.kC, this.kz });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/cast/CastDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */