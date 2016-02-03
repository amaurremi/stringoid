package android.support.v4.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public class d
{
  private static final e a = new f();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15)
    {
      a = new h();
      return;
    }
    if (i >= 11)
    {
      a = new g();
      return;
    }
  }
  
  public static Intent a(ComponentName paramComponentName)
  {
    return a.a(paramComponentName);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */