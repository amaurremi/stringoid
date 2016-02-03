package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;

final class w
  extends WebChromeClient
{
  private w(o paramo) {}
  
  public void onHideCustomView()
  {
    ja.a(3, o.a(this.a), "onHideCustomView()");
    if (!(this.a.getContext() instanceof Activity)) {
      ja.a(3, o.a(this.a), "no activity present");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.a.getContext();
    } while (o.n(this.a) == null);
    if (o.r(this.a) != null) {
      o.r(this.a).show();
    }
    ((ViewGroup)localActivity.getWindow().getDecorView()).removeView(o.p(this.a));
    o.p(this.a).removeView(o.n(this.a));
    if ((o.q(this.a) != null) && (o.q(this.a).isShowing()))
    {
      o.q(this.a).hide();
      o.q(this.a).setOnDismissListener(null);
      o.q(this.a).dismiss();
    }
    o.a(this.a, null);
    j.a(localActivity, o.s(this.a));
    o.t(this.a).onCustomViewHidden();
    o.a(this.a, null);
    o.a(this.a, null);
    o.a(this.a, null);
    this.a.b.b(localActivity, this.a.d.b().toString());
  }
  
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    ja.a(3, o.a(this.a), "onShowCustomView(14)");
    if (!(this.a.getContext() instanceof Activity))
    {
      ja.a(3, o.a(this.a), "no activity present");
      return;
    }
    Activity localActivity = (Activity)this.a.getContext();
    if ((o.n(this.a) != null) && (o.o(this.a) != null))
    {
      o.o(this.a).onHideCustomView();
      return;
    }
    o.a(this.a, paramView);
    o.a(this.a, localActivity.getRequestedOrientation());
    o.a(this.a, paramCustomViewCallback);
    o.a(this.a, new FrameLayout(localActivity));
    o.p(this.a).setBackgroundColor(-16777216);
    o.p(this.a).addView(o.n(this.a), new FrameLayout.LayoutParams(-1, -1, 17));
    ((ViewGroup)localActivity.getWindow().getDecorView()).addView(o.p(this.a), -1, -1);
    if (o.q(this.a) == null)
    {
      o.a(this.a, new x(this, localActivity, 16973841, localActivity));
      o.q(this.a).getWindow().setType(1000);
      o.q(this.a).setOnShowListener(new y(this));
      o.q(this.a).setOnDismissListener(new z(this));
      o.q(this.a).setCancelable(true);
      o.q(this.a).show();
    }
    j.a(localActivity, paramInt, true);
    this.a.b.a(localActivity, this.a.d.b().toString());
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    ja.a(3, o.a(this.a), "onShowCustomView(7)");
    if (!(this.a.getContext() instanceof Activity))
    {
      ja.a(3, o.a(this.a), "no activity present");
      return;
    }
    onShowCustomView(paramView, ((Activity)this.a.getContext()).getRequestedOrientation(), paramCustomViewCallback);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */