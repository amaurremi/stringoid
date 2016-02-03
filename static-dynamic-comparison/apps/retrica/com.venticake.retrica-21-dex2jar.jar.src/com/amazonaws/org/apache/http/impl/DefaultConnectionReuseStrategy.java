package com.amazonaws.org.apache.http.impl;

import com.amazonaws.org.apache.http.ConnectionReuseStrategy;
import com.amazonaws.org.apache.http.HeaderIterator;
import com.amazonaws.org.apache.http.TokenIterator;
import com.amazonaws.org.apache.http.message.BasicTokenIterator;
import org.apache.http.annotation.Immutable;

@Immutable
public class DefaultConnectionReuseStrategy
  implements ConnectionReuseStrategy
{
  protected TokenIterator createTokenIterator(HeaderIterator paramHeaderIterator)
  {
    return new BasicTokenIterator(paramHeaderIterator);
  }
  
  /* Error */
  public boolean keepAlive(com.amazonaws.org.apache.http.HttpResponse paramHttpResponse, com.amazonaws.org.apache.http.protocol.HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_1
    //   4: ifnonnull +13 -> 17
    //   7: new 27	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 29
    //   13: invokespecial 32	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_2
    //   18: ifnonnull +13 -> 31
    //   21: new 27	java/lang/IllegalArgumentException
    //   24: dup
    //   25: ldc 34
    //   27: invokespecial 32	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   30: athrow
    //   31: aload_1
    //   32: invokeinterface 40 1 0
    //   37: invokeinterface 46 1 0
    //   42: astore 7
    //   44: aload_1
    //   45: ldc 48
    //   47: invokeinterface 52 2 0
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +19 -> 73
    //   57: ldc 54
    //   59: aload_2
    //   60: invokeinterface 60 1 0
    //   65: invokevirtual 66	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   68: ifne +42 -> 110
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_1
    //   74: ldc 68
    //   76: invokeinterface 72 2 0
    //   81: astore_2
    //   82: aload_2
    //   83: ifnull -12 -> 71
    //   86: aload_2
    //   87: arraylength
    //   88: iconst_1
    //   89: if_icmpne -18 -> 71
    //   92: aload_2
    //   93: iconst_0
    //   94: aaload
    //   95: astore_2
    //   96: aload_2
    //   97: invokeinterface 60 1 0
    //   102: invokestatic 78	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   105: istore_3
    //   106: iload_3
    //   107: iflt -36 -> 71
    //   110: aload_1
    //   111: ldc 80
    //   113: invokeinterface 84 2 0
    //   118: astore 6
    //   120: aload 6
    //   122: astore_2
    //   123: aload 6
    //   125: invokeinterface 90 1 0
    //   130: ifne +12 -> 142
    //   133: aload_1
    //   134: ldc 92
    //   136: invokeinterface 84 2 0
    //   141: astore_2
    //   142: aload_2
    //   143: invokeinterface 90 1 0
    //   148: ifeq +60 -> 208
    //   151: aload_0
    //   152: aload_2
    //   153: invokevirtual 94	com/amazonaws/org/apache/http/impl/DefaultConnectionReuseStrategy:createTokenIterator	(Lcom/amazonaws/org/apache/http/HeaderIterator;)Lcom/amazonaws/org/apache/http/TokenIterator;
    //   156: astore_1
    //   157: iconst_0
    //   158: istore_3
    //   159: aload_1
    //   160: invokeinterface 97 1 0
    //   165: ifeq +37 -> 202
    //   168: aload_1
    //   169: invokeinterface 100 1 0
    //   174: astore_2
    //   175: ldc 102
    //   177: aload_2
    //   178: invokevirtual 66	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   181: ifne -110 -> 71
    //   184: ldc 104
    //   186: aload_2
    //   187: invokevirtual 66	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   190: istore 5
    //   192: iload 5
    //   194: ifeq -35 -> 159
    //   197: iconst_1
    //   198: istore_3
    //   199: goto -40 -> 159
    //   202: iload_3
    //   203: ifeq +5 -> 208
    //   206: iconst_1
    //   207: ireturn
    //   208: aload 7
    //   210: getstatic 110	com/amazonaws/org/apache/http/HttpVersion:HTTP_1_0	Lcom/amazonaws/org/apache/http/HttpVersion;
    //   213: invokevirtual 116	com/amazonaws/org/apache/http/ProtocolVersion:lessEquals	(Lcom/amazonaws/org/apache/http/ProtocolVersion;)Z
    //   216: ifne +6 -> 222
    //   219: iload 4
    //   221: ireturn
    //   222: iconst_0
    //   223: istore 4
    //   225: goto -6 -> 219
    //   228: astore_1
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_1
    //   232: iconst_0
    //   233: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	DefaultConnectionReuseStrategy
    //   0	234	1	paramHttpResponse	com.amazonaws.org.apache.http.HttpResponse
    //   0	234	2	paramHttpContext	com.amazonaws.org.apache.http.protocol.HttpContext
    //   105	98	3	i	int
    //   1	223	4	bool1	boolean
    //   190	3	5	bool2	boolean
    //   118	6	6	localHeaderIterator	HeaderIterator
    //   42	167	7	localProtocolVersion	com.amazonaws.org.apache.http.ProtocolVersion
    // Exception table:
    //   from	to	target	type
    //   151	157	228	com/amazonaws/org/apache/http/ParseException
    //   159	192	228	com/amazonaws/org/apache/http/ParseException
    //   96	106	231	java/lang/NumberFormatException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/DefaultConnectionReuseStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */