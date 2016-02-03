package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dh
{
  private static bj<d.a> a(bj<d.a> parambj)
  {
    try
    {
      bj localbj = new bj(de.f(a(de.a((d.a)parambj.a()))), parambj.b());
      return localbj;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      as.a("Escape URI: unsupported encoding", localUnsupportedEncodingException);
    }
    return parambj;
  }
  
  private static bj<d.a> a(bj<d.a> parambj, int paramInt)
  {
    if (!a((d.a)parambj.a()))
    {
      as.a("Escaping can only be applied to strings.");
      return parambj;
    }
    switch (paramInt)
    {
    default: 
      as.a("Unsupported Value Escaping: " + paramInt);
      return parambj;
    }
    return a(parambj);
  }
  
  static bj<d.a> a(bj<d.a> parambj, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      parambj = a(parambj, paramVarArgs[i]);
      i += 1;
    }
    return parambj;
  }
  
  static String a(String paramString)
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
  
  private static boolean a(d.a parama)
  {
    return de.f(parama) instanceof String;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */