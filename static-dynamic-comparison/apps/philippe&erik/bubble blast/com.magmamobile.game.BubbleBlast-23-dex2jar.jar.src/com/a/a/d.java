package com.a.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import com.scoreloop.client.android.core.utils.Logger;

public class d
{
  private static ProgressDialog a = null;
  
  public static void a(Context paramContext) {}
  
  private static void b()
  {
    try
    {
      new Handler().post(new Runnable()
      {
        public void run()
        {
          if (d.a() != null) {
            synchronized (d.a())
            {
              ProgressDialog localProgressDialog2 = d.a();
              if (localProgressDialog2 != null) {}
              try
              {
                d.a().dismiss();
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Logger.a("FBProgressDialog", "Error while showing progress dialog");
                }
              }
            }
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */