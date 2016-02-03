package mobi.ifunny.util.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import mobi.ifunny.util.ag;
import mobi.ifunny.view.drawable.f;

public abstract class b {
    static final String a = b.class.getSimpleName();

    public static int a(Point paramPoint1, Point paramPoint2, boolean paramBoolean) {
        int i = 1;
        int j;
        if (paramPoint1 == null) {
            j = i;
        }
        do {
            do {
                return j;
                if (paramPoint1.x > 0) {
                    break;
                }
                j = i;
            } while (paramPoint1.y <= 0);
            if (paramPoint2.x > paramPoint1.x) {
                break;
            }
            j = i;
        } while (paramPoint2.y <= paramPoint1.y);
        float f2;
        float f1;
        label89:
        int k;
        if ((paramPoint1.x > 0) && (paramPoint2.x >= paramPoint2.y)) {
            f2 = paramPoint2.x;
            f1 = paramPoint1.x;
            i = 2;
            k = 0;
        }
        for (; ; ) {
            j = i;
            if (k >= 20) {
                break;
            }
            float f3 = f2 / i;
            if (f3 < f1) {
                if (paramBoolean) {
                }
                for (; ; ) {
                    return i;
                    j = i;
                    if (paramPoint1.y <= 0) {
                        break;
                    }
                    f2 = paramPoint2.y;
                    f1 = paramPoint1.y;
                    break label89;
                    i /= 2;
                }
            }
            j = i;
            if (f3 == f1) {
                break;
            }
            k += 1;
            i *= 2;
        }
    }

    public static Bitmap a(Context paramContext, d paramd, int paramInt1, int paramInt2, String paramString, float paramFloat) {
        Object localObject2 = paramContext.getResources();
        Object localObject1 = paramContext.getAssets();
        paramInt2 = paramd.a;
        int i = paramd.b;
        float f = paramInt2 / paramInt1;
        paramInt1 = (int) (((Resources) localObject2).getInteger(2131558405) * f);
        localObject2 = new TextPaint(257);
        ((TextPaint) localObject2).setTypeface(Typeface.createFromAsset((AssetManager) localObject1, paramContext.getString(2131689882)));
        ((TextPaint) localObject2).setTextAlign(Paint.Align.LEFT);
        ((TextPaint) localObject2).setTextSize(paramFloat * f);
        ((TextPaint) localObject2).setStyle(Paint.Style.FILL);
        ((TextPaint) localObject2).setColor(-1);
        paramContext = new StaticLayout(paramString, (TextPaint) localObject2, paramInt2, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        paramString = Bitmap.createBitmap(paramInt2, paramInt1 * 2 + paramContext.getHeight() + i, Bitmap.Config.RGB_565);
        localObject1 = new Canvas(paramString);
        localObject2 = new Rect(0, 0, paramInt2, i);
        paramd = new f(paramd);
        paramd.setBounds((Rect) localObject2);
        paramd.draw((Canvas) localObject1);
        ((Canvas) localObject1).translate(0.0F, i + paramInt1);
        paramContext.draw((Canvas) localObject1);
        return paramString;
    }

    public static Bitmap a(Context paramContext, d paramd, int paramInt1, int paramInt2, String paramString1, float paramFloat1, String paramString2, float paramFloat2) {
        f localf = new f(paramd);
        paramInt2 = paramd.a;
        int i = paramd.b;
        float f = paramInt2 / paramInt1;
        paramd = new Rect(0, 0, paramInt2, i);
        Bitmap localBitmap = Bitmap.createBitmap(paramInt2, i, Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        localPaint.setColor(-16777216);
        localPaint.setStyle(Paint.Style.FILL);
        localCanvas.drawRect(paramd, localPaint);
        localf.setBounds(paramd);
        localf.draw(localCanvas);
        a(paramContext, localCanvas, paramInt2, i, paramString1, paramFloat1, paramString2, paramFloat2, f);
        return localBitmap;
    }

    public static Bitmap a(String paramString, a parama) {
        return a(a(paramString), parama);
    }

    public static Bitmap a(byte[] paramArrayOfByte, a parama) {
        BitmapFactory.Options localOptions = a();
        localOptions.inJustDecodeBounds = true;
        localOptions.inSampleSize = 1;
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        if ((i <= 0) || (j <= 0)) {
            return null;
        }
        localOptions.inJustDecodeBounds = false;
        if (parama == null) {
        }
        Point localPoint;
        for (localOptions.inSampleSize = 1; ; localOptions.inSampleSize = a(parama.d(), localPoint, parama.e())) {
            return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
            localPoint = new Point(i, j);
        }
    }

    public static BitmapFactory.Options a() {
        return c.a();
    }

    public static Point a(File paramFile) {
        BitmapFactory.Options localOptions = a();
        localOptions.inJustDecodeBounds = true;
        localOptions.inSampleSize = 1;
        BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
        return new Point(localOptions.outWidth, localOptions.outHeight);
    }

    public static d a(InputStream paramInputStream, a parama) {
        return b(a(paramInputStream), parama);
    }

    public static void a(Context paramContext, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString1, float paramFloat1, String paramString2, float paramFloat2, float paramFloat3) {
        Object localObject = paramContext.getResources();
        int i = ((Resources) localObject).getInteger(2131558432);
        float f = ((Resources) localObject).getDimensionPixelSize(2131427450) * paramFloat3;
        localObject = new TextPaint(257);
        ((TextPaint) localObject).setTypeface(Typeface.createFromAsset(paramContext.getAssets(), paramContext.getString(2131689578)));
        ((TextPaint) localObject).setTextAlign(Paint.Align.LEFT);
        ((TextPaint) localObject).setTextSize(paramFloat1 * paramFloat3);
        paramContext = new StaticLayout(paramString1, (TextPaint) localObject, paramInt1, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        int j = paramCanvas.save();
        paramCanvas.translate((paramInt1 - paramContext.getWidth()) / 2, f);
        ((TextPaint) localObject).setStrokeWidth(Math.max(i, (int) (0.08F * paramFloat1 * paramFloat3)));
        ((TextPaint) localObject).setStyle(Paint.Style.STROKE);
        ((TextPaint) localObject).setColor(-16777216);
        paramContext.draw(paramCanvas);
        ((TextPaint) localObject).setStyle(Paint.Style.FILL);
        ((TextPaint) localObject).setColor(-1);
        paramContext.draw(paramCanvas);
        paramCanvas.restoreToCount(j);
        ((TextPaint) localObject).setTextSize(paramFloat2 * paramFloat3);
        paramContext = new StaticLayout(paramString2, (TextPaint) localObject, paramInt1, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
        j = paramCanvas.save();
        paramCanvas.translate((paramInt1 - paramContext.getWidth()) / 2, paramInt2 - f - paramContext.getHeight());
        ((TextPaint) localObject).setStrokeWidth(Math.max(i, (int) (0.1F * paramFloat2 * paramFloat3)));
        ((TextPaint) localObject).setStyle(Paint.Style.STROKE);
        ((TextPaint) localObject).setColor(-16777216);
        paramContext.draw(paramCanvas);
        ((TextPaint) localObject).setStyle(Paint.Style.FILL);
        ((TextPaint) localObject).setColor(-1);
        paramContext.draw(paramCanvas);
        paramCanvas.restoreToCount(j);
    }

    public static byte[] a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt) {
        ag localag = new ag();
        paramBitmap.compress(paramCompressFormat, paramInt, localag);
        return localag.toByteArray();
    }

    /* Error */
    public static byte[] a(InputStream paramInputStream) {
        // Byte code:
        //   0: aload_0
        //   1: invokestatic 282	mobi/ifunny/util/a/b:b	(Ljava/io/InputStream;)[B
        //   4: astore_1
        //   5: aload_0
        //   6: ifnull +7 -> 13
        //   9: aload_0
        //   10: invokevirtual 287	java/io/InputStream:close	()V
        //   13: aload_1
        //   14: areturn
        //   15: astore_1
        //   16: aload_0
        //   17: ifnull +7 -> 24
        //   20: aload_0
        //   21: invokevirtual 287	java/io/InputStream:close	()V
        //   24: aload_1
        //   25: athrow
        //   26: astore_0
        //   27: aload_1
        //   28: areturn
        //   29: astore_0
        //   30: goto -6 -> 24
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	33	0	paramInputStream	InputStream
        //   4	10	1	arrayOfByte1	byte[]
        //   15	13	1	arrayOfByte2	byte[]
        // Exception table:
        //   from	to	target	type
        //   0	5	15	finally
        //   9	13	26	java/io/IOException
        //   20	24	29	java/io/IOException
    }

    public static byte[] a(String paramString) {
        try {
            paramString = a(new FileInputStream(paramString));
            return paramString;
        } catch (FileNotFoundException paramString) {
        }
        return null;
    }

    public static d b(String paramString, a parama) {
        return b(a(paramString), parama);
    }

    public static d b(byte[] paramArrayOfByte, a parama) {
        if (paramArrayOfByte == null) {
            return null;
        }
        return c.a(paramArrayOfByte, parama);
    }

    /* Error */
    private static byte[] b(InputStream paramInputStream) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: new 299	java/io/BufferedInputStream
        //   5: dup
        //   6: aload_0
        //   7: invokespecial 302	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   10: astore_0
        //   11: new 269	mobi/ifunny/util/ag
        //   14: dup
        //   15: invokespecial 270	mobi/ifunny/util/ag:<init>	()V
        //   18: astore_2
        //   19: sipush 4096
        //   22: newarray <illegal type>
        //   24: astore 4
        //   26: aload_0
        //   27: aload 4
        //   29: invokevirtual 306	java/io/BufferedInputStream:read	([B)I
        //   32: istore_1
        //   33: iload_1
        //   34: ifge +44 -> 78
        //   37: aload_0
        //   38: invokevirtual 307	java/io/BufferedInputStream:close	()V
        //   41: aconst_null
        //   42: astore_0
        //   43: aload_2
        //   44: invokevirtual 278	mobi/ifunny/util/ag:toByteArray	()[B
        //   47: astore 4
        //   49: aload_2
        //   50: ifnull +116 -> 166
        //   53: aload_2
        //   54: invokevirtual 308	mobi/ifunny/util/ag:close	()V
        //   57: aload_3
        //   58: astore_2
        //   59: aload_0
        //   60: ifnull +7 -> 67
        //   63: aload_0
        //   64: invokevirtual 307	java/io/BufferedInputStream:close	()V
        //   67: aload_2
        //   68: ifnull +7 -> 75
        //   71: aload_2
        //   72: invokevirtual 308	mobi/ifunny/util/ag:close	()V
        //   75: aload 4
        //   77: areturn
        //   78: aload_2
        //   79: aload 4
        //   81: iconst_0
        //   82: iload_1
        //   83: invokevirtual 312	mobi/ifunny/util/ag:write	([BII)V
        //   86: goto -60 -> 26
        //   89: astore 4
        //   91: goto -48 -> 43
        //   94: astore 4
        //   96: aconst_null
        //   97: astore_2
        //   98: aload_0
        //   99: astore_3
        //   100: aload 4
        //   102: astore_0
        //   103: aload_3
        //   104: ifnull +7 -> 111
        //   107: aload_3
        //   108: invokevirtual 307	java/io/BufferedInputStream:close	()V
        //   111: aload_2
        //   112: ifnull +7 -> 119
        //   115: aload_2
        //   116: invokevirtual 308	mobi/ifunny/util/ag:close	()V
        //   119: aload_0
        //   120: athrow
        //   121: astore 4
        //   123: goto -80 -> 43
        //   126: astore_3
        //   127: goto -68 -> 59
        //   130: astore_0
        //   131: goto -64 -> 67
        //   134: astore_0
        //   135: aload 4
        //   137: areturn
        //   138: astore_3
        //   139: goto -28 -> 111
        //   142: astore_2
        //   143: goto -24 -> 119
        //   146: astore 4
        //   148: aload_0
        //   149: astore_3
        //   150: aload 4
        //   152: astore_0
        //   153: goto -50 -> 103
        //   156: astore 4
        //   158: aload_0
        //   159: astore_3
        //   160: aload 4
        //   162: astore_0
        //   163: goto -60 -> 103
        //   166: goto -107 -> 59
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	169	0	paramInputStream	InputStream
        //   32	51	1	i	int
        //   18	98	2	localObject1	Object
        //   142	1	2	localIOException1	java.io.IOException
        //   1	107	3	localInputStream1	InputStream
        //   126	1	3	localIOException2	java.io.IOException
        //   138	1	3	localIOException3	java.io.IOException
        //   149	11	3	localInputStream2	InputStream
        //   24	56	4	arrayOfByte	byte[]
        //   89	1	4	localIOException4	java.io.IOException
        //   94	7	4	localObject2	Object
        //   121	15	4	localIOException5	java.io.IOException
        //   146	5	4	localObject3	Object
        //   156	5	4	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   26	33	89	java/io/IOException
        //   78	86	89	java/io/IOException
        //   11	19	94	finally
        //   37	41	121	java/io/IOException
        //   53	57	126	java/io/IOException
        //   63	67	130	java/io/IOException
        //   71	75	134	java/io/IOException
        //   107	111	138	java/io/IOException
        //   115	119	142	java/io/IOException
        //   19	26	146	finally
        //   26	33	146	finally
        //   37	41	146	finally
        //   78	86	146	finally
        //   43	49	156	finally
        //   53	57	156	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */