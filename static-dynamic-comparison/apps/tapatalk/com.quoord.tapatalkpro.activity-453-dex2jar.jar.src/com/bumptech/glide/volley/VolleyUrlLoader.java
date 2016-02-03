package com.bumptech.glide.volley;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RequestQueue.RequestFilter;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.loader.model.GenericLoaderFactory;
import com.bumptech.glide.loader.model.ModelLoader;
import com.bumptech.glide.loader.model.ModelLoaderFactory;
import com.bumptech.glide.loader.stream.StreamLoader;

import java.net.URL;

public class VolleyUrlLoader
        implements ModelLoader<URL> {
    private final RequestQueue requestQueue;

    public VolleyUrlLoader(RequestQueue paramRequestQueue) {
        this.requestQueue = paramRequestQueue;
    }

    public String getId(URL paramURL) {
        return paramURL.toString();
    }

    protected RetryPolicy getRetryPolicy() {
        return new DefaultRetryPolicy();
    }

    public StreamLoader getStreamLoader(URL paramURL, int paramInt1, int paramInt2) {
        return new VolleyStreamLoader(this.requestQueue, paramURL.toString(), getRetryPolicy());
    }

    public static class Factory
            implements ModelLoaderFactory<URL> {
        private RequestQueue requestQueue;

        public Factory() {
        }

        public Factory(RequestQueue paramRequestQueue) {
            this.requestQueue = paramRequestQueue;
        }

        public ModelLoader<URL> build(Context paramContext, GenericLoaderFactory paramGenericLoaderFactory) {
            return new VolleyUrlLoader(getRequestQueue(paramContext));
        }

        protected RequestQueue getRequestQueue(Context paramContext) {
            if (this.requestQueue == null) {
                this.requestQueue = Volley.newRequestQueue(paramContext);
            }
            return this.requestQueue;
        }

        public Class<? extends ModelLoader<URL>> loaderClass() {
            return VolleyUrlLoader.class;
        }

        public void teardown() {
            if (this.requestQueue != null) {
                this.requestQueue.stop();
                this.requestQueue.cancelAll(new RequestQueue.RequestFilter() {
                    public boolean apply(Request<?> paramAnonymousRequest) {
                        return true;
                    }
                });
                this.requestQueue = null;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/volley/VolleyUrlLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */