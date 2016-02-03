package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract interface Nestable {
    public abstract Throwable getCause();

    public abstract String getMessage();

    public abstract String getMessage(int paramInt);

    public abstract String[] getMessages();

    public abstract Throwable getThrowable(int paramInt);

    public abstract int getThrowableCount();

    public abstract Throwable[] getThrowables();

    public abstract int indexOfThrowable(Class paramClass);

    public abstract int indexOfThrowable(Class paramClass, int paramInt);

    public abstract void printPartialStackTrace(PrintWriter paramPrintWriter);

    public abstract void printStackTrace(PrintStream paramPrintStream);

    public abstract void printStackTrace(PrintWriter paramPrintWriter);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/exception/Nestable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */