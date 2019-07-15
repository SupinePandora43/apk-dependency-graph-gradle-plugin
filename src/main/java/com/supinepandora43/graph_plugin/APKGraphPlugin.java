package com.supinepandora43.graph_plugin;

import org.gradle.api.*;

/**
 * some javadoc
 */
class APKGraphPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		project.getTasks().create("graph", GraphTask.class);
	}

}
