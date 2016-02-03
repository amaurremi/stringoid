package com.drew.imaging.jpeg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JpegSegmentData
  implements Serializable
{
  private static final long serialVersionUID = 7110175216435025451L;
  private final HashMap<Byte, List<byte[]>> _segmentDataMap = new HashMap(10);
  
  private List<byte[]> d(byte paramByte)
  {
    if (this._segmentDataMap.containsKey(Byte.valueOf(paramByte))) {
      return (List)this._segmentDataMap.get(Byte.valueOf(paramByte));
    }
    ArrayList localArrayList = new ArrayList();
    this._segmentDataMap.put(Byte.valueOf(paramByte), localArrayList);
    return localArrayList;
  }
  
  public void a(byte paramByte, byte[] paramArrayOfByte)
  {
    d(paramByte).add(paramArrayOfByte);
  }
  
  public byte[] a(byte paramByte)
  {
    return a(paramByte, 0);
  }
  
  public byte[] a(byte paramByte, int paramInt)
  {
    List localList = c(paramByte);
    if ((localList == null) || (localList.size() <= paramInt)) {
      return null;
    }
    return (byte[])localList.get(paramInt);
  }
  
  public Iterable<byte[]> b(byte paramByte)
  {
    List localList = c(paramByte);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    return (Iterable<byte[]>)localObject;
  }
  
  public List<byte[]> c(byte paramByte)
  {
    return (List)this._segmentDataMap.get(Byte.valueOf(paramByte));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/imaging/jpeg/JpegSegmentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */