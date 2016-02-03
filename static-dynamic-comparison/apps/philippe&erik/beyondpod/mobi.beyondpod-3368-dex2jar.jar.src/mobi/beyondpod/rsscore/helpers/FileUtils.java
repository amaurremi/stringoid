package mobi.beyondpod.rsscore.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Date;

public class FileUtils
{
  private static final String TAG = FileUtils.class.getSimpleName();
  final int BUFSIZE = 4096;
  
  public static boolean CopyFile(File paramFile1, File paramFile2)
  {
    try
    {
      boolean bool = CopyFile(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
      return bool;
    }
    catch (IOException paramFile1) {}
    return false;
  }
  
  public static boolean CopyFile(String paramString1, String paramString2)
    throws IOException
  {
    Object localObject3 = null;
    String str = null;
    Object localObject5 = null;
    Object localObject4 = null;
    if ((StringUtils.IsNullOrEmpty(paramString1)) || (StringUtils.IsNullOrEmpty(paramString2)))
    {
      CoreHelper.WriteLogEntry(TAG, "Unable to copy file! Either source or destinations are null");
      return false;
    }
    Object localObject1 = localObject4;
    Object localObject2 = localObject5;
    try
    {
      paramString1 = new FileInputStream(paramString1).getChannel();
      localObject1 = localObject4;
      str = paramString1;
      localObject2 = localObject5;
      localObject3 = paramString1;
      paramString2 = new FileOutputStream(paramString2).getChannel();
      localObject1 = paramString2;
      str = paramString1;
      localObject2 = paramString2;
      localObject3 = paramString1;
      paramString2.transferFrom(paramString1, 0L, paramString1.size());
      if (paramString1 != null) {
        paramString1.close();
      }
      if (paramString2 != null) {
        paramString2.close();
      }
      return true;
    }
    catch (Exception paramString1)
    {
      localObject2 = localObject1;
      localObject3 = str;
      CoreHelper.LogException(TAG, "Failed to copy file!", paramString1);
      if (str != null) {
        str.close();
      }
      if (localObject1 != null) {
        ((FileChannel)localObject1).close();
      }
      return false;
    }
    finally
    {
      if (localObject3 != null) {
        ((FileChannel)localObject3).close();
      }
      if (localObject2 != null) {
        ((FileChannel)localObject2).close();
      }
    }
  }
  
  public static boolean CreateDirectory(String paramString)
  {
    return new File(paramString).mkdirs();
  }
  
  public static boolean DeleteFileIfExists(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          boolean bool = paramString.delete();
          return bool;
        }
      }
      catch (Exception paramString)
      {
        CoreHelper.LogException(TAG, "Failed to delete file!", paramString);
      }
    }
    return false;
  }
  
  public static boolean DirectoryExists(String paramString)
  {
    return Exists(paramString);
  }
  
  public static boolean Exists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static Date GetLastWriteTime(String paramString)
  {
    return new Date(new File(paramString).lastModified());
  }
  
  public static boolean RenameTo(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if (!paramString1.exists()) {
      return false;
    }
    return paramString1.renameTo(paramString2);
  }
  
  /* Error */
  public void copyStreams(java.io.InputStream paramInputStream, FileOutputStream paramFileOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 6
    //   8: astore 4
    //   10: sipush 4096
    //   13: newarray <illegal type>
    //   15: astore 7
    //   17: aload 6
    //   19: astore 4
    //   21: new 123	java/io/BufferedOutputStream
    //   24: dup
    //   25: aload_2
    //   26: sipush 4096
    //   29: invokespecial 126	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   32: astore_2
    //   33: aload_1
    //   34: aload 7
    //   36: iconst_0
    //   37: sipush 4096
    //   40: invokevirtual 132	java/io/InputStream:read	([BII)I
    //   43: istore_3
    //   44: iload_3
    //   45: iconst_m1
    //   46: if_icmpne +16 -> 62
    //   49: aload_2
    //   50: invokevirtual 135	java/io/BufferedOutputStream:flush	()V
    //   53: aload_2
    //   54: ifnull +94 -> 148
    //   57: aload_2
    //   58: invokevirtual 136	java/io/BufferedOutputStream:close	()V
    //   61: return
    //   62: aload_2
    //   63: aload 7
    //   65: iconst_0
    //   66: iload_3
    //   67: invokevirtual 140	java/io/BufferedOutputStream:write	([BII)V
    //   70: goto -37 -> 33
    //   73: astore 4
    //   75: aload_2
    //   76: astore_1
    //   77: aload 4
    //   79: astore_2
    //   80: aload_1
    //   81: astore 4
    //   83: getstatic 18	mobi/beyondpod/rsscore/helpers/FileUtils:TAG	Ljava/lang/String;
    //   86: ldc -114
    //   88: aload_2
    //   89: invokestatic 84	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_1
    //   93: ifnull -32 -> 61
    //   96: aload_1
    //   97: invokevirtual 136	java/io/BufferedOutputStream:close	()V
    //   100: return
    //   101: astore_1
    //   102: getstatic 18	mobi/beyondpod/rsscore/helpers/FileUtils:TAG	Ljava/lang/String;
    //   105: ldc -112
    //   107: aload_1
    //   108: invokestatic 84	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: return
    //   112: astore_1
    //   113: aload 4
    //   115: ifnull +8 -> 123
    //   118: aload 4
    //   120: invokevirtual 136	java/io/BufferedOutputStream:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_2
    //   126: getstatic 18	mobi/beyondpod/rsscore/helpers/FileUtils:TAG	Ljava/lang/String;
    //   129: ldc -112
    //   131: aload_2
    //   132: invokestatic 84	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: goto -12 -> 123
    //   138: astore_1
    //   139: getstatic 18	mobi/beyondpod/rsscore/helpers/FileUtils:TAG	Ljava/lang/String;
    //   142: ldc -112
    //   144: aload_1
    //   145: invokestatic 84	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   148: return
    //   149: astore_1
    //   150: aload_2
    //   151: astore 4
    //   153: goto -40 -> 113
    //   156: astore_2
    //   157: aload 5
    //   159: astore_1
    //   160: goto -80 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	FileUtils
    //   0	163	1	paramInputStream	java.io.InputStream
    //   0	163	2	paramFileOutputStream	FileOutputStream
    //   43	24	3	i	int
    //   8	12	4	localObject1	Object
    //   73	5	4	localIOException	IOException
    //   81	71	4	localObject2	Object
    //   4	154	5	localObject3	Object
    //   1	17	6	localObject4	Object
    //   15	49	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	44	73	java/io/IOException
    //   49	53	73	java/io/IOException
    //   62	70	73	java/io/IOException
    //   96	100	101	java/io/IOException
    //   10	17	112	finally
    //   21	33	112	finally
    //   83	92	112	finally
    //   118	123	125	java/io/IOException
    //   57	61	138	java/io/IOException
    //   33	44	149	finally
    //   49	53	149	finally
    //   62	70	149	finally
    //   10	17	156	java/io/IOException
    //   21	33	156	java/io/IOException
  }
  
  public void deleteFile(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    int i;
    if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
      i = 0;
    }
    for (;;)
    {
      if (i >= arrayOfFile.length)
      {
        if (!paramFile.delete()) {
          CoreHelper.WriteLogEntry(TAG, paramFile.getPath() + " could not get deleted");
        }
        return;
      }
      deleteFile(arrayOfFile[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */