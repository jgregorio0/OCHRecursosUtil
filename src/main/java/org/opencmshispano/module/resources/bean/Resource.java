package org.opencmshispano.module.resources.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sraposo on 07/05/2015.
 * Objeto que contiene toda la información necesaria de un recurso de OpenCms
 */
public class Resource {

	private String locale;
    private String title;
    private String path;
    private String resourceType;
    private List<Field> fields;

    public Resource() {
    }

    public Resource(String title, String path, String resourceType) {
        this.title = title;
        this.path = path;
        this.resourceType = resourceType;
    }

    public Resource(String title, String path, String resourceType, List<Field> fields) {
        this.title = title;
        this.path = path;
        this.resourceType = resourceType;
        this.fields = fields;
    }
    
    public Resource(Map data) {
    	this.title = (String)data.get("title");
        this.path = (String)data.get("path");
        this.resourceType = (String)data.get("resourceType");
        if(data.containsKey("locale"))
        	this.locale = (String)data.get("locale");        
        if(data.containsKey("fields") && data.get("fields")!=null){
        	 this.fields = new ArrayList<Field>();
        	List<Map> fieldsData = (List)data.get("fields");
        	for(Map dataField:fieldsData){
        		fields.add(new Field(dataField));
        	}
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

	@Override
	public String toString() {
		return "Resource [title=" + title + ", path=" + path
				+ ", resourceType=" + resourceType + ", fields=" + fields + "]";
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
    
    
}
