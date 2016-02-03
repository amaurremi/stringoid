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
        implements DirectMessage, Serializable {
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
            throws TwitterException {
        super(paramHttpResponse);
        paramHttpResponse = paramHttpResponse.asJSONObject();
        init(paramHttpResponse);
        if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse);
        }
    }

    DirectMessageJSONImpl(JSONObject paramJSONObject)
            throws TwitterException {
        init(paramJSONObject);
    }

    static ResponseList<DirectMessage> createDirectMessageList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        for (; ; ) {
            int i;
            try {
                if (paramConfiguration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.clearThreadLocalMap();
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
                        DataObjectFactoryUtil.registerJSONObject(localDirectMessageJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, localJSONArray);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramHttpResponse) {
                throw new TwitterException(paramHttpResponse);
            } catch (TwitterException paramHttpResponse) {
                throw paramHttpResponse;
            }
            i += 1;
        }
    }

    /* Error */
    private void init(JSONObject paramJSONObject)
            throws TwitterException {
        // Byte code:
        //   0: aload_0
        //   1: ldc 108
        //   3: aload_1
        //   4: invokestatic 114	twitter4j/internal/json/z_T4JInternalParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)J
        //   7: putfield 116	twitter4j/internal/json/DirectMessageJSONImpl:id	J
        //   10: aload_0
        //   11: ldc 118
        //   13: aload_1
        //   14: invokestatic 114	twitter4j/internal/json/z_T4JInternalParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)J
        //   17: putfield 120	twitter4j/internal/json/DirectMessageJSONImpl:senderId	J
        //   20: aload_0
        //   21: ldc 122
        //   23: aload_1
        //   24: invokestatic 114	twitter4j/internal/json/z_T4JInternalParseUtil:getLong	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)J
        //   27: putfield 124	twitter4j/internal/json/DirectMessageJSONImpl:recipientId	J
        //   30: aload_0
        //   31: ldc 126
        //   33: aload_1
        //   34: invokestatic 130	twitter4j/internal/json/z_T4JInternalParseUtil:getDate	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/util/Date;
        //   37: putfield 132	twitter4j/internal/json/DirectMessageJSONImpl:createdAt	Ljava/util/Date;
        //   40: aload_0
        //   41: ldc -122
        //   43: aload_1
        //   44: invokestatic 138	twitter4j/internal/json/z_T4JInternalParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
        //   47: putfield 140	twitter4j/internal/json/DirectMessageJSONImpl:senderScreenName	Ljava/lang/String;
        //   50: aload_0
        //   51: ldc -114
        //   53: aload_1
        //   54: invokestatic 138	twitter4j/internal/json/z_T4JInternalParseUtil:getUnescapedString	(Ljava/lang/String;Ltwitter4j/internal/org/json/JSONObject;)Ljava/lang/String;
        //   57: putfield 144	twitter4j/internal/json/DirectMessageJSONImpl:recipientScreenName	Ljava/lang/String;
        //   60: aload_0
        //   61: new 146	twitter4j/internal/json/UserJSONImpl
        //   64: dup
        //   65: aload_1
        //   66: ldc -109
        //   68: invokevirtual 152	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
        //   71: invokespecial 153	twitter4j/internal/json/UserJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   74: putfield 155	twitter4j/internal/json/DirectMessageJSONImpl:sender	Ltwitter4j/User;
        //   77: aload_0
        //   78: new 146	twitter4j/internal/json/UserJSONImpl
        //   81: dup
        //   82: aload_1
        //   83: ldc -100
        //   85: invokevirtual 152	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
        //   88: invokespecial 153	twitter4j/internal/json/UserJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   91: putfield 158	twitter4j/internal/json/DirectMessageJSONImpl:recipient	Ltwitter4j/User;
        //   94: aload_1
        //   95: ldc -96
        //   97: invokevirtual 164	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   100: ifne +341 -> 441
        //   103: aload_1
        //   104: ldc -96
        //   106: invokevirtual 152	twitter4j/internal/org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;
        //   109: astore 4
        //   111: aload 4
        //   113: ldc -90
        //   115: invokevirtual 164	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   118: ifne +59 -> 177
        //   121: aload 4
        //   123: ldc -90
        //   125: invokevirtual 170	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
        //   128: astore 5
        //   130: aload 5
        //   132: invokevirtual 85	twitter4j/internal/org/json/JSONArray:length	()I
        //   135: istore_3
        //   136: aload_0
        //   137: iload_3
        //   138: anewarray 172	twitter4j/UserMentionEntity
        //   141: putfield 174	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   144: iconst_0
        //   145: istore_2
        //   146: iload_2
        //   147: iload_3
        //   148: if_icmpge +29 -> 177
        //   151: aload_0
        //   152: getfield 174	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   155: iload_2
        //   156: new 176	twitter4j/internal/json/UserMentionEntityJSONImpl
        //   159: dup
        //   160: aload 5
        //   162: iload_2
        //   163: invokevirtual 94	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
        //   166: invokespecial 177	twitter4j/internal/json/UserMentionEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   169: aastore
        //   170: iload_2
        //   171: iconst_1
        //   172: iadd
        //   173: istore_2
        //   174: goto -28 -> 146
        //   177: aload 4
        //   179: ldc -77
        //   181: invokevirtual 164	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   184: ifne +59 -> 243
        //   187: aload 4
        //   189: ldc -77
        //   191: invokevirtual 170	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
        //   194: astore 5
        //   196: aload 5
        //   198: invokevirtual 85	twitter4j/internal/org/json/JSONArray:length	()I
        //   201: istore_3
        //   202: aload_0
        //   203: iload_3
        //   204: anewarray 181	twitter4j/URLEntity
        //   207: putfield 183	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   210: iconst_0
        //   211: istore_2
        //   212: iload_2
        //   213: iload_3
        //   214: if_icmpge +29 -> 243
        //   217: aload_0
        //   218: getfield 183	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   221: iload_2
        //   222: new 185	twitter4j/internal/json/URLEntityJSONImpl
        //   225: dup
        //   226: aload 5
        //   228: iload_2
        //   229: invokevirtual 94	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
        //   232: invokespecial 186	twitter4j/internal/json/URLEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   235: aastore
        //   236: iload_2
        //   237: iconst_1
        //   238: iadd
        //   239: istore_2
        //   240: goto -28 -> 212
        //   243: aload 4
        //   245: ldc -68
        //   247: invokevirtual 164	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   250: ifne +59 -> 309
        //   253: aload 4
        //   255: ldc -68
        //   257: invokevirtual 170	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
        //   260: astore 5
        //   262: aload 5
        //   264: invokevirtual 85	twitter4j/internal/org/json/JSONArray:length	()I
        //   267: istore_3
        //   268: aload_0
        //   269: iload_3
        //   270: anewarray 190	twitter4j/HashtagEntity
        //   273: putfield 192	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   276: iconst_0
        //   277: istore_2
        //   278: iload_2
        //   279: iload_3
        //   280: if_icmpge +29 -> 309
        //   283: aload_0
        //   284: getfield 192	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   287: iload_2
        //   288: new 194	twitter4j/internal/json/HashtagEntityJSONImpl
        //   291: dup
        //   292: aload 5
        //   294: iload_2
        //   295: invokevirtual 94	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
        //   298: invokespecial 195	twitter4j/internal/json/HashtagEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   301: aastore
        //   302: iload_2
        //   303: iconst_1
        //   304: iadd
        //   305: istore_2
        //   306: goto -28 -> 278
        //   309: aload 4
        //   311: ldc -59
        //   313: invokevirtual 164	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   316: ifne +59 -> 375
        //   319: aload 4
        //   321: ldc -59
        //   323: invokevirtual 170	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
        //   326: astore 5
        //   328: aload 5
        //   330: invokevirtual 85	twitter4j/internal/org/json/JSONArray:length	()I
        //   333: istore_3
        //   334: aload_0
        //   335: iload_3
        //   336: anewarray 199	twitter4j/SymbolEntity
        //   339: putfield 201	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   342: iconst_0
        //   343: istore_2
        //   344: iload_2
        //   345: iload_3
        //   346: if_icmpge +29 -> 375
        //   349: aload_0
        //   350: getfield 201	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   353: iload_2
        //   354: new 194	twitter4j/internal/json/HashtagEntityJSONImpl
        //   357: dup
        //   358: aload 5
        //   360: iload_2
        //   361: invokevirtual 94	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
        //   364: invokespecial 195	twitter4j/internal/json/HashtagEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   367: aastore
        //   368: iload_2
        //   369: iconst_1
        //   370: iadd
        //   371: istore_2
        //   372: goto -28 -> 344
        //   375: aload 4
        //   377: ldc -53
        //   379: invokevirtual 164	twitter4j/internal/org/json/JSONObject:isNull	(Ljava/lang/String;)Z
        //   382: ifne +59 -> 441
        //   385: aload 4
        //   387: ldc -53
        //   389: invokevirtual 170	twitter4j/internal/org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONArray;
        //   392: astore 4
        //   394: aload 4
        //   396: invokevirtual 85	twitter4j/internal/org/json/JSONArray:length	()I
        //   399: istore_3
        //   400: aload_0
        //   401: iload_3
        //   402: anewarray 205	twitter4j/MediaEntity
        //   405: putfield 207	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   408: iconst_0
        //   409: istore_2
        //   410: iload_2
        //   411: iload_3
        //   412: if_icmpge +29 -> 441
        //   415: aload_0
        //   416: getfield 207	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   419: iload_2
        //   420: new 209	twitter4j/internal/json/MediaEntityJSONImpl
        //   423: dup
        //   424: aload 4
        //   426: iload_2
        //   427: invokevirtual 94	twitter4j/internal/org/json/JSONArray:getJSONObject	(I)Ltwitter4j/internal/org/json/JSONObject;
        //   430: invokespecial 210	twitter4j/internal/json/MediaEntityJSONImpl:<init>	(Ltwitter4j/internal/org/json/JSONObject;)V
        //   433: aastore
        //   434: iload_2
        //   435: iconst_1
        //   436: iadd
        //   437: istore_2
        //   438: goto -28 -> 410
        //   441: aload_0
        //   442: getfield 174	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   445: ifnonnull +121 -> 566
        //   448: iconst_0
        //   449: anewarray 172	twitter4j/UserMentionEntity
        //   452: astore 4
        //   454: aload_0
        //   455: aload 4
        //   457: putfield 174	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   460: aload_0
        //   461: getfield 183	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   464: ifnonnull +111 -> 575
        //   467: iconst_0
        //   468: anewarray 181	twitter4j/URLEntity
        //   471: astore 4
        //   473: aload_0
        //   474: aload 4
        //   476: putfield 183	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   479: aload_0
        //   480: getfield 192	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   483: ifnonnull +101 -> 584
        //   486: iconst_0
        //   487: anewarray 190	twitter4j/HashtagEntity
        //   490: astore 4
        //   492: aload_0
        //   493: aload 4
        //   495: putfield 192	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   498: aload_0
        //   499: getfield 201	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   502: ifnonnull +91 -> 593
        //   505: iconst_0
        //   506: anewarray 199	twitter4j/SymbolEntity
        //   509: astore 4
        //   511: aload_0
        //   512: aload 4
        //   514: putfield 201	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   517: aload_0
        //   518: getfield 207	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   521: ifnonnull +81 -> 602
        //   524: iconst_0
        //   525: anewarray 205	twitter4j/MediaEntity
        //   528: astore 4
        //   530: aload_0
        //   531: aload 4
        //   533: putfield 207	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   536: aload_0
        //   537: aload_1
        //   538: ldc -45
        //   540: invokevirtual 215	twitter4j/internal/org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   543: aload_0
        //   544: getfield 174	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   547: aload_0
        //   548: getfield 183	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   551: aload_0
        //   552: getfield 192	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   555: aload_0
        //   556: getfield 207	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   559: invokestatic 221	twitter4j/internal/json/HTMLEntity:unescapeAndSlideEntityIncdices	(Ljava/lang/String;[Ltwitter4j/UserMentionEntity;[Ltwitter4j/URLEntity;[Ltwitter4j/HashtagEntity;[Ltwitter4j/MediaEntity;)Ljava/lang/String;
        //   562: putfield 223	twitter4j/internal/json/DirectMessageJSONImpl:text	Ljava/lang/String;
        //   565: return
        //   566: aload_0
        //   567: getfield 174	twitter4j/internal/json/DirectMessageJSONImpl:userMentionEntities	[Ltwitter4j/UserMentionEntity;
        //   570: astore 4
        //   572: goto -118 -> 454
        //   575: aload_0
        //   576: getfield 183	twitter4j/internal/json/DirectMessageJSONImpl:urlEntities	[Ltwitter4j/URLEntity;
        //   579: astore 4
        //   581: goto -108 -> 473
        //   584: aload_0
        //   585: getfield 192	twitter4j/internal/json/DirectMessageJSONImpl:hashtagEntities	[Ltwitter4j/HashtagEntity;
        //   588: astore 4
        //   590: goto -98 -> 492
        //   593: aload_0
        //   594: getfield 201	twitter4j/internal/json/DirectMessageJSONImpl:symbolEntities	[Ltwitter4j/SymbolEntity;
        //   597: astore 4
        //   599: goto -88 -> 511
        //   602: aload_0
        //   603: getfield 207	twitter4j/internal/json/DirectMessageJSONImpl:mediaEntities	[Ltwitter4j/MediaEntity;
        //   606: astore 4
        //   608: goto -78 -> 530
        //   611: astore_1
        //   612: new 38	twitter4j/TwitterException
        //   615: dup
        //   616: aload_1
        //   617: invokespecial 105	twitter4j/TwitterException:<init>	(Ljava/lang/Exception;)V
        //   620: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	621	0	this	DirectMessageJSONImpl
        //   0	621	1	paramJSONObject	JSONObject
        //   145	293	2	i	int
        //   135	278	3	j	int
        //   109	498	4	localObject	Object
        //   128	231	5	localJSONArray	JSONArray
        // Exception table:
        //   from	to	target	type
        //   60	144	611	twitter4j/internal/org/json/JSONException
        //   151	170	611	twitter4j/internal/org/json/JSONException
        //   177	210	611	twitter4j/internal/org/json/JSONException
        //   217	236	611	twitter4j/internal/org/json/JSONException
        //   243	276	611	twitter4j/internal/org/json/JSONException
        //   283	302	611	twitter4j/internal/org/json/JSONException
        //   309	342	611	twitter4j/internal/org/json/JSONException
        //   349	368	611	twitter4j/internal/org/json/JSONException
        //   375	408	611	twitter4j/internal/org/json/JSONException
        //   415	434	611	twitter4j/internal/org/json/JSONException
        //   441	454	611	twitter4j/internal/org/json/JSONException
        //   454	473	611	twitter4j/internal/org/json/JSONException
        //   473	492	611	twitter4j/internal/org/json/JSONException
        //   492	511	611	twitter4j/internal/org/json/JSONException
        //   511	530	611	twitter4j/internal/org/json/JSONException
        //   530	565	611	twitter4j/internal/org/json/JSONException
        //   566	572	611	twitter4j/internal/org/json/JSONException
        //   575	581	611	twitter4j/internal/org/json/JSONException
        //   584	590	611	twitter4j/internal/org/json/JSONException
        //   593	599	611	twitter4j/internal/org/json/JSONException
        //   602	608	611	twitter4j/internal/org/json/JSONException
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/DirectMessageJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */