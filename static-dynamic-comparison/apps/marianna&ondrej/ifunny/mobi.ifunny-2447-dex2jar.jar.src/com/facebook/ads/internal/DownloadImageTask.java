package com.facebook.ads.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.net.URL;

public class DownloadImageTask
        extends AsyncTask<String, Void, Bitmap> {
    private static final String TAG = DownloadImageTask.class.getSimpleName();
    private final ImageView imageView;

    public DownloadImageTask(ImageView paramImageView) {
        this.imageView = paramImageView;
    }

    protected Bitmap doInBackground(String... paramVarArgs) {
        paramVarArgs = paramVarArgs[0];
        try {
            Bitmap localBitmap = BitmapFactory.decodeStream(new URL(paramVarArgs).openStream());
            return localBitmap;
        } catch (Exception localException) {
            Log.e(TAG, "Error downloading image: " + paramVarArgs, localException);
        }
        return null;
    }

    protected void onPostExecute(Bitmap paramBitmap) {
        this.imageView.setImageBitmap(paramBitmap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/DownloadImageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */