/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

/**
 *
 * @author Nicolas
 */
public class QuestionShortAnswer extends QuestionClasseIntermediaire{

    private String[][] answer; //[fraction,text,feedback] pour chaque réponse
    
    public QuestionShortAnswer(){
        super();
        answer = new String[2][3];
    }
    
   public String getAnswerXFraction(int i){
	   if(i<2){
		   return answer[i][0];   
	   }
	   else{
		   return "";
	   }
   }
   public String getAnswerXText(int i){
	   if(i<2){
		   return answer[i][1];   
	   }
	   else{
		   return "";
	   }
   }
   public String getAnswerXFeedback(int i){
	   if(i<2){
		   return answer[i][2];   
	   }
	   else{
		   return "";
	   }
   }
   
   
   public void setAnswerXFraction(int i, String _fraction){
	   if(i<2){
		   answer[i][0]=_fraction;   
	   }
   }
   public void setAnswerXText(int i, String _text){
	   if(i<2){
		   answer[i][1]=_text;   
	   }
   }
   public void setAnswerXFeedback(int i, String _feedback){
	   if(i<2){
		   answer[i][2]=_feedback;   
	   }
   }

    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
}
