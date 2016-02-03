package uk.co.senab.photoview.a;

import android.content.Context;
import android.os.Build.VERSION;

public final class g
{
  public static e a(Context paramContext, f paramf)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 5) {
      paramContext = new a(paramContext);
    }
    for (;;)
    {
      paramContext.a(paramf);
      return paramContext;
      if (i < 8) {
        paramContext = new b(paramContext);
      } else {
        paramContext = new c(paramContext);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */