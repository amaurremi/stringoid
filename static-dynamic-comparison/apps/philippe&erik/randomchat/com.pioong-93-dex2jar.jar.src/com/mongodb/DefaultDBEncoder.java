package com.mongodb;

import org.bson.BSONObject;
import org.bson.BasicBSONEncoder;
import org.bson.io.OutputBuffer;
import org.bson.types.ObjectId;

public class DefaultDBEncoder
  extends BasicBSONEncoder
  implements DBEncoder
{
  public static DBEncoderFactory FACTORY = new DefaultFactory();
  
  protected void putDBPointer(String paramString1, String paramString2, ObjectId paramObjectId)
  {
    _put((byte)12, paramString1);
    _putValueString(paramString2);
    this._buf.writeInt(paramObjectId._time());
    this._buf.writeInt(paramObjectId._machine());
    this._buf.writeInt(paramObjectId._inc());
  }
  
  protected void putDBRef(String paramString, DBRefBase paramDBRefBase)
  {
    _put((byte)3, paramString);
    int i = this._buf.getPosition();
    this._buf.writeInt(0);
    _putObjectField("$ref", paramDBRefBase.getRef());
    _putObjectField("$id", paramDBRefBase.getId());
    this._buf.write(0);
    this._buf.writeInt(i, this._buf.getPosition() - i);
  }
  
  protected boolean putSpecial(String paramString, Object paramObject)
  {
    if ((paramObject instanceof DBPointer))
    {
      paramObject = (DBPointer)paramObject;
      putDBPointer(paramString, ((DBPointer)paramObject)._ns, (ObjectId)((DBPointer)paramObject)._id);
      return true;
    }
    if ((paramObject instanceof DBRefBase))
    {
      putDBRef(paramString, (DBRefBase)paramObject);
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    return "DefaultDBEncoder";
  }
  
  public int writeObject(OutputBuffer paramOutputBuffer, BSONObject paramBSONObject)
  {
    set(paramOutputBuffer);
    int i = super.putObject(paramBSONObject);
    done();
    return i;
  }
  
  static class DefaultFactory
    implements DBEncoderFactory
  {
    public DBEncoder create()
    {
      return new DefaultDBEncoder();
    }
    
    public String toString()
    {
      return "DefaultDBEncoder.DefaultFactory";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DefaultDBEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */