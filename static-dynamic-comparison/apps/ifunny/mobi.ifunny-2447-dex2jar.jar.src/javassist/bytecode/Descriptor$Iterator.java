package javassist.bytecode;

public class Descriptor$Iterator {
    private int curPos;
    private String desc;
    private int index;
    private boolean param;

    public Descriptor$Iterator(String paramString) {
        this.desc = paramString;
        this.curPos = 0;
        this.index = 0;
        this.param = false;
    }

    public char currentChar() {
        return this.desc.charAt(this.curPos);
    }

    public boolean hasNext() {
        return this.index < this.desc.length();
    }

    public boolean is2byte() {
        int i = currentChar();
        return (i == 68) || (i == 74);
    }

    public boolean isParameter() {
        return this.param;
    }

    public int next() {
        int k = this.index;
        int m = this.desc.charAt(k);
        int j = m;
        int i = k;
        String str;
        if (m == 40) {
            this.index += 1;
            str = this.desc;
            i = k + 1;
            j = str.charAt(i);
            this.param = true;
        }
        k = j;
        m = i;
        if (j == 41) {
            this.index += 1;
            str = this.desc;
            m = i + 1;
            k = str.charAt(m);
            this.param = false;
        }
        while (k == 91) {
            str = this.desc;
            m += 1;
            k = str.charAt(m);
        }
        if (k == 76) {
            j = this.desc.indexOf(';', m) + 1;
            i = j;
            if (j <= 0) {
                throw new IndexOutOfBoundsException("bad descriptor");
            }
        } else {
            i = m + 1;
        }
        this.curPos = this.index;
        this.index = i;
        return this.curPos;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/Descriptor$Iterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */