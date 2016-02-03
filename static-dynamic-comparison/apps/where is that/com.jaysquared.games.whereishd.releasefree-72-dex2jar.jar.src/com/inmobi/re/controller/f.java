package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator<JSController.ExpandProperties>
{
  public JSController.ExpandProperties a(Parcel paramParcel)
  {
    return new JSController.ExpandProperties(paramParcel);
  }
  
  public JSController.ExpandProperties[] a(int paramInt)
  {
    return new JSController.ExpandProperties[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/controller/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */