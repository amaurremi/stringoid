package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<JSController.Dimensions>
{
  public JSController.Dimensions a(Parcel paramParcel)
  {
    return new JSController.Dimensions(paramParcel);
  }
  
  public JSController.Dimensions[] a(int paramInt)
  {
    return new JSController.Dimensions[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/controller/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */