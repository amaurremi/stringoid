package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public final class cv
  implements cx
{
  private static final String a = cv.class.getSimpleName();
  
  private boolean a(String paramString1, String paramString2, cu paramcu)
  {
    boolean bool2 = false;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramcu == null)) {
      return false;
    }
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramcu.c()))
      {
        Class.forName(paramcu.c());
        bool1 = true;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ja.a(6, a, "failed to find third party ad provider api with exception: ", localClassNotFoundException);
        bool1 = bool2;
      }
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      for (;;)
      {
        ja.a(6, a, "failed to initialize third party ad provider api with exception: ", localExceptionInInitializerError);
        bool1 = bool2;
      }
    }
    catch (LinkageError localLinkageError)
    {
      for (;;)
      {
        ja.a(6, a, "failed to link third party ad provider api with exception: ", localLinkageError);
        bool1 = bool2;
      }
      ja.a(3, a, paramString1 + ": package=\"" + paramString2 + "\": apk has ad provider library with name=\"" + paramcu.a() + "\" and version=\"" + paramcu.b() + "\" or higher");
    }
    if (!bool1)
    {
      ja.b(a, paramString1 + ": package=\"" + paramString2 + "\": apk should include ad provider library with name=\"" + paramcu.a() + "\" and version=\"" + paramcu.b() + "\" or higher");
      return bool1;
    }
    return bool1;
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
      paramdb = paramdb.b();
    } while (paramdb == null);
    paramContext = paramContext.getPackageName();
    paramdb = paramdb.iterator();
    boolean bool = true;
    if (paramdb.hasNext())
    {
      if (a(str, paramContext, (cu)paramdb.next())) {
        break label78;
      }
      bool = false;
    }
    label78:
    for (;;)
    {
      break;
      return bool;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */