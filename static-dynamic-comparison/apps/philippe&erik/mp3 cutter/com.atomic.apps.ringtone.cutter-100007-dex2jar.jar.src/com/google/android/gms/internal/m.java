package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.a.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class m
{
  private static m a = new m();
  
  public static ah a(Context paramContext, A paramA)
  {
    Object localObject = paramA.a();
    long l;
    String str1;
    int i;
    label59:
    boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    if (localObject != null)
    {
      l = ((Date)localObject).getTime();
      str1 = paramA.b();
      i = paramA.c();
      localObject = paramA.d();
      if (((Set)localObject).isEmpty()) {
        break label151;
      }
      localObject = Collections.unmodifiableList(new ArrayList((Collection)localObject));
      bool1 = paramA.a(paramContext);
      j = paramA.k();
      localLocation = paramA.e();
      localBundle = paramA.a(a.class);
      bool2 = paramA.f();
      str2 = paramA.g();
      paramContext = paramA.h();
      if (paramContext == null) {
        break label157;
      }
    }
    label151:
    label157:
    for (paramContext = new av(paramContext);; paramContext = null)
    {
      return new ah(3, l, localBundle, i, (List)localObject, bool1, j, bool2, str2, paramContext, localLocation, str1);
      l = -1L;
      break;
      localObject = null;
      break label59;
    }
  }
  
  public static m a()
  {
    return a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */