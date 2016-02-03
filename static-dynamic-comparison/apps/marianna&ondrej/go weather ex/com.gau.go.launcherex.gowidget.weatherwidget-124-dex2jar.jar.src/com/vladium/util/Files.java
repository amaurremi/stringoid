package com.vladium.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Files
{
  public static File canonicalizeFile(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("null input: file");
    }
    try
    {
      File localFile = paramFile.getCanonicalFile();
      return localFile;
    }
    catch (Exception localException) {}
    return paramFile.getAbsoluteFile();
  }
  
  public static String canonicalizePathname(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null input: pathname");
    }
    try
    {
      String str = new File(paramString).getCanonicalPath();
      return str;
    }
    catch (Exception localException) {}
    return new File(paramString).getAbsolutePath();
  }
  
  public static File createTempFile(File paramFile, String paramString1, String paramString2)
    throws IOException
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      throw new IllegalArgumentException("invalid parent directory: [" + paramFile + "]");
    }
    if ((paramString1 == null) || (paramString1.length() < 3)) {
      throw new IllegalArgumentException("null or less than 3 chars long: " + paramString1);
    }
    String str;
    if (paramString2 == null) {
      str = ".tmp";
    }
    for (;;)
    {
      return File.createTempFile(paramString1, str, paramFile);
      str = paramString2;
      if (paramString2.charAt(0) != '.') {
        str = ".".concat(paramString2);
      }
    }
  }
  
  public static String getFileExtension(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("null input: file");
    }
    paramFile = paramFile.getName();
    int i = paramFile.lastIndexOf('.');
    if (i < 0) {
      return "";
    }
    return paramFile.substring(i);
  }
  
  public static String getFileName(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("null input: file");
    }
    paramFile = paramFile.getName();
    int i = paramFile.lastIndexOf('.');
    if (i < 0) {
      return paramFile;
    }
    return paramFile.substring(0, i);
  }
  
  public static File newFile(File paramFile1, File paramFile2)
  {
    if (paramFile2 == null) {
      throw new IllegalArgumentException("null input: file");
    }
    if ((paramFile1 == null) || (paramFile2.isAbsolute())) {
      return paramFile2;
    }
    return new File(paramFile1, paramFile2.getPath());
  }
  
  public static File newFile(File paramFile, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null input: file");
    }
    File localFile = new File(paramString);
    if ((paramFile == null) || (localFile.isAbsolute())) {
      return localFile;
    }
    return new File(paramFile, paramString);
  }
  
  public static File newFile(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      throw new IllegalArgumentException("null input: file");
    }
    File localFile = new File(paramString2);
    if ((paramString1 == null) || (localFile.isAbsolute())) {
      return localFile;
    }
    return new File(paramString1, paramString2);
  }
  
  public static File[] pathToFiles(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("null input: path");
    }
    if (paramArrayOfString.length == 0) {
      return IConstants.EMPTY_FILE_ARRAY;
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
    HashSet localHashSet = new HashSet(paramArrayOfString.length);
    String str2 = ",".concat(File.pathSeparator);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      Object localObject = paramArrayOfString[i];
      if (localObject == null) {
        throw new IllegalArgumentException("null input: path[" + i + "]");
      }
      StringTokenizer localStringTokenizer = new StringTokenizer((String)localObject, str2);
      while (localStringTokenizer.hasMoreTokens())
      {
        String str1 = localStringTokenizer.nextToken();
        localObject = str1;
        if (paramBoolean) {
          localObject = canonicalizePathname(str1);
        }
        if (localHashSet.add(localObject)) {
          localArrayList.add(new File((String)localObject));
        }
      }
      i += 1;
    }
    paramArrayOfString = new File[localArrayList.size()];
    localArrayList.toArray(paramArrayOfString);
    return paramArrayOfString;
  }
  
  /* Error */
  public static String[] readFileList(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 15	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc -72
    //   10: invokespecial 20	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aconst_null
    //   15: astore_1
    //   16: new 186	java/io/BufferedReader
    //   19: dup
    //   20: new 188	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 191	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: sipush 8192
    //   31: invokespecial 194	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   34: astore_0
    //   35: new 196	java/util/LinkedList
    //   38: dup
    //   39: invokespecial 197	java/util/LinkedList:<init>	()V
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 200	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +47 -> 96
    //   52: aload_2
    //   53: invokevirtual 203	java/lang/String:trim	()Ljava/lang/String;
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 72	java/lang/String:length	()I
    //   61: ifeq -18 -> 43
    //   64: aload_2
    //   65: iconst_0
    //   66: invokevirtual 83	java/lang/String:charAt	(I)C
    //   69: bipush 35
    //   71: if_icmpeq -28 -> 43
    //   74: aload_1
    //   75: aload_2
    //   76: invokeinterface 173 2 0
    //   81: pop
    //   82: goto -39 -> 43
    //   85: astore_1
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 206	java/io/BufferedReader:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 206	java/io/BufferedReader:close	()V
    //   104: aload_1
    //   105: ifnull +12 -> 117
    //   108: aload_1
    //   109: invokeinterface 209 1 0
    //   114: ifeq +7 -> 121
    //   117: getstatic 213	com/vladium/util/IConstants:EMPTY_STRING_ARRAY	[Ljava/lang/String;
    //   120: areturn
    //   121: aload_1
    //   122: invokeinterface 176 1 0
    //   127: anewarray 68	java/lang/String
    //   130: astore_0
    //   131: aload_1
    //   132: aload_0
    //   133: invokeinterface 180 2 0
    //   138: pop
    //   139: aload_0
    //   140: areturn
    //   141: astore_0
    //   142: goto -38 -> 104
    //   145: astore_0
    //   146: goto -52 -> 94
    //   149: astore_2
    //   150: aload_1
    //   151: astore_0
    //   152: aload_2
    //   153: astore_1
    //   154: goto -68 -> 86
    //   157: astore_1
    //   158: goto -72 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramFile	File
    //   15	60	1	localLinkedList	java.util.LinkedList
    //   85	66	1	localObject1	Object
    //   153	1	1	localObject2	Object
    //   157	1	1	localObject3	Object
    //   47	29	2	str	String
    //   149	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   43	48	85	finally
    //   52	82	85	finally
    //   100	104	141	java/lang/Exception
    //   90	94	145	java/lang/Exception
    //   16	35	149	finally
    //   35	43	157	finally
  }
  
  public static boolean renameFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if ((paramFile1 == null) || (!paramFile1.exists())) {
      throw new IllegalArgumentException("invalid input source: [" + paramFile1 + "]");
    }
    if (paramFile2 == null) {
      throw new IllegalArgumentException("null input: target");
    }
    boolean bool = paramFile2.exists();
    if ((!bool) || (paramBoolean))
    {
      if (bool) {
        paramFile2.delete();
      }
      for (;;)
      {
        return paramFile1.renameTo(paramFile2);
        File localFile = paramFile2.getParentFile();
        if ((localFile != null) && (!localFile.equals(paramFile1.getParentFile()))) {
          localFile.mkdirs();
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */