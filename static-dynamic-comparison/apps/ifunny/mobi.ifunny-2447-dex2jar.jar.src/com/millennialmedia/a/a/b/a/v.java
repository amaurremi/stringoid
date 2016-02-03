package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.d.d;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class v
        extends ae<Time> {
    public static final af a = new w();
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    /* Error */
    public Time a(com.millennialmedia.a.a.d.a parama) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: invokevirtual 38	com/millennialmedia/a/a/d/a:f	()Lcom/millennialmedia/a/a/d/c;
        //   6: getstatic 44	com/millennialmedia/a/a/d/c:i	Lcom/millennialmedia/a/a/d/c;
        //   9: if_acmpne +13 -> 22
        //   12: aload_1
        //   13: invokevirtual 47	com/millennialmedia/a/a/d/a:j	()V
        //   16: aconst_null
        //   17: astore_1
        //   18: aload_0
        //   19: monitorexit
        //   20: aload_1
        //   21: areturn
        //   22: new 49	java/sql/Time
        //   25: dup
        //   26: aload_0
        //   27: getfield 29	com/millennialmedia/a/a/b/a/v:b	Ljava/text/DateFormat;
        //   30: aload_1
        //   31: invokevirtual 53	com/millennialmedia/a/a/d/a:h	()Ljava/lang/String;
        //   34: invokevirtual 59	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
        //   37: invokevirtual 65	java/util/Date:getTime	()J
        //   40: invokespecial 68	java/sql/Time:<init>	(J)V
        //   43: astore_1
        //   44: goto -26 -> 18
        //   47: astore_1
        //   48: new 70	com/millennialmedia/a/a/aa
        //   51: dup
        //   52: aload_1
        //   53: invokespecial 73	com/millennialmedia/a/a/aa:<init>	(Ljava/lang/Throwable;)V
        //   56: athrow
        //   57: astore_1
        //   58: aload_0
        //   59: monitorexit
        //   60: aload_1
        //   61: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	62	0	this	v
        //   0	62	1	parama	com.millennialmedia.a.a.d.a
        // Exception table:
        //   from	to	target	type
        //   22	44	47	java/text/ParseException
        //   2	16	57	finally
        //   22	44	57	finally
        //   48	57	57	finally
    }

    public void a(d paramd, Time paramTime) {
        if (paramTime == null) {
        }
        for (paramTime = null; ; paramTime = this.b.format(paramTime)) {
            try {
                paramd.b(paramTime);
                return;
            } finally {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */