package a.a.a;

import a.a.a.d.e;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class i
  extends Activity
  implements k, View.OnClickListener
{
  protected a.a.a.c.b a;
  protected e b;
  private final int c = 0;
  private a.a.a.b.a d;
  private Context e;
  
  private boolean a(Context paramContext)
  {
    return paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
  }
  
  private boolean g()
  {
    Object localObject = new String[1];
    localObject[0] = "value";
    if (Build.VERSION.SDK_INT >= 17) {}
    for (localObject = getContentResolver().query(Settings.Global.CONTENT_URI, (String[])localObject, "name = ? AND value = ?", new String[] { "install_non_market_apps", String.valueOf(1) }, null); ((Cursor)localObject).getCount() == 1; localObject = getContentResolver().query(Settings.Secure.CONTENT_URI, (String[])localObject, "name = ? AND value = ?", new String[] { "install_non_market_apps", String.valueOf(1) }, null)) {
      return true;
    }
    return false;
  }
  
  protected void a()
  {
    ((TextView)findViewById(4098)).setText(f());
    ((TextView)findViewById(4099)).setText("Version " + this.b.a() + "\n" + this.b.b());
    ((Button)findViewById(4100)).setOnClickListener(this);
    WebView localWebView = (WebView)findViewById(4101);
    localWebView.clearCache(true);
    localWebView.destroyDrawingCache();
    localWebView.loadDataWithBaseURL("https://sdk.hockeyapp.net/", b(), "text/html", "utf-8", null);
  }
  
  protected void a(String paramString)
  {
    a(paramString, new a.a.a.a.a()
    {
      public String a(int paramAnonymousInt)
      {
        m localm = l.b();
        if (localm != null) {
          return localm.a(paramAnonymousInt);
        }
        return null;
      }
      
      public void a(a.a.a.c.b paramAnonymousb)
      {
        i.this.d();
      }
      
      public void a(a.a.a.c.b paramAnonymousb, Boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean.booleanValue())
        {
          i.this.c();
          return;
        }
        i.this.d();
      }
    });
    this.a.execute(new String[0]);
  }
  
  protected void a(String paramString, a.a.a.a.a parama)
  {
    this.a = new a.a.a.c.b(this, paramString, parama);
  }
  
  protected String b()
  {
    return this.b.a(false);
  }
  
  protected void c()
  {
    a(getIntent().getStringExtra("url"));
  }
  
  public void d()
  {
    findViewById(4100).setEnabled(true);
  }
  
  public ViewGroup e()
  {
    return new a.a.a.e.b(this);
  }
  
  public String f()
  {
    try
    {
      Object localObject = getPackageManager();
      localObject = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(getPackageName(), 0)).toString();
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "";
  }
  
  public int getCurrentVersionCode()
  {
    try
    {
      int i = getPackageManager().getPackageInfo(getPackageName(), 128).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return -1;
  }
  
  public void onClick(View paramView)
  {
    if (!a(this.e))
    {
      this.d = new a.a.a.b.a();
      this.d.a("The permission to access the external storage permission is not set. Please contact the developer.");
      runOnUiThread(new Runnable()
      {
        public void run()
        {
          i.this.showDialog(0);
        }
      });
      return;
    }
    if (!g())
    {
      this.d = new a.a.a.b.a();
      this.d.a("The installation from unknown sources is not enabled. Please check the device settings.");
      runOnUiThread(new Runnable()
      {
        public void run()
        {
          i.this.showDialog(0);
        }
      });
      return;
    }
    c();
    paramView.setEnabled(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle("App Update");
    setContentView(e());
    this.e = this;
    this.b = new e(getIntent().getStringExtra("json"), this);
    a();
    this.a = ((a.a.a.c.b)getLastNonConfigurationInstance());
    if (this.a != null) {
      this.a.a(this);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    new AlertDialog.Builder(this).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(17301543).setPositiveButton("OK", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        i.a(i.this, null);
        paramAnonymousDialogInterface.cancel();
      }
    }).create();
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramDialog = (AlertDialog)paramDialog;
    if (this.d != null)
    {
      paramDialog.setMessage(this.d.a());
      return;
    }
    paramDialog.setMessage("An unknown error has occured.");
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    if (this.a != null) {
      this.a.a();
    }
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */