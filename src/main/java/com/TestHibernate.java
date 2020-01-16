package com;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestHibernate {
	
	/** build: mvn clean install assembly:single*/
	public static void main(String[] args) {
		
		if(args.length < 4 || args[0] == null || args[1] == null || args[2] == null || args[3] == null) {
			System.out.println("Informe o host, porta, banco, usuário e a senha");
			return;
		}
		SessionFactory sf = HibernateUtil.buildSessionFactory(args[0], Integer.parseInt(args[1]), args[2], args[3], args[4]);
		Session session = sf.openSession();
		//session.beginTransaction();
		SQLQuery squery = session.createSQLQuery("select 1 from dual");
		Object o = squery.uniqueResult();
		//session.getTransaction().commit();
		HibernateUtil.shutdown(sf);
		System.out.println("Select concluído com sucesso: " + o);
	}

}
