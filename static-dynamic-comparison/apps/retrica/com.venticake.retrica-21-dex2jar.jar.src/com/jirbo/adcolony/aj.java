package com.jirbo.adcolony;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

class aj
{
  private static String a = null;
  private static final String b = "INSTALLATION";
  
  /* Error */
  public static String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 13	com/jirbo/adcolony/aj:a	Ljava/lang/String;
    //   6: ifnonnull +35 -> 41
    //   9: new 22	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 28	android/content/Context:getFilesDir	()Ljava/io/File;
    //   17: ldc 9
    //   19: invokespecial 31	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 35	java/io/File:exists	()Z
    //   27: ifne +7 -> 34
    //   30: aload_0
    //   31: invokestatic 38	com/jirbo/adcolony/aj:b	(Ljava/io/File;)V
    //   34: aload_0
    //   35: invokestatic 41	com/jirbo/adcolony/aj:a	(Ljava/io/File;)Ljava/lang/String;
    //   38: putstatic 13	com/jirbo/adcolony/aj:a	Ljava/lang/String;
    //   41: getstatic 13	com/jirbo/adcolony/aj:a	Ljava/lang/String;
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: new 43	com/jirbo/adcolony/AdColonyException
    //   54: dup
    //   55: aload_0
    //   56: invokevirtual 47	java/lang/Exception:toString	()Ljava/lang/String;
    //   59: invokespecial 50	com/jirbo/adcolony/AdColonyException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   23	34	50	java/lang/Exception
    //   34	41	50	java/lang/Exception
    //   3	23	63	finally
    //   23	34	63	finally
    //   34	41	63	finally
    //   41	45	63	finally
    //   51	63	63	finally
  }
  
  private static String a(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    paramFile.readFully(arrayOfByte);
    paramFile.close();
    return new String(arrayOfByte);
  }
  
  private static void b(File paramFile)
  {
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(UUID.randomUUID().toString().getBytes());
    paramFile.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */