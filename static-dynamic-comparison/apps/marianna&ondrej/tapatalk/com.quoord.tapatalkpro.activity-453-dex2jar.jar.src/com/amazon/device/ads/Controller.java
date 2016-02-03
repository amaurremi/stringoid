package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.lang.reflect.Field;

class Controller {
    private static String LOG_TAG = "Controller";

    public static class Dimensions
            extends Controller.ReflectedParcelable {
        public static final Parcelable.Creator<Dimensions> CREATOR = new Parcelable.Creator() {
            public Controller.Dimensions createFromParcel(Parcel paramAnonymousParcel) {
                return new Controller.Dimensions(paramAnonymousParcel);
            }

            public Controller.Dimensions[] newArray(int paramAnonymousInt) {
                return new Controller.Dimensions[paramAnonymousInt];
            }
        };
        public int height;
        public int width;
        public int x;
        public int y;

        public Dimensions() {
            this.x = -1;
            this.y = -1;
            this.width = -1;
            this.height = -1;
        }

        public Dimensions(Parcel paramParcel) {
            super();
        }
    }

    public static class PlayerProperties
            extends Controller.ReflectedParcelable {
        public static final Parcelable.Creator<PlayerProperties> CREATOR = new Parcelable.Creator() {
            public Controller.PlayerProperties createFromParcel(Parcel paramAnonymousParcel) {
                return new Controller.PlayerProperties(paramAnonymousParcel);
            }

            public Controller.PlayerProperties[] newArray(int paramAnonymousInt) {
                return new Controller.PlayerProperties[paramAnonymousInt];
            }
        };
        public boolean audioMuted;
        public boolean autoPlay;
        public boolean doLoop;
        public boolean inline;
        public boolean showControl;
        public String startStyle;
        public String stopStyle;

        public PlayerProperties() {
            this.autoPlay = true;
            this.showControl = true;
            this.doLoop = false;
            this.audioMuted = false;
            this.startStyle = "normal";
            this.stopStyle = "normal";
        }

        public PlayerProperties(Parcel paramParcel) {
            super();
        }

        public boolean doLoop() {
            return this.doLoop;
        }

        public boolean doMute() {
            return this.audioMuted;
        }

        public boolean exitOnComplete() {
            return this.stopStyle.equalsIgnoreCase("exit");
        }

        public boolean isAutoPlay() {
            return this.autoPlay;
        }

        public boolean isFullScreen() {
            return this.startStyle.equalsIgnoreCase("fullscreen");
        }

        public void muteAudio() {
            this.audioMuted = true;
        }

        public void setProperties(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2) {
            this.audioMuted = paramBoolean1;
            this.autoPlay = paramBoolean2;
            this.showControl = paramBoolean3;
            this.inline = paramBoolean4;
            this.doLoop = paramBoolean5;
            this.startStyle = paramString1;
            this.stopStyle = paramString2;
        }

        public boolean showControl() {
            return this.showControl;
        }
    }

    public static class ReflectedParcelable
            implements Parcelable {
        public static final Parcelable.Creator<ReflectedParcelable> CREATOR = new Parcelable.Creator() {
            public Controller.ReflectedParcelable createFromParcel(Parcel paramAnonymousParcel) {
                return new Controller.ReflectedParcelable(paramAnonymousParcel);
            }

            public Controller.ReflectedParcelable[] newArray(int paramAnonymousInt) {
                return new Controller.ReflectedParcelable[paramAnonymousInt];
            }
        };

        public ReflectedParcelable() {
        }

        protected ReflectedParcelable(Parcel paramParcel) {
            Field[] arrayOfField = getClass().getDeclaredFields();
            int j = arrayOfField.length;
            int i = 0;
            for (; ; ) {
                if (i < j) {
                    Field localField = arrayOfField[i];
                    try {
                        if (!(localField.get(this) instanceof Parcelable.Creator)) {
                            localField.set(this, paramParcel.readValue(null));
                        }
                        i += 1;
                    } catch (IllegalAccessException localIllegalAccessException) {
                        for (; ; ) {
                            Log.e(Controller.LOG_TAG, "Error: Could not create object from parcel: %s", new Object[]{localIllegalAccessException.getMessage()});
                        }
                    } catch (IllegalArgumentException localIllegalArgumentException) {
                        for (; ; ) {
                            Log.e(Controller.LOG_TAG, "Error: Could not create object from parcel: %s", new Object[]{localIllegalArgumentException.getMessage()});
                        }
                    }
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            Field[] arrayOfField = getClass().getDeclaredFields();
            int i = arrayOfField.length;
            paramInt = 0;
            for (; ; ) {
                if (paramInt < i) {
                    Object localObject = arrayOfField[paramInt];
                    try {
                        localObject = ((Field) localObject).get(this);
                        if (!(localObject instanceof Parcelable.Creator)) {
                            paramParcel.writeValue(localObject);
                        }
                        paramInt += 1;
                    } catch (IllegalAccessException localIllegalAccessException) {
                        for (; ; ) {
                            Log.e(Controller.LOG_TAG, "Error: Could not write to parcel: %s", new Object[]{localIllegalAccessException.getMessage()});
                        }
                    } catch (IllegalArgumentException localIllegalArgumentException) {
                        for (; ; ) {
                            Log.e(Controller.LOG_TAG, "Error: Could not write to parcel: %s", new Object[]{localIllegalArgumentException.getMessage()});
                        }
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/Controller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */