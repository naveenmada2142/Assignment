/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corejava;

/**
 *
 * @author apalya
 */
public class Assignment1 {
    public static void main(String[] args) {
        TestA a =new TestA();
        TestB b = new TestB();
        TestC c = new TestC();
        
        a.b=b;
        b.c=c;
        b.a=c;
        c.b=b;
        
        a.b.c=c.b.a;
    }
}
class TestA{
    TestB b ;
}
class TestB{
    TestC a;
    TestC c ;
}
class TestC{
   
    TestB b;
}