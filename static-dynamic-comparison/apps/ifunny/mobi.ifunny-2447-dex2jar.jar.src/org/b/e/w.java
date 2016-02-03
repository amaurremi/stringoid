package org.b.e;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.b.c.e;

class w
        extends c {
    private static w a = new w(new ae[0], true);
    private ae[] b;

    w(ae[] paramArrayOfae, boolean paramBoolean) {
        if (paramArrayOfae.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        if (paramBoolean) {
            this.b = paramArrayOfae;
            return;
        }
        this.b = new ae[paramArrayOfae.length];
        System.arraycopy(paramArrayOfae, 0, this.b, 0, paramArrayOfae.length);
    }

    public static s o() {
        return a;
    }

    public StringBuilder a(StringBuilder paramStringBuilder) {
        if (this.b.length == 0) {
            return paramStringBuilder.append("{}");
        }
        paramStringBuilder.append("{");
        paramStringBuilder.append(this.b[0]);
        paramStringBuilder.append(":");
        paramStringBuilder.append(this.b[1]);
        int i = 2;
        while (i < this.b.length) {
            paramStringBuilder.append(",");
            this.b[i].a(paramStringBuilder);
            paramStringBuilder.append(":");
            this.b[(i + 1)].a(paramStringBuilder);
            i += 2;
        }
        paramStringBuilder.append("}");
        return paramStringBuilder;
    }

    public ae a(Object paramObject) {
        if (paramObject == null) {
        }
        for (; ; ) {
            return null;
            int i = this.b.length - 2;
            while (i >= 0) {
                if (this.b[i].equals(paramObject)) {
                    return this.b[(i + 1)];
                }
                i -= 2;
            }
        }
    }

    public void a(e parame) {
        parame.d(this.b.length / 2);
        int i = 0;
        while (i < this.b.length) {
            this.b[i].a(parame);
            i += 1;
        }
        parame.b();
    }

    public Set<Map.Entry<ae, ae>> entrySet() {
        return new x(this.b);
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        for (; ; ) {
            return true;
            if (!(paramObject instanceof ae)) {
                return false;
            }
            paramObject = (ae) paramObject;
            if (!((ae) paramObject).g()) {
                return false;
            }
            paramObject = ((ae) paramObject).l();
            if (((Map) paramObject).size() != this.b.length / 2) {
                return false;
            }
            int i = 0;
            try {
                while (i < this.b.length) {
                    ae localae = this.b[i];
                    boolean bool = this.b[(i + 1)].equals(((Map) paramObject).get(localae));
                    if (!bool) {
                        return false;
                    }
                    i += 2;
                }
                return false;
            } catch (ClassCastException paramObject) {
                return false;
            } catch (NullPointerException paramObject) {
            }
        }
    }

    public int hashCode() {
        int i = 0;
        int j = 0;
        while (i < this.b.length) {
            j += (this.b[i].hashCode() ^ this.b[(i + 1)].hashCode());
            i += 2;
        }
        return j;
    }

    public Set<ae> keySet() {
        return new z(this.b);
    }

    public ae[] n() {
        return this.b;
    }

    public String toString() {
        return a(new StringBuilder()).toString();
    }

    public Collection<ae> values() {
        return new aa(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */