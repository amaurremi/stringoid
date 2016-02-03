package com.mongodb.gridfs;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.types.ObjectId;

public class GridFS
{
  public static final String DEFAULT_BUCKET = "fs";
  public static final int DEFAULT_CHUNKSIZE = 262144;
  public static final long MAX_CHUNKSIZE = 3500000L;
  protected final String _bucketName;
  protected final DBCollection _chunkCollection;
  protected final DB _db;
  protected final DBCollection _filesCollection;
  
  public GridFS(DB paramDB)
  {
    this(paramDB, "fs");
  }
  
  public GridFS(DB paramDB, String paramString)
  {
    this._db = paramDB;
    this._bucketName = paramString;
    this._filesCollection = this._db.getCollection(this._bucketName + ".files");
    this._chunkCollection = this._db.getCollection(this._bucketName + ".chunks");
    if (this._filesCollection.count() < 1000L) {
      this._filesCollection.ensureIndex(BasicDBObjectBuilder.start().add("filename", Integer.valueOf(1)).add("uploadDate", Integer.valueOf(1)).get());
    }
    if (this._chunkCollection.count() < 1000L) {
      this._chunkCollection.ensureIndex(BasicDBObjectBuilder.start().add("files_id", Integer.valueOf(1)).add("n", Integer.valueOf(1)).get(), BasicDBObjectBuilder.start().add("unique", Integer.valueOf(1)).get());
    }
    this._filesCollection.setObjectClass(GridFSDBFile.class);
  }
  
  protected GridFSDBFile _fix(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if (!(paramObject instanceof GridFSDBFile)) {
      throw new RuntimeException("somehow didn't get a GridFSDBFile");
    }
    paramObject = (GridFSDBFile)paramObject;
    ((GridFSDBFile)paramObject)._fs = this;
    return (GridFSDBFile)paramObject;
  }
  
  public GridFSInputFile createFile()
  {
    return new GridFSInputFile(this);
  }
  
  public GridFSInputFile createFile(File paramFile)
    throws IOException
  {
    return createFile(new FileInputStream(paramFile), paramFile.getName(), true);
  }
  
  public GridFSInputFile createFile(InputStream paramInputStream)
  {
    return createFile(paramInputStream, null);
  }
  
  public GridFSInputFile createFile(InputStream paramInputStream, String paramString)
  {
    return new GridFSInputFile(this, paramInputStream, paramString);
  }
  
  public GridFSInputFile createFile(InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    return new GridFSInputFile(this, paramInputStream, paramString, paramBoolean);
  }
  
  public GridFSInputFile createFile(InputStream paramInputStream, boolean paramBoolean)
  {
    return createFile(paramInputStream, null, paramBoolean);
  }
  
  public GridFSInputFile createFile(String paramString)
  {
    return new GridFSInputFile(this, paramString);
  }
  
  public GridFSInputFile createFile(byte[] paramArrayOfByte)
  {
    return createFile(new ByteArrayInputStream(paramArrayOfByte), true);
  }
  
  public GridFSDBFile find(ObjectId paramObjectId)
  {
    return findOne(paramObjectId);
  }
  
  public List<GridFSDBFile> find(DBObject paramDBObject)
  {
    return find(paramDBObject, null);
  }
  
  public List<GridFSDBFile> find(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    ArrayList localArrayList = new ArrayList();
    DBObject localDBObject = null;
    try
    {
      paramDBObject1 = this._filesCollection.find(paramDBObject1);
      if (paramDBObject2 != null)
      {
        localDBObject = paramDBObject1;
        paramDBObject1.sort(paramDBObject2);
      }
      for (;;)
      {
        localDBObject = paramDBObject1;
        if (!paramDBObject1.hasNext()) {
          break;
        }
        localDBObject = paramDBObject1;
        localArrayList.add(_fix(paramDBObject1.next()));
      }
      if (paramDBObject1 == null) {
        break label81;
      }
    }
    finally
    {
      if (localDBObject != null) {
        localDBObject.close();
      }
    }
    paramDBObject1.close();
    label81:
    return localArrayList;
  }
  
  public List<GridFSDBFile> find(String paramString)
  {
    return find(paramString, null);
  }
  
  public List<GridFSDBFile> find(String paramString, DBObject paramDBObject)
  {
    return find(new BasicDBObject("filename", paramString), paramDBObject);
  }
  
  public GridFSDBFile findOne(DBObject paramDBObject)
  {
    return _fix(this._filesCollection.findOne(paramDBObject));
  }
  
  public GridFSDBFile findOne(String paramString)
  {
    return findOne(new BasicDBObject("filename", paramString));
  }
  
  public GridFSDBFile findOne(ObjectId paramObjectId)
  {
    return findOne(new BasicDBObject("_id", paramObjectId));
  }
  
  public String getBucketName()
  {
    return this._bucketName;
  }
  
  public DB getDB()
  {
    return this._db;
  }
  
  public DBCursor getFileList()
  {
    return getFileList(new BasicDBObject());
  }
  
  public DBCursor getFileList(DBObject paramDBObject)
  {
    return getFileList(paramDBObject, new BasicDBObject("filename", Integer.valueOf(1)));
  }
  
  public DBCursor getFileList(DBObject paramDBObject1, DBObject paramDBObject2)
  {
    return this._filesCollection.find(paramDBObject1).sort(paramDBObject2);
  }
  
  public void remove(DBObject paramDBObject)
  {
    paramDBObject = find(paramDBObject).iterator();
    while (paramDBObject.hasNext()) {
      ((GridFSDBFile)paramDBObject.next()).remove();
    }
  }
  
  public void remove(String paramString)
  {
    remove(new BasicDBObject("filename", paramString));
  }
  
  public void remove(ObjectId paramObjectId)
  {
    this._filesCollection.remove(new BasicDBObject("_id", paramObjectId));
    this._chunkCollection.remove(new BasicDBObject("files_id", paramObjectId));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/gridfs/GridFS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */