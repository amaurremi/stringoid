package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class u
  extends aj
{
  private static final String ID = a.C.toString();
  private static final String NAME = b.dB.toString();
  private static final String aoE = b.cr.toString();
  private final DataLayer anS;
  
  public u(DataLayer paramDataLayer)
  {
    super(ID, new String[] { NAME });
    this.anS = paramDataLayer;
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    Object localObject = this.anS.get(di.j((d.a)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (d.a)paramMap.get(aoE);
      if (paramMap != null) {
        return paramMap;
      }
      return di.pI();
    }
    return di.u(localObject);
  }
  
  public boolean nL()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */