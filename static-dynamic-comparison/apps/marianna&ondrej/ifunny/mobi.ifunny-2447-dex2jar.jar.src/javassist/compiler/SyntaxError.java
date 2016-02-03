package javassist.compiler;

public class SyntaxError
        extends CompileError {
    public SyntaxError(Lex paramLex) {
        super("syntax error near \"" + paramLex.getTextAround() + "\"", paramLex);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/SyntaxError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */