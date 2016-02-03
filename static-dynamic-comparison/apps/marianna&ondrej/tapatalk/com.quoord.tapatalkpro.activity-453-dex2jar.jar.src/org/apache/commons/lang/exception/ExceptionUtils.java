package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

public class ExceptionUtils {
    private static String[] CAUSE_METHOD_NAMES = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    private static final Object CAUSE_METHOD_NAMES_LOCK = new Object();
    private static final Method THROWABLE_CAUSE_METHOD;
    private static final Method THROWABLE_INITCAUSE_METHOD;
    static final String WRAPPED_MARKER = " [wrapped] ";
    static Class class$java$lang$Throwable;

    static {
        for (; ; ) {
            try {
                if (class$java$lang$Throwable != null) {
                    continue;
                }
                localObject1 = class$("java.lang.Throwable");
                class$java$lang$Throwable = (Class) localObject1;
                localObject1 = ((Class) localObject1).getMethod("getCause", null);
            } catch (Exception localException1) {
                Object localObject1;
                localClass1 = null;
                continue;
                localClass1 = class$java$lang$Throwable;
                continue;
                localClass2 = class$java$lang$Throwable;
                continue;
            }
            THROWABLE_CAUSE_METHOD = (Method) localObject1;
            try {
                if (class$java$lang$Throwable != null) {
                    continue;
                }
                localObject1 = class$("java.lang.Throwable");
                class$java$lang$Throwable = (Class) localObject1;
                if (class$java$lang$Throwable != null) {
                    continue;
                }
                localClass2 = class$("java.lang.Throwable");
                class$java$lang$Throwable = localClass2;
                localObject1 = ((Class) localObject1).getMethod("initCause", new Class[]{localClass2});
            } catch (Exception localException2) {
                Class localClass2;
                Class localClass1;
                Object localObject2 = null;
                continue;
            }
            THROWABLE_INITCAUSE_METHOD = (Method) localObject1;
            return;
            localObject1 = class$java$lang$Throwable;
        }
    }

    public static void addCauseMethodName(String arg0) {
        if ((StringUtils.isNotEmpty( ? ??))&&(!isCauseMethodName( ? ??)))
        {
            ArrayList localArrayList = getCauseMethodNameList();
            if (localArrayList.add( ???)){
            synchronized (CAUSE_METHOD_NAMES_LOCK) {
                CAUSE_METHOD_NAMES = toArray(localArrayList);
                return;
            }
        }
        }
    }

    static Class class$(String paramString) {
        try {
            paramString = Class.forName(paramString);
            return paramString;
        } catch (ClassNotFoundException paramString) {
            throw new NoClassDefFoundError(paramString.getMessage());
        }
    }

    public static Throwable getCause(Throwable paramThrowable) {
        synchronized (CAUSE_METHOD_NAMES_LOCK) {
            paramThrowable = getCause(paramThrowable, CAUSE_METHOD_NAMES);
            return paramThrowable;
        }
    }

    public static Throwable getCause(Throwable paramThrowable, String[] arg1) {
        if (paramThrowable == null) {
            localObject1 = null;
        }
        Object localObject2;
        do {
            return (Throwable) localObject1;
            localObject2 = getCauseUsingWellKnownTypes(paramThrowable);
            localObject1 = localObject2;
        } while (localObject2 != null);
        Object localObject1 =???;
        if (???==null){
        }
        for (; ; ) {
            int i;
            synchronized (CAUSE_METHOD_NAMES_LOCK) {
                localObject1 = CAUSE_METHOD_NAMES;
                i = 0;
                ???=(String[]) localObject2;
                localObject2 =???;
                if (i < localObject1.length) {
                    localObject2 = localObject1[i];
                    if (localObject2 != null) {
                        localObject2 = getCauseUsingMethodName(paramThrowable, (String) localObject2);
                        ???=(String[]) localObject2;
                        if (localObject2 == null) {
                        }
                    }
                } else {
                    localObject1 = localObject2;
                    if (localObject2 != null) {
                        break;
                    }
                    return getCauseUsingFieldName(paramThrowable, "detail");
                }
            }
            i += 1;
        }
    }

    private static ArrayList getCauseMethodNameList() {
        synchronized (CAUSE_METHOD_NAMES_LOCK) {
            ArrayList localArrayList = new ArrayList(Arrays.asList(CAUSE_METHOD_NAMES));
            return localArrayList;
        }
    }

    private static Throwable getCauseUsingFieldName(Throwable paramThrowable, String paramString) {
        Class localClass = null;
        try {
            paramString = paramThrowable.getClass().getField(paramString);
            if (paramString != null) {
                if (class$java$lang$Throwable == null) {
                    localClass = class$("java.lang.Throwable");
                    class$java$lang$Throwable = localClass;
                }
                while (localClass.isAssignableFrom(paramString.getType())) {
                    try {
                        paramThrowable = (Throwable) paramString.get(paramThrowable);
                        return paramThrowable;
                    } catch (IllegalArgumentException paramThrowable) {
                        return null;
                    } catch (IllegalAccessException paramThrowable) {
                        for (; ; ) {
                        }
                    }
                    localClass = class$java$lang$Throwable;
                }
            }
        } catch (SecurityException paramString) {
            for (; ; ) {
                paramString = localClass;
            }
        } catch (NoSuchFieldException paramString) {
            for (; ; ) {
                paramString = localClass;
            }
        }
    }

    private static Throwable getCauseUsingMethodName(Throwable paramThrowable, String paramString) {
        Class localClass = null;
        try {
            paramString = paramThrowable.getClass().getMethod(paramString, null);
            if (paramString != null) {
                if (class$java$lang$Throwable == null) {
                    localClass = class$("java.lang.Throwable");
                    class$java$lang$Throwable = localClass;
                }
                while (localClass.isAssignableFrom(paramString.getReturnType())) {
                    try {
                        paramThrowable = (Throwable) paramString.invoke(paramThrowable, ArrayUtils.EMPTY_OBJECT_ARRAY);
                        return paramThrowable;
                    } catch (InvocationTargetException paramThrowable) {
                        return null;
                    } catch (IllegalArgumentException paramThrowable) {
                        for (; ; ) {
                        }
                    } catch (IllegalAccessException paramThrowable) {
                        for (; ; ) {
                        }
                    }
                    localClass = class$java$lang$Throwable;
                }
            }
        } catch (SecurityException paramString) {
            for (; ; ) {
                paramString = localClass;
            }
        } catch (NoSuchMethodException paramString) {
            for (; ; ) {
                paramString = localClass;
            }
        }
    }

    private static Throwable getCauseUsingWellKnownTypes(Throwable paramThrowable) {
        if ((paramThrowable instanceof Nestable)) {
            return ((Nestable) paramThrowable).getCause();
        }
        if ((paramThrowable instanceof SQLException)) {
            return ((SQLException) paramThrowable).getNextException();
        }
        if ((paramThrowable instanceof InvocationTargetException)) {
            return ((InvocationTargetException) paramThrowable).getTargetException();
        }
        return null;
    }

    public static String getFullStackTrace(Throwable paramThrowable) {
        StringWriter localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
        paramThrowable = getThrowables(paramThrowable);
        int i = 0;
        for (; ; ) {
            if (i < paramThrowable.length) {
                paramThrowable[i].printStackTrace(localPrintWriter);
                if (!isNestedThrowable(paramThrowable[i])) {
                }
            } else {
                return localStringWriter.getBuffer().toString();
            }
            i += 1;
        }
    }

    public static String getMessage(Throwable paramThrowable) {
        if (paramThrowable == null) {
            return "";
        }
        String str = ClassUtils.getShortClassName(paramThrowable, null);
        paramThrowable = paramThrowable.getMessage();
        return str + ": " + StringUtils.defaultString(paramThrowable);
    }

    public static Throwable getRootCause(Throwable paramThrowable) {
        paramThrowable = getThrowableList(paramThrowable);
        if (paramThrowable.size() < 2) {
            return null;
        }
        return (Throwable) paramThrowable.get(paramThrowable.size() - 1);
    }

    public static String getRootCauseMessage(Throwable paramThrowable) {
        Throwable localThrowable2 = getRootCause(paramThrowable);
        Throwable localThrowable1 = localThrowable2;
        if (localThrowable2 == null) {
            localThrowable1 = paramThrowable;
        }
        return getMessage(localThrowable1);
    }

    public static String[] getRootCauseStackTrace(Throwable paramThrowable) {
        if (paramThrowable == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
        int k = arrayOfThrowable.length;
        ArrayList localArrayList = new ArrayList();
        paramThrowable = getStackFrameList(arrayOfThrowable[(k - 1)]);
        int i = k;
        Throwable localThrowable1 = paramThrowable;
        int m = i - 1;
        if (m >= 0) {
            paramThrowable = localThrowable1;
            if (m != 0) {
                paramThrowable = getStackFrameList(arrayOfThrowable[(m - 1)]);
                removeCommonFrames(localThrowable1, paramThrowable);
            }
            Throwable localThrowable2 = paramThrowable;
            if (m == k - 1) {
                localArrayList.add(arrayOfThrowable[m].toString());
            }
            for (; ; ) {
                int j = 0;
                for (; ; ) {
                    i = m;
                    paramThrowable = localThrowable2;
                    if (j >= localThrowable1.size()) {
                        break;
                    }
                    localArrayList.add(localThrowable1.get(j));
                    j += 1;
                }
                localArrayList.add(" [wrapped] " + arrayOfThrowable[m].toString());
            }
        }
        return (String[]) localArrayList.toArray(new String[0]);
    }

    static List getStackFrameList(Throwable paramThrowable) {
        paramThrowable = new StringTokenizer(getStackTrace(paramThrowable), SystemUtils.LINE_SEPARATOR);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        do {
            for (; ; ) {
                if (!paramThrowable.hasMoreTokens()) {
                    return localArrayList;
                }
                String str = paramThrowable.nextToken();
                int j = str.indexOf("at");
                if ((j == -1) || (str.substring(0, j).trim().length() != 0)) {
                    break;
                }
                i = 1;
                localArrayList.add(str);
            }
        } while (i == 0);
        return localArrayList;
    }

    static String[] getStackFrames(String paramString) {
        paramString = new StringTokenizer(paramString, SystemUtils.LINE_SEPARATOR);
        ArrayList localArrayList = new ArrayList();
        while (paramString.hasMoreTokens()) {
            localArrayList.add(paramString.nextToken());
        }
        return toArray(localArrayList);
    }

    public static String[] getStackFrames(Throwable paramThrowable) {
        if (paramThrowable == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return getStackFrames(getStackTrace(paramThrowable));
    }

    public static String getStackTrace(Throwable paramThrowable) {
        StringWriter localStringWriter = new StringWriter();
        paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
        return localStringWriter.getBuffer().toString();
    }

    public static int getThrowableCount(Throwable paramThrowable) {
        return getThrowableList(paramThrowable).size();
    }

    public static List getThrowableList(Throwable paramThrowable) {
        ArrayList localArrayList = new ArrayList();
        while ((paramThrowable != null) && (!localArrayList.contains(paramThrowable))) {
            localArrayList.add(paramThrowable);
            paramThrowable = getCause(paramThrowable);
        }
        return localArrayList;
    }

    public static Throwable[] getThrowables(Throwable paramThrowable) {
        paramThrowable = getThrowableList(paramThrowable);
        return (Throwable[]) paramThrowable.toArray(new Throwable[paramThrowable.size()]);
    }

    private static int indexOf(Throwable paramThrowable, Class paramClass, int paramInt, boolean paramBoolean) {
        if ((paramThrowable == null) || (paramClass == null)) {
            paramInt = -1;
            return paramInt;
        }
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        paramThrowable = getThrowables(paramThrowable);
        if (i >= paramThrowable.length) {
            return -1;
        }
        if (paramBoolean) {
            for (; ; ) {
                if (i >= paramThrowable.length) {
                    break label106;
                }
                paramInt = i;
                if (paramClass.isAssignableFrom(paramThrowable[i].getClass())) {
                    break;
                }
                i += 1;
            }
        }
        for (; ; ) {
            if (i >= paramThrowable.length) {
                break label106;
            }
            paramInt = i;
            if (paramClass.equals(paramThrowable[i].getClass())) {
                break;
            }
            i += 1;
        }
        label106:
        return -1;
    }

    public static int indexOfThrowable(Throwable paramThrowable, Class paramClass) {
        return indexOf(paramThrowable, paramClass, 0, false);
    }

    public static int indexOfThrowable(Throwable paramThrowable, Class paramClass, int paramInt) {
        return indexOf(paramThrowable, paramClass, paramInt, false);
    }

    public static int indexOfType(Throwable paramThrowable, Class paramClass) {
        return indexOf(paramThrowable, paramClass, 0, true);
    }

    public static int indexOfType(Throwable paramThrowable, Class paramClass, int paramInt) {
        return indexOf(paramThrowable, paramClass, paramInt, true);
    }

    public static boolean isCauseMethodName(String paramString) {
        for (; ; ) {
            synchronized (CAUSE_METHOD_NAMES_LOCK) {
                if (ArrayUtils.indexOf(CAUSE_METHOD_NAMES, paramString) >= 0) {
                    bool = true;
                    return bool;
                }
            }
            boolean bool = false;
        }
    }

    /* Error */
    public static boolean isNestedThrowable(Throwable paramThrowable) {
        // Byte code:
        //   0: aload_0
        //   1: ifnonnull +5 -> 6
        //   4: iconst_0
        //   5: ireturn
        //   6: aload_0
        //   7: instanceof 192
        //   10: ifeq +5 -> 15
        //   13: iconst_1
        //   14: ireturn
        //   15: aload_0
        //   16: instanceof 197
        //   19: ifeq +5 -> 24
        //   22: iconst_1
        //   23: ireturn
        //   24: aload_0
        //   25: instanceof 175
        //   28: ifeq +5 -> 33
        //   31: iconst_1
        //   32: ireturn
        //   33: invokestatic 354	org/apache/commons/lang/exception/ExceptionUtils:isThrowableNested	()Z
        //   36: ifeq +5 -> 41
        //   39: iconst_1
        //   40: ireturn
        //   41: aload_0
        //   42: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
        //   45: astore 5
        //   47: getstatic 26	org/apache/commons/lang/exception/ExceptionUtils:CAUSE_METHOD_NAMES_LOCK	Ljava/lang/Object;
        //   50: astore 4
        //   52: aload 4
        //   54: monitorenter
        //   55: iconst_0
        //   56: istore_1
        //   57: getstatic 54	org/apache/commons/lang/exception/ExceptionUtils:CAUSE_METHOD_NAMES	[Ljava/lang/String;
        //   60: arraylength
        //   61: istore_2
        //   62: iload_1
        //   63: iload_2
        //   64: if_icmpge +71 -> 135
        //   67: aload 5
        //   69: getstatic 54	org/apache/commons/lang/exception/ExceptionUtils:CAUSE_METHOD_NAMES	[Ljava/lang/String;
        //   72: iload_1
        //   73: aaload
        //   74: aconst_null
        //   75: invokevirtual 68	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   78: astore 6
        //   80: aload 6
        //   82: ifnull +46 -> 128
        //   85: getstatic 56	org/apache/commons/lang/exception/ExceptionUtils:class$java$lang$Throwable	Ljava/lang/Class;
        //   88: ifnonnull +32 -> 120
        //   91: ldc 58
        //   93: invokestatic 62	org/apache/commons/lang/exception/ExceptionUtils:class$	(Ljava/lang/String;)Ljava/lang/Class;
        //   96: astore_0
        //   97: aload_0
        //   98: putstatic 56	org/apache/commons/lang/exception/ExceptionUtils:class$java$lang$Throwable	Ljava/lang/Class;
        //   101: aload_0
        //   102: aload 6
        //   104: invokevirtual 180	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
        //   107: invokevirtual 165	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
        //   110: istore_3
        //   111: iload_3
        //   112: ifeq +16 -> 128
        //   115: aload 4
        //   117: monitorexit
        //   118: iconst_1
        //   119: ireturn
        //   120: getstatic 56	org/apache/commons/lang/exception/ExceptionUtils:class$java$lang$Throwable	Ljava/lang/Class;
        //   123: astore_0
        //   124: goto -23 -> 101
        //   127: astore_0
        //   128: iload_1
        //   129: iconst_1
        //   130: iadd
        //   131: istore_1
        //   132: goto -70 -> 62
        //   135: aload 4
        //   137: monitorexit
        //   138: aload 5
        //   140: ldc 126
        //   142: invokevirtual 156	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   145: astore_0
        //   146: aload_0
        //   147: ifnull -143 -> 4
        //   150: iconst_1
        //   151: ireturn
        //   152: astore_0
        //   153: aload 4
        //   155: monitorexit
        //   156: aload_0
        //   157: athrow
        //   158: astore_0
        //   159: iconst_0
        //   160: ireturn
        //   161: astore_0
        //   162: iconst_0
        //   163: ireturn
        //   164: astore_0
        //   165: goto -37 -> 128
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	168	0	paramThrowable	Throwable
        //   56	76	1	i	int
        //   61	4	2	j	int
        //   110	2	3	bool	boolean
        //   50	104	4	localObject	Object
        //   45	94	5	localClass	Class
        //   78	25	6	localMethod	Method
        // Exception table:
        //   from	to	target	type
        //   67	80	127	java/lang/SecurityException
        //   85	101	127	java/lang/SecurityException
        //   101	111	127	java/lang/SecurityException
        //   120	124	127	java/lang/SecurityException
        //   57	62	152	finally
        //   67	80	152	finally
        //   85	101	152	finally
        //   101	111	152	finally
        //   115	118	152	finally
        //   120	124	152	finally
        //   135	138	152	finally
        //   153	156	152	finally
        //   138	146	158	java/lang/SecurityException
        //   138	146	161	java/lang/NoSuchFieldException
        //   67	80	164	java/lang/NoSuchMethodException
        //   85	101	164	java/lang/NoSuchMethodException
        //   101	111	164	java/lang/NoSuchMethodException
        //   120	124	164	java/lang/NoSuchMethodException
    }

    public static boolean isThrowableNested() {
        return THROWABLE_CAUSE_METHOD != null;
    }

    public static void printRootCauseStackTrace(Throwable paramThrowable) {
        printRootCauseStackTrace(paramThrowable, System.err);
    }

    public static void printRootCauseStackTrace(Throwable paramThrowable, PrintStream paramPrintStream) {
        if (paramThrowable == null) {
            return;
        }
        if (paramPrintStream == null) {
            throw new IllegalArgumentException("The PrintStream must not be null");
        }
        paramThrowable = getRootCauseStackTrace(paramThrowable);
        int i = 0;
        while (i < paramThrowable.length) {
            paramPrintStream.println(paramThrowable[i]);
            i += 1;
        }
        paramPrintStream.flush();
    }

    public static void printRootCauseStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter) {
        if (paramThrowable == null) {
            return;
        }
        if (paramPrintWriter == null) {
            throw new IllegalArgumentException("The PrintWriter must not be null");
        }
        paramThrowable = getRootCauseStackTrace(paramThrowable);
        int i = 0;
        while (i < paramThrowable.length) {
            paramPrintWriter.println(paramThrowable[i]);
            i += 1;
        }
        paramPrintWriter.flush();
    }

    public static void removeCauseMethodName(String arg0) {
        if (StringUtils.isNotEmpty( ???))
        {
            ArrayList localArrayList = getCauseMethodNameList();
            if (localArrayList.remove( ???)){
            synchronized (CAUSE_METHOD_NAMES_LOCK) {
                CAUSE_METHOD_NAMES = toArray(localArrayList);
                return;
            }
        }
        }
    }

    public static void removeCommonFrames(List paramList1, List paramList2) {
        if ((paramList1 == null) || (paramList2 == null)) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int j = paramList1.size() - 1;
        int i = paramList2.size() - 1;
        while ((j >= 0) && (i >= 0)) {
            if (((String) paramList1.get(j)).equals((String) paramList2.get(i))) {
                paramList1.remove(j);
            }
            j -= 1;
            i -= 1;
        }
    }

    /* Error */
    public static boolean setCause(Throwable paramThrowable1, Throwable paramThrowable2) {
        // Byte code:
        //   0: aload_0
        //   1: ifnonnull +14 -> 15
        //   4: new 396	org/apache/commons/lang/NullArgumentException
        //   7: dup
        //   8: ldc_w 398
        //   11: invokespecial 399	org/apache/commons/lang/NullArgumentException:<init>	(Ljava/lang/String;)V
        //   14: athrow
        //   15: iconst_1
        //   16: anewarray 4	java/lang/Object
        //   19: astore 4
        //   21: aload 4
        //   23: iconst_0
        //   24: aload_1
        //   25: aastore
        //   26: iconst_0
        //   27: istore_3
        //   28: iload_3
        //   29: istore_2
        //   30: getstatic 74	org/apache/commons/lang/exception/ExceptionUtils:THROWABLE_INITCAUSE_METHOD	Ljava/lang/reflect/Method;
        //   33: ifnull +15 -> 48
        //   36: getstatic 74	org/apache/commons/lang/exception/ExceptionUtils:THROWABLE_INITCAUSE_METHOD	Ljava/lang/reflect/Method;
        //   39: aload_0
        //   40: aload 4
        //   42: invokevirtual 190	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   45: pop
        //   46: iconst_1
        //   47: istore_2
        //   48: aload_0
        //   49: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
        //   52: astore 5
        //   54: getstatic 56	org/apache/commons/lang/exception/ExceptionUtils:class$java$lang$Throwable	Ljava/lang/Class;
        //   57: ifnonnull +38 -> 95
        //   60: ldc 58
        //   62: invokestatic 62	org/apache/commons/lang/exception/ExceptionUtils:class$	(Ljava/lang/String;)Ljava/lang/Class;
        //   65: astore_1
        //   66: aload_1
        //   67: putstatic 56	org/apache/commons/lang/exception/ExceptionUtils:class$java$lang$Throwable	Ljava/lang/Class;
        //   70: aload 5
        //   72: ldc_w 400
        //   75: iconst_1
        //   76: anewarray 64	java/lang/Class
        //   79: dup
        //   80: iconst_0
        //   81: aload_1
        //   82: aastore
        //   83: invokevirtual 68	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   86: aload_0
        //   87: aload 4
        //   89: invokevirtual 190	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   92: pop
        //   93: iconst_1
        //   94: ireturn
        //   95: getstatic 56	org/apache/commons/lang/exception/ExceptionUtils:class$java$lang$Throwable	Ljava/lang/Class;
        //   98: astore_1
        //   99: goto -29 -> 70
        //   102: astore_0
        //   103: iload_2
        //   104: ireturn
        //   105: astore_0
        //   106: iload_2
        //   107: ireturn
        //   108: astore_0
        //   109: iload_2
        //   110: ireturn
        //   111: astore_1
        //   112: iload_3
        //   113: istore_2
        //   114: goto -66 -> 48
        //   117: astore_1
        //   118: iload_3
        //   119: istore_2
        //   120: goto -72 -> 48
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	123	0	paramThrowable1	Throwable
        //   0	123	1	paramThrowable2	Throwable
        //   29	91	2	bool1	boolean
        //   27	92	3	bool2	boolean
        //   19	69	4	arrayOfObject	Object[]
        //   52	19	5	localClass	Class
        // Exception table:
        //   from	to	target	type
        //   48	70	102	java/lang/reflect/InvocationTargetException
        //   70	93	102	java/lang/reflect/InvocationTargetException
        //   95	99	102	java/lang/reflect/InvocationTargetException
        //   48	70	105	java/lang/IllegalAccessException
        //   70	93	105	java/lang/IllegalAccessException
        //   95	99	105	java/lang/IllegalAccessException
        //   48	70	108	java/lang/NoSuchMethodException
        //   70	93	108	java/lang/NoSuchMethodException
        //   95	99	108	java/lang/NoSuchMethodException
        //   36	46	111	java/lang/reflect/InvocationTargetException
        //   36	46	117	java/lang/IllegalAccessException
    }

    private static String[] toArray(List paramList) {
        return (String[]) paramList.toArray(new String[paramList.size()]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/exception/ExceptionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */