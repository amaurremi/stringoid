package com.amazonaws.javax.xml.stream.xerces.util;

import java.util.Arrays;

public class XMLChar
{
  private static final byte[] CHARS = new byte[65536];
  
  static
  {
    CHARS[9] = 35;
    CHARS[10] = 19;
    CHARS[13] = 19;
    CHARS[32] = 51;
    CHARS[33] = 49;
    CHARS[34] = 33;
    Arrays.fill(CHARS, 35, 38, (byte)49);
    CHARS[38] = 1;
    Arrays.fill(CHARS, 39, 45, (byte)49);
    Arrays.fill(CHARS, 45, 47, (byte)-71);
    CHARS[47] = 49;
    Arrays.fill(CHARS, 48, 58, (byte)-71);
    CHARS[58] = 61;
    CHARS[59] = 49;
    CHARS[60] = 1;
    CHARS[61] = 49;
    CHARS[62] = 33;
    Arrays.fill(CHARS, 63, 65, (byte)49);
    Arrays.fill(CHARS, 65, 91, (byte)-3);
    Arrays.fill(CHARS, 91, 93, (byte)33);
    CHARS[93] = 1;
    CHARS[94] = 33;
    CHARS[95] = -3;
    CHARS[96] = 33;
    Arrays.fill(CHARS, 97, 123, (byte)-3);
    Arrays.fill(CHARS, 123, 183, (byte)33);
    CHARS['·'] = -87;
    Arrays.fill(CHARS, 184, 192, (byte)33);
    Arrays.fill(CHARS, 192, 215, (byte)-19);
    CHARS['×'] = 33;
    Arrays.fill(CHARS, 216, 247, (byte)-19);
    CHARS['÷'] = 33;
    Arrays.fill(CHARS, 248, 306, (byte)-19);
    Arrays.fill(CHARS, 306, 308, (byte)33);
    Arrays.fill(CHARS, 308, 319, (byte)-19);
    Arrays.fill(CHARS, 319, 321, (byte)33);
    Arrays.fill(CHARS, 321, 329, (byte)-19);
    CHARS['ŉ'] = 33;
    Arrays.fill(CHARS, 330, 383, (byte)-19);
    CHARS['ſ'] = 33;
    Arrays.fill(CHARS, 384, 452, (byte)-19);
    Arrays.fill(CHARS, 452, 461, (byte)33);
    Arrays.fill(CHARS, 461, 497, (byte)-19);
    Arrays.fill(CHARS, 497, 500, (byte)33);
    Arrays.fill(CHARS, 500, 502, (byte)-19);
    Arrays.fill(CHARS, 502, 506, (byte)33);
    Arrays.fill(CHARS, 506, 536, (byte)-19);
    Arrays.fill(CHARS, 536, 592, (byte)33);
    Arrays.fill(CHARS, 592, 681, (byte)-19);
    Arrays.fill(CHARS, 681, 699, (byte)33);
    Arrays.fill(CHARS, 699, 706, (byte)-19);
    Arrays.fill(CHARS, 706, 720, (byte)33);
    Arrays.fill(CHARS, 720, 722, (byte)-87);
    Arrays.fill(CHARS, 722, 768, (byte)33);
    Arrays.fill(CHARS, 768, 838, (byte)-87);
    Arrays.fill(CHARS, 838, 864, (byte)33);
    Arrays.fill(CHARS, 864, 866, (byte)-87);
    Arrays.fill(CHARS, 866, 902, (byte)33);
    CHARS['Ά'] = -19;
    CHARS['·'] = -87;
    Arrays.fill(CHARS, 904, 907, (byte)-19);
    CHARS['΋'] = 33;
    CHARS['Ό'] = -19;
    CHARS['΍'] = 33;
    Arrays.fill(CHARS, 910, 930, (byte)-19);
    CHARS['΢'] = 33;
    Arrays.fill(CHARS, 931, 975, (byte)-19);
    CHARS['Ϗ'] = 33;
    Arrays.fill(CHARS, 976, 983, (byte)-19);
    Arrays.fill(CHARS, 983, 986, (byte)33);
    CHARS['Ϛ'] = -19;
    CHARS['ϛ'] = 33;
    CHARS['Ϝ'] = -19;
    CHARS['ϝ'] = 33;
    CHARS['Ϟ'] = -19;
    CHARS['ϟ'] = 33;
    CHARS['Ϡ'] = -19;
    CHARS['ϡ'] = 33;
    Arrays.fill(CHARS, 994, 1012, (byte)-19);
    Arrays.fill(CHARS, 1012, 1025, (byte)33);
    Arrays.fill(CHARS, 1025, 1037, (byte)-19);
    CHARS['Ѝ'] = 33;
    Arrays.fill(CHARS, 1038, 1104, (byte)-19);
    CHARS['ѐ'] = 33;
    Arrays.fill(CHARS, 1105, 1117, (byte)-19);
    CHARS['ѝ'] = 33;
    Arrays.fill(CHARS, 1118, 1154, (byte)-19);
    CHARS['҂'] = 33;
    Arrays.fill(CHARS, 1155, 1159, (byte)-87);
    Arrays.fill(CHARS, 1159, 1168, (byte)33);
    Arrays.fill(CHARS, 1168, 1221, (byte)-19);
    Arrays.fill(CHARS, 1221, 1223, (byte)33);
    Arrays.fill(CHARS, 1223, 1225, (byte)-19);
    Arrays.fill(CHARS, 1225, 1227, (byte)33);
    Arrays.fill(CHARS, 1227, 1229, (byte)-19);
    Arrays.fill(CHARS, 1229, 1232, (byte)33);
    Arrays.fill(CHARS, 1232, 1260, (byte)-19);
    Arrays.fill(CHARS, 1260, 1262, (byte)33);
    Arrays.fill(CHARS, 1262, 1270, (byte)-19);
    Arrays.fill(CHARS, 1270, 1272, (byte)33);
    Arrays.fill(CHARS, 1272, 1274, (byte)-19);
    Arrays.fill(CHARS, 1274, 1329, (byte)33);
    Arrays.fill(CHARS, 1329, 1367, (byte)-19);
    Arrays.fill(CHARS, 1367, 1369, (byte)33);
    CHARS['ՙ'] = -19;
    Arrays.fill(CHARS, 1370, 1377, (byte)33);
    Arrays.fill(CHARS, 1377, 1415, (byte)-19);
    Arrays.fill(CHARS, 1415, 1425, (byte)33);
    Arrays.fill(CHARS, 1425, 1442, (byte)-87);
    CHARS['֢'] = 33;
    Arrays.fill(CHARS, 1443, 1466, (byte)-87);
    CHARS['ֺ'] = 33;
    Arrays.fill(CHARS, 1467, 1470, (byte)-87);
    CHARS['־'] = 33;
    CHARS['ֿ'] = -87;
    CHARS['׀'] = 33;
    Arrays.fill(CHARS, 1473, 1475, (byte)-87);
    CHARS['׃'] = 33;
    CHARS['ׄ'] = -87;
    Arrays.fill(CHARS, 1477, 1488, (byte)33);
    Arrays.fill(CHARS, 1488, 1515, (byte)-19);
    Arrays.fill(CHARS, 1515, 1520, (byte)33);
    Arrays.fill(CHARS, 1520, 1523, (byte)-19);
    Arrays.fill(CHARS, 1523, 1569, (byte)33);
    Arrays.fill(CHARS, 1569, 1595, (byte)-19);
    Arrays.fill(CHARS, 1595, 1600, (byte)33);
    CHARS['ـ'] = -87;
    Arrays.fill(CHARS, 1601, 1611, (byte)-19);
    Arrays.fill(CHARS, 1611, 1619, (byte)-87);
    Arrays.fill(CHARS, 1619, 1632, (byte)33);
    Arrays.fill(CHARS, 1632, 1642, (byte)-87);
    Arrays.fill(CHARS, 1642, 1648, (byte)33);
    CHARS['ٰ'] = -87;
    Arrays.fill(CHARS, 1649, 1720, (byte)-19);
    Arrays.fill(CHARS, 1720, 1722, (byte)33);
    Arrays.fill(CHARS, 1722, 1727, (byte)-19);
    CHARS['ڿ'] = 33;
    Arrays.fill(CHARS, 1728, 1743, (byte)-19);
    CHARS['ۏ'] = 33;
    Arrays.fill(CHARS, 1744, 1748, (byte)-19);
    CHARS['۔'] = 33;
    CHARS['ە'] = -19;
    Arrays.fill(CHARS, 1750, 1765, (byte)-87);
    Arrays.fill(CHARS, 1765, 1767, (byte)-19);
    Arrays.fill(CHARS, 1767, 1769, (byte)-87);
    CHARS['۩'] = 33;
    Arrays.fill(CHARS, 1770, 1774, (byte)-87);
    Arrays.fill(CHARS, 1774, 1776, (byte)33);
    Arrays.fill(CHARS, 1776, 1786, (byte)-87);
    Arrays.fill(CHARS, 1786, 2305, (byte)33);
    Arrays.fill(CHARS, 2305, 2308, (byte)-87);
    CHARS['ऄ'] = 33;
    Arrays.fill(CHARS, 2309, 2362, (byte)-19);
    Arrays.fill(CHARS, 2362, 2364, (byte)33);
    CHARS['़'] = -87;
    CHARS['ऽ'] = -19;
    Arrays.fill(CHARS, 2366, 2382, (byte)-87);
    Arrays.fill(CHARS, 2382, 2385, (byte)33);
    Arrays.fill(CHARS, 2385, 2389, (byte)-87);
    Arrays.fill(CHARS, 2389, 2392, (byte)33);
    Arrays.fill(CHARS, 2392, 2402, (byte)-19);
    Arrays.fill(CHARS, 2402, 2404, (byte)-87);
    Arrays.fill(CHARS, 2404, 2406, (byte)33);
    Arrays.fill(CHARS, 2406, 2416, (byte)-87);
    Arrays.fill(CHARS, 2416, 2433, (byte)33);
    Arrays.fill(CHARS, 2433, 2436, (byte)-87);
    CHARS['঄'] = 33;
    Arrays.fill(CHARS, 2437, 2445, (byte)-19);
    Arrays.fill(CHARS, 2445, 2447, (byte)33);
    Arrays.fill(CHARS, 2447, 2449, (byte)-19);
    Arrays.fill(CHARS, 2449, 2451, (byte)33);
    Arrays.fill(CHARS, 2451, 2473, (byte)-19);
    CHARS['঩'] = 33;
    Arrays.fill(CHARS, 2474, 2481, (byte)-19);
    CHARS['঱'] = 33;
    CHARS['ল'] = -19;
    Arrays.fill(CHARS, 2483, 2486, (byte)33);
    Arrays.fill(CHARS, 2486, 2490, (byte)-19);
    Arrays.fill(CHARS, 2490, 2492, (byte)33);
    CHARS['়'] = -87;
    CHARS['ঽ'] = 33;
    Arrays.fill(CHARS, 2494, 2501, (byte)-87);
    Arrays.fill(CHARS, 2501, 2503, (byte)33);
    Arrays.fill(CHARS, 2503, 2505, (byte)-87);
    Arrays.fill(CHARS, 2505, 2507, (byte)33);
    Arrays.fill(CHARS, 2507, 2510, (byte)-87);
    Arrays.fill(CHARS, 2510, 2519, (byte)33);
    CHARS['ৗ'] = -87;
    Arrays.fill(CHARS, 2520, 2524, (byte)33);
    Arrays.fill(CHARS, 2524, 2526, (byte)-19);
    CHARS['৞'] = 33;
    Arrays.fill(CHARS, 2527, 2530, (byte)-19);
    Arrays.fill(CHARS, 2530, 2532, (byte)-87);
    Arrays.fill(CHARS, 2532, 2534, (byte)33);
    Arrays.fill(CHARS, 2534, 2544, (byte)-87);
    Arrays.fill(CHARS, 2544, 2546, (byte)-19);
    Arrays.fill(CHARS, 2546, 2562, (byte)33);
    CHARS['ਂ'] = -87;
    Arrays.fill(CHARS, 2563, 2565, (byte)33);
    Arrays.fill(CHARS, 2565, 2571, (byte)-19);
    Arrays.fill(CHARS, 2571, 2575, (byte)33);
    Arrays.fill(CHARS, 2575, 2577, (byte)-19);
    Arrays.fill(CHARS, 2577, 2579, (byte)33);
    Arrays.fill(CHARS, 2579, 2601, (byte)-19);
    CHARS['਩'] = 33;
    Arrays.fill(CHARS, 2602, 2609, (byte)-19);
    CHARS['਱'] = 33;
    Arrays.fill(CHARS, 2610, 2612, (byte)-19);
    CHARS['਴'] = 33;
    Arrays.fill(CHARS, 2613, 2615, (byte)-19);
    CHARS['਷'] = 33;
    Arrays.fill(CHARS, 2616, 2618, (byte)-19);
    Arrays.fill(CHARS, 2618, 2620, (byte)33);
    CHARS['਼'] = -87;
    CHARS['਽'] = 33;
    Arrays.fill(CHARS, 2622, 2627, (byte)-87);
    Arrays.fill(CHARS, 2627, 2631, (byte)33);
    Arrays.fill(CHARS, 2631, 2633, (byte)-87);
    Arrays.fill(CHARS, 2633, 2635, (byte)33);
    Arrays.fill(CHARS, 2635, 2638, (byte)-87);
    Arrays.fill(CHARS, 2638, 2649, (byte)33);
    Arrays.fill(CHARS, 2649, 2653, (byte)-19);
    CHARS['੝'] = 33;
    CHARS['ਫ਼'] = -19;
    Arrays.fill(CHARS, 2655, 2662, (byte)33);
    Arrays.fill(CHARS, 2662, 2674, (byte)-87);
    Arrays.fill(CHARS, 2674, 2677, (byte)-19);
    Arrays.fill(CHARS, 2677, 2689, (byte)33);
    Arrays.fill(CHARS, 2689, 2692, (byte)-87);
    CHARS['઄'] = 33;
    Arrays.fill(CHARS, 2693, 2700, (byte)-19);
    CHARS['ઌ'] = 33;
    CHARS['ઍ'] = -19;
    CHARS['઎'] = 33;
    Arrays.fill(CHARS, 2703, 2706, (byte)-19);
    CHARS['઒'] = 33;
    Arrays.fill(CHARS, 2707, 2729, (byte)-19);
    CHARS['઩'] = 33;
    Arrays.fill(CHARS, 2730, 2737, (byte)-19);
    CHARS['઱'] = 33;
    Arrays.fill(CHARS, 2738, 2740, (byte)-19);
    CHARS['઴'] = 33;
    Arrays.fill(CHARS, 2741, 2746, (byte)-19);
    Arrays.fill(CHARS, 2746, 2748, (byte)33);
    CHARS['઼'] = -87;
    CHARS['ઽ'] = -19;
    Arrays.fill(CHARS, 2750, 2758, (byte)-87);
    CHARS['૆'] = 33;
    Arrays.fill(CHARS, 2759, 2762, (byte)-87);
    CHARS['૊'] = 33;
    Arrays.fill(CHARS, 2763, 2766, (byte)-87);
    Arrays.fill(CHARS, 2766, 2784, (byte)33);
    CHARS['ૠ'] = -19;
    Arrays.fill(CHARS, 2785, 2790, (byte)33);
    Arrays.fill(CHARS, 2790, 2800, (byte)-87);
    Arrays.fill(CHARS, 2800, 2817, (byte)33);
    Arrays.fill(CHARS, 2817, 2820, (byte)-87);
    CHARS['଄'] = 33;
    Arrays.fill(CHARS, 2821, 2829, (byte)-19);
    Arrays.fill(CHARS, 2829, 2831, (byte)33);
    Arrays.fill(CHARS, 2831, 2833, (byte)-19);
    Arrays.fill(CHARS, 2833, 2835, (byte)33);
    Arrays.fill(CHARS, 2835, 2857, (byte)-19);
    CHARS['଩'] = 33;
    Arrays.fill(CHARS, 2858, 2865, (byte)-19);
    CHARS['଱'] = 33;
    Arrays.fill(CHARS, 2866, 2868, (byte)-19);
    Arrays.fill(CHARS, 2868, 2870, (byte)33);
    Arrays.fill(CHARS, 2870, 2874, (byte)-19);
    Arrays.fill(CHARS, 2874, 2876, (byte)33);
    CHARS['଼'] = -87;
    CHARS['ଽ'] = -19;
    Arrays.fill(CHARS, 2878, 2884, (byte)-87);
    Arrays.fill(CHARS, 2884, 2887, (byte)33);
    Arrays.fill(CHARS, 2887, 2889, (byte)-87);
    Arrays.fill(CHARS, 2889, 2891, (byte)33);
    Arrays.fill(CHARS, 2891, 2894, (byte)-87);
    Arrays.fill(CHARS, 2894, 2902, (byte)33);
    Arrays.fill(CHARS, 2902, 2904, (byte)-87);
    Arrays.fill(CHARS, 2904, 2908, (byte)33);
    Arrays.fill(CHARS, 2908, 2910, (byte)-19);
    CHARS['୞'] = 33;
    Arrays.fill(CHARS, 2911, 2914, (byte)-19);
    Arrays.fill(CHARS, 2914, 2918, (byte)33);
    Arrays.fill(CHARS, 2918, 2928, (byte)-87);
    Arrays.fill(CHARS, 2928, 2946, (byte)33);
    Arrays.fill(CHARS, 2946, 2948, (byte)-87);
    CHARS['஄'] = 33;
    Arrays.fill(CHARS, 2949, 2955, (byte)-19);
    Arrays.fill(CHARS, 2955, 2958, (byte)33);
    Arrays.fill(CHARS, 2958, 2961, (byte)-19);
    CHARS['஑'] = 33;
    Arrays.fill(CHARS, 2962, 2966, (byte)-19);
    Arrays.fill(CHARS, 2966, 2969, (byte)33);
    Arrays.fill(CHARS, 2969, 2971, (byte)-19);
    CHARS['஛'] = 33;
    CHARS['ஜ'] = -19;
    CHARS['஝'] = 33;
    Arrays.fill(CHARS, 2974, 2976, (byte)-19);
    Arrays.fill(CHARS, 2976, 2979, (byte)33);
    Arrays.fill(CHARS, 2979, 2981, (byte)-19);
    Arrays.fill(CHARS, 2981, 2984, (byte)33);
    Arrays.fill(CHARS, 2984, 2987, (byte)-19);
    Arrays.fill(CHARS, 2987, 2990, (byte)33);
    Arrays.fill(CHARS, 2990, 2998, (byte)-19);
    CHARS['ஶ'] = 33;
    Arrays.fill(CHARS, 2999, 3002, (byte)-19);
    Arrays.fill(CHARS, 3002, 3006, (byte)33);
    Arrays.fill(CHARS, 3006, 3011, (byte)-87);
    Arrays.fill(CHARS, 3011, 3014, (byte)33);
    Arrays.fill(CHARS, 3014, 3017, (byte)-87);
    CHARS['௉'] = 33;
    Arrays.fill(CHARS, 3018, 3022, (byte)-87);
    Arrays.fill(CHARS, 3022, 3031, (byte)33);
    CHARS['ௗ'] = -87;
    Arrays.fill(CHARS, 3032, 3047, (byte)33);
    Arrays.fill(CHARS, 3047, 3056, (byte)-87);
    Arrays.fill(CHARS, 3056, 3073, (byte)33);
    Arrays.fill(CHARS, 3073, 3076, (byte)-87);
    CHARS['ఄ'] = 33;
    Arrays.fill(CHARS, 3077, 3085, (byte)-19);
    CHARS['఍'] = 33;
    Arrays.fill(CHARS, 3086, 3089, (byte)-19);
    CHARS['఑'] = 33;
    Arrays.fill(CHARS, 3090, 3113, (byte)-19);
    CHARS['఩'] = 33;
    Arrays.fill(CHARS, 3114, 3124, (byte)-19);
    CHARS['ఴ'] = 33;
    Arrays.fill(CHARS, 3125, 3130, (byte)-19);
    Arrays.fill(CHARS, 3130, 3134, (byte)33);
    Arrays.fill(CHARS, 3134, 3141, (byte)-87);
    CHARS['౅'] = 33;
    Arrays.fill(CHARS, 3142, 3145, (byte)-87);
    CHARS['౉'] = 33;
    Arrays.fill(CHARS, 3146, 3150, (byte)-87);
    Arrays.fill(CHARS, 3150, 3157, (byte)33);
    Arrays.fill(CHARS, 3157, 3159, (byte)-87);
    Arrays.fill(CHARS, 3159, 3168, (byte)33);
    Arrays.fill(CHARS, 3168, 3170, (byte)-19);
    Arrays.fill(CHARS, 3170, 3174, (byte)33);
    Arrays.fill(CHARS, 3174, 3184, (byte)-87);
    Arrays.fill(CHARS, 3184, 3202, (byte)33);
    Arrays.fill(CHARS, 3202, 3204, (byte)-87);
    CHARS['಄'] = 33;
    Arrays.fill(CHARS, 3205, 3213, (byte)-19);
    CHARS['಍'] = 33;
    Arrays.fill(CHARS, 3214, 3217, (byte)-19);
    CHARS['಑'] = 33;
    Arrays.fill(CHARS, 3218, 3241, (byte)-19);
    CHARS['಩'] = 33;
    Arrays.fill(CHARS, 3242, 3252, (byte)-19);
    CHARS['಴'] = 33;
    Arrays.fill(CHARS, 3253, 3258, (byte)-19);
    Arrays.fill(CHARS, 3258, 3262, (byte)33);
    Arrays.fill(CHARS, 3262, 3269, (byte)-87);
    CHARS['೅'] = 33;
    Arrays.fill(CHARS, 3270, 3273, (byte)-87);
    CHARS['೉'] = 33;
    Arrays.fill(CHARS, 3274, 3278, (byte)-87);
    Arrays.fill(CHARS, 3278, 3285, (byte)33);
    Arrays.fill(CHARS, 3285, 3287, (byte)-87);
    Arrays.fill(CHARS, 3287, 3294, (byte)33);
    CHARS['ೞ'] = -19;
    CHARS['೟'] = 33;
    Arrays.fill(CHARS, 3296, 3298, (byte)-19);
    Arrays.fill(CHARS, 3298, 3302, (byte)33);
    Arrays.fill(CHARS, 3302, 3312, (byte)-87);
    Arrays.fill(CHARS, 3312, 3330, (byte)33);
    Arrays.fill(CHARS, 3330, 3332, (byte)-87);
    CHARS['ഄ'] = 33;
    Arrays.fill(CHARS, 3333, 3341, (byte)-19);
    CHARS['഍'] = 33;
    Arrays.fill(CHARS, 3342, 3345, (byte)-19);
    CHARS['഑'] = 33;
    Arrays.fill(CHARS, 3346, 3369, (byte)-19);
    CHARS['ഩ'] = 33;
    Arrays.fill(CHARS, 3370, 3386, (byte)-19);
    Arrays.fill(CHARS, 3386, 3390, (byte)33);
    Arrays.fill(CHARS, 3390, 3396, (byte)-87);
    Arrays.fill(CHARS, 3396, 3398, (byte)33);
    Arrays.fill(CHARS, 3398, 3401, (byte)-87);
    CHARS['൉'] = 33;
    Arrays.fill(CHARS, 3402, 3406, (byte)-87);
    Arrays.fill(CHARS, 3406, 3415, (byte)33);
    CHARS['ൗ'] = -87;
    Arrays.fill(CHARS, 3416, 3424, (byte)33);
    Arrays.fill(CHARS, 3424, 3426, (byte)-19);
    Arrays.fill(CHARS, 3426, 3430, (byte)33);
    Arrays.fill(CHARS, 3430, 3440, (byte)-87);
    Arrays.fill(CHARS, 3440, 3585, (byte)33);
    Arrays.fill(CHARS, 3585, 3631, (byte)-19);
    CHARS['ฯ'] = 33;
    CHARS['ะ'] = -19;
    CHARS['ั'] = -87;
    Arrays.fill(CHARS, 3634, 3636, (byte)-19);
    Arrays.fill(CHARS, 3636, 3643, (byte)-87);
    Arrays.fill(CHARS, 3643, 3648, (byte)33);
    Arrays.fill(CHARS, 3648, 3654, (byte)-19);
    Arrays.fill(CHARS, 3654, 3663, (byte)-87);
    CHARS['๏'] = 33;
    Arrays.fill(CHARS, 3664, 3674, (byte)-87);
    Arrays.fill(CHARS, 3674, 3713, (byte)33);
    Arrays.fill(CHARS, 3713, 3715, (byte)-19);
    CHARS['຃'] = 33;
    CHARS['ຄ'] = -19;
    Arrays.fill(CHARS, 3717, 3719, (byte)33);
    Arrays.fill(CHARS, 3719, 3721, (byte)-19);
    CHARS['ຉ'] = 33;
    CHARS['ຊ'] = -19;
    Arrays.fill(CHARS, 3723, 3725, (byte)33);
    CHARS['ຍ'] = -19;
    Arrays.fill(CHARS, 3726, 3732, (byte)33);
    Arrays.fill(CHARS, 3732, 3736, (byte)-19);
    CHARS['ຘ'] = 33;
    Arrays.fill(CHARS, 3737, 3744, (byte)-19);
    CHARS['ຠ'] = 33;
    Arrays.fill(CHARS, 3745, 3748, (byte)-19);
    CHARS['຤'] = 33;
    CHARS['ລ'] = -19;
    CHARS['຦'] = 33;
    CHARS['ວ'] = -19;
    Arrays.fill(CHARS, 3752, 3754, (byte)33);
    Arrays.fill(CHARS, 3754, 3756, (byte)-19);
    CHARS['ຬ'] = 33;
    Arrays.fill(CHARS, 3757, 3759, (byte)-19);
    CHARS['ຯ'] = 33;
    CHARS['ະ'] = -19;
    CHARS['ັ'] = -87;
    Arrays.fill(CHARS, 3762, 3764, (byte)-19);
    Arrays.fill(CHARS, 3764, 3770, (byte)-87);
    CHARS['຺'] = 33;
    Arrays.fill(CHARS, 3771, 3773, (byte)-87);
    CHARS['ຽ'] = -19;
    Arrays.fill(CHARS, 3774, 3776, (byte)33);
    Arrays.fill(CHARS, 3776, 3781, (byte)-19);
    CHARS['໅'] = 33;
    CHARS['ໆ'] = -87;
    CHARS['໇'] = 33;
    Arrays.fill(CHARS, 3784, 3790, (byte)-87);
    Arrays.fill(CHARS, 3790, 3792, (byte)33);
    Arrays.fill(CHARS, 3792, 3802, (byte)-87);
    Arrays.fill(CHARS, 3802, 3864, (byte)33);
    Arrays.fill(CHARS, 3864, 3866, (byte)-87);
    Arrays.fill(CHARS, 3866, 3872, (byte)33);
    Arrays.fill(CHARS, 3872, 3882, (byte)-87);
    Arrays.fill(CHARS, 3882, 3893, (byte)33);
    CHARS['༵'] = -87;
    CHARS['༶'] = 33;
    CHARS['༷'] = -87;
    CHARS['༸'] = 33;
    CHARS['༹'] = -87;
    Arrays.fill(CHARS, 3898, 3902, (byte)33);
    Arrays.fill(CHARS, 3902, 3904, (byte)-87);
    Arrays.fill(CHARS, 3904, 3912, (byte)-19);
    CHARS['཈'] = 33;
    Arrays.fill(CHARS, 3913, 3946, (byte)-19);
    Arrays.fill(CHARS, 3946, 3953, (byte)33);
    Arrays.fill(CHARS, 3953, 3973, (byte)-87);
    CHARS['྅'] = 33;
    Arrays.fill(CHARS, 3974, 3980, (byte)-87);
    Arrays.fill(CHARS, 3980, 3984, (byte)33);
    Arrays.fill(CHARS, 3984, 3990, (byte)-87);
    CHARS['ྖ'] = 33;
    CHARS['ྗ'] = -87;
    CHARS['྘'] = 33;
    Arrays.fill(CHARS, 3993, 4014, (byte)-87);
    Arrays.fill(CHARS, 4014, 4017, (byte)33);
    Arrays.fill(CHARS, 4017, 4024, (byte)-87);
    CHARS['ྸ'] = 33;
    CHARS['ྐྵ'] = -87;
    Arrays.fill(CHARS, 4026, 4256, (byte)33);
    Arrays.fill(CHARS, 4256, 4294, (byte)-19);
    Arrays.fill(CHARS, 4294, 4304, (byte)33);
    Arrays.fill(CHARS, 4304, 4343, (byte)-19);
    Arrays.fill(CHARS, 4343, 4352, (byte)33);
    CHARS['ᄀ'] = -19;
    CHARS['ᄁ'] = 33;
    Arrays.fill(CHARS, 4354, 4356, (byte)-19);
    CHARS['ᄄ'] = 33;
    Arrays.fill(CHARS, 4357, 4360, (byte)-19);
    CHARS['ᄈ'] = 33;
    CHARS['ᄉ'] = -19;
    CHARS['ᄊ'] = 33;
    Arrays.fill(CHARS, 4363, 4365, (byte)-19);
    CHARS['ᄍ'] = 33;
    Arrays.fill(CHARS, 4366, 4371, (byte)-19);
    Arrays.fill(CHARS, 4371, 4412, (byte)33);
    CHARS['ᄼ'] = -19;
    CHARS['ᄽ'] = 33;
    CHARS['ᄾ'] = -19;
    CHARS['ᄿ'] = 33;
    CHARS['ᅀ'] = -19;
    Arrays.fill(CHARS, 4417, 4428, (byte)33);
    CHARS['ᅌ'] = -19;
    CHARS['ᅍ'] = 33;
    CHARS['ᅎ'] = -19;
    CHARS['ᅏ'] = 33;
    CHARS['ᅐ'] = -19;
    Arrays.fill(CHARS, 4433, 4436, (byte)33);
    Arrays.fill(CHARS, 4436, 4438, (byte)-19);
    Arrays.fill(CHARS, 4438, 4441, (byte)33);
    CHARS['ᅙ'] = -19;
    Arrays.fill(CHARS, 4442, 4447, (byte)33);
    Arrays.fill(CHARS, 4447, 4450, (byte)-19);
    CHARS['ᅢ'] = 33;
    CHARS['ᅣ'] = -19;
    CHARS['ᅤ'] = 33;
    CHARS['ᅥ'] = -19;
    CHARS['ᅦ'] = 33;
    CHARS['ᅧ'] = -19;
    CHARS['ᅨ'] = 33;
    CHARS['ᅩ'] = -19;
    Arrays.fill(CHARS, 4458, 4461, (byte)33);
    Arrays.fill(CHARS, 4461, 4463, (byte)-19);
    Arrays.fill(CHARS, 4463, 4466, (byte)33);
    Arrays.fill(CHARS, 4466, 4468, (byte)-19);
    CHARS['ᅴ'] = 33;
    CHARS['ᅵ'] = -19;
    Arrays.fill(CHARS, 4470, 4510, (byte)33);
    CHARS['ᆞ'] = -19;
    Arrays.fill(CHARS, 4511, 4520, (byte)33);
    CHARS['ᆨ'] = -19;
    Arrays.fill(CHARS, 4521, 4523, (byte)33);
    CHARS['ᆫ'] = -19;
    Arrays.fill(CHARS, 4524, 4526, (byte)33);
    Arrays.fill(CHARS, 4526, 4528, (byte)-19);
    Arrays.fill(CHARS, 4528, 4535, (byte)33);
    Arrays.fill(CHARS, 4535, 4537, (byte)-19);
    CHARS['ᆹ'] = 33;
    CHARS['ᆺ'] = -19;
    CHARS['ᆻ'] = 33;
    Arrays.fill(CHARS, 4540, 4547, (byte)-19);
    Arrays.fill(CHARS, 4547, 4587, (byte)33);
    CHARS['ᇫ'] = -19;
    Arrays.fill(CHARS, 4588, 4592, (byte)33);
    CHARS['ᇰ'] = -19;
    Arrays.fill(CHARS, 4593, 4601, (byte)33);
    CHARS['ᇹ'] = -19;
    Arrays.fill(CHARS, 4602, 7680, (byte)33);
    Arrays.fill(CHARS, 7680, 7836, (byte)-19);
    Arrays.fill(CHARS, 7836, 7840, (byte)33);
    Arrays.fill(CHARS, 7840, 7930, (byte)-19);
    Arrays.fill(CHARS, 7930, 7936, (byte)33);
    Arrays.fill(CHARS, 7936, 7958, (byte)-19);
    Arrays.fill(CHARS, 7958, 7960, (byte)33);
    Arrays.fill(CHARS, 7960, 7966, (byte)-19);
    Arrays.fill(CHARS, 7966, 7968, (byte)33);
    Arrays.fill(CHARS, 7968, 8006, (byte)-19);
    Arrays.fill(CHARS, 8006, 8008, (byte)33);
    Arrays.fill(CHARS, 8008, 8014, (byte)-19);
    Arrays.fill(CHARS, 8014, 8016, (byte)33);
    Arrays.fill(CHARS, 8016, 8024, (byte)-19);
    CHARS['὘'] = 33;
    CHARS['Ὑ'] = -19;
    CHARS['὚'] = 33;
    CHARS['Ὓ'] = -19;
    CHARS['὜'] = 33;
    CHARS['Ὕ'] = -19;
    CHARS['὞'] = 33;
    Arrays.fill(CHARS, 8031, 8062, (byte)-19);
    Arrays.fill(CHARS, 8062, 8064, (byte)33);
    Arrays.fill(CHARS, 8064, 8117, (byte)-19);
    CHARS['᾵'] = 33;
    Arrays.fill(CHARS, 8118, 8125, (byte)-19);
    CHARS['᾽'] = 33;
    CHARS['ι'] = -19;
    Arrays.fill(CHARS, 8127, 8130, (byte)33);
    Arrays.fill(CHARS, 8130, 8133, (byte)-19);
    CHARS['῅'] = 33;
    Arrays.fill(CHARS, 8134, 8141, (byte)-19);
    Arrays.fill(CHARS, 8141, 8144, (byte)33);
    Arrays.fill(CHARS, 8144, 8148, (byte)-19);
    Arrays.fill(CHARS, 8148, 8150, (byte)33);
    Arrays.fill(CHARS, 8150, 8156, (byte)-19);
    Arrays.fill(CHARS, 8156, 8160, (byte)33);
    Arrays.fill(CHARS, 8160, 8173, (byte)-19);
    Arrays.fill(CHARS, 8173, 8178, (byte)33);
    Arrays.fill(CHARS, 8178, 8181, (byte)-19);
    CHARS['῵'] = 33;
    Arrays.fill(CHARS, 8182, 8189, (byte)-19);
    Arrays.fill(CHARS, 8189, 8400, (byte)33);
    Arrays.fill(CHARS, 8400, 8413, (byte)-87);
    Arrays.fill(CHARS, 8413, 8417, (byte)33);
    CHARS['⃡'] = -87;
    Arrays.fill(CHARS, 8418, 8486, (byte)33);
    CHARS['Ω'] = -19;
    Arrays.fill(CHARS, 8487, 8490, (byte)33);
    Arrays.fill(CHARS, 8490, 8492, (byte)-19);
    Arrays.fill(CHARS, 8492, 8494, (byte)33);
    CHARS['℮'] = -19;
    Arrays.fill(CHARS, 8495, 8576, (byte)33);
    Arrays.fill(CHARS, 8576, 8579, (byte)-19);
    Arrays.fill(CHARS, 8579, 12293, (byte)33);
    CHARS['々'] = -87;
    CHARS['〆'] = 33;
    CHARS['〇'] = -19;
    Arrays.fill(CHARS, 12296, 12321, (byte)33);
    Arrays.fill(CHARS, 12321, 12330, (byte)-19);
    Arrays.fill(CHARS, 12330, 12336, (byte)-87);
    CHARS['〰'] = 33;
    Arrays.fill(CHARS, 12337, 12342, (byte)-87);
    Arrays.fill(CHARS, 12342, 12353, (byte)33);
    Arrays.fill(CHARS, 12353, 12437, (byte)-19);
    Arrays.fill(CHARS, 12437, 12441, (byte)33);
    Arrays.fill(CHARS, 12441, 12443, (byte)-87);
    Arrays.fill(CHARS, 12443, 12445, (byte)33);
    Arrays.fill(CHARS, 12445, 12447, (byte)-87);
    Arrays.fill(CHARS, 12447, 12449, (byte)33);
    Arrays.fill(CHARS, 12449, 12539, (byte)-19);
    CHARS['・'] = 33;
    Arrays.fill(CHARS, 12540, 12543, (byte)-87);
    Arrays.fill(CHARS, 12543, 12549, (byte)33);
    Arrays.fill(CHARS, 12549, 12589, (byte)-19);
    Arrays.fill(CHARS, 12589, 19968, (byte)33);
    Arrays.fill(CHARS, 19968, 40870, (byte)-19);
    Arrays.fill(CHARS, 40870, 44032, (byte)33);
    Arrays.fill(CHARS, 44032, 55204, (byte)-19);
    Arrays.fill(CHARS, 55204, 55296, (byte)33);
    Arrays.fill(CHARS, 57344, 65534, (byte)33);
  }
  
  public static char highSurrogate(int paramInt)
  {
    return (char)((paramInt - 65536 >> 10) + 55296);
  }
  
  public static boolean isContent(int paramInt)
  {
    return ((paramInt < 65536) && ((CHARS[paramInt] & 0x20) != 0)) || ((65536 <= paramInt) && (paramInt <= 1114111));
  }
  
  public static boolean isHighSurrogate(int paramInt)
  {
    return (55296 <= paramInt) && (paramInt <= 56319);
  }
  
  public static boolean isInvalid(int paramInt)
  {
    return !isValid(paramInt);
  }
  
  public static boolean isLowSurrogate(int paramInt)
  {
    return (56320 <= paramInt) && (paramInt <= 57343);
  }
  
  public static boolean isMarkup(int paramInt)
  {
    return (paramInt == 60) || (paramInt == 38) || (paramInt == 37);
  }
  
  public static boolean isNCName(int paramInt)
  {
    return (paramInt < 65536) && ((CHARS[paramInt] & 0x80) != 0);
  }
  
  public static boolean isName(int paramInt)
  {
    return (paramInt < 65536) && ((CHARS[paramInt] & 0x8) != 0);
  }
  
  public static boolean isNameStart(int paramInt)
  {
    return (paramInt < 65536) && ((CHARS[paramInt] & 0x4) != 0);
  }
  
  public static boolean isPubid(int paramInt)
  {
    return (paramInt < 65536) && ((CHARS[paramInt] & 0x10) != 0);
  }
  
  public static boolean isSpace(int paramInt)
  {
    return (paramInt <= 32) && ((CHARS[paramInt] & 0x2) != 0);
  }
  
  public static boolean isSupplemental(int paramInt)
  {
    return (paramInt >= 65536) && (paramInt <= 1114111);
  }
  
  public static boolean isValid(int paramInt)
  {
    return ((paramInt < 65536) && ((CHARS[paramInt] & 0x1) != 0)) || ((65536 <= paramInt) && (paramInt <= 1114111));
  }
  
  public static boolean isValidIANAEncoding(String paramString)
  {
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.length();
      if (j > 0)
      {
        i = paramString.charAt(0);
        if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122))) {
          i = 1;
        }
      }
    }
    while (i < j)
    {
      int k = paramString.charAt(i);
      if (((k < 65) || (k > 90)) && ((k < 97) || (k > 122)) && ((k < 48) || (k > 57)) && (k != 46) && (k != 95) && (k != 45)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isValidJavaEncoding(String paramString)
  {
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.length();
      if (j > 0) {
        i = 1;
      }
    }
    while (i < j)
    {
      int k = paramString.charAt(i);
      if (((k < 65) || (k > 90)) && ((k < 97) || (k > 122)) && ((k < 48) || (k > 57)) && (k != 46) && (k != 95) && (k != 45)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static char lowSurrogate(int paramInt)
  {
    return (char)((paramInt - 65536 & 0x3FF) + 56320);
  }
  
  public static int supplemental(char paramChar1, char paramChar2)
  {
    return (paramChar1 - 55296) * 1024 + (paramChar2 - 56320) + 65536;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/XMLChar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */