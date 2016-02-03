package com.mongodb;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocketFactory;

public class MongoClientURI
{
  static final Logger LOGGER = Logger.getLogger("com.mongodb.MongoURI");
  private static final String PREFIX = "mongodb://";
  private static final String UTF_8 = "UTF-8";
  static Set<String> allKeys;
  static Set<String> authKeys;
  static Set<String> generalOptionsKeys = new HashSet();
  static Set<String> readPreferenceKeys;
  static Set<String> writeConcernKeys;
  private final String collection;
  private final MongoCredential credentials;
  private final String database;
  private final List<String> hosts;
  private final MongoClientOptions options;
  private final String uri;
  
  static
  {
    authKeys = new HashSet();
    readPreferenceKeys = new HashSet();
    writeConcernKeys = new HashSet();
    allKeys = new HashSet();
    generalOptionsKeys.add("maxpoolsize");
    generalOptionsKeys.add("waitqueuemultiple");
    generalOptionsKeys.add("waitqueuetimeoutms");
    generalOptionsKeys.add("connecttimeoutms");
    generalOptionsKeys.add("sockettimeoutms");
    generalOptionsKeys.add("sockettimeoutms");
    generalOptionsKeys.add("autoconnectretry");
    generalOptionsKeys.add("ssl");
    readPreferenceKeys.add("slaveok");
    readPreferenceKeys.add("readpreference");
    readPreferenceKeys.add("readpreferencetags");
    writeConcernKeys.add("safe");
    writeConcernKeys.add("w");
    writeConcernKeys.add("wtimeout");
    writeConcernKeys.add("fsync");
    writeConcernKeys.add("j");
    authKeys.add("authmechanism");
    authKeys.add("authsource");
    allKeys.addAll(generalOptionsKeys);
    allKeys.addAll(authKeys);
    allKeys.addAll(readPreferenceKeys);
    allKeys.addAll(writeConcernKeys);
  }
  
  public MongoClientURI(String paramString)
  {
    this(paramString, new MongoClientOptions.Builder());
  }
  
  public MongoClientURI(String paramString, MongoClientOptions.Builder paramBuilder)
  {
    try
    {
      this.uri = paramString;
      if (!paramString.startsWith("mongodb://")) {
        throw new IllegalArgumentException("uri needs to start with mongodb://");
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new MongoInternalException("This should not happen", paramString);
    }
    paramString = paramString.substring("mongodb://".length());
    String str3 = null;
    Object localObject2 = null;
    int i = paramString.lastIndexOf("/");
    if (i < 0)
    {
      if (!paramString.contains("?")) {
        break label372;
      }
      throw new IllegalArgumentException("URI contains options without trailing slash");
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      i = str2.indexOf("@");
      Object localObject1 = localObject2;
      String str4 = str2;
      if (i > 0)
      {
        localObject1 = str2.substring(0, i);
        str4 = str2.substring(i + 1);
        i = ((String)localObject1).indexOf(":");
        if (i == -1)
        {
          str3 = URLDecoder.decode((String)localObject1, "UTF-8");
          localObject1 = localObject2;
        }
      }
      else
      {
        label160:
        Collections.addAll(localLinkedList, str4.split(","));
        this.hosts = Collections.unmodifiableList(localLinkedList);
        if ((paramString == null) || (paramString.isEmpty())) {
          break label359;
        }
        i = paramString.indexOf(".");
        if (i >= 0) {
          break label335;
        }
        this.database = paramString;
        this.collection = null;
      }
      for (;;)
      {
        paramString = parseOptions(str1);
        this.options = createOptions(paramString, paramBuilder);
        this.credentials = createCredentials(paramString, str3, (char[])localObject1, this.database);
        warnOnUnsupportedOptions(paramString);
        return;
        str2 = paramString.substring(0, i);
        paramString = paramString.substring(i + 1);
        i = paramString.indexOf("?");
        if (i < 0) {
          break label384;
        }
        str1 = paramString.substring(i + 1);
        paramString = paramString.substring(0, i);
        break;
        str3 = URLDecoder.decode(((String)localObject1).substring(0, i), "UTF-8");
        localObject1 = URLDecoder.decode(((String)localObject1).substring(i + 1), "UTF-8").toCharArray();
        break label160;
        label335:
        this.database = paramString.substring(0, i);
        this.collection = paramString.substring(i + 1);
        continue;
        label359:
        this.database = null;
        this.collection = null;
      }
      label372:
      String str2 = paramString;
      paramString = null;
      String str1 = "";
      continue;
      label384:
      str1 = "";
    }
  }
  
  private ReadPreference buildReadPreference(String paramString, DBObject paramDBObject, List<DBObject> paramList, Boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (paramDBObject == null) {
        return ReadPreference.valueOf(paramString);
      }
      return ReadPreference.valueOf(paramString, paramDBObject, (DBObject[])paramList.toArray(new DBObject[paramList.size()]));
    }
    if ((paramBoolean != null) && (paramBoolean.equals(Boolean.TRUE))) {
      return ReadPreference.secondaryPreferred();
    }
    return null;
  }
  
  private WriteConcern buildWriteConcern(Boolean paramBoolean, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString != null) || (paramInt != 0) || (paramBoolean1) || (paramBoolean2))
    {
      if (paramString == null) {
        return new WriteConcern(1, paramInt, paramBoolean1, paramBoolean2);
      }
      try
      {
        paramBoolean = new WriteConcern(Integer.parseInt(paramString), paramInt, paramBoolean1, paramBoolean2);
        return paramBoolean;
      }
      catch (NumberFormatException paramBoolean)
      {
        return new WriteConcern(paramString, paramInt, paramBoolean1, paramBoolean2);
      }
    }
    if (paramBoolean != null)
    {
      if (paramBoolean.booleanValue()) {
        return WriteConcern.ACKNOWLEDGED;
      }
      return WriteConcern.UNACKNOWLEDGED;
    }
    return null;
  }
  
  private MongoCredential createCredentials(Map<String, List<String>> paramMap, String paramString1, char[] paramArrayOfChar, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = "admin";
    }
    paramString2 = "MONGODB-CR";
    Iterator localIterator = authKeys.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = getLastValue(paramMap, str2);
      if (str1 != null) {
        if (str2.equals("authmechanism")) {
          paramString2 = str1;
        } else if (str2.equals("authsource")) {
          localObject = str1;
        }
      }
    }
    if (paramString2.equals("GSSAPI")) {
      return MongoCredential.createGSSAPICredential(paramString1);
    }
    if (paramString2.equals("MONGODB-CR")) {
      return MongoCredential.createMongoCRCredential(paramString1, (String)localObject, paramArrayOfChar);
    }
    throw new IllegalArgumentException("Unsupported authMechanism: " + paramString2);
  }
  
  private MongoClientOptions createOptions(Map<String, List<String>> paramMap, MongoClientOptions.Builder paramBuilder)
  {
    Object localObject = generalOptionsKeys.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = getLastValue(paramMap, str1);
      if (str2 != null) {
        if (str1.equals("maxpoolsize")) {
          paramBuilder.connectionsPerHost(Integer.parseInt(str2));
        } else if (str1.equals("waitqueuemultiple")) {
          paramBuilder.threadsAllowedToBlockForConnectionMultiplier(Integer.parseInt(str2));
        } else if (str1.equals("waitqueuetimeoutms")) {
          paramBuilder.maxWaitTime(Integer.parseInt(str2));
        } else if (str1.equals("connecttimeoutms")) {
          paramBuilder.connectTimeout(Integer.parseInt(str2));
        } else if (str1.equals("sockettimeoutms")) {
          paramBuilder.socketTimeout(Integer.parseInt(str2));
        } else if (str1.equals("autoconnectretry")) {
          paramBuilder.autoConnectRetry(_parseBoolean(str2));
        } else if ((str1.equals("ssl")) && (_parseBoolean(str2))) {
          paramBuilder.socketFactory(SSLSocketFactory.getDefault());
        }
      }
    }
    localObject = createWriteConcern(paramMap);
    paramMap = createReadPreference(paramMap);
    if (localObject != null) {
      paramBuilder.writeConcern((WriteConcern)localObject);
    }
    if (paramMap != null) {
      paramBuilder.readPreference(paramMap);
    }
    return paramBuilder.build();
  }
  
  private ReadPreference createReadPreference(Map<String, List<String>> paramMap)
  {
    Boolean localBoolean = null;
    Object localObject1 = null;
    Object localObject2 = null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = readPreferenceKeys.iterator();
    while (localIterator.hasNext())
    {
      Object localObject4 = (String)localIterator.next();
      Object localObject3 = getLastValue(paramMap, (String)localObject4);
      if (localObject3 != null) {
        if (((String)localObject4).equals("slaveok"))
        {
          localBoolean = Boolean.valueOf(_parseBoolean((String)localObject3));
        }
        else if (((String)localObject4).equals("readpreference"))
        {
          localObject1 = localObject3;
        }
        else if (((String)localObject4).equals("readpreferencetags"))
        {
          localObject4 = ((List)paramMap.get(localObject4)).iterator();
          localObject3 = localObject2;
          for (;;)
          {
            localObject2 = localObject3;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject2 = getTagSet(((String)((Iterator)localObject4).next()).trim());
            if (localObject3 == null) {
              localObject3 = localObject2;
            } else {
              localArrayList.add(localObject2);
            }
          }
        }
      }
    }
    return buildReadPreference((String)localObject1, (DBObject)localObject2, localArrayList, localBoolean);
  }
  
  private WriteConcern createWriteConcern(Map<String, List<String>> paramMap)
  {
    Boolean localBoolean = null;
    Object localObject = null;
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    Iterator localIterator = writeConcernKeys.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = getLastValue(paramMap, str2);
      if (str1 != null) {
        if (str2.equals("safe")) {
          localBoolean = Boolean.valueOf(_parseBoolean(str1));
        } else if (str2.equals("w")) {
          localObject = str1;
        } else if (str2.equals("wtimeout")) {
          i = Integer.parseInt(str1);
        } else if (str2.equals("fsync")) {
          bool2 = _parseBoolean(str1);
        } else if (str2.equals("j")) {
          bool1 = _parseBoolean(str1);
        }
      }
    }
    return buildWriteConcern(localBoolean, (String)localObject, i, bool2, bool1);
  }
  
  private String getLastValue(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if (paramMap == null) {
      return null;
    }
    return (String)paramMap.get(paramMap.size() - 1);
  }
  
  private DBObject getTagSet(String paramString)
  {
    BasicDBObject localBasicDBObject = new BasicDBObject();
    if (paramString.length() > 0)
    {
      String[] arrayOfString1 = paramString.split(",");
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString2 = arrayOfString1[i].split(":");
        if (arrayOfString2.length != 2) {
          throw new IllegalArgumentException("Bad read preference tags: " + paramString);
        }
        localBasicDBObject.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
        i += 1;
      }
    }
    return localBasicDBObject;
  }
  
  private Map<String, List<String>> parseOptions(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.split("&|;");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = arrayOfString[i];
      int k = paramString.indexOf("=");
      if (k >= 0)
      {
        String str1 = paramString.substring(0, k).toLowerCase();
        String str2 = paramString.substring(k + 1);
        List localList = (List)localHashMap.get(str1);
        paramString = localList;
        if (localList == null) {
          paramString = new ArrayList(1);
        }
        paramString.add(str2);
        localHashMap.put(str1, paramString);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private void warnOnUnsupportedOptions(Map<String, List<String>> paramMap)
  {
    paramMap = paramMap.keySet().iterator();
    while (paramMap.hasNext())
    {
      String str = (String)paramMap.next();
      if (!allKeys.contains(str)) {
        LOGGER.warning("Unknown or Unsupported Option '" + str + "'");
      }
    }
  }
  
  boolean _parseBoolean(String paramString)
  {
    paramString = paramString.trim();
    return (paramString != null) && (paramString.length() > 0) && ((paramString.equals("1")) || (paramString.toLowerCase().equals("true")) || (paramString.toLowerCase().equals("yes")));
  }
  
  public String getCollection()
  {
    return this.collection;
  }
  
  public MongoCredential getCredentials()
  {
    return this.credentials;
  }
  
  public String getDatabase()
  {
    return this.database;
  }
  
  public List<String> getHosts()
  {
    return this.hosts;
  }
  
  public MongoClientOptions getOptions()
  {
    return this.options;
  }
  
  public char[] getPassword()
  {
    if (this.credentials != null) {
      return this.credentials.getPassword();
    }
    return null;
  }
  
  public String getURI()
  {
    return this.uri;
  }
  
  public String getUsername()
  {
    if (this.credentials != null) {
      return this.credentials.getUserName();
    }
    return null;
  }
  
  public String toString()
  {
    return this.uri;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/MongoClientURI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */