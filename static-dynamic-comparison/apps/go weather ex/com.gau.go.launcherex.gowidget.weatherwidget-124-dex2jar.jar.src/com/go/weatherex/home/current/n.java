package com.go.weatherex.home.current;

import android.text.TextPaint;
import android.widget.TextView;

class n
  implements Runnable
{
  n(m paramm, String paramString) {}
  
  public void run()
  {
    int j = m.a(this.b).getMeasuredWidth();
    if (j <= 0) {
      return;
    }
    int i = 40;
    for (;;)
    {
      m.a(this.b).setTextSize(1, i);
      if ((m.a(this.b).getPaint().measureText(this.a) < j) || (i <= 10)) {
        break;
      }
      i -= 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */