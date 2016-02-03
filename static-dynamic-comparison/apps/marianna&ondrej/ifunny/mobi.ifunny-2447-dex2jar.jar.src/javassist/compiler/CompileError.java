package javassist.compiler;

import javassist.CannotCompileException;
import javassist.NotFoundException;

public class CompileError
        extends Exception {
    private Lex lex;
    private String reason;

    public CompileError(String paramString) {
        this.reason = paramString;
        this.lex = null;
    }

    public CompileError(String paramString, Lex paramLex) {
        this.reason = paramString;
        this.lex = paramLex;
    }

    public CompileError(CannotCompileException paramCannotCompileException) {
        this(paramCannotCompileException.getReason());
    }

    public CompileError(NotFoundException paramNotFoundException) {
        this("cannot find " + paramNotFoundException.getMessage());
    }

    public Lex getLex() {
        return this.lex;
    }

    public String getMessage() {
        return this.reason;
    }

    public String toString() {
        return "compile error: " + this.reason;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/CompileError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */