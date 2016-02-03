package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NestableDelegate
        implements Serializable {
    private static final transient String MUST_BE_THROWABLE = "The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable";
    static Class class$org$apache$commons$lang$exception$Nestable;
    public static boolean matchSubclasses = true;
    private static final long serialVersionUID = 1L;
    public static boolean topDown = true;
    public static boolean trimStackFrames = true;
    private Throwable nestable = null;

    public NestableDelegate(Nestable paramNestable) {
        if ((paramNestable instanceof Throwable)) {
            this.nestable = ((Throwable) paramNestable);
            return;
        }
        throw new IllegalArgumentException("The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable");
    }

    static Class class$(String paramString) {
        try {
            paramString = Class.forName(paramString);
            return paramString;
        } catch (ClassNotFoundException paramString) {
            throw new NoClassDefFoundError(paramString.getMessage());
        }
    }

    public String getMessage(int paramInt) {
        Throwable localThrowable = getThrowable(paramInt);
        Class localClass;
        if (class$org$apache$commons$lang$exception$Nestable == null) {
            localClass = class$("org.apache.commons.lang.exception.Nestable");
            class$org$apache$commons$lang$exception$Nestable = localClass;
        }
        while (localClass.isInstance(localThrowable)) {
            return ((Nestable) localThrowable).getMessage(0);
            localClass = class$org$apache$commons$lang$exception$Nestable;
        }
        return localThrowable.getMessage();
    }

    public String getMessage(String paramString) {
        Object localObject = ExceptionUtils.getCause(this.nestable);
        String str;
        if (localObject == null) {
            str = null;
            if ((localObject != null) && (str != null)) {
                break label34;
            }
            localObject = paramString;
        }
        label34:
        do {
            return (String) localObject;
            str = ((Throwable) localObject).getMessage();
            break;
            localObject = str;
        } while (paramString == null);
        return paramString + ": " + str;
    }

    public String[] getMessages() {
        Throwable[] arrayOfThrowable = getThrowables();
        String[] arrayOfString = new String[arrayOfThrowable.length];
        int i = 0;
        if (i < arrayOfThrowable.length) {
            if (class$org$apache$commons$lang$exception$Nestable == null) {
                localObject = class$("org.apache.commons.lang.exception.Nestable");
                class$org$apache$commons$lang$exception$Nestable = (Class) localObject;
                label36:
                if (!((Class) localObject).isInstance(arrayOfThrowable[i])) {
                    break label78;
                }
            }
            label78:
            for (Object localObject = ((Nestable) arrayOfThrowable[i]).getMessage(0); ; localObject = arrayOfThrowable[i].getMessage()) {
                arrayOfString[i] = localObject;
                i += 1;
                break;
                localObject = class$org$apache$commons$lang$exception$Nestable;
                break label36;
            }
        }
        return arrayOfString;
    }

    protected String[] getStackFrames(Throwable paramThrowable) {
        StringWriter localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
        if ((paramThrowable instanceof Nestable)) {
            ((Nestable) paramThrowable).printPartialStackTrace(localPrintWriter);
        }
        for (; ; ) {
            return ExceptionUtils.getStackFrames(localStringWriter.getBuffer().toString());
            paramThrowable.printStackTrace(localPrintWriter);
        }
    }

    public Throwable getThrowable(int paramInt) {
        if (paramInt == 0) {
            return this.nestable;
        }
        return getThrowables()[paramInt];
    }

    public int getThrowableCount() {
        return ExceptionUtils.getThrowableCount(this.nestable);
    }

    public Throwable[] getThrowables() {
        return ExceptionUtils.getThrowables(this.nestable);
    }

    public int indexOfThrowable(Class paramClass, int paramInt) {
        if (paramClass == null) {
            paramInt = -1;
            return paramInt;
        }
        if (paramInt < 0) {
            throw new IndexOutOfBoundsException("The start index was out of bounds: " + paramInt);
        }
        Throwable[] arrayOfThrowable = ExceptionUtils.getThrowables(this.nestable);
        if (paramInt >= arrayOfThrowable.length) {
            throw new IndexOutOfBoundsException("The start index was out of bounds: " + paramInt + " >= " + arrayOfThrowable.length);
        }
        if (matchSubclasses) {
            i = paramInt;
            for (; ; ) {
                if (i >= arrayOfThrowable.length) {
                    break label163;
                }
                paramInt = i;
                if (paramClass.isAssignableFrom(arrayOfThrowable[i].getClass())) {
                    break;
                }
                i += 1;
            }
        }
        int i = paramInt;
        for (; ; ) {
            if (i >= arrayOfThrowable.length) {
                break label163;
            }
            paramInt = i;
            if (paramClass.equals(arrayOfThrowable[i].getClass())) {
                break;
            }
            i += 1;
        }
        label163:
        return -1;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream paramPrintStream) {
        try {
            PrintWriter localPrintWriter = new PrintWriter(paramPrintStream, false);
            printStackTrace(localPrintWriter);
            localPrintWriter.flush();
            return;
        } finally {
        }
    }

    public void printStackTrace(PrintWriter paramPrintWriter) {
        Object localObject1 = this.nestable;
        if (ExceptionUtils.isThrowableNested()) {
            if ((localObject1 instanceof Nestable)) {
                ((Nestable) localObject1).printPartialStackTrace(paramPrintWriter);
                return;
            }
            ((Throwable) localObject1).printStackTrace(paramPrintWriter);
            return;
        }
        Object localObject3 = new ArrayList();
        while (localObject1 != null) {
            ((List) localObject3).add(getStackFrames((Throwable) localObject1));
            localObject1 = ExceptionUtils.getCause((Throwable) localObject1);
        }
        localObject1 = "Caused by: ";
        if (!topDown) {
            localObject1 = "Rethrown as: ";
            Collections.reverse((List) localObject3);
        }
        if (trimStackFrames) {
            trimStackFrames((List) localObject3);
        }
        try {
            localObject3 = ((List) localObject3).iterator();
            while (((Iterator) localObject3).hasNext()) {
                String[] arrayOfString = (String[]) ((Iterator) localObject3).next();
                int i = 0;
                int j = arrayOfString.length;
                while (i < j) {
                    paramPrintWriter.println(arrayOfString[i]);
                    i += 1;
                }
                if (((Iterator) localObject3).hasNext()) {
                    paramPrintWriter.print((String) localObject1);
                }
            }
        } finally {
        }
    }

    protected void trimStackFrames(List paramList) {
        int i = paramList.size() - 1;
        while (i > 0) {
            String[] arrayOfString1 = (String[]) paramList.get(i);
            String[] arrayOfString2 = (String[]) paramList.get(i - 1);
            ArrayList localArrayList = new ArrayList(Arrays.asList(arrayOfString1));
            ExceptionUtils.removeCommonFrames(localArrayList, new ArrayList(Arrays.asList(arrayOfString2)));
            int j = arrayOfString1.length - localArrayList.size();
            if (j > 0) {
                localArrayList.add("\t... " + j + " more");
                paramList.set(i, localArrayList.toArray(new String[localArrayList.size()]));
            }
            i -= 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/exception/NestableDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */