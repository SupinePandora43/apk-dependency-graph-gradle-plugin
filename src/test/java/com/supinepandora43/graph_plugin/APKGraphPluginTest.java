package com.supinepandora43.graph_plugin;

import static org.junit.Assert.assertTrue;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Before;
import org.junit.Test;

public class APKGraphPluginTest {
	private Project project = null;
	@Before
	public void setUp() {
		this.project = ProjectBuilder.builder().build();
		this.project.getPluginManager().apply(APKGraphPlugin.class);
	}
	@Test
	public void GraphTaskType() {
		assertTrue(this.project.getTasks().getByName("graph") instanceof GraphTask);
	}

	@Test
	public void GraphExtensionType() {
		assertTrue(this.project.getExtensions().getByName("graph") instanceof GraphExtension);
	}


}
