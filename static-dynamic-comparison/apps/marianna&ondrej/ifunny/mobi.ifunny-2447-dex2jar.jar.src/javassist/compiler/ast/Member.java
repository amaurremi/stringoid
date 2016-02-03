package javassist.compiler.ast;

import javassist.CtField;

public class Member
        extends Symbol {
    private CtField field = null;

    public Member(String paramString) {
        super(paramString);
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atMember(this);
    }

    public CtField getField() {
        return this.field;
    }

    public void setField(CtField paramCtField) {
        this.field = paramCtField;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/Member.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */