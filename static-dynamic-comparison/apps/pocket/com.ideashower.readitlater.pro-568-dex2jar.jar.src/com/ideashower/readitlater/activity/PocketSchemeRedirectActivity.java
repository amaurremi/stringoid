package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.f;
import com.ideashower.readitlater.util.j;
import com.pocket.p.l;
import java.util.List;
import org.apache.a.c.k;

public class PocketSchemeRedirectActivity
  extends f
{
  private String a(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    if (paramUri.getScheme().equalsIgnoreCase("pocket")) {
      return paramUri.getHost();
    }
    if ((paramUri.getScheme().equalsIgnoreCase("http")) || (paramUri.getScheme().equalsIgnoreCase("https")))
    {
      if (paramUri.getHost().equalsIgnoreCase("getpocket.com"))
      {
        List localList = paramUri.getPathSegments();
        if ((localList.size() > 1) && (((String)localList.get(0)).equalsIgnoreCase("androidredirect"))) {
          return paramUri.getPath().substring("androidredirect".length() + 2);
        }
        return null;
      }
      return null;
    }
    return null;
  }
  
  private void f()
  {
    PremiumPurchaseFlowActivity.a(this, 2, "url_scheme");
    finish();
  }
  
  private void g()
  {
    if (j.g()) {}
    for (l locall = l.c;; locall = l.b)
    {
      an.a(this, locall, new ao()
      {
        public void a()
        {
          PocketSchemeRedirectActivity.this.finish();
        }
        
        public void b()
        {
          PocketSchemeRedirectActivity.this.finish();
        }
      });
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = a(getIntent().getData());
    if (k.b(paramBundle, "premium"))
    {
      f();
      return;
    }
    if (k.b(paramBundle, "premium-settings"))
    {
      g();
      return;
    }
    finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/PocketSchemeRedirectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */