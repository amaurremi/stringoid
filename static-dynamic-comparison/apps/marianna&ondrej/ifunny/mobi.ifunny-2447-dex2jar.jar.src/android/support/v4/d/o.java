package android.support.v4.d;

import java.io.PrintWriter;

public class o {
    private static final Object a = new Object();
    private static char[] b = new char[24];

    private static int a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
        if ((paramInt1 > 99) || ((paramBoolean) && (paramInt3 >= 3))) {
            return paramInt2 + 3;
        }
        if ((paramInt1 > 9) || ((paramBoolean) && (paramInt3 >= 2))) {
            return paramInt2 + 2;
        }
        if ((paramBoolean) || (paramInt1 > 0)) {
            return paramInt2 + 1;
        }
        return 0;
    }

    private static int a(long paramLong, int paramInt) {
        if (b.length < paramInt) {
            b = new char[paramInt];
        }
        char[] arrayOfChar = b;
        if (paramLong == 0L) {
            while (paramInt - 1 < 0) {
                arrayOfChar[0] = ' ';
            }
            arrayOfChar[0] = '0';
            return 1;
        }
        int i;
        int i4;
        int m;
        int k;
        int j;
        int n;
        if (paramLong > 0L) {
            i = 43;
            i4 = (int) (paramLong % 1000L);
            m = (int) Math.floor(paramLong / 1000L);
            k = 0;
            j = m;
            if (m > 86400) {
                k = m / 86400;
                j = m - 86400 * k;
            }
            if (j <= 3600) {
                break label574;
            }
            m = j / 3600;
            n = m;
            j -= m * 3600;
        }
        for (; ; ) {
            int i1;
            if (j > 60) {
                m = j / 60;
                i1 = m;
            }
            for (m = j - m * 60; ; m = j) {
                boolean bool;
                if (paramInt != 0) {
                    j = a(k, 1, false, 0);
                    if (j > 0) {
                        bool = true;
                        label189:
                        j += a(n, 1, bool, 2);
                        if (j <= 0) {
                            break label325;
                        }
                        bool = true;
                        label211:
                        j += a(i1, 1, bool, 2);
                        if (j <= 0) {
                            break label331;
                        }
                        bool = true;
                        label233:
                        i2 = j + a(m, 1, bool, 2);
                        if (i2 <= 0) {
                            break label337;
                        }
                    }
                    label325:
                    label331:
                    label337:
                    for (j = 3; ; j = 0) {
                        i3 = a(i4, 2, true, j);
                        j = 0;
                        i2 = i3 + 1 + i2;
                        for (; ; ) {
                            i3 = j;
                            if (i2 >= paramInt) {
                                break;
                            }
                            arrayOfChar[j] = ' ';
                            i2 += 1;
                            j += 1;
                        }
                        paramLong = -paramLong;
                        i = 45;
                        break;
                        bool = false;
                        break label189;
                        bool = false;
                        break label211;
                        bool = false;
                        break label233;
                    }
                }
                int i3 = 0;
                arrayOfChar[i3] = i;
                int i2 = i3 + 1;
                if (paramInt != 0) {
                    paramInt = 1;
                    k = a(arrayOfChar, k, 'd', i2, false, 0);
                    if (k == i2) {
                        break label523;
                    }
                    bool = true;
                    label389:
                    if (paramInt == 0) {
                        break label529;
                    }
                    j = 2;
                    label396:
                    k = a(arrayOfChar, n, 'h', k, bool, j);
                    if (k == i2) {
                        break label535;
                    }
                    bool = true;
                    label423:
                    if (paramInt == 0) {
                        break label541;
                    }
                    j = 2;
                    label430:
                    k = a(arrayOfChar, i1, 'm', k, bool, j);
                    if (k == i2) {
                        break label547;
                    }
                    bool = true;
                    label457:
                    if (paramInt == 0) {
                        break label553;
                    }
                    j = 2;
                    label464:
                    j = a(arrayOfChar, m, 's', k, bool, j);
                    if ((paramInt == 0) || (j == i2)) {
                        break label559;
                    }
                }
                label523:
                label529:
                label535:
                label541:
                label547:
                label553:
                label559:
                for (paramInt = 3; ; paramInt = 0) {
                    paramInt = a(arrayOfChar, i4, 'm', j, true, paramInt);
                    arrayOfChar[paramInt] = 's';
                    return paramInt + 1;
                    paramInt = 0;
                    break;
                    bool = false;
                    break label389;
                    j = 0;
                    break label396;
                    bool = false;
                    break label423;
                    j = 0;
                    break label430;
                    bool = false;
                    break label457;
                    j = 0;
                    break label464;
                }
                i1 = 0;
            }
            label574:
            n = 0;
        }
    }

    private static int a(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3) {
        int i;
        int j;
        if (!paramBoolean) {
            i = paramInt2;
            if (paramInt1 <= 0) {
            }
        } else {
            if (((!paramBoolean) || (paramInt3 < 3)) && (paramInt1 <= 99)) {
                break label142;
            }
            j = paramInt1 / 100;
            paramArrayOfChar[paramInt2] = ((char) (j + 48));
            i = paramInt2 + 1;
            paramInt1 -= j * 100;
        }
        for (; ; ) {
            if (((!paramBoolean) || (paramInt3 < 2)) && (paramInt1 <= 9)) {
                j = i;
                paramInt3 = paramInt1;
                if (paramInt2 == i) {
                }
            } else {
                paramInt2 = paramInt1 / 10;
                paramArrayOfChar[i] = ((char) (paramInt2 + 48));
                j = i + 1;
                paramInt3 = paramInt1 - paramInt2 * 10;
            }
            paramArrayOfChar[j] = ((char) (paramInt3 + 48));
            paramInt1 = j + 1;
            paramArrayOfChar[paramInt1] = paramChar;
            i = paramInt1 + 1;
            return i;
            label142:
            i = paramInt2;
        }
    }

    public static void a(long paramLong1, long paramLong2, PrintWriter paramPrintWriter) {
        if (paramLong1 == 0L) {
            paramPrintWriter.print("--");
            return;
        }
        a(paramLong1 - paramLong2, paramPrintWriter, 0);
    }

    public static void a(long paramLong, PrintWriter paramPrintWriter) {
        a(paramLong, paramPrintWriter, 0);
    }

    public static void a(long paramLong, PrintWriter paramPrintWriter, int paramInt) {
        synchronized (a) {
            paramInt = a(paramLong, paramInt);
            paramPrintWriter.print(new String(b, 0, paramInt));
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */