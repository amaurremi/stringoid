package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.Feed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

public final class d<T extends Feed>
        extends SimpleRestHttpHandler<T, ContentAdapterFragment> {
    public void a(ContentAdapterFragment paramContentAdapterFragment) {
        paramContentAdapterFragment.K();
    }

    public void a(ContentAdapterFragment paramContentAdapterFragment, Throwable paramThrowable) {
        super.onExceptionCallback(paramContentAdapterFragment, paramThrowable);
        paramContentAdapterFragment.b(null);
    }

    public void a(ContentAdapterFragment paramContentAdapterFragment, T paramT) {
        paramContentAdapterFragment.a(paramT);
    }

    public void a(ContentAdapterFragment paramContentAdapterFragment, RestError paramRestError) {
        if (!paramContentAdapterFragment.b(paramRestError)) {
            super.onFailureCallback(paramContentAdapterFragment, paramRestError);
        }
    }

    public void b(ContentAdapterFragment paramContentAdapterFragment) {
        paramContentAdapterFragment.M();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */