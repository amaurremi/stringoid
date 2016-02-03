package com.jiubang.playsdk.adapter;

import android.content.Context;
import com.jiubang.playsdk.a.a;
import com.jiubang.playsdk.main.BitmapBean;
import com.jiubang.playsdk.main.c;

public class f
  implements Runnable
{
  private c a;
  private a b;
  private String c;
  private Context d;
  private g e;
  
  public f(Context paramContext, c paramc, a parama, g paramg, String paramString)
  {
    this.d = paramContext;
    this.a = paramc;
    this.b = parama;
    this.e = paramg;
    this.c = paramString;
  }
  
  public void run()
  {
    BitmapBean localBitmapBean = this.a.b(this.d, this.b);
    if (this.e != null) {
      this.e.a(localBitmapBean, this.c);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */