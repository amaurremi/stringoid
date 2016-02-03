package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.core.io.UTF32Reader;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class ByteSourceJsonBootstrapper
{
  protected boolean _bigEndian = true;
  private final boolean _bufferRecyclable;
  protected int _bytesPerChar = 0;
  protected final IOContext _context;
  protected final InputStream _in;
  protected final byte[] _inputBuffer;
  private int _inputEnd;
  protected int _inputProcessed;
  private int _inputPtr;
  
  public ByteSourceJsonBootstrapper(IOContext paramIOContext, InputStream paramInputStream)
  {
    this._context = paramIOContext;
    this._in = paramInputStream;
    this._inputBuffer = paramIOContext.allocReadIOBuffer();
    this._inputPtr = 0;
    this._inputEnd = 0;
    this._inputProcessed = 0;
    this._bufferRecyclable = true;
  }
  
  private boolean checkUTF16(int paramInt)
  {
    boolean bool = false;
    if ((0xFF00 & paramInt) == 0) {}
    for (this._bigEndian = true;; this._bigEndian = false)
    {
      this._bytesPerChar = 2;
      bool = true;
      do
      {
        return bool;
      } while ((paramInt & 0xFF) != 0);
    }
  }
  
  private boolean checkUTF32(int paramInt)
  {
    boolean bool = false;
    if (paramInt >> 8 == 0) {
      this._bigEndian = true;
    }
    for (;;)
    {
      this._bytesPerChar = 4;
      bool = true;
      do
      {
        return bool;
        if ((0xFFFFFF & paramInt) == 0)
        {
          this._bigEndian = false;
          break;
        }
        if ((0xFF00FFFF & paramInt) == 0)
        {
          reportWeirdUCS4("3412");
          break;
        }
      } while ((0xFFFF00FF & paramInt) != 0);
      reportWeirdUCS4("2143");
    }
  }
  
  private boolean handleBOM(int paramInt)
  {
    switch (paramInt)
    {
    }
    int i;
    for (;;)
    {
      i = paramInt >>> 16;
      if (i != 65279) {
        break;
      }
      this._inputPtr += 2;
      this._bytesPerChar = 2;
      this._bigEndian = true;
      return true;
      this._bigEndian = true;
      this._inputPtr += 4;
      this._bytesPerChar = 4;
      return true;
      this._inputPtr += 4;
      this._bytesPerChar = 4;
      this._bigEndian = false;
      return true;
      reportWeirdUCS4("2143");
      reportWeirdUCS4("3412");
    }
    if (i == 65534)
    {
      this._inputPtr += 2;
      this._bytesPerChar = 2;
      this._bigEndian = false;
      return true;
    }
    if (paramInt >>> 8 == 15711167)
    {
      this._inputPtr += 3;
      this._bytesPerChar = 1;
      this._bigEndian = true;
      return true;
    }
    return false;
  }
  
  private void reportWeirdUCS4(String paramString)
  {
    throw new CharConversionException("Unsupported UCS-4 endianness (" + paramString + ") detected");
  }
  
  public JsonParser constructParser(int paramInt, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, CharsToNameCanonicalizer paramCharsToNameCanonicalizer, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((detectEncoding() == JsonEncoding.UTF8) && (paramBoolean1))
    {
      paramBytesToNameCanonicalizer = paramBytesToNameCanonicalizer.makeChild(paramBoolean1, paramBoolean2);
      return new UTF8StreamJsonParser(this._context, paramInt, this._in, paramObjectCodec, paramBytesToNameCanonicalizer, this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
    }
    return new ReaderBasedJsonParser(this._context, paramInt, constructReader(), paramObjectCodec, paramCharsToNameCanonicalizer.makeChild(paramBoolean1, paramBoolean2));
  }
  
  public Reader constructReader()
  {
    JsonEncoding localJsonEncoding = this._context.getEncoding();
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonEncoding[localJsonEncoding.ordinal()])
    {
    default: 
      throw new RuntimeException("Internal error");
    case 1: 
    case 2: 
      return new UTF32Reader(this._context, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, this._context.getEncoding().isBigEndian());
    }
    Object localObject = this._in;
    if (localObject == null) {
      localObject = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
    }
    for (;;)
    {
      return new InputStreamReader((InputStream)localObject, localJsonEncoding.getJavaName());
      if (this._inputPtr < this._inputEnd) {
        localObject = new MergedStream(this._context, (InputStream)localObject, this._inputBuffer, this._inputPtr, this._inputEnd);
      }
    }
  }
  
  public JsonEncoding detectEncoding()
  {
    int j = 1;
    int k;
    int i;
    JsonEncoding localJsonEncoding;
    if (ensureLoaded(4))
    {
      k = this._inputBuffer[this._inputPtr] << 24 | (this._inputBuffer[(this._inputPtr + 1)] & 0xFF) << 16 | (this._inputBuffer[(this._inputPtr + 2)] & 0xFF) << 8 | this._inputBuffer[(this._inputPtr + 3)] & 0xFF;
      if (handleBOM(k))
      {
        i = j;
        if (i != 0) {
          break label188;
        }
        localJsonEncoding = JsonEncoding.UTF8;
      }
    }
    for (;;)
    {
      this._context.setEncoding(localJsonEncoding);
      return localJsonEncoding;
      i = j;
      if (checkUTF32(k)) {
        break;
      }
      i = j;
      if (checkUTF16(k >>> 16)) {
        break;
      }
      do
      {
        i = 0;
        break;
      } while ((!ensureLoaded(2)) || (!checkUTF16((this._inputBuffer[this._inputPtr] & 0xFF) << 8 | this._inputBuffer[(this._inputPtr + 1)] & 0xFF)));
      i = j;
      break;
      label188:
      switch (this._bytesPerChar)
      {
      case 3: 
      default: 
        throw new RuntimeException("Internal error");
      case 1: 
        localJsonEncoding = JsonEncoding.UTF8;
        break;
      case 2: 
        if (this._bigEndian) {
          localJsonEncoding = JsonEncoding.UTF16_BE;
        } else {
          localJsonEncoding = JsonEncoding.UTF16_LE;
        }
        break;
      case 4: 
        if (this._bigEndian) {
          localJsonEncoding = JsonEncoding.UTF32_BE;
        } else {
          localJsonEncoding = JsonEncoding.UTF32_LE;
        }
        break;
      }
    }
  }
  
  protected boolean ensureLoaded(int paramInt)
  {
    boolean bool2 = true;
    int j;
    for (int i = this._inputEnd - this._inputPtr;; i = j + i)
    {
      boolean bool1 = bool2;
      if (i < paramInt) {
        if (this._in != null) {
          break label42;
        }
      }
      label42:
      for (j = -1; j < 1; j = this._in.read(this._inputBuffer, this._inputEnd, this._inputBuffer.length - this._inputEnd))
      {
        bool1 = false;
        return bool1;
      }
      this._inputEnd += j;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/json/ByteSourceJsonBootstrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */