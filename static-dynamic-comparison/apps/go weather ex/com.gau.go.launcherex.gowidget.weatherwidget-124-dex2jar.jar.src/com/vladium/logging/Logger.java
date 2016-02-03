package com.vladium.logging;

import com.vladium.util.ClassLoaderResolver;
import com.vladium.util.Property;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

public final class Logger
  implements ILogLevels
{
  private static final String COMMA_DELIMITERS = ", \t\r\n";
  private static final boolean FLUSH_LOG = true;
  private static final String PREFIX_TO_STRIP = "com.vladium.";
  private static final int PREFIX_TO_STRIP_LENGTH = "com.vladium.".length();
  private static final Logger STATIC_LOGGER;
  private static final ThreadLocalStack THREAD_LOCAL_STACK = new ThreadLocalStack(null);
  private final Set m_classMask;
  private final int m_level;
  private final PrintWriter m_out;
  private final String m_prefix;
  
  static
  {
    Object localObject1 = Property.getAppProperties("emma", Logger.class.getClassLoader());
    int i = stringToLevel(((Properties)localObject1).getProperty("verbosity.level", "info"));
    Object localObject2 = ((Properties)localObject1).getProperty("verbosity.filter");
    HashSet localHashSet = null;
    localObject1 = localHashSet;
    if (localObject2 != null)
    {
      localObject2 = new StringTokenizer((String)localObject2, ", \t\r\n");
      localObject1 = localHashSet;
      if (((StringTokenizer)localObject2).countTokens() > 0)
      {
        localHashSet = new HashSet(((StringTokenizer)localObject2).countTokens());
        for (;;)
        {
          localObject1 = localHashSet;
          if (!((StringTokenizer)localObject2).hasMoreTokens()) {
            break;
          }
          localHashSet.add(((StringTokenizer)localObject2).nextToken());
        }
      }
    }
    STATIC_LOGGER = create(i, new PrintWriter(System.out, false), "EMMA", (Set)localObject1);
  }
  
  private Logger(int paramInt, PrintWriter paramPrintWriter, String paramString, Set paramSet)
  {
    this.m_level = paramInt;
    this.m_out = paramPrintWriter;
    this.m_prefix = paramString;
    this.m_classMask = paramSet;
  }
  
  private void _log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    Object localObject2;
    if ((paramInt <= this.m_level) && (paramInt >= 0))
    {
      localObject2 = ClassLoaderResolver.getCallerClass(2);
      if (this.m_prefix == null) {
        break label266;
      }
    }
    label266:
    for (Object localObject1 = this.m_prefix + ": ";; localObject1 = "")
    {
      StringBuffer localStringBuffer = new StringBuffer((String)localObject1);
      if ((localObject2 != null) || (paramString1 != null))
      {
        localStringBuffer.append("[");
        if (localObject2 != null)
        {
          localObject2 = ((Class)localObject2).getName();
          localObject1 = localObject2;
          if (((String)localObject2).startsWith("com.vladium.")) {
            localObject1 = ((String)localObject2).substring(PREFIX_TO_STRIP_LENGTH);
          }
          localObject2 = localObject1;
          paramInt = ((String)localObject1).indexOf('$');
          if (paramInt > 0) {
            localObject2 = ((String)localObject1).substring(0, paramInt);
          }
          if ((this.m_classMask == null) || (this.m_classMask.contains(localObject2))) {
            localStringBuffer.append((String)localObject1);
          }
        }
        else
        {
          if (paramString1 != null)
          {
            localStringBuffer.append("::");
            localStringBuffer.append(paramString1);
          }
          localStringBuffer.append("] ");
        }
      }
      else
      {
        paramString1 = this.m_out;
        if (paramString2 != null) {
          localStringBuffer.append(paramString2);
        }
        if (paramThrowable != null)
        {
          paramString2 = new StringWriter();
          localObject1 = new PrintWriter(paramString2);
          paramThrowable.printStackTrace((PrintWriter)localObject1);
          ((PrintWriter)localObject1).flush();
          localStringBuffer.append(paramString2.toString());
        }
        paramString1.println(localStringBuffer);
        paramString1.flush();
      }
      return;
    }
  }
  
  private void _log(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramInt <= this.m_level) && (paramInt >= 0))
    {
      if (!paramBoolean) {
        break label226;
      }
      localObject1 = ClassLoaderResolver.getCallerClass(2);
      if (this.m_prefix == null) {
        break label232;
      }
    }
    label226:
    label232:
    for (Object localObject2 = this.m_prefix + ": ";; localObject2 = "")
    {
      StringBuffer localStringBuffer = new StringBuffer((String)localObject2);
      if ((localObject1 != null) || (paramString1 != null))
      {
        localStringBuffer.append("[");
        if (localObject1 != null)
        {
          localObject2 = ((Class)localObject1).getName();
          localObject1 = localObject2;
          if (((String)localObject2).startsWith("com.vladium.")) {
            localObject1 = ((String)localObject2).substring(PREFIX_TO_STRIP_LENGTH);
          }
          localObject2 = localObject1;
          paramInt = ((String)localObject1).indexOf('$');
          if (paramInt > 0) {
            localObject2 = ((String)localObject1).substring(0, paramInt);
          }
          if ((this.m_classMask == null) || (this.m_classMask.contains(localObject2))) {
            localStringBuffer.append((String)localObject1);
          }
        }
        else
        {
          if (paramString1 != null)
          {
            localStringBuffer.append("::");
            localStringBuffer.append(paramString1);
          }
          localStringBuffer.append("] ");
        }
      }
      else
      {
        paramString1 = this.m_out;
        if (paramString2 != null) {
          localStringBuffer.append(paramString2);
        }
        paramString1.println(localStringBuffer);
        paramString1.flush();
      }
      return;
      localObject1 = null;
      break;
    }
  }
  
  private void cleanup()
  {
    this.m_out.flush();
  }
  
  public static Logger create(int paramInt, PrintWriter paramPrintWriter, String paramString, Set paramSet)
  {
    if ((paramInt < -1) || (paramInt > 7)) {
      throw new IllegalArgumentException("invalid log level: " + paramInt);
    }
    if ((paramPrintWriter == null) || (paramPrintWriter.checkError())) {
      throw new IllegalArgumentException("null or corrupt input: out");
    }
    return new Logger(paramInt, paramPrintWriter, paramString, paramSet);
  }
  
  public static Logger create(int paramInt, PrintWriter paramPrintWriter, String paramString, Set paramSet, Logger paramLogger)
  {
    if (paramLogger == null) {
      return create(paramInt, paramPrintWriter, paramString, paramSet);
    }
    if (paramInt >= -1)
    {
      if ((paramPrintWriter == null) || (paramPrintWriter.checkError())) {
        break label54;
      }
      label29:
      if (paramSet == null) {
        break label63;
      }
    }
    for (;;)
    {
      return new Logger(paramInt, paramPrintWriter, paramString, paramSet);
      paramInt = paramLogger.m_level;
      break;
      label54:
      paramPrintWriter = paramLogger.m_out;
      break label29;
      label63:
      paramSet = paramLogger.m_classMask;
    }
  }
  
  public static Logger getLogger()
  {
    LinkedList localLinkedList = (LinkedList)THREAD_LOCAL_STACK.get();
    if (localLinkedList.isEmpty()) {
      return STATIC_LOGGER;
    }
    return (Logger)localLinkedList.getLast();
  }
  
  public static void pop(Logger paramLogger)
  {
    LinkedList localLinkedList = (LinkedList)THREAD_LOCAL_STACK.get();
    Logger localLogger;
    try
    {
      localLogger = (Logger)localLinkedList.getLast();
      if (localLogger != paramLogger) {
        throw new IllegalStateException("invalid context being popped: " + paramLogger);
      }
    }
    catch (NoSuchElementException paramLogger)
    {
      throw new IllegalStateException("empty logger context stack on thread [" + Thread.currentThread() + "]: " + paramLogger);
    }
    localLinkedList.removeLast();
    localLogger.cleanup();
  }
  
  public static void push(Logger paramLogger)
  {
    if (paramLogger == null) {
      throw new IllegalArgumentException("null input: ctx");
    }
    ((LinkedList)THREAD_LOCAL_STACK.get()).addLast(paramLogger);
  }
  
  public static int stringToLevel(String paramString)
  {
    int j;
    if (("severe".equalsIgnoreCase(paramString)) || ("silent".equalsIgnoreCase(paramString))) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      if (("warning".equalsIgnoreCase(paramString)) || ("quiet".equalsIgnoreCase(paramString))) {
        return 1;
      }
      if ("info".equalsIgnoreCase(paramString)) {
        return 2;
      }
      if ("verbose".equalsIgnoreCase(paramString)) {
        return 3;
      }
      if ("trace1".equalsIgnoreCase(paramString)) {
        return 4;
      }
      if ("trace2".equalsIgnoreCase(paramString)) {
        return 5;
      }
      if ("trace3".equalsIgnoreCase(paramString)) {
        return 6;
      }
      if ("none".equalsIgnoreCase(paramString)) {
        return -1;
      }
      if ("all".equalsIgnoreCase(paramString)) {
        return 7;
      }
      i = Integer.MIN_VALUE;
      try
      {
        j = Integer.parseInt(paramString);
        i = j;
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
      if (i < -1) {
        break;
      }
      j = i;
    } while (i <= 7);
    return 2;
  }
  
  public final boolean atINFO()
  {
    return 2 <= this.m_level;
  }
  
  public final boolean atTRACE1()
  {
    return 4 <= this.m_level;
  }
  
  public final boolean atTRACE2()
  {
    return 5 <= this.m_level;
  }
  
  public final boolean atTRACE3()
  {
    return 6 <= this.m_level;
  }
  
  public final boolean atVERBOSE()
  {
    return 3 <= this.m_level;
  }
  
  public PrintWriter getWriter()
  {
    return this.m_out;
  }
  
  public final void info(String paramString)
  {
    _log(2, null, paramString, false);
  }
  
  public final boolean isLoggable(int paramInt)
  {
    return paramInt <= this.m_level;
  }
  
  public final void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    _log(paramInt, paramString1, paramString2, paramThrowable);
  }
  
  public final void log(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    _log(paramInt, paramString1, paramString2, paramBoolean);
  }
  
  public final void log(int paramInt, String paramString, Throwable paramThrowable)
  {
    _log(paramInt, null, paramString, paramThrowable);
  }
  
  public final void log(int paramInt, String paramString, boolean paramBoolean)
  {
    _log(paramInt, null, paramString, paramBoolean);
  }
  
  public final void trace1(String paramString1, String paramString2)
  {
    _log(4, paramString1, paramString2, true);
  }
  
  public final void trace2(String paramString1, String paramString2)
  {
    _log(5, paramString1, paramString2, true);
  }
  
  public final void trace3(String paramString1, String paramString2)
  {
    _log(6, paramString1, paramString2, true);
  }
  
  public final void verbose(String paramString)
  {
    _log(3, null, paramString, false);
  }
  
  public final void warning(String paramString)
  {
    _log(1, null, paramString, false);
  }
  
  private static final class ThreadLocalStack
    extends InheritableThreadLocal
  {
    protected Object initialValue()
    {
      return new LinkedList();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/logging/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */