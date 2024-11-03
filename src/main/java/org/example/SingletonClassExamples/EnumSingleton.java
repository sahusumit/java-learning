package org.example.SingletonClassExamples;

/**
 * By default enum's class all constructor is private.
 * Per JVM only one snapshot/object is created of ENUM class;
 * In ENUM everything happen automatically, it take care of instance exist per JVM
 */
public enum EnumSingleton {
    INSTANCE;
}
