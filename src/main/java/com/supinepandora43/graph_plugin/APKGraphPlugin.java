package com.supinepandora43.graph_plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * some javadoc
 */
public class APKGraphPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		project.afterEvaluate(project1 -> {
			project1.getPlugins().getPlugin("com.android.application");
		});
		project.getTasks().create("graph", GraphTask.class);
		project.getExtensions().create("graph", GraphExtension.class);
	}

}
