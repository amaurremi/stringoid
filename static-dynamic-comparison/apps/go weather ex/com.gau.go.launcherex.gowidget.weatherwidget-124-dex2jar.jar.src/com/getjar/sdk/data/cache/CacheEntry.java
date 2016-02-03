package com.getjar.sdk.data.cache;

import android.database.Cursor;
import com.getjar.sdk.utilities.StringUtility;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class CacheEntry
{
  private final Long _createTimestamp;
  private final String _etag;
  private int _id;
  private final Long _lastUpdated;
  private final String _name;
  private final Long _ttl;
  private final URI _uri;
  private final String _value;
  
  protected CacheEntry(Cursor paramCursor)
    throws URISyntaxException
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("'dbCursor' can not be NULL");
    }
    if ((paramCursor.isBeforeFirst()) || (paramCursor.isAfterLast())) {
      throw new IllegalArgumentException("'dbCursor' must already be pointing to a valid record");
    }
    this._id = paramCursor.getInt(0);
    this._name = paramCursor.getString(1);
    if (!paramCursor.isNull(2))
    {
      this._value = paramCursor.getString(2);
      this._createTimestamp = Long.valueOf(paramCursor.getLong(3));
      this._lastUpdated = Long.valueOf(paramCursor.getLong(4));
      this._ttl = Long.valueOf(paramCursor.getLong(5));
      if (paramCursor.isNull(6)) {
        break label210;
      }
      String str = paramCursor.getString(6);
      if (StringUtility.isNullOrEmpty(str)) {
        break label202;
      }
      this._uri = new URI(str);
    }
    for (;;)
    {
      if (paramCursor.isNull(7)) {
        break label218;
      }
      this._etag = paramCursor.getString(7);
      return;
      this._value = null;
      break;
      label202:
      this._uri = null;
      continue;
      label210:
      this._uri = null;
    }
    label218:
    this._etag = null;
  }
  
  protected CacheEntry(String paramString1, String paramString2, Long paramLong, String paramString3, URI paramURI)
  {
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'name' can not be NULL or empty");
    }
    if (paramLong == null) {
      throw new IllegalArgumentException("'ttl' can not be NULL");
    }
    this._name = paramString1;
    this._value = paramString2;
    this._createTimestamp = Long.valueOf(System.currentTimeMillis());
    this._lastUpdated = this._createTimestamp;
    this._ttl = paramLong;
    this._uri = paramURI;
    this._etag = paramString3;
  }
  
  public Long getCreateTimestamp()
  {
    return this._createTimestamp;
  }
  
  public String getEtag()
  {
    return this._etag;
  }
  
  protected int getId()
  {
    return this._id;
  }
  
  public Long getLastUpdated()
  {
    return this._lastUpdated;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public Long getTtl()
  {
    return this._ttl;
  }
  
  public URI getUri()
  {
    return this._uri;
  }
  
  public String getValue()
  {
    return this._value;
  }
  
  public boolean hasTtlExpired()
  {
    long l = System.currentTimeMillis();
    return getLastUpdated().longValue() + getTtl().longValue() < l;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%1$s = %2$s [lastUpdated:%3$d ttl:%4$d etag:%5$s uri:%6$s]", new Object[] { this._name, this._value, this._lastUpdated, this._ttl, this._etag, this._uri });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/cache/CacheEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */