/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

/**
 *
 * @author Nicolas
 */
public class QuestionNumerical extends QuestionClasseIntermediaire{
    
	private String[] answer; //[fraction,text,tolerance,feedback]
	
    public QuestionNumerical(){
        super();
        answer = new String[4];
    }
    
    public QuestionNumerical(String xml){
        super("","","","","","","","","");
        answer = new String[4];
    }
    
   public QuestionNumerical(String _name, String _questionTextFormat, String _questionTextText, String _generalFeedBack, String _shuffleAnswer, String _defaultGrade, String _penalty, String _hidden, String _image){
        super(_name,_questionTextFormat,_questionTextText,_generalFeedBack,_shuffleAnswer,_defaultGrade,_penalty,_hidden,_image);
        answer = new String[4];
   }
    
   public String getAnswerFraction(){
	   return answer[0];
   }
   
   public String getAnswerText(){
	   return answer[1];
   }
   
   public String getAnswerTolerance(){
	   return answer[2];
   }
   
   public String getAnswerfeedBack(){
	   return answer[3];
   }
   
   public void setAnswerFraction(String _fraction){
	   answer[0]=_fraction;
   }
   
   public void setAnswerText(String _text){
	   answer[1]=_text;
   }
   
   public void setAnswerTolerance(String _tolerance){
	   answer[2]=_tolerance;
   }
   
   public void setAnswerfeedBack(String _feedBack){
	   answer[3]=_feedBack;
   }
   
    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
