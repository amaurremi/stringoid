package com.jiubang.core.c.a;

import android.text.TextUtils;
import com.gtp.a.a.b.c;
import java.io.File;

class f
  implements Runnable
{
  private final a b;
  
  public f(b paramb, a parama)
  {
    this.b = parama;
  }
  
  public void run()
  {
    int i = -1;
    Object localObject;
    if (!b.a(this.a))
    {
      this.b.f = 2;
      c.a("new_download", "new Download -> " + this.b.a);
      localObject = this.b.b;
      String str1 = this.b.a;
      String str2 = this.b.c;
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
        break label217;
      }
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = this.b;
      if (b.a(this.a, this.b, str1, this.b.a())) {
        i = 1;
      }
    }
    label217:
    for (((a)localObject).f = i;; this.b.f = -1)
    {
      c.a("new_download", "mDownloadBean.mStatus = " + this.b.f);
      switch (this.b.f)
      {
      case 0: 
      default: 
        return;
      }
    }
    b.b(this.a).sendMessage(b.b(this.a).obtainMessage(2, this.b));
    return;
    b.b(this.a).sendMessage(b.b(this.a).obtainMessage(3, this.b));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */