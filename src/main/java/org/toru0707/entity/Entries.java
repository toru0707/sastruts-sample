package org.toru0707.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entries")
public class Entries {

	@Id
	public String id;
	
	@Column
	public String title;
	
}
