package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public final class da
  implements cx
{
  private static final String a = da.class.getSimpleName();
  
  private boolean a(String paramString1, PackageManager paramPackageManager, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramPackageManager == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (-1 == paramPackageManager.checkPermission(paramString3, paramString2))
    {
      ja.b(a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml should include uses-permission node with " + "android:name=\"" + paramString3 + "\"");
      return false;
    }
    ja.a(3, a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml has uses-permission node with " + "android:name=\"" + paramString3 + "\"");
    return true;
  }
  
  public boolean a(Context paramContext, db paramdb)
  {
    if (paramdb == null) {}
    String str;
    do
    {
      do
      {
        return false;
        str = paramdb.a();
      } while (TextUtils.isEmpty(str));
      localObject = paramdb.d();
    } while (localObject == null);
    paramdb = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    Object localObject = ((List)localObject).iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      if (a(str, paramdb, paramContext, (String)((Iterator)localObject).next())) {
        break label90;
      }
      bool = false;
    }
    label90:
    for (;;)
    {
      break;
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */