package test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sanbao.it.ORM.User;
import com.sanbao.it.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
//		// 在数据库中存储对应的文件信息
//		Document doc = new Document();
//		// doc.setId(1);
//		doc.setAuthor("admin");
//		doc.setCategory("it");
//		doc.setDocumentId(String.valueOf(System.currentTimeMillis() / 1000));
//		doc.setDownloadcount(0);
//		doc.setFilename("test1");
//		doc.setFiletype("Doc");
//		doc.setUploadtime(new Date(System.currentTimeMillis()));
//		UploadFile upload = new UploadServiceImpl();
//		upload.saveFile(doc);
		
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("user_id", "10097"));
		User user = (User)criteria.uniqueResult();
//		User user = (User)session.get(User.class, 1);
		HibernateUtil.close(session);
		System.out.println(user.getPassword());
	}
}
