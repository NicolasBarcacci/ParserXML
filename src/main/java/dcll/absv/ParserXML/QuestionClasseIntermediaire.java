/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dcll.absv.ParserXML;

import nu.xom.Attribute;
import nu.xom.Element;

/**
 *
 * @author Nicolas
 */
public abstract class QuestionClasseIntermediaire extends QuestionDescription{
    
    private String image;
    
    public QuestionClasseIntermediaire(){
        super();
        image="";
    }
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String _image){
        image=_image;
    }
    
    @Override
    protected void addSpecificTags(Element eQuestion) {
    	// TODO Auto-generated method stub
    	super.addSpecificTags(eQuestion);

    	Attribute aTypeQuestion = eQuestion.getAttribute("type");
    	if (aTypeQuestion!=null) {
			eQuestion.removeAttribute(aTypeQuestion);
		}
    	
    	if (this.image!="") {
			Element eImage = new Element("image");
			eImage.appendChild(this.image);
			eQuestion.appendChild(eImage);
		}
    }
    

    @Override
    public void importXML(Element _xml) {
    	super.importXML(_xml);
    	
    	if(_xml.getFirstChildElement("image")!=null){
    		this.setImage(_xml.getFirstChildElement("image").getValue());
    	}
    	
    }
}
