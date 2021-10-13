package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement  implements MyBeanWithDependency{

    //Dependencia
    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println(myOperation.sum(1));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
