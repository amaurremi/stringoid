package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter
  extends TypeAdapter<Date>
{
  public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory()
  {
    public <T> TypeAdapter<T> create(Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
    {
      if (paramAnonymousTypeToken.getRawType() == Date.class) {
        return new SqlDateTypeAdapter();
      }
      return null;
    }
  };
  private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");
  
  /* Error */
  public Date read(com.millennialmedia.google.gson.stream.JsonReader paramJsonReader)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 45	com/millennialmedia/google/gson/stream/JsonReader:peek	()Lcom/millennialmedia/google/gson/stream/JsonToken;
    //   6: getstatic 51	com/millennialmedia/google/gson/stream/JsonToken:NULL	Lcom/millennialmedia/google/gson/stream/JsonToken;
    //   9: if_acmpne +13 -> 22
    //   12: aload_1
    //   13: invokevirtual 54	com/millennialmedia/google/gson/stream/JsonReader:nextNull	()V
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: new 56	java/sql/Date
    //   25: dup
    //   26: aload_0
    //   27: getfield 29	com/millennialmedia/google/gson/internal/bind/SqlDateTypeAdapter:format	Ljava/text/DateFormat;
    //   30: aload_1
    //   31: invokevirtual 60	com/millennialmedia/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
    //   34: invokevirtual 66	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: invokevirtual 72	java/util/Date:getTime	()J
    //   40: invokespecial 75	java/sql/Date:<init>	(J)V
    //   43: astore_1
    //   44: goto -26 -> 18
    //   47: astore_1
    //   48: new 77	com/millennialmedia/google/gson/JsonSyntaxException
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 80	com/millennialmedia/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   56: athrow
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	SqlDateTypeAdapter
    //   0	62	1	paramJsonReader	com.millennialmedia.google.gson.stream.JsonReader
    // Exception table:
    //   from	to	target	type
    //   22	44	47	java/text/ParseException
    //   2	16	57	finally
    //   22	44	57	finally
    //   48	57	57	finally
  }
  
  public void write(JsonWriter paramJsonWriter, Date paramDate)
    throws IOException
  {
    if (paramDate == null) {}
    for (paramDate = null;; paramDate = this.format.format(paramDate)) {
      try
      {
        paramJsonWriter.value(paramDate);
        return;
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/google/gson/internal/bind/SqlDateTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */