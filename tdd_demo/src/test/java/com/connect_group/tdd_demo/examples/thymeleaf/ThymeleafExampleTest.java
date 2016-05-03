package com.connect_group.tdd_demo.examples.thymeleaf;

import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.hasAttribute;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.hasOnlyText;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.isSingleElementThat;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.connect_group.tdd_demo.config.SpringBootTestThymesheetContext;
import com.connect_group.thymeleaf.testing.ThymeleafTestEngine;
import com.connect_group.thymesheet.css.selectors.NodeSelectorException;
import com.connect_group.thymesheet.query.HtmlElements;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootTestThymesheetContext.class)
public class ThymeleafExampleTest {

	private static final String HTML_PATH = "thymeleaf-example/star-wars.html";

	@Autowired
	private ThymeleafTestEngine selectorEngine;

	@Before
	public void setUp() {
	}


	@Test
	public void shouldDisplayImage_WhenImageIsSet() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("image", "expected image");
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("img"), isSingleElementThat(hasAttribute("src", "expected image")));
	}
	
	@Test
	public void shouldDisplayQuote_WhenQuoteIsSet() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("quote", "expected quote");
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("h1"), isSingleElementThat(hasOnlyText("expected quote")));
	}
}
