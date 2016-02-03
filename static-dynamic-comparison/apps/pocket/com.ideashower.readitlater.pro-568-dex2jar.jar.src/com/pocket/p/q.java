package com.pocket.p;

import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.util.u;
import org.apache.a.a.a.d;
import org.apache.a.a.b.a;

public abstract class q
{
  private static Object a = { "er", "ok", "pi", "t", ".", " ", "e", "s ", "bo", "of", "e", "d", "R", "si", "Android", " u", "es", "e", ":", "h" };
  private static String b = "P";
  private static String c;
  
  static
  {
    StringBuilder localStringBuilder = u.a();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "b";
    arrayOfString[1] = "b";
    c = b + "il" + "es" + ((String[])(String[])a)[5] + ((String[])(String[])a)[9] + ((String[])(String[])a)[5] + ((String[])(String[])a)[8] + ((String[])(String[])a)[1] + ((String[])(String[])a)[7] + arrayOfString[0] + "y" + " " + ((String[])(String[])a)[3] + ((String[])(String[])a)[19] + ((String[])(String[])a)[6] + ((String[])(String[])a)[5] + arrayOfString[1] + ((String[])(String[])a)[17] + ((String[])(String[])a)[11] + ((String[])(String[])a)[13] + ((String[])(String[])a)[11] + ((String[])(String[])a)[17];
    u.a(localStringBuilder);
  }
  
  public static String a(o paramo)
  {
    return "http://text.getpocket.com/v3beta/loadWebCache?" + b(paramo).substring(1);
  }
  
  private static String a(String paramString)
  {
    if (!as.m()) {
      return "";
    }
    String str1 = String.valueOf(System.currentTimeMillis() / 1000L);
    String str2 = as.i();
    String str3 = a(str1, str2, paramString);
    return "&pl_h=" + str3 + "&pl_u=" + str2 + "&pl_t=" + str1 + "&pl_i=" + paramString;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = u.a();
    localStringBuilder.append(paramString2).append(":").append(paramString1).append(((String[])(String[])a)[18]).append(paramString3).append(":").append(c);
    paramString1 = new String(d.a(a.b(localStringBuilder.toString().getBytes())));
    u.a(localStringBuilder);
    return paramString1;
  }
  
  public static String b(o paramo)
  {
    return a(c(paramo));
  }
  
  private static String c(o paramo)
  {
    if (paramo.c() != 0) {
      return String.valueOf(paramo.c());
    }
    return paramo.i();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */