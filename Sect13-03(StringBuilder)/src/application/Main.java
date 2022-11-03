package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Main {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comment c1 = new Comment("Have a nive trip!");
		Comment c2 = new Comment("Wow, that's awesome!");
		
		Post p1 = new Post(
				sdf.parse("23/01/2022 17:25:33"),
				"Traveling to New York", 
				"I'm going to visit this amazing city!", 
				12);
		p1.addComment(c1);
		p1.addComment(c2);
		
		System.out.println(p1);
	}

}
