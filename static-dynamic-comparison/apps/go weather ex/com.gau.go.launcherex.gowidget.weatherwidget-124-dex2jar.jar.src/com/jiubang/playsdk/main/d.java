package com.jiubang.playsdk.main;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator
{
  public BitmapBean a(Parcel paramParcel)
  {
    BitmapBean localBitmapBean = new BitmapBean();
    BitmapBean.a(localBitmapBean, paramParcel.readString());
    BitmapBean.a(localBitmapBean, (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    return localBitmapBean;
  }
  
  public BitmapBean[] a(int paramInt)
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/main/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */