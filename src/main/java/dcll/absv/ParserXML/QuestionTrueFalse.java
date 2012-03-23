/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

/**
 *
 * @author Nicolas
 */
public class QuestionTrueFalse extends QuestionClasseIntermediaire{
    private String answerTrue; 
    private String answerFalse;
    
    public QuestionTrueFalse(){
        super();
        answerTrue="";
        answerFalse="";
    }
    
    public QuestionTrueFalse(String xml){
        super("","","","","","","","","");
        answerTrue="";
        answerFalse="";
    }
    
   public QuestionTrueFalse(String _name, String _questionTextFormat, String _questionTextText, String _generalFeedBack, String _shuffleAnswer, String _defaultGrade, String _penalty, String _hidden, String _image){
        super(_name,_questionTextFormat,_questionTextText,_generalFeedBack,_shuffleAnswer,_defaultGrade,_penalty,_hidden,_image);
        answerTrue="";
        answerFalse="";
   }
    
    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String getAnswerTrueFeedBack(){
        return answerTrue;
    }
    
    public String getAnswerFalseFeedBack(){
    	return answerFalse;
    }
    
    public void setAnswerTrueFeedBack(String _answer){
        answerTrue =_answer;
    }
    
    public void setAnswerFalseFeedBack(String _answer){
        answerTrue =_answer;
    }
}
