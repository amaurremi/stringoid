package org.OpenUDID;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public class OpenUDID_service
        extends Service {
    public IBinder onBind(Intent paramIntent) {
        new Binder() {
            public boolean onTransact(int paramAnonymousInt1, Parcel paramAnonymousParcel1, Parcel paramAnonymousParcel2, int paramAnonymousInt2) {
                SharedPreferences localSharedPreferences = OpenUDID_service.this.getSharedPreferences("openudid_prefs", 0);
                paramAnonymousParcel2.writeInt(paramAnonymousParcel1.readInt());
                paramAnonymousParcel2.writeString(localSharedPreferences.getString("openudid", null));
                return true;
            }
        };
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/org/OpenUDID/OpenUDID_service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */