package net.hockeyapp.android.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;

import net.hockeyapp.android.UpdateActivity;
import net.hockeyapp.android.d.e;
import net.hockeyapp.android.d.f;
import net.hockeyapp.android.j;
import net.hockeyapp.android.o;
import net.hockeyapp.android.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
        extends AsyncTask<String, String, JSONArray> {
    protected String a;
    protected String b;
    private Activity c;
    private Boolean d;
    private s e;
    private long f;

    private static String a(InputStream paramInputStream) {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1024);
        StringBuilder localStringBuilder = new StringBuilder();
        try {
            for (; ; ) {
                String str = localBufferedReader.readLine();
                if (str == null) {
                    break;
                }
                localStringBuilder.append(str + "\n");
            }
            try {
                paramInputStream.close();
                throw ((Throwable) localObject);
            } catch (IOException paramInputStream) {
                for (; ; ) {
                    paramInputStream.printStackTrace();
                }
            }
        } catch (IOException localIOException) {
            localIOException = localIOException;
            localIOException.printStackTrace();
            try {
                paramInputStream.close();
                for (; ; ) {
                    return localStringBuilder.toString();
                    try {
                        paramInputStream.close();
                    } catch (IOException paramInputStream) {
                        paramInputStream.printStackTrace();
                    }
                }
            } catch (IOException paramInputStream) {
                for (; ; ) {
                    paramInputStream.printStackTrace();
                }
            }
        } finally {
        }
    }

    @TargetApi(11)
    private void a(JSONArray paramJSONArray, Boolean paramBoolean) {
        Object localObject1 = null;
        if (this.e != null) {
            localObject1 = this.e.a();
        }
        Object localObject2 = localObject1;
        if (localObject1 == null) {
            localObject2 = UpdateActivity.class;
        }
        if (this.c != null) {
            localObject1 = new Intent();
            ((Intent) localObject1).setClass(this.c, (Class) localObject2);
            ((Intent) localObject1).putExtra("json", paramJSONArray.toString());
            ((Intent) localObject1).putExtra("url", a("apk"));
            this.c.startActivity((Intent) localObject1);
            if (paramBoolean.booleanValue()) {
                this.c.finish();
            }
        }
        c();
    }

    private boolean a(JSONArray paramJSONArray, int paramInt) {
        boolean bool2 = false;
        int i = 0;
        for (; ; ) {
            boolean bool1 = bool2;
            try {
                if (i < paramJSONArray.length()) {
                    JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
                    if ((localJSONObject.getInt("version") > paramInt) && (f.a(localJSONObject.getString("minimum_os_version"), Build.VERSION.RELEASE) <= 0)) {
                        if (localJSONObject.has("mandatory")) {
                            this.d = Boolean.valueOf(localJSONObject.getBoolean("mandatory"));
                        }
                        bool1 = true;
                    }
                } else {
                    return bool1;
                }
                i += 1;
            } catch (JSONException paramJSONArray) {
            }
        }
        return false;
    }

    private String b(String paramString) {
        try {
            paramString = URLEncoder.encode(paramString, "UTF-8");
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
        }
        return "";
    }

    private JSONArray b(JSONArray paramJSONArray) {
        JSONArray localJSONArray = new JSONArray();
        int i = 0;
        for (; ; ) {
            if (i < Math.min(paramJSONArray.length(), 25)) {
            }
            try {
                localJSONArray.put(paramJSONArray.get(i));
                i += 1;
                continue;
                return localJSONArray;
            } catch (JSONException localJSONException) {
                for (; ; ) {
                }
            }
        }
    }

    private void c() {
        this.c = null;
        this.a = null;
        this.b = null;
    }

    @TargetApi(11)
    private void c(JSONArray paramJSONArray) {
        if (b()) {
            e.a(this.c, paramJSONArray.toString());
        }
        if ((this.c == null) || (this.c.isFinishing())) {
            return;
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.c);
        localBuilder.setTitle(j.a(this.e, 9));
        if (!this.d.booleanValue()) {
            localBuilder.setMessage(j.a(this.e, 10));
            localBuilder.setNegativeButton(j.a(this.e, 11), new b(this));
            localBuilder.setPositiveButton(j.a(this.e, 12), new c(this, paramJSONArray));
            localBuilder.create().show();
            return;
        }
        Toast.makeText(this.c, j.a(this.e, 8), 1).show();
        a(paramJSONArray, Boolean.valueOf(true));
    }

    @TargetApi(11)
    private void d(JSONArray paramJSONArray) {
        FragmentTransaction localFragmentTransaction;
        Object localObject;
        if (this.c != null) {
            localFragmentTransaction = this.c.getFragmentManager().beginTransaction();
            localFragmentTransaction.setTransition(4097);
            localObject = this.c.getFragmentManager().findFragmentByTag("hockey_update_dialog");
            if (localObject != null) {
                localFragmentTransaction.remove((Fragment) localObject);
            }
            localFragmentTransaction.addToBackStack(null);
            localObject = o.class;
            if (this.e != null) {
                localObject = this.e.b();
            }
        }
        try {
            ((DialogFragment) ((Class) localObject).getMethod("newInstance", new Class[]{JSONArray.class, String.class}).invoke(null, new Object[]{paramJSONArray, a("apk")})).show(localFragmentTransaction, "hockey_update_dialog");
            return;
        } catch (Exception localException) {
            Log.d("HockeyApp", "An exception happened while showing the update fragment:");
            localException.printStackTrace();
            Log.d("HockeyApp", "Showing update activity instead.");
            a(paramJSONArray, Boolean.valueOf(false));
        }
    }

    protected int a() {
        return Integer.parseInt(net.hockeyapp.android.a.b);
    }

    protected String a(String paramString) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append("api/2/apps/");
        if (this.b != null) {
        }
        for (String str = this.b; ; str = this.c.getPackageName()) {
            localStringBuilder.append(str);
            localStringBuilder.append("?format=" + paramString);
            if (Settings.Secure.getString(this.c.getContentResolver(), "android_id") != null) {
                localStringBuilder.append("&udid=" + b(Settings.Secure.getString(this.c.getContentResolver(), "android_id")));
            }
            localStringBuilder.append("&os=Android");
            localStringBuilder.append("&os_version=" + b(net.hockeyapp.android.a.e));
            localStringBuilder.append("&device=" + b(net.hockeyapp.android.a.f));
            localStringBuilder.append("&oem=" + b(net.hockeyapp.android.a.g));
            localStringBuilder.append("&app_version=" + b(net.hockeyapp.android.a.b));
            localStringBuilder.append("&sdk=" + b("HockeySDK"));
            localStringBuilder.append("&sdk_version=" + b("3.0.2"));
            localStringBuilder.append("&lang=" + b(Locale.getDefault().getLanguage()));
            localStringBuilder.append("&usage_time=" + this.f);
            return localStringBuilder.toString();
        }
    }

    protected URLConnection a(URL paramURL) {
        paramURL = paramURL.openConnection();
        paramURL.addRequestProperty("User-Agent", "HockeySDK/Android");
        if (Build.VERSION.SDK_INT <= 9) {
            paramURL.setRequestProperty("connection", "close");
        }
        return paramURL;
    }

    protected JSONArray a(String... paramVarArgs) {
        try {
            int i = a();
            paramVarArgs = new JSONArray(e.a(this.c));
            if ((b()) && (a(paramVarArgs, i))) {
                return paramVarArgs;
            }
            paramVarArgs = a(new URL(a("json")));
            paramVarArgs.connect();
            paramVarArgs = new BufferedInputStream(paramVarArgs.getInputStream());
            String str = a(paramVarArgs);
            paramVarArgs.close();
            paramVarArgs = new JSONArray(str);
            if (a(paramVarArgs, i)) {
                paramVarArgs = b(paramVarArgs);
                return paramVarArgs;
            }
        } catch (Exception paramVarArgs) {
            paramVarArgs.printStackTrace();
        }
        return null;
    }

    protected void a(JSONArray paramJSONArray) {
        if (paramJSONArray != null) {
            if (this.e != null) {
                this.e.d();
            }
            c(paramJSONArray);
        }
        while (this.e == null) {
            return;
        }
        this.e.c();
    }

    protected boolean b() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */