package com.supinepandora43.graph_plugin;

import static org.junit.Assert.assertTrue;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

public class APKGraphPluginTest {
	@Test
	public void GraphTaskType() {
		Project project = ProjectBuilder.builder().build();
		project.getPluginManager().apply(APKGraphPlugin.class);
		assertTrue(project.getTasks().getByName("graph") instanceof GraphTask);
	}
}
