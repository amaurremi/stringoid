package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class ShortcutUtil {
    public static void createShortcut(Activity paramActivity, final String paramString1, String paramString2, final String paramString3) {
        View localView = LayoutInflater.from(paramActivity).inflate(2130903090, null);
        final EditText localEditText = (EditText) localView.findViewById(2131230910);
        localEditText.setText(paramString2);
        new AlertDialog.Builder(paramActivity).setView(localView).setPositiveButton(2131100288, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = new FavoriateSqlHelper(ShortcutUtil.this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(paramString1);
                Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                localIntent.putExtra("android.intent.extra.shortcut.NAME", localEditText.getText().toString());
                int i;
                if (!ShortcutUtil.this.getResources().getBoolean(2131558401)) {
                    paramAnonymousInt = Util.getPxFromDip(ShortcutUtil.this, 48.0F);
                    i = Util.getPxFromDip(ShortcutUtil.this, 48.0F);
                }
                for (; ; ) {
                    try {
                        Object localObject = AvatarTool.getLocalUrl(ShortcutUtil.this, 5, paramAnonymousDialogInterface.getIconUrl());
                        if (Util.checkLocalData((String) localObject)) {
                            localIntent.putExtra("android.intent.extra.shortcut.ICON", Util.toRoundCorner(Util.getFoursquareForumIcon((String) localObject, paramAnonymousInt), 15));
                            if (paramAnonymousDialogInterface != null) {
                                localObject = new Intent();
                                ((Intent) localObject).putExtra("shortcut", true);
                                ((Intent) localObject).putExtra("shortcutID", paramString3);
                                ((Intent) localObject).putExtra("forumName", paramAnonymousDialogInterface.getName());
                                ((Intent) localObject).putExtra("cloud_username", paramAnonymousDialogInterface.getUserName());
                                ((Intent) localObject).putExtra("ext", paramAnonymousDialogInterface.getExt());
                                ((Intent) localObject).putExtra("folder", paramAnonymousDialogInterface.getFolder());
                                ((Intent) localObject).putExtra("forumId", paramAnonymousDialogInterface.getId().toString());
                                ((Intent) localObject).putExtra("shortcutURL", paramAnonymousDialogInterface.getUrl());
                                ((Intent) localObject).setClass(ShortcutUtil.this, SlidingMenuActivity.class);
                                ((Intent) localObject).addFlags(268435456);
                                ((Intent) localObject).addFlags(67108864);
                                localIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable) localObject);
                                ShortcutUtil.this.sendBroadcast(localIntent);
                            }
                            return;
                        }
                        try {
                            localObject = ShortcutUtil.this.openFileInput(paramAnonymousDialogInterface.getIconUrl().hashCode());
                            arrayOfByte = new byte['Ѐ'];
                            localByteArrayOutputStream = new ByteArrayOutputStream();
                            if (((FileInputStream) localObject).read(arrayOfByte) != -1) {
                                continue;
                            }
                            ((FileInputStream) localObject).close();
                            localByteArrayOutputStream.close();
                            localIntent.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size()));
                        } catch (Exception localException1) {
                            localIntent.putExtra("android.intent.extra.shortcut.ICON", Bitmap.createScaledBitmap(BitmapFactory.decodeResource(ShortcutUtil.this.getResources(), 2130837525), paramAnonymousInt, i, true));
                        }
                        continue;
                    } catch (Exception localException2) {
                        byte[] arrayOfByte;
                        ByteArrayOutputStream localByteArrayOutputStream;
                        continue;
                        localByteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
                        continue;
                    }
                    localIntent.putExtra("android.intent.extra.shortcut.ICON", ShortcutUtil.drawableToBitmap(ShortcutUtil.this.getResources().getDrawable(2130837525)));
                }
            }
        }).setNegativeButton(2131100289, null).show();
    }

    public static Bitmap drawableToBitmap(Drawable paramDrawable) {
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        if (paramDrawable.getOpacity() != -1) {
        }
        for (Object localObject = Bitmap.Config.ARGB_8888; ; localObject = Bitmap.Config.RGB_565) {
            localObject = Bitmap.createBitmap(i, j, (Bitmap.Config) localObject);
            Canvas localCanvas = new Canvas((Bitmap) localObject);
            paramDrawable.setBounds(0, 0, i, j);
            paramDrawable.draw(localCanvas);
            return (Bitmap) localObject;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ShortcutUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */