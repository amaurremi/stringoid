package com.everimaging.fotorsdk.editor.filter.jni;

import android.content.Context;
import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.filter.params.AdjustParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class a
        extends c {
    private static final Object e = new Object();
    private static final String f = a.class.getSimpleName();
    private final FotorLoggerFactory.c g = FotorLoggerFactory.a(f, FotorLoggerFactory.LoggerType.CONSOLE);

    public a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, AdjustParams paramAdjustParams) {
        super(paramContext, paramBitmap1, paramBitmap2, paramAdjustParams);
    }

    /* Error */
    public Bitmap b() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: getstatic 19	com/everimaging/fotorsdk/editor/filter/jni/a:e	Ljava/lang/Object;
        //   5: astore 9
        //   7: aload 9
        //   9: monitorenter
        //   10: aload_0
        //   11: getfield 46	com/everimaging/fotorsdk/editor/filter/jni/a:g	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   14: invokeinterface 52 1 0
        //   19: aload_0
        //   20: getfield 56	com/everimaging/fotorsdk/editor/filter/jni/a:c	Lcom/everimaging/fotorsdk/algorithms/filter/params/BaseParams;
        //   23: checkcast 58	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams
        //   26: astore 10
        //   28: aload 10
        //   30: invokevirtual 62	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:isProcessOrigin	()Z
        //   33: ifeq +61 -> 94
        //   36: aload 10
        //   38: invokevirtual 66	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getPreviewWidth	()I
        //   41: istore_3
        //   42: aload 10
        //   44: invokevirtual 69	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getPreviewHeight	()I
        //   47: istore 4
        //   49: aload_0
        //   50: getfield 72	com/everimaging/fotorsdk/editor/filter/jni/a:a	Landroid/graphics/Bitmap;
        //   53: invokevirtual 77	android/graphics/Bitmap:getWidth	()I
        //   56: istore 5
        //   58: aload_0
        //   59: getfield 72	com/everimaging/fotorsdk/editor/filter/jni/a:a	Landroid/graphics/Bitmap;
        //   62: invokevirtual 80	android/graphics/Bitmap:getHeight	()I
        //   65: istore 6
        //   67: iload 5
        //   69: i2f
        //   70: iload_3
        //   71: i2f
        //   72: fdiv
        //   73: fstore_1
        //   74: iload 6
        //   76: i2f
        //   77: iload 4
        //   79: i2f
        //   80: fdiv
        //   81: fstore_2
        //   82: fload_1
        //   83: fload_2
        //   84: fcmpg
        //   85: ifge +191 -> 276
        //   88: aload 10
        //   90: fload_1
        //   91: invokevirtual 84	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:setRatio	(F)V
        //   94: aload_0
        //   95: getfield 86	com/everimaging/fotorsdk/editor/filter/jni/a:b	Landroid/graphics/Bitmap;
        //   98: astore 8
        //   100: aload 8
        //   102: astore 7
        //   104: aload 8
        //   106: ifnonnull +15 -> 121
        //   109: aload_0
        //   110: getfield 72	com/everimaging/fotorsdk/editor/filter/jni/a:a	Landroid/graphics/Bitmap;
        //   113: getstatic 92	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
        //   116: invokestatic 98	com/everimaging/fotorsdk/utils/BitmapUtils:copy	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
        //   119: astore 7
        //   121: aload_0
        //   122: getfield 72	com/everimaging/fotorsdk/editor/filter/jni/a:a	Landroid/graphics/Bitmap;
        //   125: aload 7
        //   127: aload 10
        //   129: invokevirtual 66	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getPreviewWidth	()I
        //   132: aload 10
        //   134: invokevirtual 69	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getPreviewHeight	()I
        //   137: aload 10
        //   139: invokevirtual 62	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:isProcessOrigin	()Z
        //   142: aload 10
        //   144: invokevirtual 102	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getRatio	()F
        //   147: aload 10
        //   149: invokevirtual 105	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getBrightness	()F
        //   152: aload 10
        //   154: invokevirtual 108	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getContrast	()F
        //   157: aload 10
        //   159: invokevirtual 111	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getSaturation	()F
        //   162: aload 10
        //   164: invokevirtual 114	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getSharpening	()F
        //   167: aload 10
        //   169: invokevirtual 117	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getSamplerScale	()F
        //   172: aload 10
        //   174: invokevirtual 120	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getTemperature	()F
        //   177: aload 10
        //   179: invokevirtual 123	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getTint	()F
        //   182: aload 10
        //   184: invokevirtual 126	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getHighlights	()F
        //   187: aload 10
        //   189: invokevirtual 129	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getShadows	()F
        //   192: aload 10
        //   194: invokevirtual 132	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getVignette	()F
        //   197: aload 10
        //   199: invokevirtual 135	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getRgb_R	()F
        //   202: aload 10
        //   204: invokevirtual 138	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getRgb_G	()F
        //   207: aload 10
        //   209: invokevirtual 141	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getRgb_B	()F
        //   212: aload 10
        //   214: invokevirtual 145	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getCurvePoints	()[F
        //   217: invokestatic 151	com/everimaging/fotorsdk/algorithms/jni/FotorSDKAlgorithmsNative:adjust	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;IIZFFFFFFFFFFFFFF[F)V
        //   220: aload_0
        //   221: getfield 46	com/everimaging/fotorsdk/editor/filter/jni/a:g	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   224: iconst_1
        //   225: anewarray 14	java/lang/Object
        //   228: dup
        //   229: iconst_0
        //   230: new 153	java/lang/StringBuilder
        //   233: dup
        //   234: invokespecial 154	java/lang/StringBuilder:<init>	()V
        //   237: ldc -100
        //   239: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   242: aload_0
        //   243: getfield 46	com/everimaging/fotorsdk/editor/filter/jni/a:g	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   246: invokeinterface 163 1 0
        //   251: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   254: ldc -88
        //   256: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   259: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   262: aastore
        //   263: invokeinterface 174 2 0
        //   268: aload 9
        //   270: monitorexit
        //   271: aload_0
        //   272: monitorexit
        //   273: aload 7
        //   275: areturn
        //   276: fload_2
        //   277: fstore_1
        //   278: goto -190 -> 88
        //   281: astore 7
        //   283: aload 9
        //   285: monitorexit
        //   286: aload 7
        //   288: athrow
        //   289: astore 7
        //   291: aload_0
        //   292: monitorexit
        //   293: aload 7
        //   295: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	296	0	this	a
        //   73	205	1	f1	float
        //   81	196	2	f2	float
        //   41	30	3	i	int
        //   47	31	4	j	int
        //   56	12	5	k	int
        //   65	10	6	m	int
        //   102	172	7	localBitmap1	Bitmap
        //   281	6	7	localObject1	Object
        //   289	5	7	localObject2	Object
        //   98	7	8	localBitmap2	Bitmap
        //   26	187	10	localAdjustParams	AdjustParams
        // Exception table:
        //   from	to	target	type
        //   10	82	281	finally
        //   88	94	281	finally
        //   94	100	281	finally
        //   109	121	281	finally
        //   121	271	281	finally
        //   283	286	281	finally
        //   2	10	289	finally
        //   286	289	289	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/jni/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */