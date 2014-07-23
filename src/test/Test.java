package test;

import java.sql.Date;

import com.sanbao.it.ORM.Document;
import com.sanbao.it.service.UploadFile;
import com.sanbao.it.service.impl.UploadServiceImpl;

public class Test {
	public static void main(String[] args) {
		// 在数据库中存储对应的文件信息
		Document doc = new Document();
		// doc.setId(1);
		doc.setAuthor("admin");
		doc.setCategory("it");
		doc.setDocumentId(String.valueOf(System.currentTimeMillis() / 1000));
		doc.setDownloadcount(0);
		doc.setFilename("test1");
		doc.setFiletype("Doc");
		doc.setUploadtime(new Date(System.currentTimeMillis()));
		UploadFile upload = new UploadServiceImpl();
		upload.saveFile(doc);

	}
}
