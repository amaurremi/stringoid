package cmn;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

@TargetApi(13)
public class d
  extends c
{
  public final Point a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getDefaultDisplay())
    {
      Point localPoint = new Point();
      if (paramContext != null) {
        paramContext.getSize(localPoint);
      }
      return localPoint;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */