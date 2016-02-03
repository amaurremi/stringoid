package com.squareup.okhttp.internal.spdy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Huffman
{
  private static final int[] CODES = { 67108794, 67108795, 67108796, 67108797, 67108798, 67108799, 67108800, 67108801, 67108802, 67108803, 67108804, 67108805, 67108806, 67108807, 67108808, 67108809, 67108810, 67108811, 67108812, 67108813, 67108814, 67108815, 67108816, 67108817, 67108818, 67108819, 67108820, 67108821, 67108822, 67108823, 67108824, 67108825, 6, 8188, 496, 16380, 32764, 30, 100, 8189, 1018, 497, 1019, 1020, 101, 102, 31, 7, 0, 1, 2, 8, 32, 33, 34, 35, 36, 37, 38, 236, 131068, 39, 32765, 1021, 32766, 103, 237, 238, 104, 239, 105, 106, 498, 240, 499, 500, 501, 107, 108, 241, 242, 502, 503, 109, 40, 243, 504, 505, 244, 506, 507, 2044, 67108826, 2045, 16381, 110, 262142, 9, 111, 10, 41, 11, 112, 42, 43, 12, 245, 246, 44, 45, 46, 13, 47, 508, 48, 49, 14, 113, 114, 115, 116, 117, 247, 131069, 4092, 131070, 4093, 67108827, 67108828, 67108829, 67108830, 67108831, 67108832, 67108833, 67108834, 67108835, 67108836, 67108837, 67108838, 67108839, 67108840, 67108841, 67108842, 67108843, 67108844, 67108845, 67108846, 67108847, 67108848, 67108849, 67108850, 67108851, 67108852, 67108853, 67108854, 67108855, 67108856, 67108857, 67108858, 67108859, 67108860, 67108861, 67108862, 67108863, 33554304, 33554305, 33554306, 33554307, 33554308, 33554309, 33554310, 33554311, 33554312, 33554313, 33554314, 33554315, 33554316, 33554317, 33554318, 33554319, 33554320, 33554321, 33554322, 33554323, 33554324, 33554325, 33554326, 33554327, 33554328, 33554329, 33554330, 33554331, 33554332, 33554333, 33554334, 33554335, 33554336, 33554337, 33554338, 33554339, 33554340, 33554341, 33554342, 33554343, 33554344, 33554345, 33554346, 33554347, 33554348, 33554349, 33554350, 33554351, 33554352, 33554353, 33554354, 33554355, 33554356, 33554357, 33554358, 33554359, 33554360, 33554361, 33554362, 33554363, 33554364, 33554365, 33554366, 33554367, 33554368, 33554369, 33554370, 33554371, 33554372, 33554373, 33554374, 33554375, 33554376, 33554377, 33554378, 33554379, 33554380, 33554381, 33554382, 33554383, 33554384, 33554385, 33554386, 33554387, 33554388, 33554389, 33554390, 33554391, 33554392, 33554393, 33554394, 33554395 };
  private static final byte[] CODE_LENGTHS = { 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 5, 13, 9, 14, 15, 6, 7, 13, 10, 9, 10, 10, 7, 7, 6, 5, 4, 4, 4, 5, 6, 6, 6, 6, 6, 6, 6, 8, 17, 6, 15, 10, 15, 7, 8, 8, 7, 8, 7, 7, 9, 8, 9, 9, 9, 7, 7, 8, 8, 9, 9, 7, 6, 8, 9, 9, 8, 9, 9, 11, 26, 11, 14, 7, 18, 5, 7, 5, 6, 5, 7, 6, 6, 5, 8, 8, 6, 6, 6, 5, 6, 9, 6, 6, 5, 7, 7, 7, 7, 7, 8, 17, 12, 17, 12, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25 };
  private static final Huffman INSTANCE = new Huffman();
  private final Node root = new Node();
  
  private Huffman()
  {
    buildTree();
  }
  
  private void addCode(int paramInt1, int paramInt2, byte paramByte)
  {
    Node localNode2 = new Node(paramInt1, paramByte);
    for (Node localNode1 = this.root; paramByte > 8; localNode1 = localNode1.children[paramInt1])
    {
      paramByte = (byte)(paramByte - 8);
      paramInt1 = paramInt2 >>> paramByte & 0xFF;
      if (localNode1.children == null) {
        throw new IllegalStateException("invalid dictionary: prefix not unique");
      }
      if (localNode1.children[paramInt1] == null) {
        localNode1.children[paramInt1] = new Node();
      }
    }
    paramByte = 8 - paramByte;
    paramInt2 = paramInt2 << paramByte & 0xFF;
    paramInt1 = paramInt2;
    while (paramInt1 < paramInt2 + (1 << paramByte))
    {
      localNode1.children[paramInt1] = localNode2;
      paramInt1 += 1;
    }
  }
  
  private void buildTree()
  {
    int i = 0;
    while (i < CODE_LENGTHS.length)
    {
      addCode(i, CODES[i], CODE_LENGTHS[i]);
      i += 1;
    }
  }
  
  public static Huffman get()
  {
    return INSTANCE;
  }
  
  byte[] decode(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Node localNode1 = this.root;
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
    Node localNode2;
    for (;;)
    {
      m = i;
      localNode2 = localNode1;
      if (j >= paramArrayOfByte.length) {
        break;
      }
      k = k << 8 | paramArrayOfByte[j] & 0xFF;
      i += 8;
      while (i >= 8)
      {
        localNode1 = localNode1.children[(k >>> i - 8 & 0xFF)];
        if (localNode1.children == null)
        {
          localByteArrayOutputStream.write(localNode1.symbol);
          i -= localNode1.terminalBits;
          localNode1 = this.root;
        }
        else
        {
          i -= 8;
        }
      }
      j += 1;
    }
    do
    {
      localByteArrayOutputStream.write(paramArrayOfByte.symbol);
      m -= paramArrayOfByte.terminalBits;
      localNode2 = this.root;
      if (m <= 0) {
        break;
      }
      paramArrayOfByte = localNode2.children[(k << 8 - m & 0xFF)];
    } while ((paramArrayOfByte.children == null) && (paramArrayOfByte.terminalBits <= m));
    return localByteArrayOutputStream.toByteArray();
  }
  
  void encode(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    long l = 0L;
    int i = 0;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      int m = paramArrayOfByte[j] & 0xFF;
      int k = CODES[m];
      m = CODE_LENGTHS[m];
      l = l << m | k;
      i += m;
      while (i >= 8)
      {
        i -= 8;
        paramOutputStream.write((int)(l >> i));
      }
      j += 1;
    }
    if (i > 0) {
      paramOutputStream.write((int)(l << 8 - i | 255 >>> i));
    }
  }
  
  int encodedLength(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      l += CODE_LENGTHS[(j & 0xFF)];
      i += 1;
    }
    return (int)(7L + l >> 3);
  }
  
  private static final class Node
  {
    private final Node[] children;
    private final int symbol;
    private final int terminalBits;
    
    Node()
    {
      this.children = new Node['Ā'];
      this.symbol = 0;
      this.terminalBits = 0;
    }
    
    Node(int paramInt1, int paramInt2)
    {
      this.children = null;
      this.symbol = paramInt1;
      paramInt2 &= 0x7;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 8;
      }
      this.terminalBits = paramInt1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/spdy/Huffman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */