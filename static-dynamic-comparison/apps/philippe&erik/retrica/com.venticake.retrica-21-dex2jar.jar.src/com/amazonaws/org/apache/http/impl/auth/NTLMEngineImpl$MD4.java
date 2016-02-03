package com.amazonaws.org.apache.http.impl.auth;

class NTLMEngineImpl$MD4
{
  protected int A = 1732584193;
  protected int B = -271733879;
  protected int C = -1732584194;
  protected int D = 271733878;
  protected long count = 0L;
  protected byte[] dataBuffer = new byte[64];
  
  byte[] getOutput()
  {
    int i = (int)(this.count & 0x3F);
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      arrayOfByte = new byte[i + 8];
      arrayOfByte[0] = Byte.MIN_VALUE;
      int j = 0;
      while (j < 8)
      {
        arrayOfByte[(i + j)] = ((byte)(int)(this.count * 8L >>> j * 8));
        j += 1;
      }
    }
    update(arrayOfByte);
    byte[] arrayOfByte = new byte[16];
    NTLMEngineImpl.writeULong(arrayOfByte, this.A, 0);
    NTLMEngineImpl.writeULong(arrayOfByte, this.B, 4);
    NTLMEngineImpl.writeULong(arrayOfByte, this.C, 8);
    NTLMEngineImpl.writeULong(arrayOfByte, this.D, 12);
    return arrayOfByte;
  }
  
  protected void processBuffer()
  {
    int[] arrayOfInt = new int[16];
    int i = 0;
    while (i < 16)
    {
      arrayOfInt[i] = ((this.dataBuffer[(i * 4)] & 0xFF) + ((this.dataBuffer[(i * 4 + 1)] & 0xFF) << 8) + ((this.dataBuffer[(i * 4 + 2)] & 0xFF) << 16) + ((this.dataBuffer[(i * 4 + 3)] & 0xFF) << 24));
      i += 1;
    }
    i = this.A;
    int j = this.B;
    int k = this.C;
    int m = this.D;
    round1(arrayOfInt);
    round2(arrayOfInt);
    round3(arrayOfInt);
    this.A = (i + this.A);
    this.B += j;
    this.C += k;
    this.D += m;
  }
  
  protected void round1(int[] paramArrayOfInt)
  {
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + paramArrayOfInt[0], 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + paramArrayOfInt[1], 7);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + paramArrayOfInt[2], 11);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + paramArrayOfInt[3], 19);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + paramArrayOfInt[4], 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + paramArrayOfInt[5], 7);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + paramArrayOfInt[6], 11);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + paramArrayOfInt[7], 19);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + paramArrayOfInt[8], 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + paramArrayOfInt[9], 7);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + paramArrayOfInt[10], 11);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + paramArrayOfInt[11], 19);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + paramArrayOfInt[12], 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(this.A, this.B, this.C) + paramArrayOfInt[13], 7);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(this.D, this.A, this.B) + paramArrayOfInt[14], 11);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(this.C, this.D, this.A) + paramArrayOfInt[15], 19);
  }
  
  protected void round2(int[] paramArrayOfInt)
  {
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + paramArrayOfInt[0] + 1518500249, 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + paramArrayOfInt[4] + 1518500249, 5);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + paramArrayOfInt[8] + 1518500249, 9);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + paramArrayOfInt[12] + 1518500249, 13);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + paramArrayOfInt[1] + 1518500249, 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + paramArrayOfInt[5] + 1518500249, 5);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + paramArrayOfInt[9] + 1518500249, 9);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + paramArrayOfInt[13] + 1518500249, 13);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + paramArrayOfInt[2] + 1518500249, 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + paramArrayOfInt[6] + 1518500249, 5);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + paramArrayOfInt[10] + 1518500249, 9);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + paramArrayOfInt[14] + 1518500249, 13);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + paramArrayOfInt[3] + 1518500249, 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(this.A, this.B, this.C) + paramArrayOfInt[7] + 1518500249, 5);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(this.D, this.A, this.B) + paramArrayOfInt[11] + 1518500249, 9);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(this.C, this.D, this.A) + paramArrayOfInt[15] + 1518500249, 13);
  }
  
  protected void round3(int[] paramArrayOfInt)
  {
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + paramArrayOfInt[0] + 1859775393, 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + paramArrayOfInt[8] + 1859775393, 9);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + paramArrayOfInt[4] + 1859775393, 11);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + paramArrayOfInt[12] + 1859775393, 15);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + paramArrayOfInt[2] + 1859775393, 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + paramArrayOfInt[10] + 1859775393, 9);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + paramArrayOfInt[6] + 1859775393, 11);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + paramArrayOfInt[14] + 1859775393, 15);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + paramArrayOfInt[1] + 1859775393, 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + paramArrayOfInt[9] + 1859775393, 9);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + paramArrayOfInt[5] + 1859775393, 11);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + paramArrayOfInt[13] + 1859775393, 15);
    this.A = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + paramArrayOfInt[3] + 1859775393, 3);
    this.D = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(this.A, this.B, this.C) + paramArrayOfInt[11] + 1859775393, 9);
    this.C = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(this.D, this.A, this.B) + paramArrayOfInt[7] + 1859775393, 11);
    this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(this.C, this.D, this.A) + paramArrayOfInt[15] + 1859775393, 15);
  }
  
  void update(byte[] paramArrayOfByte)
  {
    int j = (int)(this.count & 0x3F);
    int i = 0;
    int k;
    while (paramArrayOfByte.length - i + j >= this.dataBuffer.length)
    {
      k = this.dataBuffer.length - j;
      System.arraycopy(paramArrayOfByte, i, this.dataBuffer, j, k);
      this.count += k;
      i += k;
      processBuffer();
      j = 0;
    }
    if (i < paramArrayOfByte.length)
    {
      k = paramArrayOfByte.length - i;
      System.arraycopy(paramArrayOfByte, i, this.dataBuffer, j, k);
      this.count += k;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngineImpl$MD4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */