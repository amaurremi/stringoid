package com.vladium.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public abstract class Property
{
  private static String s_systemFingerprint;
  private static Properties s_systemProperties;
  private static Properties s_systemRedirects;
  
  public static Properties combine(Properties paramProperties1, Properties paramProperties2)
  {
    if (paramProperties2 == null)
    {
      paramProperties2 = paramProperties1;
      if (paramProperties1 == null) {
        paramProperties2 = new XProperties();
      }
      return paramProperties2;
    }
    if (paramProperties1 == null) {
      return paramProperties2;
    }
    paramProperties2 = new XProperties(paramProperties2);
    Enumeration localEnumeration = paramProperties1.propertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      paramProperties2.setProperty(str, paramProperties1.getProperty(str));
    }
    return paramProperties2;
  }
  
  public static Properties getAppProperties(String paramString, ClassLoader paramClassLoader)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null properties: appNameLC");
    }
    Properties localProperties1 = getProperties(paramString + "_default.properties", paramClassLoader);
    Object localObject = getSystemProperty(paramString + ".properties");
    if (localObject != null) {}
    for (localObject = new File((String)localObject);; localObject = null)
    {
      localObject = getLazyPropertiesFromFile((File)localObject);
      Properties localProperties2 = getSystemProperties(paramString);
      return combine(getProperties(paramString + ".properties", paramClassLoader), combine(localProperties2, combine((Properties)localObject, localProperties1)));
    }
  }
  
  public static Properties getLazyPropertiesFromFile(File paramFile)
  {
    return new FilePropertyLookup(paramFile);
  }
  
  /* Error */
  public static Properties getProperties(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_1
    //   6: aload_0
    //   7: invokestatic 111	com/vladium/util/ResourceLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: ifnull +22 -> 36
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: astore_2
    //   21: new 27	com/vladium/util/XProperties
    //   24: dup
    //   25: invokespecial 28	com/vladium/util/XProperties:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: aload_0
    //   31: invokevirtual 115	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   34: aload_3
    //   35: astore_1
    //   36: aload_0
    //   37: ifnull +7 -> 44
    //   40: aload_0
    //   41: invokevirtual 120	java/io/InputStream:close	()V
    //   44: aload_1
    //   45: areturn
    //   46: astore_0
    //   47: aload_1
    //   48: astore_0
    //   49: aload_0
    //   50: ifnull +7 -> 57
    //   53: aload_0
    //   54: invokevirtual 120	java/io/InputStream:close	()V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aload_2
    //   61: ifnull +7 -> 68
    //   64: aload_2
    //   65: invokevirtual 120	java/io/InputStream:close	()V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: goto -27 -> 44
    //   74: astore_0
    //   75: goto -18 -> 57
    //   78: astore_1
    //   79: goto -11 -> 68
    //   82: astore_1
    //   83: aload_0
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: goto -27 -> 60
    //   90: astore_1
    //   91: goto -42 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramString	String
    //   5	43	1	localObject1	Object
    //   78	1	1	localThrowable1	Throwable
    //   82	4	1	localObject2	Object
    //   90	1	1	localThrowable2	Throwable
    //   3	82	2	str	String
    //   1	34	3	localXProperties	XProperties
    // Exception table:
    //   from	to	target	type
    //   6	11	46	java/lang/Throwable
    //   21	29	46	java/lang/Throwable
    //   6	11	59	finally
    //   21	29	59	finally
    //   40	44	70	java/lang/Throwable
    //   53	57	74	java/lang/Throwable
    //   64	68	78	java/lang/Throwable
    //   29	34	82	finally
    //   29	34	90	java/lang/Throwable
  }
  
  /* Error */
  public static Properties getProperties(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 123	com/vladium/util/ResourceLoader:getResourceAsStream	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload 4
    //   15: astore_1
    //   16: aload_0
    //   17: ifnull +20 -> 37
    //   20: aload_0
    //   21: astore_2
    //   22: aload_0
    //   23: astore_3
    //   24: new 27	com/vladium/util/XProperties
    //   27: dup
    //   28: invokespecial 28	com/vladium/util/XProperties:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: aload_0
    //   34: invokevirtual 115	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   37: aload_0
    //   38: ifnull +7 -> 45
    //   41: aload_0
    //   42: invokevirtual 120	java/io/InputStream:close	()V
    //   45: aload_1
    //   46: areturn
    //   47: astore_0
    //   48: aload_2
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull +7 -> 58
    //   54: aload_0
    //   55: invokevirtual 120	java/io/InputStream:close	()V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_0
    //   61: aload_3
    //   62: ifnull +7 -> 69
    //   65: aload_3
    //   66: invokevirtual 120	java/io/InputStream:close	()V
    //   69: aload_0
    //   70: athrow
    //   71: astore_0
    //   72: goto -27 -> 45
    //   75: astore_0
    //   76: goto -18 -> 58
    //   79: astore_1
    //   80: goto -11 -> 69
    //   83: astore_1
    //   84: aload_0
    //   85: astore_3
    //   86: aload_1
    //   87: astore_0
    //   88: goto -27 -> 61
    //   91: astore_1
    //   92: goto -42 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramString	String
    //   0	95	1	paramClassLoader	ClassLoader
    //   6	43	2	str1	String
    //   4	82	3	str2	String
    //   1	13	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	13	47	java/lang/Throwable
    //   24	32	47	java/lang/Throwable
    //   7	13	60	finally
    //   24	32	60	finally
    //   41	45	71	java/lang/Throwable
    //   54	58	75	java/lang/Throwable
    //   65	69	79	java/lang/Throwable
    //   32	37	83	finally
    //   32	37	91	java/lang/Throwable
  }
  
  /* Error */
  public static Properties getPropertiesFromFile(File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 61	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc -128
    //   10: invokespecial 66	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aconst_null
    //   15: astore_2
    //   16: new 130	java/io/BufferedInputStream
    //   19: dup
    //   20: new 132	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 133	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: sipush 8192
    //   31: invokespecial 136	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   34: astore_0
    //   35: new 27	com/vladium/util/XProperties
    //   38: dup
    //   39: invokespecial 28	com/vladium/util/XProperties:<init>	()V
    //   42: astore_1
    //   43: aload_1
    //   44: aload_0
    //   45: invokevirtual 115	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_0
    //   49: ifnull +7 -> 56
    //   52: aload_0
    //   53: invokevirtual 120	java/io/InputStream:close	()V
    //   56: aload_1
    //   57: areturn
    //   58: astore_1
    //   59: aload_2
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 120	java/io/InputStream:close	()V
    //   69: aload_1
    //   70: athrow
    //   71: astore_0
    //   72: goto -16 -> 56
    //   75: astore_0
    //   76: goto -7 -> 69
    //   79: astore_1
    //   80: goto -19 -> 61
    //   83: astore_1
    //   84: goto -23 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramFile	File
    //   42	15	1	localXProperties	XProperties
    //   58	12	1	localObject1	Object
    //   79	1	1	localObject2	Object
    //   83	1	1	localObject3	Object
    //   15	45	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   16	35	58	finally
    //   52	56	71	java/lang/Throwable
    //   65	69	75	java/lang/Throwable
    //   35	43	79	finally
    //   43	48	83	finally
  }
  
  public static String getSystemFingerprint()
  {
    if (s_systemFingerprint != null) {
      return s_systemFingerprint;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(getSystemProperty("java.vm.name", ""));
    localStringBuffer.append(':');
    localStringBuffer.append(getSystemProperty("java.vm.version", ""));
    localStringBuffer.append(':');
    localStringBuffer.append(getSystemProperty("java.vm.vendor", ""));
    localStringBuffer.append(':');
    localStringBuffer.append(getSystemProperty("os.name", ""));
    localStringBuffer.append(':');
    localStringBuffer.append(getSystemProperty("os.version", ""));
    localStringBuffer.append(':');
    localStringBuffer.append(getSystemProperty("os.arch", ""));
    s_systemFingerprint = localStringBuffer.toString();
    return s_systemFingerprint;
  }
  
  public static Properties getSystemProperties(String paramString)
  {
    Properties localProperties = s_systemProperties;
    if (localProperties == null)
    {
      paramString = new SystemPropertyLookup(paramString);
      s_systemProperties = paramString;
      return paramString;
    }
    return localProperties;
  }
  
  public static String getSystemProperty(String paramString)
  {
    try
    {
      paramString = System.getProperty(paramString);
      return paramString;
    }
    catch (SecurityException paramString) {}
    return null;
  }
  
  public static String getSystemProperty(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = System.getProperty(paramString1, paramString2);
      return paramString1;
    }
    catch (SecurityException paramString1) {}
    return paramString2;
  }
  
  public static Properties getSystemPropertyRedirects(Map paramMap)
  {
    Properties localProperties = s_systemRedirects;
    if (localProperties == null)
    {
      paramMap = new SystemRedirectsLookup(paramMap);
      s_systemRedirects = paramMap;
      return paramMap;
    }
    return localProperties;
  }
  
  public static boolean toBoolean(String paramString)
  {
    if (paramString == null) {}
    while ((!paramString.startsWith("t")) && (!paramString.startsWith("y"))) {
      return false;
    }
    return true;
  }
  
  private static final class FilePropertyLookup
    extends XProperties
  {
    private Properties m_contents;
    private final File m_src;
    
    FilePropertyLookup(File paramFile)
    {
      this.m_src = paramFile;
    }
    
    /* Error */
    private void faultContents()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 26	com/vladium/util/Property$FilePropertyLookup:m_contents	Ljava/util/Properties;
      //   6: astore_2
      //   7: aload_2
      //   8: astore_1
      //   9: aload_2
      //   10: ifnonnull +22 -> 32
      //   13: aload_0
      //   14: getfield 18	com/vladium/util/Property$FilePropertyLookup:m_src	Ljava/io/File;
      //   17: astore_3
      //   18: aload_2
      //   19: astore_1
      //   20: aload_3
      //   21: ifnull +11 -> 32
      //   24: aload_0
      //   25: getfield 18	com/vladium/util/Property$FilePropertyLookup:m_src	Ljava/io/File;
      //   28: invokestatic 30	com/vladium/util/Property:getPropertiesFromFile	(Ljava/io/File;)Ljava/util/Properties;
      //   31: astore_1
      //   32: aload_1
      //   33: astore_2
      //   34: aload_1
      //   35: ifnonnull +11 -> 46
      //   38: new 4	com/vladium/util/XProperties
      //   41: dup
      //   42: invokespecial 16	com/vladium/util/XProperties:<init>	()V
      //   45: astore_2
      //   46: aload_0
      //   47: aload_2
      //   48: putfield 26	com/vladium/util/Property$FilePropertyLookup:m_contents	Ljava/util/Properties;
      //   51: aload_0
      //   52: monitorexit
      //   53: return
      //   54: astore_1
      //   55: aload_1
      //   56: athrow
      //   57: astore_1
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_1
      //   61: athrow
      //   62: astore_1
      //   63: new 22	java/lang/RuntimeException
      //   66: dup
      //   67: new 32	java/lang/StringBuilder
      //   70: dup
      //   71: invokespecial 33	java/lang/StringBuilder:<init>	()V
      //   74: ldc 35
      //   76: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: aload_0
      //   80: getfield 18	com/vladium/util/Property$FilePropertyLookup:m_src	Ljava/io/File;
      //   83: invokevirtual 45	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   86: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   89: ldc 47
      //   91: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   94: aload_1
      //   95: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   98: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   101: invokespecial 56	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   104: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	105	0	this	FilePropertyLookup
      //   8	27	1	localObject1	Object
      //   54	2	1	localRuntimeException	RuntimeException
      //   57	4	1	localObject2	Object
      //   62	33	1	localException	Exception
      //   6	42	2	localObject3	Object
      //   17	4	3	localFile	File
      // Exception table:
      //   from	to	target	type
      //   24	32	54	java/lang/RuntimeException
      //   2	7	57	finally
      //   13	18	57	finally
      //   24	32	57	finally
      //   38	46	57	finally
      //   46	51	57	finally
      //   55	57	57	finally
      //   63	105	57	finally
      //   24	32	62	java/lang/Exception
    }
    
    public Object get(Object paramObject)
    {
      faultContents();
      return this.m_contents.get(paramObject);
    }
    
    public String getProperty(String paramString)
    {
      faultContents();
      return this.m_contents.getProperty(paramString);
    }
    
    public Enumeration keys()
    {
      faultContents();
      return this.m_contents.keys();
    }
  }
  
  private static final class SystemPropertyLookup
    extends XProperties
  {
    private final String m_systemPrefix;
    
    SystemPropertyLookup(String paramString)
    {
      String str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (!paramString.endsWith(".")) {
          str = paramString.concat(".");
        }
      }
      this.m_systemPrefix = str;
    }
    
    public Object get(Object paramObject)
    {
      Object localObject;
      if (!(paramObject instanceof String)) {
        localObject = null;
      }
      do
      {
        do
        {
          String str;
          do
          {
            return localObject;
            str = (String)super.get(paramObject);
            localObject = str;
          } while (str != null);
          localObject = str;
        } while (this.m_systemPrefix == null);
        paramObject = Property.getSystemProperty(this.m_systemPrefix.concat((String)paramObject), null);
        localObject = paramObject;
      } while (paramObject == null);
      return paramObject;
    }
    
    public String getProperty(String paramString)
    {
      return (String)get(paramString);
    }
    
    public Enumeration keys()
    {
      try
      {
        Object localObject1 = new Hashtable();
        Object localObject3 = this.m_systemPrefix;
        if (localObject3 != null) {
          try
          {
            int i = this.m_systemPrefix.length();
            localObject3 = System.getProperties().propertyNames();
            while (((Enumeration)localObject3).hasMoreElements())
            {
              String str = (String)((Enumeration)localObject3).nextElement();
              if (str.startsWith(this.m_systemPrefix))
              {
                str = str.substring(i);
                ((Hashtable)localObject1).put(str, str);
              }
            }
            localObject1 = ((Hashtable)localObject1).keys();
          }
          catch (SecurityException localSecurityException)
          {
            localSecurityException.printStackTrace(System.out);
          }
        }
        return (Enumeration)localObject1;
      }
      finally {}
    }
  }
  
  private static final class SystemRedirectsLookup
    extends XProperties
  {
    private final Map m_systemRedirects;
    
    SystemRedirectsLookup(Map paramMap)
    {
      this.m_systemRedirects = paramMap;
    }
    
    public Object get(Object paramObject)
    {
      Object localObject;
      if (!(paramObject instanceof String)) {
        localObject = null;
      }
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              return localObject;
              str = (String)super.get(paramObject);
              localObject = str;
            } while (str != null);
            localObject = str;
          } while (this.m_systemRedirects == null);
          paramObject = (String)this.m_systemRedirects.get(paramObject);
          localObject = str;
        } while (paramObject == null);
        paramObject = Property.getSystemProperty((String)paramObject, null);
        localObject = paramObject;
      } while (paramObject == null);
      return paramObject;
    }
    
    public String getProperty(String paramString)
    {
      return (String)get(paramString);
    }
    
    public Enumeration keys()
    {
      try
      {
        Hashtable localHashtable = new Hashtable();
        if (this.m_systemRedirects != null)
        {
          Iterator localIterator = this.m_systemRedirects.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = localIterator.next();
            if (localObject2 != null) {
              localHashtable.put(localObject2, localObject2);
            }
          }
        }
        localEnumeration = ((Hashtable)localObject1).keys();
      }
      finally {}
      Enumeration localEnumeration;
      return localEnumeration;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */