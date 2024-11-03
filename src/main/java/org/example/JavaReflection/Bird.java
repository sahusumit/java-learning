package org.example.JavaReflection;

public class Bird {
    public String birdName;
    public String breed;
    private boolean canSwim;

    public void fly(String name){
        System.out.println(name+ " can fly");
    }
    private void eat(){
        System.out.println("this bird can eat");
    }
}
