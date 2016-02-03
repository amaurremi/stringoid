package com.bumptech.glide.volley;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.bumptech.glide.loader.stream.StreamLoader;
import com.bumptech.glide.loader.stream.StreamLoader.StreamReadyCallback;

import java.io.ByteArrayInputStream;

public class VolleyStreamLoader
        implements StreamLoader {
    private Request current = null;
    private final RequestQueue requestQueue;
    private final RetryPolicy retryPolicy;
    private final String url;

    public VolleyStreamLoader(RequestQueue paramRequestQueue, String paramString) {
        this(paramRequestQueue, paramString, new DefaultRetryPolicy());
    }

    public VolleyStreamLoader(RequestQueue paramRequestQueue, String paramString, RetryPolicy paramRetryPolicy) {
        this.requestQueue = paramRequestQueue;
        this.url = paramString;
        this.retryPolicy = paramRetryPolicy;
    }

    public void cancel() {
        Request localRequest = this.current;
        if (localRequest != null) {
            localRequest.cancel();
            this.current = null;
        }
    }

    public void loadStream(StreamLoader.StreamReadyCallback paramStreamReadyCallback) {
        paramStreamReadyCallback = new GlideRequest(this.url, paramStreamReadyCallback);
        paramStreamReadyCallback.setRetryPolicy(this.retryPolicy);
        this.current = this.requestQueue.add(paramStreamReadyCallback);
    }

    private static class GlideRequest
            extends Request<Void> {
        private final StreamLoader.StreamReadyCallback cb;

        public GlideRequest(String paramString, StreamLoader.StreamReadyCallback paramStreamReadyCallback) {
            super(paramString, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError paramAnonymousVolleyError) {
                    VolleyStreamLoader.GlideRequest.this.onException(paramAnonymousVolleyError);
                }
            });
            this.cb = paramStreamReadyCallback;
        }

        protected void deliverResponse(Void paramVoid) {
        }

        protected Response<Void> parseNetworkResponse(NetworkResponse paramNetworkResponse) {
            this.cb.onStreamReady(new ByteArrayInputStream(paramNetworkResponse.data));
            return Response.success(null, getCacheEntry());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/volley/VolleyStreamLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */