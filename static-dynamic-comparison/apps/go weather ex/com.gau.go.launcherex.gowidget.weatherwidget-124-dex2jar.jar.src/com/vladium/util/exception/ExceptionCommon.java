package com.vladium.util.exception;

import com.vladium.util.IJREVersion;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

abstract class ExceptionCommon
  implements IJREVersion
{
  private static final Class ABSTACT_RUNTIME_EXCEPTION;
  private static final Class ABSTRACT_EXCEPTION;
  private static final boolean EMBED_ERROR_CODE = true;
  static final Enumeration EMPTY_ENUMERATION;
  private static final ResourceBundle EMPTY_RESOURCE_BUNDLE;
  private static final String EOL;
  private static final String NESTED_THROWABLE_HEADER = "[NESTED EXCEPTION]:";
  private static final ResourceBundle ROOT_RESOURCE_BUNDLE;
  private static final String ROOT_RESOURCE_BUNDLE_NAME;
  private static final Class THROWABLE;
  private static final Map s_exceptionCodeMap = new HashMap();
  
  static
  {
    THROWABLE = Throwable.class;
    ABSTRACT_EXCEPTION = AbstractException.class;
    ABSTACT_RUNTIME_EXCEPTION = AbstractRuntimeException.class;
    EMPTY_ENUMERATION = Collections.enumeration(Collections.EMPTY_SET);
    EMPTY_RESOURCE_BUNDLE = new ResourceBundle()
    {
      public Enumeration getKeys()
      {
        return ExceptionCommon.EMPTY_ENUMERATION;
      }
      
      public Object handleGetObject(String paramAnonymousString)
      {
        return null;
      }
    };
    EOL = System.getProperty("line.separator", "\n");
    ROOT_RESOURCE_BUNDLE_NAME = getNameInNamespace(ExceptionCommon.class, "exceptions");
    Object localObject = null;
    try
    {
      ResourceBundle localResourceBundle = ResourceBundle.getBundle(ROOT_RESOURCE_BUNDLE_NAME);
      localObject = localResourceBundle;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    ROOT_RESOURCE_BUNDLE = (ResourceBundle)localObject;
  }
  
  public static ResourceBundle addExceptionResource(Class paramClass, String paramString)
  {
    if ((paramClass != null) && (paramString != null) && (paramString.length() > 0)) {
      if ((!ABSTRACT_EXCEPTION.isAssignableFrom(paramClass)) && (!ABSTACT_RUNTIME_EXCEPTION.isAssignableFrom(paramClass))) {
        throw new Error("addExceptionResource(): class [" + paramClass + "] is not a subclass of " + ABSTRACT_EXCEPTION.getName() + " or " + ABSTACT_RUNTIME_EXCEPTION.getName());
      }
    }
    try
    {
      localObject2 = getNameInNamespace(paramClass, paramString);
      ??? = paramClass.getClassLoader();
      paramString = (String)???;
      if (??? == null) {
        paramString = ClassLoader.getSystemClassLoader();
      }
      paramString = ResourceBundle.getBundle((String)localObject2, Locale.getDefault(), paramString);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Object localObject2;
        paramString = null;
      }
    }
    if (paramString != null) {
      synchronized (s_exceptionCodeMap)
      {
        localObject2 = (ResourceBundle)s_exceptionCodeMap.get(paramClass);
        if (localObject2 != null) {
          return (ResourceBundle)localObject2;
        }
        s_exceptionCodeMap.put(paramClass, paramString);
        return paramString;
      }
    }
    return null;
  }
  
  static String getMessage(Class paramClass, String paramString)
  {
    if (paramString == null) {
      paramClass = null;
    }
    for (;;)
    {
      return paramClass;
      try
      {
        if (paramString.length() > 0)
        {
          String str = lookup(paramClass, paramString);
          paramClass = paramString;
          if (str != null) {
            return "[" + paramString + "] " + str;
          }
        }
        else
        {
          return "";
        }
      }
      catch (Throwable paramClass) {}
    }
    return paramString;
  }
  
  static String getMessage(Class paramClass, String paramString, Object[] paramArrayOfObject)
  {
    if (paramString == null) {
      paramClass = null;
    }
    String str;
    do
    {
      do
      {
        return paramClass;
        str = getMessage(paramClass, paramString);
        paramClass = str;
      } while (paramArrayOfObject == null);
      paramClass = str;
    } while (paramArrayOfObject.length == 0);
    try
    {
      paramClass = MessageFormat.format(str, paramArrayOfObject);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass = new StringBuffer(paramString + EOL);
      int i = 0;
      for (;;)
      {
        if (i < paramArrayOfObject.length)
        {
          paramClass.append("\t{" + i + "} = [");
          paramString = paramArrayOfObject[i];
          try
          {
            paramClass.append(paramString.toString());
            paramClass.append("]");
            paramClass.append(EOL);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              if (paramString != null) {
                paramClass.append(paramString.getClass().getName());
              } else {
                paramClass.append("null");
              }
            }
          }
        }
      }
    }
    return paramClass.toString();
  }
  
  private static String getNameInNamespace(Class paramClass, String paramString)
  {
    if (paramClass == null) {}
    int i;
    do
    {
      return paramString;
      paramClass = paramClass.getName();
      i = paramClass.lastIndexOf('.');
    } while (i <= 0);
    return paramClass.substring(0, i + 1) + paramString;
  }
  
  private static String lookup(Class paramClass, String paramString)
  {
    if (paramString == null) {
      paramClass = null;
    }
    for (;;)
    {
      return paramClass;
      Class localClass;
      label14:
      Object localObject;
      if (paramClass != null)
      {
        localClass = paramClass;
        if ((localClass != ABSTRACT_EXCEPTION) && (localClass != ABSTACT_RUNTIME_EXCEPTION) && (localClass != THROWABLE) && (localClass != null)) {
          synchronized (s_exceptionCodeMap)
          {
            localObject = (ResourceBundle)s_exceptionCodeMap.get(localClass);
            paramClass = (Class)localObject;
            if (localObject == null)
            {
              localObject = addExceptionResource(localClass, "exceptions");
              paramClass = (Class)localObject;
              if (localObject == null)
              {
                s_exceptionCodeMap.put(localClass, EMPTY_RESOURCE_BUNDLE);
                paramClass = (Class)localObject;
              }
            }
            if (paramClass != null) {
              localObject = null;
            }
          }
        }
      }
      try
      {
        paramClass = paramClass.getString(paramString);
        localObject = paramClass;
        paramClass = (Class)localObject;
        if (localObject != null) {
          continue;
        }
        localClass = localClass.getSuperclass();
        break label14;
        paramClass = finally;
        throw paramClass;
        if (ROOT_RESOURCE_BUNDLE != null) {
          paramClass = null;
        }
      }
      catch (Throwable paramClass)
      {
        try
        {
          paramString = ROOT_RESOURCE_BUNDLE.getString(paramString);
          paramClass = paramString;
          if (paramString != null) {
            continue;
          }
          return null;
          paramClass = paramClass;
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            paramString = paramClass;
          }
        }
      }
    }
  }
  
  static void printStackTrace(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    if (JRE_1_4_PLUS)
    {
      if ((paramThrowable instanceof IThrowableWrapper))
      {
        ((IThrowableWrapper)paramThrowable).__printStackTrace(paramPrintStream);
        return;
      }
      paramThrowable.printStackTrace(paramPrintStream);
      return;
    }
    int i = 1;
    label32:
    if (paramThrowable != null)
    {
      if (i == 0) {
        break label71;
      }
      i = 0;
    }
    for (;;)
    {
      if (!(paramThrowable instanceof IThrowableWrapper)) {
        break label84;
      }
      paramThrowable = (IThrowableWrapper)paramThrowable;
      paramThrowable.__printStackTrace(paramPrintStream);
      paramThrowable = paramThrowable.getCause();
      break label32;
      break;
      label71:
      paramPrintStream.println();
      paramPrintStream.println("[NESTED EXCEPTION]:");
    }
    label84:
    paramThrowable.printStackTrace(paramPrintStream);
  }
  
  static void printStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    if (JRE_1_4_PLUS)
    {
      if ((paramThrowable instanceof IThrowableWrapper))
      {
        ((IThrowableWrapper)paramThrowable).__printStackTrace(paramPrintWriter);
        return;
      }
      paramThrowable.printStackTrace(paramPrintWriter);
      return;
    }
    int i = 1;
    label32:
    if (paramThrowable != null)
    {
      if (i == 0) {
        break label71;
      }
      i = 0;
    }
    for (;;)
    {
      if (!(paramThrowable instanceof IThrowableWrapper)) {
        break label84;
      }
      paramThrowable = (IThrowableWrapper)paramThrowable;
      paramThrowable.__printStackTrace(paramPrintWriter);
      paramThrowable = paramThrowable.getCause();
      break label32;
      break;
      label71:
      paramPrintWriter.println();
      paramPrintWriter.println("[NESTED EXCEPTION]:");
    }
    label84:
    paramThrowable.printStackTrace(paramPrintWriter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/exception/ExceptionCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */