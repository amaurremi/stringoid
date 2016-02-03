package com.mongodb.gridfs;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.BSONObject;

public abstract class GridFSFile
  implements DBObject
{
  static final Set<String> VALID_FIELDS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "_id", "filename", "contentType", "length", "chunkSize", "uploadDate", "aliases", "md5" })));
  List<String> _aliases;
  long _chunkSize;
  String _contentType;
  DBObject _extradata = new BasicDBObject();
  String _filename;
  protected GridFS _fs = null;
  Object _id;
  long _length;
  String _md5;
  Date _uploadDate;
  
  public boolean containsField(String paramString)
  {
    return keySet().contains(paramString);
  }
  
  @Deprecated
  public boolean containsKey(String paramString)
  {
    return containsField(paramString);
  }
  
  public Object get(String paramString)
  {
    if (paramString == null) {
      throw new RuntimeException("key should never be null");
    }
    if (paramString.equals("_id")) {
      return this._id;
    }
    if (paramString.equals("filename")) {
      return this._filename;
    }
    if (paramString.equals("contentType")) {
      return this._contentType;
    }
    if (paramString.equals("length")) {
      return Long.valueOf(this._length);
    }
    if (paramString.equals("chunkSize")) {
      return Long.valueOf(this._chunkSize);
    }
    if (paramString.equals("uploadDate")) {
      return this._uploadDate;
    }
    if (paramString.equals("md5")) {
      return this._md5;
    }
    return this._extradata.get(paramString);
  }
  
  public List<String> getAliases()
  {
    return (List)this._extradata.get("aliases");
  }
  
  public long getChunkSize()
  {
    return this._chunkSize;
  }
  
  public String getContentType()
  {
    return this._contentType;
  }
  
  public String getFilename()
  {
    return this._filename;
  }
  
  public Object getId()
  {
    return this._id;
  }
  
  public long getLength()
  {
    return this._length;
  }
  
  public String getMD5()
  {
    return this._md5;
  }
  
  public DBObject getMetaData()
  {
    return (DBObject)this._extradata.get("metadata");
  }
  
  public Date getUploadDate()
  {
    return this._uploadDate;
  }
  
  public boolean isPartialObject()
  {
    return false;
  }
  
  public Set<String> keySet()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(VALID_FIELDS);
    localHashSet.addAll(this._extradata.keySet());
    return localHashSet;
  }
  
  public void markAsPartialObject()
  {
    throw new RuntimeException("can't load partial GridFSFile file");
  }
  
  public int numChunks()
  {
    return (int)Math.ceil(this._length / this._chunkSize);
  }
  
  public Object put(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new RuntimeException("key should never be null");
    }
    if (paramString.equals("_id"))
    {
      this._id = paramObject;
      return paramObject;
    }
    if (paramString.equals("filename"))
    {
      if (paramObject == null) {}
      for (paramString = null;; paramString = paramObject.toString())
      {
        this._filename = paramString;
        return paramObject;
      }
    }
    if (paramString.equals("contentType"))
    {
      this._contentType = ((String)paramObject);
      return paramObject;
    }
    if (paramString.equals("length"))
    {
      this._length = ((Number)paramObject).longValue();
      return paramObject;
    }
    if (paramString.equals("chunkSize"))
    {
      this._chunkSize = ((Number)paramObject).longValue();
      return paramObject;
    }
    if (paramString.equals("uploadDate"))
    {
      this._uploadDate = ((Date)paramObject);
      return paramObject;
    }
    if (paramString.equals("md5"))
    {
      this._md5 = ((String)paramObject);
      return paramObject;
    }
    this._extradata.put(paramString, paramObject);
    return paramObject;
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public void putAll(BSONObject paramBSONObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object removeField(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void save()
  {
    if (this._fs == null) {
      throw new MongoException("need _fs");
    }
    this._fs._filesCollection.save(this);
  }
  
  protected void setGridFS(GridFS paramGridFS)
  {
    this._fs = paramGridFS;
  }
  
  public void setMetaData(DBObject paramDBObject)
  {
    this._extradata.put("metadata", paramDBObject);
  }
  
  public Map toMap()
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return JSON.serialize(this);
  }
  
  public void validate()
  {
    if (this._fs == null) {
      throw new MongoException("no _fs");
    }
    if (this._md5 == null) {
      throw new MongoException("no _md5 stored");
    }
    Object localObject = new BasicDBObject("filemd5", this._id);
    ((DBObject)localObject).put("root", this._fs._bucketName);
    localObject = this._fs._db.command((DBObject)localObject);
    if ((localObject != null) && (((DBObject)localObject).containsField("md5")))
    {
      localObject = ((DBObject)localObject).get("md5").toString();
      if (((String)localObject).equals(this._md5)) {
        return;
      }
      throw new MongoException("md5 differ.  mine [" + this._md5 + "] theirs [" + (String)localObject + "]");
    }
    throw new MongoException("no md5 returned from server: " + localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/gridfs/GridFSFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */