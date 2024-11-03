package org.example.JavaReflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionMain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /**
         * Class of any class get by below methods
         * 1. Class.forName("class Name")
         * 2. by calling .class  i.e Bird.class
         * 3. by calling getClass() method after creating instance of the class i.e Bird.getClass()
         */
        Class birdClass = Bird.class;

        System.out.println("className by .class method :"+  birdClass.getName());
        System.out.println("Get Modifiers of class :"+ Modifier.toString(birdClass.getModifiers()));
        System.out.println("Get all fields of class :"+ Arrays.toString(birdClass.getFields()));

        //REFLECTION OF METHOD

        Method[] birdMethods = birdClass.getMethods();
        /**
         * this return all public method
         */
        for(Method method : birdMethods){
            //for each method we can get the information or meta like return type access modifies;
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getDeclaringClass());
            System.out.println("**********************");
            //Note since each class have on parent class called object so it returns its metadata also
            // like notify, notifyAll, wait
        }
        /**
         * to get the all public and private methods of given class only
         * use getDeclaredMethods;
         */
        Method[] methods1 = birdClass.getDeclaredMethods();
        for(Method method: methods1){
            System.out.println("method names :" + method.getName());
        }


        /**
         * to get the method and class using reflection
         */
        Object birdObject = birdClass.newInstance();

        Method flyMethod = birdClass.getMethod("fly", String.class);
        flyMethod.invoke(birdObject,"eagle");

        /*
         USING REFLECTION WE CAN CHANGE THE PUBLIC AND PRIVATE FIELDS VALUE
         */

        Field breedField = birdClass.getField("breed");
        Bird birdObj = new Bird();
        breedField.set(birdObj, "changedBreadValue");
        System.out.println("change field value "+ birdObj.breed);


        // to change the private fields
        Field canSwimField = birdClass.getDeclaredField("canSwim");
        canSwimField.setAccessible(true);
         canSwimField.set(birdObj, true);
         if(canSwimField.getBoolean(birdObj)) {
             System.out.println("private field value changed");
         }

          /*
            USING REFLECTION WE CAN CREATE THE INSTANCE OF PRIVATE CONSTRUCTOR
         */

        Class<?> testClass = TestSingleton.class;
        Constructor<?>[] constructors = testClass.getDeclaredConstructors();
        for(Constructor<?> constructor: constructors){
            System.out.println("modifiers "+Modifier.toString(constructor.getModifiers()));
            constructor.setAccessible(true);
            TestSingleton testObj = (TestSingleton) constructor.newInstance();
            testObj.testMethod();
        }


    }

}
