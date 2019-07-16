package com.supinepandora43.graph_plugin;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class APKGraphPluginTest {
	private Project project;

	public APKGraphPluginTest() {
		this.project = ProjectBuilder.builder().build();
		this.project.getPluginManager().apply(APKGraphPlugin.class);
		//((DefaultProject) this.project).evaluate();
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
