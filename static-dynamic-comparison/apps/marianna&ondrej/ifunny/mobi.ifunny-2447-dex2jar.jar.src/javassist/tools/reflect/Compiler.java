package javassist.tools.reflect;

import java.io.PrintStream;

import javassist.ClassPool;
import javassist.CtClass;

public class Compiler {
    private static void help(PrintStream paramPrintStream) {
        paramPrintStream.println("Usage: java javassist.tools.reflect.Compiler");
        paramPrintStream.println("            (<class> [-m <metaobject>] [-c <class metaobject>])+");
    }

    public static void main(String[] paramArrayOfString) {
        if (paramArrayOfString.length == 0) {
            help(System.err);
            return;
        }
        CompiledClass[] arrayOfCompiledClass = new CompiledClass[paramArrayOfString.length];
        int i = parse(paramArrayOfString, arrayOfCompiledClass);
        if (i < 1) {
            System.err.println("bad parameter.");
            return;
        }
        processClasses(arrayOfCompiledClass, i);
    }

    private static int parse(String[] paramArrayOfString, CompiledClass[] paramArrayOfCompiledClass) {
        int i = 0;
        int j = -1;
        if (i < paramArrayOfString.length) {
            Object localObject = paramArrayOfString[i];
            if (((String) localObject).equals("-m")) {
                if ((j < 0) || (i + 1 > paramArrayOfString.length)) {
                    label37:
                    return -1;
                }
                localObject = paramArrayOfCompiledClass[j];
                i += 1;
                ((CompiledClass) localObject).metaobject = paramArrayOfString[i];
            }
            for (; ; ) {
                i += 1;
                break;
                if (((String) localObject).equals("-c")) {
                    if ((j < 0) || (i + 1 > paramArrayOfString.length)) {
                        break label37;
                    }
                    localObject = paramArrayOfCompiledClass[j];
                    i += 1;
                    ((CompiledClass) localObject).classobject = paramArrayOfString[i];
                    continue;
                }
                if (((String) localObject).charAt(0) == '-') {
                    break label37;
                }
                CompiledClass localCompiledClass = new CompiledClass();
                localCompiledClass.classname = ((String) localObject);
                localCompiledClass.metaobject = null;
                localCompiledClass.classobject = null;
                j += 1;
                paramArrayOfCompiledClass[j] = localCompiledClass;
            }
        }
        return j + 1;
    }

    private static void processClasses(CompiledClass[] paramArrayOfCompiledClass, int paramInt) {
        Reflection localReflection = new Reflection();
        ClassPool localClassPool = ClassPool.getDefault();
        localReflection.start(localClassPool);
        int i = 0;
        if (i < paramInt) {
            CtClass localCtClass = localClassPool.get(paramArrayOfCompiledClass[i].classname);
            String str1;
            label71:
            String str2;
            if ((paramArrayOfCompiledClass[i].metaobject != null) || (paramArrayOfCompiledClass[i].classobject != null)) {
                if (paramArrayOfCompiledClass[i].metaobject == null) {
                    str1 = "javassist.tools.reflect.Metaobject";
                    if (paramArrayOfCompiledClass[i].classobject != null) {
                        break label201;
                    }
                    str2 = "javassist.tools.reflect.ClassMetaobject";
                    label84:
                    if (!localReflection.makeReflective(localCtClass, localClassPool.get(str1), localClassPool.get(str2))) {
                        System.err.println("Warning: " + localCtClass.getName() + " is reflective.  It was not changed.");
                    }
                    System.err.println(localCtClass.getName() + ": " + str1 + ", " + str2);
                }
            }
            for (; ; ) {
                i += 1;
                break;
                str1 = paramArrayOfCompiledClass[i].metaobject;
                break label71;
                label201:
                str2 = paramArrayOfCompiledClass[i].classobject;
                break label84;
                System.err.println(localCtClass.getName() + ": not reflective");
            }
        }
        i = 0;
        while (i < paramInt) {
            localReflection.onLoad(localClassPool, paramArrayOfCompiledClass[i].classname);
            localClassPool.get(paramArrayOfCompiledClass[i].classname).writeFile();
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/reflect/Compiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */