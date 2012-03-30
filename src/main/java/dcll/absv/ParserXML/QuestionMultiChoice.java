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
    private String correctFeedBack;
    private String partiallyCorrectFeedBack;
    private String incorrectFeedBack;
    private String answernumbering;
    
    private String[][] answer; //[fraction,text,feedback] pour chaque question
    
    
    public QuestionMultiChoice(){
        super();
        answer = new String[4][3];
    }

    
    
   public void setImage64(String image64) {
		this.image64 = image64;
	}



	public void setSingle(String single) {
		this.single = single;
	}


	public void setCorrectFeedBack(String correctFeedBack) {
		this.correctFeedBack = correctFeedBack;
	}



	public void setPartiallyCorrectFeedBack(String partiallyCorrectFeedBack) {
		this.partiallyCorrectFeedBack = partiallyCorrectFeedBack;
	}



	public void setIncorrectFeedBack(String incorrectFeedBack) {
		this.incorrectFeedBack = incorrectFeedBack;
	}



	public void setAnswernumbering(String answernumbering) {
		this.answernumbering = answernumbering;
	}



public String getImage64(){
	   return image64;
   }
   
   public String getSingle(){
	   return single;
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
    	//récupere les tags de la/les classe(s) mère(s)
    	super.addSpecificTags(eQuestion);
    	//Suppression du type de la classe mère
    	Attribute aTypeQuestion = eQuestion.getAttribute("type");
    	if (aTypeQuestion!=null) {
			eQuestion.removeAttribute(aTypeQuestion);
		}
    	//ajout de son type
    	aTypeQuestion = new Attribute("type", "multichoice");
		eQuestion.addAttribute(aTypeQuestion);
       
       if (this.image64!="") {
		Element eImage64 = new Element("image64");
		eImage64.appendChild(image64);
		eQuestion.appendChild(eImage64);
	}
       if (this.correctFeedBack!="") {
		Element eCorrectFeedBack = new Element("correctfeedback");
		eCorrectFeedBack.appendChild(this.correctFeedBack);
		eQuestion.appendChild(eCorrectFeedBack);
	}
       
       if (this.partiallyCorrectFeedBack!="") {
		Element ePartiallyCorrectFeedBack = new Element("partiallyCorrectFeedBack");
		ePartiallyCorrectFeedBack.appendChild(partiallyCorrectFeedBack);
		eQuestion.appendChild(ePartiallyCorrectFeedBack);
	}
       
       if (this.incorrectFeedBack!="") {
		Element eIncorrectFeedBack = new Element("incorrectfeedback");
		eIncorrectFeedBack.appendChild(incorrectFeedBack);
		eQuestion.appendChild(eIncorrectFeedBack);
	}
       if (this.answernumbering!="") {
		Element eAnswernumbering = new Element("answernumbering");
		eAnswernumbering.appendChild(answernumbering);
		eQuestion.appendChild(eAnswernumbering);
	}
       
       

   	for (int i = 0; i < this.answer.length; i++) {
   		Attribute eFraction = new Attribute("fraction",this.answer[i][0]);
   		Element eText = new Element("text");
   		eText.appendChild(this.answer[i][1]);
   		Element eFeedbak = new Element("feedback");
   		eFeedbak.appendChild(this.answer[i][2]);
   		
   		Element eAnswer = new Element("answer");
   		eAnswer.addAttribute(eFraction);
   		eAnswer.appendChild(eText);
   		eAnswer.appendChild(eFeedbak);
   		eQuestion.appendChild(eAnswer);
   	}
	}

    @Override
	public void importXML(Element _xml) {
		// TODO Auto-generated method stub
		super.importXML(_xml);
		if (_xml.getFirstChildElement("image64")!=null) {
			this.setImage64(_xml.getFirstChildElement("image64").getValue());
		}
		if (_xml.getFirstChildElement("single")!=null) {
			this.setSingle(_xml.getFirstChildElement("single").getValue());
		}
		if (_xml.getFirstChildElement("correctfeedback")!=null) {
			this.setCorrectFeedBack(_xml.getFirstChildElement("correctfeedback").getValue());
		}
		if (_xml.getFirstChildElement("incorrectfeedback")!=null) {
			this.setIncorrectFeedBack(_xml.getFirstChildElement("incorrectfeedback").getValue());
		}
		if (_xml.getFirstChildElement("partiallycorrectfeedback")!=null) {
			this.setPartiallyCorrectFeedBack(_xml.getFirstChildElement("partiallycorrectfeedback").getValue());
		}
		if (_xml.getFirstChildElement("answernumbering")!=null) {
			this.setAnswernumbering(_xml.getFirstChildElement("answernumbering").getValue());
		}
		this.answer = new String[_xml.getChildElements("answer").size()][3];
		for (int i = 0; i < _xml.getChildElements("answer").size(); i++) {
			this.setAnswerXFraction(i, _xml.getChildElements("answer").get(i).getAttributeValue("fraction"));
			this.setAnswerXText(i, _xml.getChildElements("answer").get(i).getFirstChildElement("text").getValue());
			this.setAnswerXFeedBack(i, _xml.getChildElements("answer").get(i).getFirstChildElement("feedback").getFirstChildElement("text").getValue());
		}
	}
}
