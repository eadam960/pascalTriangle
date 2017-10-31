/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezerles;

import elements.Element;

/**
 *
 * @author eadam
 */
public class Vezerlo {
    public static void main(String[] args) {
        new Vezerlo().start();
    }
    
    private void start(){
        Element triangle = new Element();
        triangle.createNewLevel(10);
        triangle.getLine(7);
    }
}
