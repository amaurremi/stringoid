package com.gau.go.launcherex.gowidget.weather.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FeedbackBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new e();
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private int g;
  
  public FeedbackBean()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = "";
  }
  
  private FeedbackBean(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String a(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Problem type：" + this.g + ". " + this.b + "\n");
    localStringBuffer.append("User city：" + this.c + "\n");
    localStringBuffer.append("Content：" + this.d + "\n");
    if (this.e != null) {
      localStringBuffer.append("Weather Info：" + this.e + "\n");
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        localStringBuffer.append("Version Name: " + paramContext);
        return localStringBuffer.toString();
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
        continue;
        paramContext = "unknow";
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public void e(String paramString)
  {
    this.f = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/FeedbackBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */