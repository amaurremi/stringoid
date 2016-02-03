package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch
  extends aj
{
  private static final String ID = a.ag.toString();
  private static final String aqc = b.bw.toString();
  private static final String aqd = b.bx.toString();
  private static final String aqe = b.dc.toString();
  private static final String aqf = b.cW.toString();
  
  public ch()
  {
    super(ID, new String[] { aqc, aqd });
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(aqc);
    d.a locala = (d.a)paramMap.get(aqd);
    if ((localObject == null) || (localObject == di.pI()) || (locala == null) || (locala == di.pI())) {
      return di.pI();
    }
    int i = 64;
    if (di.n((d.a)paramMap.get(aqe)).booleanValue()) {
      i = 66;
    }
    paramMap = (d.a)paramMap.get(aqf);
    int j;
    if (paramMap != null)
    {
      paramMap = di.l(paramMap);
      if (paramMap == di.pD()) {
        return di.pI();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return di.pI();
      }
    }
    else
    {
      j = 1;
    }
    try
    {
      paramMap = di.j((d.a)localObject);
      localObject = di.j(locala);
      locala = null;
      localObject = Pattern.compile((String)localObject, i).matcher(paramMap);
      paramMap = locala;
      if (((Matcher)localObject).find())
      {
        paramMap = locala;
        if (((Matcher)localObject).groupCount() >= j) {
          paramMap = ((Matcher)localObject).group(j);
        }
      }
      if (paramMap == null) {
        return di.pI();
      }
      paramMap = di.u(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return di.pI();
  }
  
  public boolean nL()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */