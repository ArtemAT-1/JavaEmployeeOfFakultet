/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Артем
 */
public class Stag {
            int fio_id;
    int stag_id;
    public Stag(int fio_id, int stag_id)
    {
        this.fio_id=fio_id;
        this.stag_id=stag_id;
    }

    
    public int getID1(){
        return fio_id;
    }
    
    public int getID2(){
        return stag_id;
    }
}
