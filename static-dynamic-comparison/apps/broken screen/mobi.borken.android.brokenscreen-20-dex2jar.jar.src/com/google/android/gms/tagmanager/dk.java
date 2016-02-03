package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dk
{
  private static by<d.a> a(by<d.a> paramby)
  {
    try
    {
      by localby = new by(dh.r(cv(dh.j((d.a)paramby.getObject()))), paramby.lV());
      return localby;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      bh.b("Escape URI: unsupported encoding", localUnsupportedEncodingException);
    }
    return paramby;
  }
  
  private static by<d.a> a(by<d.a> paramby, int paramInt)
  {
    if (!q((d.a)paramby.getObject()))
    {
      bh.A("Escaping can only be applied to strings.");
      return paramby;
    }
    switch (paramInt)
    {
    default: 
      bh.A("Unsupported Value Escaping: " + paramInt);
      return paramby;
    }
    return a(paramby);
  }
  
  static by<d.a> a(by<d.a> paramby, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramby = a(paramby, paramVarArgs[i]);
      i += 1;
    }
    return paramby;
  }
  
  static String cv(String paramString)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
  
  private static boolean q(d.a parama)
  {
    return dh.o(parama) instanceof String;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */