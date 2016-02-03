package com.flurry.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class CatalogActivity
  extends Activity
  implements View.OnClickListener
{
  private static volatile String a = "<html><body><table height='100%' width='100%' border='0'><tr><td style='vertical-align:middle;text-align:center'>No recommendations available<p><button type='input' onClick='activity.finish()'>Back</button></td></tr></table></body></html>";
  private WebView b;
  private w c;
  private List d = new ArrayList();
  private u e;
  private p f;
  
  private void a(x paramx)
  {
    try
    {
      this.b.loadUrl(paramx.a);
      this.c.a(paramx.b);
      return;
    }
    catch (Exception localException)
    {
      ah.a("FlurryAgent", "Error loading url: " + paramx.a);
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof y))
    {
      x localx = new x();
      localx.a = this.b.getUrl();
      localx.b = new ArrayList(this.c.b());
      this.d.add(localx);
      if (this.d.size() > 5) {
        this.d.remove(0);
      }
      localx = new x();
      Object localObject = (y)paramView;
      this.f = this.e.b(((y)localObject).a());
      ((y)localObject).a(this.f);
      localObject = this.e.a(((y)localObject).a());
      localx.a = (this.e.i() + (String)localObject);
      localx.b = this.c.a(paramView.getContext());
      a(localx);
      return;
    }
    if (paramView.getId() == 10000)
    {
      finish();
      return;
    }
    if (paramView.getId() == 10002)
    {
      this.c.a();
      return;
    }
    if (this.d.isEmpty())
    {
      finish();
      return;
    }
    a((x)this.d.remove(this.d.size() - 1));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(16973839);
    super.onCreate(paramBundle);
    this.e = FlurryAgent.b();
    paramBundle = getIntent();
    if (paramBundle.getExtras() != null)
    {
      paramBundle = Long.valueOf(paramBundle.getExtras().getLong("o"));
      if (paramBundle != null) {
        this.f = this.e.b(paramBundle.longValue());
      }
    }
    paramBundle = new ab(this, this);
    paramBundle.setId(1);
    paramBundle.setBackgroundColor(-16777216);
    this.b = new WebView(this);
    this.b.setId(2);
    this.b.setScrollBarStyle(0);
    this.b.setBackgroundColor(-1);
    if (this.f != null) {
      this.b.setWebViewClient(new q(this));
    }
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.addJavascriptInterface(this, "activity");
    this.c = new w(this, this);
    this.c.setId(3);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(10, paramBundle.getId());
    localRelativeLayout.addView(paramBundle, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, paramBundle.getId());
    localLayoutParams.addRule(2, this.c.getId());
    localRelativeLayout.addView(this.b, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12, paramBundle.getId());
    localRelativeLayout.addView(this.c, localLayoutParams);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      paramBundle = null;
      if (paramBundle != null) {
        break label356;
      }
      this.b.loadDataWithBaseURL(null, a, "text/html", "utf-8", null);
    }
    for (;;)
    {
      setContentView(localRelativeLayout);
      return;
      paramBundle = paramBundle.getString("u");
      break;
      label356:
      this.b.loadUrl(paramBundle);
    }
  }
  
  protected void onDestroy()
  {
    this.e.g();
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/CatalogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */