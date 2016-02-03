package javassist.compiler;

import java.util.HashMap;

import javassist.compiler.ast.Declarator;

public final class SymbolTable
        extends HashMap {
    private SymbolTable parent;

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable paramSymbolTable) {
        this.parent = paramSymbolTable;
    }

    public void append(String paramString, Declarator paramDeclarator) {
        put(paramString, paramDeclarator);
    }

    public SymbolTable getParent() {
        return this.parent;
    }

    public Declarator lookup(String paramString) {
        Declarator localDeclarator2 = (Declarator) get(paramString);
        Declarator localDeclarator1 = localDeclarator2;
        if (localDeclarator2 == null) {
            localDeclarator1 = localDeclarator2;
            if (this.parent != null) {
                localDeclarator1 = this.parent.lookup(paramString);
            }
        }
        return localDeclarator1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/SymbolTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */