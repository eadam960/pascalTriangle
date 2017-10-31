/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

/**
 *
 * @author eadam
 */
public class Element {
    private Element originLeft, originRight, descendantLeft, descendantRight;
    int data;

    public Element() {
    }
    
    public void createNewLevel(){
        if(descendantLeft != null){
            descendantLeft.createNewLevel();
        }else{
            descendantLeft = new Element();
            descendantLeft.createDataValue();
            descendantLeft.originRight = this;
            descendantLeft.createThisLevel();
        }
    }
    
    public void createNewLevel(int level){
        for (int i = 0; i < level; i++) {
            createNewLevel();
        }
    }
    
    private void createThisLevel(){
        originRight.descendantRight = new Element();
        originRight.descendantRight.originLeft = originRight;
        
        if(originRight.originRight != null){
            originRight.descendantRight.originRight = originRight.originRight.descendantRight;
            originRight.descendantRight.originRight.descendantLeft = originRight.descendantRight;
            originRight.descendantRight.createThisLevel();
        }
        
        originRight.descendantRight.createDataValue();
        
    }
    
    private void createDataValue(){
        int a,b;
        
        if(originLeft != null){
            a = originLeft.data;
        }else{
            a = 0;
        }
        
        if(originRight != null){
            b = originRight.data;
        }else{
            b = 0;
        }
        
        if(a+b != 0){
            data = a+b;
        }else{
            data = 1;
        }
    }
    
    public void getLine(int level){
        if(level > 0){
            if(descendantLeft != null){
                descendantLeft.getLine(level-1);
            }else{
                System.out.println("Too high");
            }
        }else{
            System.out.println(data);
            if(originRight != null){
                originRight.descendantRight.getLine(level);
            }
        }
    }
    
    public int getNumberofLevels(){
        int levels= 1;
        
        if(descendantLeft != null){
           levels+= descendantLeft.getNumberofLevels();
        }
        
        return levels;
    }
    
    
    
    
    
    
    
}
