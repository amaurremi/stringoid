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
  private static final String agE = b.bi.toString();
  private static final String agF = b.bj.toString();
  private static final String agG = b.cF.toString();
  private static final String agH = b.cz.toString();
  
  public cg()
  {
    super(ID, new String[] { agE, agF });
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(agE);
    d.a locala = (d.a)paramMap.get(agF);
    if ((localObject == null) || (localObject == dh.mY()) || (locala == null) || (locala == dh.mY())) {
      return dh.mY();
    }
    int i = 64;
    if (dh.n((d.a)paramMap.get(agG)).booleanValue()) {
      i = 66;
    }
    paramMap = (d.a)paramMap.get(agH);
    int j;
    if (paramMap != null)
    {
      paramMap = dh.l(paramMap);
      if (paramMap == dh.mT()) {
        return dh.mY();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return dh.mY();
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
        return dh.mY();
      }
      paramMap = dh.r(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return dh.mY();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */