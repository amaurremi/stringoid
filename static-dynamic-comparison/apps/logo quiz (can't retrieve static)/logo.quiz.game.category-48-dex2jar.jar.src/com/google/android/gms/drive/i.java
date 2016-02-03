package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.n;

public abstract class i
  implements Parcelable
{
  private volatile transient boolean ND = false;
  
  protected abstract void I(Parcel paramParcel, int paramInt);
  
  public final boolean hT()
  {
    return this.ND;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!hT()) {}
    for (boolean bool = true;; bool = false)
    {
      n.I(bool);
      this.ND = true;
      I(paramParcel, paramInt);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */