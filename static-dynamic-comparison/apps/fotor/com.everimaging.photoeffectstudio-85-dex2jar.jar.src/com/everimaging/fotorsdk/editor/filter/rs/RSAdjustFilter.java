package com.everimaging.fotorsdk.editor.filter.rs;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.RSFilterFactory;
import com.everimaging.fotorsdk.algorithms.RSFilterFactory.Filters;
import com.everimaging.fotorsdk.algorithms.f;
import com.everimaging.fotorsdk.algorithms.filter.params.AdjustParams;
import com.everimaging.fotorsdk.algorithms.g;
import com.everimaging.fotorsdk.editor.filter.a.a;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class RSAdjustFilter
        extends c {
    private static final Object g = new Object();
    private static final String h = RSAdjustFilter.class.getSimpleName();
    private final FotorLoggerFactory.c i = FotorLoggerFactory.a(h, FotorLoggerFactory.LoggerType.CONSOLE);

    public RSAdjustFilter(a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, AdjustParams paramAdjustParams) {
        super(parama, paramBitmap1, paramBitmap2, paramAdjustParams);
        parama = RSFilterFactory.a(RSFilterFactory.Filters.ADJUST, paramAdjustParams);
        parama.a("src", paramBitmap1);
        parama.a("dst", paramBitmap2);
        this.c.a(parama);
    }

    /* Error */
    public Bitmap b() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: getstatic 19	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:g	Ljava/lang/Object;
        //   5: astore 7
        //   7: aload 7
        //   9: monitorenter
        //   10: aload_0
        //   11: getfield 46	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:i	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   14: invokeinterface 81 1 0
        //   19: aload_0
        //   20: getfield 85	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:f	Lcom/everimaging/fotorsdk/algorithms/filter/params/BaseParams;
        //   23: checkcast 87	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams
        //   26: astore 8
        //   28: aload 8
        //   30: invokevirtual 91	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:isProcessOrigin	()Z
        //   33: ifeq +61 -> 94
        //   36: aload 8
        //   38: invokevirtual 95	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getPreviewWidth	()I
        //   41: istore_3
        //   42: aload 8
        //   44: invokevirtual 98	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:getPreviewHeight	()I
        //   47: istore 4
        //   49: aload_0
        //   50: getfield 102	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:d	Landroid/graphics/Bitmap;
        //   53: invokevirtual 107	android/graphics/Bitmap:getWidth	()I
        //   56: istore 5
        //   58: aload_0
        //   59: getfield 102	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:d	Landroid/graphics/Bitmap;
        //   62: invokevirtual 110	android/graphics/Bitmap:getHeight	()I
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
        //   85: ifge +122 -> 207
        //   88: aload 8
        //   90: fload_1
        //   91: invokevirtual 114	com/everimaging/fotorsdk/algorithms/filter/params/AdjustParams:setRatio	(F)V
        //   94: aload_0
        //   95: getfield 70	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:c	Lcom/everimaging/fotorsdk/algorithms/g;
        //   98: invokevirtual 117	com/everimaging/fotorsdk/algorithms/g:d	()Landroid/support/v8/renderscript/Allocation;
        //   101: astore 8
        //   103: aload_0
        //   104: getfield 120	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:e	Landroid/graphics/Bitmap;
        //   107: ifnonnull +29 -> 136
        //   110: aload_0
        //   111: aload 8
        //   113: invokevirtual 126	android/support/v8/renderscript/Allocation:getType	()Landroid/support/v8/renderscript/Type;
        //   116: invokevirtual 131	android/support/v8/renderscript/Type:getX	()I
        //   119: aload 8
        //   121: invokevirtual 126	android/support/v8/renderscript/Allocation:getType	()Landroid/support/v8/renderscript/Type;
        //   124: invokevirtual 134	android/support/v8/renderscript/Type:getY	()I
        //   127: getstatic 140	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
        //   130: invokestatic 146	com/everimaging/fotorsdk/utils/BitmapUtils:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
        //   133: putfield 120	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:e	Landroid/graphics/Bitmap;
        //   136: aload 8
        //   138: aload_0
        //   139: getfield 120	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:e	Landroid/graphics/Bitmap;
        //   142: invokevirtual 150	android/support/v8/renderscript/Allocation:copyTo	(Landroid/graphics/Bitmap;)V
        //   145: aload_0
        //   146: getfield 46	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:i	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   149: iconst_1
        //   150: anewarray 14	java/lang/Object
        //   153: dup
        //   154: iconst_0
        //   155: new 152	java/lang/StringBuilder
        //   158: dup
        //   159: invokespecial 153	java/lang/StringBuilder:<init>	()V
        //   162: ldc -101
        //   164: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   167: aload_0
        //   168: getfield 46	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:i	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   171: invokeinterface 162 1 0
        //   176: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   179: ldc -89
        //   181: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   184: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   187: aastore
        //   188: invokeinterface 173 2 0
        //   193: aload_0
        //   194: getfield 120	com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter:e	Landroid/graphics/Bitmap;
        //   197: astore 8
        //   199: aload 7
        //   201: monitorexit
        //   202: aload_0
        //   203: monitorexit
        //   204: aload 8
        //   206: areturn
        //   207: fload_2
        //   208: fstore_1
        //   209: goto -121 -> 88
        //   212: astore 8
        //   214: aload 7
        //   216: monitorexit
        //   217: aload 8
        //   219: athrow
        //   220: astore 7
        //   222: aload_0
        //   223: monitorexit
        //   224: aload 7
        //   226: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	227	0	this	RSAdjustFilter
        //   73	136	1	f1	float
        //   81	127	2	f2	float
        //   41	30	3	j	int
        //   47	31	4	k	int
        //   56	12	5	m	int
        //   65	10	6	n	int
        //   220	5	7	localObject2	Object
        //   26	179	8	localObject3	Object
        //   212	6	8	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   10	82	212	finally
        //   88	94	212	finally
        //   94	136	212	finally
        //   136	202	212	finally
        //   214	217	212	finally
        //   2	10	220	finally
        //   217	220	220	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/filter/rs/RSAdjustFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */