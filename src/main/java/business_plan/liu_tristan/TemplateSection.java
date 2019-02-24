package business_plan.liu_tristan;
import java.util.ArrayList;

public class TemplateSection
{
	TemplateSection parent;
	ArrayList<TemplateSection> children;
	double childLimit;
	String category;
	String name;
	ArrayList<Content> contents;
	
	/**
	 * @param category
	 * @param name
	 */
	public TemplateSection(String category, String name)
	{
		
		this.category = category;
		this.name = name;
		children = new ArrayList<TemplateSection>();
		contents = new ArrayList<Content>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(TemplateSection t)
	{
		if(!this.category.equals(t.category)
			|| !this.name.equals(t.name)
			||  children.size() != t.children.size()
			|| contents.size() != t.contents.size())
		{
			return false;
		}
		
		for(int i=0; i< this.children.size();i++)
		{
			if(!children.get(i).equals(t.children.get(i)))
			{
				return false;
			}
		}
		
		for(int i=0; i<contents.size();i++)
		{
			if(contents.get(i).equals(t.contents.get(i)))
			{
				return false;
			}
		}
		return true;
	}

	public void addContent(Content c)
	{
		contents.add(c);
	}
	
	public void addChild(TemplateSection child)
	{
		children.add(child);
	}

	public TemplateSection deepCopy()
	{
		TemplateSection deepCopy = new TemplateSection(this.category, this.name);
		deepCopy.setParent(parent);
		deepCopy.setChildLimit(childLimit);
		for(int i=0; i<children.size(); i++)
		{
			deepCopy.children.add(this.children.get(i).deepCopy());
		}
		
		for(Content content : contents)
		{
			deepCopy.contents.add(content.deepCopy());
		}
		return deepCopy;
	}
	
	/**
	 * @return the parent
	 */
	public TemplateSection getParent()
	{
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(TemplateSection parent)
	{
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public ArrayList<TemplateSection> getChildren()
	{
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<TemplateSection> children)
	{
		this.children = children;
	}

	/**
	 * @return the childLimit
	 */
	public double getChildLimit()
	{
		return childLimit;
	}

	/**
	 * @param childLimit the childLimit to set
	 */
	public void setChildLimit(double childLimit)
	{
		this.childLimit = childLimit;
	}

	/**
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the contents
	 */
	public ArrayList<Content> getContents()
	{
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(ArrayList<Content> contents)
	{
		this.contents = contents;
	}
}
