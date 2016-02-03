package a.a.a;

import a.a.a.a.a;
import a.a.a.d.e;
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
import org.json.JSONArray;
import org.json.JSONException;

public class j
  extends DialogFragment
  implements k, View.OnClickListener
{
  private a.a.a.c.b downloadTask;
  private String urlString;
  private e versionHelper;
  private JSONArray versionInfo;
  
  public static j newInstance(JSONArray paramJSONArray, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putString("versionInfo", paramJSONArray.toString());
    paramJSONArray = new j();
    paramJSONArray.setArguments(localBundle);
    return paramJSONArray;
  }
  
  private void startDownloadTask(final Activity paramActivity)
  {
    this.downloadTask = new a.a.a.c.b(paramActivity, this.urlString, new a()
    {
      public String a(int paramAnonymousInt)
      {
        m localm = l.b();
        if (localm != null) {
          return localm.a(paramAnonymousInt);
        }
        return null;
      }
      
      public void a(a.a.a.c.b paramAnonymousb) {}
      
      public void a(a.a.a.c.b paramAnonymousb, Boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean.booleanValue()) {
          j.this.startDownloadTask(paramActivity);
        }
      }
    });
    this.downloadTask.execute(new String[0]);
  }
  
  public String getAppName()
  {
    Object localObject = getActivity();
    try
    {
      PackageManager localPackageManager = ((Activity)localObject).getPackageManager();
      localObject = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(((Activity)localObject).getPackageName(), 0)).toString();
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return "";
  }
  
  public int getCurrentVersionCode()
  {
    try
    {
      int i = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 128).versionCode;
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      return -1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return -1;
  }
  
  public View getLayoutView()
  {
    return new a.a.a.e.b(getActivity(), false, true);
  }
  
  public void onClick(View paramView)
  {
    startDownloadTask(getActivity());
    dismiss();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      this.urlString = getArguments().getString("url");
      this.versionInfo = new JSONArray(getArguments().getString("versionInfo"));
      setStyle(1, 16973939);
      return;
    }
    catch (JSONException paramBundle)
    {
      dismiss();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getLayoutView();
    this.versionHelper = new e(this.versionInfo.toString(), this);
    ((TextView)paramLayoutInflater.findViewById(4098)).setText(getAppName());
    ((TextView)paramLayoutInflater.findViewById(4099)).setText("Version " + this.versionHelper.a() + "\n" + this.versionHelper.b());
    ((Button)paramLayoutInflater.findViewById(4100)).setOnClickListener(this);
    paramViewGroup = (WebView)paramLayoutInflater.findViewById(4101);
    paramViewGroup.clearCache(true);
    paramViewGroup.destroyDrawingCache();
    paramViewGroup.loadDataWithBaseURL("https://sdk.hockeyapp.net/", this.versionHelper.a(false), "text/html", "utf-8", null);
    return paramLayoutInflater;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */