package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class c<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final b<T> C;
  
  public c(b<T> paramb)
  {
    this.C = paramb;
  }
  
  public T createFromParcel(Parcel paramParcel)
  {
    return (T)this.C.createFromParcel(paramParcel, null);
  }
  
  public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return (T)this.C.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public T[] newArray(int paramInt)
  {
    return this.C.newArray(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */