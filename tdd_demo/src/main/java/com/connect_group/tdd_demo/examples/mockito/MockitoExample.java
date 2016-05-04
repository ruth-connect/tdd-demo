package com.connect_group.tdd_demo.examples.mockito;

import java.util.List;

public class MockitoExample {

	private WebServiceExample webService;
	
	public void setWebService(WebServiceExample webService) {
		this.webService = webService;
	}
	
	public String getFilms() {
		try {
			StringBuilder stringBuilder = new StringBuilder();
			List<Film> films = webService.getFilms();
			for (int i = 0; i < films.size(); i++) {
				stringBuilder.append(films.get(i).getTitle());
				if (i < films.size() - 1) {
					stringBuilder.append(", ");
				}
			}
			return stringBuilder.toString();
		} catch (NotFoundException ex) {
			return "These are not the films you are looking for";
		}
	}
}
