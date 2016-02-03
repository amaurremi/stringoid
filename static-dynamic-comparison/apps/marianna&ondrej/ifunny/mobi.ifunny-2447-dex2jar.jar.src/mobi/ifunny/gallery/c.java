package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.Feed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

public final class c<T extends Feed>
        extends SimpleRestHttpHandler<T, ContentAdapterFragment> {
    private final int a;

    public c(int paramInt) {
        this.a = paramInt;
    }

    public void a(ContentAdapterFragment paramContentAdapterFragment) {
        paramContentAdapterFragment.h(this.a);
    }

    public void a(ContentAdapterFragment paramContentAdapterFragment, Throwable paramThrowable) {
        super.onExceptionCallback(paramContentAdapterFragment, paramThrowable);
        paramContentAdapterFragment.a(this.a, null);
    }

    public void a(ContentAdapterFragment paramContentAdapterFragment, T paramT) {
        paramContentAdapterFragment.a(this.a, paramT);
    }

    public void a(ContentAdapterFragment paramContentAdapterFragment, RestError paramRestError) {
        if (!paramContentAdapterFragment.a(this.a, paramRestError)) {
            super.onFailureCallback(paramContentAdapterFragment, paramRestError);
        }
    }

    public void b(ContentAdapterFragment paramContentAdapterFragment) {
        if (paramContentAdapterFragment != null) {
            paramContentAdapterFragment.j(this.a);
        }
    }

    protected boolean b(ContentAdapterFragment paramContentAdapterFragment, RestError paramRestError) {
        if (paramContentAdapterFragment.a(paramRestError)) {
            return true;
        }
        return super.onFailureAuthorization(paramContentAdapterFragment, paramRestError);
    }

    public void c(ContentAdapterFragment paramContentAdapterFragment) {
        paramContentAdapterFragment.i(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */