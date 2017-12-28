# Kotlin 1.2 Enum Reflection Bug Demo

Run the code: `./gradlew clean run`

Expecting to see constructors for both `ENUM1` and `ENUM2`, however the code explodes with
```
Exception in thread "main" kotlin.reflect.jvm.internal.KotlinReflectionInternalError: Unknown origin of private constructor ENUM2() defined in bugdemo.TestEnum.ENUM2[DefaultClassConstructorDescriptor@1e67a849] (class kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory$DefaultClassConstructorDescriptor)
        at kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapSignature(RuntimeTypeMapper.kt:201)
        at kotlin.reflect.jvm.internal.KFunctionImpl.<init>(KFunctionImpl.kt:47)
        at kotlin.reflect.jvm.internal.KClassImpl$Data$constructors$2.invoke(KClassImpl.kt:91)
        at kotlin.reflect.jvm.internal.KClassImpl$Data$constructors$2.invoke(KClassImpl.kt:43)
        at kotlin.reflect.jvm.internal.ReflectProperties$LazySoftVal.invoke(ReflectProperties.java:93)
        at kotlin.reflect.jvm.internal.ReflectProperties$Val.getValue(ReflectProperties.java:32)
        at kotlin.reflect.jvm.internal.KClassImpl$Data.getConstructors(KClassImpl.kt)
        at kotlin.reflect.jvm.internal.KClassImpl.getConstructors(KClassImpl.kt:222)
        at bugdemo.TestEnumKt.main(TestEnum.kt:21)
```
when attempting to access `ENUM2`'s constructors, presumably due to the fact that it overrides a method.
