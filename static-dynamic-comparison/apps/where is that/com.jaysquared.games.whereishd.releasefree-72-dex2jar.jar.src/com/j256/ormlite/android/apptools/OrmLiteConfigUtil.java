package com.j256.ormlite.android.apptools;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrmLiteConfigUtil
{
  protected static final String RAW_DIR_NAME = "raw";
  protected static final String RESOURCE_DIR_NAME = "res";
  private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
  protected static int maxFindSourceLevel = 20;
  
  private static boolean classHasAnnotations(Class<?> paramClass)
  {
    for (;;)
    {
      if (paramClass != null)
      {
        if (paramClass.getAnnotation(DatabaseTable.class) != null) {
          return true;
        }
        try
        {
          Field[] arrayOfField = paramClass.getDeclaredFields();
          int j = arrayOfField.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label115;
            }
            Field localField = arrayOfField[i];
            if ((localField.getAnnotation(DatabaseField.class) != null) || (localField.getAnnotation(ForeignCollectionField.class) != null)) {
              break;
            }
            i += 1;
          }
          try
          {
            Class localClass = paramClass.getSuperclass();
            paramClass = localClass;
          }
          catch (Throwable localThrowable2)
          {
            System.err.println("Could not get super class for: " + paramClass);
            System.err.println("     " + localThrowable2);
            return false;
          }
        }
        catch (Throwable localThrowable1)
        {
          System.err.println("Could not load get delcared fields from: " + paramClass);
          System.err.println("     " + localThrowable1);
          return false;
        }
      }
    }
    label115:
    return false;
  }
  
  /* Error */
  private static void findAnnotatedClasses(List<Class<?>> paramList, File paramFile, int paramInt)
    throws SQLException, IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 103	java/io/File:listFiles	()[Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: arraylength
    //   7: istore 5
    //   9: iconst_0
    //   10: istore_3
    //   11: iload_3
    //   12: iload 5
    //   14: if_icmpge +339 -> 353
    //   17: aload_1
    //   18: iload_3
    //   19: aaload
    //   20: astore 7
    //   22: aload 7
    //   24: invokevirtual 107	java/io/File:isDirectory	()Z
    //   27: ifeq +26 -> 53
    //   30: iload_2
    //   31: getstatic 21	com/j256/ormlite/android/apptools/OrmLiteConfigUtil:maxFindSourceLevel	I
    //   34: if_icmpge +12 -> 46
    //   37: aload_0
    //   38: aload 7
    //   40: iload_2
    //   41: iconst_1
    //   42: iadd
    //   43: invokestatic 109	com/j256/ormlite/android/apptools/OrmLiteConfigUtil:findAnnotatedClasses	(Ljava/util/List;Ljava/io/File;I)V
    //   46: iload_3
    //   47: iconst_1
    //   48: iadd
    //   49: istore_3
    //   50: goto -39 -> 11
    //   53: aload 7
    //   55: invokevirtual 112	java/io/File:getName	()Ljava/lang/String;
    //   58: ldc 114
    //   60: invokevirtual 120	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   63: ifeq -17 -> 46
    //   66: aload 7
    //   68: invokestatic 124	com/j256/ormlite/android/apptools/OrmLiteConfigUtil:getPackageOfClass	(Ljava/io/File;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 8
    //   75: ifnonnull +32 -> 107
    //   78: getstatic 59	java/lang/System:err	Ljava/io/PrintStream;
    //   81: new 61	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   88: ldc 126
    //   90: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 7
    //   95: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 81	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   104: goto -58 -> 46
    //   107: aload 7
    //   109: invokevirtual 112	java/io/File:getName	()Ljava/lang/String;
    //   112: astore 9
    //   114: aload 9
    //   116: iconst_0
    //   117: aload 9
    //   119: invokevirtual 130	java/lang/String:length	()I
    //   122: ldc 114
    //   124: invokevirtual 130	java/lang/String:length	()I
    //   127: isub
    //   128: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
    //   131: astore 9
    //   133: new 61	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   140: aload 8
    //   142: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc -120
    //   147: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 9
    //   152: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore 8
    //   160: aload 8
    //   162: invokestatic 140	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   165: astore 8
    //   167: aload 8
    //   169: invokestatic 142	com/j256/ormlite/android/apptools/OrmLiteConfigUtil:classHasAnnotations	(Ljava/lang/Class;)Z
    //   172: ifeq +12 -> 184
    //   175: aload_0
    //   176: aload 8
    //   178: invokeinterface 148 2 0
    //   183: pop
    //   184: aload 8
    //   186: invokevirtual 152	java/lang/Class:getDeclaredClasses	()[Ljava/lang/Class;
    //   189: astore 7
    //   191: aload 7
    //   193: arraylength
    //   194: istore 6
    //   196: iconst_0
    //   197: istore 4
    //   199: iload 4
    //   201: iload 6
    //   203: if_icmpge -157 -> 46
    //   206: aload 7
    //   208: iload 4
    //   210: aaload
    //   211: astore 9
    //   213: aload 9
    //   215: invokestatic 142	com/j256/ormlite/android/apptools/OrmLiteConfigUtil:classHasAnnotations	(Ljava/lang/Class;)Z
    //   218: ifeq +12 -> 230
    //   221: aload_0
    //   222: aload 9
    //   224: invokeinterface 148 2 0
    //   229: pop
    //   230: iload 4
    //   232: iconst_1
    //   233: iadd
    //   234: istore 4
    //   236: goto -37 -> 199
    //   239: astore 8
    //   241: getstatic 59	java/lang/System:err	Ljava/io/PrintStream;
    //   244: new 61	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   251: ldc -102
    //   253: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 7
    //   258: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokevirtual 81	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   267: getstatic 59	java/lang/System:err	Ljava/io/PrintStream;
    //   270: new 61	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   277: ldc 83
    //   279: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 8
    //   284: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 81	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   293: goto -247 -> 46
    //   296: astore 7
    //   298: getstatic 59	java/lang/System:err	Ljava/io/PrintStream;
    //   301: new 61	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   308: ldc -100
    //   310: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 8
    //   315: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokevirtual 81	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   324: getstatic 59	java/lang/System:err	Ljava/io/PrintStream;
    //   327: new 61	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   334: ldc 83
    //   336: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 7
    //   341: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokevirtual 81	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   350: goto -304 -> 46
    //   353: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramList	List<Class<?>>
    //   0	354	1	paramFile	File
    //   0	354	2	paramInt	int
    //   10	40	3	i	int
    //   197	38	4	j	int
    //   7	8	5	k	int
    //   194	10	6	m	int
    //   20	237	7	localObject1	Object
    //   296	44	7	localThrowable1	Throwable
    //   71	114	8	localObject2	Object
    //   239	75	8	localThrowable2	Throwable
    //   112	111	9	str	String
    // Exception table:
    //   from	to	target	type
    //   160	167	239	java/lang/Throwable
    //   184	196	296	java/lang/Throwable
    //   213	230	296	java/lang/Throwable
  }
  
  protected static File findRawDir(File paramFile)
  {
    int i = 0;
    while ((paramFile != null) && (i < 20))
    {
      File localFile = findResRawDir(paramFile);
      if (localFile != null) {
        return localFile;
      }
      paramFile = paramFile.getParentFile();
      i += 1;
    }
    return null;
  }
  
  private static File findResRawDir(File paramFile)
  {
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      File[] arrayOfFile = paramFile[i];
      if ((arrayOfFile.getName().equals("res")) && (arrayOfFile.isDirectory()))
      {
        arrayOfFile = arrayOfFile.listFiles(new FileFilter()
        {
          public boolean accept(File paramAnonymousFile)
          {
            return (paramAnonymousFile.getName().equals("raw")) && (paramAnonymousFile.isDirectory());
          }
        });
        if (arrayOfFile.length == 1) {
          return arrayOfFile[0];
        }
      }
      i += 1;
    }
    return null;
  }
  
  private static String getPackageOfClass(File paramFile)
    throws IOException
  {
    paramFile = new BufferedReader(new FileReader(paramFile));
    try
    {
      do
      {
        do
        {
          localObject1 = paramFile.readLine();
          if (localObject1 == null) {
            return null;
          }
        } while (!((String)localObject1).contains("package"));
        localObject1 = ((String)localObject1).split("[ \t;]");
      } while ((localObject1.length <= 1) || (!localObject1[0].equals("package")));
      Object localObject1 = localObject1[1];
      return (String)localObject1;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    if (paramArrayOfString.length != 1) {
      throw new IllegalArgumentException("Main can take a single file-name argument.");
    }
    writeConfigFile(paramArrayOfString[0]);
  }
  
  public static void writeConfigFile(File paramFile)
    throws SQLException, IOException
  {
    writeConfigFile(paramFile, new File("."));
  }
  
  public static void writeConfigFile(File paramFile1, File paramFile2)
    throws SQLException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    findAnnotatedClasses(localArrayList, paramFile2, 0);
    writeConfigFile(paramFile1, (Class[])localArrayList.toArray(new Class[localArrayList.size()]));
  }
  
  public static void writeConfigFile(File paramFile, Class<?>[] paramArrayOfClass)
    throws SQLException, IOException
  {
    System.out.println("Writing configurations to " + paramFile.getAbsolutePath());
    writeConfigFile(new FileOutputStream(paramFile), paramArrayOfClass);
  }
  
  public static void writeConfigFile(OutputStream paramOutputStream, File paramFile)
    throws SQLException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    findAnnotatedClasses(localArrayList, paramFile, 0);
    writeConfigFile(paramOutputStream, (Class[])localArrayList.toArray(new Class[localArrayList.size()]));
  }
  
  public static void writeConfigFile(OutputStream paramOutputStream, Class<?>[] paramArrayOfClass)
    throws SQLException, IOException
  {
    paramOutputStream = new BufferedWriter(new OutputStreamWriter(paramOutputStream), 4096);
    try
    {
      writeHeader(paramOutputStream);
      int j = paramArrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        writeConfigForTable(paramOutputStream, paramArrayOfClass[i]);
        i += 1;
      }
      System.out.println("Done.");
      return;
    }
    finally
    {
      paramOutputStream.close();
    }
  }
  
  public static void writeConfigFile(String paramString)
    throws SQLException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    findAnnotatedClasses(localArrayList, new File("."), 0);
    writeConfigFile(paramString, (Class[])localArrayList.toArray(new Class[localArrayList.size()]));
  }
  
  public static void writeConfigFile(String paramString, Class<?>[] paramArrayOfClass)
    throws SQLException, IOException
  {
    File localFile = findRawDir(new File("."));
    if (localFile == null)
    {
      System.err.println("Could not find raw directory");
      return;
    }
    writeConfigFile(new File(localFile, paramString), paramArrayOfClass);
  }
  
  private static void writeConfigForTable(BufferedWriter paramBufferedWriter, Class<?> paramClass)
    throws SQLException, IOException
  {
    String str = DatabaseTableConfig.extractTableName(paramClass);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramClass;
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        Field[] arrayOfField = ((Class)localObject1).getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = arrayOfField[i];
          localObject2 = DatabaseFieldConfig.fromField(databaseType, str, (Field)localObject2);
          if (localObject2 == null) {
            break label226;
          }
          localArrayList.add(localObject2);
          break label226;
        }
        localObject1 = ((Class)localObject1).getSuperclass();
      }
      catch (Error paramBufferedWriter)
      {
        System.err.println("Skipping " + paramClass + " because we got an error finding its definition: " + paramBufferedWriter.getMessage());
        return;
      }
      if (localArrayList.isEmpty())
      {
        System.out.println("Skipping " + paramClass + " because no annotated fields found");
        return;
      }
      DatabaseTableConfigLoader.write(paramBufferedWriter, new DatabaseTableConfig(paramClass, str, localArrayList));
      paramBufferedWriter.append("#################################");
      paramBufferedWriter.newLine();
      System.out.println("Wrote config for " + paramClass);
      return;
      label226:
      i += 1;
    }
  }
  
  private static void writeHeader(BufferedWriter paramBufferedWriter)
    throws IOException
  {
    paramBufferedWriter.append('#');
    paramBufferedWriter.newLine();
    paramBufferedWriter.append("# generated on ").append(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
    paramBufferedWriter.newLine();
    paramBufferedWriter.append('#');
    paramBufferedWriter.newLine();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/apptools/OrmLiteConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */