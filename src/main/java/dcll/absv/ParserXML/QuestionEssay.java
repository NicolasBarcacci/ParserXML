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
    
	private String[] answer; //[fraction,feedback]
	
	public QuestionEssay(){
        super();
        answer = new String[2];
    }
    
    public QuestionEssay(String xml){
        super("","","","","","","","","");
        answer = new String[2];
    }
    
   public QuestionEssay(String _name, String _questionTextFormat, String _questionTextText, String _generalFeedBack, String _shuffleAnswer, String _defaultGrade, String _penalty, String _hidden, String _image){
        super(_name,_questionTextFormat,_questionTextText,_generalFeedBack,_shuffleAnswer,_defaultGrade,_penalty,_hidden,_image);
        answer = new String[2];
   }
    
   public String getAnswerFraction(){
	   return answer[0];
   }
   
   public String getAnswerFeedBack(){
	   return answer[1];
   }
   
   public void setAnswerFraction(String _fraction){
	   answer[0]=_fraction;
   }
   
   public void setAnswerFeedBack(String _feedBack){
	   answer[0]=_feedBack;
   }
   
    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
