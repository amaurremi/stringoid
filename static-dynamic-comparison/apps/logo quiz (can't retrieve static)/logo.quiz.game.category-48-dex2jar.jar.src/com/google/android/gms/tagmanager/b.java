package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class b
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.u.toString();
  private final a anH;
  
  public b(Context paramContext)
  {
    this(a.V(paramContext));
  }
  
  b(a parama)
  {
    super(ID, new String[0]);
    this.anH = parama;
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    paramMap = this.anH.nH();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */