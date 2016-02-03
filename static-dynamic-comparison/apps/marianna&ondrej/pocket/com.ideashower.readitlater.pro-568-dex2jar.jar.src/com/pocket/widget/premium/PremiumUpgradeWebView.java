package com.pocket.widget.premium;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.widget.Toast;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.views.BaseWebView;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.pocket.c.r;
import com.pocket.c.s;
import com.pocket.p.z;
import com.pocket.user.a;
import com.pocket.user.d;
import com.pocket.webkit.JsInterface;
import java.net.URL;

public class PremiumUpgradeWebView
  extends ResizeDetectRelativeLayout
  implements s
{
  private Activity a;
  private BaseWebView b;
  private h c;
  private boolean d;
  private r e;
  private boolean f;
  
  public PremiumUpgradeWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PremiumUpgradeWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PremiumUpgradeWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      if ((!this.f) && ((paramString.contains("/purchase_confirmation")) || (paramString.contains("/premium_settings")))) {
        try
        {
          String str = com.ideashower.readitlater.util.g.b(paramString);
          if ((str.equalsIgnoreCase("getpocket.com")) || (str.equalsIgnoreCase("pocket.com")) || (str.equalsIgnoreCase("readitlater.com")) || (str.equalsIgnoreCase("readitlaterlist.com")))
          {
            paramString = new URL(paramString);
            if (paramString.getPath().startsWith("/purchase_confirmation"))
            {
              b();
              return true;
            }
            if (paramString.getPath().startsWith("/premium_settings"))
            {
              b();
              Toast.makeText(this.a, 2131493586, 1).show();
              return true;
            }
          }
        }
        catch (Throwable paramString)
        {
          e.a(paramString);
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    this.b.setVisibility(4);
    this.c.a(false);
    new AlertDialog.Builder(getContext()).setTitle(2131493175).setMessage(2131493122).setPositiveButton(2131492932, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        PremiumUpgradeWebView.b(PremiumUpgradeWebView.this).setVisibility(0);
        PremiumUpgradeWebView.a(PremiumUpgradeWebView.this).a(false);
        PremiumUpgradeWebView.b(PremiumUpgradeWebView.this).loadUrl("https://getpocket.com/android/purchase");
      }
    }).setNegativeButton(2131492871, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        PremiumUpgradeWebView.a(PremiumUpgradeWebView.this).b();
      }
    }).show();
  }
  
  public void a()
  {
    this.e = null;
    c();
  }
  
  public void a(Activity paramActivity, h paramh)
  {
    if (!this.d)
    {
      this.a = paramActivity;
      this.c = paramh;
      setBackgroundColor(-1);
      LayoutInflater.from(getContext()).inflate(2130903167, this, true);
      this.b = ((BaseWebView)findViewById(2131231122));
      this.b.setWebViewClient(new g(this, null));
      paramActivity = this.b.getSettings();
      z.a(paramActivity, true);
      JsInterface.removeSearchBoxInterface(this.b);
      paramActivity.setJavaScriptEnabled(true);
      paramActivity.setSaveFormData(false);
      paramActivity.setSavePassword(false);
      paramActivity.setBuiltInZoomControls(false);
      paramActivity.setSupportZoom(false);
      paramActivity.setLoadWithOverviewMode(false);
      paramActivity.setUseWideViewPort(false);
      this.b.setScrollBarStyle(0);
      this.b.setBackgroundColor(0);
      this.d = true;
      this.b.requestFocus(130);
      this.b.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            return false;
            if (!paramAnonymousView.hasFocus()) {
              paramAnonymousView.requestFocus();
            }
          }
        }
      });
    }
    this.c.a(true);
    this.e = new r(this);
    this.e.h();
  }
  
  public void a(r paramr, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (paramr != this.e) {
      return;
    }
    this.e = null;
    this.b.postUrl("https://getpocket.com/android/purchase", paramArrayOfByte);
  }
  
  public void b()
  {
    this.f = true;
    as.a(new d(as.k().h()).b(1).a());
    this.c.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumUpgradeWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */