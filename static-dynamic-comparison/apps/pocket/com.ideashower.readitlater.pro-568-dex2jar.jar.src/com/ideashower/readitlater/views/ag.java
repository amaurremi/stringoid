package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.ideashower.readitlater.util.v;
import java.net.URI;
import org.apache.a.c.k;

class ag
  extends af
{
  public ag(ad paramad, ResolveInfo paramResolveInfo)
  {
    super(paramad, paramResolveInfo);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    ad.a(this.a.activityInfo.name);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(v.a("http://getpocket.com/redirect?url=" + k.a(ad.c(this.c).b(), "browser::", "")).toString()));
    localIntent.addFlags(524288);
    this.c.getContext().startActivity(localIntent);
  }
  
  public int g()
  {
    return 8;
  }
  
  public boolean h()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */