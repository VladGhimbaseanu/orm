package com.unitbv.projectejb;

import javax.ejb.Remote;

@Remote
public interface ProjectStatelessEbjRemote {

	void insert(String name);
	
}
