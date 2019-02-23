package business_plan.liu_tristan;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		
	}

}
