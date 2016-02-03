package com.uservoice.uservoicesdk.image;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

public class DownloadImageTask
        extends AsyncTask<Void, Void, Bitmap> {
    private ImageView imageView;
    private final String url;

    public DownloadImageTask(String paramString, ImageView paramImageView) {
        this.url = paramString;
        this.imageView = paramImageView;
        paramImageView.setImageBitmap(null);
    }

    /* Error */
    protected Bitmap doInBackground(Void... paramVarArgs) {
        // Byte code:
        //   0: new 31	java/net/URL
        //   3: dup
        //   4: aload_0
        //   5: getfield 16	com/uservoice/uservoicesdk/image/DownloadImageTask:url	Ljava/lang/String;
        //   8: invokespecial 34	java/net/URL:<init>	(Ljava/lang/String;)V
        //   11: invokevirtual 38	java/net/URL:openStream	()Ljava/io/InputStream;
        //   14: astore_2
        //   15: aload_2
        //   16: astore_1
        //   17: aload_2
        //   18: invokestatic 44	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
        //   21: astore_3
        //   22: aload_2
        //   23: invokevirtual 49	java/io/InputStream:close	()V
        //   26: aload_3
        //   27: areturn
        //   28: astore_3
        //   29: aconst_null
        //   30: astore_2
        //   31: aload_2
        //   32: astore_1
        //   33: aload_3
        //   34: invokevirtual 52	java/lang/Exception:printStackTrace	()V
        //   37: aload_2
        //   38: invokevirtual 49	java/io/InputStream:close	()V
        //   41: aconst_null
        //   42: areturn
        //   43: astore_1
        //   44: aconst_null
        //   45: areturn
        //   46: astore_2
        //   47: aconst_null
        //   48: astore_1
        //   49: aload_1
        //   50: invokevirtual 49	java/io/InputStream:close	()V
        //   53: aload_2
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: areturn
        //   58: astore_1
        //   59: goto -6 -> 53
        //   62: astore_2
        //   63: goto -14 -> 49
        //   66: astore_3
        //   67: goto -36 -> 31
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	70	0	this	DownloadImageTask
        //   0	70	1	paramVarArgs	Void[]
        //   14	24	2	localInputStream	java.io.InputStream
        //   46	8	2	localObject1	Object
        //   62	1	2	localObject2	Object
        //   21	6	3	localBitmap	Bitmap
        //   28	29	3	localException1	Exception
        //   66	1	3	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   0	15	28	java/lang/Exception
        //   37	41	43	java/lang/Exception
        //   0	15	46	finally
        //   22	26	55	java/lang/Exception
        //   49	53	58	java/lang/Exception
        //   17	22	62	finally
        //   33	37	62	finally
        //   17	22	66	java/lang/Exception
    }

    protected void onPostExecute(Bitmap paramBitmap) {
        ImageCache.getInstance().set(this.url, paramBitmap);
        this.imageView.setImageBitmap(paramBitmap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/image/DownloadImageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */