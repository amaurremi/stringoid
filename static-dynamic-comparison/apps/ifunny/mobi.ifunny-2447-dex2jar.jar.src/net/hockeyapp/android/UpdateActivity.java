package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
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
import net.hockeyapp.android.c.d;
import net.hockeyapp.android.d.f;

public class UpdateActivity
        extends Activity
        implements View.OnClickListener, q {
    protected d a;
    protected f b;
    private final int c = 0;
    private net.hockeyapp.android.b.a d;
    private Context e;

    private boolean a(Context paramContext) {
        return paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private boolean h() {
        Object localObject = new String[1];
        localObject[0] = "value";
        if (Build.VERSION.SDK_INT >= 17) {
        }
        for (localObject = getContentResolver().query(Settings.Global.CONTENT_URI, (String[]) localObject, "name = ? AND value = ?", new String[]{"install_non_market_apps", String.valueOf(1)}, null); ((Cursor) localObject).getCount() == 1; localObject = getContentResolver().query(Settings.Secure.CONTENT_URI, (String[]) localObject, "name = ? AND value = ?", new String[]{"install_non_market_apps", String.valueOf(1)}, null)) {
            return true;
        }
        return false;
    }

    protected void a() {
        ((TextView) findViewById(4098)).setText(g());
        ((TextView) findViewById(4099)).setText("Version " + this.b.a() + "\n" + this.b.b());
        ((Button) findViewById(4100)).setOnClickListener(this);
        WebView localWebView = (WebView) findViewById(4101);
        localWebView.clearCache(true);
        localWebView.destroyDrawingCache();
        localWebView.loadDataWithBaseURL("https://sdk.hockeyapp.net/", b(), "text/html", "utf-8", null);
    }

    protected void a(String paramString) {
        a(paramString, new k(this));
        this.a.execute(new String[0]);
    }

    protected void a(String paramString, net.hockeyapp.android.a.a parama) {
        this.a = new d(this, paramString, parama);
    }

    protected String b() {
        return this.b.a(false);
    }

    protected void c() {
        a(getIntent().getStringExtra("url"));
    }

    public void d() {
        findViewById(4100).setEnabled(true);
    }

    public int e() {
        try {
            int i = getPackageManager().getPackageInfo(getPackageName(), 128).versionCode;
            return i;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
        }
        return -1;
    }

    public ViewGroup f() {
        return new net.hockeyapp.android.e.a(this);
    }

    public String g() {
        try {
            Object localObject = getPackageManager();
            localObject = ((PackageManager) localObject).getApplicationLabel(((PackageManager) localObject).getApplicationInfo(getPackageName(), 0)).toString();
            return (String) localObject;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
        }
        return "";
    }

    public void onClick(View paramView) {
        if (!a(this.e)) {
            this.d = new net.hockeyapp.android.b.a();
            this.d.a("The permission to access the external storage permission is not set. Please contact the developer.");
            runOnUiThread(new l(this));
            return;
        }
        if (!h()) {
            this.d = new net.hockeyapp.android.b.a();
            this.d.a("The installation from unknown sources is not enabled. Please check the device settings.");
            runOnUiThread(new m(this));
            return;
        }
        c();
        paramView.setEnabled(false);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setTitle("App Update");
        setContentView(f());
        this.e = this;
        this.b = new f(getIntent().getStringExtra("json"), this);
        a();
        this.a = ((d) getLastNonConfigurationInstance());
        if (this.a != null) {
            this.a.a(this);
        }
    }

    protected Dialog onCreateDialog(int paramInt) {
        switch (paramInt) {
            default:
                return null;
        }
        return new AlertDialog.Builder(this).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(17301543).setPositiveButton("OK", new n(this)).create();
    }

    protected void onPrepareDialog(int paramInt, Dialog paramDialog) {
        switch (paramInt) {
            default:
                return;
        }
        paramDialog = (AlertDialog) paramDialog;
        if (this.d != null) {
            paramDialog.setMessage(this.d.a());
            return;
        }
        paramDialog.setMessage("An unknown error has occured.");
    }

    public Object onRetainNonConfigurationInstance() {
        if (this.a != null) {
            this.a.a();
        }
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/UpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */