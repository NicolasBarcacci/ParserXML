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
public class QuestionDescription extends QuestionCloze{
    
    private String defaultGrade;
    private String penalty;
    private String hidden;
    
    public QuestionDescription(){
        super();
        defaultGrade="";
        penalty="";
        hidden="";
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
    	aTypeQuestion = new Attribute("type", "description");
		eQuestion.addAttribute(aTypeQuestion);
		
		if (this.defaultGrade!="") {
			Element eDefaultGrade = new Element("defaultgrade");
			eDefaultGrade.appendChild(this.defaultGrade);
			eQuestion.appendChild(eDefaultGrade);
		}
		
		if (this.hidden!="") {
			Element eHidden = new Element("hidden");
			eHidden.appendChild(this.hidden);
			eQuestion.appendChild(eHidden);
		}
		
		if (this.penalty!="") {
			Element ePenalty = new Element("penalty");
			ePenalty.appendChild(this.penalty);
			eQuestion.appendChild(ePenalty);
		}
	}
    




	public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
    
    public String getDefaulGrade(){
        return defaultGrade;
    }
    
    public String getPenalty(){
        return penalty;
    }
    
    public String getHidden(){
        return hidden;
    }
    
    public void setDefaultGrade(String _defaulGrade){
        defaultGrade=_defaulGrade;
    }
    
    public void setPenalty(String _Penalty){
        penalty=_Penalty;
    }
    
    public void setHidden(String _hidden){
        hidden=_hidden;
    }
}
