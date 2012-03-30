/*

 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

import java.util.Iterator;

import nu.xom.*;

/**
 *
 * @author Nicolas
 */
public class QuestionCloze implements IQuestion{
    private String name;
    private String[] questionText; //Un tableau de deux case, une pour indiquer le format (s'il y a) et une pour le texte
    private String generalFeedBack;
    private String shuffleAnswer;
    
    public QuestionCloze(){
        name="";
        questionText = new String[2];
        questionText[0]="";
        questionText[1]="";
        
    }
    
    public Element toXML() {
       Element eQuestion = new Element("question");
       
       Element eName = new Element("name");
	   eName.appendChild(Quiz.getElementText(this.name));
	   eQuestion.appendChild(eName);
	   
	   Element eQuestionText = new Element("questiontext");
	   if (this.questionText[0]!="") {
		Attribute aFormatQuestionText = new Attribute("format",this.questionText[0]);
		eQuestionText.addAttribute(aFormatQuestionText);
	   }
	   eQuestionText.appendChild(Quiz.getElementText(this.questionText[1]));
	   eQuestion.appendChild(eQuestionText);
       
       
       Element eGeneralFeedback;
       if (this.generalFeedBack!="") {
		eGeneralFeedback = new Element("generalfeedback");
		eGeneralFeedback.appendChild(Quiz
				.getElementText(this.generalFeedBack));
		eQuestion.appendChild(eGeneralFeedback);
       }
       
       if (this.shuffleAnswer!="") {
		Element eShuffleAnswer = new Element("shuffleanswer");
		eShuffleAnswer.appendChild(this.shuffleAnswer);
		eQuestion.appendChild(eShuffleAnswer);
	}
       
       
       this.addSpecificTags(eQuestion);
       
       return eQuestion;
    }

	protected void addSpecificTags(Element eQuestion) {
		//Ajout d'élément spécifiques à la question
		 Attribute aTypeQuestion = new Attribute("type","cloze");
	     eQuestion.addAttribute(aTypeQuestion);
		
	}

    
    public void importXML(Element _xml) {
    	if (_xml.getFirstChildElement("name")!=null) {
			this.setName(_xml.getFirstChildElement("name").getValue());
		}
    	if (_xml.getFirstChildElement("generalfeedback")!=null) {
			this.setGeneralFeedBack(_xml.getFirstChildElement("generalfeedback").getFirstChildElement("text").getValue());
		}
    	if (_xml.getFirstChildElement("shuffleanswer")!=null) {
    		this.setShuffleAnswer(_xml.getFirstChildElement("shuffleanswer").getValue());
    	}
    	if (_xml.getFirstChildElement("questiontext")!=null) {
    		if (_xml.getFirstChildElement("questiontext")
						.getAttributeValue("format")!=null) {
				this.setQuestionText(_xml.getFirstChildElement("questiontext")
						.getAttributeValue("format"));
			}
    		this.setQuestionTextText(_xml.getFirstChildElement("questiontext").getFirstChildElement("text").getValue());
    	}
    	
	}
    
    public String getName(){
        return name;
    }
    
    public String getQuestionTextFormat(){
        return questionText[0];
    }
    
    public String getQuestionTextText(){
        return questionText[1];
    }
    
    public String getGeneralFeedBack(){
        return generalFeedBack;
    }
    
    public String getShuffleAnswer(){
        return shuffleAnswer;
    }
    
    public void setName(String _name){
        name=_name;
    }
    
    public void setQuestionText(String _questionTextFormat){
        questionText[0]=_questionTextFormat;
    }
    
    public void setQuestionTextText(String _questionTextText){
        questionText[1]=_questionTextText;
    }
        
    public void setGeneralFeedBack(String _generalFeedBack){
        generalFeedBack=_generalFeedBack;
    }
    
    public void setShuffleAnswer(String _shuffleAnswer){
        shuffleAnswer=_shuffleAnswer;
    }
}
