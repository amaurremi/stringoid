package mobi.beyondpod.ui.core.mediarouter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import mobi.beyondpod.R.attr;

final class MediaRouterThemeHelper
{
  public static Context createThemedContext(Context paramContext, boolean paramBoolean)
  {
    return paramContext;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/mediarouter/MediaRouterThemeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */