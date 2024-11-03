package org.example.JavaBasics;

public class MemoryManagement {
    public static void main(String[] args){
        int primitiveVariable =10;
        Person personObj = new Person();
        String stringLiterals1 ="24";
        MemoryManagement memoryObj = new MemoryManagement();
        memoryObj.memoryManagementTest(personObj);
    }

    private void memoryManagementTest(Person personObj){
        Person personObj1 = personObj;
        String stringLiterals2 ="24";
        String stringLiterals3 = new String("24");
    }
}
