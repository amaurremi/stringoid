package com.ideashower.readitlater.a.a;

import com.ideashower.readitlater.g.g;

class c
  extends g
{
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 23	com/ideashower/readitlater/util/l:a	()Lorg/codehaus/jackson/map/ObjectMapper;
    //   5: astore_2
    //   6: new 25	java/io/File
    //   9: dup
    //   10: invokestatic 31	com/ideashower/readitlater/a/g:c	()Landroid/content/Context;
    //   13: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: ldc 39
    //   18: invokespecial 42	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 46	java/io/File:exists	()Z
    //   26: ifeq +182 -> 208
    //   29: aload_2
    //   30: aload_1
    //   31: invokestatic 51	org/apache/a/b/b:a	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   34: invokevirtual 57	org/codehaus/jackson/map/ObjectMapper:readTree	(Ljava/io/InputStream;)Lorg/codehaus/jackson/JsonNode;
    //   37: checkcast 59	org/codehaus/jackson/node/ObjectNode
    //   40: astore_1
    //   41: new 25	java/io/File
    //   44: dup
    //   45: invokestatic 31	com/ideashower/readitlater/a/g:c	()Landroid/content/Context;
    //   48: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   51: ldc 61
    //   53: invokespecial 42	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   56: astore 4
    //   58: aload 4
    //   60: invokevirtual 46	java/io/File:exists	()Z
    //   63: ifeq +140 -> 203
    //   66: aload_2
    //   67: aload 4
    //   69: invokestatic 51	org/apache/a/b/b:a	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   72: invokevirtual 57	org/codehaus/jackson/map/ObjectMapper:readTree	(Ljava/io/InputStream;)Lorg/codehaus/jackson/JsonNode;
    //   75: checkcast 59	org/codehaus/jackson/node/ObjectNode
    //   78: astore_2
    //   79: aload_1
    //   80: ifnull +89 -> 169
    //   83: aload_2
    //   84: ifnull +85 -> 169
    //   87: new 63	com/ideashower/readitlater/a/a/d
    //   90: dup
    //   91: aload_1
    //   92: aload_2
    //   93: invokestatic 69	com/ideashower/readitlater/a/a/a:f	()Landroid/content/SharedPreferences;
    //   96: invokespecial 72	com/ideashower/readitlater/a/a/d:<init>	(Lorg/codehaus/jackson/node/ObjectNode;Lorg/codehaus/jackson/node/ObjectNode;Landroid/content/SharedPreferences;)V
    //   99: astore_1
    //   100: invokestatic 75	com/ideashower/readitlater/a/a/a:g	()Z
    //   103: ifeq +58 -> 161
    //   106: aload_1
    //   107: invokestatic 78	com/ideashower/readitlater/a/a/a:a	(Lcom/ideashower/readitlater/a/a/d;)Lcom/ideashower/readitlater/a/a/d;
    //   110: pop
    //   111: invokestatic 82	com/ideashower/readitlater/a/a/a:h	()Ljava/lang/Object;
    //   114: astore_1
    //   115: aload_1
    //   116: monitorenter
    //   117: aconst_null
    //   118: invokestatic 85	com/ideashower/readitlater/a/a/a:a	(Lcom/ideashower/readitlater/g/g;)Lcom/ideashower/readitlater/g/g;
    //   121: pop
    //   122: aload_1
    //   123: monitorexit
    //   124: return
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_2
    //   129: invokestatic 90	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   132: aload_3
    //   133: astore_2
    //   134: goto -55 -> 79
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_2
    //   141: invokestatic 90	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   144: aload_3
    //   145: astore_2
    //   146: goto -67 -> 79
    //   149: astore_2
    //   150: aconst_null
    //   151: astore_1
    //   152: aload_2
    //   153: invokestatic 90	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   156: aload_3
    //   157: astore_2
    //   158: goto -79 -> 79
    //   161: aload_1
    //   162: invokestatic 93	com/ideashower/readitlater/a/a/a:b	(Lcom/ideashower/readitlater/a/a/d;)Lcom/ideashower/readitlater/a/a/d;
    //   165: pop
    //   166: goto -55 -> 111
    //   169: invokestatic 98	com/ideashower/readitlater/a/as:l	()Z
    //   172: ifeq -61 -> 111
    //   175: iconst_m1
    //   176: invokestatic 101	com/ideashower/readitlater/a/a/a:a	(I)Lcom/ideashower/readitlater/g/g;
    //   179: invokevirtual 105	com/ideashower/readitlater/g/g:d	()I
    //   182: pop
    //   183: goto -72 -> 111
    //   186: astore_2
    //   187: aload_1
    //   188: monitorexit
    //   189: aload_2
    //   190: athrow
    //   191: astore_2
    //   192: goto -40 -> 152
    //   195: astore_2
    //   196: goto -56 -> 140
    //   199: astore_2
    //   200: goto -72 -> 128
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -126 -> 79
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -169 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	c
    //   5	88	2	localObject2	Object
    //   125	4	2	localJsonParseException1	org.codehaus.jackson.JsonParseException
    //   133	1	2	localObject3	Object
    //   137	4	2	localJsonMappingException1	org.codehaus.jackson.map.JsonMappingException
    //   145	1	2	localObject4	Object
    //   149	4	2	localIOException1	java.io.IOException
    //   157	1	2	localObject5	Object
    //   186	4	2	localObject6	Object
    //   191	1	2	localIOException2	java.io.IOException
    //   195	1	2	localJsonMappingException2	org.codehaus.jackson.map.JsonMappingException
    //   199	1	2	localJsonParseException2	org.codehaus.jackson.JsonParseException
    //   204	1	2	localObject7	Object
    //   1	156	3	localObject8	Object
    //   56	12	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   2	41	125	org/codehaus/jackson/JsonParseException
    //   2	41	137	org/codehaus/jackson/map/JsonMappingException
    //   2	41	149	java/io/IOException
    //   117	124	186	finally
    //   187	189	186	finally
    //   41	79	191	java/io/IOException
    //   41	79	195	org/codehaus/jackson/map/JsonMappingException
    //   41	79	199	org/codehaus/jackson/JsonParseException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */