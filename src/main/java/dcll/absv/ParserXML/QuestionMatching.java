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
    public Element toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void importXML(String _xml) {
		// TODO Auto-generated method stub
		
	}
}
