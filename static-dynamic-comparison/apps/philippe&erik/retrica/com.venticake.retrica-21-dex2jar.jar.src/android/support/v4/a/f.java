package android.support.v4.a;

import android.content.ComponentName;
import android.content.Intent;

class f
  implements e
{
  public Intent a(ComponentName paramComponentName)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(paramComponentName);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    return localIntent;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */