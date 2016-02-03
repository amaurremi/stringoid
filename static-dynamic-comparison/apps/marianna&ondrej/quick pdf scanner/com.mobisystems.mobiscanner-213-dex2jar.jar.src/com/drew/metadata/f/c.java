package com.drew.metadata.f;

public class c
{
  /* Error */
  public void a(com.drew.lang.a parama, com.drew.metadata.d paramd)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_2
    //   4: ldc 15
    //   6: invokevirtual 20	com/drew/metadata/d:a	(Ljava/lang/Class;)Lcom/drew/metadata/b;
    //   9: checkcast 15	com/drew/metadata/f/b
    //   12: astore 11
    //   14: aload_1
    //   15: iconst_0
    //   16: bipush 13
    //   18: invokeinterface 26 3 0
    //   23: ldc 28
    //   25: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: istore 6
    //   30: iload 6
    //   32: ifeq +7 -> 39
    //   35: bipush 14
    //   37: istore 4
    //   39: iload 4
    //   41: i2l
    //   42: aload_1
    //   43: invokeinterface 38 1 0
    //   48: lcmp
    //   49: ifge +64 -> 113
    //   52: iload 4
    //   54: iconst_4
    //   55: iadd
    //   56: istore_3
    //   57: aload_1
    //   58: iload_3
    //   59: invokeinterface 42 2 0
    //   64: istore 5
    //   66: iload_3
    //   67: iconst_2
    //   68: iadd
    //   69: istore 4
    //   71: aload_1
    //   72: iload 4
    //   74: invokeinterface 42 2 0
    //   79: istore_3
    //   80: iload 4
    //   82: iconst_2
    //   83: iadd
    //   84: istore 4
    //   86: iload_3
    //   87: iflt +26 -> 113
    //   90: iload_3
    //   91: iload 4
    //   93: iadd
    //   94: i2l
    //   95: lstore 7
    //   97: aload_1
    //   98: invokeinterface 38 1 0
    //   103: lstore 9
    //   105: lload 7
    //   107: lload 9
    //   109: lcmp
    //   110: ifle +13 -> 123
    //   113: return
    //   114: astore_1
    //   115: aload 11
    //   117: ldc 44
    //   119: invokevirtual 48	com/drew/metadata/f/b:c	(Ljava/lang/String;)V
    //   122: return
    //   123: iload 4
    //   125: iload_3
    //   126: iadd
    //   127: istore 4
    //   129: iload 4
    //   131: istore_3
    //   132: iload 4
    //   134: iconst_2
    //   135: irem
    //   136: ifeq +8 -> 144
    //   139: iload 4
    //   141: iconst_1
    //   142: iadd
    //   143: istore_3
    //   144: aload_1
    //   145: iload_3
    //   146: invokeinterface 51 2 0
    //   151: istore 4
    //   153: iload_3
    //   154: iconst_4
    //   155: iadd
    //   156: istore_3
    //   157: aload_1
    //   158: iload_3
    //   159: iload 4
    //   161: invokeinterface 55 3 0
    //   166: astore 12
    //   168: iload_3
    //   169: iload 4
    //   171: iadd
    //   172: istore 4
    //   174: iload 4
    //   176: istore_3
    //   177: iload 4
    //   179: iconst_2
    //   180: irem
    //   181: ifeq +8 -> 189
    //   184: iload 4
    //   186: iconst_1
    //   187: iadd
    //   188: istore_3
    //   189: aload 11
    //   191: iload 5
    //   193: aload 12
    //   195: invokevirtual 58	com/drew/metadata/f/b:a	(I[B)V
    //   198: iload 5
    //   200: sipush 1028
    //   203: if_icmpne +23 -> 226
    //   206: new 60	com/drew/metadata/d/c
    //   209: dup
    //   210: invokespecial 61	com/drew/metadata/d/c:<init>	()V
    //   213: new 63	com/drew/lang/b
    //   216: dup
    //   217: aload 12
    //   219: invokespecial 66	com/drew/lang/b:<init>	([B)V
    //   222: aload_2
    //   223: invokevirtual 68	com/drew/metadata/d/c:a	(Lcom/drew/lang/a;Lcom/drew/metadata/d;)V
    //   226: iload_3
    //   227: istore 4
    //   229: iload 5
    //   231: sipush 4000
    //   234: if_icmplt -195 -> 39
    //   237: iload_3
    //   238: istore 4
    //   240: iload 5
    //   242: sipush 4999
    //   245: if_icmpgt -206 -> 39
    //   248: getstatic 72	com/drew/metadata/f/b:gb	Ljava/util/HashMap;
    //   251: iload 5
    //   253: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: ldc 80
    //   258: iconst_1
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: iload 5
    //   266: sipush 4000
    //   269: isub
    //   270: iconst_1
    //   271: iadd
    //   272: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: aastore
    //   276: invokestatic 84	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokevirtual 90	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: iload_3
    //   284: istore 4
    //   286: goto -247 -> 39
    //   289: astore_1
    //   290: aload 11
    //   292: aload_1
    //   293: invokevirtual 94	com/drew/lang/BufferBoundsException:getMessage	()Ljava/lang/String;
    //   296: invokevirtual 48	com/drew/metadata/f/b:c	(Ljava/lang/String;)V
    //   299: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	c
    //   0	300	1	parama	com.drew.lang.a
    //   0	300	2	paramd	com.drew.metadata.d
    //   56	228	3	i	int
    //   1	284	4	j	int
    //   64	206	5	k	int
    //   28	3	6	bool	boolean
    //   95	11	7	l1	long
    //   103	5	9	l2	long
    //   12	279	11	localb	b
    //   166	52	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	30	114	com/drew/lang/BufferBoundsException
    //   57	66	289	com/drew/lang/BufferBoundsException
    //   71	80	289	com/drew/lang/BufferBoundsException
    //   97	105	289	com/drew/lang/BufferBoundsException
    //   144	153	289	com/drew/lang/BufferBoundsException
    //   157	168	289	com/drew/lang/BufferBoundsException
    //   189	198	289	com/drew/lang/BufferBoundsException
    //   206	226	289	com/drew/lang/BufferBoundsException
    //   248	283	289	com/drew/lang/BufferBoundsException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */