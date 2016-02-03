package com.everimaging.fotorsdk.collage.painter;

public abstract interface ICollagePainter {
    public abstract int d();

    public abstract PainterType e();

    public static enum PainterType {
        Attachment, Canvas, Slot;

        private PainterType() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/painter/ICollagePainter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */