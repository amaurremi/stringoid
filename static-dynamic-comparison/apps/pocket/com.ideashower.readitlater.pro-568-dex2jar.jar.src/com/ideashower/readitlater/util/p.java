package com.ideashower.readitlater.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.d;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;

public class p
{
  private static p a;
  private int b;
  private boolean c = false;
  
  private p(int paramInt)
  {
    this.b = paramInt;
    if (this.b != a.Z.a) {
      this.c = true;
    }
  }
  
  public static p a()
  {
    if (a == null) {
      a = new p(i.a(a.Z));
    }
    return a;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = 0;
    int j = 1;
    switch (paramInt2)
    {
    default: 
      paramInt1 = 1;
      return paramInt1;
    case 2: 
      paramInt2 = j;
      if (paramInt1 != 2) {
        if (paramInt1 != 3) {
          break label61;
        }
      }
      label61:
      for (paramInt2 = j;; paramInt2 = 0)
      {
        paramInt1 = i;
        if (paramInt2 == 0) {
          break;
        }
        return 8;
      }
    }
    if (paramInt1 != 2)
    {
      paramInt2 = k;
      if (paramInt1 != 1) {}
    }
    else
    {
      paramInt2 = 1;
    }
    if (paramInt2 == 0) {
      return 1;
    }
    return 9;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    a(paramBoolean, paramActivity, false, 0);
  }
  
  public void a(boolean paramBoolean1, Activity paramActivity, boolean paramBoolean2, int paramInt)
  {
    this.c = paramBoolean1;
    if (paramBoolean1) {
      if (paramBoolean2) {
        this.b = paramInt;
      }
    }
    for (;;)
    {
      i.b().a(a.Z, this.b).a();
      paramActivity.setRequestedOrientation(this.b);
      return;
      this.b = a(paramActivity.getWindowManager().getDefaultDisplay().getRotation(), paramActivity.getResources().getConfiguration().orientation);
      continue;
      this.b = 4;
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */