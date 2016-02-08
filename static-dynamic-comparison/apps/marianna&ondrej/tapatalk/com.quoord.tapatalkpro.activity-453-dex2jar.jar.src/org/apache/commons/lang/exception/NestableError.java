package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class NestableError
        extends Error
        implements Nestable {
    private static final long serialVersionUID = 1L;
    private Throwable cause = null;
    protected NestableDelegate delegate = new NestableDelegate(this);

    public NestableError() {
    }

    public NestableError(String paramString) {
        super(paramString);
    }

    public NestableError(String paramString, Throwable paramThrowable) {
        super(paramString);
        this.cause = paramThrowable;
    }

    public NestableError(Throwable paramThrowable) {
        this.cause = paramThrowable;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        }
        if (this.cause != null) {
            return this.cause.toString();
        }
        return null;
    }

    public String getMessage(int paramInt) {
        if (paramInt == 0) {
            return super.getMessage();
        }
        return this.delegate.getMessage(paramInt);
    }

    public String[] getMessages() {
        return this.delegate.getMessages();
    }

    public Throwable getThrowable(int paramInt) {
        return this.delegate.getThrowable(paramInt);
    }

    public int getThrowableCount() {
        return this.delegate.getThrowableCount();
    }

    public Throwable[] getThrowables() {
        return this.delegate.getThrowables();
    }

    public int indexOfThrowable(Class paramClass) {
        return this.delegate.indexOfThrowable(paramClass, 0);
    }

    public int indexOfThrowable(Class paramClass, int paramInt) {
        return this.delegate.indexOfThrowable(paramClass, paramInt);
    }

    public final void printPartialStackTrace(PrintWriter paramPrintWriter) {
        super.printStackTrace(paramPrintWriter);
    }

    public void printStackTrace() {
        this.delegate.printStackTrace();
    }

    public void printStackTrace(PrintStream paramPrintStream) {
        this.delegate.printStackTrace(paramPrintStream);
    }

    public void printStackTrace(PrintWriter paramPrintWriter) {
        this.delegate.printStackTrace(paramPrintWriter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/exception/NestableError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */