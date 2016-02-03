package mobi.ifunny.studio.comics;

import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.Toast;

import java.io.File;

import mobi.ifunny.l.b;

public class r
        extends b<FrameEditorActivity, File, Void, Void> {
    private Bitmap a;
    private String b;
    private boolean c;
    private Intent d;
    private int e;

    /* Error */
    protected Void a(File... paramVarArgs) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aload_0
        //   3: invokevirtual 22	mobi/ifunny/studio/comics/r:isCanceled	()Z
        //   6: ifeq +5 -> 11
        //   9: aconst_null
        //   10: areturn
        //   11: new 24	java/io/File
        //   14: dup
        //   15: aload_1
        //   16: iconst_0
        //   17: aaload
        //   18: ldc 26
        //   20: invokespecial 30	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   23: astore 4
        //   25: new 32	java/io/FileOutputStream
        //   28: dup
        //   29: aload 4
        //   31: invokespecial 35	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   34: astore_1
        //   35: new 37	java/io/BufferedOutputStream
        //   38: dup
        //   39: aload_1
        //   40: invokespecial 40	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   43: astore 5
        //   45: aload_1
        //   46: astore_3
        //   47: aload 5
        //   49: astore_2
        //   50: aload_0
        //   51: getfield 42	mobi/ifunny/studio/comics/r:a	Landroid/graphics/Bitmap;
        //   54: getstatic 48	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   57: bipush 50
        //   59: aload_1
        //   60: invokevirtual 54	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   63: pop
        //   64: aload_1
        //   65: astore_3
        //   66: aload 5
        //   68: astore_2
        //   69: aload_0
        //   70: aload 4
        //   72: invokevirtual 58	java/io/File:getPath	()Ljava/lang/String;
        //   75: putfield 60	mobi/ifunny/studio/comics/r:b	Ljava/lang/String;
        //   78: aload_1
        //   79: astore_3
        //   80: aload 5
        //   82: astore_2
        //   83: aload_0
        //   84: getfield 42	mobi/ifunny/studio/comics/r:a	Landroid/graphics/Bitmap;
        //   87: invokevirtual 64	android/graphics/Bitmap:recycle	()V
        //   90: aload_1
        //   91: astore_3
        //   92: aload 5
        //   94: astore_2
        //   95: aload_0
        //   96: aconst_null
        //   97: putfield 42	mobi/ifunny/studio/comics/r:a	Landroid/graphics/Bitmap;
        //   100: aload 5
        //   102: invokevirtual 67	java/io/BufferedOutputStream:close	()V
        //   105: aload_1
        //   106: invokevirtual 68	java/io/FileOutputStream:close	()V
        //   109: aconst_null
        //   110: areturn
        //   111: astore_1
        //   112: aload_1
        //   113: invokevirtual 71	java/lang/Exception:printStackTrace	()V
        //   116: aconst_null
        //   117: areturn
        //   118: astore_1
        //   119: aconst_null
        //   120: astore 4
        //   122: aconst_null
        //   123: astore_1
        //   124: aload 4
        //   126: astore_3
        //   127: aload_1
        //   128: astore_2
        //   129: aload_0
        //   130: iconst_1
        //   131: putfield 73	mobi/ifunny/studio/comics/r:c	Z
        //   134: aload_1
        //   135: invokevirtual 67	java/io/BufferedOutputStream:close	()V
        //   138: aload 4
        //   140: invokevirtual 68	java/io/FileOutputStream:close	()V
        //   143: aconst_null
        //   144: areturn
        //   145: astore_1
        //   146: aload_1
        //   147: invokevirtual 71	java/lang/Exception:printStackTrace	()V
        //   150: aconst_null
        //   151: areturn
        //   152: astore_1
        //   153: aconst_null
        //   154: astore_2
        //   155: aload_2
        //   156: invokevirtual 67	java/io/BufferedOutputStream:close	()V
        //   159: aload_3
        //   160: invokevirtual 68	java/io/FileOutputStream:close	()V
        //   163: aload_1
        //   164: athrow
        //   165: astore_2
        //   166: aload_2
        //   167: invokevirtual 71	java/lang/Exception:printStackTrace	()V
        //   170: goto -7 -> 163
        //   173: astore 4
        //   175: aconst_null
        //   176: astore_2
        //   177: aload_1
        //   178: astore_3
        //   179: aload 4
        //   181: astore_1
        //   182: goto -27 -> 155
        //   185: astore_1
        //   186: goto -31 -> 155
        //   189: astore_2
        //   190: aconst_null
        //   191: astore_2
        //   192: aload_1
        //   193: astore 4
        //   195: aload_2
        //   196: astore_1
        //   197: goto -73 -> 124
        //   200: astore_2
        //   201: aload_1
        //   202: astore 4
        //   204: aload 5
        //   206: astore_1
        //   207: goto -83 -> 124
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	210	0	this	r
        //   0	210	1	paramVarArgs	File[]
        //   49	107	2	localObject1	Object
        //   165	2	2	localException1	Exception
        //   176	1	2	localObject2	Object
        //   189	1	2	localException2	Exception
        //   191	5	2	localObject3	Object
        //   200	1	2	localException3	Exception
        //   1	178	3	localObject4	Object
        //   23	116	4	localFile	File
        //   173	7	4	localObject5	Object
        //   193	10	4	arrayOfFile	File[]
        //   43	162	5	localBufferedOutputStream	java.io.BufferedOutputStream
        // Exception table:
        //   from	to	target	type
        //   100	109	111	java/lang/Exception
        //   25	35	118	java/lang/Exception
        //   134	143	145	java/lang/Exception
        //   25	35	152	finally
        //   155	163	165	java/lang/Exception
        //   35	45	173	finally
        //   50	64	185	finally
        //   69	78	185	finally
        //   83	90	185	finally
        //   95	100	185	finally
        //   129	134	185	finally
        //   35	45	189	java/lang/Exception
        //   50	64	200	java/lang/Exception
        //   69	78	200	java/lang/Exception
        //   83	90	200	java/lang/Exception
        //   95	100	200	java/lang/Exception
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity) {
        super.onStarted(paramFrameEditorActivity);
        paramFrameEditorActivity.s();
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity, Void paramVoid) {
        if (this.c) {
            Toast.makeText(paramFrameEditorActivity, 2131689606, 0).show();
            return;
        }
        this.d.putExtra("tmp.image.path", this.b);
        paramFrameEditorActivity.startActivityForResult(this.d, this.e);
    }

    protected void b(FrameEditorActivity paramFrameEditorActivity) {
        super.onFinished(paramFrameEditorActivity);
        paramFrameEditorActivity.t();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */