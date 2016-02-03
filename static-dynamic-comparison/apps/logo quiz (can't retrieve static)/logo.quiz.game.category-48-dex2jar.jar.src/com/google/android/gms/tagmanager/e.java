package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class e
  extends aj
{
  private static final String ID = a.Y.toString();
  private static final String anI = b.bW.toString();
  private static final String anJ = b.bZ.toString();
  private final Context lB;
  
  public e(Context paramContext)
  {
    super(ID, new String[] { anJ });
    this.lB = paramContext;
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(anJ);
    if (localObject == null) {
      return di.pI();
    }
    localObject = di.j((d.a)localObject);
    paramMap = (d.a)paramMap.get(anI);
    if (paramMap != null) {}
    for (paramMap = di.j(paramMap);; paramMap = null)
    {
      paramMap = ay.f(this.lB, (String)localObject, paramMap);
      if (paramMap == null) {
        break;
      }
      return di.u(paramMap);
    }
    return di.pI();
  }
  
  public boolean nL()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */