package com.amazonaws.handlers;

import java.util.List;

public class HandlerChainFactory
{
  /* Error */
  private List<RequestHandler2> createRequestHandlerChain(String paramString, Class<?> paramClass)
  {
    // Byte code:
    //   0: new 17	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 18	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: invokevirtual 22	java/lang/Object:getClass	()Ljava/lang/Class;
    //   13: aload_1
    //   14: invokevirtual 28	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +18 -> 37
    //   22: iconst_0
    //   23: ifeq +11 -> 34
    //   26: new 30	java/lang/NullPointerException
    //   29: dup
    //   30: invokespecial 31	java/lang/NullPointerException:<init>	()V
    //   33: athrow
    //   34: aload 4
    //   36: areturn
    //   37: new 33	java/io/BufferedReader
    //   40: dup
    //   41: new 35	java/io/InputStreamReader
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 38	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_3
    //   53: aload_3
    //   54: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnonnull +14 -> 73
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 48	java/io/BufferedReader:close	()V
    //   70: aload 4
    //   72: areturn
    //   73: aload_1
    //   74: invokevirtual 53	java/lang/String:trim	()Ljava/lang/String;
    //   77: astore 5
    //   79: aload 5
    //   81: ldc 55
    //   83: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifne -33 -> 53
    //   89: aload 5
    //   91: iconst_2
    //   92: anewarray 24	java/lang/Class
    //   95: dup
    //   96: iconst_0
    //   97: aload_2
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: aload_0
    //   102: invokevirtual 22	java/lang/Object:getClass	()Ljava/lang/Class;
    //   105: aastore
    //   106: invokestatic 65	com/amazonaws/util/ClassLoaderHelper:loadClass	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/Class;
    //   109: invokevirtual 69	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   112: astore_1
    //   113: aload_2
    //   114: aload_1
    //   115: invokevirtual 72	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   118: ifeq +105 -> 223
    //   121: aload_2
    //   122: ldc 74
    //   124: if_acmpne +67 -> 191
    //   127: aload 4
    //   129: aload_1
    //   130: checkcast 74	com/amazonaws/handlers/RequestHandler2
    //   133: invokeinterface 79 2 0
    //   138: pop
    //   139: goto -86 -> 53
    //   142: astore_2
    //   143: aload_3
    //   144: astore_1
    //   145: new 81	com/amazonaws/AmazonClientException
    //   148: dup
    //   149: new 83	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   156: ldc 86
    //   158: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_2
    //   162: invokevirtual 93	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aload_2
    //   172: invokespecial 99	com/amazonaws/AmazonClientException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: athrow
    //   176: astore_3
    //   177: aload_1
    //   178: astore_2
    //   179: aload_3
    //   180: astore_1
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 48	java/io/BufferedReader:close	()V
    //   189: aload_1
    //   190: athrow
    //   191: aload_2
    //   192: ldc 101
    //   194: if_acmpne +21 -> 215
    //   197: aload 4
    //   199: aload_1
    //   200: checkcast 101	com/amazonaws/handlers/RequestHandler
    //   203: invokestatic 105	com/amazonaws/handlers/RequestHandler2:adapt	(Lcom/amazonaws/handlers/RequestHandler;)Lcom/amazonaws/handlers/RequestHandler2;
    //   206: invokeinterface 79 2 0
    //   211: pop
    //   212: goto -159 -> 53
    //   215: new 107	java/lang/IllegalStateException
    //   218: dup
    //   219: invokespecial 108	java/lang/IllegalStateException:<init>	()V
    //   222: athrow
    //   223: new 81	com/amazonaws/AmazonClientException
    //   226: dup
    //   227: new 83	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   234: ldc 110
    //   236: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 5
    //   241: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 112
    //   246: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc 114
    //   251: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_2
    //   255: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   258: ldc 119
    //   260: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokespecial 122	com/amazonaws/AmazonClientException:<init>	(Ljava/lang/String;)V
    //   269: athrow
    //   270: astore_1
    //   271: goto -237 -> 34
    //   274: astore_1
    //   275: goto -205 -> 70
    //   278: astore_2
    //   279: goto -90 -> 189
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_2
    //   285: goto -104 -> 181
    //   288: astore_2
    //   289: aconst_null
    //   290: astore_1
    //   291: goto -146 -> 145
    //   294: astore_1
    //   295: aload_3
    //   296: astore_2
    //   297: goto -116 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	HandlerChainFactory
    //   0	300	1	paramString	String
    //   0	300	2	paramClass	Class<?>
    //   52	92	3	localBufferedReader	java.io.BufferedReader
    //   176	120	3	localObject	Object
    //   7	191	4	localArrayList	java.util.ArrayList
    //   77	163	5	str	String
    // Exception table:
    //   from	to	target	type
    //   53	58	142	java/lang/Exception
    //   73	121	142	java/lang/Exception
    //   127	139	142	java/lang/Exception
    //   197	212	142	java/lang/Exception
    //   215	223	142	java/lang/Exception
    //   223	270	142	java/lang/Exception
    //   145	176	176	finally
    //   26	34	270	java/io/IOException
    //   66	70	274	java/io/IOException
    //   185	189	278	java/io/IOException
    //   9	18	282	finally
    //   37	53	282	finally
    //   9	18	288	java/lang/Exception
    //   37	53	288	java/lang/Exception
    //   53	58	294	finally
    //   73	121	294	finally
    //   127	139	294	finally
    //   197	212	294	finally
    //   215	223	294	finally
    //   223	270	294	finally
  }
  
  public List<RequestHandler2> newRequestHandler2Chain(String paramString)
  {
    return createRequestHandlerChain(paramString, RequestHandler2.class);
  }
  
  public List<RequestHandler2> newRequestHandlerChain(String paramString)
  {
    return createRequestHandlerChain(paramString, RequestHandler.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/handlers/HandlerChainFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */