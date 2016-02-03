package com.flurry.android;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

final class cs
  extends WebChromeClient
{
  private cs(bn parambn, byte paramByte) {}
  
  public final void onHideCustomView()
  {
    if (bn.k(this.dW) == null) {}
    while (bn.l(this.dW) == null) {
      return;
    }
    if (bn.p(this.dW) != null) {
      bn.p(this.dW).show();
    }
    ((ViewGroup)bn.k(this.dW).getWindow().getDecorView()).removeView(bn.n(this.dW));
    bn.n(this.dW).removeView(bn.l(this.dW));
    if ((bn.o(this.dW) != null) && (bn.o(this.dW).isShowing()))
    {
      bn.o(this.dW).hide();
      bn.o(this.dW).setOnDismissListener(null);
      bn.o(this.dW).dismiss();
    }
    bn.a(this.dW, null);
    ax.a(bn.k(this.dW), bn.q(this.dW));
    bn.r(this.dW).onCustomViewHidden();
    bn.a(this.dW, null);
    bn.a(this.dW, null);
    bn.a(this.dW, null);
    this.dW.K.j(this.dW.M.getAdSpace().toString());
  }
  
  public final void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (bn.k(this.dW) == null) {
      return;
    }
    if ((bn.l(this.dW) != null) && (bn.m(this.dW) != null))
    {
      bn.m(this.dW).onHideCustomView();
      return;
    }
    bn.a(this.dW, paramView);
    bn.a(this.dW, bn.k(this.dW).getRequestedOrientation());
    bn.a(this.dW, paramCustomViewCallback);
    bn.a(this.dW, new FrameLayout(bn.j(this.dW)));
    bn.n(this.dW).setBackgroundColor(-16777216);
    bn.n(this.dW).addView(bn.l(this.dW), new FrameLayout.LayoutParams(-1, -1, 17));
    ((ViewGroup)bn.k(this.dW).getWindow().getDecorView()).addView(bn.n(this.dW), -1, -1);
    if (bn.o(this.dW) == null)
    {
      bn.a(this.dW, new r(this, bn.j(this.dW), 16973841));
      bn.o(this.dW).getWindow().setType(1000);
      bn.o(this.dW).setOnShowListener(new q(this));
      bn.o(this.dW).setOnDismissListener(new o(this));
      bn.o(this.dW).setCancelable(true);
      bn.o(this.dW).show();
    }
    ax.a(bn.k(this.dW), paramInt, true);
    this.dW.K.b(this.dW.M.getAdSpace().toString(), false);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (bn.k(this.dW) == null) {
      return;
    }
    onShowCustomView(paramView, bn.k(this.dW).getRequestedOrientation(), paramCustomViewCallback);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */