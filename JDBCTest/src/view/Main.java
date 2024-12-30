package view;

import java.sql.Date;


import model.ModelException;
import model.dao.DAOFactory;
import model.dao.PostDAO;
import model.dao.UserDAO;
import model.entities.Post;
import model.entities.User;

public class Main {
	public static void main(String[] args) throws ModelException {
		User emerson = new User(6);
		emerson.setName("Emerson DAO Novo");
		emerson.setEmail("emerson.novo@mail.com");
		emerson.setSex('M');
		
		UserDAO dao = (UserDAO) DAOFactory.getDAO(UserDAO.class);
		
		dao.save(emerson);
		
		User user = null;
		try {
			user = dao.findById(6);
		} catch (ModelException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getMessage());
			e.getCause().printStackTrace();
		}
		
		if (user != null) {
			System.out.println("Id: " + user.getId());
			System.out.println("Nome: " + user.getName());
			System.out.println("Sexo: " + user.getSex());
			System.out.println("Email: " + user.getEmail());
			System.out.println();
		}
		
		Post post1 = new Post(6);
		post1.setContent("Poste Novo");
		post1.setDate(Date.valueOf("2024-11-10"));
		post1.setUserId(emerson);
		
		PostDAO postDAO = (PostDAO) DAOFactory.getDAO(PostDAO.class);
		
		postDAO.save(post1);

		Post post = null;

		try {

			post = postDAO.findById(6);

		} catch (ModelException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getMessage());
			e.getCause().printStackTrace();
		}

		if (post != null) {
			System.out.println("Id: " + post.getId());
			System.out.println("Legenda: " + post.getContent());
			System.out.println("Data: " + post.getDate().toString());
			System.out.println("Usuario: " + post.getUserId().getName());
			System.out.println();
		}

	}
}
