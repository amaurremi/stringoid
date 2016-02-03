package a.a.a.c;

import a.a.a.d.d;
import a.a.a.d.e;
import a.a.a.g;
import a.a.a.h;
import a.a.a.i;
import a.a.a.j;
import a.a.a.l;
import a.a.a.m;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends AsyncTask
{
  protected String a = null;
  protected String b = null;
  private Activity c = null;
  private Boolean d = Boolean.valueOf(false);
  private m e;
  private long f = 0L;
  
  public a(WeakReference paramWeakReference, String paramString1, String paramString2, m paramm)
  {
    this.b = paramString2;
    this.a = paramString1;
    this.e = paramm;
    if (paramWeakReference != null) {
      this.c = ((Activity)paramWeakReference.get());
    }
    if (this.c != null)
    {
      this.f = h.a(this.c);
      a.a.a.a.a(this.c);
    }
  }
  
  private static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1024);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "\n");
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localIOException.printStackTrace();
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  @TargetApi(11)
  private void a(JSONArray paramJSONArray, Boolean paramBoolean)
  {
    Object localObject1 = null;
    if (this.e != null) {
      localObject1 = this.e.a();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = i.class;
    }
    if (this.c != null)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).setClass(this.c, (Class)localObject2);
      ((Intent)localObject1).putExtra("json", paramJSONArray.toString());
      ((Intent)localObject1).putExtra("url", a("apk"));
      this.c.startActivity((Intent)localObject1);
      if (paramBoolean.booleanValue()) {
        this.c.finish();
      }
    }
    c();
  }
  
  private boolean a(JSONArray paramJSONArray, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      try
      {
        if (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if ((localJSONObject.getInt("version") > paramInt) && (e.a(localJSONObject.getString("minimum_os_version"), Build.VERSION.RELEASE) <= 0))
          {
            if (localJSONObject.has("mandatory")) {
              this.d = Boolean.valueOf(localJSONObject.getBoolean("mandatory"));
            }
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      catch (JSONException paramJSONArray) {}
    }
    return false;
  }
  
  private String b(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return "";
  }
  
  private JSONArray b(JSONArray paramJSONArray)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < Math.min(paramJSONArray.length(), 25)) {}
      try
      {
        localJSONArray.put(paramJSONArray.get(i));
        i += 1;
        continue;
        return localJSONArray;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  private void c()
  {
    this.c = null;
    this.a = null;
    this.b = null;
  }
  
  @TargetApi(11)
  private void c(final JSONArray paramJSONArray)
  {
    if (b()) {
      d.a(this.c, paramJSONArray.toString());
    }
    if ((this.c == null) || (this.c.isFinishing())) {
      return;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.c);
    localBuilder.setTitle(g.a(this.e, 9));
    if (!this.d.booleanValue())
    {
      localBuilder.setMessage(g.a(this.e, 10));
      localBuilder.setNegativeButton(g.a(this.e, 11), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          a.a(a.this);
        }
      });
      localBuilder.setPositiveButton(g.a(this.e, 12), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (a.this.b()) {
            d.a(a.b(a.this), "[]");
          }
          paramAnonymousDialogInterface = new WeakReference(a.b(a.this));
          if ((l.a().booleanValue()) && (l.a(paramAnonymousDialogInterface).booleanValue()))
          {
            a.a(a.this, paramJSONArray);
            return;
          }
          a.a(a.this, paramJSONArray, Boolean.valueOf(false));
        }
      });
      localBuilder.create().show();
      return;
    }
    Toast.makeText(this.c, g.a(this.e, 8), 1).show();
    a(paramJSONArray, Boolean.valueOf(true));
  }
  
  @TargetApi(11)
  private void d(JSONArray paramJSONArray)
  {
    FragmentTransaction localFragmentTransaction;
    Object localObject;
    if (this.c != null)
    {
      localFragmentTransaction = this.c.getFragmentManager().beginTransaction();
      localFragmentTransaction.setTransition(4097);
      localObject = this.c.getFragmentManager().findFragmentByTag("hockey_update_dialog");
      if (localObject != null) {
        localFragmentTransaction.remove((Fragment)localObject);
      }
      localFragmentTransaction.addToBackStack(null);
      localObject = j.class;
      if (this.e != null) {
        localObject = this.e.b();
      }
    }
    try
    {
      ((DialogFragment)((Class)localObject).getMethod("newInstance", new Class[] { JSONArray.class, String.class }).invoke(null, new Object[] { paramJSONArray, a("apk") })).show(localFragmentTransaction, "hockey_update_dialog");
      return;
    }
    catch (Exception localException)
    {
      Log.d("HockeyApp", "An exception happened while showing the update fragment:");
      localException.printStackTrace();
      Log.d("HockeyApp", "Showing update activity instead.");
      a(paramJSONArray, Boolean.valueOf(false));
    }
  }
  
  protected int a()
  {
    return Integer.parseInt(a.a.a.a.b);
  }
  
  protected String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("api/2/apps/");
    if (this.b != null) {}
    for (String str = this.b;; str = this.c.getPackageName())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("?format=" + paramString);
      if (Settings.Secure.getString(this.c.getContentResolver(), "android_id") != null) {
        localStringBuilder.append("&udid=" + b(Settings.Secure.getString(this.c.getContentResolver(), "android_id")));
      }
      localStringBuilder.append("&os=Android");
      localStringBuilder.append("&os_version=" + b(a.a.a.a.e));
      localStringBuilder.append("&device=" + b(a.a.a.a.f));
      localStringBuilder.append("&oem=" + b(a.a.a.a.g));
      localStringBuilder.append("&app_version=" + b(a.a.a.a.b));
      localStringBuilder.append("&sdk=" + b("HockeySDK"));
      localStringBuilder.append("&sdk_version=" + b("3.0.1"));
      localStringBuilder.append("&lang=" + b(Locale.getDefault().getLanguage()));
      localStringBuilder.append("&usage_time=" + this.f);
      return localStringBuilder.toString();
    }
  }
  
  protected URLConnection a(URL paramURL)
  {
    paramURL = paramURL.openConnection();
    paramURL.addRequestProperty("User-Agent", "HockeySDK/Android");
    if (Build.VERSION.SDK_INT <= 9) {
      paramURL.setRequestProperty("connection", "close");
    }
    return paramURL;
  }
  
  protected JSONArray a(String... paramVarArgs)
  {
    try
    {
      int i = a();
      paramVarArgs = new JSONArray(d.a(this.c));
      if ((b()) && (a(paramVarArgs, i))) {
        return paramVarArgs;
      }
      paramVarArgs = a(new URL(a("json")));
      paramVarArgs.connect();
      paramVarArgs = new BufferedInputStream(paramVarArgs.getInputStream());
      String str = a(paramVarArgs);
      paramVarArgs.close();
      paramVarArgs = new JSONArray(str);
      if (a(paramVarArgs, i))
      {
        paramVarArgs = b(paramVarArgs);
        return paramVarArgs;
      }
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return null;
  }
  
  public void a(WeakReference paramWeakReference)
  {
    if (paramWeakReference != null) {
      this.c = ((Activity)paramWeakReference.get());
    }
    if (this.c != null) {
      a.a.a.a.a(this.c);
    }
  }
  
  protected void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
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
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */