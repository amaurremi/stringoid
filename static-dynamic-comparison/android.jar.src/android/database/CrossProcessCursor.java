package android.database;

public abstract interface CrossProcessCursor
        extends Cursor {
    public abstract CursorWindow getWindow();

    public abstract void fillWindow(int paramInt, CursorWindow paramCursorWindow);

    public abstract boolean onMove(int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/CrossProcessCursor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */