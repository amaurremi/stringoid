package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Future;

@ez
public class ai
{
  protected ah a(final Context paramContext, gt paramgt, final gk<ah> paramgk)
  {
    paramContext = new aj(paramContext, paramgt);
    paramContext.a(new ah.a()
    {
      public void aM()
      {
        paramgk.a(paramContext);
      }
    });
    return paramContext;
  }
  
  public Future<ah> a(final Context paramContext, final gt paramgt, final String paramString)
  {
    final gk localgk = new gk();
    gr.wC.post(new Runnable()
    {
      public void run()
      {
        ai.this.a(paramContext, paramgt, localgk).f(paramString);
      }
    });
    return localgk;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */