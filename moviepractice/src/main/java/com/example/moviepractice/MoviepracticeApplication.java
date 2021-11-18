package com.example.moviepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class MoviepracticeApplication {

	public static void main(String[] args) {

		SpringApplication.run(MoviepracticeApplication.class, args);

		//getting title input
		Scanner getTitle = new Scanner(System.in);
		System.out.println("Enter a title: ");
		String userTitle = getTitle.nextLine();
		getTitle.close();

	}

}
