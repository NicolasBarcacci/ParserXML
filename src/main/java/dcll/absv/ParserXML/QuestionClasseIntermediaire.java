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
    
    public QuestionClasseIntermediaire(String xml){
        super("","","","","","","","");
    }

    public QuestionClasseIntermediaire(String _name, String _questionTextFormat, String _questionTextText, String _generalFeedBack, String _shuffleAnswer, String _defaultGrade, String _penalty, String _hidden, String _image){
        super(_name,_questionTextFormat,_questionTextText,_generalFeedBack,_shuffleAnswer,_defaultGrade,_penalty,_hidden);
        image=_image;
    }
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String _image){
        image=_image;
    }
}
