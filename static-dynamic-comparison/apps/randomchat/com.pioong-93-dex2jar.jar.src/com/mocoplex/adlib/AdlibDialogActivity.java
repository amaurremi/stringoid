package com.mocoplex.adlib;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout.LayoutParams;

public class AdlibDialogActivity
  extends Activity
{
  protected String a;
  protected int b;
  protected int c;
  AdlibDialogView d;
  LinearLayout.LayoutParams e;
  
  private int a(int paramInt)
  {
    float f = getResources().getDisplayMetrics().density;
    return (int)(paramInt / Float.valueOf(f).floatValue());
  }
  
  private void b()
  {
    Object localObject = getWindowManager().getDefaultDisplay();
    int k = ((Display)localObject).getWidth();
    int m = ((Display)localObject).getHeight();
    int i;
    int j;
    if (k >= 1000)
    {
      i = 80;
      if (m < 1000) {
        break label156;
      }
      j = 100;
    }
    for (;;)
    {
      this.b = (a(k) - i);
      this.c = (a(m) - j);
      this.d = new AdlibDialogView(this, this.a, this.b, this.c);
      this.e = new LinearLayout.LayoutParams(-1, -1);
      localObject = new Handler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          try
          {
            switch (paramAnonymousMessage.what)
            {
            case 10: 
              AdlibDialogActivity.this.a();
              return;
            case 20: 
              paramAnonymousMessage = new Intent("android.intent.action.VIEW", Uri.parse((String)paramAnonymousMessage.obj));
              try
              {
                AdlibDialogActivity.this.startActivity(paramAnonymousMessage);
                AdlibDialogActivity.this.finish();
                return;
              }
              catch (Exception paramAnonymousMessage)
              {
                return;
              }
            case 30: 
              Object localObject = (String)paramAnonymousMessage.obj;
              paramAnonymousMessage = new Bundle();
              paramAnonymousMessage.putString("url", (String)localObject);
              paramAnonymousMessage.putInt("type", 1);
              localObject = new Intent(AdlibDialogActivity.this, AdlibWebBrowserActivity.class);
              ((Intent)localObject).putExtras(paramAnonymousMessage);
              try
              {
                AdlibDialogActivity.this.startActivity((Intent)localObject);
                AdlibDialogActivity.this.finish();
                return;
              }
              catch (Exception paramAnonymousMessage)
              {
                return;
              }
            }
            return;
          }
          catch (Exception paramAnonymousMessage) {}
        }
      };
      this.d.setHandler((Handler)localObject);
      setContentView(this.d, this.e);
      return;
      if (k >= 700)
      {
        i = 50;
        break;
      }
      i = 25;
      break;
      label156:
      if (m >= 700) {
        j = 70;
      } else {
        j = 40;
      }
    }
  }
  
  protected final void a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    this.d.setAnimation(localAlphaAnimation);
    this.d.setVisibility(8);
    new Handler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AdlibDialogActivity.this.finish();
      }
    }, 200L);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2) {
      b();
    }
    while (paramConfiguration.orientation != 1) {
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = new WindowManager.LayoutParams();
    paramBundle.flags = 2;
    paramBundle.dimAmount = 0.7F;
    getWindow().setAttributes(paramBundle);
    this.a = getIntent().getStringExtra("did");
    b();
  }
  
  protected void onDestroy()
  {
    if (this.d != null) {
      this.d.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (this.d != null) {
      this.d.onPause();
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    if (this.d != null) {
      this.d.onResume();
    }
    super.onResume();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */