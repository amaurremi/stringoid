package com.google.tagmanager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class PreviewActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      f.B("Preview activity");
      paramBundle = getIntent().getData();
      if (!TagManager.V(this).h(paramBundle))
      {
        f.D("Cannot preview the app with the uri: " + paramBundle);
        return;
      }
      paramBundle = getPackageManager().getLaunchIntentForPackage(getPackageName());
      if (paramBundle != null)
      {
        f.B("Invoke the launch activity for package name: " + getPackageName());
        startActivity(paramBundle);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      f.A("Calling preview threw an exception: " + paramBundle.getMessage());
      return;
    }
    f.B("No launch activity found for package name: " + getPackageName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/PreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */