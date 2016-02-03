package com.parse.signpost;

import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.exception.OAuthNotAuthorizedException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractOAuthProvider
  implements OAuthProvider
{
  private static final long serialVersionUID = 1L;
  private String accessTokenEndpointUrl;
  private String authorizationWebsiteUrl;
  private Map<String, String> defaultHeaders;
  private boolean isOAuth10a;
  private transient OAuthProviderListener listener;
  private String requestTokenEndpointUrl;
  private HttpParameters responseParameters;
  
  public AbstractOAuthProvider(String paramString1, String paramString2, String paramString3)
  {
    this.requestTokenEndpointUrl = paramString1;
    this.accessTokenEndpointUrl = paramString2;
    this.authorizationWebsiteUrl = paramString3;
    this.responseParameters = new HttpParameters();
    this.defaultHeaders = new HashMap();
  }
  
  protected void closeConnection(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
    throws Exception
  {}
  
  protected abstract HttpRequest createRequest(String paramString)
    throws Exception;
  
  public String getAccessTokenEndpointUrl()
  {
    return this.accessTokenEndpointUrl;
  }
  
  public String getAuthorizationWebsiteUrl()
  {
    return this.authorizationWebsiteUrl;
  }
  
  public Map<String, String> getRequestHeaders()
  {
    return this.defaultHeaders;
  }
  
  public String getRequestTokenEndpointUrl()
  {
    return this.requestTokenEndpointUrl;
  }
  
  protected String getResponseParameter(String paramString)
  {
    return this.responseParameters.getFirst(paramString);
  }
  
  public HttpParameters getResponseParameters()
  {
    return this.responseParameters;
  }
  
  protected void handleUnexpectedResponse(int paramInt, HttpResponse paramHttpResponse)
    throws Exception
  {
    if (paramHttpResponse == null) {
      return;
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramHttpResponse.getContent()), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    for (String str = localBufferedReader.readLine();; str = localBufferedReader.readLine())
    {
      if (str == null) {}
      switch (paramInt)
      {
      default: 
        throw new OAuthCommunicationException("Service provider responded in error: " + paramInt + " (" + paramHttpResponse.getReasonPhrase() + ")", localStringBuilder.toString());
        localStringBuilder.append(str);
      }
    }
    throw new OAuthNotAuthorizedException(localStringBuilder.toString());
  }
  
  public boolean isOAuth10a()
  {
    return this.isOAuth10a;
  }
  
  public void removeListener(OAuthProviderListener paramOAuthProviderListener)
  {
    this.listener = null;
  }
  
  public void retrieveAccessToken(OAuthConsumer paramOAuthConsumer, String paramString)
    throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException
  {
    if ((paramOAuthConsumer.getToken() == null) || (paramOAuthConsumer.getTokenSecret() == null)) {
      throw new OAuthExpectationFailedException("Authorized request token or token secret not set. Did you retrieve an authorized request token before?");
    }
    if ((this.isOAuth10a) && (paramString != null))
    {
      retrieveToken(paramOAuthConsumer, this.accessTokenEndpointUrl, new String[] { "oauth_verifier", paramString });
      return;
    }
    retrieveToken(paramOAuthConsumer, this.accessTokenEndpointUrl, new String[0]);
  }
  
  public String retrieveRequestToken(OAuthConsumer paramOAuthConsumer, String paramString)
    throws OAuthMessageSignerException, OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException
  {
    paramOAuthConsumer.setTokenWithSecret(null, null);
    retrieveToken(paramOAuthConsumer, this.requestTokenEndpointUrl, new String[] { "oauth_callback", paramString });
    String str = this.responseParameters.getFirst("oauth_callback_confirmed");
    this.responseParameters.remove("oauth_callback_confirmed");
    this.isOAuth10a = Boolean.TRUE.toString().equals(str);
    if (this.isOAuth10a) {
      return OAuth.addQueryParameters(this.authorizationWebsiteUrl, new String[] { "oauth_token", paramOAuthConsumer.getToken() });
    }
    return OAuth.addQueryParameters(this.authorizationWebsiteUrl, new String[] { "oauth_token", paramOAuthConsumer.getToken(), "oauth_callback", paramString });
  }
  
  /* Error */
  protected void retrieveToken(OAuthConsumer paramOAuthConsumer, String paramString, String... paramVarArgs)
    throws OAuthMessageSignerException, OAuthCommunicationException, OAuthNotAuthorizedException, OAuthExpectationFailedException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 188	com/parse/signpost/AbstractOAuthProvider:getRequestHeaders	()Ljava/util/Map;
    //   4: astore 18
    //   6: aload_1
    //   7: invokeinterface 191 1 0
    //   12: ifnull +12 -> 24
    //   15: aload_1
    //   16: invokeinterface 194 1 0
    //   21: ifnonnull +13 -> 34
    //   24: new 135	com/parse/signpost/exception/OAuthExpectationFailedException
    //   27: dup
    //   28: ldc -60
    //   30: invokespecial 146	com/parse/signpost/exception/OAuthExpectationFailedException:<init>	(Ljava/lang/String;)V
    //   33: athrow
    //   34: aconst_null
    //   35: astore 6
    //   37: aconst_null
    //   38: astore 10
    //   40: aconst_null
    //   41: astore 12
    //   43: aconst_null
    //   44: astore 8
    //   46: aconst_null
    //   47: astore 15
    //   49: aconst_null
    //   50: astore 16
    //   52: aconst_null
    //   53: astore 17
    //   55: aconst_null
    //   56: astore 14
    //   58: aload 14
    //   60: astore 9
    //   62: aload 15
    //   64: astore 7
    //   66: aload 16
    //   68: astore 11
    //   70: aload 17
    //   72: astore 13
    //   74: aload_0
    //   75: aload_2
    //   76: invokevirtual 198	com/parse/signpost/AbstractOAuthProvider:createRequest	(Ljava/lang/String;)Lcom/parse/signpost/http/HttpRequest;
    //   79: astore_2
    //   80: aload_2
    //   81: astore 8
    //   83: aload 14
    //   85: astore 9
    //   87: aload_2
    //   88: astore 6
    //   90: aload 15
    //   92: astore 7
    //   94: aload_2
    //   95: astore 10
    //   97: aload 16
    //   99: astore 11
    //   101: aload_2
    //   102: astore 12
    //   104: aload 17
    //   106: astore 13
    //   108: aload 18
    //   110: invokeinterface 204 1 0
    //   115: invokeinterface 210 1 0
    //   120: astore 19
    //   122: aload_2
    //   123: astore 8
    //   125: aload 14
    //   127: astore 9
    //   129: aload_2
    //   130: astore 6
    //   132: aload 15
    //   134: astore 7
    //   136: aload_2
    //   137: astore 10
    //   139: aload 16
    //   141: astore 11
    //   143: aload_2
    //   144: astore 12
    //   146: aload 17
    //   148: astore 13
    //   150: aload 19
    //   152: invokeinterface 215 1 0
    //   157: ifne +446 -> 603
    //   160: aload_3
    //   161: ifnull +111 -> 272
    //   164: aload_2
    //   165: astore 8
    //   167: aload 14
    //   169: astore 9
    //   171: aload_2
    //   172: astore 6
    //   174: aload 15
    //   176: astore 7
    //   178: aload_2
    //   179: astore 10
    //   181: aload 16
    //   183: astore 11
    //   185: aload_2
    //   186: astore 12
    //   188: aload 17
    //   190: astore 13
    //   192: new 36	com/parse/signpost/http/HttpParameters
    //   195: dup
    //   196: invokespecial 37	com/parse/signpost/http/HttpParameters:<init>	()V
    //   199: astore 18
    //   201: aload_2
    //   202: astore 8
    //   204: aload 14
    //   206: astore 9
    //   208: aload_2
    //   209: astore 6
    //   211: aload 15
    //   213: astore 7
    //   215: aload_2
    //   216: astore 10
    //   218: aload 16
    //   220: astore 11
    //   222: aload_2
    //   223: astore 12
    //   225: aload 17
    //   227: astore 13
    //   229: aload 18
    //   231: aload_3
    //   232: iconst_1
    //   233: invokevirtual 219	com/parse/signpost/http/HttpParameters:putAll	([Ljava/lang/String;Z)V
    //   236: aload_2
    //   237: astore 8
    //   239: aload 14
    //   241: astore 9
    //   243: aload_2
    //   244: astore 6
    //   246: aload 15
    //   248: astore 7
    //   250: aload_2
    //   251: astore 10
    //   253: aload 16
    //   255: astore 11
    //   257: aload_2
    //   258: astore 12
    //   260: aload 17
    //   262: astore 13
    //   264: aload_1
    //   265: aload 18
    //   267: invokeinterface 223 2 0
    //   272: aload_2
    //   273: astore 8
    //   275: aload 14
    //   277: astore 9
    //   279: aload_2
    //   280: astore 6
    //   282: aload 15
    //   284: astore 7
    //   286: aload_2
    //   287: astore 10
    //   289: aload 16
    //   291: astore 11
    //   293: aload_2
    //   294: astore 12
    //   296: aload 17
    //   298: astore 13
    //   300: aload_0
    //   301: getfield 129	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   304: ifnull +41 -> 345
    //   307: aload_2
    //   308: astore 8
    //   310: aload 14
    //   312: astore 9
    //   314: aload_2
    //   315: astore 6
    //   317: aload 15
    //   319: astore 7
    //   321: aload_2
    //   322: astore 10
    //   324: aload 16
    //   326: astore 11
    //   328: aload_2
    //   329: astore 12
    //   331: aload 17
    //   333: astore 13
    //   335: aload_0
    //   336: getfield 129	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   339: aload_2
    //   340: invokeinterface 229 2 0
    //   345: aload_2
    //   346: astore 8
    //   348: aload 14
    //   350: astore 9
    //   352: aload_2
    //   353: astore 6
    //   355: aload 15
    //   357: astore 7
    //   359: aload_2
    //   360: astore 10
    //   362: aload 16
    //   364: astore 11
    //   366: aload_2
    //   367: astore 12
    //   369: aload 17
    //   371: astore 13
    //   373: aload_1
    //   374: aload_2
    //   375: invokeinterface 233 2 0
    //   380: pop
    //   381: aload_2
    //   382: astore 8
    //   384: aload 14
    //   386: astore 9
    //   388: aload_2
    //   389: astore 6
    //   391: aload 15
    //   393: astore 7
    //   395: aload_2
    //   396: astore 10
    //   398: aload 16
    //   400: astore 11
    //   402: aload_2
    //   403: astore 12
    //   405: aload 17
    //   407: astore 13
    //   409: aload_0
    //   410: getfield 129	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   413: ifnull +41 -> 454
    //   416: aload_2
    //   417: astore 8
    //   419: aload 14
    //   421: astore 9
    //   423: aload_2
    //   424: astore 6
    //   426: aload 15
    //   428: astore 7
    //   430: aload_2
    //   431: astore 10
    //   433: aload 16
    //   435: astore 11
    //   437: aload_2
    //   438: astore 12
    //   440: aload 17
    //   442: astore 13
    //   444: aload_0
    //   445: getfield 129	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   448: aload_2
    //   449: invokeinterface 236 2 0
    //   454: aload_2
    //   455: astore 8
    //   457: aload 14
    //   459: astore 9
    //   461: aload_2
    //   462: astore 6
    //   464: aload 15
    //   466: astore 7
    //   468: aload_2
    //   469: astore 10
    //   471: aload 16
    //   473: astore 11
    //   475: aload_2
    //   476: astore 12
    //   478: aload 17
    //   480: astore 13
    //   482: aload_0
    //   483: aload_2
    //   484: invokevirtual 240	com/parse/signpost/AbstractOAuthProvider:sendRequest	(Lcom/parse/signpost/http/HttpRequest;)Lcom/parse/signpost/http/HttpResponse;
    //   487: astore_3
    //   488: aload_2
    //   489: astore 8
    //   491: aload_3
    //   492: astore 9
    //   494: aload_2
    //   495: astore 6
    //   497: aload_3
    //   498: astore 7
    //   500: aload_2
    //   501: astore 10
    //   503: aload_3
    //   504: astore 11
    //   506: aload_2
    //   507: astore 12
    //   509: aload_3
    //   510: astore 13
    //   512: aload_3
    //   513: invokeinterface 244 1 0
    //   518: istore 4
    //   520: iconst_0
    //   521: istore 5
    //   523: aload_2
    //   524: astore 8
    //   526: aload_3
    //   527: astore 9
    //   529: aload_2
    //   530: astore 6
    //   532: aload_3
    //   533: astore 7
    //   535: aload_2
    //   536: astore 10
    //   538: aload_3
    //   539: astore 11
    //   541: aload_2
    //   542: astore 12
    //   544: aload_3
    //   545: astore 13
    //   547: aload_0
    //   548: getfield 129	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   551: ifnull +40 -> 591
    //   554: aload_2
    //   555: astore 8
    //   557: aload_3
    //   558: astore 9
    //   560: aload_2
    //   561: astore 6
    //   563: aload_3
    //   564: astore 7
    //   566: aload_2
    //   567: astore 10
    //   569: aload_3
    //   570: astore 11
    //   572: aload_2
    //   573: astore 12
    //   575: aload_3
    //   576: astore 13
    //   578: aload_0
    //   579: getfield 129	com/parse/signpost/AbstractOAuthProvider:listener	Lcom/parse/signpost/OAuthProviderListener;
    //   582: aload_2
    //   583: aload_3
    //   584: invokeinterface 248 3 0
    //   589: istore 5
    //   591: iload 5
    //   593: ifeq +133 -> 726
    //   596: aload_0
    //   597: aload_2
    //   598: aload_3
    //   599: invokevirtual 250	com/parse/signpost/AbstractOAuthProvider:closeConnection	(Lcom/parse/signpost/http/HttpRequest;Lcom/parse/signpost/http/HttpResponse;)V
    //   602: return
    //   603: aload_2
    //   604: astore 8
    //   606: aload 14
    //   608: astore 9
    //   610: aload_2
    //   611: astore 6
    //   613: aload 15
    //   615: astore 7
    //   617: aload_2
    //   618: astore 10
    //   620: aload 16
    //   622: astore 11
    //   624: aload_2
    //   625: astore 12
    //   627: aload 17
    //   629: astore 13
    //   631: aload 19
    //   633: invokeinterface 254 1 0
    //   638: checkcast 148	java/lang/String
    //   641: astore 20
    //   643: aload_2
    //   644: astore 8
    //   646: aload 14
    //   648: astore 9
    //   650: aload_2
    //   651: astore 6
    //   653: aload 15
    //   655: astore 7
    //   657: aload_2
    //   658: astore 10
    //   660: aload 16
    //   662: astore 11
    //   664: aload_2
    //   665: astore 12
    //   667: aload 17
    //   669: astore 13
    //   671: aload_2
    //   672: aload 20
    //   674: aload 18
    //   676: aload 20
    //   678: invokeinterface 258 2 0
    //   683: checkcast 148	java/lang/String
    //   686: invokeinterface 263 3 0
    //   691: goto -569 -> 122
    //   694: astore_1
    //   695: aload 8
    //   697: astore 6
    //   699: aload 9
    //   701: astore 7
    //   703: aload_1
    //   704: athrow
    //   705: astore_1
    //   706: aload_0
    //   707: aload 6
    //   709: aload 7
    //   711: invokevirtual 250	com/parse/signpost/AbstractOAuthProvider:closeConnection	(Lcom/parse/signpost/http/HttpRequest;Lcom/parse/signpost/http/HttpResponse;)V
    //   714: aload_1
    //   715: athrow
    //   716: astore_1
    //   717: new 94	com/parse/signpost/exception/OAuthCommunicationException
    //   720: dup
    //   721: aload_1
    //   722: invokespecial 266	com/parse/signpost/exception/OAuthCommunicationException:<init>	(Ljava/lang/Exception;)V
    //   725: athrow
    //   726: iload 4
    //   728: sipush 300
    //   731: if_icmplt +34 -> 765
    //   734: aload_2
    //   735: astore 8
    //   737: aload_3
    //   738: astore 9
    //   740: aload_2
    //   741: astore 6
    //   743: aload_3
    //   744: astore 7
    //   746: aload_2
    //   747: astore 10
    //   749: aload_3
    //   750: astore 11
    //   752: aload_2
    //   753: astore 12
    //   755: aload_3
    //   756: astore 13
    //   758: aload_0
    //   759: iload 4
    //   761: aload_3
    //   762: invokevirtual 268	com/parse/signpost/AbstractOAuthProvider:handleUnexpectedResponse	(ILcom/parse/signpost/http/HttpResponse;)V
    //   765: aload_2
    //   766: astore 8
    //   768: aload_3
    //   769: astore 9
    //   771: aload_2
    //   772: astore 6
    //   774: aload_3
    //   775: astore 7
    //   777: aload_2
    //   778: astore 10
    //   780: aload_3
    //   781: astore 11
    //   783: aload_2
    //   784: astore 12
    //   786: aload_3
    //   787: astore 13
    //   789: aload_3
    //   790: invokeinterface 80 1 0
    //   795: invokestatic 272	com/parse/signpost/OAuth:decodeForm	(Ljava/io/InputStream;)Lcom/parse/signpost/http/HttpParameters;
    //   798: astore 14
    //   800: aload_2
    //   801: astore 8
    //   803: aload_3
    //   804: astore 9
    //   806: aload_2
    //   807: astore 6
    //   809: aload_3
    //   810: astore 7
    //   812: aload_2
    //   813: astore 10
    //   815: aload_3
    //   816: astore 11
    //   818: aload_2
    //   819: astore 12
    //   821: aload_3
    //   822: astore 13
    //   824: aload 14
    //   826: ldc -76
    //   828: invokevirtual 66	com/parse/signpost/http/HttpParameters:getFirst	(Ljava/lang/Object;)Ljava/lang/String;
    //   831: astore 15
    //   833: aload_2
    //   834: astore 8
    //   836: aload_3
    //   837: astore 9
    //   839: aload_2
    //   840: astore 6
    //   842: aload_3
    //   843: astore 7
    //   845: aload_2
    //   846: astore 10
    //   848: aload_3
    //   849: astore 11
    //   851: aload_2
    //   852: astore 12
    //   854: aload_3
    //   855: astore 13
    //   857: aload 14
    //   859: ldc_w 274
    //   862: invokevirtual 66	com/parse/signpost/http/HttpParameters:getFirst	(Ljava/lang/Object;)Ljava/lang/String;
    //   865: astore 16
    //   867: aload_2
    //   868: astore 8
    //   870: aload_3
    //   871: astore 9
    //   873: aload_2
    //   874: astore 6
    //   876: aload_3
    //   877: astore 7
    //   879: aload_2
    //   880: astore 10
    //   882: aload_3
    //   883: astore 11
    //   885: aload_2
    //   886: astore 12
    //   888: aload_3
    //   889: astore 13
    //   891: aload 14
    //   893: ldc -76
    //   895: invokevirtual 167	com/parse/signpost/http/HttpParameters:remove	(Ljava/lang/Object;)Ljava/util/SortedSet;
    //   898: pop
    //   899: aload_2
    //   900: astore 8
    //   902: aload_3
    //   903: astore 9
    //   905: aload_2
    //   906: astore 6
    //   908: aload_3
    //   909: astore 7
    //   911: aload_2
    //   912: astore 10
    //   914: aload_3
    //   915: astore 11
    //   917: aload_2
    //   918: astore 12
    //   920: aload_3
    //   921: astore 13
    //   923: aload 14
    //   925: ldc_w 274
    //   928: invokevirtual 167	com/parse/signpost/http/HttpParameters:remove	(Ljava/lang/Object;)Ljava/util/SortedSet;
    //   931: pop
    //   932: aload_2
    //   933: astore 8
    //   935: aload_3
    //   936: astore 9
    //   938: aload_2
    //   939: astore 6
    //   941: aload_3
    //   942: astore 7
    //   944: aload_2
    //   945: astore 10
    //   947: aload_3
    //   948: astore 11
    //   950: aload_2
    //   951: astore 12
    //   953: aload_3
    //   954: astore 13
    //   956: aload_0
    //   957: aload 14
    //   959: invokevirtual 277	com/parse/signpost/AbstractOAuthProvider:setResponseParameters	(Lcom/parse/signpost/http/HttpParameters;)V
    //   962: aload 15
    //   964: ifnull +8 -> 972
    //   967: aload 16
    //   969: ifnonnull +49 -> 1018
    //   972: aload_2
    //   973: astore 8
    //   975: aload_3
    //   976: astore 9
    //   978: aload_2
    //   979: astore 6
    //   981: aload_3
    //   982: astore 7
    //   984: aload_2
    //   985: astore 10
    //   987: aload_3
    //   988: astore 11
    //   990: aload_2
    //   991: astore 12
    //   993: aload_3
    //   994: astore 13
    //   996: new 135	com/parse/signpost/exception/OAuthExpectationFailedException
    //   999: dup
    //   1000: ldc_w 279
    //   1003: invokespecial 146	com/parse/signpost/exception/OAuthExpectationFailedException:<init>	(Ljava/lang/String;)V
    //   1006: athrow
    //   1007: astore_1
    //   1008: aload 10
    //   1010: astore 6
    //   1012: aload 11
    //   1014: astore 7
    //   1016: aload_1
    //   1017: athrow
    //   1018: aload_2
    //   1019: astore 8
    //   1021: aload_3
    //   1022: astore 9
    //   1024: aload_2
    //   1025: astore 6
    //   1027: aload_3
    //   1028: astore 7
    //   1030: aload_2
    //   1031: astore 10
    //   1033: aload_3
    //   1034: astore 11
    //   1036: aload_2
    //   1037: astore 12
    //   1039: aload_3
    //   1040: astore 13
    //   1042: aload_1
    //   1043: aload 15
    //   1045: aload 16
    //   1047: invokeinterface 159 3 0
    //   1052: aload_0
    //   1053: aload_2
    //   1054: aload_3
    //   1055: invokevirtual 250	com/parse/signpost/AbstractOAuthProvider:closeConnection	(Lcom/parse/signpost/http/HttpRequest;Lcom/parse/signpost/http/HttpResponse;)V
    //   1058: return
    //   1059: astore_1
    //   1060: new 94	com/parse/signpost/exception/OAuthCommunicationException
    //   1063: dup
    //   1064: aload_1
    //   1065: invokespecial 266	com/parse/signpost/exception/OAuthCommunicationException:<init>	(Ljava/lang/Exception;)V
    //   1068: athrow
    //   1069: astore_1
    //   1070: aload 12
    //   1072: astore 6
    //   1074: aload 13
    //   1076: astore 7
    //   1078: new 94	com/parse/signpost/exception/OAuthCommunicationException
    //   1081: dup
    //   1082: aload_1
    //   1083: invokespecial 266	com/parse/signpost/exception/OAuthCommunicationException:<init>	(Ljava/lang/Exception;)V
    //   1086: athrow
    //   1087: astore_1
    //   1088: new 94	com/parse/signpost/exception/OAuthCommunicationException
    //   1091: dup
    //   1092: aload_1
    //   1093: invokespecial 266	com/parse/signpost/exception/OAuthCommunicationException:<init>	(Ljava/lang/Exception;)V
    //   1096: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1097	0	this	AbstractOAuthProvider
    //   0	1097	1	paramOAuthConsumer	OAuthConsumer
    //   0	1097	2	paramString	String
    //   0	1097	3	paramVarArgs	String[]
    //   518	242	4	i	int
    //   521	71	5	bool	boolean
    //   35	1038	6	localObject1	Object
    //   64	1013	7	localObject2	Object
    //   44	976	8	str1	String
    //   60	963	9	localObject3	Object
    //   38	994	10	str2	String
    //   68	967	11	localObject4	Object
    //   41	1030	12	str3	String
    //   72	1003	13	localObject5	Object
    //   56	902	14	localHttpParameters	HttpParameters
    //   47	997	15	str4	String
    //   50	996	16	str5	String
    //   53	615	17	localObject6	Object
    //   4	671	18	localObject7	Object
    //   120	512	19	localIterator	java.util.Iterator
    //   641	36	20	str6	String
    // Exception table:
    //   from	to	target	type
    //   74	80	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   108	122	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   150	160	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   192	201	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   229	236	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   264	272	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   300	307	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   335	345	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   373	381	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   409	416	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   444	454	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   482	488	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   512	520	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   547	554	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   578	591	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   631	643	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   671	691	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   758	765	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   789	800	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   824	833	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   857	867	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   891	899	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   923	932	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   956	962	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   996	1007	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   1042	1052	694	com/parse/signpost/exception/OAuthNotAuthorizedException
    //   74	80	705	finally
    //   108	122	705	finally
    //   150	160	705	finally
    //   192	201	705	finally
    //   229	236	705	finally
    //   264	272	705	finally
    //   300	307	705	finally
    //   335	345	705	finally
    //   373	381	705	finally
    //   409	416	705	finally
    //   444	454	705	finally
    //   482	488	705	finally
    //   512	520	705	finally
    //   547	554	705	finally
    //   578	591	705	finally
    //   631	643	705	finally
    //   671	691	705	finally
    //   703	705	705	finally
    //   758	765	705	finally
    //   789	800	705	finally
    //   824	833	705	finally
    //   857	867	705	finally
    //   891	899	705	finally
    //   923	932	705	finally
    //   956	962	705	finally
    //   996	1007	705	finally
    //   1016	1018	705	finally
    //   1042	1052	705	finally
    //   1078	1087	705	finally
    //   596	602	716	java/lang/Exception
    //   74	80	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   108	122	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   150	160	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   192	201	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   229	236	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   264	272	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   300	307	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   335	345	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   373	381	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   409	416	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   444	454	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   482	488	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   512	520	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   547	554	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   578	591	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   631	643	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   671	691	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   758	765	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   789	800	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   824	833	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   857	867	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   891	899	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   923	932	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   956	962	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   996	1007	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   1042	1052	1007	com/parse/signpost/exception/OAuthExpectationFailedException
    //   1052	1058	1059	java/lang/Exception
    //   74	80	1069	java/lang/Exception
    //   108	122	1069	java/lang/Exception
    //   150	160	1069	java/lang/Exception
    //   192	201	1069	java/lang/Exception
    //   229	236	1069	java/lang/Exception
    //   264	272	1069	java/lang/Exception
    //   300	307	1069	java/lang/Exception
    //   335	345	1069	java/lang/Exception
    //   373	381	1069	java/lang/Exception
    //   409	416	1069	java/lang/Exception
    //   444	454	1069	java/lang/Exception
    //   482	488	1069	java/lang/Exception
    //   512	520	1069	java/lang/Exception
    //   547	554	1069	java/lang/Exception
    //   578	591	1069	java/lang/Exception
    //   631	643	1069	java/lang/Exception
    //   671	691	1069	java/lang/Exception
    //   758	765	1069	java/lang/Exception
    //   789	800	1069	java/lang/Exception
    //   824	833	1069	java/lang/Exception
    //   857	867	1069	java/lang/Exception
    //   891	899	1069	java/lang/Exception
    //   923	932	1069	java/lang/Exception
    //   956	962	1069	java/lang/Exception
    //   996	1007	1069	java/lang/Exception
    //   1042	1052	1069	java/lang/Exception
    //   706	714	1087	java/lang/Exception
  }
  
  protected abstract HttpResponse sendRequest(HttpRequest paramHttpRequest)
    throws Exception;
  
  public void setListener(OAuthProviderListener paramOAuthProviderListener)
  {
    this.listener = paramOAuthProviderListener;
  }
  
  public void setOAuth10a(boolean paramBoolean)
  {
    this.isOAuth10a = paramBoolean;
  }
  
  public void setRequestHeader(String paramString1, String paramString2)
  {
    this.defaultHeaders.put(paramString1, paramString2);
  }
  
  public void setResponseParameters(HttpParameters paramHttpParameters)
  {
    this.responseParameters = paramHttpParameters;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/AbstractOAuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */