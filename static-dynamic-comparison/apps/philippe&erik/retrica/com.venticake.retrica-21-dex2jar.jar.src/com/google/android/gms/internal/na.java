package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class na
{
  private final List<String> a;
  private final List<String> b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final boolean h;
  private final int i;
  
  public na(Map<String, String> paramMap)
  {
    this.g = ((String)paramMap.get("url"));
    this.d = ((String)paramMap.get("base_uri"));
    this.e = ((String)paramMap.get("post_parameters"));
    this.h = a((String)paramMap.get("drt_include"));
    this.c = ((String)paramMap.get("activation_overlay_url"));
    this.b = b((String)paramMap.get("check_packages"));
    this.i = c((String)paramMap.get("request_id"));
    this.f = ((String)paramMap.get("type"));
    this.a = b((String)paramMap.get("errors"));
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
  }
  
  private List<String> b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  private int c(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    return Integer.parseInt(paramString);
  }
  
  public List<String> a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/na.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */