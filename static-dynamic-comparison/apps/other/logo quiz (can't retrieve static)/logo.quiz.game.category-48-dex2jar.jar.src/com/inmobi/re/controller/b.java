package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/controller/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */