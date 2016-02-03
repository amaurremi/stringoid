package mobi.ifunny.studio.source;

import mobi.ifunny.k.r;
import mobi.ifunny.k.t;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;

class i
        implements t<mobi.ifunny.video.a> {
    public mobi.ifunny.video.a a(mobi.ifunny.util.a.a parama, r<mobi.ifunny.video.a> paramr) {
        parama = mobi.ifunny.util.cache.a.a(parama.c(), f.c, new j(this, paramr)).b;
        if (parama == null) {
            return null;
        }
        try {
            parama = new mobi.ifunny.video.a(parama);
            return parama;
        } catch (UnsatisfiedLinkError parama) {
            paramr.d = Integer.valueOf(2131689610);
            return null;
        } catch (IllegalStateException parama) {
            for (; ; ) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/source/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */