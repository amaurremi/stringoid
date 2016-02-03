package com.parse.codec.binary;

public class Base32
  extends BaseNCodec
{
  private static final int BITS_PER_ENCODED_BYTE = 5;
  private static final int BYTES_PER_ENCODED_BLOCK = 8;
  private static final int BYTES_PER_UNENCODED_BLOCK = 5;
  private static final byte[] CHUNK_SEPARATOR = { 13, 10 };
  private static final byte[] DECODE_TABLE;
  private static final byte[] ENCODE_TABLE;
  private static final byte[] HEX_DECODE_TABLE;
  private static final byte[] HEX_ENCODE_TABLE = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86 };
  private static final int MASK_5BITS = 31;
  private long bitWorkArea;
  private final int decodeSize;
  private final byte[] decodeTable;
  private final int encodeSize;
  private final byte[] encodeTable;
  private final byte[] lineSeparator;
  
  static
  {
    byte[] arrayOfByte = new byte[91];
    arrayOfByte[0] = -1;
    arrayOfByte[1] = -1;
    arrayOfByte[2] = -1;
    arrayOfByte[3] = -1;
    arrayOfByte[4] = -1;
    arrayOfByte[5] = -1;
    arrayOfByte[6] = -1;
    arrayOfByte[7] = -1;
    arrayOfByte[8] = -1;
    arrayOfByte[9] = -1;
    arrayOfByte[10] = -1;
    arrayOfByte[11] = -1;
    arrayOfByte[12] = -1;
    arrayOfByte[13] = -1;
    arrayOfByte[14] = -1;
    arrayOfByte[15] = -1;
    arrayOfByte[16] = -1;
    arrayOfByte[17] = -1;
    arrayOfByte[18] = -1;
    arrayOfByte[19] = -1;
    arrayOfByte[20] = -1;
    arrayOfByte[21] = -1;
    arrayOfByte[22] = -1;
    arrayOfByte[23] = -1;
    arrayOfByte[24] = -1;
    arrayOfByte[25] = -1;
    arrayOfByte[26] = -1;
    arrayOfByte[27] = -1;
    arrayOfByte[28] = -1;
    arrayOfByte[29] = -1;
    arrayOfByte[30] = -1;
    arrayOfByte[31] = -1;
    arrayOfByte[32] = -1;
    arrayOfByte[33] = -1;
    arrayOfByte[34] = -1;
    arrayOfByte[35] = -1;
    arrayOfByte[36] = -1;
    arrayOfByte[37] = -1;
    arrayOfByte[38] = -1;
    arrayOfByte[39] = -1;
    arrayOfByte[40] = -1;
    arrayOfByte[41] = -1;
    arrayOfByte[42] = -1;
    arrayOfByte[43] = -1;
    arrayOfByte[44] = -1;
    arrayOfByte[45] = -1;
    arrayOfByte[46] = -1;
    arrayOfByte[47] = 63;
    arrayOfByte[48] = -1;
    arrayOfByte[49] = -1;
    arrayOfByte[50] = 26;
    arrayOfByte[51] = 27;
    arrayOfByte[52] = 28;
    arrayOfByte[53] = 29;
    arrayOfByte[54] = 30;
    arrayOfByte[55] = 31;
    arrayOfByte[56] = -1;
    arrayOfByte[57] = -1;
    arrayOfByte[58] = -1;
    arrayOfByte[59] = -1;
    arrayOfByte[60] = -1;
    arrayOfByte[61] = -1;
    arrayOfByte[62] = -1;
    arrayOfByte[63] = -1;
    arrayOfByte[64] = -1;
    arrayOfByte[66] = 1;
    arrayOfByte[67] = 2;
    arrayOfByte[68] = 3;
    arrayOfByte[69] = 4;
    arrayOfByte[70] = 5;
    arrayOfByte[71] = 6;
    arrayOfByte[72] = 7;
    arrayOfByte[73] = 8;
    arrayOfByte[74] = 9;
    arrayOfByte[75] = 10;
    arrayOfByte[76] = 11;
    arrayOfByte[77] = 12;
    arrayOfByte[78] = 13;
    arrayOfByte[79] = 14;
    arrayOfByte[80] = 15;
    arrayOfByte[81] = 16;
    arrayOfByte[82] = 17;
    arrayOfByte[83] = 18;
    arrayOfByte[84] = 19;
    arrayOfByte[85] = 20;
    arrayOfByte[86] = 21;
    arrayOfByte[87] = 22;
    arrayOfByte[88] = 23;
    arrayOfByte[89] = 24;
    arrayOfByte[90] = 25;
    DECODE_TABLE = arrayOfByte;
    ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55 };
    arrayOfByte = new byte[88];
    arrayOfByte[0] = -1;
    arrayOfByte[1] = -1;
    arrayOfByte[2] = -1;
    arrayOfByte[3] = -1;
    arrayOfByte[4] = -1;
    arrayOfByte[5] = -1;
    arrayOfByte[6] = -1;
    arrayOfByte[7] = -1;
    arrayOfByte[8] = -1;
    arrayOfByte[9] = -1;
    arrayOfByte[10] = -1;
    arrayOfByte[11] = -1;
    arrayOfByte[12] = -1;
    arrayOfByte[13] = -1;
    arrayOfByte[14] = -1;
    arrayOfByte[15] = -1;
    arrayOfByte[16] = -1;
    arrayOfByte[17] = -1;
    arrayOfByte[18] = -1;
    arrayOfByte[19] = -1;
    arrayOfByte[20] = -1;
    arrayOfByte[21] = -1;
    arrayOfByte[22] = -1;
    arrayOfByte[23] = -1;
    arrayOfByte[24] = -1;
    arrayOfByte[25] = -1;
    arrayOfByte[26] = -1;
    arrayOfByte[27] = -1;
    arrayOfByte[28] = -1;
    arrayOfByte[29] = -1;
    arrayOfByte[30] = -1;
    arrayOfByte[31] = -1;
    arrayOfByte[32] = -1;
    arrayOfByte[33] = -1;
    arrayOfByte[34] = -1;
    arrayOfByte[35] = -1;
    arrayOfByte[36] = -1;
    arrayOfByte[37] = -1;
    arrayOfByte[38] = -1;
    arrayOfByte[39] = -1;
    arrayOfByte[40] = -1;
    arrayOfByte[41] = -1;
    arrayOfByte[42] = -1;
    arrayOfByte[43] = -1;
    arrayOfByte[44] = -1;
    arrayOfByte[45] = -1;
    arrayOfByte[46] = -1;
    arrayOfByte[47] = 63;
    arrayOfByte[49] = 1;
    arrayOfByte[50] = 2;
    arrayOfByte[51] = 3;
    arrayOfByte[52] = 4;
    arrayOfByte[53] = 5;
    arrayOfByte[54] = 6;
    arrayOfByte[55] = 7;
    arrayOfByte[56] = 8;
    arrayOfByte[57] = 9;
    arrayOfByte[58] = -1;
    arrayOfByte[59] = -1;
    arrayOfByte[60] = -1;
    arrayOfByte[61] = -1;
    arrayOfByte[62] = -1;
    arrayOfByte[63] = -1;
    arrayOfByte[64] = -1;
    arrayOfByte[65] = 10;
    arrayOfByte[66] = 11;
    arrayOfByte[67] = 12;
    arrayOfByte[68] = 13;
    arrayOfByte[69] = 14;
    arrayOfByte[70] = 15;
    arrayOfByte[71] = 16;
    arrayOfByte[72] = 17;
    arrayOfByte[73] = 18;
    arrayOfByte[74] = 19;
    arrayOfByte[75] = 20;
    arrayOfByte[76] = 21;
    arrayOfByte[77] = 22;
    arrayOfByte[78] = 23;
    arrayOfByte[79] = 24;
    arrayOfByte[80] = 25;
    arrayOfByte[81] = 26;
    arrayOfByte[82] = 27;
    arrayOfByte[83] = 28;
    arrayOfByte[84] = 29;
    arrayOfByte[85] = 30;
    arrayOfByte[86] = 31;
    arrayOfByte[87] = 32;
    HEX_DECODE_TABLE = arrayOfByte;
  }
  
  public Base32()
  {
    this(false);
  }
  
  public Base32(int paramInt)
  {
    this(paramInt, CHUNK_SEPARATOR);
  }
  
  public Base32(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public Base32(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public Base32(boolean paramBoolean)
  {
    this(0, null, paramBoolean);
  }
  
  void decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eof) {
      return;
    }
    if (paramInt2 < 0) {
      this.eof = true;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {}
      int j;
      while ((this.eof) && (this.modulus >= 2))
      {
        ensureBufferSize(this.decodeSize);
        switch (this.modulus)
        {
        default: 
          return;
        case 2: 
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 2 & 0xFF));
          return;
          j = paramArrayOfByte[paramInt1];
          if (j != 61) {
            break label146;
          }
          this.eof = true;
        }
      }
      label146:
      ensureBufferSize(this.decodeSize);
      if ((j >= 0) && (j < this.decodeTable.length))
      {
        j = this.decodeTable[j];
        if (j >= 0)
        {
          this.modulus = ((this.modulus + 1) % 8);
          this.bitWorkArea = ((this.bitWorkArea << 5) + j);
          if (this.modulus == 0)
          {
            byte[] arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)(int)(this.bitWorkArea >> 32 & 0xFF));
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)(int)(this.bitWorkArea >> 24 & 0xFF));
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)(int)(this.bitWorkArea >> 16 & 0xFF));
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)(int)(this.bitWorkArea >> 8 & 0xFF));
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)(int)(this.bitWorkArea & 0xFF));
          }
        }
      }
      i += 1;
      paramInt1 += 1;
    }
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 7 & 0xFF));
    return;
    this.bitWorkArea >>= 4;
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 8 & 0xFF));
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea & 0xFF));
    return;
    this.bitWorkArea >>= 1;
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 16 & 0xFF));
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 8 & 0xFF));
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea & 0xFF));
    return;
    this.bitWorkArea >>= 6;
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 16 & 0xFF));
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 8 & 0xFF));
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea & 0xFF));
    return;
    this.bitWorkArea >>= 3;
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 24 & 0xFF));
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 16 & 0xFF));
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea >> 8 & 0xFF));
    paramArrayOfByte = this.buffer;
    paramInt1 = this.pos;
    this.pos = (paramInt1 + 1);
    paramArrayOfByte[paramInt1] = ((byte)(int)(this.bitWorkArea & 0xFF));
  }
  
  void encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eof) {}
    do
    {
      return;
      if (paramInt2 >= 0) {
        break;
      }
      this.eof = true;
    } while ((this.modulus == 0) && (this.lineLength == 0));
    ensureBufferSize(this.encodeSize);
    paramInt1 = this.pos;
    switch (this.modulus)
    {
    }
    for (;;)
    {
      this.currentLinePos += this.pos - paramInt1;
      if ((this.lineLength <= 0) || (this.currentLinePos <= 0)) {
        break;
      }
      System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
      this.pos += this.lineSeparator.length;
      return;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 3) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea << 2) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      continue;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 11) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 6) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 1) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea << 4) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      continue;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 19) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 14) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 9) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 4) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea << 1) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
      continue;
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 27) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 22) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 17) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 12) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 7) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea >> 2) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = this.encodeTable[((int)(this.bitWorkArea << 3) & 0x1F)];
      paramArrayOfByte = this.buffer;
      paramInt2 = this.pos;
      this.pos = (paramInt2 + 1);
      paramArrayOfByte[paramInt2] = 61;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {
        return;
      }
      ensureBufferSize(this.encodeSize);
      this.modulus = ((this.modulus + 1) % 5);
      int k = paramArrayOfByte[paramInt1];
      int j = k;
      if (k < 0) {
        j = k + 256;
      }
      this.bitWorkArea = ((this.bitWorkArea << 8) + j);
      if (this.modulus == 0)
      {
        byte[] arrayOfByte = this.buffer;
        j = this.pos;
        this.pos = (j + 1);
        arrayOfByte[j] = this.encodeTable[((int)(this.bitWorkArea >> 35) & 0x1F)];
        arrayOfByte = this.buffer;
        j = this.pos;
        this.pos = (j + 1);
        arrayOfByte[j] = this.encodeTable[((int)(this.bitWorkArea >> 30) & 0x1F)];
        arrayOfByte = this.buffer;
        j = this.pos;
        this.pos = (j + 1);
        arrayOfByte[j] = this.encodeTable[((int)(this.bitWorkArea >> 25) & 0x1F)];
        arrayOfByte = this.buffer;
        j = this.pos;
        this.pos = (j + 1);
        arrayOfByte[j] = this.encodeTable[((int)(this.bitWorkArea >> 20) & 0x1F)];
        arrayOfByte = this.buffer;
        j = this.pos;
        this.pos = (j + 1);
        arrayOfByte[j] = this.encodeTable[((int)(this.bitWorkArea >> 15) & 0x1F)];
        arrayOfByte = this.buffer;
        j = this.pos;
        this.pos = (j + 1);
        arrayOfByte[j] = this.encodeTable[((int)(this.bitWorkArea >> 10) & 0x1F)];
        arrayOfByte = this.buffer;
        j = this.pos;
        this.pos = (j + 1);
        arrayOfByte[j] = this.encodeTable[((int)(this.bitWorkArea >> 5) & 0x1F)];
        arrayOfByte = this.buffer;
        j = this.pos;
        this.pos = (j + 1);
        arrayOfByte[j] = this.encodeTable[((int)this.bitWorkArea & 0x1F)];
        this.currentLinePos += 8;
        if ((this.lineLength > 0) && (this.lineLength <= this.currentLinePos))
        {
          System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
          this.pos += this.lineSeparator.length;
          this.currentLinePos = 0;
        }
      }
      i += 1;
      paramInt1 += 1;
    }
  }
  
  public boolean isInAlphabet(byte paramByte)
  {
    return (paramByte >= 0) && (paramByte < this.decodeTable.length) && (this.decodeTable[paramByte] != -1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/binary/Base32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */