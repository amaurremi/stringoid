package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DescriptionBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  private int a;
  private int b;
  private int c;
  
  public DescriptionBean()
  {
    this.a = 0;
    this.c = 480;
  }
  
  private DescriptionBean(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {}
    for (;;)
    {
      this.c = paramInt2;
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/DescriptionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */