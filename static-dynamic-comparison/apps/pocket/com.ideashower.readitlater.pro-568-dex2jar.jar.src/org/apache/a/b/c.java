package org.apache.a.b;

import java.io.File;

public class c
{
  public static final String a = Character.toString('.');
  private static final char b = File.separatorChar;
  private static final char c = '\\';
  
  static
  {
    if (a())
    {
      c = '/';
      return;
    }
  }
  
  static boolean a()
  {
    return b == '\\';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */