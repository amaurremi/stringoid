package com.jiubang.playsdk.main;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BitmapBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new d();
  private Bitmap a;
  private String b;
  
  public BitmapBean() {}
  
  public BitmapBean(Bitmap paramBitmap, String paramString)
  {
    this.a = paramBitmap;
    this.b = paramString;
  }
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.a, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/main/BitmapBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */