/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Артем
 */
class Languages2 {
        private int idfio;
    int idlang; String language;
    public Languages2(int idfio, int idlang, String language)
    {
        this.idfio=idfio;
        this.language=language;
        this.idlang=idlang;
    }
    
    public int getID1(){
        return idfio;
    }
    
    public int getLanguage1(){
        return idlang;
    }
  
    public String getLanguage2(){
        return language;
    }

    Object getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
