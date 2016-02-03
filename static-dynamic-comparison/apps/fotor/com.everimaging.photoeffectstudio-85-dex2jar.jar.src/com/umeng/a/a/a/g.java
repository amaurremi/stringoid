package com.umeng.a.a.a;

import com.umeng.a.a.a.b.b.a;
import com.umeng.a.a.a.b.c;
import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.d.b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class g {
    private final h a;
    private final b b = new b();

    public g() {
        this(new b.a());
    }

    public g(com.umeng.a.a.a.b.j paramj) {
        this.a = paramj.a(this.b);
    }

    private Object a(byte paramByte, byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        try {
            paramArrayOfByte = j(paramArrayOfByte, paramk, paramVarArgs);
            if (paramArrayOfByte != null) {
                switch (paramByte) {
                }
            }
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            return null;
                                        } while (paramArrayOfByte.b != 2);
                                        boolean bool = this.a.t();
                                        return Boolean.valueOf(bool);
                                    } while (paramArrayOfByte.b != 3);
                                    byte b1 = this.a.u();
                                    return Byte.valueOf(b1);
                                } while (paramArrayOfByte.b != 4);
                                double d = this.a.y();
                                return Double.valueOf(d);
                            } while (paramArrayOfByte.b != 6);
                            short s = this.a.v();
                            return Short.valueOf(s);
                        } while (paramArrayOfByte.b != 8);
                        paramByte = this.a.w();
                        return Integer.valueOf(paramByte);
                    } while (paramArrayOfByte.b != 10);
                    long l = this.a.x();
                    return Long.valueOf(l);
                } while (paramArrayOfByte.b != 11);
                paramArrayOfByte = this.a.z();
                return paramArrayOfByte;
            } while (paramArrayOfByte.b != 11);
            paramArrayOfByte = this.a.A();
            return paramArrayOfByte;
        } catch (Exception paramArrayOfByte) {
            throw new j(paramArrayOfByte);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    private c j(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        int j = 0;
        this.b.a(paramArrayOfByte);
        k[] arrayOfk = new k[paramVarArgs.length + 1];
        arrayOfk[0] = paramk;
        int i = 0;
        while (i < paramVarArgs.length) {
            arrayOfk[(i + 1)] = paramVarArgs[i];
            i += 1;
        }
        this.a.j();
        paramArrayOfByte = null;
        i = j;
        while (i < arrayOfk.length) {
            paramk = this.a.l();
            if ((paramk.b == 0) || (paramk.c > arrayOfk[i].a())) {
                return null;
            }
            if (paramk.c != arrayOfk[i].a()) {
                com.umeng.a.a.a.b.k.a(this.a, paramk.b);
                this.a.m();
                paramArrayOfByte = paramk;
            } else {
                j = i + 1;
                paramArrayOfByte = paramk;
                i = j;
                if (j < arrayOfk.length) {
                    this.a.j();
                    paramArrayOfByte = paramk;
                    i = j;
                }
            }
        }
        return paramArrayOfByte;
    }

    public Boolean a(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        return (Boolean) a((byte) 2, paramArrayOfByte, paramk, paramVarArgs);
    }

    public void a(d paramd, String paramString)
            throws j {
        a(paramd, paramString.getBytes());
    }

    public void a(d paramd, String paramString1, String paramString2)
            throws j {
        try {
            a(paramd, paramString1.getBytes(paramString2));
            return;
        } catch (UnsupportedEncodingException paramd) {
            throw new j("JVM DOES NOT SUPPORT ENCODING: " + paramString2);
        } finally {
            this.a.B();
        }
    }

    public void a(d paramd, byte[] paramArrayOfByte)
            throws j {
        try {
            this.b.a(paramArrayOfByte);
            paramd.a(this.a);
            return;
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public void a(d paramd, byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        try {
            if (j(paramArrayOfByte, paramk, paramVarArgs) != null) {
                paramd.a(this.a);
            }
            return;
        } catch (Exception paramd) {
            throw new j(paramd);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Byte b(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        return (Byte) a((byte) 3, paramArrayOfByte, paramk, paramVarArgs);
    }

    public Double c(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        return (Double) a((byte) 4, paramArrayOfByte, paramk, paramVarArgs);
    }

    public Short d(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        return (Short) a((byte) 6, paramArrayOfByte, paramk, paramVarArgs);
    }

    public Integer e(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        return (Integer) a((byte) 8, paramArrayOfByte, paramk, paramVarArgs);
    }

    public Long f(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        return (Long) a((byte) 10, paramArrayOfByte, paramk, paramVarArgs);
    }

    public String g(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        return (String) a((byte) 11, paramArrayOfByte, paramk, paramVarArgs);
    }

    public ByteBuffer h(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        return (ByteBuffer) a((byte) 100, paramArrayOfByte, paramk, paramVarArgs);
    }

    public Short i(byte[] paramArrayOfByte, k paramk, k... paramVarArgs)
            throws j {
        try {
            if (j(paramArrayOfByte, paramk, paramVarArgs) != null) {
                this.a.j();
                short s = this.a.l().c;
                return Short.valueOf(s);
            }
            return null;
        } catch (Exception paramArrayOfByte) {
            throw new j(paramArrayOfByte);
        } finally {
            this.b.e();
            this.a.B();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */