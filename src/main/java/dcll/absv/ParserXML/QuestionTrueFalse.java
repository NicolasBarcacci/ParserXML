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
public class QuestionTrueFalse extends QuestionClasseIntermediaire{
    private String answerTrue; 
    private String answerFalse;
    
    public QuestionTrueFalse(){
        super();
        answerTrue="";
        answerFalse="";
    }
    
    @Override
	protected void addSpecificTags(Element eQuestion) {

    	 Attribute aTypeQuestion = new Attribute("type","truefalse");
         eQuestion.addAttribute(aTypeQuestion);
         
         Element eFeedbackCorrect = new Element("feedback");
         eFeedbackCorrect.appendChild(Quiz.getElementText("Correct !"));
         
         Element eFeedbackWrong = new Element("feedback");
         eFeedbackWrong.appendChild(Quiz.getElementText("Oops !"));
         
         Element eTrue = new Element("true");
         eTrue.appendChild(Quiz.getElementText("true"));
        
         Element eFalse = new Element("false");
         eFalse.appendChild(Quiz.getElementText("false"));

         
         if (this.answerTrue=="100") {
         	Attribute aTrueFraction = new Attribute("fraction","100");
             Attribute aFalseFraction = new Attribute("fraction","0");
 			eTrue.appendChild(eFeedbackCorrect);
 			eFalse.appendChild(eFeedbackWrong);
 	        eTrue.addAttribute(aTrueFraction);
 	        eFalse.addAttribute(aFalseFraction);
 		} else {
 			Attribute aTrueFraction = new Attribute("fraction","0");
            Attribute aFalseFraction = new Attribute("fraction","100");
 			eTrue.appendChild(eFeedbackWrong);
 			eFalse.appendChild(eFeedbackCorrect);
 	        eTrue.addAttribute(aTrueFraction);
 	        eFalse.addAttribute(aFalseFraction);
 		}
         
         eQuestion.appendChild(eFalse);
 		eQuestion.appendChild(eTrue);
	}

	public void importXML(Element _xml) {
		// TODO Auto-generated method stub
		super.importXML(_xml);
		if (_xml.getChildElements("answer").size()==2 ) {
			if (_xml.getChildElements("answer").get(0).getFirstChildElement("text").getValue()=="true") {
			this.setAnswerTrue(_xml.getChildElements("answer").get(0).getAttributeValue("fraction"));
			this.setAnswerFalse(_xml.getChildElements("answer").get(1).getAttributeValue("fraction"));
			} else {

				this.setAnswerTrue(_xml.getChildElements("answer").get(1).getAttributeValue("fraction"));
				this.setAnswerFalse(_xml.getChildElements("answer").get(0).getAttributeValue("fraction"));
			}
		}
	}
    
    public String getAnswerTrue(){
        return answerTrue;
    }
    
    public String getAnswerFalse(){
    	return answerFalse;
    }
    
    public void setAnswerTrue(String _answer){
        answerTrue =_answer;
    }
    
    public void setAnswerFalse(String _answer){
        answerTrue =_answer;
    }
}
