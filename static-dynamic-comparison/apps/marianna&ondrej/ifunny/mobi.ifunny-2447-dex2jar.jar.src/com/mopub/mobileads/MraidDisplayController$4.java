package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Handler;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.HttpResponses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

class MraidDisplayController$4
        implements Runnable {
    private MediaScannerConnection mediaScannerConnection;
    private InputStream pictureInputStream;
    private OutputStream pictureOutputStream;
    private URI uri;

    MraidDisplayController$4(MraidDisplayController paramMraidDisplayController, String paramString, File paramFile) {
    }

    private void loadPictureIntoGalleryApp(String paramString) {
        paramString = new MraidDisplayController.MoPubMediaScannerConnectionClient(this.this$0, paramString, null, null);
        this.mediaScannerConnection = new MediaScannerConnection(MraidDisplayController.access$000(this.this$0).getApplicationContext(), paramString);
        MraidDisplayController.MoPubMediaScannerConnectionClient.access$500(paramString, this.mediaScannerConnection);
        this.mediaScannerConnection.connect();
    }

    public void run() {
        try {
            this.uri = URI.create(this.val$uriString);
            Object localObject1 = HttpClientFactory.create().execute(new HttpGet(this.uri));
            this.pictureInputStream = ((HttpResponse) localObject1).getEntity().getContent();
            String str = HttpResponses.extractHeader((HttpResponse) localObject1, ResponseHeader.LOCATION);
            if (str != null) {
                this.uri = URI.create(str);
            }
            localObject1 = MraidDisplayController.access$100(this.this$0, this.uri, (HttpResponse) localObject1);
            localObject1 = new File(this.val$pictureStoragePath, (String) localObject1);
            str = ((File) localObject1).toString();
            this.pictureOutputStream = new FileOutputStream((File) localObject1);
            Streams.copyContent(this.pictureInputStream, this.pictureOutputStream);
            loadPictureIntoGalleryApp(str);
            return;
        } catch (Exception localException) {
            MraidDisplayController.access$300(this.this$0).post(new MraidDisplayController .4 .1 (this));
            return;
        } finally {
            Streams.closeStream(this.pictureInputStream);
            Streams.closeStream(this.pictureOutputStream);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidDisplayController$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */