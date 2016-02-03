package javassist.expr;

final class ExprEditor$NewOp {
    NewOp next;
    int pos;
    String type;

    ExprEditor$NewOp(NewOp paramNewOp, int paramInt, String paramString) {
        this.next = paramNewOp;
        this.pos = paramInt;
        this.type = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/ExprEditor$NewOp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */