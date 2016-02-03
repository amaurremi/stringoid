package javassist.bytecode;

final class LongVector {
    static final int ABITS = 7;
    static final int ASIZE = 128;
    static final int VSIZE = 8;
    private int elements;
    private ConstInfo[][] objects;

    public LongVector() {
        this.objects = new ConstInfo[8][];
        this.elements = 0;
    }

    public LongVector(int paramInt) {
        this.objects = new ConstInfo[(paramInt >> 7 & 0xFFFFFFF8) + 8][];
        this.elements = 0;
    }

    public void addElement(ConstInfo paramConstInfo) {
        int i = this.elements >> 7;
        int j = this.elements;
        int k = this.objects.length;
        if (i >= k) {
            ConstInfo[][] arrayOfConstInfo = new ConstInfo[k + 8][];
            System.arraycopy(this.objects, 0, arrayOfConstInfo, 0, k);
            this.objects = arrayOfConstInfo;
        }
        if (this.objects[i] == null) {
            this.objects[i] = new ConstInfo[''];
        }
        this.objects[i][(j & 0x7F)] = paramConstInfo;
        this.elements += 1;
    }

    public int capacity() {
        return this.objects.length * 128;
    }

    public ConstInfo elementAt(int paramInt) {
        if ((paramInt < 0) || (this.elements <= paramInt)) {
            return null;
        }
        return this.objects[(paramInt >> 7)][(paramInt & 0x7F)];
    }

    public int size() {
        return this.elements;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/LongVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */