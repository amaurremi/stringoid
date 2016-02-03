package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.DirectMessage;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.ResponseList;
import twitter4j.SymbolEntity;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class DirectMessageJSONImpl
  extends TwitterResponseImpl
  implements Serializable, DirectMessage
{
  private static final long serialVersionUID = -7104233663827757577L;
  private Date createdAt;
  private HashtagEntity[] hashtagEntities;
  private long id;
  private MediaEntity[] mediaEntities;
  private User recipient;
  private long recipientId;
  private String recipientScreenName;
  private User sender;
  private long senderId;
  private String senderScreenName;
  private SymbolEntity[] symbolEntities;
  private String text;
  private URLEntity[] urlEntities;
  private UserMentionEntity[] userMentionEntities;
  
  DirectMessageJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    super(paramHttpResponse);
    paramHttpResponse = paramHttpResponse.asJSONObject();
    init(paramHttpResponse);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse);
    }
  }
  
  DirectMessageJSONImpl(JSONObject paramJSONObject)
  {
    init(paramJSONObject);
  }
  
  static ResponseList createDirectMessageList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    for (;;)
    {
      int i;
      try
      {
        if (paramConfiguration.isJSONStoreEnabled()) {
          DataObjectFactoryUtil.clearThreadLocalMap();
        }
        JSONArray localJSONArray = paramHttpResponse.asJSONArray();
        int j = localJSONArray.length();
        paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          DirectMessageJSONImpl localDirectMessageJSONImpl = new DirectMessageJSONImpl(localJSONObject);
          paramHttpResponse.add(localDirectMessageJSONImpl);
          if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(localDirectMessageJSONImpl, localJSONObject);
          }
        }
        else
        {
          if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, localJSONArray);
          }
          return paramHttpResponse;
        }
      }
      catch (JSONException paramHttpResponse)
      {
        throw new TwitterException(paramHttpResponse);
      }
      catch (TwitterException paramHttpResponse)
      {
        throw paramHttpResponse;
      }
      i += 1;
    }
  }
  
  /* Error */
  private void init(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ldc 105
    //   5: aload_1
    //   6: invokestatic 111	twitter4j/internal/json/z_T4JInternalParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)J
    //   9: putfield 113	twitter4j/internal/json/DirectMessageJSONImpl:id	J
    //   12: aload_0
    //   13: ldc 115
    //   15: aload_1
    //   16: invokestatic 111	twitter4j/internal/json/z_T4JInternalParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)J
    //   19: putfield 117	twitter4j/internal/json/DirectMessageJSONImpl:senderId	J
    //   22: aload_0
    //   23: ldc 119
    //   25: aload_1
    //   26: invokestatic 111	twitter4j/internal/json/z_T4JInternalParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)J
    //   29: putfield 121	twitter4j/internal/json/DirectMessageJSONImpl:recipientId	J
    //   32: aload_0
    //   33: ldc 123
    //   35: aload_1
    //   36: invokestatic 127	twitter4j/internal/json/z_T4JInternalParseUtil:getDate	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/util/Date;
    //   39: putfield 129	twitter4j/internal/json/DirectMessageJSONImpl:createdAt	Ljava/util/Date;
    //   42: aload_0
    //   43: ldc -125
    //   45: aload_1
    //   46: invokestatic 135	twitter4j/internal/json/z_T4JInternalParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
    //   49: putfield 137	twitter4j/internal/json/DirectMessageJSONImpl:senderScreenName	Ljava/lang/String;
    //   52: aload_0
    //   53: ldc -117
    //   55: aload_1
    //   56: invokestatic 135	twitter4j/internal/json/z_T4JInternalParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
    //   59: putfield 141	twitter4j/internal/json/DirectMessageJSONImpl:recipientScreenName	Ljava/lang/String;
    //   62: aload_0
    //   63: new 143	twitter4j/internal/json/UserJSONImpl
    //   66: dup
    //   67: aload_1
    //   68: ldc -112
    //   70: invokevirtual 149	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
    //   73: invokespecial 150	twitter4j/internal/json/UserJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   76: putfield 152	twitter4j/internal/json/DirectMessageJSONImpl:sender	Ltwitter4j/User;
    //   79: aload_0
    //   80: new 143	twitter4j/internal/json/UserJSONImpl
    //   83: dup
    //   84: aload_1
    //   85: ldc -103
    //   87: invokevirtual 149	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
    //   90: invokespecial 150	twitter4j/internal/json/UserJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   93: putfield 155	twitter4j/internal/json/DirectMessageJSONImpl:recipient	Ltwitter4j/User;
    //   96: aload_1
    //   97: ldc -99
    //   99: invokevirtual 161	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   102: ifne +356 -> 458
    //   105: aload_1
    //   106: ldc -99
    //   108: invokevirtual 149	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
    //   111: astore 5
    //   113: aload 5
    //   115: ldc -93
    //   117: invokevirtual 161	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   120: ifne +62 -> 182
    //   123: aload 5
    //   125: ldc -93
    //   127: invokevirtual 167	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
    //   130: astore 6
    //   132: aload 6
    //   134: invokevirtual 84	twitter4j/internal/org/json/JSONArray:length	()I
    //   137: istore 4
    //   139: aload_0
    //   140: iload 4
    //   142: anewarray 169	twitter4j/UserMentionEntity
    //   145: putfield 171	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
    //   148: iconst_0
    //   149: istore_2
    //   150: iload_2
    //   151: iload 4
    //   153: if_icmpge +29 -> 182
    //   156: aload_0
    //   157: getfield 171	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
    //   160: iload_2
    //   161: new 173	twitter4j/internal/json/UserMentionEntityJSONImpl
    //   164: dup
    //   165: aload 6
    //   167: iload_2
    //   168: invokevirtual 93	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
    //   171: invokespecial 174	twitter4j/internal/json/UserMentionEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   174: aastore
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: istore_2
    //   179: goto -29 -> 150
    //   182: aload 5
    //   184: ldc -80
    //   186: invokevirtual 161	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   189: ifne +62 -> 251
    //   192: aload 5
    //   194: ldc -80
    //   196: invokevirtual 167	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
    //   199: astore 6
    //   201: aload 6
    //   203: invokevirtual 84	twitter4j/internal/org/json/JSONArray:length	()I
    //   206: istore 4
    //   208: aload_0
    //   209: iload 4
    //   211: anewarray 178	twitter4j/URLEntity
    //   214: putfield 180	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
    //   217: iconst_0
    //   218: istore_2
    //   219: iload_2
    //   220: iload 4
    //   222: if_icmpge +29 -> 251
    //   225: aload_0
    //   226: getfield 180	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
    //   229: iload_2
    //   230: new 182	twitter4j/internal/json/URLEntityJSONImpl
    //   233: dup
    //   234: aload 6
    //   236: iload_2
    //   237: invokevirtual 93	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
    //   240: invokespecial 183	twitter4j/internal/json/URLEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   243: aastore
    //   244: iload_2
    //   245: iconst_1
    //   246: iadd
    //   247: istore_2
    //   248: goto -29 -> 219
    //   251: aload 5
    //   253: ldc -71
    //   255: invokevirtual 161	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   258: ifne +62 -> 320
    //   261: aload 5
    //   263: ldc -71
    //   265: invokevirtual 167	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
    //   268: astore 6
    //   270: aload 6
    //   272: invokevirtual 84	twitter4j/internal/org/json/JSONArray:length	()I
    //   275: istore 4
    //   277: aload_0
    //   278: iload 4
    //   280: anewarray 187	twitter4j/HashtagEntity
    //   283: putfield 189	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
    //   286: iconst_0
    //   287: istore_2
    //   288: iload_2
    //   289: iload 4
    //   291: if_icmpge +29 -> 320
    //   294: aload_0
    //   295: getfield 189	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
    //   298: iload_2
    //   299: new 191	twitter4j/internal/json/HashtagEntityJSONImpl
    //   302: dup
    //   303: aload 6
    //   305: iload_2
    //   306: invokevirtual 93	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
    //   309: invokespecial 192	twitter4j/internal/json/HashtagEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   312: aastore
    //   313: iload_2
    //   314: iconst_1
    //   315: iadd
    //   316: istore_2
    //   317: goto -29 -> 288
    //   320: aload 5
    //   322: ldc -62
    //   324: invokevirtual 161	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   327: ifne +62 -> 389
    //   330: aload 5
    //   332: ldc -62
    //   334: invokevirtual 167	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
    //   337: astore 6
    //   339: aload 6
    //   341: invokevirtual 84	twitter4j/internal/org/json/JSONArray:length	()I
    //   344: istore 4
    //   346: aload_0
    //   347: iload 4
    //   349: anewarray 196	twitter4j/SymbolEntity
    //   352: putfield 198	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
    //   355: iconst_0
    //   356: istore_2
    //   357: iload_2
    //   358: iload 4
    //   360: if_icmpge +29 -> 389
    //   363: aload_0
    //   364: getfield 198	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
    //   367: iload_2
    //   368: new 191	twitter4j/internal/json/HashtagEntityJSONImpl
    //   371: dup
    //   372: aload 6
    //   374: iload_2
    //   375: invokevirtual 93	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
    //   378: invokespecial 192	twitter4j/internal/json/HashtagEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   381: aastore
    //   382: iload_2
    //   383: iconst_1
    //   384: iadd
    //   385: istore_2
    //   386: goto -29 -> 357
    //   389: aload 5
    //   391: ldc -56
    //   393: invokevirtual 161	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   396: ifne +62 -> 458
    //   399: aload 5
    //   401: ldc -56
    //   403: invokevirtual 167	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
    //   406: astore 5
    //   408: aload 5
    //   410: invokevirtual 84	twitter4j/internal/org/json/JSONArray:length	()I
    //   413: istore 4
    //   415: aload_0
    //   416: iload 4
    //   418: anewarray 202	twitter4j/MediaEntity
    //   421: putfield 204	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
    //   424: iload_3
    //   425: istore_2
    //   426: iload_2
    //   427: iload 4
    //   429: if_icmpge +29 -> 458
    //   432: aload_0
    //   433: getfield 204	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
    //   436: iload_2
    //   437: new 206	twitter4j/internal/json/MediaEntityJSONImpl
    //   440: dup
    //   441: aload 5
    //   443: iload_2
    //   444: invokevirtual 93	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
    //   447: invokespecial 207	twitter4j/internal/json/MediaEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
    //   450: aastore
    //   451: iload_2
    //   452: iconst_1
    //   453: iadd
    //   454: istore_2
    //   455: goto -29 -> 426
    //   458: aload_0
    //   459: getfield 171	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
    //   462: ifnonnull +121 -> 583
    //   465: iconst_0
    //   466: anewarray 169	twitter4j/UserMentionEntity
    //   469: astore 5
    //   471: aload_0
    //   472: aload 5
    //   474: putfield 171	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
    //   477: aload_0
    //   478: getfield 180	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
    //   481: ifnonnull +111 -> 592
    //   484: iconst_0
    //   485: anewarray 178	twitter4j/URLEntity
    //   488: astore 5
    //   490: aload_0
    //   491: aload 5
    //   493: putfield 180	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
    //   496: aload_0
    //   497: getfield 189	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
    //   500: ifnonnull +101 -> 601
    //   503: iconst_0
    //   504: anewarray 187	twitter4j/HashtagEntity
    //   507: astore 5
    //   509: aload_0
    //   510: aload 5
    //   512: putfield 189	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
    //   515: aload_0
    //   516: getfield 198	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
    //   519: ifnonnull +91 -> 610
    //   522: iconst_0
    //   523: anewarray 196	twitter4j/SymbolEntity
    //   526: astore 5
    //   528: aload_0
    //   529: aload 5
    //   531: putfield 198	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
    //   534: aload_0
    //   535: getfield 204	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
    //   538: ifnonnull +81 -> 619
    //   541: iconst_0
    //   542: anewarray 202	twitter4j/MediaEntity
    //   545: astore 5
    //   547: aload_0
    //   548: aload 5
    //   550: putfield 204	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
    //   553: aload_0
    //   554: aload_1
    //   555: ldc -48
    //   557: invokevirtual 212	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   560: aload_0
    //   561: getfield 171	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
    //   564: aload_0
    //   565: getfield 180	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
    //   568: aload_0
    //   569: getfield 189	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
    //   572: aload_0
    //   573: getfield 204	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
    //   576: invokestatic 218	twitter4j/internal/json/HTMLEntity:unescapeAndSlideEntityIncdices	(Ljava/lang/String;[Ltwitter4j/UserMentionEntity;[Ltwitter4j/URLEntity;[Ltwitter4j/HashtagEntity;[Ltwitter4j/MediaEntity;)Ljava/lang/String;
    //   579: putfield 220	twitter4j/internal/json/DirectMessageJSONImpl:text	Ljava/lang/String;
    //   582: return
    //   583: aload_0
    //   584: getfield 171	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
    //   587: astore 5
    //   589: goto -118 -> 471
    //   592: aload_0
    //   593: getfield 180	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
    //   596: astore 5
    //   598: goto -108 -> 490
    //   601: aload_0
    //   602: getfield 189	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
    //   605: astore 5
    //   607: goto -98 -> 509
    //   610: aload_0
    //   611: getfield 198	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
    //   614: astore 5
    //   616: goto -88 -> 528
    //   619: aload_0
    //   620: getfield 204	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
    //   623: astore 5
    //   625: goto -78 -> 547
    //   628: astore_1
    //   629: new 74	twitter4j/TwitterException
    //   632: dup
    //   633: aload_1
    //   634: invokespecial 104	twitter4j/TwitterException:<init>	(Ljava/lang/Exception;)V
    //   637: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	this	DirectMessageJSONImpl
    //   0	638	1	paramJSONObject	JSONObject
    //   149	306	2	i	int
    //   1	424	3	j	int
    //   137	293	4	k	int
    //   111	513	5	localObject	Object
    //   130	243	6	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   62	148	628	twitter4j/internal/org/json/JSONException
    //   156	175	628	twitter4j/internal/org/json/JSONException
    //   182	217	628	twitter4j/internal/org/json/JSONException
    //   225	244	628	twitter4j/internal/org/json/JSONException
    //   251	286	628	twitter4j/internal/org/json/JSONException
    //   294	313	628	twitter4j/internal/org/json/JSONException
    //   320	355	628	twitter4j/internal/org/json/JSONException
    //   363	382	628	twitter4j/internal/org/json/JSONException
    //   389	424	628	twitter4j/internal/org/json/JSONException
    //   432	451	628	twitter4j/internal/org/json/JSONException
    //   458	471	628	twitter4j/internal/org/json/JSONException
    //   471	490	628	twitter4j/internal/org/json/JSONException
    //   490	509	628	twitter4j/internal/org/json/JSONException
    //   509	528	628	twitter4j/internal/org/json/JSONException
    //   528	547	628	twitter4j/internal/org/json/JSONException
    //   547	582	628	twitter4j/internal/org/json/JSONException
    //   583	589	628	twitter4j/internal/org/json/JSONException
    //   592	598	628	twitter4j/internal/org/json/JSONException
    //   601	607	628	twitter4j/internal/org/json/JSONException
    //   610	616	628	twitter4j/internal/org/json/JSONException
    //   619	625	628	twitter4j/internal/org/json/JSONException
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      if (!(paramObject instanceof DirectMessage)) {
        break;
      }
      bool1 = bool2;
    } while (((DirectMessage)paramObject).getId() == this.id);
    return false;
  }
  
  public Date getCreatedAt()
  {
    return this.createdAt;
  }
  
  public HashtagEntity[] getHashtagEntities()
  {
    return this.hashtagEntities;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public MediaEntity[] getMediaEntities()
  {
    return this.mediaEntities;
  }
  
  public User getRecipient()
  {
    return this.recipient;
  }
  
  public long getRecipientId()
  {
    return this.recipientId;
  }
  
  public String getRecipientScreenName()
  {
    return this.recipientScreenName;
  }
  
  public User getSender()
  {
    return this.sender;
  }
  
  public long getSenderId()
  {
    return this.senderId;
  }
  
  public String getSenderScreenName()
  {
    return this.senderScreenName;
  }
  
  public SymbolEntity[] getSymbolEntities()
  {
    return this.symbolEntities;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public URLEntity[] getURLEntities()
  {
    return this.urlEntities;
  }
  
  public UserMentionEntity[] getUserMentionEntities()
  {
    return this.userMentionEntities;
  }
  
  public int hashCode()
  {
    return (int)this.id;
  }
  
  public String toString()
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("DirectMessageJSONImpl{id=").append(this.id).append(", text='").append(this.text).append('\'').append(", sender_id=").append(this.senderId).append(", recipient_id=").append(this.recipientId).append(", created_at=").append(this.createdAt).append(", userMentionEntities=");
    if (this.userMentionEntities == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", urlEntities=");
      if (this.urlEntities != null) {
        break label286;
      }
      localObject1 = null;
      label115:
      localStringBuilder = localStringBuilder.append(localObject1).append(", hashtagEntities=");
      if (this.hashtagEntities != null) {
        break label297;
      }
      localObject1 = null;
      label136:
      localStringBuilder = localStringBuilder.append(localObject1).append(", sender_screen_name='").append(this.senderScreenName).append('\'').append(", recipient_screen_name='").append(this.recipientScreenName).append('\'').append(", sender=").append(this.sender).append(", recipient=").append(this.recipient).append(", userMentionEntities=");
      if (this.userMentionEntities != null) {
        break label308;
      }
      localObject1 = null;
      label219:
      localStringBuilder = localStringBuilder.append(localObject1).append(", urlEntities=");
      if (this.urlEntities != null) {
        break label319;
      }
      localObject1 = null;
      label240:
      localStringBuilder = localStringBuilder.append(localObject1).append(", hashtagEntities=");
      if (this.hashtagEntities != null) {
        break label330;
      }
    }
    label286:
    label297:
    label308:
    label319:
    label330:
    for (Object localObject1 = localObject2;; localObject1 = Arrays.asList(this.hashtagEntities))
    {
      return localObject1 + '}';
      localObject1 = Arrays.asList(this.userMentionEntities);
      break;
      localObject1 = Arrays.asList(this.urlEntities);
      break label115;
      localObject1 = Arrays.asList(this.hashtagEntities);
      break label136;
      localObject1 = Arrays.asList(this.userMentionEntities);
      break label219;
      localObject1 = Arrays.asList(this.urlEntities);
      break label240;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/DirectMessageJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */