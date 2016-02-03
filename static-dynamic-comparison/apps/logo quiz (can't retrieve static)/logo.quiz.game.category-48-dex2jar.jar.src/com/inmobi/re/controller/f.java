package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator<JSController.ResizeProperties>
{
  public JSController.ResizeProperties a(Parcel paramParcel)
  {
    return new JSController.ResizeProperties(paramParcel);
  }
  
  public JSController.ResizeProperties[] a(int paramInt)
  {
    return new JSController.ResizeProperties[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/controller/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */