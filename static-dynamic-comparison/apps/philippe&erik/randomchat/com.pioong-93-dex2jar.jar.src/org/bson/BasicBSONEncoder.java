package org.bson;

import com.mongodb.DBRefBase;
import com.mongodb.util.MyAsserts;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import org.bson.io.BasicOutputBuffer;
import org.bson.io.OutputBuffer;
import org.bson.types.BSONTimestamp;
import org.bson.types.Binary;
import org.bson.types.Code;
import org.bson.types.CodeWScope;
import org.bson.types.MaxKey;
import org.bson.types.MinKey;
import org.bson.types.ObjectId;
import org.bson.types.Symbol;

public class BasicBSONEncoder
  implements BSONEncoder
{
  static final boolean DEBUG = false;
  protected OutputBuffer _buf;
  
  private void _putString(String paramString1, String paramString2, byte paramByte)
  {
    _put(paramByte, paramString1);
    _putValueString(paramString2);
  }
  
  private void putArray(String paramString, Object paramObject)
  {
    _put((byte)4, paramString);
    int j = this._buf.getPosition();
    this._buf.writeInt(0);
    int k = Array.getLength(paramObject);
    int i = 0;
    while (i < k)
    {
      _putObjectField(String.valueOf(i), Array.get(paramObject, i));
      i += 1;
    }
    this._buf.write(0);
    this._buf.writeInt(j, this._buf.getPosition() - j);
  }
  
  private void putBinary(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    _put((byte)5, paramString);
    int j = paramArrayOfByte.length;
    int i = j;
    if (paramInt == 2) {
      i = j + 4;
    }
    this._buf.writeInt(i);
    this._buf.write(paramInt);
    if (paramInt == 2) {
      this._buf.writeInt(i - 4);
    }
    paramInt = this._buf.getPosition();
    this._buf.write(paramArrayOfByte);
    MyAsserts.assertEquals(this._buf.getPosition() - paramInt, paramArrayOfByte.length);
  }
  
  private void putIterable(String paramString, Iterable paramIterable)
  {
    _put((byte)4, paramString);
    int j = this._buf.getPosition();
    this._buf.writeInt(0);
    int i = 0;
    paramString = paramIterable.iterator();
    while (paramString.hasNext())
    {
      _putObjectField(String.valueOf(i), paramString.next());
      i += 1;
    }
    this._buf.write(0);
    this._buf.writeInt(j, this._buf.getPosition() - j);
  }
  
  private void putMap(String paramString, Map paramMap)
  {
    _put((byte)3, paramString);
    int i = this._buf.getPosition();
    this._buf.writeInt(0);
    paramString = paramMap.entrySet().iterator();
    while (paramString.hasNext())
    {
      paramMap = (Map.Entry)paramString.next();
      _putObjectField(paramMap.getKey().toString(), paramMap.getValue());
    }
    this._buf.write(0);
    this._buf.writeInt(i, this._buf.getPosition() - i);
  }
  
  private void putMaxKey(String paramString)
  {
    _put((byte)Byte.MAX_VALUE, paramString);
  }
  
  private void putMinKey(String paramString)
  {
    _put((byte)-1, paramString);
  }
  
  private void putPattern(String paramString, Pattern paramPattern)
  {
    _put((byte)11, paramString);
    _put(paramPattern.pattern());
    _put(BSON.regexFlags(paramPattern.flags()));
  }
  
  protected int _put(String paramString)
  {
    int k = paramString.length();
    int i = 0;
    int j = 0;
    if (j < k)
    {
      int m = Character.codePointAt(paramString, j);
      if (m < 128)
      {
        this._buf.write((byte)m);
        i += 1;
      }
      for (;;)
      {
        j += Character.charCount(m);
        break;
        if (m < 2048)
        {
          this._buf.write((byte)((m >> 6) + 192));
          this._buf.write((byte)((m & 0x3F) + 128));
          i += 2;
        }
        else if (m < 65536)
        {
          this._buf.write((byte)((m >> 12) + 224));
          this._buf.write((byte)((m >> 6 & 0x3F) + 128));
          this._buf.write((byte)((m & 0x3F) + 128));
          i += 3;
        }
        else
        {
          this._buf.write((byte)((m >> 18) + 240));
          this._buf.write((byte)((m >> 12 & 0x3F) + 128));
          this._buf.write((byte)((m >> 6 & 0x3F) + 128));
          this._buf.write((byte)((m & 0x3F) + 128));
          i += 4;
        }
      }
    }
    this._buf.write(0);
    return i + 1;
  }
  
  protected void _put(byte paramByte, String paramString)
  {
    this._buf.write(paramByte);
    _put(paramString);
  }
  
  protected void _putObjectField(String paramString, Object paramObject)
  {
    if (paramString.equals("_transientFields")) {}
    do
    {
      return;
      if ((paramString.equals("$where")) && ((paramObject instanceof String)))
      {
        _put((byte)13, paramString);
        _putValueString(paramObject.toString());
        return;
      }
      paramObject = BSON.applyEncodingHooks(paramObject);
      if (paramObject == null)
      {
        putNull(paramString);
        return;
      }
      if ((paramObject instanceof Date))
      {
        putDate(paramString, (Date)paramObject);
        return;
      }
      if ((paramObject instanceof Number))
      {
        putNumber(paramString, (Number)paramObject);
        return;
      }
      if ((paramObject instanceof Character))
      {
        putString(paramString, paramObject.toString());
        return;
      }
      if ((paramObject instanceof String))
      {
        putString(paramString, paramObject.toString());
        return;
      }
      if ((paramObject instanceof ObjectId))
      {
        putObjectId(paramString, (ObjectId)paramObject);
        return;
      }
      if ((paramObject instanceof BSONObject))
      {
        putObject(paramString, (BSONObject)paramObject);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        putBoolean(paramString, (Boolean)paramObject);
        return;
      }
      if ((paramObject instanceof Pattern))
      {
        putPattern(paramString, (Pattern)paramObject);
        return;
      }
      if ((paramObject instanceof Map))
      {
        putMap(paramString, (Map)paramObject);
        return;
      }
      if ((paramObject instanceof Iterable))
      {
        putIterable(paramString, (Iterable)paramObject);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        putBinary(paramString, (byte[])paramObject);
        return;
      }
      if ((paramObject instanceof Binary))
      {
        putBinary(paramString, (Binary)paramObject);
        return;
      }
      if ((paramObject instanceof UUID))
      {
        putUUID(paramString, (UUID)paramObject);
        return;
      }
      if (paramObject.getClass().isArray())
      {
        putArray(paramString, paramObject);
        return;
      }
      if ((paramObject instanceof Symbol))
      {
        putSymbol(paramString, (Symbol)paramObject);
        return;
      }
      if ((paramObject instanceof BSONTimestamp))
      {
        putTimestamp(paramString, (BSONTimestamp)paramObject);
        return;
      }
      if ((paramObject instanceof CodeWScope))
      {
        putCodeWScope(paramString, (CodeWScope)paramObject);
        return;
      }
      if ((paramObject instanceof Code))
      {
        putCode(paramString, (Code)paramObject);
        return;
      }
      if ((paramObject instanceof DBRefBase))
      {
        BasicBSONObject localBasicBSONObject = new BasicBSONObject();
        localBasicBSONObject.put("$ref", ((DBRefBase)paramObject).getRef());
        localBasicBSONObject.put("$id", ((DBRefBase)paramObject).getId());
        putObject(paramString, localBasicBSONObject);
        return;
      }
      if ((paramObject instanceof MinKey))
      {
        putMinKey(paramString);
        return;
      }
      if ((paramObject instanceof MaxKey))
      {
        putMaxKey(paramString);
        return;
      }
    } while (putSpecial(paramString, paramObject));
    throw new IllegalArgumentException("can't serialize " + paramObject.getClass());
  }
  
  protected void _putValueString(String paramString)
  {
    int i = this._buf.getPosition();
    this._buf.writeInt(0);
    int j = _put(paramString);
    this._buf.writeInt(i, j);
  }
  
  void _reset(Buffer paramBuffer)
  {
    paramBuffer.position(0);
    paramBuffer.limit(paramBuffer.capacity());
  }
  
  public void done()
  {
    this._buf = null;
  }
  
  public byte[] encode(BSONObject paramBSONObject)
  {
    BasicOutputBuffer localBasicOutputBuffer = new BasicOutputBuffer();
    set(localBasicOutputBuffer);
    putObject(paramBSONObject);
    done();
    return localBasicOutputBuffer.toByteArray();
  }
  
  protected boolean handleSpecialObjects(String paramString, BSONObject paramBSONObject)
  {
    return false;
  }
  
  protected void putBinary(String paramString, Binary paramBinary)
  {
    putBinary(paramString, paramBinary.getType(), paramBinary.getData());
  }
  
  protected void putBinary(String paramString, byte[] paramArrayOfByte)
  {
    putBinary(paramString, 0, paramArrayOfByte);
  }
  
  protected void putBoolean(String paramString, Boolean paramBoolean)
  {
    _put((byte)8, paramString);
    paramString = this._buf;
    if (paramBoolean.booleanValue()) {}
    for (int i = 1;; i = 0)
    {
      paramString.write(i);
      return;
    }
  }
  
  protected void putCode(String paramString, Code paramCode)
  {
    _put((byte)13, paramString);
    this._buf.getPosition();
    _putValueString(paramCode.getCode());
  }
  
  protected void putCodeWScope(String paramString, CodeWScope paramCodeWScope)
  {
    _put((byte)15, paramString);
    int i = this._buf.getPosition();
    this._buf.writeInt(0);
    _putValueString(paramCodeWScope.getCode());
    putObject(paramCodeWScope.getScope());
    this._buf.writeInt(i, this._buf.getPosition() - i);
  }
  
  protected void putDate(String paramString, Date paramDate)
  {
    _put((byte)9, paramString);
    this._buf.writeLong(paramDate.getTime());
  }
  
  protected void putNull(String paramString)
  {
    _put((byte)10, paramString);
  }
  
  protected void putNumber(String paramString, Number paramNumber)
  {
    if (((paramNumber instanceof Integer)) || ((paramNumber instanceof Short)) || ((paramNumber instanceof Byte)) || ((paramNumber instanceof AtomicInteger)))
    {
      _put((byte)16, paramString);
      this._buf.writeInt(paramNumber.intValue());
      return;
    }
    if (((paramNumber instanceof Long)) || ((paramNumber instanceof AtomicLong)))
    {
      _put((byte)18, paramString);
      this._buf.writeLong(paramNumber.longValue());
      return;
    }
    if (((paramNumber instanceof Float)) || ((paramNumber instanceof Double)))
    {
      _put((byte)1, paramString);
      this._buf.writeDouble(paramNumber.doubleValue());
      return;
    }
    throw new IllegalArgumentException("can't serialize " + paramNumber.getClass());
  }
  
  protected int putObject(String paramString, BSONObject paramBSONObject)
  {
    if (paramBSONObject == null) {
      throw new NullPointerException("can't save a null object");
    }
    int j = this._buf.getPosition();
    byte b = 3;
    if ((paramBSONObject instanceof List)) {
      b = 4;
    }
    if (handleSpecialObjects(paramString, paramBSONObject)) {
      return this._buf.getPosition() - j;
    }
    if (paramString != null) {
      _put(b, paramString);
    }
    int k = this._buf.getPosition();
    this._buf.writeInt(0);
    Object localObject1 = null;
    if ((b == 3) && (paramString == null)) {}
    Object localObject2;
    for (int i = 1;; i = 0)
    {
      paramString = (String)localObject1;
      if (b == 3)
      {
        if ((i != 0) && (paramBSONObject.containsField("_id"))) {
          _putObjectField("_id", paramBSONObject.get("_id"));
        }
        localObject2 = paramBSONObject.get("_transientFields");
        paramString = (String)localObject1;
        if ((localObject2 instanceof List)) {
          paramString = (List)localObject2;
        }
      }
      if (!(paramBSONObject instanceof Map)) {
        break;
      }
      paramBSONObject = ((Map)paramBSONObject).entrySet().iterator();
      while (paramBSONObject.hasNext())
      {
        localObject1 = (Map.Entry)paramBSONObject.next();
        if (((i == 0) || (!((String)((Map.Entry)localObject1).getKey()).equals("_id"))) && ((paramString == null) || (!paramString.contains(((Map.Entry)localObject1).getKey())))) {
          _putObjectField((String)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
        }
      }
    }
    localObject1 = paramBSONObject.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((i == 0) || (!((String)localObject2).equals("_id"))) && ((paramString == null) || (!paramString.contains(localObject2)))) {
        _putObjectField((String)localObject2, paramBSONObject.get((String)localObject2));
      }
    }
    this._buf.write(0);
    this._buf.writeInt(k, this._buf.getPosition() - k);
    return this._buf.getPosition() - j;
  }
  
  public int putObject(BSONObject paramBSONObject)
  {
    return putObject(null, paramBSONObject);
  }
  
  protected void putObjectId(String paramString, ObjectId paramObjectId)
  {
    _put((byte)7, paramString);
    this._buf.writeIntBE(paramObjectId._time());
    this._buf.writeIntBE(paramObjectId._machine());
    this._buf.writeIntBE(paramObjectId._inc());
  }
  
  protected boolean putSpecial(String paramString, Object paramObject)
  {
    return false;
  }
  
  protected void putString(String paramString1, String paramString2)
  {
    _putString(paramString1, paramString2, (byte)2);
  }
  
  protected void putSymbol(String paramString, Symbol paramSymbol)
  {
    _putString(paramString, paramSymbol.getSymbol(), (byte)14);
  }
  
  protected void putTimestamp(String paramString, BSONTimestamp paramBSONTimestamp)
  {
    _put((byte)17, paramString);
    this._buf.writeInt(paramBSONTimestamp.getInc());
    this._buf.writeInt(paramBSONTimestamp.getTime());
  }
  
  protected void putUUID(String paramString, UUID paramUUID)
  {
    _put((byte)5, paramString);
    this._buf.writeInt(16);
    this._buf.write(3);
    this._buf.writeLong(paramUUID.getMostSignificantBits());
    this._buf.writeLong(paramUUID.getLeastSignificantBits());
  }
  
  protected void putUndefined(String paramString)
  {
    _put((byte)6, paramString);
  }
  
  public void set(OutputBuffer paramOutputBuffer)
  {
    if (this._buf != null) {
      throw new IllegalStateException("in the middle of something");
    }
    this._buf = paramOutputBuffer;
  }
  
  public void writeCString(String paramString)
  {
    _put(paramString);
  }
  
  public void writeInt(int paramInt)
  {
    this._buf.writeInt(paramInt);
  }
  
  public void writeLong(long paramLong)
  {
    this._buf.writeLong(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BasicBSONEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */