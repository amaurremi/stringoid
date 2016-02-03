package com.amazon.device.ads;

import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Properties;
import javax.crypto.Cipher;

class cx {
    private static final String a = cx.class.getSimpleName();
    private static final BigInteger b = new BigInteger("22425945969293236512819607281747202268852113345956851069545419503178249900977203670147638322801582881051882957295768557918356441519366172126884608406316888515239296504501830280664879549133570276792155151832332847188532369002492210234019359186842709493620665119919750832332220777141369255943445578381285984064028865613478676828533273460580467686485184132743895959747097454385452868408957601246667523882372216446056029831689133478714597838700864119273209955182548633182248700235085802575904827859971001196599005060045450779595767759943984991630413046800554347791145167910883355627096118148593841261053098773337592734097");
    private static final BigInteger c = new BigInteger("5599215006722084151841970702827860151139465197978118529242591197804380779249736540498127864809226859371835159226553869008622098243456195347852554241917744888762998133926842072150379542281041403163862165638226686887497980590930009552760406707269286898150890998325325890252103828011111664174475487114957696526157790937869377570600085450453371238028811033168218737171144699577236108423054506552958366535341910569552237227686862748056351625445281035713423043506793107235726047151346608576583081807969458368853010104969843563629579750936551771756389538574062221915919980316992216032119182896925094308799622409361028579777");
    private static Properties d = new Properties();
    private static boolean e = false;

    public static int a(String paramString, int paramInt) {
        return a(paramString, Integer.valueOf(paramInt)).intValue();
    }

    public static Boolean a(String paramString, Boolean paramBoolean) {
        if (!e) {
        }
        String str;
        do {
            return paramBoolean;
            str = d.getProperty(paramString);
        } while (str == null);
        try {
            boolean bool = Boolean.parseBoolean(str);
            return Boolean.valueOf(bool);
        } catch (NumberFormatException localNumberFormatException) {
            dv.b(a, "Unable to parse boolean debug property - property: %s, value: %s", new Object[]{paramString, str});
        }
        return paramBoolean;
    }

    public static Integer a(String paramString, Integer paramInteger) {
        if (!e) {
        }
        String str;
        do {
            return paramInteger;
            str = d.getProperty(paramString);
        } while (str == null);
        try {
            int i = Integer.parseInt(str);
            return Integer.valueOf(i);
        } catch (NumberFormatException localNumberFormatException) {
            dv.b(a, "Unable to parse integer debug property - property: %s, value: %s", new Object[]{paramString, str});
        }
        return paramInteger;
    }

    public static Long a(String paramString, Long paramLong) {
        if (!e) {
        }
        String str;
        do {
            return paramLong;
            str = d.getProperty(paramString);
        } while (str == null);
        try {
            long l = Long.parseLong(str);
            return Long.valueOf(l);
        } catch (NumberFormatException localNumberFormatException) {
            dv.b(a, "Unable to parse long debug property - property: %s, value: %s", new Object[]{paramString, str});
        }
        return paramLong;
    }

    public static String a(String paramString1, String paramString2) {
        if (!e) {
            return paramString2;
        }
        return d.getProperty(paramString1, paramString2);
    }

    public static void a() {
        Object localObject1;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            localObject1 = new File(Environment.getExternalStorageDirectory() + "/com.amazon.device.ads.debug");
            if ((((File) localObject1).exists()) && (((File) localObject1).length() <= 2147483647L)) {
                break label59;
            }
        }
        for (; ; ) {
            return;
            label59:
            int i = 0;
            for (; ; ) {
                try {
                    localBufferedInputStream = new BufferedInputStream(new FileInputStream((File) localObject1));
                } finally {
                    BufferedInputStream localBufferedInputStream = null;
                    continue;
                }
                try {
                    localObject1 = new byte[(int) ((File) localObject1).length()];
                    if (i < localObject1.length) {
                        int j = localBufferedInputStream.read((byte[]) localObject1, i, localObject1.length - i);
                        if (j > 0) {
                            i += j;
                        }
                    } else {
                        localObject1 = a((byte[]) localObject1);
                        if (localObject1 != null) {
                            localObject1 = new ByteArrayInputStream((byte[]) localObject1);
                            d.clear();
                            d.load((InputStream) localObject1);
                            if (d.getProperty("debug.mode", "false").equals("true")) {
                                e = true;
                            }
                        }
                        if (localBufferedInputStream == null) {
                            break;
                        }
                    }
                } finally {
                }
            }
        }
        try {
            localBufferedInputStream.close();
            return;
        } catch (Exception localException) {
            return;
        }
        if (localBufferedInputStream != null) {
            localBufferedInputStream.close();
        }
        throw ((Throwable) localObject1);
    }

    public static boolean a(String paramString) {
        if (!e) {
            return false;
        }
        return d.containsKey(paramString);
    }

    public static boolean a(String paramString, boolean paramBoolean) {
        return a(paramString, Boolean.valueOf(paramBoolean)).booleanValue();
    }

    protected static byte[] a(byte[] paramArrayOfByte) {
        try {
            Object localObject = new RSAPrivateKeySpec(b, c);
            localObject = KeyFactory.getInstance("RSA").generatePrivate((KeySpec) localObject);
            Cipher localCipher = Cipher.getInstance("RSA");
            localCipher.init(2, (Key) localObject);
            paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
            return paramArrayOfByte;
        } catch (Exception paramArrayOfByte) {
            dv.b(a, "Exception " + paramArrayOfByte + " trying to decrypt debug file");
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */