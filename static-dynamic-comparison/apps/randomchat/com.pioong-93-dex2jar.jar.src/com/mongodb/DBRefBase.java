package com.mongodb;

public class DBRefBase
{
  final DB _db;
  final Object _id;
  private boolean _loadedPointedTo = false;
  final String _ns;
  private DBObject _pointedTo;
  
  public DBRefBase(DB paramDB, String paramString, Object paramObject)
  {
    this._db = paramDB;
    this._ns = paramString.intern();
    this._id = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DBRefBase)paramObject;
      if (this._id != null)
      {
        if (this._id.equals(((DBRefBase)paramObject)._id)) {}
      }
      else {
        while (((DBRefBase)paramObject)._id != null) {
          return false;
        }
      }
      if (this._ns == null) {
        break;
      }
    } while (this._ns.equals(((DBRefBase)paramObject)._ns));
    for (;;)
    {
      return false;
      if (((DBRefBase)paramObject)._ns == null) {
        break;
      }
    }
  }
  
  public DBObject fetch()
    throws MongoException
  {
    if (this._loadedPointedTo) {
      return this._pointedTo;
    }
    if (this._db == null) {
      throw new RuntimeException("no db");
    }
    this._pointedTo = this._db.getCollectionFromString(this._ns).findOne(this._id);
    this._loadedPointedTo = true;
    return this._pointedTo;
  }
  
  public DB getDB()
  {
    return this._db;
  }
  
  public Object getId()
  {
    return this._id;
  }
  
  public String getRef()
  {
    return this._ns;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this._id != null) {}
    for (int i = this._id.hashCode();; i = 0)
    {
      if (this._ns != null) {
        j = this._ns.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public String toString()
  {
    return "{ \"$ref\" : \"" + this._ns + "\", \"$id\" : \"" + this._id + "\" }";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBRefBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */