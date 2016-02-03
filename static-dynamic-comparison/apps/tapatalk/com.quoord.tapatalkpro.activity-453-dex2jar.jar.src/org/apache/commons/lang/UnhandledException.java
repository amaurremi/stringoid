package org.apache.commons.lang;

import org.apache.commons.lang.exception.NestableRuntimeException;

public class UnhandledException
        extends NestableRuntimeException {
    private static final long serialVersionUID = 1832101364842773720L;

    public UnhandledException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public UnhandledException(Throwable paramThrowable) {
        super(paramThrowable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/UnhandledException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */