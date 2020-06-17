package com.star.tank.test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {




    public static void main(String[] args) throws InterruptedException {
        Dog[] dogs = new Dog[]{new Dog(3,4),new Dog(5,7),new Dog(1,6)};

        new SortUtil<Dog>().sortUp(dogs,new ComparatorDog());

        System.out.println(Arrays.toString(dogs));

    }
}

class ComparatorDog implements Comparator<Dog>{

    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.getWeight()<o2.getWeight()) return -1;
        else if(o1.getWeight()>o2.getWeight()) return 1;
        else return 0;
    }
}