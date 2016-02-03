package com.everimaging.fotorsdk.editor;

import android.content.Context;
import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.editor.filter.params.MosaicParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapCacheManager;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class b {
    private static final String a = b.class.getSimpleName();
    private static FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private BitmapCacheManager c;
    private LinkedList<a> d;
    private LinkedList<a> e;
    private b f;
    private Context g;
    private boolean h;

    public b(Context paramContext, boolean paramBoolean) {
        this.g = paramContext;
        this.c = BitmapCacheManager.getInstance(paramContext);
        this.d = new LinkedList();
        this.e = new LinkedList();
        this.h = paramBoolean;
    }

    private void b(a parama) {
        parama.b = new WeakReference(this.c.loadBitmap(parama.a));
    }

    /* Error */
    public a a() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: invokevirtual 89	com/everimaging/fotorsdk/editor/b:c	()Z
        //   6: ifeq +104 -> 110
        //   9: aload_0
        //   10: getfield 67	com/everimaging/fotorsdk/editor/b:d	Ljava/util/LinkedList;
        //   13: invokevirtual 93	java/util/LinkedList:removeLast	()Ljava/lang/Object;
        //   16: checkcast 6	com/everimaging/fotorsdk/editor/b$a
        //   19: astore_1
        //   20: aload_0
        //   21: getfield 69	com/everimaging/fotorsdk/editor/b:e	Ljava/util/LinkedList;
        //   24: aload_1
        //   25: invokevirtual 96	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
        //   28: aload_0
        //   29: getfield 67	com/everimaging/fotorsdk/editor/b:d	Ljava/util/LinkedList;
        //   32: invokevirtual 99	java/util/LinkedList:getLast	()Ljava/lang/Object;
        //   35: checkcast 6	com/everimaging/fotorsdk/editor/b$a
        //   38: astore_2
        //   39: aload_0
        //   40: aload_2
        //   41: invokespecial 101	com/everimaging/fotorsdk/editor/b:b	(Lcom/everimaging/fotorsdk/editor/b$a;)V
        //   44: getstatic 47	com/everimaging/fotorsdk/editor/b:b	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   47: iconst_1
        //   48: anewarray 4	java/lang/Object
        //   51: dup
        //   52: iconst_0
        //   53: new 103	java/lang/StringBuilder
        //   56: dup
        //   57: invokespecial 104	java/lang/StringBuilder:<init>	()V
        //   60: ldc 106
        //   62: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   65: aload_2
        //   66: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   69: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   72: aastore
        //   73: invokeinterface 121 2 0
        //   78: aload_2
        //   79: astore_1
        //   80: aload_0
        //   81: getfield 123	com/everimaging/fotorsdk/editor/b:f	Lcom/everimaging/fotorsdk/editor/b$b;
        //   84: ifnull +22 -> 106
        //   87: aload_0
        //   88: getfield 123	com/everimaging/fotorsdk/editor/b:f	Lcom/everimaging/fotorsdk/editor/b$b;
        //   91: aload_0
        //   92: invokevirtual 89	com/everimaging/fotorsdk/editor/b:c	()Z
        //   95: aload_0
        //   96: invokevirtual 125	com/everimaging/fotorsdk/editor/b:d	()Z
        //   99: invokeinterface 128 3 0
        //   104: aload_2
        //   105: astore_1
        //   106: aload_0
        //   107: monitorexit
        //   108: aload_1
        //   109: areturn
        //   110: aconst_null
        //   111: astore_1
        //   112: goto -6 -> 106
        //   115: astore_1
        //   116: aload_0
        //   117: monitorexit
        //   118: aload_1
        //   119: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	120	0	this	b
        //   19	93	1	localObject1	Object
        //   115	4	1	localObject2	Object
        //   38	67	2	locala	a
        // Exception table:
        //   from	to	target	type
        //   2	78	115	finally
        //   80	104	115	finally
    }

    /* Error */
    public a a(int paramInt) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 67	com/everimaging/fotorsdk/editor/b:d	Ljava/util/LinkedList;
        //   6: astore_3
        //   7: aload_3
        //   8: monitorenter
        //   9: aload_0
        //   10: invokevirtual 89	com/everimaging/fotorsdk/editor/b:c	()Z
        //   13: ifeq +41 -> 54
        //   16: iload_1
        //   17: aload_0
        //   18: getfield 67	com/everimaging/fotorsdk/editor/b:d	Ljava/util/LinkedList;
        //   21: invokevirtual 133	java/util/LinkedList:size	()I
        //   24: if_icmpge +30 -> 54
        //   27: iload_1
        //   28: iflt +26 -> 54
        //   31: aload_0
        //   32: getfield 67	com/everimaging/fotorsdk/editor/b:d	Ljava/util/LinkedList;
        //   35: iload_1
        //   36: invokevirtual 137	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   39: checkcast 6	com/everimaging/fotorsdk/editor/b$a
        //   42: astore_2
        //   43: aload_0
        //   44: aload_2
        //   45: invokespecial 101	com/everimaging/fotorsdk/editor/b:b	(Lcom/everimaging/fotorsdk/editor/b$a;)V
        //   48: aload_3
        //   49: monitorexit
        //   50: aload_0
        //   51: monitorexit
        //   52: aload_2
        //   53: areturn
        //   54: aconst_null
        //   55: astore_2
        //   56: aload_3
        //   57: monitorexit
        //   58: goto -8 -> 50
        //   61: astore_2
        //   62: aload_3
        //   63: monitorexit
        //   64: aload_2
        //   65: athrow
        //   66: astore_2
        //   67: aload_0
        //   68: monitorexit
        //   69: aload_2
        //   70: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	71	0	this	b
        //   0	71	1	paramInt	int
        //   42	14	2	locala	a
        //   61	4	2	localObject1	Object
        //   66	4	2	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   9	27	61	finally
        //   31	50	61	finally
        //   56	58	61	finally
        //   62	64	61	finally
        //   2	9	66	finally
        //   64	66	66	finally
    }

    public void a(a parama) {
        for (; ; ) {
            int i;
            try {
                b.b(new Object[]{"addStep:" + parama});
                this.d.add(parama);
                this.c.addBitmap(parama.a, (Bitmap) parama.b.get());
                parama.b.clear();
                parama = this.e.iterator();
                if (parama.hasNext()) {
                    Object localObject = (a) parama.next();
                    this.c.removeBitmap(((a) localObject).a);
                    File localFile = new File(((a) localObject).a);
                    b.f(new Object[]{"delete file:" + ((a) localObject).a});
                    if (localFile.exists()) {
                        localFile.delete();
                    }
                    if (((a) localObject).c == null) {
                        continue;
                    }
                    localObject = ((a) localObject).c;
                    int j = localObject.length;
                    i = 0;
                    if (i >= j) {
                        continue;
                    }
                    localFile = localObject[i];
                    if ((localFile instanceof MosaicParams)) {
                        ((MosaicParams) localFile).deleteMaskCache();
                    }
                } else {
                    this.e.clear();
                    if (this.f != null) {
                        this.f.a(c(), d());
                    }
                    return;
                }
            } finally {
            }
            i += 1;
        }
    }

    public void a(b paramb) {
        this.f = paramb;
    }

    /* Error */
    public a b() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: invokevirtual 125	com/everimaging/fotorsdk/editor/b:d	()Z
        //   6: ifeq +93 -> 99
        //   9: aload_0
        //   10: getfield 69	com/everimaging/fotorsdk/editor/b:e	Ljava/util/LinkedList;
        //   13: invokevirtual 93	java/util/LinkedList:removeLast	()Ljava/lang/Object;
        //   16: checkcast 6	com/everimaging/fotorsdk/editor/b$a
        //   19: astore_2
        //   20: aload_0
        //   21: aload_2
        //   22: invokespecial 101	com/everimaging/fotorsdk/editor/b:b	(Lcom/everimaging/fotorsdk/editor/b$a;)V
        //   25: aload_0
        //   26: getfield 67	com/everimaging/fotorsdk/editor/b:d	Ljava/util/LinkedList;
        //   29: aload_2
        //   30: invokevirtual 96	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
        //   33: getstatic 47	com/everimaging/fotorsdk/editor/b:b	Lcom/everimaging/fotorsdk/log/FotorLoggerFactory$c;
        //   36: iconst_1
        //   37: anewarray 4	java/lang/Object
        //   40: dup
        //   41: iconst_0
        //   42: new 103	java/lang/StringBuilder
        //   45: dup
        //   46: invokespecial 104	java/lang/StringBuilder:<init>	()V
        //   49: ldc -60
        //   51: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   54: aload_2
        //   55: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   58: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   61: aastore
        //   62: invokeinterface 121 2 0
        //   67: aload_2
        //   68: astore_1
        //   69: aload_0
        //   70: getfield 123	com/everimaging/fotorsdk/editor/b:f	Lcom/everimaging/fotorsdk/editor/b$b;
        //   73: ifnull +22 -> 95
        //   76: aload_0
        //   77: getfield 123	com/everimaging/fotorsdk/editor/b:f	Lcom/everimaging/fotorsdk/editor/b$b;
        //   80: aload_0
        //   81: invokevirtual 89	com/everimaging/fotorsdk/editor/b:c	()Z
        //   84: aload_0
        //   85: invokevirtual 125	com/everimaging/fotorsdk/editor/b:d	()Z
        //   88: invokeinterface 128 3 0
        //   93: aload_2
        //   94: astore_1
        //   95: aload_0
        //   96: monitorexit
        //   97: aload_1
        //   98: areturn
        //   99: aconst_null
        //   100: astore_1
        //   101: goto -6 -> 95
        //   104: astore_1
        //   105: aload_0
        //   106: monitorexit
        //   107: aload_1
        //   108: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	109	0	this	b
        //   68	33	1	locala1	a
        //   104	4	1	localObject	Object
        //   19	75	2	locala2	a
        // Exception table:
        //   from	to	target	type
        //   2	67	104	finally
        //   69	93	104	finally
    }

    /* Error */
    public boolean c() {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: aload_0
        //   3: monitorenter
        //   4: aload_0
        //   5: getfield 67	com/everimaging/fotorsdk/editor/b:d	Ljava/util/LinkedList;
        //   8: invokevirtual 133	java/util/LinkedList:size	()I
        //   11: istore_1
        //   12: iload_1
        //   13: iconst_1
        //   14: if_icmple +7 -> 21
        //   17: aload_0
        //   18: monitorexit
        //   19: iload_2
        //   20: ireturn
        //   21: iconst_0
        //   22: istore_2
        //   23: goto -6 -> 17
        //   26: astore_3
        //   27: aload_0
        //   28: monitorexit
        //   29: aload_3
        //   30: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	31	0	this	b
        //   11	4	1	i	int
        //   1	22	2	bool	boolean
        //   26	4	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   4	12	26	finally
    }

    /* Error */
    public boolean d() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 69	com/everimaging/fotorsdk/editor/b:e	Ljava/util/LinkedList;
        //   6: invokevirtual 133	java/util/LinkedList:size	()I
        //   9: istore_1
        //   10: iload_1
        //   11: ifle +9 -> 20
        //   14: iconst_1
        //   15: istore_2
        //   16: aload_0
        //   17: monitorexit
        //   18: iload_2
        //   19: ireturn
        //   20: iconst_0
        //   21: istore_2
        //   22: goto -6 -> 16
        //   25: astore_3
        //   26: aload_0
        //   27: monitorexit
        //   28: aload_3
        //   29: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	30	0	this	b
        //   9	2	1	i	int
        //   15	7	2	bool	boolean
        //   25	4	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	10	25	finally
    }

    public LinkedList<a> e() {
        synchronized (this.d) {
            LinkedList localLinkedList2 = this.d;
            return localLinkedList2;
        }
    }

    public static class a {
        public String a;
        public WeakReference<Bitmap> b;
        public BaseParams[] c;

        public String toString() {
            return String.format("bitmapPath:%s,bitmap:" + this.b, new Object[]{this.a});
        }
    }

    public static abstract interface b {
        public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */