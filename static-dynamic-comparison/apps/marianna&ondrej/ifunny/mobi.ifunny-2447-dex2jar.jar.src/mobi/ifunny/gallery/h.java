package mobi.ifunny.gallery;

public class h<D> {
    public D a;
    public int b;
    public Object c;

    public h(D paramD) {
        this(paramD, 0, null);
    }

    public h(D paramD, int paramInt) {
        this(paramD, paramInt, null);
    }

    public h(D paramD, int paramInt, Object paramObject) {
        this.a = paramD;
        this.b = paramInt;
        this.c = paramObject;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (h) paramObject;
            if (this.b != ((h) paramObject).b) {
                return false;
            }
        } while (this.a.equals(((h) paramObject).a));
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() * 31 + this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */