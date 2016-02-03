package com.appflood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.appflood.c.a;
import com.appflood.c.e;
import com.appflood.c.f;
import com.appflood.e.c;
import com.appflood.e.j;
import com.appflood.mraid.AFBannerWebView;
import java.util.HashMap;

public class AFFullScreenActivity
  extends Activity
  implements com.appflood.c.b
{
  private RelativeLayout a = null;
  private float b = 480.0F;
  private float c = 800.0F;
  private boolean d = false;
  private int e = 0;
  private a f;
  private int g = 0;
  private int h = 0;
  private View i;
  private com.appflood.f.b j;
  private int k = 0;
  private int l = 0;
  
  private void a()
  {
    if (this.a != null) {
      this.a.removeAllViews();
    }
    if (this.f != null)
    {
      this.f.d();
      this.f = null;
    }
    e.a().a(false, j.a("type", Integer.valueOf(4)));
    finish();
  }
  
  private void b()
  {
    if (f.g())
    {
      a();
      return;
    }
    f.a(new Runnable()
    {
      public final void run()
      {
        AFFullScreenActivity.k(AFFullScreenActivity.this);
      }
    });
  }
  
  public void onClick() {}
  
  public void onClose()
  {
    b();
  }
  
  public void onComplete() {}
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.onCreate(paramBundle);
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getExtras();
        if (paramBundle != null)
        {
          bool = paramBundle.getBoolean("isFull");
          this.d = paramBundle.getBoolean("isPortrait");
          this.e = paramBundle.getInt("titlebar");
        }
        if (this.d)
        {
          if (c.j >= 9)
          {
            setRequestedOrientation(7);
            requestWindowFeature(1);
            if (bool) {
              getWindow().setFlags(1024, 1024);
            }
            paramBundle = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
            getWindow().setBackgroundDrawableResource(17170445);
            this.b = paramBundle.widthPixels;
            this.c = (paramBundle.heightPixels - this.e);
            this.k = AFListActivity.1.a(this, 3);
            if (this.a == null)
            {
              this.a = new RelativeLayout(this);
              this.a.setBackgroundColor(-939524096);
              this.a.setVisibility(4);
            }
            setContentView(this.a);
            this.g = ((int)this.b);
            this.h = ((int)this.c);
            this.f = new a(this);
            this.f.a(15);
            this.f.a(this);
            this.f.a(this.g, this.h, 7);
            return;
          }
          setRequestedOrientation(1);
          continue;
        }
        if (c.j < 9) {
          break label295;
        }
      }
      catch (Throwable paramBundle)
      {
        j.b(paramBundle, "onCreate");
        return;
      }
      setRequestedOrientation(6);
      continue;
      label295:
      setRequestedOrientation(0);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onFinish(HashMap<String, Object> paramHashMap)
  {
    new StringBuilder("result = ").append(paramHashMap).append("w ").append(this.b).append(" h ").append(this.c).toString();
    j.a();
    boolean bool1 = ((Boolean)paramHashMap.get("result")).booleanValue();
    final int m = ((Integer)paramHashMap.get("w")).intValue();
    final int n = ((Integer)paramHashMap.get("h")).intValue();
    final String str = (String)paramHashMap.get("type");
    Object localObject;
    if (paramHashMap.containsKey("resize"))
    {
      localObject = paramHashMap.get("resize");
      final boolean bool2 = ((Boolean)localObject).booleanValue();
      if (!bool1) {
        break label176;
      }
      this.l = 0;
      f.a(new Runnable()
      {
        public final void run()
        {
          int n = (int)(AFFullScreenActivity.a(AFFullScreenActivity.this) * 2.5D);
          RelativeLayout.LayoutParams localLayoutParams;
          if ((bool2) && (m > 0) && (n > 0))
          {
            localLayoutParams = new RelativeLayout.LayoutParams(m, n);
            localLayoutParams.addRule(13);
            if (AFFullScreenActivity.b(AFFullScreenActivity.this) == null)
            {
              AFFullScreenActivity.a(AFFullScreenActivity.this, new com.appflood.f.b(AFFullScreenActivity.this, AFFullScreenActivity.a(AFFullScreenActivity.this)));
              AFFullScreenActivity.c(AFFullScreenActivity.this).addView(AFFullScreenActivity.b(AFFullScreenActivity.this), localLayoutParams);
            }
            for (;;)
            {
              if (AFFullScreenActivity.d(AFFullScreenActivity.this) != null)
              {
                localLayoutParams = new RelativeLayout.LayoutParams(m - n, n - n);
                localLayoutParams.addRule(13);
                new StringBuilder(" 666666666   ").append(AFFullScreenActivity.c(AFFullScreenActivity.this)).toString();
                j.a();
                if (AFFullScreenActivity.d(AFFullScreenActivity.this).getParent() == null) {
                  break;
                }
                AFFullScreenActivity.c(AFFullScreenActivity.this).updateViewLayout(AFFullScreenActivity.d(AFFullScreenActivity.this), localLayoutParams);
              }
              return;
              AFFullScreenActivity.c(AFFullScreenActivity.this).updateViewLayout(AFFullScreenActivity.b(AFFullScreenActivity.this), localLayoutParams);
            }
            AFFullScreenActivity.c(AFFullScreenActivity.this).addView(AFFullScreenActivity.d(AFFullScreenActivity.this), localLayoutParams);
            return;
          }
          AFFullScreenActivity.c(AFFullScreenActivity.this).removeAllViews();
          if ((AFFullScreenActivity.d(AFFullScreenActivity.this) instanceof AFBannerWebView)) {
            ((AFBannerWebView)AFFullScreenActivity.d(AFFullScreenActivity.this)).destroy();
          }
          int m = AFFullScreenActivity.e(AFFullScreenActivity.this);
          int k = AFFullScreenActivity.f(AFFullScreenActivity.this);
          new StringBuilder("ww ").append(m).append(" hh ").append(k).toString();
          j.a();
          int i;
          int j;
          if ("html".equals(str))
          {
            i = -1;
            j = -1;
          }
          for (;;)
          {
            m = i;
            k = j;
            if (j > 0)
            {
              m = i;
              k = j;
              if (i > 0)
              {
                if (AFFullScreenActivity.b(AFFullScreenActivity.this) == null) {
                  AFFullScreenActivity.a(AFFullScreenActivity.this, new com.appflood.f.b(AFFullScreenActivity.this, AFFullScreenActivity.a(AFFullScreenActivity.this)));
                }
                localLayoutParams = new RelativeLayout.LayoutParams(j, i);
                localLayoutParams.addRule(13);
                AFFullScreenActivity.c(AFFullScreenActivity.this).addView(AFFullScreenActivity.b(AFFullScreenActivity.this), localLayoutParams);
                k = j - n;
                m = i - n;
              }
            }
            localLayoutParams = new RelativeLayout.LayoutParams(k, m);
            localLayoutParams.addRule(13);
            AFFullScreenActivity.a(AFFullScreenActivity.this, AFFullScreenActivity.i(AFFullScreenActivity.this).c());
            AFFullScreenActivity.c(AFFullScreenActivity.this).addView(AFFullScreenActivity.d(AFFullScreenActivity.this), localLayoutParams);
            AFFullScreenActivity.j(AFFullScreenActivity.this);
            new StringBuilder(" ww ").append(k).append(" hh ").append(m).append(" strokesie ").append(AFFullScreenActivity.a(AFFullScreenActivity.this)).toString();
            j.a();
            return;
            i = k;
            j = m;
            if (m > 0)
            {
              i = k;
              j = m;
              if (n > 0) {
                if ("banner".equals(str))
                {
                  j = m;
                  if (m > AFFullScreenActivity.g(AFFullScreenActivity.this) - n)
                  {
                    j = (int)(AFFullScreenActivity.g(AFFullScreenActivity.this) - n);
                    k = n * j / m;
                  }
                  i = k;
                  if (k > AFFullScreenActivity.h(AFFullScreenActivity.this) - n)
                  {
                    i = (int)(AFFullScreenActivity.h(AFFullScreenActivity.this) - n);
                    j = m * i / n;
                  }
                }
                else
                {
                  j = m;
                  i = n;
                }
              }
            }
          }
        }
      });
    }
    for (;;)
    {
      e.a().a(bool1, 4);
      label176:
      do
      {
        return;
        localObject = Boolean.valueOf(false);
        break;
      } while (paramHashMap.containsKey("video_error"));
      m = this.l + 1;
      this.l = m;
      if (m > 1) {
        b();
      } else {
        this.f.b();
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {}
    try
    {
      b();
      return true;
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    catch (Throwable paramKeyEvent)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/AFFullScreenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */