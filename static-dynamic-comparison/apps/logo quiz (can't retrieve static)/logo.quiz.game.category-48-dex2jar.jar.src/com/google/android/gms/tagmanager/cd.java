package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

abstract class cd
  extends aj
{
  private static final String aoU = b.bw.toString();
  private static final String apQ = b.bx.toString();
  
  public cd(String paramString)
  {
    super(paramString, new String[] { aoU, apQ });
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((d.a)((Iterator)localObject).next() == di.pI()) {
        return di.u(Boolean.valueOf(false));
      }
    }
    localObject = (d.a)paramMap.get(aoU);
    d.a locala = (d.a)paramMap.get(apQ);
    if ((localObject == null) || (locala == null)) {}
    for (boolean bool = false;; bool = a((d.a)localObject, locala, paramMap)) {
      return di.u(Boolean.valueOf(bool));
    }
  }
  
  protected abstract boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap);
  
  public boolean nL()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */