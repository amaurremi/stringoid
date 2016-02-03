package com.mobisystems.office.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  /* Error */
  private static int a(ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: new 14	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   14: ldc 20
    //   16: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 26
    //   25: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 36	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull +124 -> 167
    //   46: aload_0
    //   47: astore_1
    //   48: aload_0
    //   49: invokeinterface 48 1 0
    //   54: ifeq +113 -> 167
    //   57: aload_0
    //   58: astore_1
    //   59: aload_0
    //   60: invokeinterface 52 1 0
    //   65: iconst_1
    //   66: if_icmpne +101 -> 167
    //   69: aload_0
    //   70: astore_1
    //   71: aload_0
    //   72: iconst_0
    //   73: invokeinterface 56 2 0
    //   78: istore_3
    //   79: iload_3
    //   80: iflt +10 -> 90
    //   83: iload_3
    //   84: istore_2
    //   85: iload_3
    //   86: iconst_2
    //   87: if_icmple +5 -> 92
    //   90: iconst_m1
    //   91: istore_2
    //   92: aload_0
    //   93: ifnull +9 -> 102
    //   96: aload_0
    //   97: invokeinterface 59 1 0
    //   102: iload_2
    //   103: ireturn
    //   104: astore 4
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: astore_1
    //   110: aload 4
    //   112: athrow
    //   113: astore_0
    //   114: aload_1
    //   115: astore 4
    //   117: aload 4
    //   119: ifnull +10 -> 129
    //   122: aload 4
    //   124: invokeinterface 59 1 0
    //   129: aload_0
    //   130: athrow
    //   131: astore_1
    //   132: aload 5
    //   134: astore_0
    //   135: aload_0
    //   136: astore 4
    //   138: aload_1
    //   139: invokevirtual 62	java/lang/Throwable:printStackTrace	()V
    //   142: aload_0
    //   143: ifnull +9 -> 152
    //   146: aload_0
    //   147: invokeinterface 59 1 0
    //   152: iconst_m1
    //   153: ireturn
    //   154: astore_0
    //   155: goto -38 -> 117
    //   158: astore_1
    //   159: goto -24 -> 135
    //   162: astore 4
    //   164: goto -56 -> 108
    //   167: iconst_m1
    //   168: istore_2
    //   169: goto -77 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContentResolver	ContentResolver
    //   0	172	1	paramString	String
    //   84	85	2	i	int
    //   78	10	3	j	int
    //   1	1	4	localObject1	Object
    //   104	7	4	localSecurityException1	SecurityException
    //   115	22	4	localObject2	Object
    //   162	1	4	localSecurityException2	SecurityException
    //   4	129	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	42	104	java/lang/SecurityException
    //   48	57	113	finally
    //   59	69	113	finally
    //   71	79	113	finally
    //   110	113	113	finally
    //   6	42	131	java/lang/Throwable
    //   6	42	154	finally
    //   138	142	154	finally
    //   48	57	158	java/lang/Throwable
    //   59	69	158	java/lang/Throwable
    //   71	79	158	java/lang/Throwable
    //   48	57	162	java/lang/SecurityException
    //   59	69	162	java/lang/SecurityException
    //   71	79	162	java/lang/SecurityException
  }
  
  public static a aB(Context paramContext)
  {
    a locala = new a();
    locala.aNm = -1;
    ContentResolver localContentResolver = paramContext.getContentResolver();
    paramContext = aC(paramContext);
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = paramContext[i];
      int k = a(localContentResolver, str);
      if (k > locala.aNm)
      {
        locala.aNm = k;
        locala.packageName = str;
      }
      i += 1;
    }
    if (locala.aNm == -1) {
      locala.aNm = 0;
    }
    if (locala.packageName != null) {
      paramContext = locala.packageName;
    }
    try
    {
      locala.packageName = paramContext.substring(0, paramContext.length() - ".license".length());
      return locala;
    }
    catch (Throwable paramContext)
    {
      locala.packageName = null;
    }
    return locala;
  }
  
  private static String[] aC(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager().getInstalledPackages(8);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        Object localObject1 = (PackageInfo)paramContext.next();
        if ((localObject1 != null) && ((((PackageInfo)localObject1).packageName.startsWith("com.mobisystems.office")) || (((PackageInfo)localObject1).packageName.startsWith("com.mobisystems.editor"))) && (((PackageInfo)localObject1).providers != null))
        {
          localObject1 = ((PackageInfo)localObject1).providers;
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 != null) && (((ProviderInfo)localObject2).authority != null) && (((ProviderInfo)localObject2).authority.endsWith(".license"))) {
              localArrayList.add(((ProviderInfo)localObject2).authority);
            }
            i += 1;
          }
        }
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static class a
  {
    public int aNm;
    public String packageName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */