package com.pocket.oauth;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.activity.SplashActivity;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.RainbowBar;
import com.pocket.i.a.i;
import com.pocket.p.k;

public class PocketAuthorizeAppActivity
  extends a
{
  private p z;
  
  public static void a(SplashActivity paramSplashActivity)
  {
    Intent localIntent = new Intent(paramSplashActivity, PocketAuthorizeAppActivity.class);
    Bundle localBundle = paramSplashActivity.getIntent().getBundleExtra("com.pocket.oauth.extra.app_auth");
    localIntent.putExtra("com.pocket.oauth.extra.request_token", localBundle.getString("com.pocket.oauth.extra.request_token"));
    localIntent.putExtra("com.pocket.external.extra.package", localBundle.getString("com.pocket.external.extra.package"));
    localIntent.putExtra("com.pocket.external.extra.view", localBundle.getString("com.pocket.external.extra.view"));
    paramSplashActivity.startActivity(localIntent);
  }
  
  protected static void a(PocketAuthorizeAppActivity paramPocketAuthorizeAppActivity, String paramString)
  {
    Intent localIntent = new Intent(paramPocketAuthorizeAppActivity, SplashActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.pocket.oauth.extra.request_token", paramString);
    localBundle.putString("com.pocket.external.extra.package", paramPocketAuthorizeAppActivity.getIntent().getStringExtra("com.pocket.external.extra.package"));
    localBundle.putString("com.pocket.external.extra.view", paramPocketAuthorizeAppActivity.getIntent().getStringExtra("com.pocket.external.extra.view"));
    localIntent.putExtra("com.pocket.oauth.extra.app_auth", localBundle);
    localIntent.addFlags(1073741824);
    paramPocketAuthorizeAppActivity.startActivity(localIntent);
  }
  
  public String f()
  {
    return "PocketAuthorizeAppActivity";
  }
  
  protected com.ideashower.readitlater.activity.b l()
  {
    return com.ideashower.readitlater.activity.b.d;
  }
  
  protected Drawable m()
  {
    return getResources().getDrawable(2130837830);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.z.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!com.pocket.e.b.a())
    {
      finish();
      return;
    }
    if (paramBundle == null)
    {
      this.z = p.Y();
      if (j.g())
      {
        k.a(this.z, this, "main");
        paramBundle = new RainbowBar(this);
        paramBundle.getRainbow().a(false);
        paramBundle.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.n.addView(paramBundle);
        return;
      }
      a(this.z, "main");
      return;
    }
    this.z = ((p)k().a("main"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/oauth/PocketAuthorizeAppActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */