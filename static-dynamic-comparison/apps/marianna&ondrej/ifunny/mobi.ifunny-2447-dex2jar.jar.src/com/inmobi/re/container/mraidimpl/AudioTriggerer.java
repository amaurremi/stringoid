package com.inmobi.re.container.mraidimpl;

import android.media.AudioRecord;
import com.inmobi.commons.internal.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

public class AudioTriggerer {
    static boolean a;
    public static AudioRecord audioRecorder = null;
    static boolean b;
    static Timer c;
    public static List<AudioTriggerCallback> callbacks = new ArrayList();
    static long d = 0L;
    static long e = 50L;
    private static int[] f = {8000, 11025, 22050, 44100};

    private static void a(double paramDouble) {
        Iterator localIterator = callbacks.iterator();
        while (localIterator.hasNext()) {
            AudioTriggerCallback localAudioTriggerCallback = (AudioTriggerCallback) localIterator.next();
            try {
                localAudioTriggerCallback.audioLevel(paramDouble);
            } catch (Exception localException) {
                Log.internal("[InMobi]-[RE]-4.5.1", "AudioTriggerer: One of the mic listeners has a problem.");
            }
        }
    }

    public static void addEventListener(AudioTriggerCallback paramAudioTriggerCallback) {
        callbacks.add(paramAudioTriggerCallback);
        if (callbacks.size() == 1) {
            b();
        }
    }

    private static void b() {
        a = true;
        audioRecorder = h();
        c = new Timer();
        c.scheduleAtFixedRate(new AudioTriggerer.a(), d, e);
    }

    private static void c() {
        a = false;
        if (audioRecorder != null) {
            if (f()) {
                g();
            }
        }
        try {
            audioRecorder.stop();
            audioRecorder.release();
            c.cancel();
            c.purge();
            return;
        } catch (IllegalStateException localIllegalStateException) {
            localIllegalStateException.printStackTrace();
            return;
        } catch (RuntimeException localRuntimeException) {
            localRuntimeException.printStackTrace();
        }
    }

    private static void d() {
        if (audioRecorder == null) {
        }
        while (audioRecorder.getState() != 1) {
            return;
        }
        short[] arrayOfShort = new short['Ȁ'];
        float[] arrayOfFloat = new float[3];
        b = true;
        try {
            audioRecorder.startRecording();
            while (f()) {
                int j = audioRecorder.read(arrayOfShort, 0, arrayOfShort.length);
                int i = 0;
                float f2;
                for (float f1 = 0.0F; i < j; f1 = f2) {
                    int k = (short) (arrayOfShort[i] | arrayOfShort[(i + 1)]);
                    f2 = f1;
                    if (k != 0) {
                        f2 = f1 + Math.abs(k) / j;
                    }
                    i += 2;
                }
                arrayOfFloat[0] = f1;
                i = 0;
                f1 = 0.0F;
                while (i < 3) {
                    f1 += arrayOfFloat[i];
                    i += 1;
                }
                a(f1 / j / 32.0F);
            }
            e();
            return;
        } catch (Exception localException) {
        }
    }

    private static void e() {
        if (audioRecorder != null) {
            if (f()) {
                g();
            }
        }
        try {
            audioRecorder.stop();
            audioRecorder.release();
            return;
        } catch (IllegalStateException localIllegalStateException) {
            localIllegalStateException.printStackTrace();
            return;
        } catch (RuntimeException localRuntimeException) {
            localRuntimeException.printStackTrace();
        }
    }

    private static boolean f() {
        return b;
    }

    private static void g() {
        b = false;
    }

    private static AudioRecord h() {
        int[] arrayOfInt = f;
        int m = arrayOfInt.length;
        int i = 0;
        while (i < m) {
            int n = arrayOfInt[i];
            short[] arrayOfShort1 = new short[2];
            short[] tmp29_27 = arrayOfShort1;
            tmp29_27[0] = 3;
            short[] tmp34_29 = tmp29_27;
            tmp34_29[1] = 2;
            tmp34_29;
            int i1 = arrayOfShort1.length;
            int j = 0;
            while (j < i1) {
                int i2 = arrayOfShort1[j];
                short[] arrayOfShort2 = new short[2];
                short[] tmp66_64 = arrayOfShort2;
                tmp66_64[0] = 16;
                short[] tmp71_66 = tmp66_64;
                tmp71_66[1] = 12;
                tmp71_66;
                int i3 = arrayOfShort2.length;
                int k = 0;
                while (k < i3) {
                    int i4 = arrayOfShort2[k];
                    try {
                        int i5 = AudioRecord.getMinBufferSize(n, i4, i2);
                        if (i5 != -2) {
                            AudioRecord localAudioRecord = new AudioRecord(0, n, i4, i2, i5);
                            i4 = localAudioRecord.getState();
                            if (i4 == 1) {
                                return localAudioRecord;
                            }
                        }
                    } catch (Exception localException) {
                        k += 1;
                    }
                }
                j += 1;
            }
            i += 1;
        }
        return null;
    }

    public static void removeEventListener(AudioTriggerCallback paramAudioTriggerCallback) {
        callbacks.remove(paramAudioTriggerCallback);
        if (callbacks.size() == 0) {
            c();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/AudioTriggerer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */