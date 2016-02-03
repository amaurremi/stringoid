package com.ideashower.readitlater.views;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class CheckableImageButton$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public CheckableImageButton.SavedState a(Parcel paramAnonymousParcel)
    {
      return new CheckableImageButton.SavedState(paramAnonymousParcel, null);
    }
    
    public CheckableImageButton.SavedState[] a(int paramAnonymousInt)
    {
      return new CheckableImageButton.SavedState[paramAnonymousInt];
    }
  };
  boolean a;
  
  private CheckableImageButton$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((Boolean)paramParcel.readValue(null)).booleanValue();
  }
  
  CheckableImageButton$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeValue(Boolean.valueOf(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/CheckableImageButton$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */