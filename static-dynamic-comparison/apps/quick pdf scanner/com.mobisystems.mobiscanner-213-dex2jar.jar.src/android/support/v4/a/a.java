package android.support.v4.a;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class a
{
  public static <T> Parcelable.Creator<T> a(b<T> paramb)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      d.b(paramb);
    }
    return new a(paramb);
  }
  
  static class a<T>
    implements Parcelable.Creator<T>
  {
    final b<T> C;
    
    public a(b<T> paramb)
    {
      this.C = paramb;
    }
    
    public T createFromParcel(Parcel paramParcel)
    {
      return (T)this.C.createFromParcel(paramParcel, null);
    }
    
    public T[] newArray(int paramInt)
    {
      return this.C.newArray(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */