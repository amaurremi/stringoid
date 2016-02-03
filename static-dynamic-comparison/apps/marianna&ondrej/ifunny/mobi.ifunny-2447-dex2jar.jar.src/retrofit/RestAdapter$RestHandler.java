package retrofit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Executor;

class RestAdapter$RestHandler
        implements InvocationHandler {
    private final Map<Method, RestMethodInfo> methodDetailsCache;

    RestAdapter$RestHandler(Map<Method, RestMethodInfo> paramMap) {
        Map localMap;
        this.methodDetailsCache = localMap;
    }

    /* Error */
    private Object invokeRequest(RequestInterceptor paramRequestInterceptor, RestMethodInfo paramRestMethodInfo, Object[] paramArrayOfObject) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 8
        //   3: aload_2
        //   4: invokevirtual 42	retrofit/RestMethodInfo:init	()V
        //   7: aload_0
        //   8: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   11: getfield 48	retrofit/RestAdapter:server	Lretrofit/Endpoint;
        //   14: invokeinterface 54 1 0
        //   19: astore 10
        //   21: new 56	retrofit/RequestBuilder
        //   24: dup
        //   25: aload 10
        //   27: aload_2
        //   28: aload_0
        //   29: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   32: getfield 60	retrofit/RestAdapter:converter	Lretrofit/converter/Converter;
        //   35: invokespecial 63	retrofit/RequestBuilder:<init>	(Ljava/lang/String;Lretrofit/RestMethodInfo;Lretrofit/converter/Converter;)V
        //   38: astore 9
        //   40: aload 9
        //   42: aload_3
        //   43: invokevirtual 67	retrofit/RequestBuilder:setArguments	([Ljava/lang/Object;)V
        //   46: aload_1
        //   47: aload 9
        //   49: invokeinterface 73 2 0
        //   54: aload 9
        //   56: invokevirtual 77	retrofit/RequestBuilder:build	()Lretrofit/client/Request;
        //   59: astore 9
        //   61: aload 9
        //   63: invokevirtual 80	retrofit/client/Request:getUrl	()Ljava/lang/String;
        //   66: astore_1
        //   67: aload_2
        //   68: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   71: ifne +36 -> 107
        //   74: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   77: new 92	java/lang/StringBuilder
        //   80: dup
        //   81: invokespecial 93	java/lang/StringBuilder:<init>	()V
        //   84: ldc 95
        //   86: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   89: aload_1
        //   90: aload 10
        //   92: invokevirtual 105	java/lang/String:length	()I
        //   95: invokevirtual 109	java/lang/String:substring	(I)Ljava/lang/String;
        //   98: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   101: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   104: invokevirtual 116	java/lang/Thread:setName	(Ljava/lang/String;)V
        //   107: aload 9
        //   109: astore 8
        //   111: aload_0
        //   112: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   115: getfield 120	retrofit/RestAdapter:logLevel	Lretrofit/RestAdapter$LogLevel;
        //   118: invokevirtual 126	retrofit/RestAdapter$LogLevel:log	()Z
        //   121: ifeq +17 -> 138
        //   124: aload_0
        //   125: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   128: ldc -128
        //   130: aload 9
        //   132: aload_3
        //   133: invokevirtual 132	retrofit/RestAdapter:logAndReplaceRequest	(Ljava/lang/String;Lretrofit/client/Request;[Ljava/lang/Object;)Lretrofit/client/Request;
        //   136: astore 8
        //   138: aload_0
        //   139: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   142: invokestatic 136	retrofit/RestAdapter:access$200	(Lretrofit/RestAdapter;)Lretrofit/Profiler;
        //   145: ifnull +569 -> 714
        //   148: aload_0
        //   149: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   152: invokestatic 136	retrofit/RestAdapter:access$200	(Lretrofit/RestAdapter;)Lretrofit/Profiler;
        //   155: invokeinterface 142 1 0
        //   160: astore_3
        //   161: invokestatic 148	java/lang/System:nanoTime	()J
        //   164: lstore 5
        //   166: aload_0
        //   167: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   170: invokestatic 152	retrofit/RestAdapter:access$300	(Lretrofit/RestAdapter;)Lretrofit/client/Client$Provider;
        //   173: invokeinterface 158 1 0
        //   178: aload 8
        //   180: invokeinterface 164 2 0
        //   185: astore 9
        //   187: getstatic 170	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
        //   190: invokestatic 148	java/lang/System:nanoTime	()J
        //   193: lload 5
        //   195: lsub
        //   196: invokevirtual 174	java/util/concurrent/TimeUnit:toMillis	(J)J
        //   199: lstore 5
        //   201: aload 9
        //   203: invokevirtual 179	retrofit/client/Response:getStatus	()I
        //   206: istore 4
        //   208: aload_0
        //   209: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   212: invokestatic 136	retrofit/RestAdapter:access$200	(Lretrofit/RestAdapter;)Lretrofit/Profiler;
        //   215: ifnull +32 -> 247
        //   218: aload 10
        //   220: aload_2
        //   221: aload 8
        //   223: invokestatic 183	retrofit/RestAdapter:access$400	(Ljava/lang/String;Lretrofit/RestMethodInfo;Lretrofit/client/Request;)Lretrofit/Profiler$RequestInformation;
        //   226: astore 8
        //   228: aload_0
        //   229: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   232: invokestatic 136	retrofit/RestAdapter:access$200	(Lretrofit/RestAdapter;)Lretrofit/Profiler;
        //   235: aload 8
        //   237: lload 5
        //   239: iload 4
        //   241: aload_3
        //   242: invokeinterface 187 6 0
        //   247: aload_0
        //   248: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   251: getfield 120	retrofit/RestAdapter:logLevel	Lretrofit/RestAdapter$LogLevel;
        //   254: invokevirtual 126	retrofit/RestAdapter$LogLevel:log	()Z
        //   257: ifeq +451 -> 708
        //   260: aload_0
        //   261: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   264: aload_1
        //   265: aload 9
        //   267: lload 5
        //   269: invokestatic 191	retrofit/RestAdapter:access$500	(Lretrofit/RestAdapter;Ljava/lang/String;Lretrofit/client/Response;J)Lretrofit/client/Response;
        //   272: astore_3
        //   273: aload_2
        //   274: getfield 195	retrofit/RestMethodInfo:responseObjectType	Ljava/lang/reflect/Type;
        //   277: astore 9
        //   279: iload 4
        //   281: sipush 200
        //   284: if_icmplt +355 -> 639
        //   287: iload 4
        //   289: sipush 300
        //   292: if_icmpge +347 -> 639
        //   295: aload 9
        //   297: ldc -80
        //   299: invokevirtual 199	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   302: ifeq +74 -> 376
        //   305: aload_2
        //   306: getfield 202	retrofit/RestMethodInfo:isStreaming	Z
        //   309: ifne +396 -> 705
        //   312: aload_3
        //   313: invokestatic 208	retrofit/Utils:readBodyToBytesIfNecessary	(Lretrofit/client/Response;)Lretrofit/client/Response;
        //   316: astore_3
        //   317: aload_2
        //   318: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   321: istore 7
        //   323: iload 7
        //   325: ifeq +24 -> 349
        //   328: aload_3
        //   329: astore_1
        //   330: aload_2
        //   331: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   334: ifne +13 -> 347
        //   337: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   340: ldc -46
        //   342: invokevirtual 116	java/lang/Thread:setName	(Ljava/lang/String;)V
        //   345: aload_3
        //   346: astore_1
        //   347: aload_1
        //   348: areturn
        //   349: new 212	retrofit/ResponseWrapper
        //   352: dup
        //   353: aload_3
        //   354: aload_3
        //   355: invokespecial 215	retrofit/ResponseWrapper:<init>	(Lretrofit/client/Response;Ljava/lang/Object;)V
        //   358: astore_3
        //   359: aload_2
        //   360: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   363: ifne +11 -> 374
        //   366: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   369: ldc -46
        //   371: invokevirtual 116	java/lang/Thread:setName	(Ljava/lang/String;)V
        //   374: aload_3
        //   375: areturn
        //   376: aload_3
        //   377: invokevirtual 219	retrofit/client/Response:getBody	()Lretrofit/mime/TypedInput;
        //   380: astore 11
        //   382: aload 11
        //   384: ifnonnull +60 -> 444
        //   387: aload_2
        //   388: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   391: istore 7
        //   393: iload 7
        //   395: ifeq +20 -> 415
        //   398: aload_2
        //   399: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   402: ifne +11 -> 413
        //   405: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   408: ldc -46
        //   410: invokevirtual 116	java/lang/Thread:setName	(Ljava/lang/String;)V
        //   413: aconst_null
        //   414: areturn
        //   415: new 212	retrofit/ResponseWrapper
        //   418: dup
        //   419: aload_3
        //   420: aconst_null
        //   421: invokespecial 215	retrofit/ResponseWrapper:<init>	(Lretrofit/client/Response;Ljava/lang/Object;)V
        //   424: astore_3
        //   425: aload_3
        //   426: astore_1
        //   427: aload_2
        //   428: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   431: ifne -84 -> 347
        //   434: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   437: ldc -46
        //   439: invokevirtual 116	java/lang/Thread:setName	(Ljava/lang/String;)V
        //   442: aload_3
        //   443: areturn
        //   444: new 221	retrofit/ExceptionCatchingTypedInput
        //   447: dup
        //   448: aload 11
        //   450: invokespecial 224	retrofit/ExceptionCatchingTypedInput:<init>	(Lretrofit/mime/TypedInput;)V
        //   453: astore 10
        //   455: aload_0
        //   456: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   459: getfield 60	retrofit/RestAdapter:converter	Lretrofit/converter/Converter;
        //   462: aload 10
        //   464: aload 9
        //   466: invokeinterface 230 3 0
        //   471: astore 8
        //   473: aload_0
        //   474: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   477: aload 11
        //   479: aload 8
        //   481: invokestatic 234	retrofit/RestAdapter:access$600	(Lretrofit/RestAdapter;Lretrofit/mime/TypedInput;Ljava/lang/Object;)V
        //   484: aload_2
        //   485: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   488: istore 7
        //   490: iload 7
        //   492: ifeq +24 -> 516
        //   495: aload 8
        //   497: astore_1
        //   498: aload_2
        //   499: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   502: ifne -155 -> 347
        //   505: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   508: ldc -46
        //   510: invokevirtual 116	java/lang/Thread:setName	(Ljava/lang/String;)V
        //   513: aload 8
        //   515: areturn
        //   516: new 212	retrofit/ResponseWrapper
        //   519: dup
        //   520: aload_3
        //   521: aload 8
        //   523: invokespecial 215	retrofit/ResponseWrapper:<init>	(Lretrofit/client/Response;Ljava/lang/Object;)V
        //   526: astore 8
        //   528: aload_2
        //   529: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   532: ifne +11 -> 543
        //   535: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   538: ldc -46
        //   540: invokevirtual 116	java/lang/Thread:setName	(Ljava/lang/String;)V
        //   543: aload 8
        //   545: areturn
        //   546: astore 8
        //   548: aload 10
        //   550: invokevirtual 237	retrofit/ExceptionCatchingTypedInput:threwException	()Z
        //   553: ifeq +30 -> 583
        //   556: aload 10
        //   558: invokevirtual 241	retrofit/ExceptionCatchingTypedInput:getThrownException	()Ljava/io/IOException;
        //   561: athrow
        //   562: astore_1
        //   563: aload_1
        //   564: athrow
        //   565: astore_1
        //   566: aload_2
        //   567: getfield 84	retrofit/RestMethodInfo:isSynchronous	Z
        //   570: ifne +11 -> 581
        //   573: invokestatic 90	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   576: ldc -46
        //   578: invokevirtual 116	java/lang/Thread:setName	(Ljava/lang/String;)V
        //   581: aload_1
        //   582: athrow
        //   583: aload_1
        //   584: aload_3
        //   585: aconst_null
        //   586: invokestatic 245	retrofit/Utils:replaceResponseBody	(Lretrofit/client/Response;Lretrofit/mime/TypedInput;)Lretrofit/client/Response;
        //   589: aload_0
        //   590: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   593: getfield 60	retrofit/RestAdapter:converter	Lretrofit/converter/Converter;
        //   596: aload 9
        //   598: aload 8
        //   600: invokestatic 249	retrofit/RetrofitError:conversionError	(Ljava/lang/String;Lretrofit/client/Response;Lretrofit/converter/Converter;Ljava/lang/reflect/Type;Lretrofit/converter/ConversionException;)Lretrofit/RetrofitError;
        //   603: athrow
        //   604: astore 8
        //   606: aload_1
        //   607: astore_3
        //   608: aload 8
        //   610: astore_1
        //   611: aload_0
        //   612: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   615: getfield 120	retrofit/RestAdapter:logLevel	Lretrofit/RestAdapter$LogLevel;
        //   618: invokevirtual 126	retrofit/RestAdapter$LogLevel:log	()Z
        //   621: ifeq +12 -> 633
        //   624: aload_0
        //   625: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   628: aload_1
        //   629: aload_3
        //   630: invokevirtual 253	retrofit/RestAdapter:logException	(Ljava/lang/Throwable;Ljava/lang/String;)V
        //   633: aload_3
        //   634: aload_1
        //   635: invokestatic 257	retrofit/RetrofitError:networkError	(Ljava/lang/String;Ljava/io/IOException;)Lretrofit/RetrofitError;
        //   638: athrow
        //   639: aload_1
        //   640: aload_3
        //   641: invokestatic 208	retrofit/Utils:readBodyToBytesIfNecessary	(Lretrofit/client/Response;)Lretrofit/client/Response;
        //   644: aload_0
        //   645: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   648: getfield 60	retrofit/RestAdapter:converter	Lretrofit/converter/Converter;
        //   651: aload 9
        //   653: invokestatic 261	retrofit/RetrofitError:httpError	(Ljava/lang/String;Lretrofit/client/Response;Lretrofit/converter/Converter;Ljava/lang/reflect/Type;)Lretrofit/RetrofitError;
        //   656: athrow
        //   657: astore 8
        //   659: aload_1
        //   660: astore_3
        //   661: aload 8
        //   663: astore_1
        //   664: aload_0
        //   665: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   668: getfield 120	retrofit/RestAdapter:logLevel	Lretrofit/RestAdapter$LogLevel;
        //   671: invokevirtual 126	retrofit/RestAdapter$LogLevel:log	()Z
        //   674: ifeq +12 -> 686
        //   677: aload_0
        //   678: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
        //   681: aload_1
        //   682: aload_3
        //   683: invokevirtual 253	retrofit/RestAdapter:logException	(Ljava/lang/Throwable;Ljava/lang/String;)V
        //   686: aload_3
        //   687: aload_1
        //   688: invokestatic 265	retrofit/RetrofitError:unexpectedError	(Ljava/lang/String;Ljava/lang/Throwable;)Lretrofit/RetrofitError;
        //   691: athrow
        //   692: astore_1
        //   693: aconst_null
        //   694: astore_3
        //   695: goto -31 -> 664
        //   698: astore_1
        //   699: aload 8
        //   701: astore_3
        //   702: goto -91 -> 611
        //   705: goto -388 -> 317
        //   708: aload 9
        //   710: astore_3
        //   711: goto -438 -> 273
        //   714: aconst_null
        //   715: astore_3
        //   716: goto -555 -> 161
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	719	0	this	RestHandler
        //   0	719	1	paramRequestInterceptor	RequestInterceptor
        //   0	719	2	paramRestMethodInfo	RestMethodInfo
        //   0	719	3	paramArrayOfObject	Object[]
        //   206	87	4	i	int
        //   164	104	5	l	long
        //   321	170	7	bool	boolean
        //   1	543	8	localObject1	Object
        //   546	53	8	localConversionException	retrofit.converter.ConversionException
        //   604	5	8	localIOException	java.io.IOException
        //   657	43	8	localThrowable	Throwable
        //   38	671	9	localObject2	Object
        //   19	538	10	localObject3	Object
        //   380	98	11	localTypedInput	retrofit.mime.TypedInput
        // Exception table:
        //   from	to	target	type
        //   455	490	546	retrofit/converter/ConversionException
        //   516	528	546	retrofit/converter/ConversionException
        //   3	67	562	retrofit/RetrofitError
        //   67	107	562	retrofit/RetrofitError
        //   111	138	562	retrofit/RetrofitError
        //   138	161	562	retrofit/RetrofitError
        //   161	247	562	retrofit/RetrofitError
        //   247	273	562	retrofit/RetrofitError
        //   273	279	562	retrofit/RetrofitError
        //   295	317	562	retrofit/RetrofitError
        //   317	323	562	retrofit/RetrofitError
        //   349	359	562	retrofit/RetrofitError
        //   376	382	562	retrofit/RetrofitError
        //   387	393	562	retrofit/RetrofitError
        //   415	425	562	retrofit/RetrofitError
        //   444	455	562	retrofit/RetrofitError
        //   455	490	562	retrofit/RetrofitError
        //   516	528	562	retrofit/RetrofitError
        //   548	562	562	retrofit/RetrofitError
        //   583	604	562	retrofit/RetrofitError
        //   639	657	562	retrofit/RetrofitError
        //   3	67	565	finally
        //   67	107	565	finally
        //   111	138	565	finally
        //   138	161	565	finally
        //   161	247	565	finally
        //   247	273	565	finally
        //   273	279	565	finally
        //   295	317	565	finally
        //   317	323	565	finally
        //   349	359	565	finally
        //   376	382	565	finally
        //   387	393	565	finally
        //   415	425	565	finally
        //   444	455	565	finally
        //   455	490	565	finally
        //   516	528	565	finally
        //   548	562	565	finally
        //   563	565	565	finally
        //   583	604	565	finally
        //   611	633	565	finally
        //   633	639	565	finally
        //   639	657	565	finally
        //   664	686	565	finally
        //   686	692	565	finally
        //   67	107	604	java/io/IOException
        //   111	138	604	java/io/IOException
        //   138	161	604	java/io/IOException
        //   161	247	604	java/io/IOException
        //   247	273	604	java/io/IOException
        //   273	279	604	java/io/IOException
        //   295	317	604	java/io/IOException
        //   317	323	604	java/io/IOException
        //   349	359	604	java/io/IOException
        //   376	382	604	java/io/IOException
        //   387	393	604	java/io/IOException
        //   415	425	604	java/io/IOException
        //   444	455	604	java/io/IOException
        //   455	490	604	java/io/IOException
        //   516	528	604	java/io/IOException
        //   548	562	604	java/io/IOException
        //   583	604	604	java/io/IOException
        //   639	657	604	java/io/IOException
        //   67	107	657	java/lang/Throwable
        //   111	138	657	java/lang/Throwable
        //   138	161	657	java/lang/Throwable
        //   161	247	657	java/lang/Throwable
        //   247	273	657	java/lang/Throwable
        //   273	279	657	java/lang/Throwable
        //   295	317	657	java/lang/Throwable
        //   317	323	657	java/lang/Throwable
        //   349	359	657	java/lang/Throwable
        //   376	382	657	java/lang/Throwable
        //   387	393	657	java/lang/Throwable
        //   415	425	657	java/lang/Throwable
        //   444	455	657	java/lang/Throwable
        //   455	490	657	java/lang/Throwable
        //   516	528	657	java/lang/Throwable
        //   548	562	657	java/lang/Throwable
        //   583	604	657	java/lang/Throwable
        //   639	657	657	java/lang/Throwable
        //   3	67	692	java/lang/Throwable
        //   3	67	698	java/io/IOException
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
        if (paramMethod.getDeclaringClass() == Object.class) {
            return paramMethod.invoke(this, paramArrayOfObject);
        }
        paramObject = RestAdapter.getMethodInfo(this.methodDetailsCache, paramMethod);
        if (((RestMethodInfo) paramObject).isSynchronous) {
            try {
                paramObject = invokeRequest(this.this$0.requestInterceptor, (RestMethodInfo) paramObject, paramArrayOfObject);
                return paramObject;
            } catch (RetrofitError paramObject) {
                paramMethod = this.this$0.errorHandler.handleError((RetrofitError) paramObject);
                if (paramMethod == null) {
                    throw new IllegalStateException("Error handler returned null for wrapped exception.", (Throwable) paramObject);
                }
                throw paramMethod;
            }
        }
        if ((this.this$0.httpExecutor == null) || (this.this$0.callbackExecutor == null)) {
            throw new IllegalStateException("Asynchronous invocation requires calling setExecutors.");
        }
        if (((RestMethodInfo) paramObject).isObservable) {
            if (RestAdapter.access$000(this.this$0) == null) {
                if (Platform.HAS_RX_JAVA) {
                    RestAdapter.access$002(this.this$0, new RxSupport(this.this$0.httpExecutor, this.this$0.errorHandler, this.this$0.requestInterceptor));
                }
            } else {
                return RestAdapter.access$000(this.this$0).createRequestObservable(new RestAdapter.RestHandler .1
                (this, (RestMethodInfo) paramObject, paramArrayOfObject));
            }
            throw new IllegalStateException("Observable method found but no RxJava on classpath.");
        }
        paramMethod = new RequestInterceptorTape();
        this.this$0.requestInterceptor.intercept(paramMethod);
        Callback localCallback = (Callback) paramArrayOfObject[(paramArrayOfObject.length - 1)];
        this.this$0.httpExecutor.execute(new RestAdapter.RestHandler .2
        (this, localCallback, this.this$0.callbackExecutor, this.this$0.errorHandler, paramMethod, (RestMethodInfo) paramObject, paramArrayOfObject))
        ;
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RestAdapter$RestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */