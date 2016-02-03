package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ParcelableCompat
{
  public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      ParcelableCompatCreatorHoneycombMR2Stub.instantiate(paramParcelableCompatCreatorCallbacks);
    }
    return new CompatCreator(paramParcelableCompatCreatorCallbacks);
  }
  
  static class CompatCreator<T>
    implements Parcelable.Creator<T>
  {
    final ParcelableCompatCreatorCallbacks<T> mCallbacks;
    
    public CompatCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
    {
      this.mCallbacks = paramParcelableCompatCreatorCallbacks;
    }
    
    public T createFromParcel(Parcel paramParcel)
    {
      return (T)this.mCallbacks.createFromParcel(paramParcel, null);
    }
    
    public T[] newArray(int paramInt)
    {
      return this.mCallbacks.newArray(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/android/support/v4/os/ParcelableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */