package com.vladium.emma.data;

import com.vladium.emma.Command;

public final class mergeCommand
  extends Command
{
  private String[] m_datapath;
  private String m_outFileName;
  
  public mergeCommand(String paramString, String[] paramArrayOfString)
  {
    super(paramString, paramArrayOfString);
  }
  
  protected void initialize()
  {
    super.initialize();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 30	com/vladium/util/ClassLoaderResolver:getClassLoader	()Ljava/lang/ClassLoader;
    //   5: astore_2
    //   6: aload_0
    //   7: aload_2
    //   8: invokevirtual 34	com/vladium/emma/data/mergeCommand:getOptParser	(Ljava/lang/ClassLoader;)Lcom/vladium/util/args/IOptsParser;
    //   11: astore 4
    //   13: aload 4
    //   15: aload_0
    //   16: getfield 37	com/vladium/emma/data/mergeCommand:m_args	[Ljava/lang/String;
    //   19: invokeinterface 43 2 0
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface 49 1 0
    //   31: istore_1
    //   32: iload_1
    //   33: ifle +26 -> 59
    //   36: aload_0
    //   37: aload 4
    //   39: iload_1
    //   40: aconst_null
    //   41: invokevirtual 53	com/vladium/emma/data/mergeCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_2
    //   48: aload_0
    //   49: invokevirtual 59	java/lang/Object:getClass	()Ljava/lang/Class;
    //   52: invokevirtual 62	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   55: astore_2
    //   56: goto -50 -> 6
    //   59: aload_2
    //   60: invokeinterface 66 1 0
    //   65: astore_3
    //   66: aload_3
    //   67: ifnonnull +46 -> 113
    //   70: aload_2
    //   71: aload_0
    //   72: getfield 70	com/vladium/emma/data/mergeCommand:m_out	Ljava/io/PrintWriter;
    //   75: bipush 80
    //   77: invokeinterface 74 3 0
    //   82: aload_0
    //   83: aload 4
    //   85: iconst_1
    //   86: aconst_null
    //   87: invokevirtual 53	com/vladium/emma/data/mergeCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   90: goto -46 -> 44
    //   93: astore_2
    //   94: aload_0
    //   95: iconst_1
    //   96: aload_2
    //   97: invokevirtual 78	com/vladium/emma/EMMARuntimeException:getMessage	()Ljava/lang/String;
    //   100: aload_2
    //   101: iconst_2
    //   102: invokevirtual 82	com/vladium/emma/data/mergeCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   105: goto -61 -> 44
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    //   113: iconst_0
    //   114: istore_1
    //   115: iload_1
    //   116: aload_3
    //   117: arraylength
    //   118: if_icmpge +101 -> 219
    //   121: aload_3
    //   122: iload_1
    //   123: aaload
    //   124: astore 4
    //   126: aload 4
    //   128: invokeinterface 87 1 0
    //   133: astore 5
    //   135: aload_0
    //   136: aload 4
    //   138: invokevirtual 91	com/vladium/emma/data/mergeCommand:processOpt	(Lcom/vladium/util/args/IOptsParser$IOpt;)Z
    //   141: ifne +139 -> 280
    //   144: ldc 93
    //   146: aload 5
    //   148: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +19 -> 170
    //   154: aload_0
    //   155: aload 4
    //   157: getstatic 102	com/vladium/emma/data/mergeCommand:PATH_DELIMITERS	Ljava/lang/String;
    //   160: iconst_1
    //   161: invokestatic 106	com/vladium/emma/data/mergeCommand:getListOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;Ljava/lang/String;Z)[Ljava/lang/String;
    //   164: putfield 108	com/vladium/emma/data/mergeCommand:m_datapath	[Ljava/lang/String;
    //   167: goto +113 -> 280
    //   170: ldc 110
    //   172: aload 5
    //   174: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   177: ifeq +103 -> 280
    //   180: aload_0
    //   181: aload 4
    //   183: invokeinterface 113 1 0
    //   188: putfield 115	com/vladium/emma/data/mergeCommand:m_outFileName	Ljava/lang/String;
    //   191: goto +89 -> 280
    //   194: astore_2
    //   195: new 22	com/vladium/emma/EMMARuntimeException
    //   198: dup
    //   199: ldc 117
    //   201: aload_2
    //   202: invokespecial 120	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: athrow
    //   206: astore_2
    //   207: aload_0
    //   208: iconst_1
    //   209: ldc 122
    //   211: aload_2
    //   212: iconst_2
    //   213: invokevirtual 82	com/vladium/emma/data/mergeCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   216: goto -172 -> 44
    //   219: aload_0
    //   220: invokevirtual 126	com/vladium/emma/data/mergeCommand:processFilePropertyOverrides	()Z
    //   223: ifeq -179 -> 44
    //   226: aload_0
    //   227: aload_2
    //   228: invokevirtual 130	com/vladium/emma/data/mergeCommand:processCmdPropertyOverrides	(Lcom/vladium/util/args/IOptsParser$IOpts;)V
    //   231: invokestatic 136	com/vladium/emma/data/MergeProcessor:create	()Lcom/vladium/emma/data/MergeProcessor;
    //   234: astore_2
    //   235: aload_2
    //   236: ldc -118
    //   238: invokevirtual 142	com/vladium/emma/data/MergeProcessor:setAppName	(Ljava/lang/String;)V
    //   241: aload_2
    //   242: aload_0
    //   243: getfield 108	com/vladium/emma/data/mergeCommand:m_datapath	[Ljava/lang/String;
    //   246: invokevirtual 146	com/vladium/emma/data/MergeProcessor:setDataPath	([Ljava/lang/String;)V
    //   249: aload_2
    //   250: aload_0
    //   251: getfield 115	com/vladium/emma/data/mergeCommand:m_outFileName	Ljava/lang/String;
    //   254: invokevirtual 149	com/vladium/emma/data/MergeProcessor:setSessionOutFile	(Ljava/lang/String;)V
    //   257: aload_2
    //   258: aload_0
    //   259: getfield 153	com/vladium/emma/data/mergeCommand:m_propertyOverrides	Ljava/util/Properties;
    //   262: invokevirtual 157	com/vladium/emma/data/MergeProcessor:setPropertyOverrides	(Ljava/util/Properties;)V
    //   265: aload_2
    //   266: invokevirtual 159	com/vladium/emma/data/MergeProcessor:run	()V
    //   269: aload_0
    //   270: iconst_0
    //   271: aconst_null
    //   272: aconst_null
    //   273: iconst_0
    //   274: invokevirtual 82	com/vladium/emma/data/mergeCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   277: goto -233 -> 44
    //   280: iload_1
    //   281: iconst_1
    //   282: iadd
    //   283: istore_1
    //   284: goto -169 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	mergeCommand
    //   31	253	1	i	int
    //   5	21	2	localObject1	Object
    //   47	1	2	localThrowable1	Throwable
    //   55	16	2	localClassLoader	ClassLoader
    //   93	8	2	localEMMARuntimeException	com.vladium.emma.EMMARuntimeException
    //   108	4	2	localObject2	Object
    //   194	8	2	localIOException	java.io.IOException
    //   206	22	2	localThrowable2	Throwable
    //   234	32	2	localMergeProcessor	MergeProcessor
    //   65	57	3	arrayOfIOpt	com.vladium.util.args.IOptsParser.IOpt[]
    //   11	171	4	localIOptsParser	com.vladium.util.args.IOptsParser
    //   133	40	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	6	47	java/lang/Throwable
    //   6	32	93	com/vladium/emma/EMMARuntimeException
    //   36	44	93	com/vladium/emma/EMMARuntimeException
    //   59	66	93	com/vladium/emma/EMMARuntimeException
    //   70	90	93	com/vladium/emma/EMMARuntimeException
    //   115	121	93	com/vladium/emma/EMMARuntimeException
    //   126	167	93	com/vladium/emma/EMMARuntimeException
    //   170	191	93	com/vladium/emma/EMMARuntimeException
    //   195	206	93	com/vladium/emma/EMMARuntimeException
    //   219	231	93	com/vladium/emma/EMMARuntimeException
    //   231	269	93	com/vladium/emma/EMMARuntimeException
    //   2	6	108	finally
    //   6	32	108	finally
    //   36	44	108	finally
    //   48	56	108	finally
    //   59	66	108	finally
    //   70	90	108	finally
    //   94	105	108	finally
    //   115	121	108	finally
    //   126	167	108	finally
    //   170	191	108	finally
    //   195	206	108	finally
    //   207	216	108	finally
    //   219	231	108	finally
    //   231	269	108	finally
    //   269	277	108	finally
    //   115	121	194	java/io/IOException
    //   126	167	194	java/io/IOException
    //   170	191	194	java/io/IOException
    //   219	231	194	java/io/IOException
    //   6	32	206	java/lang/Throwable
    //   36	44	206	java/lang/Throwable
    //   59	66	206	java/lang/Throwable
    //   70	90	206	java/lang/Throwable
    //   115	121	206	java/lang/Throwable
    //   126	167	206	java/lang/Throwable
    //   170	191	206	java/lang/Throwable
    //   195	206	206	java/lang/Throwable
    //   219	231	206	java/lang/Throwable
    //   231	269	206	java/lang/Throwable
  }
  
  protected String usageArgsMsg()
  {
    return "[options]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/mergeCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */