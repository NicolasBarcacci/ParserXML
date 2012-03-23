/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

/**
 *
 * @author Nicolas
 */
public abstract class QuestionClasseIntermediaire extends QuestionDescription{
    
    private String image;
    
    public QuestionClasseIntermediaire(){
        super();
        image="";
    }
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String _image){
        image=_image;
    }
}
