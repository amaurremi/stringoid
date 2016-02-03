package com.flurry.sdk;

public final class ii {
    static final String a = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String b = String.valueOf(Long.MAX_VALUE);

    public static double a(String paramString, double paramDouble) {
        if (paramString == null) {
        }
        do {
            return paramDouble;
            paramString = paramString.trim();
        } while (paramString.length() == 0);
        try {
            double d = c(paramString);
            return d;
        } catch (NumberFormatException paramString) {
        }
        return paramDouble;
    }

    public static final int a(String paramString) {
        int k = 1;
        int i = paramString.charAt(0);
        int n = paramString.length();
        int j;
        if (i == 45) {
            j = 1;
        }
        while (j != 0) {
            if ((n == 1) || (n > 10)) {
                k = Integer.parseInt(paramString);
                return k;
                j = 0;
            } else {
                i = paramString.charAt(1);
                k = 2;
            }
        }
        while ((i > 57) || (i < 48)) {
            return Integer.parseInt(paramString);
            if (n > 9) {
                return Integer.parseInt(paramString);
            }
        }
        int m = i - 48;
        i = m;
        if (k < n) {
            int i1 = k + 1;
            i = paramString.charAt(k);
            if ((i > 57) || (i < 48)) {
                return Integer.parseInt(paramString);
            }
            k = m * 10 + (i - 48);
            i = k;
            if (i1 < n) {
                m = i1 + 1;
                i = paramString.charAt(i1);
                if ((i > 57) || (i < 48)) {
                    return Integer.parseInt(paramString);
                }
                k = k * 10 + (i - 48);
                i = k;
                if (m < n) {
                    i = k;
                }
            }
        }
        for (; ; ) {
            k = m + 1;
            m = paramString.charAt(m);
            if ((m > 57) || (m < 48)) {
                return Integer.parseInt(paramString);
            }
            i = i * 10 + (m - 48);
            if (k >= n) {
                k = i;
                if (j == 0) {
                    break;
                }
                return -i;
            }
            m = k;
        }
    }

    public static final int a(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
        int i = paramArrayOfChar[paramInt1] - '0';
        int j = paramInt2 + paramInt1;
        int k = paramInt1 + 1;
        paramInt1 = i;
        if (k < j) {
            paramInt2 = i * 10 + (paramArrayOfChar[k] - '0');
            i = k + 1;
            paramInt1 = paramInt2;
            if (i < j) {
                paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                i += 1;
                paramInt1 = paramInt2;
                if (i < j) {
                    paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                    i += 1;
                    paramInt1 = paramInt2;
                    if (i < j) {
                        paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                        i += 1;
                        paramInt1 = paramInt2;
                        if (i < j) {
                            paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                            i += 1;
                            paramInt1 = paramInt2;
                            if (i < j) {
                                paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                                i += 1;
                                paramInt1 = paramInt2;
                                if (i < j) {
                                    paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                                    i += 1;
                                    paramInt1 = paramInt2;
                                    if (i < j) {
                                        paramInt1 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return paramInt1;
    }

    public static final boolean a(String paramString, boolean paramBoolean) {
        String str;
        int j;
        int i;
        if (paramBoolean) {
            str = a;
            j = str.length();
            i = paramString.length();
            if (i >= j) {
                break label35;
            }
        }
        for (; ; ) {
            return true;
            str = b;
            break;
            label35:
            if (i > j) {
                return false;
            }
            i = 0;
            while (i < j) {
                int k = paramString.charAt(i) - str.charAt(i);
                if (k != 0) {
                    if (k < 0) {
                    }
                    for (paramBoolean = true; ; paramBoolean = false) {
                        return paramBoolean;
                    }
                }
                i += 1;
            }
        }
    }

    public static final boolean a(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean) {
        String str;
        int i;
        if (paramBoolean) {
            str = a;
            i = str.length();
            if (paramInt2 >= i) {
                break label32;
            }
        }
        for (; ; ) {
            return true;
            str = b;
            break;
            label32:
            if (paramInt2 > i) {
                return false;
            }
            paramInt2 = 0;
            while (paramInt2 < i) {
                int j = paramArrayOfChar[(paramInt1 + paramInt2)] - str.charAt(paramInt2);
                if (j != 0) {
                    if (j < 0) {
                    }
                    for (paramBoolean = true; ; paramBoolean = false) {
                        return paramBoolean;
                    }
                }
                paramInt2 += 1;
            }
        }
    }

    public static final long b(String paramString) {
        if (paramString.length() <= 9) {
            return a(paramString);
        }
        return Long.parseLong(paramString);
    }

    public static final long b(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
        paramInt2 -= 9;
        return a(paramArrayOfChar, paramInt1, paramInt2) * 1000000000L + a(paramArrayOfChar, paramInt2 + paramInt1, 9);
    }

    public static final double c(String paramString)
            throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(paramString)) {
            return 2.2250738585072014E-308D;
        }
        return Double.parseDouble(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */