package com.vladium.emma.rt;

public abstract class RTSettings
{
  private static boolean s_not_standalone;
  
  /* Error */
  public static boolean isStandaloneMode()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 15	com/vladium/emma/rt/RTSettings:s_not_standalone	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	14	0	bool	boolean
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  /* Error */
  public static void setStandaloneMode(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_0
    //   4: ifne +13 -> 17
    //   7: iconst_1
    //   8: istore_0
    //   9: iload_0
    //   10: putstatic 15	com/vladium/emma/rt/RTSettings:s_not_standalone	Z
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: iconst_0
    //   18: istore_0
    //   19: goto -10 -> 9
    //   22: astore_1
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	paramBoolean	boolean
    //   22	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	13	22	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/RTSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */