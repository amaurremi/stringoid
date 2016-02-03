package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class p
  extends aj
{
  private static final String ID = a.D.toString();
  private final String Sq;
  
  public p(String paramString)
  {
    super(ID, new String[0]);
    this.Sq = paramString;
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    if (this.Sq == null) {
      return di.pI();
    }
    return di.u(this.Sq);
  }
  
  public boolean nL()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */