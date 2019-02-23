package business_plan.liu_tristan;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.hamcrest.core.IsEqual;

public class Template
{

	String developerTemplateName;
	String userTemplateName;
	TemplateSection root;

	public Template(TemplateSection root)
	{
		this.root = root;
	}

	public Template deepCopy()
	{
		TemplateSection newRoot = root.deepCopy();
		Template deepCopy = new Template(newRoot);
		return deepCopy;
	}

	public void save()
	{
		XMLEncoder encoder =null;
		String fileName;
		if(userTemplateName.equals(developerTemplateName))
		{
			fileName = developerTemplateName;
		}
		else
		{
			fileName = userTemplateName;
		}
		fileName+=".xml";
		
		try
		{
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
		} 
		catch (FileNotFoundException fileNotFound)
		{
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		
		encoder.writeObject(this);
		encoder.close();

	}

	public static Template load(String name)
	{
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(name)));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File "+name+" not found");
		}
		Template loadTemplate = (Template)decoder.readObject();
		decoder.close();
		return loadTemplate;
	}

	/**
	 * @return the developerTemplateName
	 */
	public String getDeveloperTemplateName()
	{
		return developerTemplateName;
	}

	/**
	 * @param developerTemplateName the developerTemplateName to set
	 */
	public void setDeveloperTemplateName(String developerTemplateName)
	{
		this.developerTemplateName = developerTemplateName;
	}

	/**
	 * @return the userTemplateName
	 */
	public String getUserTemplateName()
	{
		return userTemplateName;
	}

	/**
	 * @param userTemplateName the userTemplateName to set
	 */
	public void setUserTemplateName(String userTemplateName)
	{
		this.userTemplateName = userTemplateName;
	}

	/**
	 * @return the root
	 */
	public TemplateSection getRoot()
	{
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(TemplateSection root)
	{
		this.root = root;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Template template)
	{
		// TODO Auto-generated method stub
		return this.developerTemplateName.equals(template.developerTemplateName)
				&& this.userTemplateName.equals(template.userTemplateName)
				&& this.root.equals(template.root);
		
	}

	
}
