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
public class QuestionShortAnswer extends QuestionClasseIntermediaire{

    private String[][] answer; //[fraction,text,feedback] pour chaque r�ponse
    
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
protected void addSpecificTags(Element eQuestion) {
	super.addSpecificTags(eQuestion);
	//Suppression du type de la classe mère
	Attribute aTypeQuestion = eQuestion.getAttribute("type");
	if (aTypeQuestion!=null) {
		eQuestion.removeAttribute(aTypeQuestion);
	}
	//ajoute de son type
	aTypeQuestion = new Attribute("type", "shortanswer");
	eQuestion.addAttribute(aTypeQuestion);
	
	// TODO Ajout des réponses
}

	public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
}
