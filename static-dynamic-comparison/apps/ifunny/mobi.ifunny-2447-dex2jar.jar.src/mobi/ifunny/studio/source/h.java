package mobi.ifunny.studio.source;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashSet;

import mobi.ifunny.gallery.a.i;
import mobi.ifunny.k.r;
import mobi.ifunny.rest.content.WebImage;
import mobi.ifunny.video.a;

public class h
        extends i<a, WebImage, mobi.ifunny.k.f<a, WebImage>> {
    public h(f paramf, Context paramContext) {
        super(paramContext);
    }

    protected void a(ImageView paramImageView, mobi.ifunny.k.f<a, WebImage> paramf, a parama, boolean paramBoolean) {
        super.a(paramImageView, paramf, parama, paramBoolean);
        if (parama != null) {
            parama.d();
            f.a(this.a).remove(parama);
        }
    }

    protected void a(mobi.ifunny.k.f<a, WebImage> paramf) {
        super.b(paramf);
        if ((paramf.c().d != null) && ((paramf.c().d instanceof Integer))) {
        }
        for (int i = ((Integer) paramf.c().d).intValue(); ; i = 0) {
            if (i != 0) {
                Toast.makeText(paramf.a().getContext(), i, 1).show();
            }
            return;
        }
    }

    protected void a(mobi.ifunny.k.f<a, WebImage> paramf, a parama) {
        super.b(paramf, parama);
        parama.start();
        f.a(this.a).add(parama);
    }

    public void b(mobi.ifunny.k.f<a, WebImage> paramf, a parama) {
        super.a(paramf, parama);
        parama.d();
        f.a(this.a).remove(parama);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/source/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */