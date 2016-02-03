package android.support.v4.c;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class a
{
  public static <T> Parcelable.Creator<T> a(c<T> paramc)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      e.a(paramc);
    }
    return new b(paramc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */