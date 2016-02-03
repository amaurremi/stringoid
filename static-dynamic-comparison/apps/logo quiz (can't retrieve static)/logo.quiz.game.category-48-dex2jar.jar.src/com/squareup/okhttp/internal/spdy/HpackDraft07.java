package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.BitArray;
import com.squareup.okhttp.internal.BitArray.FixedCapacity;
import com.squareup.okio.Buffer;
import com.squareup.okio.BufferedSource;
import com.squareup.okio.ByteString;
import com.squareup.okio.Okio;
import com.squareup.okio.Source;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class HpackDraft07
{
  private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
  private static final int PREFIX_4_BITS = 15;
  private static final int PREFIX_6_BITS = 63;
  private static final int PREFIX_7_BITS = 127;
  private static final Header[] STATIC_HEADER_TABLE = { new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", ""), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "") };
  
  private static ByteString checkLowercase(ByteString paramByteString)
    throws IOException
  {
    int i = 0;
    int j = paramByteString.size();
    while (i < j)
    {
      int k = paramByteString.getByte(i);
      if ((k >= 65) && (k <= 90)) {
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramByteString.utf8());
      }
      i += 1;
    }
    return paramByteString;
  }
  
  private static Map<ByteString, Integer> nameToFirstIndex()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
    int i = 0;
    while (i < STATIC_HEADER_TABLE.length)
    {
      if (!localLinkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name)) {
        localLinkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static final class Reader
  {
    private final List<Header> emittedHeaders = new ArrayList();
    BitArray emittedReferencedHeaders = new BitArray.FixedCapacity();
    int headerCount = 0;
    Header[] headerTable = new Header[8];
    int headerTableByteCount = 0;
    private int maxHeaderTableByteCount;
    private int maxHeaderTableByteCountSetting;
    int nextHeaderIndex = this.headerTable.length - 1;
    BitArray referencedHeaders = new BitArray.FixedCapacity();
    private final BufferedSource source;
    
    Reader(int paramInt, Source paramSource)
    {
      this.maxHeaderTableByteCountSetting = paramInt;
      this.maxHeaderTableByteCount = paramInt;
      this.source = Okio.buffer(paramSource);
    }
    
    private void adjustHeaderTableByteCount()
    {
      if (this.maxHeaderTableByteCount < this.headerTableByteCount)
      {
        if (this.maxHeaderTableByteCount == 0) {
          clearHeaderTable();
        }
      }
      else {
        return;
      }
      evictToRecoverBytes(this.headerTableByteCount - this.maxHeaderTableByteCount);
    }
    
    private void clearHeaderTable()
    {
      clearReferenceSet();
      Arrays.fill(this.headerTable, null);
      this.nextHeaderIndex = (this.headerTable.length - 1);
      this.headerCount = 0;
      this.headerTableByteCount = 0;
    }
    
    private void clearReferenceSet()
    {
      this.referencedHeaders.clear();
      this.emittedReferencedHeaders.clear();
    }
    
    private int evictToRecoverBytes(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.headerTable.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.nextHeaderIndex) && (j > 0))
        {
          j -= this.headerTable[i].hpackSize;
          this.headerTableByteCount -= this.headerTable[i].hpackSize;
          this.headerCount -= 1;
          paramInt += 1;
          i -= 1;
        }
        this.referencedHeaders.shiftLeft(paramInt);
        this.emittedReferencedHeaders.shiftLeft(paramInt);
        System.arraycopy(this.headerTable, this.nextHeaderIndex + 1, this.headerTable, this.nextHeaderIndex + 1 + paramInt, this.headerCount);
        this.nextHeaderIndex += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private ByteString getName(int paramInt)
    {
      if (isStaticHeader(paramInt)) {
        return HpackDraft07.STATIC_HEADER_TABLE[(paramInt - this.headerCount)].name;
      }
      return this.headerTable[headerTableIndex(paramInt)].name;
    }
    
    private int headerTableIndex(int paramInt)
    {
      return this.nextHeaderIndex + 1 + paramInt;
    }
    
    private void insertIntoHeaderTable(int paramInt, Header paramHeader)
    {
      int j = paramHeader.hpackSize;
      int i = j;
      if (paramInt != -1) {
        i = j - this.headerTable[headerTableIndex(paramInt)].hpackSize;
      }
      if (i > this.maxHeaderTableByteCount)
      {
        clearHeaderTable();
        this.emittedHeaders.add(paramHeader);
        return;
      }
      j = evictToRecoverBytes(this.headerTableByteCount + i - this.maxHeaderTableByteCount);
      if (paramInt == -1)
      {
        if (this.headerCount + 1 > this.headerTable.length)
        {
          Header[] arrayOfHeader = new Header[this.headerTable.length * 2];
          System.arraycopy(this.headerTable, 0, arrayOfHeader, this.headerTable.length, this.headerTable.length);
          if (arrayOfHeader.length == 64)
          {
            this.referencedHeaders = ((BitArray.FixedCapacity)this.referencedHeaders).toVariableCapacity();
            this.emittedReferencedHeaders = ((BitArray.FixedCapacity)this.emittedReferencedHeaders).toVariableCapacity();
          }
          this.referencedHeaders.shiftLeft(this.headerTable.length);
          this.emittedReferencedHeaders.shiftLeft(this.headerTable.length);
          this.nextHeaderIndex = (this.headerTable.length - 1);
          this.headerTable = arrayOfHeader;
        }
        paramInt = this.nextHeaderIndex;
        this.nextHeaderIndex = (paramInt - 1);
        this.referencedHeaders.set(paramInt);
        this.headerTable[paramInt] = paramHeader;
        this.headerCount += 1;
      }
      for (;;)
      {
        this.headerTableByteCount += i;
        return;
        paramInt += headerTableIndex(paramInt) + j;
        this.referencedHeaders.set(paramInt);
        this.headerTable[paramInt] = paramHeader;
      }
    }
    
    private boolean isStaticHeader(int paramInt)
    {
      return paramInt >= this.headerCount;
    }
    
    private int readByte()
      throws IOException
    {
      return this.source.readByte() & 0xFF;
    }
    
    private void readIndexedHeader(int paramInt)
      throws IOException
    {
      if (isStaticHeader(paramInt))
      {
        paramInt -= this.headerCount;
        if (paramInt > HpackDraft07.STATIC_HEADER_TABLE.length - 1) {
          throw new IOException("Header index too large " + (paramInt + 1));
        }
        Header localHeader = HpackDraft07.STATIC_HEADER_TABLE[paramInt];
        if (this.maxHeaderTableByteCount == 0)
        {
          this.emittedHeaders.add(localHeader);
          return;
        }
        insertIntoHeaderTable(-1, localHeader);
        return;
      }
      paramInt = headerTableIndex(paramInt);
      if (!this.referencedHeaders.get(paramInt))
      {
        this.emittedHeaders.add(this.headerTable[paramInt]);
        this.emittedReferencedHeaders.set(paramInt);
      }
      this.referencedHeaders.toggle(paramInt);
    }
    
    private void readLiteralHeaderWithIncrementalIndexingIndexedName(int paramInt)
      throws IOException
    {
      insertIntoHeaderTable(-1, new Header(getName(paramInt), readByteString()));
    }
    
    private void readLiteralHeaderWithIncrementalIndexingNewName()
      throws IOException
    {
      insertIntoHeaderTable(-1, new Header(HpackDraft07.checkLowercase(readByteString()), readByteString()));
    }
    
    private void readLiteralHeaderWithoutIndexingIndexedName(int paramInt)
      throws IOException
    {
      ByteString localByteString1 = getName(paramInt);
      ByteString localByteString2 = readByteString();
      this.emittedHeaders.add(new Header(localByteString1, localByteString2));
    }
    
    private void readLiteralHeaderWithoutIndexingNewName()
      throws IOException
    {
      ByteString localByteString1 = HpackDraft07.checkLowercase(readByteString());
      ByteString localByteString2 = readByteString();
      this.emittedHeaders.add(new Header(localByteString1, localByteString2));
    }
    
    void emitReferenceSet()
    {
      int i = this.headerTable.length - 1;
      while (i != this.nextHeaderIndex)
      {
        if ((this.referencedHeaders.get(i)) && (!this.emittedReferencedHeaders.get(i))) {
          this.emittedHeaders.add(this.headerTable[i]);
        }
        i -= 1;
      }
    }
    
    List<Header> getAndReset()
    {
      ArrayList localArrayList = new ArrayList(this.emittedHeaders);
      this.emittedHeaders.clear();
      this.emittedReferencedHeaders.clear();
      return localArrayList;
    }
    
    int maxHeaderTableByteCount()
    {
      return this.maxHeaderTableByteCount;
    }
    
    void maxHeaderTableByteCountSetting(int paramInt)
    {
      this.maxHeaderTableByteCountSetting = paramInt;
      this.maxHeaderTableByteCount = this.maxHeaderTableByteCountSetting;
      adjustHeaderTableByteCount();
    }
    
    ByteString readByteString()
      throws IOException
    {
      int j = readByte();
      if ((j & 0x80) == 128) {}
      for (int i = 1;; i = 0)
      {
        j = readInt(j, 127);
        if (i == 0) {
          break;
        }
        return ByteString.of(Huffman.get().decode(this.source.readByteArray(j)));
      }
      return this.source.readByteString(j);
    }
    
    void readHeaders()
      throws IOException
    {
      while (!this.source.exhausted())
      {
        int i = this.source.readByte() & 0xFF;
        if (i == 128) {
          throw new IOException("index == 0");
        }
        if ((i & 0x80) == 128) {
          readIndexedHeader(readInt(i, 127) - 1);
        } else if (i == 64) {
          readLiteralHeaderWithIncrementalIndexingNewName();
        } else if ((i & 0x40) == 64) {
          readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
        } else if ((i & 0x20) == 32)
        {
          if ((i & 0x10) == 16)
          {
            if ((i & 0xF) != 0) {
              throw new IOException("Invalid header table state change " + i);
            }
            clearReferenceSet();
          }
          else
          {
            this.maxHeaderTableByteCount = readInt(i, 15);
            if ((this.maxHeaderTableByteCount < 0) || (this.maxHeaderTableByteCount > this.maxHeaderTableByteCountSetting)) {
              throw new IOException("Invalid header table byte count " + this.maxHeaderTableByteCount);
            }
            adjustHeaderTableByteCount();
          }
        }
        else if ((i == 16) || (i == 0)) {
          readLiteralHeaderWithoutIndexingNewName();
        } else {
          readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
        }
      }
    }
    
    int readInt(int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = readByte();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return paramInt2 + (i << paramInt1);
    }
  }
  
  static final class Writer
  {
    private final Buffer out;
    
    Writer(Buffer paramBuffer)
    {
      this.out = paramBuffer;
    }
    
    void writeByteString(ByteString paramByteString)
      throws IOException
    {
      writeInt(paramByteString.size(), 127, 0);
      this.out.write(paramByteString);
    }
    
    void writeHeaders(List<Header> paramList)
      throws IOException
    {
      int i = 0;
      int j = paramList.size();
      if (i < j)
      {
        ByteString localByteString = ((Header)paramList.get(i)).name.toAsciiLowercase();
        Integer localInteger = (Integer)HpackDraft07.NAME_TO_FIRST_INDEX.get(localByteString);
        if (localInteger != null)
        {
          writeInt(localInteger.intValue() + 1, 15, 0);
          writeByteString(((Header)paramList.get(i)).value);
        }
        for (;;)
        {
          i += 1;
          break;
          this.out.writeByte(0);
          writeByteString(localByteString);
          writeByteString(((Header)paramList.get(i)).value);
        }
      }
    }
    
    void writeInt(int paramInt1, int paramInt2, int paramInt3)
      throws IOException
    {
      if (paramInt1 < paramInt2)
      {
        this.out.writeByte(paramInt3 | paramInt1);
        return;
      }
      this.out.writeByte(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.out.writeByte(paramInt1 & 0x7F | 0x80);
        paramInt1 >>>= 7;
      }
      this.out.writeByte(paramInt1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/spdy/HpackDraft07.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */