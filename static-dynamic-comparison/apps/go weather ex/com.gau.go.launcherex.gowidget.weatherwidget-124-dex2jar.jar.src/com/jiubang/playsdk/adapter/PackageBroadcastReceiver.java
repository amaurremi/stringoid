package com.jiubang.playsdk.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

public class PackageBroadcastReceiver
  extends BroadcastReceiver
{
  private l a;
  private m b;
  private k c;
  private Context d;
  
  public PackageBroadcastReceiver(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.VIEW_RELOAD_ADDED");
    localIntentFilter.addAction("android.intent.action.VIEW_RELOAD_REMOVED");
    localIntentFilter.addAction("android.intent.action.VIEW_REFRESH");
    localIntentFilter.addAction("android.intent.action.VIEW_RELOAD");
    localIntentFilter.addAction("android.intent.action.VIEW_REMOVE_ADMOB");
    localIntentFilter.addCategory(this.d.getPackageName());
    return localIntentFilter;
  }
  
  public void a(k paramk)
  {
    this.c = paramk;
  }
  
  public void a(l paraml)
  {
    this.a = paraml;
  }
  
  public void a(m paramm)
  {
    this.b = paramm;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!TextUtils.isEmpty(paramContext))
      {
        if ((!"android.intent.action.VIEW_RELOAD".equals(paramContext)) && (!"android.intent.action.VIEW_RELOAD_REMOVED".equals(paramContext)) && (!"android.intent.action.VIEW_RELOAD_ADDED".equals(paramContext))) {
          break label72;
        }
        paramIntent = paramIntent.getDataString();
        if (this.a != null) {
          this.a.a("android.intent.action.VIEW_RELOAD_REMOVED".equals(paramContext), paramIntent);
        }
      }
    }
    label72:
    do
    {
      do
      {
        return;
        if (!"android.intent.action.VIEW_REFRESH".equals(paramContext)) {
          break;
        }
      } while (this.b == null);
      this.b.k();
      return;
    } while ((!"android.intent.action.VIEW_REMOVE_ADMOB".equals(paramContext)) || (this.c == null));
    this.c.l();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/PackageBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */