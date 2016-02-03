package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class by
  extends cd
{
  public by(String paramString)
  {
    super(paramString);
  }
  
  protected boolean a(d.a parama1, d.a parama2, Map<String, d.a> paramMap)
  {
    parama1 = di.k(parama1);
    parama2 = di.k(parama2);
    if ((parama1 == di.pG()) || (parama2 == di.pG())) {
      return false;
    }
    return a(parama1, parama2, paramMap);
  }
  
  protected abstract boolean a(dh paramdh1, dh paramdh2, Map<String, d.a> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */