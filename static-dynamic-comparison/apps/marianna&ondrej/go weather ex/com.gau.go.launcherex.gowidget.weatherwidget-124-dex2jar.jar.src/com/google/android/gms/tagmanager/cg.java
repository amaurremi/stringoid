package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cg
  extends aj
{
  private static final String ID = a.ae.toString();
  private static final String YZ = b.bi.toString();
  private static final String Za = b.bj.toString();
  private static final String Zb = b.cF.toString();
  private static final String Zc = b.cz.toString();
  
  public cg()
  {
    super(ID, new String[] { YZ, Za });
  }
  
  public boolean jX()
  {
    return true;
  }
  
  public d.a x(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(YZ);
    d.a locala = (d.a)paramMap.get(Za);
    if ((localObject == null) || (localObject == dh.lT()) || (locala == null) || (locala == dh.lT())) {
      return dh.lT();
    }
    int i = 64;
    if (dh.n((d.a)paramMap.get(Zb)).booleanValue()) {
      i = 66;
    }
    paramMap = (d.a)paramMap.get(Zc);
    int j;
    if (paramMap != null)
    {
      paramMap = dh.l(paramMap);
      if (paramMap == dh.lO()) {
        return dh.lT();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return dh.lT();
      }
    }
    else
    {
      j = 1;
    }
    try
    {
      paramMap = dh.j((d.a)localObject);
      localObject = dh.j(locala);
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
        return dh.lT();
      }
      paramMap = dh.r(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return dh.lT();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */