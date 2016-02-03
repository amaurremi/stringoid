package com.badlogic.gdx.utils;

import java.io.PrintStream;

public class e
{
  public static boolean a = false;
  private static boolean b;
  
  public static void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = b;
        if (bool) {
          return;
        }
        b = true;
        if (a) {
          System.out.println("Native loading is disabled.");
        } else {
          new r().b("gdx");
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */