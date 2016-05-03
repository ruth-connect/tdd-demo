package com.connect_group.tdd_demo.examples.mockito;

import java.util.List;

public interface WebServiceExample {

	public List<Film> getFilms() throws NotFoundException;
}
