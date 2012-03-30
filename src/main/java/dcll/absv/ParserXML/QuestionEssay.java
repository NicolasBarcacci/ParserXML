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
public class QuestionEssay extends QuestionClasseIntermediaire{
    
	private String[] answer; //[fraction,text,feedback]
	
	public QuestionEssay(){
        super();
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
    protected void addSpecificTags(Element eQuestion) {
    	// TODO Auto-generated method stub
    	super.addSpecificTags(eQuestion);
    	Attribute aTypeQuestion = eQuestion.getAttribute("type");
    	if (aTypeQuestion!=null) {
    		eQuestion.removeAttribute(aTypeQuestion);
    	}
    	//ajoute de son type
    	aTypeQuestion = new Attribute("type", "essay");
    	eQuestion.addAttribute(aTypeQuestion);
    	
    	Attribute eFraction = new Attribute("fraction",this.answer[0]);
    	
    	Element eText = new Element("text");
    	eText.appendChild(this.answer[1]);
    	
    	Element eFeedbak = new Element("feedback");
    	eFeedbak.appendChild(Quiz.getElementText(this.answer[2]));
    	
    	Element eAnswer = new Element("answer");
    	eAnswer.addAttribute(eFraction);
    	eAnswer.appendChild(eText);
    	eAnswer.appendChild(eFeedbak);
    	eQuestion.appendChild(eAnswer);
    }
    
    public void importXML(Element _xml) {
		// TODO Auto-generated method stub
		
	}
}
