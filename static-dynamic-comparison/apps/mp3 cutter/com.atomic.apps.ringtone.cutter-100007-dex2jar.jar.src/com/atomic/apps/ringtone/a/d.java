package com.atomic.apps.ringtone.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public final class d
  extends h
{
  private static int[] m;
  private static int[] n;
  private static int[] o;
  private static int[] p;
  private static int[] q;
  private static int[] r;
  private static int[] s;
  private int c;
  private int[] d;
  private int[] e;
  private int[] f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  static
  {
    int[] arrayOfInt = new int[16];
    arrayOfInt[0] = 12;
    arrayOfInt[1] = 13;
    arrayOfInt[2] = 15;
    arrayOfInt[3] = 17;
    arrayOfInt[4] = 19;
    arrayOfInt[5] = 20;
    arrayOfInt[6] = 26;
    arrayOfInt[7] = 31;
    arrayOfInt[8] = 5;
    m = arrayOfInt;
    n = new int[] { 28753, 2785, 6594, 7413, 10444, 1269, 4423, 1556, 12820, 2498, 4833, 2498, 7864, 1884, 3153, 1802, 20193, 3031, 5857, 4014, 8970, 1392, 4096, 655, 13926, 3112, 4669, 2703, 6553, 901, 2662, 655, 23511, 2457, 5079, 4096, 8560, 737, 4259, 2088, 12288, 1474, 4628, 1433, 7004, 737, 2252, 1228, 17326, 2334, 5816, 3686, 8601, 778, 3809, 614, 9256, 1761, 3522, 1966, 5529, 737, 3194, 778 };
    arrayOfInt = new int[65];
    arrayOfInt[0] = 17333;
    arrayOfInt[1] = 62105;
    arrayOfInt[2] = 4235;
    arrayOfInt[3] = 5276;
    arrayOfInt[4] = 8325;
    arrayOfInt[5] = 55114;
    arrayOfInt[6] = 683;
    arrayOfInt[7] = 56927;
    arrayOfInt[8] = 10148;
    arrayOfInt[9] = 61138;
    arrayOfInt[10] = 1472;
    arrayOfInt[11] = 61138;
    arrayOfInt[12] = 5802;
    arrayOfInt[13] = 58629;
    arrayOfInt[14] = 63209;
    arrayOfInt[15] = 58233;
    arrayOfInt[16] = 14189;
    arrayOfInt[17] = 62858;
    arrayOfInt[18] = 3181;
    arrayOfInt[19] = 65356;
    arrayOfInt[20] = 6972;
    arrayOfInt[21] = 55937;
    arrayOfInt[23] = 49231;
    arrayOfInt[24] = 10884;
    arrayOfInt[25] = 63092;
    arrayOfInt[26] = 1165;
    arrayOfInt[27] = 61839;
    arrayOfInt[28] = 4180;
    arrayOfInt[29] = 52068;
    arrayOfInt[30] = 61703;
    arrayOfInt[31] = 49231;
    arrayOfInt[32] = 15543;
    arrayOfInt[33] = 60990;
    arrayOfInt[34] = 1913;
    arrayOfInt[36] = 6556;
    arrayOfInt[37] = 50281;
    arrayOfInt[38] = 347;
    arrayOfInt[39] = 59543;
    arrayOfInt[40] = 9771;
    arrayOfInt[41] = 56446;
    arrayOfInt[42] = 1086;
    arrayOfInt[43] = 56195;
    arrayOfInt[44] = 4772;
    arrayOfInt[45] = 50281;
    arrayOfInt[46] = 60215;
    arrayOfInt[47] = 54822;
    arrayOfInt[48] = 12827;
    arrayOfInt[49] = 60534;
    arrayOfInt[50] = 3118;
    arrayOfInt[51] = 64598;
    arrayOfInt[52] = 6598;
    arrayOfInt[53] = 50762;
    arrayOfInt[54] = 64890;
    arrayOfInt[55] = 48657;
    arrayOfInt[56] = 7251;
    arrayOfInt[57] = 58028;
    arrayOfInt[58] = 64193;
    arrayOfInt[59] = 59007;
    arrayOfInt[60] = 2668;
    arrayOfInt[61] = 50281;
    arrayOfInt[62] = 63324;
    arrayOfInt[63] = 63082;
    arrayOfInt[64] = 50762;
    o = arrayOfInt;
    p = new int[] { 159, 61760, 42805, 206, 62142, 45108, 268, 62531, 47448, 349, 62921, 49797, 419, 63191, 51423, 482, 63398, 52669, 554, 63604, 53907, 637, 63810, 55149, 733, 64018, 56397, 842, 64222, 57630, 969, 64430, 58880, 1114, 64636, 60120, 1281, 64842, 61363, 1473, 65049, 62605, 1694, 65255, 63848, 1948, -75, 65091, 2241, 133, 801, 2577, 339, 2044, 2963, 545, 3285, 3408, 752, 4530, 3919, 958, 5772, 4507, 1165, 7016, 5183, 1371, 8259, 5960, 1577, 9501, 6855, 1784, 10745, 7883, 1991, 11988, 9065, 2197, 13231, 10425, 2404, 14474, 12510, 2673, 16096, 16263, 3060, 18429, 21142, 3448, 20763, 27485, 3836, 23097 };
    q = new int[] { 812, 128, 542, 140, 2873, 1135, 2266, 3402, 2067, 563, 12677, 647, 4132, 1798, 5601, 5285, 7689, 374, 3735, 441, 10912, 2638, 11807, 2494, 20490, 797, 5218, 675, 6724, 8354, 5282, 1696, 1488, 428, 5882, 452, 5332, 4072, 3583, 1268, 2469, 901, 15894, 1005, 14982, 3271, 10331, 4858, 3635, 2021, 2596, 835, 12360, 4892, 12206, 1704, 13432, 1604, 9118, 2341, 3968, 1538, 5479, 9936, 3795, 417, 1359, 414, 3640, 1569, 7995, 3541, 11405, 645, 8552, 635, 4056, 1377, 16608, 6124, 11420, 700, 2007, 607, 12415, 1578, 11119, 4654, 13680, 1708, 11990, 1229, 7996, 7297, 13231, 5715, 2428, 1159, 2073, 1941, 6218, 6121, 3546, 1804, 8925, 1802, 8679, 1580, 13935, 3576, 13313, 6237, 6142, 1130, 5994, 1734, 14141, 4662, 11271, 3321, 12226, 1551, 13931, 3015, 5081, 10464, 9444, 6706, 1689, 683, 1436, 1306, 7212, 3933, 4082, 2713, 7793, 704, 15070, 802, 6299, 5212, 4337, 5357, 6676, 541, 6062, 626, 13651, 3700, 11498, 2408, 16156, 716, 12177, 751, 8065, 11489, 6314, 2256, 4466, 496, 7293, 523, 10213, 3833, 8394, 3037, 8403, 966, 14228, 1880, 8703, 5409, 16395, 4863, 7420, 1979, 6089, 1230, 9371, 4398, 14558, 3363, 13559, 2873, 13163, 1465, 5534, 1678, 13138, 14771, 7338, 600, 1318, 548, 4252, 3539, 10044, 2364, 10587, 622, 13088, 669, 14126, 3526, 5039, 9784, 15338, 619, 3115, 590, 16442, 3013, 15542, 4168, 15537, 1611, 15405, 1228, 16023, 9299, 7534, 4976, 1990, 1213, 11447, 1157, 12512, 5519, 9475, 2644, 7716, 2034, 13280, 2239, 16011, 5093, 8066, 6761, 10083, 1413, 5002, 2347, 12523, 5975, 15126, 2899, 18264, 2289, 15827, 2527, 16265, 10254, 14651, 11319, 1797, 337, 3115, 397, 3510, 2928, 4592, 2670, 7519, 628, 11415, 656, 5946, 2435, 6544, 7367, 8238, 829, 4000, 863, 10032, 2492, 16057, 3551, 18204, 1054, 6103, 1454, 5884, 7900, 18752, 3468, 1864, 544, 9198, 683, 11623, 4160, 4594, 1644, 3158, 1157, 15953, 2560, 12349, 3733, 17420, 5260, 6106, 2004, 2917, 1742, 16467, 5257, 16787, 1680, 17205, 1759, 4773, 3231, 7386, 6035, 14342, 10012, 4035, 442, 4194, 458, 9214, 2242, 7427, 4217, 12860, 801, 11186, 825, 12648, 2084, 12956, 6554, 9505, 996, 6629, 985, 10537, 2502, 15289, 5006, 12602, 2055, 15484, 1653, 16194, 6921, 14231, 5790, 2626, 828, 5615, 1686, 13663, 5778, 3668, 1554, 11313, 2633, 9770, 1459, 14003, 4733, 15897, 6291, 6278, 1870, 7910, 2285, 16978, 4571, 16576, 3849, 15248, 2311, 16023, 3244, 14459, 17808, 11847, 2763, 1981, 1407, 1400, 876, 4335, 3547, 4391, 4210, 5405, 680, 17461, 781, 6501, 5118, 8091, 7677, 7355, 794, 8333, 1182, 15041, 3160, 14928, 3039, 20421, 880, 14545, 852, 12337, 14708, 6904, 1920, 4225, 933, 8218, 1087, 10659, 4084, 10082, 4533, 2735, 840, 20657, 1081, 16711, 5966, 15873, 4578, 10871, 2574, 3773, 1166, 14519, 4044, 20699, 2627, 15219, 2734, 15274, 2186, 6257, 3226, 13125, 19480, 7196, 930, 2462, 1618, 4515, 3092, 13852, 4277, 10460, 833, 17339, 810, 16891, 2289, 15546, 8217, 13603, 1684, 3197, 1834, 15948, 2820, 15812, 5327, 17006, 2438, 16788, 1326, 15671, 8156, 11726, 8556, 3762, 2053, 9563, 1317, 13561, 6790, 12227, 1936, 8180, 3550, 13287, 1778, 16299, 6599, 16291, 7758, 8521, 2551, 7225, 2645, 18269, 7489, 16885, 2248, 17882, 2884, 17265, 3328, 9417, 20162, 11042, 8320, 1286, 620, 1431, 583, 5993, 2289, 3978, 3626, 5144, 752, 13409, 830, 5553, 2860, 11764, 5908, 10737, 560, 5446, 564, 13321, 3008, 11946, 3683, 19887, 798, 9825, 728, 13663, 8748, 7391, 3053, 2515, 778, 6050, 833, 6469, 5074, 8305, 2463, 6141, 1865, 15308, 1262, 14408, 4547, 13663, 4515, 3137, 2983, 2479, 1259, 15088, 4647, 15382, 2607, 14492, 2392, 12462, 2537, 7539, 2949, 12909, 12060, 5468, 684, 3141, 722, 5081, 1274, 12732, 4200, 15302, 681, 7819, 592, 6534, 2021, 16478, 8737, 13364, 882, 5397, 899, 14656, 2178, 14741, 4227, 14270, 1298, 13929, 2029, 15477, 7482, 15815, 4572, 2521, 2013, 5062, 1804, 5159, 6582, 7130, 3597, 10920, 1611, 11729, 1708, 16903, 3455, 16268, 6640, 9306, 1007, 9369, 2106, 19182, 5037, 12441, 4269, 15919, 1332, 15357, 3512, 11898, 14141, 16101, 6854, 2010, 737, 3779, 861, 11454, 2880, 3564, 3540, 9057, 1241, 12391, 896, 8546, 4629, 11561, 5776, 8129, 589, 8218, 588, 18728, 3755, 12973, 3149, 15729, 758, 16634, 754, 15222, 11138, 15871, 2208, 4673, 610, 10218, 678, 15257, 4146, 5729, 3327, 8377, 1670, 19862, 2321, 15450, 5511, 14054, 5481, 5728, 2888, 7580, 1346, 14384, 5325, 16236, 3950, 15118, 3744, 15306, 1435, 14597, 4070, 12301, 15696, 7617, 1699, 2170, 884, 4459, 4567, 18094, 3306, 12742, 815, 14926, 907, 15016, 4281, 15518, 8368, 17994, 1087, 2358, 865, 16281, 3787, 15679, 4596, 16356, 1534, 16584, 2210, 16833, 9697, 15929, 4513, 3277, 1085, 9643, 2187, 11973, 6068, 9199, 4462, 8955, 1629, 10289, 3062, 16481, 5155, 15466, 7066, 13678, 2543, 5273, 2277, 16746, 6213, 16655, 3408, 20304, 3363, 18688, 1985, 14172, 12867, 15154, 15703, 4473, 1020, 1681, 886, 4311, 4301, 8952, 3657, 5893, 1147, 11647, 1452, 15886, 2227, 4582, 6644, 6929, 1205, 6220, 799, 12415, 3409, 15968, 3877, 19859, 2109, 9689, 2141, 14742, 8830, 14480, 2599, 1817, 1238, 7771, 813, 19079, 4410, 5554, 2064, 3687, 2844, 17435, 2256, 16697, 4486, 16199, 5388, 8028, 2763, 3405, 2119, 17426, 5477, 13698, 2786, 19879, 2720, 9098, 3880, 18172, 4833, 17336, 12207, 5116, 996, 4935, 988, 9888, 3081, 6014, 5371, 15881, 1667, 8405, 1183, 15087, 2366, 19777, 7002, 11963, 1562, 7279, 1128, 16859, 1532, 15762, 5381, 14708, 2065, 20105, 2155, 17158, 8245, 17911, 6318, 5467, 1504, 4100, 2574, 17421, 6810, 5673, 2888, 16636, 3382, 8975, 1831, 20159, 4737, 19550, 7294, 6658, 2781, 11472, 3321, 19397, 5054, 18878, 4722, 16439, 2373, 20430, 4386, 11353, 26526, 11593, 3068, 2866, 1566, 5108, 1070, 9614, 4915, 4939, 3536, 7541, 878, 20717, 851, 6938, 4395, 16799, 7733, 10137, 1019, 9845, 964, 15494, 3955, 15459, 3430, 18863, 982, 20120, 963, 16876, 12887, 14334, 4200, 6599, 1220, 9222, 814, 16942, 5134, 5661, 4898, 5488, 1798, 20258, 3962, 17005, 6178, 17929, 5929, 9365, 3420, 7474, 1971, 19537, 5177, 19003, 3006, 16454, 3788, 16070, 2367, 8664, 2743, 9445, 26358, 10856, 1287, 3555, 1009, 5606, 3622, 19453, 5512, 12453, 797, 20634, 911, 15427, 3066, 17037, 10275, 18883, 2633, 3913, 1268, 19519, 3371, 18052, 5230, 19291, 1678, 19508, 3172, 18072, 10754, 16625, 6845, 3134, 2298, 10869, 2437, 15580, 6913, 12597, 3381, 11116, 3297, 16762, 2424, 18853, 6715, 17171, 9887, 12743, 2605, 8937, 3140, 19033, 7764, 18347, 3880, 20475, 3682, 19602, 3380, 13044, 19373, 10526, 23124 };
    arrayOfInt = new int[8];
    arrayOfInt[1] = 1;
    arrayOfInt[2] = 3;
    arrayOfInt[3] = 2;
    arrayOfInt[4] = 5;
    arrayOfInt[5] = 6;
    arrayOfInt[6] = 4;
    arrayOfInt[7] = 7;
    r = arrayOfInt;
    arrayOfInt = new int[16];
    arrayOfInt[1] = 3277;
    arrayOfInt[2] = 6556;
    arrayOfInt[3] = 8192;
    arrayOfInt[4] = 9830;
    arrayOfInt[5] = 11469;
    arrayOfInt[6] = 12288;
    arrayOfInt[7] = 13107;
    arrayOfInt[8] = 13926;
    arrayOfInt[9] = 14746;
    arrayOfInt[10] = 15565;
    arrayOfInt[11] = 16384;
    arrayOfInt[12] = 17203;
    arrayOfInt[13] = 18022;
    arrayOfInt[14] = 18842;
    arrayOfInt[15] = 19661;
    s = arrayOfInt;
  }
  
  public static i a()
  {
    return new e();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d[this.c] = paramInt1;
    this.e[this.c] = paramInt2;
    this.f[this.c] = paramInt3;
    if (paramInt3 < this.k) {
      this.k = paramInt3;
    }
    if (paramInt3 > this.l) {
      this.l = paramInt3;
    }
    this.c += 1;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int[] arrayOfInt3;
    if (this.c == this.j)
    {
      paramInt2 = this.j << 1;
      arrayOfInt1 = new int[paramInt2];
      arrayOfInt2 = new int[paramInt2];
      arrayOfInt3 = new int[paramInt2];
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 >= this.c)
      {
        this.d = arrayOfInt1;
        this.e = arrayOfInt2;
        this.f = arrayOfInt3;
        this.j = paramInt2;
        return;
      }
      arrayOfInt1[paramInt1] = this.d[paramInt1];
      arrayOfInt2[paramInt1] = this.e[paramInt1];
      arrayOfInt3[paramInt1] = this.f[paramInt1];
      paramInt1 += 1;
    }
  }
  
  private void a(InputStream paramInputStream, int paramInt)
  {
    for (;;)
    {
      if (paramInt < 8) {}
      byte[] arrayOfByte;
      int i1;
      do
      {
        return;
        arrayOfByte = new byte[8];
        paramInputStream.read(arrayOfByte, 0, 8);
        this.i += 8;
        i1 = (arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF;
      } while ((i1 > paramInt) || (i1 <= 0));
      if ((arrayOfByte[4] == 109) && (arrayOfByte[5] == 100) && (arrayOfByte[6] == 97) && (arrayOfByte[7] == 116))
      {
        b(paramInputStream, i1);
        return;
      }
      paramInputStream.skip(i1 - 8);
      this.i += i1 - 8;
      paramInt -= i1;
    }
  }
  
  private void b(InputStream paramInputStream, int paramInt)
  {
    int[] arrayOfInt = new int[4];
    int i1 = 0;
    if (i1 >= 4)
    {
      localObject1 = new int[4];
      i1 = 0;
    }
    int i3;
    int i2;
    for (;;)
    {
      if (i1 >= 4)
      {
        i3 = 0;
        i2 = paramInt;
        if (i2 > 0) {
          break label72;
        }
        label39:
        return;
        arrayOfInt[i1] = 0;
        i1 += 1;
        break;
      }
      localObject1[i1] = 63155;
      i1 += 1;
    }
    label72:
    int i8 = this.i;
    Object localObject1 = new byte[1];
    paramInputStream.read((byte[])localObject1, 0, 1);
    this.i += 1;
    int i10 = ((localObject1[0] & 0xFF) >> 3) % 15;
    int i9 = m[i10];
    if (i9 + 1 > i2) {}
    for (i1 = i2;; i1 = 1)
    {
      label138:
      i3 += i1;
      i2 -= i1;
      if ((this.a != null) && (!this.a.a(i3 / paramInt))) {
        break label39;
      }
      break;
      if (i9 != 0) {
        break label191;
      }
    }
    label191:
    Object localObject2 = new byte[i9];
    paramInputStream.read((byte[])localObject2, 0, i9);
    this.i += i9;
    localObject1 = new int[i9 << 3];
    i1 = localObject2[0] & 0xFF;
    int i5 = 0;
    int i4 = 0;
    int i7;
    int i6;
    for (;;)
    {
      if (i4 >= i9 << 3) {}
      switch (i10)
      {
      default: 
        System.out.println("Unsupported frame type: " + i10);
        a(i8, i9 + 1, 1);
        i1 = i9 + 1;
        break label138;
        localObject1[i4] = ((i1 & 0x80) >> 7);
        i7 = i1 << 1;
        i1 = i7;
        i6 = i5;
        if ((i4 & 0x7) == 7)
        {
          i1 = i7;
          i6 = i5;
          if (i4 < (i9 << 3) - 1)
          {
            i6 = i5 + 1;
            i1 = localObject2[i6] & 0xFF;
          }
        }
        i4 += 1;
        i5 = i6;
      }
    }
    this.h = 5;
    localObject2 = new int[4];
    localObject2[0] = (localObject1[28] * 1 + localObject1[29] * 2 + localObject1[30] * 4 + localObject1[31] * 8 + localObject1[46] * 16 + localObject1[47] * 32 + localObject1[48] * 64 + localObject1[49] * 128);
    localObject2[1] = localObject2[0];
    localObject2[2] = (localObject1[32] * 1 + localObject1[33] * 2 + localObject1[34] * 4 + localObject1[35] * 8 + localObject1[40] * 16 + localObject1[41] * 32 + localObject1[42] * 64 + localObject1[43] * 128);
    localObject2[3] = localObject2[2];
    i1 = 0;
    double d1;
    int i11;
    int i12;
    while (i1 < 4)
    {
      i4 = localObject2[i1];
      i4 = q[((i4 << 2) + ((i1 & 0x1) << 1) + 1)];
      d1 = Math.log(i4) / Math.log(2.0D);
      i5 = (int)d1;
      i6 = (int)((d1 - i5) * 32768.0D);
      i7 = arrayOfInt[0];
      i10 = arrayOfInt[1];
      i11 = arrayOfInt[2];
      i12 = arrayOfInt[3];
      arrayOfInt[3] = arrayOfInt[2];
      arrayOfInt[2] = arrayOfInt[1];
      arrayOfInt[1] = arrayOfInt[0];
      arrayOfInt[0] = (((i5 - 12) * 49320 + (i6 * 24660 >> 15 << 1) << 13) + 32768 >> 16);
      a(i8, i9 + 1, i4 * (385963008 + i7 * 5571 + i10 * 4751 + i11 * 2785 + i12 * 1556 >> 15) >> 24);
      i1 += 1;
    }
    this.h = 5;
    localObject2 = new int[4];
    localObject2[0] = (localObject1[24] * 1 + localObject1[25] * 2 + localObject1[26] * 4 + localObject1[36] * 8 + localObject1[45] * 16 + localObject1[55] * 32);
    localObject2[1] = (localObject1[27] * 1 + localObject1[28] * 2 + localObject1[29] * 4 + localObject1[37] * 8 + localObject1[46] * 16 + localObject1[56] * 32);
    localObject2[2] = (localObject1[30] * 1 + localObject1[31] * 2 + localObject1[32] * 4 + localObject1[38] * 8 + localObject1[47] * 16 + localObject1[57] * 32);
    localObject2[3] = (localObject1[33] * 1 + localObject1[34] * 2 + localObject1[35] * 4 + localObject1[39] * 8 + localObject1[48] * 16 + localObject1[58] * 32);
    i1 = 0;
    while (i1 < 4)
    {
      i4 = arrayOfInt[0];
      i5 = arrayOfInt[1];
      i6 = arrayOfInt[2];
      i7 = arrayOfInt[3];
      i10 = o[localObject2[i1]];
      i11 = n[localObject2[i1]];
      arrayOfInt[3] = arrayOfInt[2];
      arrayOfInt[2] = arrayOfInt[1];
      arrayOfInt[1] = arrayOfInt[0];
      arrayOfInt[0] = i10;
      a(i8, i9 + 1, (385963008 + i4 * 5571 + i5 * 4751 + i6 * 2785 + i7 * 1556 >> 15) * i11 >> 24);
      i1 += 1;
    }
    this.h = 12;
    localObject2 = new int[4][];
    i1 = 0;
    label1178:
    int i56;
    int i57;
    int i58;
    int i59;
    int i60;
    int i61;
    int i62;
    int i63;
    int i64;
    int i65;
    int i66;
    int i67;
    int i68;
    int i69;
    int i70;
    int i71;
    int i72;
    int i73;
    int i74;
    int i75;
    if (i1 >= 4)
    {
      i10 = localObject1[45];
      i11 = localObject1[43];
      i12 = localObject1[41];
      int i13 = localObject1[39];
      int i14 = localObject1[37];
      int i15 = localObject1[35];
      int i16 = localObject1[33];
      int i17 = localObject1[31];
      int i18 = localObject1[29];
      int i19 = localObject1['ò'];
      int i20 = localObject1[79];
      int i21 = localObject1[77];
      int i22 = localObject1[75];
      int i23 = localObject1[73];
      int i24 = localObject1[71];
      int i25 = localObject1[46];
      int i26 = localObject1[44];
      int i27 = localObject1[42];
      int i28 = localObject1[40];
      int i29 = localObject1[38];
      int i30 = localObject1[36];
      int i31 = localObject1[34];
      int i32 = localObject1[32];
      int i33 = localObject1[30];
      int i34 = localObject1['ó'];
      int i35 = localObject1[80];
      int i36 = localObject1[78];
      int i37 = localObject1[76];
      int i38 = localObject1[74];
      int i39 = localObject1[72];
      int i40 = localObject1[88];
      int i41 = localObject1[55];
      int i42 = localObject1[51];
      int i43 = localObject1[47];
      int i44 = localObject1[89];
      int i45 = localObject1[56];
      int i46 = localObject1[52];
      int i47 = localObject1[48];
      int i48 = localObject1[90];
      int i49 = localObject1[57];
      int i50 = localObject1[53];
      int i51 = localObject1[49];
      int i52 = localObject1[91];
      int i53 = localObject1[58];
      int i54 = localObject1[54];
      int i55 = localObject1[50];
      i56 = localObject1[104];
      i57 = localObject1[92];
      i58 = localObject1[67];
      i59 = localObject1[63];
      i60 = localObject1[59];
      i61 = localObject1[105];
      i62 = localObject1[93];
      i63 = localObject1[68];
      i64 = localObject1[64];
      i65 = localObject1[60];
      i66 = localObject1[106];
      i67 = localObject1[94];
      i68 = localObject1[69];
      i69 = localObject1[65];
      i70 = localObject1[61];
      i71 = localObject1[107];
      i72 = localObject1[95];
      i73 = localObject1[70];
      i74 = localObject1[66];
      i75 = localObject1[62];
      localObject2[0][0] = (localObject1[122] * 1 + localObject1[123] * 2 + localObject1[124] * 4 + localObject1[96] * 8);
      localObject2[0][1] = (localObject1[125] * 1 + localObject1[126] * 2 + localObject1[127] * 4 + localObject1[100] * 8);
      localObject2[0][2] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[108] * 8);
      localObject2[0][3] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[112] * 8);
      localObject2[0][4] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[116] * 8);
      localObject2[0][5] = (localObject1['¶'] * 1 + localObject1['·'] * 2 + localObject1['¸'] * 4);
      localObject2[0][6] = (localObject1['¹'] * 1 + localObject1['º'] * 2 + localObject1['»'] * 4);
      localObject2[0][7] = (localObject1['¼'] * 1 + localObject1['½'] * 2 + localObject1['¾'] * 4);
      localObject2[0][8] = (localObject1['¿'] * 1 + localObject1['À'] * 2 + localObject1['Á'] * 4);
      localObject2[0][9] = (localObject1['Â'] * 1 + localObject1['Ã'] * 2 + localObject1['Ä'] * 4);
      localObject2[1][0] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[97] * 8);
      localObject2[1][1] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[101] * 8);
      localObject2[1][2] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[109] * 8);
      localObject2[1][3] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[113] * 8);
      localObject2[1][4] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[117] * 8);
      localObject2[1][5] = (localObject1['Å'] * 1 + localObject1['Æ'] * 2 + localObject1['Ç'] * 4);
      localObject2[1][6] = (localObject1['È'] * 1 + localObject1['É'] * 2 + localObject1['Ê'] * 4);
      localObject2[1][7] = (localObject1['Ë'] * 1 + localObject1['Ì'] * 2 + localObject1['Í'] * 4);
      localObject2[1][8] = (localObject1['Î'] * 1 + localObject1['Ï'] * 2 + localObject1['Ð'] * 4);
      localObject2[1][9] = (localObject1['Ñ'] * 1 + localObject1['Ò'] * 2 + localObject1['Ó'] * 4);
      localObject2[2][0] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[98] * 8);
      localObject2[2][1] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[''] * 4 + localObject1[102] * 8);
      localObject2[2][2] = (localObject1[''] * 1 + localObject1[''] * 2 + localObject1[' '] * 4 + localObject1[110] * 8);
      localObject2[2][3] = (localObject1['¡'] * 1 + localObject1['¢'] * 2 + localObject1['£'] * 4 + localObject1[114] * 8);
      localObject2[2][4] = (localObject1['¤'] * 1 + localObject1['¥'] * 2 + localObject1['¦'] * 4 + localObject1[118] * 8);
      localObject2[2][5] = (localObject1['Ô'] * 1 + localObject1['Õ'] * 2 + localObject1['Ö'] * 4);
      localObject2[2][6] = (localObject1['×'] * 1 + localObject1['Ø'] * 2 + localObject1['Ù'] * 4);
      localObject2[2][7] = (localObject1['Ú'] * 1 + localObject1['Û'] * 2 + localObject1['Ü'] * 4);
      localObject2[2][8] = (localObject1['Ý'] * 1 + localObject1['Þ'] * 2 + localObject1['ß'] * 4);
      localObject2[2][9] = (localObject1['à'] * 1 + localObject1['á'] * 2 + localObject1['â'] * 4);
      localObject2[3][0] = (localObject1['§'] * 1 + localObject1['¨'] * 2 + localObject1['©'] * 4 + localObject1[99] * 8);
      localObject2[3][1] = (localObject1['ª'] * 1 + localObject1['«'] * 2 + localObject1['¬'] * 4 + localObject1[103] * 8);
      localObject2[3][2] = (localObject1['­'] * 1 + localObject1['®'] * 2 + localObject1['¯'] * 4 + localObject1[111] * 8);
      localObject2[3][3] = (localObject1['°'] * 1 + localObject1['±'] * 2 + localObject1['²'] * 4 + localObject1[115] * 8);
      localObject2[3][4] = (localObject1['³'] * 1 + localObject1['´'] * 2 + localObject1['µ'] * 4 + localObject1[119] * 8);
      localObject2[3][5] = (localObject1['ã'] * 1 + localObject1['ä'] * 2 + localObject1['å'] * 4);
      localObject2[3][6] = (localObject1['æ'] * 1 + localObject1['ç'] * 2 + localObject1['è'] * 4);
      localObject2[3][7] = (localObject1['é'] * 1 + localObject1['ê'] * 2 + localObject1['ë'] * 4);
      localObject2[3][8] = (localObject1['ì'] * 1 + localObject1['í'] * 2 + localObject1['î'] * 4);
      localObject2[3][9] = (localObject1['ï'] * 1 + localObject1['ð'] * 2 + localObject1['ñ'] * 4);
      i5 = 0;
      i4 = 0;
      label3124:
      if (i4 < 4)
      {
        localObject1 = new int[40];
        i1 = 0;
        label3139:
        if (i1 < 40) {
          break label3926;
        }
        i6 = 0;
        if (i6 < 5) {
          break label3941;
        }
        i6 = new int[] { i10 * 1 + i11 * 2 + i12 * 4 + i13 * 8 + i14 * 16 + i15 * 32 + i16 * 64 + i17 * 128 + i18 * 256, i19 * 1 + i20 * 2 + i21 * 4 + i22 * 8 + i23 * 16 + i24 * 32, i25 * 1 + i26 * 2 + i27 * 4 + i28 * 8 + i29 * 16 + i30 * 32 + i31 * 64 + i32 * 128 + i33 * 256, i34 * 1 + i35 * 2 + i36 * 4 + i37 * 8 + i38 * 16 + i39 * 32 }[i4];
        if ((i4 != 0) && (i4 != 2)) {
          break label4071;
        }
        if (i6 >= 463) {
          break label4060;
        }
        i1 = (i6 + 5) / 6 + 17;
        label3374:
        i5 = s[new int[] { i40 * 1 + i41 * 2 + i42 * 4 + i43 * 8, i44 * 1 + i45 * 2 + i46 * 4 + i47 * 8, i48 * 1 + i49 * 2 + i50 * 4 + i51 * 8, i52 * 1 + i53 * 2 + i54 * 4 + i55 * 8 }[i4]] >> 2 << 2;
        if (i5 <= 16383) {
          break label4129;
        }
        i5 = 32767;
        label3495:
        i6 = i1;
        label3499:
        if (i6 < 40) {
          break label4138;
        }
        i6 = 0;
        i5 = 0;
        label3512:
        if (i5 < 40) {
          break label4172;
        }
        if ((1073741823 > i6) && (i6 >= 0)) {
          break label4197;
        }
        i5 = Integer.MAX_VALUE;
        label3535:
        d1 = Math.log((i5 + 32768 >> 16) * 52428) / Math.log(2.0D);
        i5 = (int)d1;
        i6 = (int)((d1 - i5) * 32768.0D);
        i5 = ((arrayOfInt[0] * 44 + arrayOfInt[1] * 37 + arrayOfInt[2] * 22 + arrayOfInt[3] * 12) * 2 + 783741 - ((i5 - 30 << 16) + (i6 << 1))) / 2;
        i6 = i5 >> 16;
        i5 = (int)(Math.pow(2.0D, i6 + ((i5 >> 1) - (i6 << 15)) / 32768.0D) + 0.5D);
        if (i5 > 2047) {
          break label4206;
        }
        i5 <<= 4;
      }
    }
    for (;;)
    {
      i7 = new int[] { i56 * 1 + i57 * 2 + i58 * 4 + i59 * 8 + i60 * 16, i61 * 1 + i62 * 2 + i63 * 4 + i64 * 8 + i65 * 16, i66 * 1 + i67 * 2 + i68 * 4 + i69 * 8 + i70 * 16, i71 * 1 + i72 * 2 + i73 * 4 + i74 * 8 + i75 * 16 }[i4];
      i6 = i5 * p[(i7 * 3)] >> 15 << 1;
      i5 = i6;
      if ((i6 & 0x8000) != 0) {
        i5 = 32767;
      }
      a(i8, i9 + 1, i5);
      i5 = p[(i7 * 3 + 1)];
      arrayOfInt[3] = arrayOfInt[2];
      arrayOfInt[2] = arrayOfInt[1];
      arrayOfInt[1] = arrayOfInt[0];
      arrayOfInt[0] = i5;
      i4 += 1;
      i5 = i1;
      break label3124;
      break;
      localObject2[i1] = new int[10];
      i1 += 1;
      break label1178;
      label3926:
      localObject1[i1] = 0;
      i1 += 1;
      break label3139;
      label3941:
      if ((localObject2[i4][i6] >> 3 & 0x1) == 0) {}
      for (i1 = 4096;; i1 = 61440)
      {
        int i77 = r[(localObject2[i4][i6] & 0x7)] * 5 + i6;
        int i76 = r[(localObject2[i4][(i6 + 5)] & 0x7)] * 5 + i6;
        localObject1[i77] = i1;
        i7 = i1;
        if (i76 < i77) {
          i7 = -i1;
        }
        localObject1[i76] = (i7 + localObject1[i76]);
        i6 += 1;
        break;
      }
      label4060:
      i1 = i6 - 368;
      break label3374;
      label4071:
      i5 -= 5;
      i1 = i5;
      if (i5 < 18) {
        i1 = 18;
      }
      i5 = i1;
      if (i1 + 9 > 143) {
        i5 = 134;
      }
      i1 = i5 + (i6 + 5) / 6 - 1;
      break label3374;
      label4129:
      i5 <<= 1;
      break label3495;
      label4138:
      localObject1[i6] += (localObject1[(i6 - i1)] * i5 >> 15);
      i6 += 1;
      break label3499;
      label4172:
      i6 += localObject1[i5] * localObject1[i5];
      i5 += 1;
      break label3512;
      label4197:
      i5 = i6 << 1;
      break label3535;
      label4206:
      i5 = 32767;
    }
  }
  
  public final void a(File paramFile)
  {
    super.a(paramFile);
    this.c = 0;
    this.j = 64;
    this.d = new int[this.j];
    this.e = new int[this.j];
    this.f = new int[this.j];
    this.k = 1000000000;
    this.l = 0;
    this.h = 10;
    this.i = 0;
    this.g = ((int)this.b.length());
    if (this.g < 128) {
      throw new IOException("File too small to parse");
    }
    paramFile = new FileInputStream(this.b);
    byte[] arrayOfByte = new byte[12];
    paramFile.read(arrayOfByte, 0, 6);
    this.i += 6;
    if ((arrayOfByte[0] == 35) && (arrayOfByte[1] == 33) && (arrayOfByte[2] == 65) && (arrayOfByte[3] == 77) && (arrayOfByte[4] == 82) && (arrayOfByte[5] == 10)) {
      b(paramFile, this.g - 6);
    }
    paramFile.read(arrayOfByte, 6, 6);
    this.i += 6;
    if ((arrayOfByte[4] == 102) && (arrayOfByte[5] == 116) && (arrayOfByte[6] == 121) && (arrayOfByte[7] == 112) && (arrayOfByte[8] == 51) && (arrayOfByte[9] == 103) && (arrayOfByte[10] == 112) && (arrayOfByte[11] == 52))
    {
      int i1 = arrayOfByte[0];
      int i2 = arrayOfByte[1];
      int i3 = arrayOfByte[2];
      i1 = arrayOfByte[3] & 0xFF | (i1 & 0xFF) << 24 | (i2 & 0xFF) << 16 | (i3 & 0xFF) << 8;
      if ((i1 >= 4) && (i1 <= this.g - 8))
      {
        paramFile.skip(i1 - 12);
        this.i += i1 - 12;
      }
      a(paramFile, this.g - i1);
    }
  }
  
  public final void a(File paramFile, int paramInt1, int paramInt2)
  {
    paramFile.createNewFile();
    FileInputStream localFileInputStream = new FileInputStream(this.b);
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(new byte[] { 35, 33, 65, 77, 82, 10 }, 0, 6);
    int i1 = 0;
    int i2 = 0;
    byte[] arrayOfByte;
    if (i1 >= paramInt2)
    {
      arrayOfByte = new byte[i2];
      i2 = 0;
    }
    int i3;
    for (i1 = 0;; i1 = i3)
    {
      if (i2 >= paramInt2)
      {
        localFileInputStream.close();
        paramFile.close();
        return;
        i3 = i2;
        if (this.e[(paramInt1 + i1)] > i2) {
          i3 = this.e[(paramInt1 + i1)];
        }
        i1 += 1;
        i2 = i3;
        break;
      }
      int i5 = this.d[(paramInt1 + i2)] - i1;
      int i4 = this.e[(paramInt1 + i2)];
      i3 = i1;
      if (i5 >= 0)
      {
        i3 = i1;
        if (i5 > 0)
        {
          localFileInputStream.skip(i5);
          i3 = i1 + i5;
        }
        localFileInputStream.read(arrayOfByte, 0, i4);
        paramFile.write(arrayOfByte, 0, i4);
        i3 += i4;
      }
      i2 += 1;
    }
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return 40;
  }
  
  public final int[] d()
  {
    return this.f;
  }
  
  public final int e()
  {
    return this.h;
  }
  
  public final int f()
  {
    return 8000;
  }
  
  public final String g()
  {
    return "AMR";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */