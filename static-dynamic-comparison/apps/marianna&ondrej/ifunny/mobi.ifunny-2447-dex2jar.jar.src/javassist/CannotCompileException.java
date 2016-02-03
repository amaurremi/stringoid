package javassist;

import javassist.compiler.CompileError;

public class CannotCompileException
        extends Exception {
    private String message;
    private Throwable myCause;

    public CannotCompileException(ClassFormatError paramClassFormatError, String paramString) {
        this("invalid class format: " + paramString, paramClassFormatError);
    }

    public CannotCompileException(ClassNotFoundException paramClassNotFoundException, String paramString) {
        this("cannot find " + paramString, paramClassNotFoundException);
    }

    public CannotCompileException(String paramString) {
        super(paramString);
        this.message = paramString;
        initCause(null);
    }

    public CannotCompileException(String paramString, Throwable paramThrowable) {
        this(paramString);
        initCause(paramThrowable);
    }

    public CannotCompileException(Throwable paramThrowable) {
        super("by " + paramThrowable.toString());
        this.message = null;
        initCause(paramThrowable);
    }

    public CannotCompileException(NotFoundException paramNotFoundException) {
        this("cannot find " + paramNotFoundException.getMessage(), paramNotFoundException);
    }

    public CannotCompileException(CompileError paramCompileError) {
        this("[source error] " + paramCompileError.getMessage(), paramCompileError);
    }

    public Throwable getCause() {
        if (this.myCause == this) {
            return null;
        }
        return this.myCause;
    }

    public String getReason() {
        if (this.message != null) {
            return this.message;
        }
        return toString();
    }

    public Throwable initCause(Throwable paramThrowable) {
        try {
            this.myCause = paramThrowable;
            return this;
        } finally {
            paramThrowable =finally;
            throw paramThrowable;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CannotCompileException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */