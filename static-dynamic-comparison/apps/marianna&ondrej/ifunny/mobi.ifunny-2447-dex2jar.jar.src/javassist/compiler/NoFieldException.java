package javassist.compiler;

import javassist.compiler.ast.ASTree;

public class NoFieldException
        extends CompileError {
    private ASTree expr;
    private String fieldName;

    public NoFieldException(String paramString, ASTree paramASTree) {
        super("no such field: " + paramString);
        this.fieldName = paramString;
        this.expr = paramASTree;
    }

    public ASTree getExpr() {
        return this.expr;
    }

    public String getField() {
        return this.fieldName;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/NoFieldException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */