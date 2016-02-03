package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v7.mediarouter.R.attr;
import android.support.v7.mediarouter.R.style;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

final class MediaRouterThemeHelper
{
  public static Context createThemedContext(Context paramContext, boolean paramBoolean)
  {
    boolean bool2 = isLightTheme(paramContext);
    boolean bool1 = bool2;
    Object localObject = paramContext;
    if (bool2)
    {
      bool1 = bool2;
      localObject = paramContext;
      if (paramBoolean)
      {
        localObject = new ContextThemeWrapper(paramContext, R.style.Theme_AppCompat);
        bool1 = false;
      }
    }
    if (bool1) {}
    for (int i = R.style.Theme_MediaRouter_Light;; i = R.style.Theme_MediaRouter) {
      return new ContextThemeWrapper((Context)localObject, i);
    }
  }
  
  public static Drawable getThemeDrawable(Context paramContext, int paramInt)
  {
    paramInt = getThemeResource(paramContext, paramInt);
    if (paramInt != 0) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    return null;
  }
  
  public static int getThemeResource(Context paramContext, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true)) {
      return localTypedValue.resourceId;
    }
    return 0;
  }
  
  private static boolean isLightTheme(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    return (paramContext.getTheme().resolveAttribute(R.attr.isLightTheme, localTypedValue, true)) && (localTypedValue.data != 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/app/MediaRouterThemeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */