package com.inmobi.commons.db;

public class ColumnData {
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private ColumnData.ColumnType d;

    public ColumnData.ColumnType getDataType() {
        return this.d;
    }

    public boolean isAutoIncrement() {
        return this.b;
    }

    public boolean isMandatory() {
        return this.c;
    }

    public boolean isPrimaryKey() {
        return this.a;
    }

    public void setAutoIncrement(boolean paramBoolean) {
        this.b = paramBoolean;
    }

    public void setDataType(ColumnData.ColumnType paramColumnType) {
        this.d = paramColumnType;
    }

    public void setMandatory(boolean paramBoolean) {
        this.c = paramBoolean;
    }

    public void setPrimaryKey(boolean paramBoolean) {
        this.a = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/db/ColumnData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */