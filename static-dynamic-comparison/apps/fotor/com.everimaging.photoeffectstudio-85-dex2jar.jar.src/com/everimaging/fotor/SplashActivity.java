package com.everimaging.fotor;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.everimaging.fotor.camera.CameraActivity;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplashActivity
        extends b {
    public static SplashActivity a;
    private static final String c = SplashActivity.class.getSimpleName();
    private static final LoggerFactory.c d = LoggerFactory.a(c, LoggerFactory.LoggerType.CONSOLE);
    Thread b = new Thread() {
        Camera a;

        /* Error */
        public void run() {
            // Byte code:
            //   0: invokestatic 26	com/everimaging/fotor/SplashActivity:a	()Lcom/everimaging/fotor/log/LoggerFactory$c;
            //   3: iconst_1
            //   4: anewarray 28	java/lang/Object
            //   7: dup
            //   8: iconst_0
            //   9: ldc 30
            //   11: aastore
            //   12: invokeinterface 36 2 0
            //   17: aload_0
            //   18: invokestatic 42	android/hardware/Camera:open	()Landroid/hardware/Camera;
            //   21: putfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   24: aload_0
            //   25: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   28: ifnull +153 -> 181
            //   31: aload_0
            //   32: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   35: invokevirtual 48	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
            //   38: astore_1
            //   39: aload_1
            //   40: invokevirtual 54	android/hardware/Camera$Parameters:getSupportedFlashModes	()Ljava/util/List;
            //   43: invokestatic 59	com/everimaging/fotor/camera/a:a	(Ljava/util/List;)V
            //   46: aload_0
            //   47: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   50: invokevirtual 48	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
            //   53: invokevirtual 62	android/hardware/Camera$Parameters:getSupportedPictureSizes	()Ljava/util/List;
            //   56: astore_2
            //   57: aload_2
            //   58: ifnull +79 -> 137
            //   61: aload_2
            //   62: invokeinterface 68 1 0
            //   67: ifne +70 -> 137
            //   70: aload_2
            //   71: new 70	com/everimaging/fotor/camera/b
            //   74: dup
            //   75: invokespecial 71	com/everimaging/fotor/camera/b:<init>	()V
            //   78: invokestatic 77	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
            //   81: aload_2
            //   82: invokestatic 80	com/everimaging/fotor/settings/a:a	(Ljava/util/List;)V
            //   85: aload_2
            //   86: aload_2
            //   87: invokeinterface 84 1 0
            //   92: iconst_1
            //   93: isub
            //   94: invokeinterface 88 2 0
            //   99: checkcast 90	android/hardware/Camera$Size
            //   102: astore_2
            //   103: new 92	com/everimaging/fotor/c/c
            //   106: dup
            //   107: aload_2
            //   108: getfield 96	android/hardware/Camera$Size:width	I
            //   111: aload_2
            //   112: getfield 99	android/hardware/Camera$Size:height	I
            //   115: invokespecial 102	com/everimaging/fotor/c/c:<init>	(II)V
            //   118: astore_2
            //   119: aload_2
            //   120: getfield 104	com/everimaging/fotor/c/c:a	I
            //   123: ifeq +97 -> 220
            //   126: aload_2
            //   127: getfield 106	com/everimaging/fotor/c/c:b	I
            //   130: ifeq +90 -> 220
            //   133: aload_2
            //   134: invokestatic 109	com/everimaging/fotor/settings/a:a	(Lcom/everimaging/fotor/c/c;)V
            //   137: invokestatic 26	com/everimaging/fotor/SplashActivity:a	()Lcom/everimaging/fotor/log/LoggerFactory$c;
            //   140: iconst_1
            //   141: anewarray 28	java/lang/Object
            //   144: dup
            //   145: iconst_0
            //   146: new 111	java/lang/StringBuilder
            //   149: dup
            //   150: invokespecial 112	java/lang/StringBuilder:<init>	()V
            //   153: ldc 114
            //   155: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   158: aload_1
            //   159: invokevirtual 121	android/hardware/Camera$Parameters:isZoomSupported	()Z
            //   162: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
            //   165: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   168: aastore
            //   169: invokeinterface 36 2 0
            //   174: aload_1
            //   175: invokevirtual 121	android/hardware/Camera$Parameters:isZoomSupported	()Z
            //   178: invokestatic 131	com/everimaging/fotor/camera/a:b	(Z)V
            //   181: aload_0
            //   182: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   185: ifnull +15 -> 200
            //   188: aload_0
            //   189: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   192: invokevirtual 134	android/hardware/Camera:release	()V
            //   195: aload_0
            //   196: aconst_null
            //   197: putfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   200: aload_0
            //   201: getfield 16	com/everimaging/fotor/SplashActivity$1:b	Lcom/everimaging/fotor/SplashActivity;
            //   204: invokestatic 137	com/everimaging/fotor/SplashActivity:a	(Lcom/everimaging/fotor/SplashActivity;)Landroid/os/Handler;
            //   207: new 8	com/everimaging/fotor/SplashActivity$1$1
            //   210: dup
            //   211: aload_0
            //   212: invokespecial 140	com/everimaging/fotor/SplashActivity$1$1:<init>	(Lcom/everimaging/fotor/SplashActivity$1;)V
            //   215: invokevirtual 146	android/os/Handler:post	(Ljava/lang/Runnable;)Z
            //   218: pop
            //   219: return
            //   220: aconst_null
            //   221: invokestatic 109	com/everimaging/fotor/settings/a:a	(Lcom/everimaging/fotor/c/c;)V
            //   224: goto -87 -> 137
            //   227: astore_1
            //   228: aload_1
            //   229: invokevirtual 149	java/lang/Exception:printStackTrace	()V
            //   232: aconst_null
            //   233: invokestatic 80	com/everimaging/fotor/settings/a:a	(Ljava/util/List;)V
            //   236: aconst_null
            //   237: invokestatic 109	com/everimaging/fotor/settings/a:a	(Lcom/everimaging/fotor/c/c;)V
            //   240: aload_0
            //   241: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   244: ifnull +15 -> 259
            //   247: aload_0
            //   248: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   251: invokevirtual 134	android/hardware/Camera:release	()V
            //   254: aload_0
            //   255: aconst_null
            //   256: putfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   259: aload_0
            //   260: getfield 16	com/everimaging/fotor/SplashActivity$1:b	Lcom/everimaging/fotor/SplashActivity;
            //   263: invokestatic 137	com/everimaging/fotor/SplashActivity:a	(Lcom/everimaging/fotor/SplashActivity;)Landroid/os/Handler;
            //   266: new 8	com/everimaging/fotor/SplashActivity$1$1
            //   269: dup
            //   270: aload_0
            //   271: invokespecial 140	com/everimaging/fotor/SplashActivity$1$1:<init>	(Lcom/everimaging/fotor/SplashActivity$1;)V
            //   274: invokevirtual 146	android/os/Handler:post	(Ljava/lang/Runnable;)Z
            //   277: pop
            //   278: return
            //   279: astore_1
            //   280: aload_0
            //   281: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   284: ifnull +15 -> 299
            //   287: aload_0
            //   288: getfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   291: invokevirtual 134	android/hardware/Camera:release	()V
            //   294: aload_0
            //   295: aconst_null
            //   296: putfield 44	com/everimaging/fotor/SplashActivity$1:a	Landroid/hardware/Camera;
            //   299: aload_0
            //   300: getfield 16	com/everimaging/fotor/SplashActivity$1:b	Lcom/everimaging/fotor/SplashActivity;
            //   303: invokestatic 137	com/everimaging/fotor/SplashActivity:a	(Lcom/everimaging/fotor/SplashActivity;)Landroid/os/Handler;
            //   306: new 8	com/everimaging/fotor/SplashActivity$1$1
            //   309: dup
            //   310: aload_0
            //   311: invokespecial 140	com/everimaging/fotor/SplashActivity$1$1:<init>	(Lcom/everimaging/fotor/SplashActivity$1;)V
            //   314: invokevirtual 146	android/os/Handler:post	(Ljava/lang/Runnable;)Z
            //   317: pop
            //   318: aload_1
            //   319: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	320	0	this	1
            //   38	137	1	localParameters	android.hardware.Camera.Parameters
            //   227	2	1	localException	Exception
            //   279	40	1	localObject1	Object
            //   56	78	2	localObject2	Object
            // Exception table:
            //   from	to	target	type
            //   0	57	227	java/lang/Exception
            //   61	137	227	java/lang/Exception
            //   137	181	227	java/lang/Exception
            //   220	224	227	java/lang/Exception
            //   0	57	279	finally
            //   61	137	279	finally
            //   137	181	279	finally
            //   220	224	279	finally
            //   228	240	279	finally
        }
    };
    private Handler e = new Handler();
    private com.everimaging.fotorsdk.store.iap.a f;

    private void a(boolean paramBoolean) {
        Intent localIntent;
        if (!com.everimaging.fotor.settings.a.c()) {
            localIntent = new Intent(this, CameraActivity.class);
            localIntent.putExtra("camera_show_home", true);
        }
        for (; ; ) {
            localIntent.setFlags(67108864);
            startActivity(localIntent);
            if (paramBoolean) {
                break;
            }
            finish();
            return;
            localIntent = new Intent(this, HomeActivity.class);
        }
        a = this;
    }

    private void b() {
        List localList = com.everimaging.fotor.settings.a.a();
        int i;
        if ((localList == null) || (localList.isEmpty())) {
            i = 1;
            d.c(new Object[]{"sizes:" + localList});
            if (i == 0) {
                break label74;
            }
            this.b.start();
        }
        for (; ; ) {
            com.everimaging.fotor.a.a.a(this);
            return;
            i = 0;
            break;
            label74:
            a(false);
        }
    }

    private void c() {
        new a(this).execute(new Void[0]);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903215);
        if (!Utils.isSDCardAvailable()) {
            showDialog(1);
            return;
        }
        c();
        this.f = com.everimaging.fotorsdk.store.iap.a.a();
        this.f.a(this);
    }

    protected Dialog onCreateDialog(int paramInt) {
        Object localObject;
        switch (paramInt) {
            default:
                return super.onCreateDialog(paramInt);
            case 1:
                localObject = new AlertDialog.Builder(this);
                ((AlertDialog.Builder) localObject).setMessage(2131296616);
                ((AlertDialog.Builder) localObject).setCancelable(false);
                ((AlertDialog.Builder) localObject).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        SplashActivity.this.finish();
                    }
                });
                return ((AlertDialog.Builder) localObject).create();
        }
        try {
            localObject = new HashMap();
            ((Map) localObject).put("Device", Build.DEVICE);
            ((Map) localObject).put("Version", Build.VERSION.SDK_INT + "");
            a("Fotor_Compat_Error", (Map) localObject);
            localObject = new AlertDialog.Builder(this);
            ((AlertDialog.Builder) localObject).setMessage(2131296617);
            ((AlertDialog.Builder) localObject).setCancelable(false);
            ((AlertDialog.Builder) localObject).setPositiveButton(2131296618, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    SplashActivity.this.a("Fotor_Compat_Get_It_Now");
                    paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW");
                    paramAnonymousDialogInterface.setData(Uri.parse("http://dl.fotor.com/android/apk/PhotoEffectStudio-v1.2.0.037-Release.apk"));
                    SplashActivity.this.startActivity(paramAnonymousDialogInterface);
                    SplashActivity.this.finish();
                }
            });
            ((AlertDialog.Builder) localObject).setNegativeButton(2131296619, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    SplashActivity.this.a("Fotor_Compat_No_Thanks");
                    SplashActivity.this.finish();
                }
            });
            return ((AlertDialog.Builder) localObject).create();
        } catch (Exception localException) {
            for (; ; ) {
                HashMap localHashMap = new HashMap();
                localHashMap.put("Device", "Unknow");
                localHashMap.put("Version", "Unknow");
                a("Fotor_Compat_Error", localHashMap);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f != null) {
            this.f.c();
        }
    }

    class a
            extends FotorAsyncTask<Void, Void, Boolean> {
        private Context b;

        public a(Context paramContext) {
            this.b = paramContext;
        }

        protected Boolean a(Void... paramVarArgs) {
            paramVarArgs = Build.CPU_ABI;
            SplashActivity.a().c(new Object[]{"device abi:" + paramVarArgs});
            return Boolean.valueOf(false);
        }

        protected void a(Boolean paramBoolean) {
            if (paramBoolean.booleanValue()) {
                SplashActivity.this.showDialog(2);
                return;
            }
            SplashActivity.b(SplashActivity.this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */