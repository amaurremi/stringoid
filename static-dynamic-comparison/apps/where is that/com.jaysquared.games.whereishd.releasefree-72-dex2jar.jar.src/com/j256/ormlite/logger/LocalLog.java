package com.j256.ormlite.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalLog
  implements Log
{
  private static final Log.Level DEFAULT_LEVEL = Log.Level.DEBUG;
  public static final String LOCAL_LOG_FILE_PROPERTY = "com.j256.ormlite.logger.file";
  public static final String LOCAL_LOG_LEVEL_PROPERTY = "com.j256.ormlite.logger.level";
  public static final String LOCAL_LOG_PROPERTIES_FILE = "/ormliteLocalLog.properties";
  private static final List<PatternLevel> classLevels;
  private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
    }
  };
  private static PrintStream printStream;
  private final String className;
  private final Log.Level level;
  
  static
  {
    classLevels = readLevelResourceFile(LocalLog.class.getResourceAsStream("/ormliteLocalLog.properties"));
    openLogFile(System.getProperty("com.j256.ormlite.logger.file"));
  }
  
  public LocalLog(String paramString)
  {
    this.className = LoggerFactory.getSimpleClassName(paramString);
    Object localObject = null;
    Log.Level localLevel = null;
    if (classLevels != null)
    {
      Iterator localIterator = classLevels.iterator();
      for (;;)
      {
        localObject = localLevel;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PatternLevel)localIterator.next();
        if ((((PatternLevel)localObject).pattern.matcher(paramString).matches()) && ((localLevel == null) || (((PatternLevel)localObject).level.ordinal() < localLevel.ordinal()))) {
          localLevel = ((PatternLevel)localObject).level;
        }
      }
    }
    paramString = (String)localObject;
    if (localObject == null)
    {
      localObject = System.getProperty("com.j256.ormlite.logger.level");
      if (localObject != null) {
        break label121;
      }
      paramString = DEFAULT_LEVEL;
    }
    for (;;)
    {
      this.level = paramString;
      return;
      try
      {
        label121:
        paramString = Log.Level.valueOf(((String)localObject).toUpperCase());
      }
      catch (IllegalArgumentException paramString)
      {
        throw new IllegalArgumentException("Level '" + (String)localObject + "' was not found", paramString);
      }
    }
  }
  
  private static List<PatternLevel> configureClassLevels(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Object localObject = paramInputStream.readLine();
      if (localObject == null) {
        return localArrayList;
      }
      if ((((String)localObject).length() != 0) && (((String)localObject).charAt(0) != '#'))
      {
        String[] arrayOfString = ((String)localObject).split("=");
        if (arrayOfString.length != 2)
        {
          System.err.println("Line is not in the format of 'pattern = level': " + (String)localObject);
        }
        else
        {
          localObject = Pattern.compile(arrayOfString[0].trim());
          try
          {
            Log.Level localLevel = Log.Level.valueOf(arrayOfString[1].trim());
            localArrayList.add(new PatternLevel((Pattern)localObject, localLevel));
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            System.err.println("Level '" + arrayOfString[1] + "' was not found");
          }
        }
      }
    }
  }
  
  public static void openLogFile(String paramString)
  {
    if (paramString == null)
    {
      printStream = System.out;
      return;
    }
    try
    {
      printStream = new PrintStream(new File(paramString));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      throw new IllegalArgumentException("Log file " + paramString + " was not found", localFileNotFoundException);
    }
  }
  
  private void printMessage(Log.Level paramLevel, String paramString, Throwable paramThrowable)
  {
    if (!isLevelEnabled(paramLevel)) {}
    do
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(((DateFormat)dateFormatThreadLocal.get()).format(new Date()));
      localStringBuilder.append(" [").append(paramLevel.name()).append("] ");
      localStringBuilder.append(this.className).append(' ');
      localStringBuilder.append(paramString);
      printStream.println(localStringBuilder.toString());
    } while (paramThrowable == null);
    paramThrowable.printStackTrace(printStream);
  }
  
  /* Error */
  static List<PatternLevel> readLevelResourceFile(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: invokestatic 263	com/j256/ormlite/logger/LocalLog:configureClassLevels	(Ljava/io/InputStream;)Ljava/util/List;
    //   10: astore_1
    //   11: aload_0
    //   12: invokevirtual 268	java/io/InputStream:close	()V
    //   15: aload_1
    //   16: areturn
    //   17: astore_1
    //   18: getstatic 180	java/lang/System:err	Ljava/io/PrintStream;
    //   21: new 130	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 270
    //   31: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_1
    //   35: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 187	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   44: aload_0
    //   45: invokevirtual 268	java/io/InputStream:close	()V
    //   48: aconst_null
    //   49: areturn
    //   50: astore_0
    //   51: aconst_null
    //   52: areturn
    //   53: astore_1
    //   54: aload_0
    //   55: invokevirtual 268	java/io/InputStream:close	()V
    //   58: aload_1
    //   59: athrow
    //   60: astore_0
    //   61: aload_1
    //   62: areturn
    //   63: astore_0
    //   64: goto -6 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramInputStream	InputStream
    //   1	15	1	localList	List
    //   17	18	1	localIOException	IOException
    //   53	9	1	localList1	List<PatternLevel>
    // Exception table:
    //   from	to	target	type
    //   6	11	17	java/io/IOException
    //   44	48	50	java/io/IOException
    //   6	11	53	finally
    //   18	44	53	finally
    //   11	15	60	java/io/IOException
    //   54	58	63	java/io/IOException
  }
  
  void flush()
  {
    printStream.flush();
  }
  
  public boolean isLevelEnabled(Log.Level paramLevel)
  {
    return this.level.isEnabled(paramLevel);
  }
  
  public void log(Log.Level paramLevel, String paramString)
  {
    printMessage(paramLevel, paramString, null);
  }
  
  public void log(Log.Level paramLevel, String paramString, Throwable paramThrowable)
  {
    printMessage(paramLevel, paramString, paramThrowable);
  }
  
  private static class PatternLevel
  {
    Log.Level level;
    Pattern pattern;
    
    public PatternLevel(Pattern paramPattern, Log.Level paramLevel)
    {
      this.pattern = paramPattern;
      this.level = paramLevel;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/logger/LocalLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */