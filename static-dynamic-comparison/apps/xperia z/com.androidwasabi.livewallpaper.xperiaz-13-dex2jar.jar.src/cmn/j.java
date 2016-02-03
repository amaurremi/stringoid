package cmn;

import android.os.Handler;
import android.os.Message;

final class j
  extends Handler
{
  public final void handleMessage(Message paramMessage)
  {
    i locali = (i)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      g.c(locali.a, locali.b[0]);
      return;
    }
    paramMessage = locali.a;
    paramMessage = locali.b;
    g.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */