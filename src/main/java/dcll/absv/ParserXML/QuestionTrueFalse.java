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
    public Element toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
    
    public String getAnswerTrueFeedBack(){
        return answerTrue;
    }
    
    public String getAnswerFalseFeedBack(){
    	return answerFalse;
    }
    
    public void setAnswerTrueFeedBack(String _answer){
        answerTrue =_answer;
    }
    
    public void setAnswerFalseFeedBack(String _answer){
        answerTrue =_answer;
    }
}
