package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class bw
  extends t
{
  private static final String a = a.ae.toString();
  private static final String b = b.bi.toString();
  private static final String c = b.bj.toString();
  private static final String d = b.cF.toString();
  private static final String e = b.cz.toString();
  
  public bw()
  {
    super(a, new String[] { b, c });
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(b);
    d.a locala = (d.a)paramMap.get(c);
    if ((localObject == null) || (localObject == de.g()) || (locala == null) || (locala == de.g())) {
      return de.g();
    }
    int i = 64;
    if (de.e((d.a)paramMap.get(d)).booleanValue()) {
      i = 66;
    }
    paramMap = (d.a)paramMap.get(e);
    int j;
    if (paramMap != null)
    {
      paramMap = de.c(paramMap);
      if (paramMap == de.b()) {
        return de.g();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return de.g();
      }
    }
    else
    {
      j = 1;
    }
    try
    {
      paramMap = de.a((d.a)localObject);
      localObject = de.a(locala);
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
        return de.g();
      }
      paramMap = de.f(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return de.g();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */