/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package com.ssrr.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResourceElement {
	@JsonProperty("resource")
	private Resource resource;

 	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Resource getResource() {
		return resource;
	}

}