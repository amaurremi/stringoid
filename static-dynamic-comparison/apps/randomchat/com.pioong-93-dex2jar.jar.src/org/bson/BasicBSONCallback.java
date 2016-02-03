package org.bson;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.bson.types.BSONTimestamp;
import org.bson.types.BasicBSONList;
import org.bson.types.Binary;
import org.bson.types.Code;
import org.bson.types.CodeWScope;
import org.bson.types.MaxKey;
import org.bson.types.MinKey;
import org.bson.types.ObjectId;

public class BasicBSONCallback
  implements BSONCallback
{
  private final LinkedList<String> _nameStack = new LinkedList();
  private Object _root;
  private final LinkedList<BSONObject> _stack = new LinkedList();
  
  public BasicBSONCallback()
  {
    reset();
  }
  
  protected void _put(String paramString, Object paramObject)
  {
    BSONObject localBSONObject = cur();
    if (!BSON.hasDecodeHooks()) {}
    for (;;)
    {
      localBSONObject.put(paramString, paramObject);
      return;
      paramObject = BSON.applyDecodingHooks(paramObject);
    }
  }
  
  public Object arrayDone()
  {
    return objectDone();
  }
  
  public void arrayStart()
  {
    objectStart(true);
  }
  
  public void arrayStart(String paramString)
  {
    objectStart(true, paramString);
  }
  
  public BSONObject create()
  {
    return new BasicBSONObject();
  }
  
  public BSONObject create(boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean) {
      return createList();
    }
    return create();
  }
  
  public BSONCallback createBSONCallback()
  {
    return new BasicBSONCallback();
  }
  
  protected BSONObject createList()
  {
    return new BasicBSONList();
  }
  
  protected BSONObject cur()
  {
    return (BSONObject)this._stack.getLast();
  }
  
  protected String curName()
  {
    if (!this._nameStack.isEmpty()) {
      return (String)this._nameStack.getLast();
    }
    return null;
  }
  
  public Object get()
  {
    return this._root;
  }
  
  public void gotBinary(String paramString, byte paramByte, byte[] paramArrayOfByte)
  {
    if ((paramByte == 0) || (paramByte == 2))
    {
      _put(paramString, paramArrayOfByte);
      return;
    }
    _put(paramString, new Binary(paramByte, paramArrayOfByte));
  }
  
  @Deprecated
  public void gotBinaryArray(String paramString, byte[] paramArrayOfByte)
  {
    gotBinary(paramString, (byte)0, paramArrayOfByte);
  }
  
  public void gotBoolean(String paramString, boolean paramBoolean)
  {
    _put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void gotCode(String paramString1, String paramString2)
  {
    _put(paramString1, new Code(paramString2));
  }
  
  public void gotCodeWScope(String paramString1, String paramString2, Object paramObject)
  {
    _put(paramString1, new CodeWScope(paramString2, (BSONObject)paramObject));
  }
  
  public void gotDBRef(String paramString1, String paramString2, ObjectId paramObjectId)
  {
    _put(paramString1, new BasicBSONObject("$ns", paramString2).append("$id", paramObjectId));
  }
  
  public void gotDate(String paramString, long paramLong)
  {
    _put(paramString, new Date(paramLong));
  }
  
  public void gotDouble(String paramString, double paramDouble)
  {
    _put(paramString, Double.valueOf(paramDouble));
  }
  
  public void gotInt(String paramString, int paramInt)
  {
    _put(paramString, Integer.valueOf(paramInt));
  }
  
  public void gotLong(String paramString, long paramLong)
  {
    _put(paramString, Long.valueOf(paramLong));
  }
  
  public void gotMaxKey(String paramString)
  {
    cur().put(paramString, new MaxKey());
  }
  
  public void gotMinKey(String paramString)
  {
    cur().put(paramString, new MinKey());
  }
  
  public void gotNull(String paramString)
  {
    cur().put(paramString, null);
  }
  
  public void gotObjectId(String paramString, ObjectId paramObjectId)
  {
    _put(paramString, paramObjectId);
  }
  
  public void gotRegex(String paramString1, String paramString2, String paramString3)
  {
    _put(paramString1, Pattern.compile(paramString2, BSON.regexFlags(paramString3)));
  }
  
  public void gotString(String paramString1, String paramString2)
  {
    _put(paramString1, paramString2);
  }
  
  public void gotSymbol(String paramString1, String paramString2)
  {
    _put(paramString1, paramString2);
  }
  
  public void gotTimestamp(String paramString, int paramInt1, int paramInt2)
  {
    _put(paramString, new BSONTimestamp(paramInt1, paramInt2));
  }
  
  public void gotUUID(String paramString, long paramLong1, long paramLong2)
  {
    _put(paramString, new UUID(paramLong1, paramLong2));
  }
  
  public void gotUndefined(String paramString) {}
  
  protected boolean isStackEmpty()
  {
    return this._stack.size() < 1;
  }
  
  public Object objectDone()
  {
    BSONObject localBSONObject = (BSONObject)this._stack.removeLast();
    if (this._nameStack.size() > 0) {
      this._nameStack.removeLast();
    }
    while (!BSON.hasDecodeHooks())
    {
      return localBSONObject;
      if (this._stack.size() > 0) {
        throw new IllegalStateException("something is wrong");
      }
    }
    return (BSONObject)BSON.applyDecodingHooks(localBSONObject);
  }
  
  public void objectStart()
  {
    if (this._stack.size() > 0) {
      throw new IllegalStateException("something is wrong");
    }
    objectStart(false);
  }
  
  public void objectStart(String paramString)
  {
    objectStart(false, paramString);
  }
  
  public void objectStart(boolean paramBoolean)
  {
    this._root = create(paramBoolean, null);
    this._stack.add((BSONObject)this._root);
  }
  
  public void objectStart(boolean paramBoolean, String paramString)
  {
    this._nameStack.addLast(paramString);
    BSONObject localBSONObject = create(paramBoolean, this._nameStack);
    ((BSONObject)this._stack.getLast()).put(paramString, localBSONObject);
    this._stack.addLast(localBSONObject);
  }
  
  public void reset()
  {
    this._root = null;
    this._stack.clear();
    this._nameStack.clear();
  }
  
  protected void setRoot(Object paramObject)
  {
    this._root = paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BasicBSONCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */