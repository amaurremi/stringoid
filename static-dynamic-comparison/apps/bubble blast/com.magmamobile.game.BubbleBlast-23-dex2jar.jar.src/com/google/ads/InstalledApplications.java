package com.google.ads;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class InstalledApplications
{
  private static final int NOT_INSTALLED = 0;
  private final PackageManager mPackageManager;
  
  public InstalledApplications(PackageManager paramPackageManager)
  {
    this.mPackageManager = paramPackageManager;
  }
  
  public List<AdSpec.Parameter> getInstallationState()
  {
    LinkedList localLinkedList = new LinkedList();
    Application[] arrayOfApplication = Application.values();
    int j = arrayOfApplication.length;
    int i = 0;
    while (i < j)
    {
      Application localApplication = arrayOfApplication[i];
      localLinkedList.add(new AdSpec.Parameter(localApplication.getTag(), "" + localApplication.getVersionCode(this.mPackageManager)));
      i += 1;
    }
    return localLinkedList;
  }
  
  private static enum Application
  {
    YOUTUBE("app_youtube", "com.google.android.youtube");
    
    private String mPackageName;
    private String mTag;
    
    private Application(String paramString1, String paramString2)
    {
      this.mTag = paramString1;
      this.mPackageName = paramString2;
    }
    
    private String getTag()
    {
      return this.mTag;
    }
    
    private int getVersionCode(PackageManager paramPackageManager)
    {
      try
      {
        paramPackageManager = paramPackageManager.getPackageInfo(this.mPackageName, 0);
        if (paramPackageManager == null) {
          return 0;
        }
        int i = paramPackageManager.versionCode;
        return i;
      }
      catch (PackageManager.NameNotFoundException paramPackageManager) {}
      return 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/InstalledApplications.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */