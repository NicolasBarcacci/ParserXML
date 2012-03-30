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
public class QuestionMatching extends QuestionClasseIntermediaire{
    private String[][] subquestion;
	
	public QuestionMatching(){
        super();
        subquestion = new String[4][2];
    }
    
   public String getSubquestionXText(int i){
	   if(i<4){
		   return subquestion[i][0];
	   }
	   else{
		   return "";
	   }
   }
   
   public String getSubquestionXAnswer(int i){
	   if(i<4){
		   return subquestion[i][1];
	   }
	   else{
		   return "";
	   }
   }
   
   public void setSubquestionXText(int i, String _text){
	   if(i<4){
		   subquestion[i][0]=_text;
	   }
   }
   public void setSubquestionXAnswer(int i, String _answer){
	   if(i<4){
		   subquestion[i][1]=_answer;
	   }
   }
   
   @Override
protected void addSpecificTags(Element eQuestion) {
	// TODO Auto-generated method stub
	super.addSpecificTags(eQuestion);
	//Suppression du type de la classe mère
		Attribute aTypeQuestion = eQuestion.getAttribute("type");
		if (aTypeQuestion!=null) {
			eQuestion.removeAttribute(aTypeQuestion);
		}
		//ajoute de son type
		aTypeQuestion = new Attribute("type", "matching");
		eQuestion.addAttribute(aTypeQuestion);
		
		for (int i = 0; i < this.subquestion.length; i++) {
			Element eAnswer = new Element("answer");
			eAnswer.appendChild(Quiz.getElementText(this.subquestion[i][1]));
			
			Element eSubquestion = new Element("answer");
			eSubquestion.appendChild(Quiz.getElementText(this.subquestion[i][0]));
			eSubquestion.appendChild(eAnswer);
			eQuestion.appendChild(eSubquestion);
		}
}
    
    public void importXML(Element _xml) {
		super.importXML(_xml);
		//TODO subquestion
		if (_xml.getChildElements("subquestion")!=null){
			for (int i = 0; i < _xml.getChildElements().size(); i++) {
				this.setSubquestionXText(i, _xml.getChildElements().get(i).getFirstChildElement("text").getValue());
				this.setSubquestionXAnswer(i, _xml.getChildElements().get(i).getFirstChildElement("answer").getFirstChildElement("text").getValue());
			}
		}
	}
}
