package mobi.ifunny.studio.crop.free;

import android.net.Uri;
import android.util.Pair;

import java.io.File;

import mobi.ifunny.e;
import mobi.ifunny.e.c;
import mobi.ifunny.l.f;
import mobi.ifunny.video.a;

final class b
        extends f<FreeCropGifFragment, Uri, Void, Pair<a, File>> {
    private File a;
    private a b;
    private int c;

    private b(FreeCropGifFragment paramFreeCropGifFragment, String paramString, File paramFile) {
        super(paramFreeCropGifFragment, paramString);
        this.a = paramFile;
    }

    protected Pair<a, File> a(Uri... paramVarArgs) {
        paramVarArgs = paramVarArgs[0];
        if (this.a == null) {
            this.a = c.a(e.a, paramVarArgs);
        }
        if (this.a == null) {
            return null;
        }
        try {
            this.b = new a(this.a);
            return new Pair(this.b, this.a);
        } catch (UnsatisfiedLinkError paramVarArgs) {
            this.c = 2131689610;
            return null;
        } catch (Exception paramVarArgs) {
        }
        return null;
    }

    protected void a(FreeCropGifFragment paramFreeCropGifFragment, Pair<a, File> paramPair) {
        super.onPostExecute(paramFreeCropGifFragment, paramPair);
        if (this.b == null) {
            FreeCropGifFragment.a(paramFreeCropGifFragment, this.c);
            return;
        }
        FreeCropGifFragment.a(paramFreeCropGifFragment, paramPair);
    }

    protected void b(FreeCropGifFragment paramFreeCropGifFragment, Pair<a, File> paramPair) {
        super.onCancelled(paramFreeCropGifFragment, paramPair);
        if (this.b != null) {
            this.b.d();
        }
        if (paramFreeCropGifFragment != null) {
            FreeCropGifFragment.a(paramFreeCropGifFragment, this.b);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */