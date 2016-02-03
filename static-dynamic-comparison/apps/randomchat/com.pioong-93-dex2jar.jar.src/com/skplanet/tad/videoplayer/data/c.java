package com.skplanet.tad.videoplayer.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.telephony.TelephonyManager;
import com.skplanet.tad.videoplayer.util.b;

public class c
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public c a(Parcel paramAnonymousParcel)
    {
      return new c(paramAnonymousParcel);
    }
    
    public c[] a(int paramAnonymousInt)
    {
      return new c[paramAnonymousInt];
    }
  };
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f = "";
  public String g = "";
  public String h = "";
  
  public c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    a(paramContext);
  }
  
  public c(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  private void a(Context paramContext)
  {
    try
    {
      this.f = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      this.f = (this.f.substring(0, this.f.length() - 4) + "0000");
      b.a("uniqueId:" + this.f);
      b.a("Build.MODEL:" + Build.MODEL);
      b.a("Build.VERSION.RELEASE:" + Build.VERSION.RELEASE);
      this.g = Build.MODEL;
      this.h = ("Android_" + Build.VERSION.RELEASE);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public String a()
  {
    return b() + "|" + e() + "|" + f() + "|" + g() + "|" + c() + "|" + d();
  }
  
  public String b()
  {
    return "Cookie=" + this.a;
  }
  
  public String c()
  {
    return "Ads_ID=" + this.b;
  }
  
  public String d()
  {
    return "App_ID=" + this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return "Device_UID=" + this.f;
  }
  
  public String f()
  {
    return "Device_Name=" + this.g;
  }
  
  public String g()
  {
    return "OS_Version=" + this.h;
  }
  
  public String toString()
  {
    return "RequestData [cookie=" + this.a + ", adsID=" + this.b + ", appID=" + this.c + ", metaURL=" + this.d + ", multimedia=" + this.e + ", deviceId=" + this.f + ", deviceName=" + this.g + ", osVersion=" + this.h + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */