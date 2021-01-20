/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Артем
 */
class User {
    public int fio_id;
    public String fio1;
    public User(int fio_id, String fio1)
    {
        this.fio_id=fio_id;
        this.fio1=fio1;
    }
    
    public int getFIOid(){
        return fio_id;
    }
    
    public String getFIO(){
        return fio1;
    }
}
