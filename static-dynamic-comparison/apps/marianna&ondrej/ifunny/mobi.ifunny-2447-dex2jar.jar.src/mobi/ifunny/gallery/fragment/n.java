package mobi.ifunny.gallery.fragment;

import android.support.v4.app.k;
import android.widget.Toast;

import java.io.File;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.util.cache.a;
import mobi.ifunny.util.cache.m;

class n
        extends mobi.ifunny.l.f<f, Void, Void, Boolean> {
    private final IFunny a;

    public n(f paramf, String paramString, IFunny paramIFunny) {
        super(paramf, paramString);
        this.a = paramIFunny;
    }

    private void c(f paramf, Boolean paramBoolean) {
        k localk;
        if (paramBoolean != null) {
            localk = paramf.getActivity();
            if (paramBoolean.booleanValue()) {
                Toast.makeText(localk, 2131689635, 0).show();
                IFunnyRestRequest.Content.contentStat(paramf, "task.content.stat", null, this.a.id, "save", null);
            }
        } else {
            return;
        }
        Toast.makeText(localk, 2131689629, 0).show();
    }

    protected Boolean a(Void... paramVarArgs) {
        String str;
        int i;
        if (this.a.isGifContent()) {
            str = ".gif";
            i = this.a.url.lastIndexOf(File.separator);
            if (i + 1 < this.a.url.length()) {
                break label117;
            }
        }
        label117:
        for (paramVarArgs = Long.toString(this.a.url.hashCode()); ; paramVarArgs = this.a.url.substring(i)) {
            Object localObject = paramVarArgs;
            if (!paramVarArgs.endsWith(str)) {
                localObject = paramVarArgs + str;
            }
            return (Boolean) a.a(this.a.url, mobi.ifunny.util.cache.f.a((String) localObject)).a;
            str = ".jpg";
            break;
        }
    }

    protected void a(f paramf, Boolean paramBoolean) {
        c(paramf, paramBoolean);
    }

    protected void b(f paramf, Boolean paramBoolean) {
        super.onCancelled(paramf, paramBoolean);
        if (paramf != null) {
            c(paramf, paramBoolean);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */