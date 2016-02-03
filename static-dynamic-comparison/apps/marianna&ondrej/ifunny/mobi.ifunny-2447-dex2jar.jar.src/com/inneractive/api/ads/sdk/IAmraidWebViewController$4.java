package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

final class IAmraidWebViewController$4
        implements Runnable {
    private MediaScannerConnection mediaScannerConnection;
    private InputStream pictureInputStream;
    private OutputStream pictureOutputStream;
    private URI uri;

    IAmraidWebViewController$4(IAmraidWebViewController paramIAmraidWebViewController, String paramString, File paramFile) {
    }

    private void loadPictureIntoGalleryApp(String paramString) {
        paramString = new IAmraidWebViewController.a(this.this$0, paramString, null, null);
        this.mediaScannerConnection = new MediaScannerConnection(IAmraidWebViewController.access$000(this.this$0).getApplicationContext(), paramString);
        IAmraidWebViewController.a.access$500(paramString, this.mediaScannerConnection);
        this.mediaScannerConnection.connect();
    }

    public final void run() {
        try {
            this.uri = URI.create(this.val$uriString);
            Object localObject1 = m.b().execute(new HttpGet(this.uri));
            this.pictureInputStream = ((HttpResponse) localObject1).getEntity().getContent();
            localObject1 = IAmraidWebViewController.access$100(this.this$0, this.uri, (HttpResponse) localObject1);
            localObject1 = new File(this.val$pictureStoragePath, (String) localObject1);
            String str = ((File) localObject1).toString();
            this.pictureOutputStream = new FileOutputStream((File) localObject1);
            c.a(this.pictureInputStream, this.pictureOutputStream);
            loadPictureIntoGalleryApp(str);
            return;
        } catch (Exception localException) {
            IAmraidWebViewController.access$300(this.this$0).post(new IAmraidWebViewController .4 .1 (this));
            return;
        } finally {
            c.a(this.pictureInputStream);
            c.a(this.pictureOutputStream);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebViewController$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */