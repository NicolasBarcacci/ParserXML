/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

/**
 *
 * @author Nicolas
 */
public class QuestionEssay extends QuestionClasseIntermediaire{
    public QuestionEssay(){
        super();
    }
    
    public QuestionEssay(String xml){
        super("","","","","","","","","");
    }
    
   public QuestionEssay(String _name, String _questionTextFormat, String _questionTextText, String _generalFeedBack, String _shuffleAnswer, String _defaultGrade, String _penalty, String _hidden, String _image){
        super(_name,_questionTextFormat,_questionTextText,_generalFeedBack,_shuffleAnswer,_defaultGrade,_penalty,_hidden,_image);
    }
    
    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
