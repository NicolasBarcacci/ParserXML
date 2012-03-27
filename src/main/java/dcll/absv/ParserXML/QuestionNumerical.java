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
protected void addSpecificTags(Element eQuestion) {
	// TODO Auto-generated method stub
	super.addSpecificTags(eQuestion);
	Attribute aTypeQuestion = eQuestion.getAttribute("type");
	if (aTypeQuestion!=null) {
		eQuestion.removeAttribute(aTypeQuestion);
	}
	//ajoute de son type
	aTypeQuestion = new Attribute("type", "numerical");
	eQuestion.addAttribute(aTypeQuestion);
	
	Attribute eFraction = new Attribute("fraction",this.answer[0]);
	
	Element eText = new Element("text");
	eText.appendChild(this.answer[1]);
	
	Element eTolerance = new Element("tolerance");
	eTolerance.appendChild(this.answer[2]);
	
	Element eFeedbak = new Element("feedback");
	eFeedbak.appendChild(QuestionCloze.getElementText(this.answer[3]));
	
	Element eAnswer = new Element("answer");
	eAnswer.addAttribute(eFraction);
	eAnswer.appendChild(eText);
	eAnswer.appendChild(eFeedbak);
	eQuestion.appendChild(eAnswer);
}
    
    public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
}
