package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class aj
  extends t
{
  private static final String a = a.ac.toString();
  private static final String b = b.bi.toString();
  private static final String c = b.cL.toString();
  private static final String d = b.cO.toString();
  private static final String e = b.co.toString();
  
  public aj()
  {
    super(a, new String[] { b });
  }
  
  private String a(String paramString, ak paramak, Set<Character> paramSet)
  {
    switch (1.a[paramak.ordinal()])
    {
    default: 
      return paramString;
    case 1: 
      try
      {
        paramak = dh.a(paramString);
        return paramak;
      }
      catch (UnsupportedEncodingException paramak)
      {
        as.a("Joiner: unsupported encoding", paramak);
        return paramString;
      }
    }
    paramString = paramString.replace("\\", "\\\\");
    paramak = paramSet.iterator();
    while (paramak.hasNext())
    {
      paramSet = ((Character)paramak.next()).toString();
      paramString = paramString.replace(paramSet, "\\" + paramSet);
    }
    return paramString;
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, ak paramak, Set<Character> paramSet)
  {
    paramStringBuilder.append(a(paramString, paramak, paramSet));
  }
  
  private void a(Set<Character> paramSet, String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      paramSet.add(Character.valueOf(paramString.charAt(i)));
      i += 1;
    }
  }
  
  public d.a a(Map<String, d.a> paramMap)
  {
    d.a locala = (d.a)paramMap.get(b);
    if (locala == null) {
      return de.g();
    }
    Object localObject1 = (d.a)paramMap.get(c);
    String str1;
    Object localObject2;
    if (localObject1 != null)
    {
      str1 = de.a((d.a)localObject1);
      localObject1 = (d.a)paramMap.get(d);
      if (localObject1 == null) {
        break label186;
      }
      localObject2 = de.a((d.a)localObject1);
      label75:
      localObject1 = ak.a;
      paramMap = (d.a)paramMap.get(e);
      if (paramMap == null) {
        break label418;
      }
      paramMap = de.a(paramMap);
      if (!"url".equals(paramMap)) {
        break label193;
      }
      localObject1 = ak.b;
      paramMap = null;
    }
    for (;;)
    {
      label118:
      StringBuilder localStringBuilder = new StringBuilder();
      switch (locala.type)
      {
      default: 
        a(localStringBuilder, de.a(locala), (ak)localObject1, paramMap);
      }
      for (;;)
      {
        return de.f(localStringBuilder.toString());
        str1 = "";
        break;
        label186:
        localObject2 = "=";
        break label75;
        label193:
        if ("backslash".equals(paramMap))
        {
          localObject1 = ak.c;
          paramMap = new HashSet();
          a(paramMap, str1);
          a(paramMap, (String)localObject2);
          paramMap.remove(Character.valueOf('\\'));
          break label118;
        }
        as.a("Joiner: unsupported escape type: " + paramMap);
        return de.g();
        int j = 1;
        localObject2 = locala.fO;
        int k = localObject2.length;
        int i = 0;
        while (i < k)
        {
          locala = localObject2[i];
          if (j == 0) {
            localStringBuilder.append(str1);
          }
          a(localStringBuilder, de.a(locala), (ak)localObject1, paramMap);
          i += 1;
          j = 0;
        }
        i = 0;
        while (i < locala.fP.length)
        {
          if (i > 0) {
            localStringBuilder.append(str1);
          }
          String str2 = de.a(locala.fP[i]);
          String str3 = de.a(locala.fQ[i]);
          a(localStringBuilder, str2, (ak)localObject1, paramMap);
          localStringBuilder.append((String)localObject2);
          a(localStringBuilder, str3, (ak)localObject1, paramMap);
          i += 1;
        }
      }
      label418:
      paramMap = null;
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */