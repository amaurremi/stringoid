package com.appbrain.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.webkit.JavascriptInterface;
import cmn.Proguard.KeepMembers;
import cmn.a;
import cmn.x;

class ab
  implements Proguard.KeepMembers
{
  final af a;
  private final Activity b;
  
  public ab(Activity paramActivity, af paramaf)
  {
    this.a = paramaf;
    this.b = paramActivity;
  }
  
  @JavascriptInterface
  public void click()
  {
    if (this.a != null)
    {
      aa.a(this.b, this.a);
      SharedPreferences localSharedPreferences = aw.a().d();
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putInt("ow_click", localSharedPreferences.getInt("ow_click", 0) + 1);
      a.a().b(localEditor);
    }
  }
  
  @JavascriptInterface
  public void close()
  {
    this.b.finish();
  }
  
  @JavascriptInterface
  public boolean isPackageInstalled(String paramString)
  {
    return x.a(this.b, paramString);
  }
  
  @JavascriptInterface
  public void openUrl(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aa.c(this.b, paramString);
      return;
    }
    aa.a(this.b, paramString);
  }
  
  @JavascriptInterface
  public void reportSelected(String paramString1, String paramString2, String paramString3)
  {
    new Thread(new ad(this, paramString1, paramString2, paramString3)).start();
    paramString1 = aw.a().d();
    paramString2 = paramString1.edit();
    paramString2.putInt("ow_imp", paramString1.getInt("ow_imp", 0) + 1);
    a.a().b(paramString2);
  }
  
  @JavascriptInterface
  public void trackClick(String paramString1, String paramString2, String paramString3)
  {
    aa.a(this.b, paramString1, paramString2, paramString3);
    paramString1 = aw.a().d();
    paramString2 = paramString1.edit();
    paramString2.putInt("ow_click", paramString1.getInt("ow_click", 0) + 1);
    a.a().b(paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */