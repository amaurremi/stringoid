package com.mongodb.gridfs;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GridFSDBFile
  extends GridFSFile
{
  byte[] getChunk(int paramInt)
  {
    if (this._fs == null) {
      throw new RuntimeException("no gridfs!");
    }
    DBObject localDBObject = this._fs._chunkCollection.findOne(BasicDBObjectBuilder.start("files_id", this._id).add("n", Integer.valueOf(paramInt)).get());
    if (localDBObject == null) {
      throw new MongoException("can't find a chunk!  file id: " + this._id + " chunk: " + paramInt);
    }
    return (byte[])localDBObject.get("data");
  }
  
  public InputStream getInputStream()
  {
    return new MyInputStream();
  }
  
  void remove()
  {
    this._fs._filesCollection.remove(new BasicDBObject("_id", this._id));
    this._fs._chunkCollection.remove(new BasicDBObject("files_id", this._id));
  }
  
  public long writeTo(File paramFile)
    throws IOException
  {
    Object localObject3 = null;
    try
    {
      paramFile = new FileOutputStream(paramFile);
      long l;
      if (paramFile == null) {
        break label41;
      }
    }
    finally
    {
      try
      {
        l = writeTo(paramFile);
        if (paramFile != null) {
          paramFile.close();
        }
        return l;
      }
      finally {}
      localObject1 = finally;
      paramFile = (File)localObject3;
    }
    paramFile.close();
    label41:
    throw ((Throwable)localObject1);
  }
  
  public long writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    int j = numChunks();
    int i = 0;
    while (i < j)
    {
      paramOutputStream.write(getChunk(i));
      i += 1;
    }
    return this._length;
  }
  
  public long writeTo(String paramString)
    throws IOException
  {
    return writeTo(new File(paramString));
  }
  
  class MyInputStream
    extends InputStream
  {
    int _currentChunkIdx = -1;
    byte[] _data = null;
    final int _numChunks = GridFSDBFile.this.numChunks();
    int _offset = 0;
    
    MyInputStream() {}
    
    public int available()
    {
      if (this._data == null) {
        return 0;
      }
      return this._data.length - this._offset;
    }
    
    public void close() {}
    
    public void mark(int paramInt)
    {
      throw new RuntimeException("mark not supported");
    }
    
    public boolean markSupported()
    {
      return false;
    }
    
    public int read()
    {
      byte[] arrayOfByte = new byte[1];
      if (read(arrayOfByte) < 0) {
        return -1;
      }
      return arrayOfByte[0] & 0xFF;
    }
    
    public int read(byte[] paramArrayOfByte)
    {
      return read(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if ((this._data == null) || (this._offset >= this._data.length))
      {
        if (this._currentChunkIdx + 1 >= this._numChunks) {
          return -1;
        }
        GridFSDBFile localGridFSDBFile = GridFSDBFile.this;
        int i = this._currentChunkIdx + 1;
        this._currentChunkIdx = i;
        this._data = localGridFSDBFile.getChunk(i);
        this._offset = 0;
      }
      paramInt2 = Math.min(paramInt2, this._data.length - this._offset);
      System.arraycopy(this._data, this._offset, paramArrayOfByte, paramInt1, paramInt2);
      this._offset += paramInt2;
      return paramInt2;
    }
    
    public void reset()
    {
      throw new RuntimeException("mark not supported");
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      if (paramLong <= 0L) {
        return 0L;
      }
      if (this._currentChunkIdx == this._numChunks) {
        return 0L;
      }
      long l = 0L;
      if (this._currentChunkIdx >= 0) {
        l = this._currentChunkIdx * GridFSDBFile.this._chunkSize + this._offset;
      }
      if (paramLong + l >= GridFSDBFile.this._length)
      {
        this._currentChunkIdx = this._numChunks;
        this._data = null;
        return GridFSDBFile.this._length - l;
      }
      int i = this._currentChunkIdx;
      this._currentChunkIdx = ((int)((paramLong + l) / GridFSDBFile.this._chunkSize));
      if (i != this._currentChunkIdx) {
        this._data = GridFSDBFile.this.getChunk(this._currentChunkIdx);
      }
      this._offset = ((int)((paramLong + l) % GridFSDBFile.this._chunkSize));
      return paramLong;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/gridfs/GridFSDBFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */