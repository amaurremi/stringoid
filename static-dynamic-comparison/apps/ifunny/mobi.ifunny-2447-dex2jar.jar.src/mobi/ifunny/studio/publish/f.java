package mobi.ifunny.studio.publish;

import android.util.Pair;

import java.io.File;

import mobi.ifunny.l.b;

class f
        extends b<PublishGifCaptionActivity, Void, Void, Pair<String, String>> {
    private File a;
    private String b;
    private String c;

    private f(PublishGifCaptionActivity paramPublishGifCaptionActivity, String paramString1, File paramFile, String paramString2, String paramString3) {
        super(paramPublishGifCaptionActivity, paramString1);
        this.a = paramFile;
        this.b = paramString2;
        this.c = paramString3;
    }

    /* Error */
    protected Pair<String, String> a(Void... paramVarArgs) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: new 32	java/util/Random
        //   5: dup
        //   6: invokespecial 35	java/util/Random:<init>	()V
        //   9: astore_1
        //   10: new 37	java/io/File
        //   13: dup
        //   14: aload_0
        //   15: getfield 17	mobi/ifunny/studio/publish/f:a	Ljava/io/File;
        //   18: new 39	java/lang/StringBuilder
        //   21: dup
        //   22: invokespecial 40	java/lang/StringBuilder:<init>	()V
        //   25: aload_1
        //   26: invokevirtual 44	java/util/Random:nextLong	()J
        //   29: invokestatic 50	java/lang/Long:toHexString	(J)Ljava/lang/String;
        //   32: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   35: ldc 56
        //   37: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   40: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   43: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   46: astore_1
        //   47: aload_1
        //   48: invokevirtual 67	java/io/File:mkdirs	()Z
        //   51: pop
        //   52: aload_1
        //   53: invokevirtual 70	java/io/File:delete	()Z
        //   56: pop
        //   57: aload_1
        //   58: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   61: astore_3
        //   62: new 75	java/io/BufferedOutputStream
        //   65: dup
        //   66: new 77	java/io/FileOutputStream
        //   69: dup
        //   70: aload_3
        //   71: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
        //   74: invokespecial 83	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   77: astore_1
        //   78: getstatic 89	mobi/ifunny/studio/publish/PublishGifCaptionActivity:v	Landroid/graphics/Bitmap;
        //   81: getstatic 95	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   84: bipush 100
        //   86: aload_1
        //   87: invokevirtual 101	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   90: pop
        //   91: aload_1
        //   92: ifnull +7 -> 99
        //   95: aload_1
        //   96: invokevirtual 106	java/io/OutputStream:close	()V
        //   99: new 108	android/util/Pair
        //   102: dup
        //   103: aload_3
        //   104: aload_0
        //   105: getfield 19	mobi/ifunny/studio/publish/f:b	Ljava/lang/String;
        //   108: invokespecial 111	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   111: astore_2
        //   112: aload_2
        //   113: areturn
        //   114: astore_1
        //   115: aconst_null
        //   116: astore_1
        //   117: aload_1
        //   118: ifnull -6 -> 112
        //   121: aload_1
        //   122: invokevirtual 106	java/io/OutputStream:close	()V
        //   125: aconst_null
        //   126: areturn
        //   127: astore_1
        //   128: aconst_null
        //   129: areturn
        //   130: astore_2
        //   131: aconst_null
        //   132: astore_1
        //   133: aload_1
        //   134: ifnull +7 -> 141
        //   137: aload_1
        //   138: invokevirtual 106	java/io/OutputStream:close	()V
        //   141: aload_2
        //   142: athrow
        //   143: astore_1
        //   144: goto -45 -> 99
        //   147: astore_1
        //   148: goto -7 -> 141
        //   151: astore_2
        //   152: goto -19 -> 133
        //   155: astore_3
        //   156: goto -39 -> 117
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	159	0	this	f
        //   0	159	1	paramVarArgs	Void[]
        //   1	112	2	localPair	Pair
        //   130	12	2	localObject1	Object
        //   151	1	2	localObject2	Object
        //   61	43	3	str	String
        //   155	1	3	localFileNotFoundException	java.io.FileNotFoundException
        // Exception table:
        //   from	to	target	type
        //   62	78	114	java/io/FileNotFoundException
        //   121	125	127	java/io/IOException
        //   62	78	130	finally
        //   95	99	143	java/io/IOException
        //   137	141	147	java/io/IOException
        //   78	91	151	finally
        //   78	91	155	java/io/FileNotFoundException
    }

    protected void a(PublishGifCaptionActivity paramPublishGifCaptionActivity) {
        super.onStarted(paramPublishGifCaptionActivity);
        paramPublishGifCaptionActivity.c("TASK_PREPARE");
    }

    protected void a(PublishGifCaptionActivity paramPublishGifCaptionActivity, Pair<String, String> paramPair) {
        super.onPostExecute(paramPublishGifCaptionActivity, paramPair);
        if (paramPair != null) {
            PublishGifCaptionActivity.a(paramPublishGifCaptionActivity, this.c, (String) paramPair.first, (String) paramPair.second);
        }
    }

    protected void b(PublishGifCaptionActivity paramPublishGifCaptionActivity) {
        super.onFinished(paramPublishGifCaptionActivity);
        paramPublishGifCaptionActivity.t();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */