package com.google.gson.internal.a;

import com.google.gson.b.a;
import com.google.gson.d;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.stream.b;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class k
  extends m<Date>
{
  public static final n afz = new n()
  {
    public <T> m<T> a(d paramAnonymousd, a<T> paramAnonymousa)
    {
      if (paramAnonymousa.zZ() == Date.class) {
        return new k();
      }
      return null;
    }
  };
  private final DateFormat agf = new SimpleDateFormat("MMM d, yyyy");
  
  public void a(b paramb, Date paramDate)
  {
    if (paramDate == null) {}
    for (paramDate = null;; paramDate = this.agf.format(paramDate)) {
      try
      {
        paramb.cM(paramDate);
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  public Date k(com.google.gson.stream.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 62	com/google/gson/stream/a:zN	()Lcom/google/gson/stream/JsonToken;
    //   6: getstatic 68	com/google/gson/stream/JsonToken:ahQ	Lcom/google/gson/stream/JsonToken;
    //   9: if_acmpne +13 -> 22
    //   12: aload_1
    //   13: invokevirtual 71	com/google/gson/stream/a:nextNull	()V
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: new 33	java/sql/Date
    //   25: dup
    //   26: aload_0
    //   27: getfield 29	com/google/gson/internal/a/k:agf	Ljava/text/DateFormat;
    //   30: aload_1
    //   31: invokevirtual 75	com/google/gson/stream/a:nextString	()Ljava/lang/String;
    //   34: invokevirtual 79	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: invokevirtual 85	java/util/Date:getTime	()J
    //   40: invokespecial 88	java/sql/Date:<init>	(J)V
    //   43: astore_1
    //   44: goto -26 -> 18
    //   47: astore_1
    //   48: new 90	com/google/gson/JsonSyntaxException
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 93	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   56: athrow
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	k
    //   0	62	1	parama	com.google.gson.stream.a
    // Exception table:
    //   from	to	target	type
    //   22	44	47	java/text/ParseException
    //   2	16	57	finally
    //   22	44	57	finally
    //   48	57	57	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */