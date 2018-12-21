/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Duy Do
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "999";
        String s2 = "3409";
        MyBigNumber mb = new MyBigNumber();
        String ketqua = mb.sum(s1, s2);
        System.out.println(ketqua);
    }    
}
