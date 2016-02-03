package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import twitter4j.conf.Configuration;

final class DirectMessageJSONImpl
        extends TwitterResponseImpl
        implements Serializable, DirectMessage {
    private static final long serialVersionUID = 7092906238192790921L;
    private Date createdAt;
    private MediaEntity[] extendedMediaEntities;
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

    DirectMessageJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        super(paramHttpResponse);
        paramHttpResponse = paramHttpResponse.asJSONObject();
        init(paramHttpResponse);
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, paramHttpResponse);
        }
    }

    DirectMessageJSONImpl(JSONObject paramJSONObject) {
        init(paramJSONObject);
    }

    static ResponseList<DirectMessage> createDirectMessageList(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        for (; ; ) {
            int i;
            try {
                if (paramConfiguration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.clearThreadLocalMap();
                }
                JSONArray localJSONArray = paramHttpResponse.asJSONArray();
                int j = localJSONArray.length();
                paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
                i = 0;
                if (i < j) {
                    JSONObject localJSONObject = localJSONArray.getJSONObject(i);
                    DirectMessageJSONImpl localDirectMessageJSONImpl = new DirectMessageJSONImpl(localJSONObject);
                    paramHttpResponse.add(localDirectMessageJSONImpl);
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(localDirectMessageJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(paramHttpResponse, localJSONArray);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramHttpResponse) {
                throw new TwitterException(paramHttpResponse);
            }
            i += 1;
        }
    }

    /* Error */
    private void init(JSONObject paramJSONObject) {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: aload_0
        //   3: ldc 108
        //   5: aload_1
        //   6: invokestatic 114	twitter4j/ParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/JSONObject;)J
        //   9: putfield 116	twitter4j/DirectMessageJSONImpl:id	J
        //   12: aload_0
        //   13: ldc 118
        //   15: aload_1
        //   16: invokestatic 114	twitter4j/ParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/JSONObject;)J
        //   19: putfield 120	twitter4j/DirectMessageJSONImpl:senderId	J
        //   22: aload_0
        //   23: ldc 122
        //   25: aload_1
        //   26: invokestatic 114	twitter4j/ParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/JSONObject;)J
        //   29: putfield 124	twitter4j/DirectMessageJSONImpl:recipientId	J
        //   32: aload_0
        //   33: ldc 126
        //   35: aload_1
        //   36: invokestatic 130	twitter4j/ParseUtil:getDate	(Ljava/lang/String;Ltwitter4j/JSONObject;)Ljava/util/Date;
        //   39: putfield 132	twitter4j/DirectMessageJSONImpl:createdAt	Ljava/util/Date;
        //   42: aload_0
        //   43: ldc -122
        //   45: aload_1
        //   46: invokestatic 138	twitter4j/ParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/JSONObject;)Ljava/lang/String;
        //   49: putfield 140	twitter4j/DirectMessageJSONImpl:senderScreenName	Ljava/lang/String;
        //   52: aload_0
        //   53: ldc -114
        //   55: aload_1
        //   56: invokestatic 138	twitter4j/ParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/JSONObject;)Ljava/lang/String;
        //   59: putfield 144	twitter4j/DirectMessageJSONImpl:recipientScreenName	Ljava/lang/String;
        //   62: aload_0
        //   63: new 146	twitter4j/UserJSONImpl
        //   66: dup
        //   67: aload_1
        //   68: ldc -109
        //   70: invokevirtual 152	twitter4j/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/JSONObject;
        //   73: invokespecial 153	twitter4j/UserJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   76: putfield 155	twitter4j/DirectMessageJSONImpl:sender	Ltwitter4j/User;
        //   79: aload_0
        //   80: new 146	twitter4j/UserJSONImpl
        //   83: dup
        //   84: aload_1
        //   85: ldc -100
        //   87: invokevirtual 152	twitter4j/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/JSONObject;
        //   90: invokespecial 153	twitter4j/UserJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   93: putfield 158	twitter4j/DirectMessageJSONImpl:recipient	Ltwitter4j/User;
        //   96: aload_1
        //   97: ldc -96
        //   99: invokevirtual 164	twitter4j/JSONObject:isNull	(Ljava/lang/String;)Z
        //   102: ifne +356 -> 458
        //   105: aload_1
        //   106: ldc -96
        //   108: invokevirtual 152	twitter4j/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/JSONObject;
        //   111: astore 5
        //   113: aload 5
        //   115: ldc -90
        //   117: invokevirtual 164	twitter4j/JSONObject:isNull	(Ljava/lang/String;)Z
        //   120: ifne +62 -> 182
        //   123: aload 5
        //   125: ldc -90
        //   127: invokevirtual 170	twitter4j/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/JSONArray;
        //   130: astore 6
        //   132: aload 6
        //   134: invokevirtual 83	twitter4j/JSONArray:length	()I
        //   137: istore 4
        //   139: aload_0
        //   140: iload 4
        //   142: anewarray 172	twitter4j/UserMentionEntity
        //   145: putfield 174	twitter4j/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   148: iconst_0
        //   149: istore_2
        //   150: iload_2
        //   151: iload 4
        //   153: if_icmpge +29 -> 182
        //   156: aload_0
        //   157: getfield 174	twitter4j/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   160: iload_2
        //   161: new 176	twitter4j/UserMentionEntityJSONImpl
        //   164: dup
        //   165: aload 6
        //   167: iload_2
        //   168: invokevirtual 92	twitter4j/JSONArray:getJSONObject	(I)Ltwitter4j/JSONObject;
        //   171: invokespecial 177	twitter4j/UserMentionEntityJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   174: aastore
        //   175: iload_2
        //   176: iconst_1
        //   177: iadd
        //   178: istore_2
        //   179: goto -29 -> 150
        //   182: aload 5
        //   184: ldc -77
        //   186: invokevirtual 164	twitter4j/JSONObject:isNull	(Ljava/lang/String;)Z
        //   189: ifne +62 -> 251
        //   192: aload 5
        //   194: ldc -77
        //   196: invokevirtual 170	twitter4j/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/JSONArray;
        //   199: astore 6
        //   201: aload 6
        //   203: invokevirtual 83	twitter4j/JSONArray:length	()I
        //   206: istore 4
        //   208: aload_0
        //   209: iload 4
        //   211: anewarray 181	twitter4j/URLEntity
        //   214: putfield 183	twitter4j/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   217: iconst_0
        //   218: istore_2
        //   219: iload_2
        //   220: iload 4
        //   222: if_icmpge +29 -> 251
        //   225: aload_0
        //   226: getfield 183	twitter4j/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   229: iload_2
        //   230: new 185	twitter4j/URLEntityJSONImpl
        //   233: dup
        //   234: aload 6
        //   236: iload_2
        //   237: invokevirtual 92	twitter4j/JSONArray:getJSONObject	(I)Ltwitter4j/JSONObject;
        //   240: invokespecial 186	twitter4j/URLEntityJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   243: aastore
        //   244: iload_2
        //   245: iconst_1
        //   246: iadd
        //   247: istore_2
        //   248: goto -29 -> 219
        //   251: aload 5
        //   253: ldc -68
        //   255: invokevirtual 164	twitter4j/JSONObject:isNull	(Ljava/lang/String;)Z
        //   258: ifne +62 -> 320
        //   261: aload 5
        //   263: ldc -68
        //   265: invokevirtual 170	twitter4j/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/JSONArray;
        //   268: astore 6
        //   270: aload 6
        //   272: invokevirtual 83	twitter4j/JSONArray:length	()I
        //   275: istore 4
        //   277: aload_0
        //   278: iload 4
        //   280: anewarray 190	twitter4j/HashtagEntity
        //   283: putfield 192	twitter4j/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   286: iconst_0
        //   287: istore_2
        //   288: iload_2
        //   289: iload 4
        //   291: if_icmpge +29 -> 320
        //   294: aload_0
        //   295: getfield 192	twitter4j/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   298: iload_2
        //   299: new 194	twitter4j/HashtagEntityJSONImpl
        //   302: dup
        //   303: aload 6
        //   305: iload_2
        //   306: invokevirtual 92	twitter4j/JSONArray:getJSONObject	(I)Ltwitter4j/JSONObject;
        //   309: invokespecial 195	twitter4j/HashtagEntityJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   312: aastore
        //   313: iload_2
        //   314: iconst_1
        //   315: iadd
        //   316: istore_2
        //   317: goto -29 -> 288
        //   320: aload 5
        //   322: ldc -59
        //   324: invokevirtual 164	twitter4j/JSONObject:isNull	(Ljava/lang/String;)Z
        //   327: ifne +62 -> 389
        //   330: aload 5
        //   332: ldc -59
        //   334: invokevirtual 170	twitter4j/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/JSONArray;
        //   337: astore 6
        //   339: aload 6
        //   341: invokevirtual 83	twitter4j/JSONArray:length	()I
        //   344: istore 4
        //   346: aload_0
        //   347: iload 4
        //   349: anewarray 199	twitter4j/SymbolEntity
        //   352: putfield 201	twitter4j/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   355: iconst_0
        //   356: istore_2
        //   357: iload_2
        //   358: iload 4
        //   360: if_icmpge +29 -> 389
        //   363: aload_0
        //   364: getfield 201	twitter4j/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   367: iload_2
        //   368: new 194	twitter4j/HashtagEntityJSONImpl
        //   371: dup
        //   372: aload 6
        //   374: iload_2
        //   375: invokevirtual 92	twitter4j/JSONArray:getJSONObject	(I)Ltwitter4j/JSONObject;
        //   378: invokespecial 195	twitter4j/HashtagEntityJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   381: aastore
        //   382: iload_2
        //   383: iconst_1
        //   384: iadd
        //   385: istore_2
        //   386: goto -29 -> 357
        //   389: aload 5
        //   391: ldc -53
        //   393: invokevirtual 164	twitter4j/JSONObject:isNull	(Ljava/lang/String;)Z
        //   396: ifne +62 -> 458
        //   399: aload 5
        //   401: ldc -53
        //   403: invokevirtual 170	twitter4j/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/JSONArray;
        //   406: astore 5
        //   408: aload 5
        //   410: invokevirtual 83	twitter4j/JSONArray:length	()I
        //   413: istore 4
        //   415: aload_0
        //   416: iload 4
        //   418: anewarray 205	twitter4j/MediaEntity
        //   421: putfield 207	twitter4j/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   424: iload_3
        //   425: istore_2
        //   426: iload_2
        //   427: iload 4
        //   429: if_icmpge +29 -> 458
        //   432: aload_0
        //   433: getfield 207	twitter4j/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   436: iload_2
        //   437: new 209	twitter4j/MediaEntityJSONImpl
        //   440: dup
        //   441: aload 5
        //   443: iload_2
        //   444: invokevirtual 92	twitter4j/JSONArray:getJSONObject	(I)Ltwitter4j/JSONObject;
        //   447: invokespecial 210	twitter4j/MediaEntityJSONImpl:<init>	(Ltwitter4j/JSONObject;)V
        //   450: aastore
        //   451: iload_2
        //   452: iconst_1
        //   453: iadd
        //   454: istore_2
        //   455: goto -29 -> 426
        //   458: aload_0
        //   459: getfield 174	twitter4j/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   462: ifnonnull +140 -> 602
        //   465: iconst_0
        //   466: anewarray 172	twitter4j/UserMentionEntity
        //   469: astore 5
        //   471: aload_0
        //   472: aload 5
        //   474: putfield 174	twitter4j/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   477: aload_0
        //   478: getfield 183	twitter4j/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   481: ifnonnull +130 -> 611
        //   484: iconst_0
        //   485: anewarray 181	twitter4j/URLEntity
        //   488: astore 5
        //   490: aload_0
        //   491: aload 5
        //   493: putfield 183	twitter4j/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   496: aload_0
        //   497: getfield 192	twitter4j/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   500: ifnonnull +120 -> 620
        //   503: iconst_0
        //   504: anewarray 190	twitter4j/HashtagEntity
        //   507: astore 5
        //   509: aload_0
        //   510: aload 5
        //   512: putfield 192	twitter4j/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   515: aload_0
        //   516: getfield 201	twitter4j/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   519: ifnonnull +110 -> 629
        //   522: iconst_0
        //   523: anewarray 199	twitter4j/SymbolEntity
        //   526: astore 5
        //   528: aload_0
        //   529: aload 5
        //   531: putfield 201	twitter4j/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   534: aload_0
        //   535: getfield 207	twitter4j/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   538: ifnonnull +100 -> 638
        //   541: iconst_0
        //   542: anewarray 205	twitter4j/MediaEntity
        //   545: astore 5
        //   547: aload_0
        //   548: aload 5
        //   550: putfield 207	twitter4j/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   553: aload_0
        //   554: getfield 212	twitter4j/DirectMessageJSONImpl:extendedMediaEntities	[Ltwitter4j/MediaEntity;
        //   557: ifnonnull +90 -> 647
        //   560: iconst_0
        //   561: anewarray 205	twitter4j/MediaEntity
        //   564: astore 5
        //   566: aload_0
        //   567: aload 5
        //   569: putfield 212	twitter4j/DirectMessageJSONImpl:extendedMediaEntities	[Ltwitter4j/MediaEntity;
        //   572: aload_0
        //   573: aload_1
        //   574: ldc -43
        //   576: invokevirtual 217	twitter4j/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   579: aload_0
        //   580: getfield 174	twitter4j/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   583: aload_0
        //   584: getfield 183	twitter4j/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   587: aload_0
        //   588: getfield 192	twitter4j/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   591: aload_0
        //   592: getfield 207	twitter4j/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   595: invokestatic 223	twitter4j/HTMLEntity:unescapeAndSlideEntityIncdices	(Ljava/lang/String;[Ltwitter4j/UserMentionEntity;[Ltwitter4j/URLEntity;[Ltwitter4j/HashtagEntity;[Ltwitter4j/MediaEntity;)Ljava/lang/String;
        //   598: putfield 225	twitter4j/DirectMessageJSONImpl:text	Ljava/lang/String;
        //   601: return
        //   602: aload_0
        //   603: getfield 174	twitter4j/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   606: astore 5
        //   608: goto -137 -> 471
        //   611: aload_0
        //   612: getfield 183	twitter4j/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   615: astore 5
        //   617: goto -127 -> 490
        //   620: aload_0
        //   621: getfield 192	twitter4j/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   624: astore 5
        //   626: goto -117 -> 509
        //   629: aload_0
        //   630: getfield 201	twitter4j/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   633: astore 5
        //   635: goto -107 -> 528
        //   638: aload_0
        //   639: getfield 207	twitter4j/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   642: astore 5
        //   644: goto -97 -> 547
        //   647: aload_0
        //   648: getfield 212	twitter4j/DirectMessageJSONImpl:extendedMediaEntities	[Ltwitter4j/MediaEntity;
        //   651: astore 5
        //   653: goto -87 -> 566
        //   656: astore_1
        //   657: new 102	twitter4j/TwitterException
        //   660: dup
        //   661: aload_1
        //   662: invokespecial 105	twitter4j/TwitterException:<init>	(Ljava/lang/Exception;)V
        //   665: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	666	0	this	DirectMessageJSONImpl
        //   0	666	1	paramJSONObject	JSONObject
        //   149	306	2	i	int
        //   1	424	3	j	int
        //   137	293	4	k	int
        //   111	541	5	localObject	Object
        //   130	243	6	localJSONArray	JSONArray
        // Exception table:
        //   from	to	target	type
        //   62	148	656	twitter4j/JSONException
        //   156	175	656	twitter4j/JSONException
        //   182	217	656	twitter4j/JSONException
        //   225	244	656	twitter4j/JSONException
        //   251	286	656	twitter4j/JSONException
        //   294	313	656	twitter4j/JSONException
        //   320	355	656	twitter4j/JSONException
        //   363	382	656	twitter4j/JSONException
        //   389	424	656	twitter4j/JSONException
        //   432	451	656	twitter4j/JSONException
        //   458	471	656	twitter4j/JSONException
        //   471	490	656	twitter4j/JSONException
        //   490	509	656	twitter4j/JSONException
        //   509	528	656	twitter4j/JSONException
        //   528	547	656	twitter4j/JSONException
        //   547	566	656	twitter4j/JSONException
        //   566	601	656	twitter4j/JSONException
        //   602	608	656	twitter4j/JSONException
        //   611	617	656	twitter4j/JSONException
        //   620	626	656	twitter4j/JSONException
        //   629	635	656	twitter4j/JSONException
        //   638	644	656	twitter4j/JSONException
        //   647	653	656	twitter4j/JSONException
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (paramObject == null) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (this == paramObject);
            if (!(paramObject instanceof DirectMessage)) {
                break;
            }
            bool1 = bool2;
        } while (((DirectMessage) paramObject).getId() == this.id);
        return false;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public MediaEntity[] getExtendedMediaEntities() {
        return this.extendedMediaEntities;
    }

    public HashtagEntity[] getHashtagEntities() {
        return this.hashtagEntities;
    }

    public long getId() {
        return this.id;
    }

    public MediaEntity[] getMediaEntities() {
        return this.mediaEntities;
    }

    public User getRecipient() {
        return this.recipient;
    }

    public long getRecipientId() {
        return this.recipientId;
    }

    public String getRecipientScreenName() {
        return this.recipientScreenName;
    }

    public User getSender() {
        return this.sender;
    }

    public long getSenderId() {
        return this.senderId;
    }

    public String getSenderScreenName() {
        return this.senderScreenName;
    }

    public SymbolEntity[] getSymbolEntities() {
        return this.symbolEntities;
    }

    public String getText() {
        return this.text;
    }

    public URLEntity[] getURLEntities() {
        return this.urlEntities;
    }

    public UserMentionEntity[] getUserMentionEntities() {
        return this.userMentionEntities;
    }

    public int hashCode() {
        return (int) this.id;
    }

    public String toString() {
        Object localObject2 = null;
        StringBuilder localStringBuilder = new StringBuilder().append("DirectMessageJSONImpl{id=").append(this.id).append(", text='").append(this.text).append('\'').append(", sender_id=").append(this.senderId).append(", recipient_id=").append(this.recipientId).append(", created_at=").append(this.createdAt).append(", userMentionEntities=");
        if (this.userMentionEntities == null) {
            localObject1 = null;
            localStringBuilder = localStringBuilder.append(localObject1).append(", urlEntities=");
            if (this.urlEntities != null) {
                break label287;
            }
            localObject1 = null;
            label116:
            localStringBuilder = localStringBuilder.append(localObject1).append(", hashtagEntities=");
            if (this.hashtagEntities != null) {
                break label298;
            }
            localObject1 = null;
            label137:
            localStringBuilder = localStringBuilder.append(localObject1).append(", sender_screen_name='").append(this.senderScreenName).append('\'').append(", recipient_screen_name='").append(this.recipientScreenName).append('\'').append(", sender=").append(this.sender).append(", recipient=").append(this.recipient).append(", userMentionEntities=");
            if (this.userMentionEntities != null) {
                break label309;
            }
            localObject1 = null;
            label220:
            localStringBuilder = localStringBuilder.append(localObject1).append(", urlEntities=");
            if (this.urlEntities != null) {
                break label320;
            }
            localObject1 = null;
            label241:
            localStringBuilder = localStringBuilder.append(localObject1).append(", hashtagEntities=");
            if (this.hashtagEntities != null) {
                break label331;
            }
        }
        label287:
        label298:
        label309:
        label320:
        label331:
        for (Object localObject1 = localObject2; ; localObject1 = Arrays.asList(this.hashtagEntities)) {
            return localObject1 + '}';
            localObject1 = Arrays.asList(this.userMentionEntities);
            break;
            localObject1 = Arrays.asList(this.urlEntities);
            break label116;
            localObject1 = Arrays.asList(this.hashtagEntities);
            break label137;
            localObject1 = Arrays.asList(this.userMentionEntities);
            break label220;
            localObject1 = Arrays.asList(this.urlEntities);
            break label241;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/DirectMessageJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */