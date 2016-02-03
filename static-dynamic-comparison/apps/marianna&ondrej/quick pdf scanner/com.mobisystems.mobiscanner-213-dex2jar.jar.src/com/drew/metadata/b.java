package com.drew.metadata;

import com.drew.lang.Rational;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class b
{
  protected final Map<Integer, Object> fP = new HashMap();
  protected final Collection<e> fQ = new ArrayList();
  private final Collection<String> fR = new ArrayList(4);
  protected f fS;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public boolean Y(int paramInt)
  {
    return this.fP.containsKey(Integer.valueOf(paramInt));
  }
  
  public Integer Z(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            if ((localObject instanceof String)) {
              try
              {
                paramInt = Integer.parseInt((String)localObject);
                return Integer.valueOf(paramInt);
              }
              catch (NumberFormatException localNumberFormatException)
              {
                localObject = ((String)localObject).getBytes();
                int i = localObject.length;
                long l = 0L;
                paramInt = 0;
                while (paramInt < i)
                {
                  l = (l << 8) + (localObject[paramInt] & 0xFF);
                  paramInt += 1;
                }
                return Integer.valueOf((int)l);
              }
            }
            if ((localObject instanceof Number)) {
              return Integer.valueOf(((Number)localObject).intValue());
            }
            if (!(localObject instanceof Rational[])) {
              break;
            }
            localObject = (Rational[])localObject;
          } while (localObject.length != 1);
          return Integer.valueOf(localObject[0].intValue());
          if (!(localObject instanceof byte[])) {
            break;
          }
          localObject = (byte[])localObject;
        } while (localObject.length != 1);
        return Integer.valueOf(localObject[0]);
      } while (!(localObject instanceof int[]));
      localObject = (int[])localObject;
    } while (localObject.length != 1);
    return Integer.valueOf(localObject[0]);
  }
  
  public void a(int paramInt, Rational paramRational)
  {
    setObject(paramInt, paramRational);
  }
  
  public void a(int paramInt, Date paramDate)
  {
    setObject(paramInt, paramDate);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    b(paramInt, paramArrayOfByte);
  }
  
  public void a(int paramInt, double[] paramArrayOfDouble)
  {
    b(paramInt, paramArrayOfDouble);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    b(paramInt, paramArrayOfFloat);
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    b(paramInt, paramArrayOfInt);
  }
  
  public void a(int paramInt, Rational[] paramArrayOfRational)
  {
    b(paramInt, paramArrayOfRational);
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    b(paramInt, paramArrayOfString);
  }
  
  public void a(f paramf)
  {
    if (paramf == null) {
      throw new NullPointerException("cannot set a null descriptor");
    }
    this.fS = paramf;
  }
  
  protected abstract HashMap<Integer, String> aA();
  
  public Collection<e> aB()
  {
    return this.fQ;
  }
  
  public byte[] aa(int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    byte[] arrayOfByte;
    if ((localObject instanceof Rational[]))
    {
      localObject = (Rational[])localObject;
      arrayOfByte = new byte[localObject.length];
      paramInt = i;
      while (paramInt < arrayOfByte.length)
      {
        arrayOfByte[paramInt] = localObject[paramInt].byteValue();
        paramInt += 1;
      }
      return arrayOfByte;
    }
    if ((localObject instanceof byte[])) {
      return (byte[])localObject;
    }
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      arrayOfByte = new byte[localObject.length];
      paramInt = j;
      while (paramInt < localObject.length)
      {
        arrayOfByte[paramInt] = ((byte)localObject[paramInt]);
        paramInt += 1;
      }
      return arrayOfByte;
    }
    if ((localObject instanceof CharSequence))
    {
      localObject = (CharSequence)localObject;
      arrayOfByte = new byte[((CharSequence)localObject).length()];
      paramInt = k;
      while (paramInt < ((CharSequence)localObject).length())
      {
        arrayOfByte[paramInt] = ((byte)((CharSequence)localObject).charAt(paramInt));
        paramInt += 1;
      }
      return arrayOfByte;
    }
    if ((localObject instanceof Integer)) {
      return new byte[] { ((Integer)localObject).byteValue() };
    }
    return null;
  }
  
  public Double ab(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String)) {
      try
      {
        double d = Double.parseDouble((String)localObject);
        return Double.valueOf(d);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
    }
    if ((localNumberFormatException instanceof Number)) {
      return Double.valueOf(((Number)localNumberFormatException).doubleValue());
    }
    return null;
  }
  
  public Float ac(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String)) {
      try
      {
        float f = Float.parseFloat((String)localObject);
        return Float.valueOf(f);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
    }
    if ((localNumberFormatException instanceof Number)) {
      return Float.valueOf(((Number)localNumberFormatException).floatValue());
    }
    return null;
  }
  
  public Long ad(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String)) {
      try
      {
        long l = Long.parseLong((String)localObject);
        return Long.valueOf(l);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
    }
    if ((localNumberFormatException instanceof Number)) {
      return Long.valueOf(((Number)localNumberFormatException).longValue());
    }
    return null;
  }
  
  public Rational ae(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Rational)) {
      return (Rational)localObject;
    }
    if ((localObject instanceof Integer)) {
      return new Rational(((Integer)localObject).intValue(), 1L);
    }
    if ((localObject instanceof Long)) {
      return new Rational(((Long)localObject).longValue(), 1L);
    }
    return null;
  }
  
  public Rational[] af(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Rational[])) {
      return (Rational[])localObject;
    }
    return null;
  }
  
  public void b(int paramInt, Object paramObject)
  {
    setObject(paramInt, paramObject);
  }
  
  public void c(String paramString)
  {
    this.fR.add(paramString);
  }
  
  public String getDescription(int paramInt)
  {
    assert (this.fS != null);
    return this.fS.getDescription(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    Object localObject = Z(paramInt);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = getObject(paramInt);
    if (localObject == null) {
      throw new MetadataException("Tag '" + getTagName(paramInt) + "' has not been set -- check using containsTag() first");
    }
    throw new MetadataException("Tag '" + paramInt + "' cannot be converted to int.  It is of type '" + localObject.getClass() + "'.");
  }
  
  public int[] getIntArray(int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    int[] arrayOfInt;
    if ((localObject instanceof Rational[]))
    {
      localObject = (Rational[])localObject;
      arrayOfInt = new int[localObject.length];
      paramInt = i;
      while (paramInt < arrayOfInt.length)
      {
        arrayOfInt[paramInt] = localObject[paramInt].intValue();
        paramInt += 1;
      }
      return arrayOfInt;
    }
    if ((localObject instanceof int[])) {
      return (int[])localObject;
    }
    if ((localObject instanceof byte[]))
    {
      localObject = (byte[])localObject;
      arrayOfInt = new int[localObject.length];
      paramInt = j;
      while (paramInt < localObject.length)
      {
        arrayOfInt[paramInt] = localObject[paramInt];
        paramInt += 1;
      }
      return arrayOfInt;
    }
    if ((localObject instanceof CharSequence))
    {
      localObject = (CharSequence)localObject;
      arrayOfInt = new int[((CharSequence)localObject).length()];
      paramInt = k;
      while (paramInt < ((CharSequence)localObject).length())
      {
        arrayOfInt[paramInt] = ((CharSequence)localObject).charAt(paramInt);
        paramInt += 1;
      }
      return arrayOfInt;
    }
    if ((localObject instanceof Integer)) {
      return new int[] { ((Integer)localObject).intValue() };
    }
    return null;
  }
  
  public abstract String getName();
  
  public Object getObject(int paramInt)
  {
    return this.fP.get(Integer.valueOf(paramInt));
  }
  
  public String getString(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Rational)) {
      return ((Rational)localObject).g(true);
    }
    if (localObject.getClass().isArray())
    {
      int i = Array.getLength(localObject);
      Class localClass = localObject.getClass().getComponentType();
      boolean bool1 = Object.class.isAssignableFrom(localClass);
      boolean bool2 = localClass.getName().equals("float");
      boolean bool3 = localClass.getName().equals("double");
      boolean bool4 = localClass.getName().equals("int");
      boolean bool5 = localClass.getName().equals("long");
      boolean bool6 = localClass.getName().equals("byte");
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = 0;
      if (paramInt < i)
      {
        if (paramInt != 0) {
          localStringBuilder.append(' ');
        }
        if (bool1) {
          localStringBuilder.append(Array.get(localObject, paramInt).toString());
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if (bool4) {
            localStringBuilder.append(Array.getInt(localObject, paramInt));
          } else if (bool5) {
            localStringBuilder.append(Array.getLong(localObject, paramInt));
          } else if (bool2) {
            localStringBuilder.append(Array.getFloat(localObject, paramInt));
          } else if (bool3) {
            localStringBuilder.append(Array.getDouble(localObject, paramInt));
          } else if (bool6) {
            localStringBuilder.append(Array.getByte(localObject, paramInt));
          } else {
            c("Unexpected array component type: " + localClass.getName());
          }
        }
      }
      return localStringBuilder.toString();
    }
    return localObject.toString();
  }
  
  public String[] getStringArray(int paramInt)
  {
    int j = 0;
    int i = 0;
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String[])) {
      return (String[])localObject;
    }
    if ((localObject instanceof String)) {
      return new String[] { (String)localObject };
    }
    String[] arrayOfString;
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      arrayOfString = new String[localObject.length];
      paramInt = i;
      while (paramInt < arrayOfString.length)
      {
        arrayOfString[paramInt] = Integer.toString(localObject[paramInt]);
        paramInt += 1;
      }
      return arrayOfString;
    }
    if ((localObject instanceof byte[]))
    {
      localObject = (byte[])localObject;
      arrayOfString = new String[localObject.length];
      paramInt = j;
      while (paramInt < arrayOfString.length)
      {
        arrayOfString[paramInt] = Byte.toString(localObject[paramInt]);
        paramInt += 1;
      }
      return arrayOfString;
    }
    if ((localObject instanceof Rational[]))
    {
      localObject = (Rational[])localObject;
      arrayOfString = new String[localObject.length];
      paramInt = 0;
      while (paramInt < arrayOfString.length)
      {
        arrayOfString[paramInt] = localObject[paramInt].g(false);
        paramInt += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  public String getTagName(int paramInt)
  {
    Object localObject = aA();
    if (!((HashMap)localObject).containsKey(Integer.valueOf(paramInt)))
    {
      for (localObject = Integer.toHexString(paramInt); ((String)localObject).length() < 4; localObject = "0" + (String)localObject) {}
      return "Unknown tag (0x" + (String)localObject + ")";
    }
    return (String)((HashMap)localObject).get(Integer.valueOf(paramInt));
  }
  
  public void setDouble(int paramInt, double paramDouble)
  {
    setObject(paramInt, Double.valueOf(paramDouble));
  }
  
  public void setFloat(int paramInt, float paramFloat)
  {
    setObject(paramInt, Float.valueOf(paramFloat));
  }
  
  public void setInt(int paramInt1, int paramInt2)
  {
    setObject(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public void setLong(int paramInt, long paramLong)
  {
    setObject(paramInt, Long.valueOf(paramLong));
  }
  
  public void setObject(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("cannot set a null object");
    }
    if (!this.fP.containsKey(Integer.valueOf(paramInt))) {
      this.fQ.add(new e(paramInt, this));
    }
    this.fP.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void setString(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("cannot set a null String");
    }
    setObject(paramInt, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */