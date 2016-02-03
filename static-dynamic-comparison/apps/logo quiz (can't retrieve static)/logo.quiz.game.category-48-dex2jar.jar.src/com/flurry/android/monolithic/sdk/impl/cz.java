package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public final class cz
  implements cx
{
  private static final String a = cz.class.getSimpleName();
  
  private boolean a(String paramString1, String paramString2, Bundle paramBundle, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramBundle == null) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    paramBundle = paramBundle.getString(paramString3);
    if (TextUtils.isEmpty(paramBundle))
    {
      ja.b(a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml should include meta-data node with android:name=\"" + paramString3 + "\" and not empty value for android:value");
      return false;
    }
    ja.a(3, a, paramString1 + ": package=\"" + paramString2 + "\": AndroidManifest.xml has meta-data node with android:name=\"" + paramString3 + "\" and android:value=\"" + paramBundle + "\"");
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
      localObject = paramdb.c();
    } while (localObject == null);
    paramdb = il.e(paramContext);
    paramContext = paramContext.getPackageName();
    Object localObject = ((List)localObject).iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      if (a(str, paramContext, paramdb, (String)((Iterator)localObject).next())) {
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */