package business_plan.liu_tristan;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.RootPaneContainer;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

class TemplateTest
{

	
	void testConstructor()
	{
		TemplateSection root = new TemplateSection("Vision","Vision");
		root.addChild(new TemplateSection("Mission", "Mission"));
		Template template = new Template(root);
		assertEquals(root, template.root);
		
		template.setDeveloperTemplateName("VMOSA");
		assertEquals("VMOSA", "VMOSA");
		
		template.setUserTemplateName("myTemplate");
		assertEquals("myTemplate", template.userTemplateName);	
	}
	
	void testDeepCopy()
	{
		TemplateSection root = new TemplateSection("Vision","Vision");
		root.addChild(new TemplateSection("Mission", "Mission"));
		Template template = new Template(root);
		Template template2 = template.deepCopy();
		assertEquals(template, template2);
		assert template != template2;
	
		
		
	}
	void testSave()
	{
		TemplateSection root = new TemplateSection("Vision","Vision");
		root.addChild(new TemplateSection("Mission", "Mission"));
		Template template = new Template(root);
		template.setDeveloperTemplateName("VMOSA");
		template.setUserTemplateName("VMOSA");
		template.save();
		Template template2 = Template.load("VMOSA.xml");
		assertEquals(template, template2);
		
	}
	
	void testEquals()
	{
		Template t1 = null;
		Template t2 = null;
		assertEquals(t1, t2);
		
		TemplateSection root1 = new TemplateSection("Vision", "Vision");
		TemplateSection root2 = new TemplateSection("Mission", "Mission");
		
		String dName1 = "VMOSA";
		String dName2 = "Centre";
		
		String uName1 = "myTemplate";
		String uName2 = "yourTemplate";
				
		t1 = new Template(root1);
		t1.setDeveloperTemplateName(dName1);
		t1.setUserTemplateName(uName1);
		
		t2 = new Template(root1);
		t2.setDeveloperTemplateName(dName1);
		t2.setUserTemplateName(uName1);
		//Root, DeveloperTemplateName, UserTemplateName all the same
		assertEquals(t1, t2);
		
		//root is different
		t2.setRoot(root2);
		assertNotEquals(t1, t2);
		
		//DeveloperTemplateName is different
		t2.setRoot(root1);
		t2.setDeveloperTemplateName(dName2);
		assertNotEquals(t1, t2);
		
		//UserTemplateName is different
		t2.setDeveloperTemplateName(dName1);
		t2.setUserTemplateName(uName2);
		assertNotEquals(t1, t2);
		
		//both UserTemplateName and UserTemplateName are different
		t2.setDeveloperTemplateName(dName2);
		assertNotEquals(t1, t2);
		
		
 	}

}
