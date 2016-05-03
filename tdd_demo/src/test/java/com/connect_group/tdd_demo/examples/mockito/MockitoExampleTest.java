package com.connect_group.tdd_demo.examples.mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MockitoExampleTest {
	
	private WebServiceExample webService;
	private MockitoExample example;
	
	@Before
	public void setUp() throws Exception {
		webService = mock(WebServiceExample.class);
		example = new MockitoExample();
		example.setWebService(webService);
	}

	@Test
	public void shouldReturnErrorMessage_WhenNotFoundExceptionIsThrown() throws Exception {
		when(webService.getFilms()).thenThrow(new NotFoundException());
		assertThat(example.getFilms(), equalTo("These are not the films you are looking for"));
	}
	
	@Test
	public void shouldReturnExpectedFilms_WhenWebServiceIsInvoked() throws Exception {
		when(webService.getFilms()).thenReturn(getFilms());
		assertThat(example.getFilms(), equalTo("The Phantom Menace, Attack of the Clones, Revenge of the Sith, A New Hope, The Empire Strikes Back, Return of the Jedi, The Force Awakens"));
	}
	
	private List<Film> getFilms() {
		return Arrays.asList(new Film("The Phantom Menace"),
							 new Film("Attack of the Clones"),
							 new Film("Revenge of the Sith"),
							 new Film("A New Hope"),
							 new Film("The Empire Strikes Back"),
							 new Film("Return of the Jedi"),
							 new Film("The Force Awakens"));
	}
}
