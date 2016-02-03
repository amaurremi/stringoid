package android.database.sqlite;

public abstract interface SQLiteTransactionListener {
    public abstract void onBegin();

    public abstract void onCommit();

    public abstract void onRollback();
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/database/sqlite/SQLiteTransactionListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */