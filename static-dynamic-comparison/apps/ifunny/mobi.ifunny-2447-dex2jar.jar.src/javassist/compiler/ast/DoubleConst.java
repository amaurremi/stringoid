package javassist.compiler.ast;

public class DoubleConst
        extends ASTree {
    protected int type;
    protected double value;

    public DoubleConst(double paramDouble, int paramInt) {
        this.value = paramDouble;
        this.type = paramInt;
    }

    private static DoubleConst compute(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2) {
        switch (paramInt1) {
            case 38:
            case 39:
            case 40:
            case 41:
            case 44:
            case 46:
            default:
                return null;
            case 43:
                paramDouble1 += paramDouble2;
        }
        for (; ; ) {
            return new DoubleConst(paramDouble1, paramInt2);
            paramDouble1 -= paramDouble2;
            continue;
            paramDouble1 *= paramDouble2;
            continue;
            paramDouble1 /= paramDouble2;
            continue;
            paramDouble1 %= paramDouble2;
        }
    }

    private DoubleConst compute0(int paramInt, DoubleConst paramDoubleConst) {
        int j = 405;
        int i = j;
        if (this.type != 405) {
            if (paramDoubleConst.type != 405) {
                break label45;
            }
        }
        label45:
        for (i = j; ; i = 404) {
            return compute(paramInt, this.value, paramDoubleConst.value, i);
        }
    }

    private DoubleConst compute0(int paramInt, IntConst paramIntConst) {
        return compute(paramInt, this.value, paramIntConst.value, this.type);
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atDoubleConst(this);
    }

    public ASTree compute(int paramInt, ASTree paramASTree) {
        if ((paramASTree instanceof IntConst)) {
            return compute0(paramInt, (IntConst) paramASTree);
        }
        if ((paramASTree instanceof DoubleConst)) {
            return compute0(paramInt, (DoubleConst) paramASTree);
        }
        return null;
    }

    public double get() {
        return this.value;
    }

    public int getType() {
        return this.type;
    }

    public void set(double paramDouble) {
        this.value = paramDouble;
    }

    public String toString() {
        return Double.toString(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/DoubleConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */