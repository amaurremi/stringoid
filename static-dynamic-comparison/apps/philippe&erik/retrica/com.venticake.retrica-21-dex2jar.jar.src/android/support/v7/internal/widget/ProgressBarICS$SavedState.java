package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class ProgressBarICS$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
  {
    public ProgressBarICS.SavedState a(Parcel paramAnonymousParcel)
    {
      return new ProgressBarICS.SavedState(paramAnonymousParcel, null);
    }
    
    public ProgressBarICS.SavedState[] a(int paramAnonymousInt)
    {
      return new ProgressBarICS.SavedState[paramAnonymousInt];
    }
  };
  int a;
  int b;
  
  private ProgressBarICS$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  ProgressBarICS$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ProgressBarICS$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */