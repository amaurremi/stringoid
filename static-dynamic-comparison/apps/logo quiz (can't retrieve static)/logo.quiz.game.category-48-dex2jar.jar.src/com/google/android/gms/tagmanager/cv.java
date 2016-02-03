package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class cv
  extends aj
{
  private static final String ID = a.U.toString();
  
  public cv()
  {
    super(ID, new String[0]);
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    return di.u(Integer.valueOf(Build.VERSION.SDK_INT));
  }
  
  public boolean nL()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */