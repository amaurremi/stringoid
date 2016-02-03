package mobi.beyondpod.rsscore.helpers;

public class CallStackDumper
{
  /* Error */
  public static String getCallStackAsString()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 13	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   10: astore_1
    //   11: invokestatic 20	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14: invokevirtual 24	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   17: invokestatic 28	mobi/beyondpod/rsscore/helpers/CallStackDumper:getCallStackAsStringArray	([Ljava/lang/StackTraceElement;)[Ljava/lang/String;
    //   20: astore_2
    //   21: iconst_0
    //   22: istore_0
    //   23: iload_0
    //   24: aload_2
    //   25: arraylength
    //   26: if_icmplt +13 -> 39
    //   29: aload_1
    //   30: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_1
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aload_1
    //   40: new 13	java/lang/StringBuilder
    //   43: dup
    //   44: aload_2
    //   45: iload_0
    //   46: aaload
    //   47: invokestatic 37	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: ldc 42
    //   55: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: iload_0
    //   66: iconst_1
    //   67: iadd
    //   68: istore_0
    //   69: goto -46 -> 23
    //   72: astore_1
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	47	0	i	int
    //   10	30	1	localObject1	Object
    //   72	5	1	localObject2	Object
    //   20	25	2	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   3	21	72	finally
    //   23	34	72	finally
    //   39	65	72	finally
  }
  
  public static String[] getCallStackAsStringArray()
  {
    try
    {
      String[] arrayOfString = getCallStackAsStringArray(Thread.currentThread().getStackTrace());
      return arrayOfString;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private static String[] getCallStackAsStringArray(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 49	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 50	java/util/ArrayList:<init>	()V
    //   10: astore_3
    //   11: iconst_1
    //   12: anewarray 33	java/lang/String
    //   15: astore 4
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_1
    //   20: aload_0
    //   21: arraylength
    //   22: if_icmplt +18 -> 40
    //   25: aload_3
    //   26: aload 4
    //   28: invokevirtual 54	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   31: checkcast 56	[Ljava/lang/String;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: aload_0
    //   41: iload_1
    //   42: aaload
    //   43: astore 5
    //   45: aload 5
    //   47: invokevirtual 61	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   50: astore 6
    //   52: aload 5
    //   54: invokevirtual 64	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   57: astore 7
    //   59: aload 5
    //   61: invokevirtual 68	java/lang/StackTraceElement:getLineNumber	()I
    //   64: istore_2
    //   65: aload_3
    //   66: new 13	java/lang/StringBuilder
    //   69: dup
    //   70: aload 6
    //   72: invokestatic 37	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: ldc 70
    //   80: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 7
    //   85: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 72
    //   90: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_2
    //   94: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 79	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   103: pop
    //   104: iload_1
    //   105: iconst_1
    //   106: iadd
    //   107: istore_1
    //   108: goto -89 -> 19
    //   111: astore_0
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramArrayOfStackTraceElement	StackTraceElement[]
    //   18	90	1	i	int
    //   64	30	2	j	int
    //   10	56	3	localArrayList	java.util.ArrayList
    //   15	12	4	arrayOfString	String[]
    //   43	17	5	localStackTraceElement	StackTraceElement
    //   50	21	6	str1	String
    //   57	27	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	17	111	finally
    //   19	35	111	finally
    //   45	104	111	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/CallStackDumper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */