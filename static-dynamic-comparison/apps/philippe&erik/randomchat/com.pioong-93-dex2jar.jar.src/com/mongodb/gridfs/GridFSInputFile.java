package com.mongodb.gridfs;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import org.bson.types.ObjectId;

public class GridFSInputFile
  extends GridFSFile
{
  private byte[] _buffer = null;
  private boolean _closeStreamOnPersist;
  private int _currentBufferPosition = 0;
  private int _currentChunkNumber = 0;
  private final InputStream _in;
  private MessageDigest _messageDigester = null;
  private OutputStream _outputStream = null;
  private boolean _savedChunks = false;
  private long _totalBytes = 0L;
  
  protected GridFSInputFile(GridFS paramGridFS)
  {
    this(paramGridFS, null, null);
  }
  
  protected GridFSInputFile(GridFS paramGridFS, InputStream paramInputStream, String paramString)
  {
    this(paramGridFS, paramInputStream, paramString, false);
  }
  
  protected GridFSInputFile(GridFS paramGridFS, InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    this._fs = paramGridFS;
    this._in = paramInputStream;
    this._filename = paramString;
    this._closeStreamOnPersist = paramBoolean;
    this._id = new ObjectId();
    this._chunkSize = 262144L;
    this._uploadDate = new Date();
    try
    {
      this._messageDigester = MessageDigest.getInstance("MD5");
      this._messageDigester.reset();
      this._buffer = new byte[(int)this._chunkSize];
      return;
    }
    catch (NoSuchAlgorithmException paramGridFS)
    {
      throw new RuntimeException("No MD5!");
    }
  }
  
  protected GridFSInputFile(GridFS paramGridFS, String paramString)
  {
    this(paramGridFS, null, paramString);
  }
  
  private void _dumpBuffer(boolean paramBoolean)
  {
    if ((this._currentBufferPosition < this._chunkSize) && (!paramBoolean)) {}
    while (this._currentBufferPosition == 0) {
      return;
    }
    byte[] arrayOfByte = this._buffer;
    if (this._currentBufferPosition != this._chunkSize)
    {
      arrayOfByte = new byte[this._currentBufferPosition];
      System.arraycopy(this._buffer, 0, arrayOfByte, 0, this._currentBufferPosition);
    }
    DBObject localDBObject = createChunk(this._id, this._currentChunkNumber, arrayOfByte);
    this._fs._chunkCollection.save(localDBObject);
    this._currentChunkNumber += 1;
    this._totalBytes += arrayOfByte.length;
    this._messageDigester.update(arrayOfByte);
    this._currentBufferPosition = 0;
  }
  
  private void _finishData()
  {
    if (!this._savedChunks)
    {
      this._md5 = Util.toHex(this._messageDigester.digest());
      this._messageDigester = null;
      this._length = this._totalBytes;
      this._savedChunks = true;
    }
    try
    {
      if ((this._in != null) && (this._closeStreamOnPersist)) {
        this._in.close();
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private int _readStream2Buffer()
    throws IOException
  {
    int i = 0;
    while ((this._currentBufferPosition < this._chunkSize) && (i >= 0))
    {
      int j = this._in.read(this._buffer, this._currentBufferPosition, (int)this._chunkSize - this._currentBufferPosition);
      if (j > 0)
      {
        this._currentBufferPosition += j;
        i = j;
      }
      else
      {
        i = j;
        if (j == 0) {
          throw new RuntimeException("i'm doing something wrong");
        }
      }
    }
    return i;
  }
  
  protected DBObject createChunk(Object paramObject, int paramInt, byte[] paramArrayOfByte)
  {
    return BasicDBObjectBuilder.start().add("files_id", paramObject).add("n", Integer.valueOf(paramInt)).add("data", paramArrayOfByte).get();
  }
  
  public OutputStream getOutputStream()
  {
    if (this._outputStream == null) {
      this._outputStream = new MyOutputStream();
    }
    return this._outputStream;
  }
  
  public void save()
  {
    save(this._chunkSize);
  }
  
  public void save(long paramLong)
  {
    if (this._outputStream != null) {
      throw new MongoException("cannot mix OutputStream and regular save()");
    }
    if (!this._savedChunks) {}
    try
    {
      saveChunks(paramLong);
      super.save();
      return;
    }
    catch (IOException localIOException)
    {
      throw new MongoException("couldn't save chunks", localIOException);
    }
  }
  
  public int saveChunks()
    throws IOException
  {
    return saveChunks(this._chunkSize);
  }
  
  public int saveChunks(long paramLong)
    throws IOException
  {
    if (this._outputStream != null) {
      throw new MongoException("cannot mix OutputStream and regular save()");
    }
    if (this._savedChunks) {
      throw new MongoException("chunks already saved!");
    }
    if ((paramLong <= 0L) || (paramLong > 3500000L)) {
      throw new MongoException("chunkSize must be greater than zero and less than or equal to GridFS.MAX_CHUNKSIZE");
    }
    if (this._chunkSize != paramLong)
    {
      this._chunkSize = paramLong;
      this._buffer = new byte[(int)this._chunkSize];
    }
    int i = 0;
    while (i >= 0)
    {
      this._currentBufferPosition = 0;
      i = _readStream2Buffer();
      _dumpBuffer(true);
    }
    _finishData();
    return this._currentChunkNumber;
  }
  
  public void setChunkSize(long paramLong)
  {
    if ((this._outputStream != null) || (this._savedChunks)) {
      return;
    }
    this._chunkSize = paramLong;
    this._buffer = new byte[(int)this._chunkSize];
  }
  
  public void setContentType(String paramString)
  {
    this._contentType = paramString;
  }
  
  public void setFilename(String paramString)
  {
    this._filename = paramString;
  }
  
  public void setId(Object paramObject)
  {
    this._id = paramObject;
  }
  
  class MyOutputStream
    extends OutputStream
  {
    MyOutputStream() {}
    
    public void close()
    {
      GridFSInputFile.this._dumpBuffer(true);
      GridFSInputFile.this._finishData();
      GridFSInputFile.this.save();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      write(new byte[] { (byte)(paramInt & 0xFF) }, 0, 1);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (paramInt1 > 0)
      {
        int j = paramInt1;
        i = j;
        if (j > GridFSInputFile.this._chunkSize - GridFSInputFile.this._currentBufferPosition) {
          i = (int)GridFSInputFile.this._chunkSize - GridFSInputFile.this._currentBufferPosition;
        }
        System.arraycopy(paramArrayOfByte, paramInt2, GridFSInputFile.this._buffer, GridFSInputFile.this._currentBufferPosition, i);
        GridFSInputFile.access$012(GridFSInputFile.this, i);
        j = paramInt2 + i;
        i = paramInt1 - i;
        paramInt1 = i;
        paramInt2 = j;
        if (GridFSInputFile.this._currentBufferPosition == GridFSInputFile.this._chunkSize)
        {
          GridFSInputFile.this._dumpBuffer(false);
          paramInt1 = i;
          paramInt2 = j;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/gridfs/GridFSInputFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */