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

	public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
}
