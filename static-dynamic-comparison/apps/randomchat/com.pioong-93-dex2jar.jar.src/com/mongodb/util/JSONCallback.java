package com.mongodb.util;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.BasicBSONCallback;
import org.bson.types.BSONTimestamp;
import org.bson.types.Binary;
import org.bson.types.Code;
import org.bson.types.CodeWScope;
import org.bson.types.MaxKey;
import org.bson.types.MinKey;
import org.bson.types.ObjectId;

public class JSONCallback
  extends BasicBSONCallback
{
  public static final String _msDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String _secDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  private boolean _lastArray = false;
  
  public BSONObject create()
  {
    return new BasicDBObject();
  }
  
  protected BSONObject createList()
  {
    return new BasicDBList();
  }
  
  public Object objectDone()
  {
    String str = curName();
    Object localObject = super.objectDone();
    if (this._lastArray) {
      return localObject;
    }
    BSONObject localBSONObject = (BSONObject)localObject;
    if (localBSONObject.containsField("$oid")) {
      localObject = new ObjectId((String)localBSONObject.get("$oid"));
    }
    while (!isStackEmpty())
    {
      _put(str, localObject);
      return localObject;
      if (localBSONObject.containsField("$date"))
      {
        if ((localBSONObject.get("$date") instanceof Number))
        {
          localObject = new Date(((Number)localBSONObject.get("$date")).longValue());
        }
        else
        {
          localObject = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
          ((SimpleDateFormat)localObject).setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
          Date localDate = ((SimpleDateFormat)localObject).parse(localBSONObject.get("$date").toString(), new ParsePosition(0));
          localObject = localDate;
          if (localDate == null)
          {
            localObject = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            ((SimpleDateFormat)localObject).setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
            localObject = ((SimpleDateFormat)localObject).parse(localBSONObject.get("$date").toString(), new ParsePosition(0));
          }
        }
      }
      else if (localBSONObject.containsField("$regex"))
      {
        localObject = Pattern.compile((String)localBSONObject.get("$regex"), BSON.regexFlags((String)localBSONObject.get("$options")));
      }
      else
      {
        int i;
        int j;
        if (localBSONObject.containsField("$ts"))
        {
          i = ((Number)localBSONObject.get("$ts")).intValue();
          j = ((Number)localBSONObject.get("$inc")).intValue();
          localObject = new BSONTimestamp(Integer.valueOf(i).intValue(), Integer.valueOf(j).intValue());
        }
        else if (localBSONObject.containsField("$timestamp"))
        {
          localObject = (BSONObject)localBSONObject.get("$timestamp");
          i = ((Number)((BSONObject)localObject).get("t")).intValue();
          j = ((Number)((BSONObject)localObject).get("i")).intValue();
          localObject = new BSONTimestamp(Integer.valueOf(i).intValue(), Integer.valueOf(j).intValue());
        }
        else if (localBSONObject.containsField("$code"))
        {
          if (localBSONObject.containsField("$scope")) {
            localObject = new CodeWScope((String)localBSONObject.get("$code"), (DBObject)localBSONObject.get("$scope"));
          } else {
            localObject = new Code((String)localBSONObject.get("$code"));
          }
        }
        else if (localBSONObject.containsField("$ref"))
        {
          localObject = new DBRef(null, (String)localBSONObject.get("$ref"), localBSONObject.get("$id"));
        }
        else if (localBSONObject.containsField("$minKey"))
        {
          localObject = new MinKey();
        }
        else if (localBSONObject.containsField("$maxKey"))
        {
          localObject = new MaxKey();
        }
        else if (localBSONObject.containsField("$uuid"))
        {
          localObject = UUID.fromString((String)localBSONObject.get("$uuid"));
        }
        else if (localBSONObject.containsField("$binary"))
        {
          i = ((Integer)localBSONObject.get("$type")).intValue();
          localObject = new Base64Codec().decode((String)localBSONObject.get("$binary"));
          localObject = new Binary((byte)i, (byte[])localObject);
        }
      }
    }
    if (!BSON.hasDecodeHooks()) {}
    for (;;)
    {
      setRoot(localObject);
      return localObject;
      localObject = BSON.applyDecodingHooks(localObject);
    }
  }
  
  public void objectStart(boolean paramBoolean, String paramString)
  {
    this._lastArray = paramBoolean;
    super.objectStart(paramBoolean, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/JSONCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */