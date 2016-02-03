package com.ideashower.readitlater.h;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import com.ideashower.readitlater.activity.f;
import com.ideashower.readitlater.views.t;

public class m
{
  public static final int[] a = { 2130772083 };
  public static final int[] b = { 2130772084 };
  public static final int[] c = { 2130772082 };
  public static final int[] d = { 2130772085 };
  
  public static int a()
  {
    return a((Context)null);
  }
  
  private static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    if (a(paramInt1)) {
      if ((paramBoolean) && (i.a(a.ax))) {
        paramInt1 = 4;
      }
    }
    for (;;)
    {
      int i = paramInt1;
      switch (paramInt2)
      {
      case 1: 
      default: 
        if (paramInt1 == 2) {
          paramInt1 = j;
        }
        break;
      }
      for (;;)
      {
        i = paramInt1;
        do
        {
          return i;
          paramInt1 = 1;
          break;
          return 4;
          return 0;
          i = paramInt1;
        } while (paramInt1 != 2);
        return 0;
        if (paramInt1 == 4) {
          paramInt1 = 1;
        }
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    int j = i.a(a.av);
    int i = 0;
    boolean bool = true;
    paramContext = com.ideashower.readitlater.activity.a.a(paramContext);
    if (paramContext != null)
    {
      i = paramContext.s();
      bool = paramContext.t();
    }
    return a(j, i, bool);
  }
  
  public static int a(View paramView)
  {
    return a(paramView, null);
  }
  
  public static int a(View paramView, Fragment paramFragment)
  {
    boolean bool = false;
    int j = i.a(a.av);
    com.ideashower.readitlater.activity.a locala = com.ideashower.readitlater.activity.a.a(paramView.getContext());
    int i;
    if (locala != null) {
      if (paramFragment == null)
      {
        paramFragment = locala.a(paramView);
        if ((paramFragment instanceof f))
        {
          i = ((f)paramFragment).U();
          bool = ((f)paramFragment).V();
        }
      }
    }
    for (;;)
    {
      return a(j, i, bool);
      return a(paramView.getContext());
      break;
      i = 0;
    }
  }
  
  public static void a(t paramt)
  {
    ((com.ideashower.readitlater.activity.a)paramt.getContext()).a(paramt);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 4);
  }
  
  public static boolean a(int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        int k = paramArrayOfInt[i];
        if ((k == a[0]) || (k == d[0])) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt2 = paramArrayOfInt1;
    int[] arrayOfInt1 = paramArrayOfInt2;
    if (paramArrayOfInt1 == null) {
      if (paramArrayOfInt2 != null) {}
    }
    int i2;
    int k;
    int j;
    int i;
    int i1;
    int n;
    do
    {
      int i3;
      do
      {
        return true;
        arrayOfInt1 = null;
        arrayOfInt2 = paramArrayOfInt2;
        i2 = arrayOfInt2.length;
        m = 0;
        k = 0;
        j = 0;
        i = 0;
        if (m < i2)
        {
          i3 = arrayOfInt2[m];
          if (i3 == a[0])
          {
            i1 = 1;
            n = j;
          }
          for (;;)
          {
            m += 1;
            j = n;
            i = i1;
            break;
            if (i3 == d[0])
            {
              n = 1;
              i1 = i;
            }
            else
            {
              n = j;
              i1 = i;
              if (i3 == b[0])
              {
                k = 1;
                n = j;
                i1 = i;
              }
            }
          }
        }
        if (arrayOfInt1 != null) {
          break;
        }
      } while ((i == 0) && (j == 0) && (k == 0));
      return false;
      int i5 = arrayOfInt1.length;
      int m = 0;
      i2 = 0;
      i1 = 0;
      n = 0;
      if (m < i5)
      {
        int i6 = arrayOfInt1[m];
        int i4;
        if (i6 == a[0])
        {
          if (i == 0) {
            return false;
          }
          i4 = 1;
          i3 = i1;
        }
        for (;;)
        {
          m += 1;
          i1 = i3;
          n = i4;
          break;
          if (i6 == d[0])
          {
            if (j == 0) {
              return false;
            }
            i3 = 1;
            i4 = n;
          }
          else
          {
            i3 = i1;
            i4 = n;
            if (i6 == b[0])
            {
              if (k == 0) {
                return false;
              }
              i2 = 1;
              i3 = i1;
              i4 = n;
            }
          }
        }
      }
    } while ((i == n) && (j == i1) && (k == i2));
    return false;
  }
  
  public static int[] a(View paramView, f paramf)
  {
    return c(a(paramView, paramf));
  }
  
  public static void b(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 4) {
      i = 1;
    }
    i.b().a(a.av, i).a(a.aw, a(i)).a();
  }
  
  public static boolean b(Context paramContext)
  {
    return a(a(paramContext));
  }
  
  public static boolean b(int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == b[0]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int[] b(View paramView)
  {
    return c(a(paramView, null));
  }
  
  public static int c(Context paramContext)
  {
    int i;
    switch (a(paramContext))
    {
    case 3: 
    default: 
      i = 2131165252;
    }
    for (;;)
    {
      return paramContext.getResources().getColor(i);
      i = 2131165249;
      continue;
      i = 2131165250;
      continue;
      i = 2131165271;
    }
  }
  
  public static int[] c(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return c;
    case 4: 
      return d;
    case 1: 
      return a;
    }
    return b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/h/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */