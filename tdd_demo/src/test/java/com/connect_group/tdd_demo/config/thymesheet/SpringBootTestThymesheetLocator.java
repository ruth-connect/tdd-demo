package com.connect_group.tdd_demo.config.thymesheet;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.thymeleaf.dom.Document;

import com.connect_group.thymesheet.ThymesheetLocator;
import com.connect_group.thymesheet.impl.HtmlThymesheetLocator;

public class SpringBootTestThymesheetLocator extends HtmlThymesheetLocator implements ThymesheetLocator {

	private static final Logger log = Logger.getLogger(SpringBootTestThymesheetLocator.class);

	private static final String DEFAULT_PREFIX = "src/main/resources/templates/";
	private static final String DEFAULT_SUFFIX = ".tss";
	
	private final Set<String> thymesheetSuffixes = new HashSet<String>();
	
	@Override
	public List<String> getThymesheetPaths(Document document) {
		String path = document.getDocumentName();
		List<String> thymesheetPaths = getThymesheetPaths(path);
		thymesheetPaths.addAll(super.getThymesheetPaths(document));
		
		if (log.isInfoEnabled()) {
			log.info("getThymesheetPaths called");
			for (String thymesheetPath : thymesheetPaths) {
				log.info("Thymesheet Path: " + thymesheetPath);
			}
		}
		
		return thymesheetPaths;
	}
	
	@Override
	public void removeThymesheetLinks(Document document) {
	}
	
	public void addThymesheetSuffix(String suffix) {
		if (suffix != null) {
			if (suffix.startsWith("*")) {
				suffix = suffix.substring(1);
			}
			thymesheetSuffixes.add(suffix);
		}
	}
	
	protected boolean isPathWithThymesheetSuffix(String path) {
		boolean result = false;
		if (path != null && path.length() > 0) {
			if (thymesheetSuffixes != null && !thymesheetSuffixes.isEmpty()) {
				for (String suffix : thymesheetSuffixes) {
					if (path.endsWith(suffix)) {
						result = true;
						break;
					}
				}
			} else {
				result = path.endsWith(DEFAULT_SUFFIX);
			}
		}
		return result;
	}
	
	private List<String> getThymesheetPaths(String documentPath) {
		String thymesheetPath = documentPath.replace(".html", ".tss");
		File file = new File(DEFAULT_PREFIX + thymesheetPath);
		if (file.exists()) {
			if (log.isInfoEnabled()) {
				log.info("Found Thymesheet file: " + thymesheetPath);
			}
			return Collections.singletonList(thymesheetPath);
		} else {
			if (log.isInfoEnabled()) {
				log.info("Thymesheet file not present: " + thymesheetPath);
			}
			return Collections.emptyList();
		}
	}
}
