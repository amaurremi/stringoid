package cmn;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class q
{
  private static float a = 1.0F;
  
  public static float a(float paramFloat)
  {
    return a * paramFloat;
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int b(float paramFloat)
  {
    return Math.round(a * paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */