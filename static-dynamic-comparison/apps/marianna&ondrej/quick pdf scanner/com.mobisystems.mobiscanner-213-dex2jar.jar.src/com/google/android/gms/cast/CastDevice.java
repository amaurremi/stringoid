package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cm;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<CastDevice> CREATOR = new b();
  private final int qh;
  private String qn;
  String qo;
  private Inet4Address qp;
  private String qq;
  private String qr;
  private String qs;
  private int qt;
  private List<WebImage> qu;
  
  private CastDevice()
  {
    this(1, null, null, null, null, null, -1, new ArrayList());
  }
  
  CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList)
  {
    this.qh = paramInt1;
    this.qn = paramString1;
    this.qo = paramString2;
    if (this.qo != null) {}
    try
    {
      paramString1 = InetAddress.getByName(this.qo);
      if ((paramString1 instanceof Inet4Address)) {
        this.qp = ((Inet4Address)paramString1);
      }
      this.qq = paramString3;
      this.qr = paramString4;
      this.qs = paramString5;
      this.qt = paramInt2;
      this.qu = paramList;
      return;
    }
    catch (UnknownHostException paramString1)
    {
      for (;;)
      {
        this.qp = null;
      }
    }
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
    } while ((cm.d(this.qn, ((CastDevice)paramObject).qn)) && (cm.d(this.qp, ((CastDevice)paramObject).qp)) && (cm.d(this.qr, ((CastDevice)paramObject).qr)) && (cm.d(this.qq, ((CastDevice)paramObject).qq)) && (cm.d(this.qs, ((CastDevice)paramObject).qs)) && (this.qt == ((CastDevice)paramObject).qt) && (cm.d(this.qu, ((CastDevice)paramObject).qu)));
    return false;
  }
  
  public String getDeviceId()
  {
    return this.qn;
  }
  
  public int hashCode()
  {
    if (this.qn == null) {
      return 0;
    }
    return this.qn.hashCode();
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public String mc()
  {
    return this.qq;
  }
  
  public String md()
  {
    return this.qr;
  }
  
  public String me()
  {
    return this.qs;
  }
  
  public int mf()
  {
    return this.qt;
  }
  
  public List<WebImage> mg()
  {
    return Collections.unmodifiableList(this.qu);
  }
  
  public String toString()
  {
    return String.format("\"%s\" (%s)", new Object[] { this.qq, this.qn });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/cast/CastDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */