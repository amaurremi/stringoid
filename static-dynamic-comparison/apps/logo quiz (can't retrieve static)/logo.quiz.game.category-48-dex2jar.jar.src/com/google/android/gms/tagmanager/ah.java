package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ah
  extends aj
{
  private static final String ID = a.K.toString();
  private final ct anT;
  
  public ah(ct paramct)
  {
    super(ID, new String[0]);
    this.anT = paramct;
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    paramMap = this.anT.pl();
    if (paramMap == null) {
      return di.pI();
    }
    return di.u(paramMap);
  }
  
  public boolean nL()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */