package com.ideashower.readitlater.db.operation;

import android.database.sqlite.SQLiteDatabase;
import com.ideashower.readitlater.e.s;
import com.ideashower.readitlater.util.l;
import com.pocket.c.ah;
import java.io.InputStream;
import java.util.ArrayList;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class t
  extends b
{
  private final InputStream e;
  private final ArrayList p;
  private final ArrayList q;
  private Throwable r;
  private String s;
  
  public t(ah paramah, ArrayList paramArrayList1, ArrayList paramArrayList2, InputStream paramInputStream)
  {
    this.e = paramInputStream;
    this.p = paramArrayList1;
    this.q = paramArrayList2;
  }
  
  private void z()
  {
    JsonParser localJsonParser = l.d().createJsonParser(this.s);
    localJsonParser.nextToken();
    while ((localJsonParser.nextToken() != JsonToken.END_OBJECT) && (!localJsonParser.isClosed()))
    {
      Object localObject1 = localJsonParser.getCurrentName();
      localJsonParser.nextToken();
      if ("status".equals(localObject1))
      {
        if (localJsonParser.getValueAsInt() == 1) {}
      }
      else
      {
        if ("action_results".equals(localObject1))
        {
          localObject1 = new s();
          Object[] arrayOfObject = f(1);
          int i = 0;
          label86:
          Object localObject2;
          if ((localJsonParser.nextToken() != JsonToken.END_ARRAY) && (!localJsonParser.isClosed()))
          {
            localObject2 = ((JsonNode)this.q.get(i)).get("action").getTextValue();
            if ((localJsonParser.getCurrentToken() != JsonToken.VALUE_FALSE) && (localJsonParser.getCurrentToken() != JsonToken.VALUE_NULL)) {
              break label174;
            }
          }
          label174:
          label417:
          do
          {
            for (;;)
            {
              arrayOfObject[0] = this.p.get(i);
              this.h.execSQL("DELETE FROM sync_queue WHERE rowid = ?", arrayOfObject);
              i += 1;
              break label86;
              break;
              if (("add".equals(localObject2)) || ("readd".equals(localObject2)))
              {
                if (localJsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                  e(s.a(localJsonParser, (s)localObject1), true);
                } else if (localJsonParser.getCurrentToken() != JsonToken.VALUE_TRUE) {
                  throw new JsonParseException("Expecting item data in response to add, but response is not an object.  Token is " + localJsonParser.getCurrentToken().name(), localJsonParser.getCurrentLocation());
                }
              }
              else
              {
                if (!"shared_to".equals(localObject2)) {
                  break label417;
                }
                while ((localJsonParser.nextToken() != JsonToken.END_OBJECT) && (!localJsonParser.isClosed()))
                {
                  localObject2 = localJsonParser.getCurrentName();
                  localJsonParser.nextToken();
                  if (((String)localObject2).equals("to_friends"))
                  {
                    localObject2 = new g();
                    while ((localJsonParser.nextToken() != JsonToken.END_ARRAY) && (!localJsonParser.isClosed())) {
                      if (((g)localObject2).a(localJsonParser)) {
                        k().a(((g)localObject2).b, ((g)localObject2).a, ((g)localObject2).c, ((g)localObject2).e, ((g)localObject2).d, this.h);
                      }
                    }
                  }
                  else if (((String)localObject2).equals("item"))
                  {
                    e(s.a(localJsonParser, (s)localObject1), true);
                  }
                  else
                  {
                    localJsonParser.skipChildren();
                  }
                }
              }
            }
          } while (localJsonParser.getCurrentToken() == JsonToken.VALUE_TRUE);
          throw new JsonParseException("Unexpected value, must be boolean or object", localJsonParser.getCurrentLocation());
        }
        localJsonParser.skipChildren();
      }
    }
    localJsonParser.close();
  }
  
  /* Error */
  protected void c_()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 20	com/ideashower/readitlater/db/operation/t:e	Ljava/io/InputStream;
    //   5: ldc -46
    //   7: invokestatic 216	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   10: invokestatic 221	org/apache/a/b/d:a	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   13: putfield 34	com/ideashower/readitlater/db/operation/t:s	Ljava/lang/String;
    //   16: aload_0
    //   17: invokespecial 223	com/ideashower/readitlater/db/operation/t:z	()V
    //   20: aload_0
    //   21: invokevirtual 226	com/ideashower/readitlater/db/operation/t:m	()I
    //   24: invokestatic 231	com/pocket/c/e:b	(I)V
    //   27: return
    //   28: astore_1
    //   29: aload_0
    //   30: aload_1
    //   31: putfield 233	com/ideashower/readitlater/db/operation/t:r	Ljava/lang/Throwable;
    //   34: new 235	java/lang/RuntimeException
    //   37: dup
    //   38: ldc -19
    //   40: aload_1
    //   41: invokespecial 240	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: athrow
    //   45: astore_1
    //   46: aload_0
    //   47: aload_1
    //   48: putfield 233	com/ideashower/readitlater/db/operation/t:r	Ljava/lang/Throwable;
    //   51: new 235	java/lang/RuntimeException
    //   54: dup
    //   55: ldc -19
    //   57: aload_1
    //   58: invokespecial 240	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	t
    //   28	13	1	localThrowable1	Throwable
    //   45	13	1	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	16	28	java/lang/Throwable
    //   16	20	45	java/lang/Throwable
  }
  
  public Throwable e()
  {
    return this.r;
  }
  
  public String g()
  {
    return this.s;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */