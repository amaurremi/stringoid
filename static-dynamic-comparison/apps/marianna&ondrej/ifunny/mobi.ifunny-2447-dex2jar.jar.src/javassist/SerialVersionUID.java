package javassist;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javassist.bytecode.ClassFile;
import javassist.bytecode.Descriptor;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;

public class SerialVersionUID {
    static long calculateDefault(CtClass paramCtClass) {
        int j = 0;
        for (; ; ) {
            int k;
            try {
                ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
                ClassFile localClassFile = paramCtClass.getClassFile();
                localDataOutputStream.writeUTF(javaName(paramCtClass));
                CtMethod[] arrayOfCtMethod = paramCtClass.getDeclaredMethods();
                k = paramCtClass.getModifiers();
                i = k;
                if ((k & 0x200) != 0) {
                    if (arrayOfCtMethod.length > 0) {
                        i = k | 0x400;
                    }
                } else {
                    localDataOutputStream.writeInt(i);
                    Object localObject1 = localClassFile.getInterfaces();
                    i = 0;
                    if (i < localObject1.length) {
                        localObject1[i] = javaName(localObject1[i]);
                        i += 1;
                        continue;
                    }
                    Arrays.sort((Object[]) localObject1);
                    i = 0;
                    if (i < localObject1.length) {
                        localDataOutputStream.writeUTF(localObject1[i]);
                        i += 1;
                        continue;
                    }
                    localObject1 = paramCtClass.getDeclaredFields();
                    Arrays.sort((Object[]) localObject1, new SerialVersionUID .1 ());
                    i = 0;
                    if (i < localObject1.length) {
                        Object localObject2 = localObject1[i];
                        k = ((CtField) localObject2).getModifiers();
                        if (((k & 0x2) != 0) && ((k & 0x88) != 0)) {
                            break label502;
                        }
                        localDataOutputStream.writeUTF(((CtField) localObject2).getName());
                        localDataOutputStream.writeInt(k);
                        localDataOutputStream.writeUTF(((CtField) localObject2).getFieldInfo2().getDescriptor());
                        break label502;
                    }
                    if (localClassFile.getStaticInitializer() != null) {
                        localDataOutputStream.writeUTF("<clinit>");
                        localDataOutputStream.writeInt(8);
                        localDataOutputStream.writeUTF("()V");
                    }
                    paramCtClass = paramCtClass.getDeclaredConstructors();
                    Arrays.sort(paramCtClass, new SerialVersionUID .2 ());
                    i = 0;
                    if (i < paramCtClass.length) {
                        localClassFile = paramCtClass[i];
                        k = localClassFile.getModifiers();
                        if ((k & 0x2) != 0) {
                            break label509;
                        }
                        localDataOutputStream.writeUTF("<init>");
                        localDataOutputStream.writeInt(k);
                        localDataOutputStream.writeUTF(localClassFile.getMethodInfo2().getDescriptor().replace('/', '.'));
                        break label509;
                    }
                    Arrays.sort(arrayOfCtMethod, new SerialVersionUID .3 ());
                    i = j;
                    if (i < arrayOfCtMethod.length) {
                        paramCtClass = arrayOfCtMethod[i];
                        j = paramCtClass.getModifiers() & 0xD3F;
                        if ((j & 0x2) != 0) {
                            break label516;
                        }
                        localDataOutputStream.writeUTF(paramCtClass.getName());
                        localDataOutputStream.writeInt(j);
                        localDataOutputStream.writeUTF(paramCtClass.getMethodInfo2().getDescriptor().replace('/', '.'));
                        break label516;
                    }
                    localDataOutputStream.flush();
                    paramCtClass = MessageDigest.getInstance("SHA").digest(localByteArrayOutputStream.toByteArray());
                    long l = 0L;
                    i = Math.min(paramCtClass.length, 8) - 1;
                    if (i >= 0) {
                        j = paramCtClass[i];
                        l = l << 8 | j & 0xFF;
                        i -= 1;
                        continue;
                    }
                    return l;
                }
            } catch (IOException paramCtClass) {
                throw new CannotCompileException(paramCtClass);
            } catch (NoSuchAlgorithmException paramCtClass) {
                throw new CannotCompileException(paramCtClass);
            }
            int i = k & 0xFBFF;
            continue;
            label502:
            i += 1;
            continue;
            label509:
            i += 1;
            continue;
            label516:
            i += 1;
        }
    }

    private static boolean isSerializable(CtClass paramCtClass) {
        return paramCtClass.subtypeOf(paramCtClass.getClassPool().get("java.io.Serializable"));
    }

    private static String javaName(String paramString) {
        return Descriptor.toJavaName(Descriptor.toJvmName(paramString));
    }

    private static String javaName(CtClass paramCtClass) {
        return Descriptor.toJavaName(Descriptor.toJvmName(paramCtClass));
    }

    public static void setSerialVersionUID(CtClass paramCtClass) {
        try {
            paramCtClass.getDeclaredField("serialVersionUID");
            return;
        } catch (NotFoundException localNotFoundException) {
            while (!isSerializable(paramCtClass)) {
            }
            CtField localCtField = new CtField(CtClass.longType, "serialVersionUID", paramCtClass);
            localCtField.setModifiers(26);
            paramCtClass.addField(localCtField, calculateDefault(paramCtClass) + "L");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/SerialVersionUID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */