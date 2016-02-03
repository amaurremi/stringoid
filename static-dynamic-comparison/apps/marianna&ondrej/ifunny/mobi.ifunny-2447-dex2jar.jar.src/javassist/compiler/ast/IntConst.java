package javassist.compiler.ast;

public class IntConst
        extends ASTree {
    protected int type;
    protected long value;

    public IntConst(long paramLong, int paramInt) {
        this.value = paramLong;
        this.type = paramInt;
    }

    private DoubleConst compute0(int paramInt, DoubleConst paramDoubleConst) {
        double d1 = this.value;
        double d2 = paramDoubleConst.value;
        switch (paramInt) {
            case 38:
            case 39:
            case 40:
            case 41:
            case 44:
            case 46:
            default:
                return null;
            case 43:
                d1 += d2;
        }
        for (; ; ) {
            return new DoubleConst(d1, paramDoubleConst.type);
            d1 -= d2;
            continue;
            d1 *= d2;
            continue;
            d1 /= d2;
            continue;
            d1 %= d2;
        }
    }

    private IntConst compute0(int paramInt, IntConst paramIntConst) {
        int i = 401;
        int j = this.type;
        int k = paramIntConst.type;
        if ((j == 403) || (k == 403)) {
        }
        long l1;
        long l2;
        for (i = 403; ; i = 402) {
            do {
                l1 = this.value;
                l2 = paramIntConst.value;
                switch (paramInt) {
                    default:
                        return null;
                }
            } while ((j == 401) && (k == 401));
        }
        paramInt = i;
        l1 += l2;
        for (; ; ) {
            return new IntConst(l1, paramInt);
            paramInt = i;
            l1 -= l2;
            continue;
            paramInt = i;
            l1 *= l2;
            continue;
            l1 /= l2;
            paramInt = i;
            continue;
            paramInt = i;
            l1 %= l2;
            continue;
            paramInt = i;
            l1 |= l2;
            continue;
            paramInt = i;
            l1 ^= l2;
            continue;
            paramInt = i;
            l1 &= l2;
            continue;
            l1 = this.value << (int) l2;
            paramInt = j;
            continue;
            l1 = this.value >> (int) l2;
            paramInt = j;
            continue;
            l1 = this.value >>> (int) l2;
            paramInt = j;
        }
    }

    public void accept(Visitor paramVisitor) {
        paramVisitor.atIntConst(this);
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

    public long get() {
        return this.value;
    }

    public int getType() {
        return this.type;
    }

    public void set(long paramLong) {
        this.value = paramLong;
    }

    public String toString() {
        return Long.toString(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/ast/IntConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */