/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

import nu.xom.*;


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
    public Element toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
}
