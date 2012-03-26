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
public class QuestionMultiChoice extends QuestionClasseIntermediaire{
    
    private String image64;
    private String single;
    private String shuffleAnswer2;
    private String correctFeedBack;
    private String partiallyCorrectFeedBack;
    private String incorrectFeedBack;
    private String answernumbering;
    
    private String[][] answer; //[fraction,text,feedback] pour chaque question
    
    
    public QuestionMultiChoice(){
        super();
        answer = new String[4][3];
    }

   public String getImage64(){
	   return image64;
   }
   
   public String getSingle(){
	   return single;
   }
   
   public String getShuffleAnswer2(){
	   return shuffleAnswer2;
   }
   
   public String getCorrectFeedBack(){
	   return correctFeedBack;
   }
   
   public String getPartiallyCorrectFeedBack(){
	   return partiallyCorrectFeedBack;
   }
   
   public String getIncorrectFeedBack(){
	   return incorrectFeedBack;
   }
   
   public String getAnswernumbering(){
	   return answernumbering;
   }
   
   public String getAnswerXFraction(int i){
	   if(i<4){
		   return answer[i][0];
	   }
	   else{
		   return "";
	   }
   }
   
   public String getAnswerXText(int i){
	   if(i<4){
		   return answer[i][1];
	   }
	   else{
		   return "";
	   }
   }
   
   public String getAnswerXFeedBack(int i){
	   if(i<4){
		   return answer[i][2];
	   }
	   else{
		   return "";
	   }
   }
   
   public void setAnswerXFraction(int i, String _fraction){
	   if(i<4){
		   answer[i][0]=_fraction;
	   }
   }
   public void setAnswerXText(int i, String _text){
	   if(i<4){
		   answer[i][1]=_text;
	   }
   }
   public void setAnswerXFeedBack(int i, String _feedBack){
	   if(i<4){
		   answer[i][2]=_feedBack;
	   }
   }
   
    
    
    @Override
	protected void addSpecificTags(Element eQuestion) {
    	   Attribute aTypeQuestion = new Attribute("type", "multichoice");
           eQuestion.addAttribute(aTypeQuestion);
           
           if (this.image64!="") {
   			Element eImage64 = new Element("image64");
   			eImage64.appendChild(image64);
   			eQuestion.appendChild(eImage64);
   		}
           if (this.correctFeedBack!="") {
   			Element eCorrectFeedBack;
   		}
	}

	public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
}
