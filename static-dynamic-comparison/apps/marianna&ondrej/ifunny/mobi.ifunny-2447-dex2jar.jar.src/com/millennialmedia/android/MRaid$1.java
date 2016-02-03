package com.millennialmedia.android;

import android.content.Context;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

final class MRaid$1
        implements Runnable {
    MRaid$1(String paramString, Context paramContext) {
    }

    public void run() {
        label181:
        label305:
        try {
            MMLog.d("MRaid", "MMJS -  download start (" + this.a + ")");
            localObject1 = new HttpGet(this.a);
            localObject1 = new DefaultHttpClient().execute((HttpUriRequest) localObject1);
            MMLog.d("MRaid", "MMJS -  download finish (" + this.a + ")");
            if ((MRaid.a(this.b, ((HttpResponse) localObject1).getEntity().getContent())) && (MRaid.c(this.b, this.a))) {
                MMLog.d("MRaid", "MMJS -  download saved (" + this.a + ")");
            }
            if (MRaid.a == null) {
                break label181;
            }
            localObject1 = (MRaid.Finished) MRaid.a.get();
            if (localObject1 == null) {
                break label181;
            }
        } catch (MalformedURLException localMalformedURLException) {
            for (; ; ) {
                Object localObject1;
                MMLog.a("MRaid", "Mraid download exception: ", localMalformedURLException);
                if (MRaid.a != null) {
                    MRaid.Finished localFinished1 = (MRaid.Finished) MRaid.a.get();
                    if (localFinished1 == null) {
                    }
                }
            }
        } catch (IllegalStateException localIllegalStateException) {
            for (; ; ) {
                MMLog.a("MRaid", "Mraid download exception: ", localIllegalStateException);
                if (MRaid.a != null) {
                    MRaid.Finished localFinished2 = (MRaid.Finished) MRaid.a.get();
                    if (localFinished2 == null) {
                    }
                }
            }
        } catch (IOException localIOException) {
            for (; ; ) {
                MMLog.a("MRaid", "Mraid download exception: ", localIOException);
                if (MRaid.a != null) {
                    MRaid.Finished localFinished3 = (MRaid.Finished) MRaid.a.get();
                    if (localFinished3 == null) {
                    }
                }
            }
        } finally {
            if (MRaid.a == null) {
                break label305;
            }
            MRaid.Finished localFinished4 = (MRaid.Finished) MRaid.a.get();
            if (localFinished4 == null) {
                break label305;
            }
            localFinished4.finished();
        }
        ((MRaid.Finished) localObject1).finished();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MRaid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */