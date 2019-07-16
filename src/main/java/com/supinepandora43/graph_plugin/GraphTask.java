package com.supinepandora43.graph_plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class GraphTask extends DefaultTask {
	@TaskAction
	public void run() {
		System.out.println("Hello from " + this.getClass());
	}
}
