/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Артем
 */
class User2 {
       private
    String fio1;
    int amount;
    public User2(String fio1, int amount)
    {
        this.fio1 = fio1;
        this.amount = amount;
    }



    

    
    public String getFIO(){
        return fio1;
    }

    public int getAMOUNT(){
        return amount;
    }
}
