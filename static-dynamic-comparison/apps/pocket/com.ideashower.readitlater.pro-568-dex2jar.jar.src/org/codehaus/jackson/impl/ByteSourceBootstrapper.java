package org.codehaus.jackson.impl;

import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.format.InputAccessor;
import org.codehaus.jackson.format.MatchStrength;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.io.MergedStream;
import org.codehaus.jackson.io.UTF32Reader;
import org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import org.codehaus.jackson.sym.CharsToNameCanonicalizer;

public final class ByteSourceBootstrapper
{
  static final byte UTF8_BOM_1 = -17;
  static final byte UTF8_BOM_2 = -69;
  static final byte UTF8_BOM_3 = -65;
  protected boolean _bigEndian = true;
  private final boolean _bufferRecyclable;
  protected int _bytesPerChar = 0;
  protected final IOContext _context;
  protected final InputStream _in;
  protected final byte[] _inputBuffer;
  private int _inputEnd;
  protected int _inputProcessed;
  private int _inputPtr;
  
  public ByteSourceBootstrapper(IOContext paramIOContext, InputStream paramInputStream)
  {
    this._context = paramIOContext;
    this._in = paramInputStream;
    this._inputBuffer = paramIOContext.allocReadIOBuffer();
    this._inputPtr = 0;
    this._inputEnd = 0;
    this._inputProcessed = 0;
    this._bufferRecyclable = true;
  }
  
  public ByteSourceBootstrapper(IOContext paramIOContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this._context = paramIOContext;
    this._in = null;
    this._inputBuffer = paramArrayOfByte;
    this._inputPtr = paramInt1;
    this._inputEnd = (paramInt1 + paramInt2);
    this._inputProcessed = (-paramInt1);
    this._bufferRecyclable = false;
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
  
  public static MatchStrength hasJSONFormat(InputAccessor paramInputAccessor)
  {
    Object localObject;
    if (!paramInputAccessor.hasMoreBytes()) {
      localObject = MatchStrength.INCONCLUSIVE;
    }
    int i;
    MatchStrength localMatchStrength;
    do
    {
      do
      {
        do
        {
          return (MatchStrength)localObject;
          byte b2 = paramInputAccessor.nextByte();
          byte b1 = b2;
          if (b2 == -17)
          {
            if (!paramInputAccessor.hasMoreBytes()) {
              return MatchStrength.INCONCLUSIVE;
            }
            if (paramInputAccessor.nextByte() != -69) {
              return MatchStrength.NO_MATCH;
            }
            if (!paramInputAccessor.hasMoreBytes()) {
              return MatchStrength.INCONCLUSIVE;
            }
            if (paramInputAccessor.nextByte() != -65) {
              return MatchStrength.NO_MATCH;
            }
            if (!paramInputAccessor.hasMoreBytes()) {
              return MatchStrength.INCONCLUSIVE;
            }
            b1 = paramInputAccessor.nextByte();
          }
          i = skipSpace(paramInputAccessor, b1);
          if (i < 0) {
            return MatchStrength.INCONCLUSIVE;
          }
          if (i == 123)
          {
            i = skipSpace(paramInputAccessor);
            if (i < 0) {
              return MatchStrength.INCONCLUSIVE;
            }
            if ((i == 34) || (i == 125)) {
              return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.NO_MATCH;
          }
          if (i == 91)
          {
            i = skipSpace(paramInputAccessor);
            if (i < 0) {
              return MatchStrength.INCONCLUSIVE;
            }
            if ((i == 93) || (i == 91)) {
              return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
          }
          localMatchStrength = MatchStrength.WEAK_MATCH;
          localObject = localMatchStrength;
        } while (i == 34);
        if (i > 57) {
          break;
        }
        localObject = localMatchStrength;
      } while (i >= 48);
      if (i != 45) {
        break label270;
      }
      i = skipSpace(paramInputAccessor);
      if (i < 0) {
        return MatchStrength.INCONCLUSIVE;
      }
      if (i > 57) {
        break;
      }
      localObject = localMatchStrength;
    } while (i >= 48);
    return MatchStrength.NO_MATCH;
    label270:
    if (i == 110) {
      return tryMatch(paramInputAccessor, "ull", localMatchStrength);
    }
    if (i == 116) {
      return tryMatch(paramInputAccessor, "rue", localMatchStrength);
    }
    if (i == 102) {
      return tryMatch(paramInputAccessor, "alse", localMatchStrength);
    }
    return MatchStrength.NO_MATCH;
  }
  
  private void reportWeirdUCS4(String paramString)
  {
    throw new CharConversionException("Unsupported UCS-4 endianness (" + paramString + ") detected");
  }
  
  private static final int skipSpace(InputAccessor paramInputAccessor)
  {
    if (!paramInputAccessor.hasMoreBytes()) {
      return -1;
    }
    return skipSpace(paramInputAccessor, paramInputAccessor.nextByte());
  }
  
  private static final int skipSpace(InputAccessor paramInputAccessor, byte paramByte)
  {
    for (;;)
    {
      paramByte &= 0xFF;
      if ((paramByte != 32) && (paramByte != 13) && (paramByte != 10) && (paramByte != 9)) {
        return paramByte;
      }
      if (!paramInputAccessor.hasMoreBytes()) {
        return -1;
      }
      paramByte = paramInputAccessor.nextByte();
    }
  }
  
  private static final MatchStrength tryMatch(InputAccessor paramInputAccessor, String paramString, MatchStrength paramMatchStrength)
  {
    int i = 0;
    int j = paramString.length();
    for (;;)
    {
      MatchStrength localMatchStrength = paramMatchStrength;
      if (i < j)
      {
        if (!paramInputAccessor.hasMoreBytes()) {
          localMatchStrength = MatchStrength.INCONCLUSIVE;
        }
      }
      else {
        return localMatchStrength;
      }
      if (paramInputAccessor.nextByte() != paramString.charAt(i)) {
        return MatchStrength.NO_MATCH;
      }
      i += 1;
    }
  }
  
  public JsonParser constructParser(int paramInt, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    JsonEncoding localJsonEncoding = detectEncoding();
    boolean bool1 = JsonParser.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(paramInt);
    boolean bool2 = JsonParser.Feature.INTERN_FIELD_NAMES.enabledIn(paramInt);
    if ((localJsonEncoding == JsonEncoding.UTF8) && (bool1))
    {
      paramBytesToNameCanonicalizer = paramBytesToNameCanonicalizer.makeChild(bool1, bool2);
      return new Utf8StreamParser(this._context, paramInt, this._in, paramObjectCodec, paramBytesToNameCanonicalizer, this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
    }
    return new ReaderBasedParser(this._context, paramInt, constructReader(), paramObjectCodec, paramCharsToNameCanonicalizer.makeChild(bool1, bool2));
  }
  
  public Reader constructReader()
  {
    JsonEncoding localJsonEncoding = this._context.getEncoding();
    switch (1.$SwitchMap$org$codehaus$jackson$JsonEncoding[localJsonEncoding.ordinal()])
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/impl/ByteSourceBootstrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */