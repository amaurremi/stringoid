package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class m
  extends aj
{
  private static final String ID = a.A.toString();
  private static final String VALUE = b.ff.toString();
  
  public m()
  {
    super(ID, new String[] { VALUE });
  }
  
  public static String nO()
  {
    return ID;
  }
  
  public static String nP()
  {
    return VALUE;
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    return (d.a)paramMap.get(VALUE);
  }
  
  public boolean nL()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */