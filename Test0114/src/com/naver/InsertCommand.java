package com.naver;

import java.util.Scanner;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		
		MemberDAO dao = new MemberDAO();
		
		System.out.println("insert id");
		String id = sc.nextLine();
		
		System.out.println("insert name");
		String name = sc.nextLine();
		
		System.out.println("insert age");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("insert did");
		String did = sc.nextLine();
		
		dao.insert(new MemberDTO(id, name, age));
		
	}
}
