package mobi.ifunny.gallery.fragment;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

public class y
        extends SimpleRestHttpHandler<IFunny, IFunnyWorkInfoFragment> {
    private final boolean a;

    public y(boolean paramBoolean) {
        this.a = paramBoolean;
    }

    public void a(IFunnyWorkInfoFragment paramIFunnyWorkInfoFragment) {
        super.onStartCallback(paramIFunnyWorkInfoFragment);
        if (this.a) {
            paramIFunnyWorkInfoFragment.b();
        }
    }

    public void a(IFunnyWorkInfoFragment paramIFunnyWorkInfoFragment, IFunny paramIFunny) {
        paramIFunnyWorkInfoFragment.a(paramIFunny);
    }

    public void b(IFunnyWorkInfoFragment paramIFunnyWorkInfoFragment) {
        paramIFunnyWorkInfoFragment.c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */