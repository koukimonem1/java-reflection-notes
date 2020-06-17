package com.kouki;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Notes0 {
    /*
     La reflection est une manière de savoir les méta-données d'un objet, c'à'd savoir
     les méthodes les attributs et classes au moment d'éxecution
     */
    public static void main(String[] args) {
       // On peut obtenir un objet Class directement depuis le nom de la classe
        Class c = A.class;

        A a =new A();
        showMethodNames(a);
        showFieldsNames(a);
    }

    /**
     *  Inspecter les noms des méthodes
      */

    public static void showMethodNames(Object o){
        Method[] methods = o.getClass().getMethods();
        for(Method method : methods){
            System.out.print(method.getName());
            // get return type
            System.out.println(" ; "+method.getReturnType());
        }
        System.out.println("-------------------------------");
    }
    /**
     * Inspecter les noms des attributs
     */
    public static void showFieldsNames(Object o){
        Field[] fields = o.getClass().getFields();
        for(Field field : fields){
            System.out.println(field.getName()+" ; type = "+field.getType().getName());
        }
        System.out.println("-------------------------------");
    }

    /**
     * Inspecter les constructeurs
     */
    public static void showConstructersNames(Object o){
        Constructor[] constructors = o.getClass().getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.getName());
        }
        System.out.println("-------------------------------");
    }
    static  class A{
        public int a;
        private int b;
        public A(){}
        public A(int a,int b){
            this.a=a;
            this.b=b;
        }
        public void f(String s){}
        public int g(){ return 1;}
    }
}
