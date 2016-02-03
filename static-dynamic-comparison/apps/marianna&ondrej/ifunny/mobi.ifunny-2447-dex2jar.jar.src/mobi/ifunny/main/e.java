package mobi.ifunny.main;

import mobi.ifunny.h;
import mobi.ifunny.l.b;
import mobi.ifunny.util.af;

class e
        extends b<IFunnyMenuActivity, Void, Void, Void> {
    private int a;

    private e(IFunnyMenuActivity paramIFunnyMenuActivity, String paramString, int paramInt) {
        super(paramIFunnyMenuActivity, paramString);
        this.a = paramInt;
    }

    protected Void a(Void... paramVarArgs) {
        h.a().b("pref.push.featured_count", this.a);
        af.a(mobi.ifunny.e.a, this.a);
        if (this.a == 0) {
            af.a(mobi.ifunny.e.a);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */