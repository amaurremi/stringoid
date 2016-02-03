package com.vladium.emma.report;

import com.vladium.emma.Command;

public final class reportCommand
  extends Command
{
  private String[] m_datapath;
  private String[] m_reportTypes;
  private String[] m_srcpath;
  
  public reportCommand(String paramString, String[] paramArrayOfString)
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
    //   8: invokevirtual 34	com/vladium/emma/report/reportCommand:getOptParser	(Ljava/lang/ClassLoader;)Lcom/vladium/util/args/IOptsParser;
    //   11: astore 4
    //   13: aload 4
    //   15: aload_0
    //   16: getfield 37	com/vladium/emma/report/reportCommand:m_args	[Ljava/lang/String;
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
    //   41: invokevirtual 53	com/vladium/emma/report/reportCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
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
    //   72: getfield 70	com/vladium/emma/report/reportCommand:m_out	Ljava/io/PrintWriter;
    //   75: bipush 80
    //   77: invokeinterface 74 3 0
    //   82: aload_0
    //   83: aload 4
    //   85: iconst_1
    //   86: aconst_null
    //   87: invokevirtual 53	com/vladium/emma/report/reportCommand:usageexit	(Lcom/vladium/util/args/IOptsParser;ILjava/lang/String;)V
    //   90: goto -46 -> 44
    //   93: astore_2
    //   94: aload_0
    //   95: iconst_1
    //   96: aload_2
    //   97: invokevirtual 78	com/vladium/emma/EMMARuntimeException:getMessage	()Ljava/lang/String;
    //   100: aload_2
    //   101: iconst_2
    //   102: invokevirtual 82	com/vladium/emma/report/reportCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
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
    //   118: if_icmpge +133 -> 251
    //   121: aload_3
    //   122: iload_1
    //   123: aaload
    //   124: astore 4
    //   126: aload 4
    //   128: invokeinterface 87 1 0
    //   133: astore 5
    //   135: aload_0
    //   136: aload 4
    //   138: invokevirtual 91	com/vladium/emma/report/reportCommand:processOpt	(Lcom/vladium/util/args/IOptsParser$IOpt;)Z
    //   141: ifne +179 -> 320
    //   144: ldc 93
    //   146: aload 5
    //   148: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +19 -> 170
    //   154: aload_0
    //   155: aload 4
    //   157: getstatic 103	com/vladium/emma/report/reportCommand:PATH_DELIMITERS	Ljava/lang/String;
    //   160: iconst_1
    //   161: invokestatic 107	com/vladium/emma/report/reportCommand:getListOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;Ljava/lang/String;Z)[Ljava/lang/String;
    //   164: putfield 109	com/vladium/emma/report/reportCommand:m_datapath	[Ljava/lang/String;
    //   167: goto +153 -> 320
    //   170: ldc 111
    //   172: aload 5
    //   174: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   177: ifeq +44 -> 221
    //   180: aload_0
    //   181: aload 4
    //   183: getstatic 103	com/vladium/emma/report/reportCommand:PATH_DELIMITERS	Ljava/lang/String;
    //   186: iconst_1
    //   187: invokestatic 107	com/vladium/emma/report/reportCommand:getListOptValue	(Lcom/vladium/util/args/IOptsParser$IOpt;Ljava/lang/String;Z)[Ljava/lang/String;
    //   190: putfield 113	com/vladium/emma/report/reportCommand:m_srcpath	[Ljava/lang/String;
    //   193: goto +127 -> 320
    //   196: astore_2
    //   197: new 22	com/vladium/emma/EMMARuntimeException
    //   200: dup
    //   201: ldc 115
    //   203: aload_2
    //   204: invokespecial 118	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   207: athrow
    //   208: astore_2
    //   209: aload_0
    //   210: iconst_1
    //   211: ldc 120
    //   213: aload_2
    //   214: iconst_2
    //   215: invokevirtual 82	com/vladium/emma/report/reportCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   218: goto -174 -> 44
    //   221: ldc 122
    //   223: aload 5
    //   225: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifeq +92 -> 320
    //   231: aload_0
    //   232: aload 4
    //   234: invokeinterface 126 1 0
    //   239: ldc -128
    //   241: iconst_1
    //   242: invokestatic 134	com/vladium/util/Strings:merge	([Ljava/lang/String;Ljava/lang/String;Z)[Ljava/lang/String;
    //   245: putfield 136	com/vladium/emma/report/reportCommand:m_reportTypes	[Ljava/lang/String;
    //   248: goto +72 -> 320
    //   251: aload_0
    //   252: invokevirtual 140	com/vladium/emma/report/reportCommand:processFilePropertyOverrides	()Z
    //   255: ifeq -211 -> 44
    //   258: aload_0
    //   259: aload_2
    //   260: invokevirtual 144	com/vladium/emma/report/reportCommand:processCmdPropertyOverrides	(Lcom/vladium/util/args/IOptsParser$IOpts;)V
    //   263: invokestatic 150	com/vladium/emma/report/ReportProcessor:create	()Lcom/vladium/emma/report/ReportProcessor;
    //   266: astore_2
    //   267: aload_2
    //   268: ldc -104
    //   270: invokevirtual 156	com/vladium/emma/report/ReportProcessor:setAppName	(Ljava/lang/String;)V
    //   273: aload_2
    //   274: aload_0
    //   275: getfield 109	com/vladium/emma/report/reportCommand:m_datapath	[Ljava/lang/String;
    //   278: invokevirtual 160	com/vladium/emma/report/ReportProcessor:setDataPath	([Ljava/lang/String;)V
    //   281: aload_2
    //   282: aload_0
    //   283: getfield 113	com/vladium/emma/report/reportCommand:m_srcpath	[Ljava/lang/String;
    //   286: invokevirtual 163	com/vladium/emma/report/ReportProcessor:setSourcePath	([Ljava/lang/String;)V
    //   289: aload_2
    //   290: aload_0
    //   291: getfield 136	com/vladium/emma/report/reportCommand:m_reportTypes	[Ljava/lang/String;
    //   294: invokevirtual 166	com/vladium/emma/report/ReportProcessor:setReportTypes	([Ljava/lang/String;)V
    //   297: aload_2
    //   298: aload_0
    //   299: getfield 170	com/vladium/emma/report/reportCommand:m_propertyOverrides	Ljava/util/Properties;
    //   302: invokevirtual 174	com/vladium/emma/report/ReportProcessor:setPropertyOverrides	(Ljava/util/Properties;)V
    //   305: aload_2
    //   306: invokevirtual 176	com/vladium/emma/report/ReportProcessor:run	()V
    //   309: aload_0
    //   310: iconst_0
    //   311: aconst_null
    //   312: aconst_null
    //   313: iconst_0
    //   314: invokevirtual 82	com/vladium/emma/report/reportCommand:exit	(ZLjava/lang/String;Ljava/lang/Throwable;I)V
    //   317: goto -273 -> 44
    //   320: iload_1
    //   321: iconst_1
    //   322: iadd
    //   323: istore_1
    //   324: goto -209 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	reportCommand
    //   31	293	1	i	int
    //   5	21	2	localObject1	Object
    //   47	1	2	localThrowable1	Throwable
    //   55	16	2	localClassLoader	ClassLoader
    //   93	8	2	localEMMARuntimeException	com.vladium.emma.EMMARuntimeException
    //   108	4	2	localObject2	Object
    //   196	8	2	localIOException	java.io.IOException
    //   208	52	2	localThrowable2	Throwable
    //   266	40	2	localReportProcessor	ReportProcessor
    //   65	57	3	arrayOfIOpt	com.vladium.util.args.IOptsParser.IOpt[]
    //   11	222	4	localIOptsParser	com.vladium.util.args.IOptsParser
    //   133	91	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	6	47	java/lang/Throwable
    //   6	32	93	com/vladium/emma/EMMARuntimeException
    //   36	44	93	com/vladium/emma/EMMARuntimeException
    //   59	66	93	com/vladium/emma/EMMARuntimeException
    //   70	90	93	com/vladium/emma/EMMARuntimeException
    //   115	121	93	com/vladium/emma/EMMARuntimeException
    //   126	167	93	com/vladium/emma/EMMARuntimeException
    //   170	193	93	com/vladium/emma/EMMARuntimeException
    //   197	208	93	com/vladium/emma/EMMARuntimeException
    //   221	248	93	com/vladium/emma/EMMARuntimeException
    //   251	263	93	com/vladium/emma/EMMARuntimeException
    //   263	309	93	com/vladium/emma/EMMARuntimeException
    //   2	6	108	finally
    //   6	32	108	finally
    //   36	44	108	finally
    //   48	56	108	finally
    //   59	66	108	finally
    //   70	90	108	finally
    //   94	105	108	finally
    //   115	121	108	finally
    //   126	167	108	finally
    //   170	193	108	finally
    //   197	208	108	finally
    //   209	218	108	finally
    //   221	248	108	finally
    //   251	263	108	finally
    //   263	309	108	finally
    //   309	317	108	finally
    //   115	121	196	java/io/IOException
    //   126	167	196	java/io/IOException
    //   170	193	196	java/io/IOException
    //   221	248	196	java/io/IOException
    //   251	263	196	java/io/IOException
    //   6	32	208	java/lang/Throwable
    //   36	44	208	java/lang/Throwable
    //   59	66	208	java/lang/Throwable
    //   70	90	208	java/lang/Throwable
    //   115	121	208	java/lang/Throwable
    //   126	167	208	java/lang/Throwable
    //   170	193	208	java/lang/Throwable
    //   197	208	208	java/lang/Throwable
    //   221	248	208	java/lang/Throwable
    //   251	263	208	java/lang/Throwable
    //   263	309	208	java/lang/Throwable
  }
  
  protected String usageArgsMsg()
  {
    return "[options]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/reportCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */