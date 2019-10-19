package com.example.demo.controller;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.classes.items;

@RestController
public class ItemsContoller {
	Configuration con;
	ServiceRegistry sr;
	SessionFactory sf;
	Session session;
	Transaction tx;
	
	public ItemsContoller() {
		con = new Configuration().configure().addAnnotatedClass(items.class);
		sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		sf = con.buildSessionFactory(sr);
		session = sf.openSession();
		tx = session.beginTransaction();
		tx.commit();
	}

	@CrossOrigin(origins = "http://172.17.0.3:3000")
	@PostMapping(path = "/addItem", consumes = "application/json")
	public items addItem(@RequestBody items item) {
		session = sf.openSession();
		tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		return item;
	}

}