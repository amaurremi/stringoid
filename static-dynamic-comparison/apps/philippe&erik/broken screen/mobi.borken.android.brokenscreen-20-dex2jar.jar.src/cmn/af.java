package cmn;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;

public final class af
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  
  public static FrameLayout a(Activity paramActivity)
  {
    paramActivity = paramActivity.findViewById(16908290);
    if ((paramActivity instanceof FrameLayout)) {
      return (FrameLayout)paramActivity;
    }
    return null;
  }
  
  public static final void a(Runnable paramRunnable)
  {
    if (a())
    {
      paramRunnable.run();
      return;
    }
    a.post(paramRunnable);
  }
  
  public static final boolean a()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */