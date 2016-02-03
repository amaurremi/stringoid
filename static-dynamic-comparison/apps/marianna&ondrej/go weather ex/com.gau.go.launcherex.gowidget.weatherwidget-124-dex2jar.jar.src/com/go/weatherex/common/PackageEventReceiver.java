package com.go.weatherex.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.gtp.a.a.b.c;

public class PackageEventReceiver
  extends BroadcastReceiver
{
  private a a;
  
  public void a(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addDataScheme("package");
    paramContext.registerReceiver(this, localIntentFilter);
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    boolean bool;
    if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
    {
      paramContext = paramIntent.getDataString().replace("package:", "");
      bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      if ((!TextUtils.isEmpty(paramContext)) && (!bool))
      {
        c.a("PackageEventReceiver", "ACTION_PACKAGE_ADDED: " + paramContext);
        if (this.a != null) {
          this.a.d(paramContext);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!"android.intent.action.PACKAGE_REMOVED".equals(paramContext)) {
                    break;
                  }
                  paramContext = paramIntent.getDataString().replace("package:", "");
                  bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
                } while ((TextUtils.isEmpty(paramContext)) || (bool));
                c.a("PackageEventReceiver", "ACTION_PACKAGE_REMOVED: " + paramContext);
              } while (this.a == null);
              this.a.b(paramContext);
              return;
              if (!"android.intent.action.PACKAGE_REPLACED".equals(paramContext)) {
                break;
              }
              paramContext = paramIntent.getDataString().replace("package:", "");
              bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
            } while ((TextUtils.isEmpty(paramContext)) || (!bool));
            c.a("PackageEventReceiver", "ACTION_PACKAGE_REPLACED: " + paramContext);
          } while (this.a == null);
          this.a.a(paramContext);
          return;
        } while (!paramContext.equals("android.intent.action.PACKAGE_DATA_CLEARED"));
        paramContext = paramIntent.getDataString().replace("package:", "");
      } while (TextUtils.isEmpty(paramContext));
      c.a("PackageEventReceiver", "ACTION_PACKAGE_DATA_CLEARED: " + paramContext);
    } while (this.a == null);
    this.a.c(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/common/PackageEventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */