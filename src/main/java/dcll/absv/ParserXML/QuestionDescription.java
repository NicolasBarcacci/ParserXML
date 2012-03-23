/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

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
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet.");
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
