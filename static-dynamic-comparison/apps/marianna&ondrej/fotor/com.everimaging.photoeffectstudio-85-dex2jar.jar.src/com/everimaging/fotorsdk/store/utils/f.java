package com.everimaging.fotorsdk.store.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.everimaging.fotorsdk.app.FotorAlertDialog;
import com.everimaging.fotorsdk.app.FotorAlertDialog.a;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.R.string;

public class f {
    private static final String a = f.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);

    public static void a(int paramInt, Context paramContext, FragmentManager paramFragmentManager) {
        if (paramFragmentManager == null) {
        }
        for (; ; ) {
            return;
            try {
                if (paramFragmentManager.findFragmentByTag("alert_dlg_tag_store_download_error") != null) {
                    continue;
                }
                FotorAlertDialog localFotorAlertDialog = FotorAlertDialog.a();
                Bundle localBundle = new Bundle();
                int i = 0;
                switch (paramInt) {
                }
                for (; ; ) {
                    localBundle.putCharSequence("MESSAGE", paramContext.getText(paramInt));
                    localFotorAlertDialog.setArguments(localBundle);
                    localBundle.putCharSequence("POSITIVE_BUTTON_TEXT", paramContext.getText(17039370));
                    localFotorAlertDialog.a(new FotorAlertDialog.a() {
                        public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                        }

                        public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                        }

                        public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                        }
                    });
                    localFotorAlertDialog.a(paramFragmentManager, "alert_dlg_tag_store_download_error", true);
                    return;
                    paramInt = R.string.fotor_dialog_alert_message_network_exception;
                    continue;
                    paramInt = R.string.fotor_dialog_alert_message_storage_no_space;
                    continue;
                    paramInt = R.string.fotor_dialog_alert_message_unzip_error;
                    continue;
                    paramInt = i;
                }
                return;
            } catch (Exception paramContext) {
            }
        }
    }

    public static void a(FragmentActivity paramFragmentActivity) {
        if (paramFragmentActivity == null) {
        }
        for (; ; ) {
            return;
            try {
                if (paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("alert_dlg_tag_network_error") == null) {
                    FotorAlertDialog localFotorAlertDialog = FotorAlertDialog.a();
                    Bundle localBundle = new Bundle();
                    localBundle.putCharSequence("MESSAGE", paramFragmentActivity.getText(R.string.fotor_dialog_alert_message_network_exception));
                    localFotorAlertDialog.setArguments(localBundle);
                    localBundle.putCharSequence("POSITIVE_BUTTON_TEXT", paramFragmentActivity.getText(17039370));
                    localFotorAlertDialog.a(new FotorAlertDialog.a() {
                        public void a(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                        }

                        public void b(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                        }

                        public void c(FotorAlertDialog paramAnonymousFotorAlertDialog) {
                        }
                    });
                    localFotorAlertDialog.a(paramFragmentActivity.getSupportFragmentManager(), "alert_dlg_tag_network_error", true);
                    return;
                }
            } catch (Exception paramFragmentActivity) {
            }
        }
    }

    public static void b(FragmentActivity paramFragmentActivity) {
        try {
            Object localObject = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("alert_dlg_tag_store_unavailable");
            b.c(new Object[]{"showing dialog:" + localObject});
            if (localObject != null) {
                b.d(new Object[]{"unavailable alert dialog is showing will return."});
                return;
            }
            localObject = new Bundle();
            ((Bundle) localObject).putCharSequence("TITLE", paramFragmentActivity.getText(R.string.fotor_store_title));
            ((Bundle) localObject).putCharSequence("MESSAGE", paramFragmentActivity.getResources().getString(R.string.fotor_dialog_alert_message_network_exception));
            ((Bundle) localObject).putCharSequence("NEUTRAL_BUTTON_TEXT", paramFragmentActivity.getText(17039370));
            FotorAlertDialog localFotorAlertDialog = FotorAlertDialog.a();
            localFotorAlertDialog.setArguments((Bundle) localObject);
            localFotorAlertDialog.a(paramFragmentActivity.getSupportFragmentManager(), "alert_dlg_tag_store_unavailable", true);
            return;
        } catch (Exception paramFragmentActivity) {
            paramFragmentActivity.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */