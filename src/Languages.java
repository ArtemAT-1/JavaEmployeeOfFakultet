/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Артем
 */
class Languages {

    public int id;
    String language;
    public Languages(int id, String language)
    {
        this.id=id;
        this.language=language;
    }
    
    public int getID(){
        return id;
    }
    
    public String getLanguage(){
        return language;
    }
    
}
