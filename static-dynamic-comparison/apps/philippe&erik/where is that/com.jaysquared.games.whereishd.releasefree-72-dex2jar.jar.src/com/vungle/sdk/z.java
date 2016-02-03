package com.vungle.sdk;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

final class z
  extends Handler
{
  z(y paramy) {}
  
  public final void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      synchronized (y.n(this.a))
      {
        if ((y.b(this.a) == null) || (y.o(this.a))) {
          return;
        }
        if (!y.p(this.a)) {
          y.q(this.a).getDrawable().setAlpha(0);
        }
        if (!y.r(this.a))
        {
          y.s(this.a).setTextColor(0);
          y.s(this.a).setShadowLayer(2.0F, 0.0F, 0.0F, 0);
        }
        switch (paramMessage.what)
        {
        case 66: 
          return;
        }
      }
      double d = y.b(this.a).getCurrentPosition() / 1000.0D;
      if ((y.j(this.a)) && (d > y.k(this.a)) && (!y.p(this.a)))
      {
        paramMessage = new AlphaAnimation(0.0F, 1.0F);
        paramMessage.setDuration(1000L);
        y.q(this.a).startAnimation(paramMessage);
        y.t(this.a);
        y.q(this.a).getDrawable().setAlpha(255);
        y.q(this.a).bringToFront();
      }
      if ((!y.r(this.a)) && (d > y.u(this.a)))
      {
        paramMessage = new AlphaAnimation(0.0F, 1.0F);
        paramMessage.setDuration(1000L);
        y.s(this.a).startAnimation(paramMessage);
        y.v(this.a);
        y.s(this.a).setTextColor(-1);
        y.s(this.a).setShadowLayer(2.0F, 0.0F, 0.0F, -16777216);
        y.s(this.a).bringToFront();
      }
      long l = Math.round((y.b(this.a).getDuration() - y.b(this.a).getCurrentPosition()) / 1000.0D);
      StringBuilder localStringBuilder = new StringBuilder("Video ends in ").append(l);
      if (l == 1L) {}
      for (paramMessage = " second";; paramMessage = " seconds")
      {
        paramMessage = paramMessage;
        y.s(this.a).setText(paramMessage);
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */