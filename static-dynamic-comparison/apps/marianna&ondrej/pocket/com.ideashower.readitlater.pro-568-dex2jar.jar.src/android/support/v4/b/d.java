package android.support.v4.b;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class d
  implements Parcelable.ClassLoaderCreator
{
  private final c a;
  
  public d(c paramc)
  {
    this.a = paramc;
  }
  
  public Object createFromParcel(Parcel paramParcel)
  {
    return this.a.a(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return this.a.a(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return this.a.a(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */