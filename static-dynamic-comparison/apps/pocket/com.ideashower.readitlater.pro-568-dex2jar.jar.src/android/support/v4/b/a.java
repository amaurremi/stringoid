package android.support.v4.b;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class a
{
  public static Parcelable.Creator a(c paramc)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      e.a(paramc);
    }
    return new b(paramc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */