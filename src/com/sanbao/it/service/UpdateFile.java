package com.sanbao.it.service;

import com.sanbao.it.ORM.Document;

public interface UpdateFile {
	public void updateFile(Document doc);
	
	public void deleteFile(String documentId);
}
