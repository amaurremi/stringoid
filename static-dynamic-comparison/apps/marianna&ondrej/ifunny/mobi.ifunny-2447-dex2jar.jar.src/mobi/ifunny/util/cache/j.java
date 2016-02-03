package mobi.ifunny.util.cache;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.util.l;

class j
        implements i<Boolean> {
    private final String a;

    public j(String paramString) {
        this.a = paramString;
    }

    public Boolean a(byte[] paramArrayOfByte) {
        return Boolean.valueOf(l.a(IFunnyApplication.a, paramArrayOfByte, this.a));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */