package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gi;
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
  private String Ah;
  String Ai;
  private Inet4Address Aj;
  private String Ak;
  private String Al;
  private String Am;
  private int An;
  private List<WebImage> Ao;
  private int Ap;
  private final int xM;
  
  private CastDevice()
  {
    this(2, null, null, null, null, null, -1, new ArrayList(), 0);
  }
  
  CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList, int paramInt3)
  {
    this.xM = paramInt1;
    this.Ah = paramString1;
    this.Ai = paramString2;
    if (this.Ai != null) {}
    try
    {
      paramString1 = InetAddress.getByName(this.Ai);
      if ((paramString1 instanceof Inet4Address)) {
        this.Aj = ((Inet4Address)paramString1);
      }
      this.Ak = paramString3;
      this.Al = paramString4;
      this.Am = paramString5;
      this.An = paramInt2;
      this.Ao = paramList;
      this.Ap = paramInt3;
      return;
    }
    catch (UnknownHostException paramString1)
    {
      for (;;)
      {
        this.Aj = null;
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
    } while ((gi.a(this.Ah, ((CastDevice)paramObject).Ah)) && (gi.a(this.Aj, ((CastDevice)paramObject).Aj)) && (gi.a(this.Al, ((CastDevice)paramObject).Al)) && (gi.a(this.Ak, ((CastDevice)paramObject).Ak)) && (gi.a(this.Am, ((CastDevice)paramObject).Am)) && (this.An == ((CastDevice)paramObject).An) && (gi.a(this.Ao, ((CastDevice)paramObject).Ao)) && (this.Ap == ((CastDevice)paramObject).Ap));
    return false;
  }
  
  public int getCapabilities()
  {
    return this.Ap;
  }
  
  public String getDeviceId()
  {
    return this.Ah;
  }
  
  public String getDeviceVersion()
  {
    return this.Am;
  }
  
  public String getFriendlyName()
  {
    return this.Ak;
  }
  
  public WebImage getIcon(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (this.Ao.isEmpty()) {
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return (WebImage)this.Ao.get(0);
    }
    Iterator localIterator = this.Ao.iterator();
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
            localObject2 = (WebImage)this.Ao.get(0);
          }
        }
      }
    }
  }
  
  public List<WebImage> getIcons()
  {
    return Collections.unmodifiableList(this.Ao);
  }
  
  public Inet4Address getIpAddress()
  {
    return this.Aj;
  }
  
  public String getModelName()
  {
    return this.Al;
  }
  
  public int getServicePort()
  {
    return this.An;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasIcons()
  {
    return !this.Ao.isEmpty();
  }
  
  public int hashCode()
  {
    if (this.Ah == null) {
      return 0;
    }
    return this.Ah.hashCode();
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
    return gi.a(getDeviceId(), paramCastDevice.getDeviceId());
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
    return String.format("\"%s\" (%s)", new Object[] { this.Ak, this.Ah });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/CastDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */