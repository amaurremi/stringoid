package com.pocket.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class DrawerLayoutNoMinMargin$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public DrawerLayoutNoMinMargin.SavedState a(Parcel paramAnonymousParcel)
    {
      return new DrawerLayoutNoMinMargin.SavedState(paramAnonymousParcel);
    }
    
    public DrawerLayoutNoMinMargin.SavedState[] a(int paramAnonymousInt)
    {
      return new DrawerLayoutNoMinMargin.SavedState[paramAnonymousInt];
    }
  };
  int a = 0;
  int b = 0;
  int c = 0;
  
  public DrawerLayoutNoMinMargin$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readInt();
  }
  
  public DrawerLayoutNoMinMargin$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/DrawerLayoutNoMinMargin$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */