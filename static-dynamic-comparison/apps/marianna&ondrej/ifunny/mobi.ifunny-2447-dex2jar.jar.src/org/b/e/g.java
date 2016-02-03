package org.b.e;

import java.util.ListIterator;

import org.b.c.e;

class g
        extends a {
    private static g a = new g(new ae[0], true);
    private ae[] b;

    g(ae[] paramArrayOfae, boolean paramBoolean) {
        if (paramBoolean) {
            this.b = paramArrayOfae;
            return;
        }
        this.b = new ae[paramArrayOfae.length];
        System.arraycopy(paramArrayOfae, 0, this.b, 0, paramArrayOfae.length);
    }

    private boolean a(g paramg) {
        if (this.b.length != paramg.b.length) {
            return false;
        }
        int i = 0;
        for (; ; ) {
            if (i >= this.b.length) {
                break label51;
            }
            if (!this.b[i].equals(paramg.b[i])) {
                break;
            }
            i += 1;
        }
        label51:
        return true;
    }

    public static f o() {
        return a;
    }

    public StringBuilder a(StringBuilder paramStringBuilder) {
        if (this.b.length == 0) {
            return paramStringBuilder.append("[]");
        }
        paramStringBuilder.append("[");
        paramStringBuilder.append(this.b[0]);
        int i = 1;
        while (i < this.b.length) {
            paramStringBuilder.append(",");
            this.b[i].a(paramStringBuilder);
            i += 1;
        }
        paramStringBuilder.append("]");
        return paramStringBuilder;
    }

    public ae a(int paramInt) {
        if ((paramInt < 0) || (this.b.length <= paramInt)) {
            throw new IndexOutOfBoundsException();
        }
        return this.b[paramInt];
    }

    public void a(e parame) {
        parame.c(this.b.length);
        int i = 0;
        while (i < this.b.length) {
            this.b[i].a(parame);
            i += 1;
        }
        parame.a();
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        label120:
        do {
            do {
                do {
                    return bool1;
                    bool1 = bool2;
                } while (!(paramObject instanceof ae));
                paramObject = (ae) paramObject;
                bool1 = bool2;
            } while (!((ae) paramObject).a());
            if (paramObject.getClass() == g.class) {
                return a((g) paramObject);
            }
            paramObject = ((ae) paramObject).b().listIterator();
            int i = 0;
            for (; ; ) {
                if (i >= this.b.length) {
                    break label120;
                }
                bool1 = bool2;
                if (!((ListIterator) paramObject).hasNext()) {
                    break;
                }
                bool1 = bool2;
                if (!this.b[i].equals(((ListIterator) paramObject).next())) {
                    break;
                }
                i += 1;
            }
            bool1 = bool2;
        } while (((ListIterator) paramObject).hasNext());
        return true;
    }

    public int hashCode() {
        int j = 1;
        int i = 0;
        while (i < this.b.length) {
            j = j * 31 + this.b[i].hashCode();
            i += 1;
        }
        return j;
    }

    public int indexOf(Object paramObject) {
        int j;
        if (paramObject == null) {
            j = -1;
            return j;
        }
        int i = 0;
        for (; ; ) {
            if (i >= this.b.length) {
                break label41;
            }
            j = i;
            if (this.b[i].equals(paramObject)) {
                break;
            }
            i += 1;
        }
        label41:
        return -1;
    }

    public boolean isEmpty() {
        return this.b.length == 0;
    }

    public int lastIndexOf(Object paramObject) {
        if (paramObject == null) {
        }
        for (; ; ) {
            return -1;
            int i = this.b.length - 1;
            while (i >= 0) {
                if (this.b[i].equals(paramObject)) {
                    return i;
                }
                i -= 1;
            }
        }
    }

    public ae[] n() {
        return this.b;
    }

    public int size() {
        return this.b.length;
    }

    public String toString() {
        return a(new StringBuilder()).toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */