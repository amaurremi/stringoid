package cmn;

import android.os.Handler;
import android.os.Looper;

public final class f
{
  public static final void a(Runnable paramRunnable)
  {
    if (a())
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  public static final boolean a()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */