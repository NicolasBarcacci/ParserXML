/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

import nu.xom.Element;

/**
 *
 * @author Nicolas
 */
public class QuestionCategory implements IQuestion{
    private String category;
    
    public QuestionCategory(){
        category="";
    }
    
    public QuestionCategory(String xml){
        
    }
    
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String _category){
        category=_category;
    }

    public Element toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
    
}
