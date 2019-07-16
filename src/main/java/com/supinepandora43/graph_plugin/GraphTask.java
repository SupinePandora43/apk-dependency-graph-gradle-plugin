package com.supinepandora43.graph_plugin;

import org.gradle.api.*;
import org.gradle.api.tasks.TaskAction;

public class GraphTask extends DefaultTask {
	@TaskAction
	public void greet() {
		System.out.println("Hello from " + this.getClass());
	}
}
