package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.cc.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class ad
{
  private static s<cc.a> a(s<cc.a> params)
  {
    try
    {
      s locals = new s(ab.R(bu(ab.e((cc.a)params.getObject()))), params.vW());
      return locals;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      j.f("Escape URI: unsupported encoding", localUnsupportedEncodingException);
    }
    return params;
  }
  
  private static s<cc.a> a(s<cc.a> params, int paramInt)
  {
    if (!h((cc.a)params.getObject()))
    {
      j.Z("Escaping can only be applied to strings.");
      return params;
    }
    switch (paramInt)
    {
    default: 
      j.Z("Unsupported Value Escaping: " + paramInt);
      return params;
    }
    return a(params);
  }
  
  static s<cc.a> a(s<cc.a> params, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      params = a(params, paramVarArgs[i]);
      i += 1;
    }
    return params;
  }
  
  static String bu(String paramString)
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
  
  private static boolean h(cc.a parama)
  {
    return ab.g(parama) instanceof String;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */