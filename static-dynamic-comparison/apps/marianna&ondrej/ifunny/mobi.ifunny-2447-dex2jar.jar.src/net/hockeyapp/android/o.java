package net.hockeyapp.android;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import net.hockeyapp.android.c.d;
import net.hockeyapp.android.d.f;
import net.hockeyapp.android.e.a;
import org.json.JSONArray;
import org.json.JSONException;

public class o
        extends DialogFragment
        implements View.OnClickListener, q {
    private d a;
    private JSONArray b;
    private String c;
    private f d;

    private void a(Activity paramActivity) {
        this.a = new d(paramActivity, this.c, new p(this, paramActivity));
        this.a.execute(new String[0]);
    }

    public String a() {
        Object localObject = getActivity();
        try {
            PackageManager localPackageManager = ((Activity) localObject).getPackageManager();
            localObject = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(((Activity) localObject).getPackageName(), 0)).toString();
            return (String) localObject;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
        }
        return "";
    }

    public View b() {
        return new a(getActivity(), false, true);
    }

    public int e() {
        try {
            int i = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 128).versionCode;
            return i;
        } catch (NullPointerException localNullPointerException) {
            return -1;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
        }
        return -1;
    }

    public void onClick(View paramView) {
        a(getActivity());
        dismiss();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        try {
            this.c = getArguments().getString("url");
            this.b = new JSONArray(getArguments().getString("versionInfo"));
            setStyle(1, 16973939);
            return;
        } catch (JSONException paramBundle) {
            dismiss();
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = b();
        this.d = new f(this.b.toString(), this);
        ((TextView) paramLayoutInflater.findViewById(4098)).setText(a());
        ((TextView) paramLayoutInflater.findViewById(4099)).setText("Version " + this.d.a() + "\n" + this.d.b());
        ((Button) paramLayoutInflater.findViewById(4100)).setOnClickListener(this);
        paramViewGroup = (WebView) paramLayoutInflater.findViewById(4101);
        paramViewGroup.clearCache(true);
        paramViewGroup.destroyDrawingCache();
        paramViewGroup.loadDataWithBaseURL("https://sdk.hockeyapp.net/", this.d.a(false), "text/html", "utf-8", null);
        return paramLayoutInflater;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */