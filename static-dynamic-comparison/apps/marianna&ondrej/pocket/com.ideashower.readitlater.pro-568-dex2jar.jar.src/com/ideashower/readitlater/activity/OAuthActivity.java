package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.pocket.oauth.k;
import com.pocket.p.o;

public class OAuthActivity
  extends Activity
{
  private Uri a;
  private int b;
  private boolean c = false;
  
  public void finish()
  {
    super.finish();
    k.b(this.a, this.b);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(getIntent().getStringExtra("requestUrl")));
      paramBundle.addFlags(1073741824);
      if (o.a(this, paramBundle))
      {
        startActivity(paramBundle);
        return;
      }
      this.b = -2;
      finish();
      return;
    }
    this.c = true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.c = false;
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getData();; paramIntent = null)
    {
      this.a = paramIntent;
      this.b = 1;
      finish();
      return;
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.c = true;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.c)
    {
      this.b = -1;
      finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/OAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */