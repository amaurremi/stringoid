package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gj;
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
  private String Ae;
  String Af;
  private Inet4Address Ag;
  private String Ah;
  private String Ai;
  private String Aj;
  private int Ak;
  private List<WebImage> Al;
  private int Am;
  private final int xJ;
  
  private CastDevice()
  {
    this(2, null, null, null, null, null, -1, new ArrayList(), 0);
  }
  
  CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList, int paramInt3)
  {
    this.xJ = paramInt1;
    this.Ae = paramString1;
    this.Af = paramString2;
    if (this.Af != null) {}
    try
    {
      paramString1 = InetAddress.getByName(this.Af);
      if ((paramString1 instanceof Inet4Address)) {
        this.Ag = ((Inet4Address)paramString1);
      }
      this.Ah = paramString3;
      this.Ai = paramString4;
      this.Aj = paramString5;
      this.Ak = paramInt2;
      this.Al = paramList;
      this.Am = paramInt3;
      return;
    }
    catch (UnknownHostException paramString1)
    {
      for (;;)
      {
        this.Ag = null;
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
    } while ((gj.a(this.Ae, ((CastDevice)paramObject).Ae)) && (gj.a(this.Ag, ((CastDevice)paramObject).Ag)) && (gj.a(this.Ai, ((CastDevice)paramObject).Ai)) && (gj.a(this.Ah, ((CastDevice)paramObject).Ah)) && (gj.a(this.Aj, ((CastDevice)paramObject).Aj)) && (this.Ak == ((CastDevice)paramObject).Ak) && (gj.a(this.Al, ((CastDevice)paramObject).Al)) && (this.Am == ((CastDevice)paramObject).Am));
    return false;
  }
  
  public int getCapabilities()
  {
    return this.Am;
  }
  
  public String getDeviceId()
  {
    return this.Ae;
  }
  
  public String getDeviceVersion()
  {
    return this.Aj;
  }
  
  public String getFriendlyName()
  {
    return this.Ah;
  }
  
  public WebImage getIcon(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (this.Al.isEmpty()) {
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return (WebImage)this.Al.get(0);
    }
    Iterator localIterator = this.Al.iterator();
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
            localObject2 = (WebImage)this.Al.get(0);
          }
        }
      }
    }
  }
  
  public List<WebImage> getIcons()
  {
    return Collections.unmodifiableList(this.Al);
  }
  
  public Inet4Address getIpAddress()
  {
    return this.Ag;
  }
  
  public String getModelName()
  {
    return this.Ai;
  }
  
  public int getServicePort()
  {
    return this.Ak;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean hasIcons()
  {
    return !this.Al.isEmpty();
  }
  
  public int hashCode()
  {
    if (this.Ae == null) {
      return 0;
    }
    return this.Ae.hashCode();
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
    return gj.a(getDeviceId(), paramCastDevice.getDeviceId());
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
    return String.format("\"%s\" (%s)", new Object[] { this.Ah, this.Ae });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/cast/CastDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */