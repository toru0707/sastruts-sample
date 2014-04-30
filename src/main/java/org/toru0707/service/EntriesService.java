package org.toru0707.service;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.service.S2AbstractService;
import org.toru0707.entity.Entries;

public class EntriesService extends S2AbstractService<Entries>{


	
	public Entries getEntryById(String id){
		return select().id(id).getSingleResult();
	}
}
