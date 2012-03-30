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
public class QuestionCalculated extends QuestionClasseIntermediaire{
    public QuestionCalculated(){
        super();
    }
    
    @Override
    protected void addSpecificTags(Element eQuestion) {
    	// TODO Auto-generated method stub
    	super.addSpecificTags(eQuestion);
    }
    
    public void importXML(Element _xml) {
		// TODO Auto-generated method stub
    	super.importXML(_xml);
		
	}
}
