package com.supinepandora43.graph_plugin;

import com.alex_zaitsev.adg.Main;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class GraphTask extends DefaultTask {
	@TaskAction
	public void run() {
		System.out.println("Hello from " + this.getClass());
		GraphExtension extension = (GraphExtension) getProject().getExtensions().getByName("graph");
		String s = File.separator;
		String path = "outputs" + s + "apk" + s + "release" + s + "app-release-unsigned.apk";
		if (extension.type == GraphExtension.Type.DEBUG) {
			path = "outputs" + s + "apk" + s + "debug" + s + "app-debug.apk";
		}
		path = getProject().getBuildDir() + s + path;
//		String filterText =
//			"{\n" +
//				"    \"package-name\": " + extension.packageName + ",\n" +
//				"    \"show-inner-classes\": " + extension.showInnerClasses + ",\n" +
//				"    \"ignored-classes\": " + extension.ignoredClasses.toString() + "\n" +
//				"}";
		String filterText = "{\n" +
			"    \"package-name\": \"\",\n" +
			"    \"show-inner-classes\": false,\n" +
			"    \"ignored-classes\": [] "+
			"}\n";
		File filterFile = getProject().file(getProject().getBuildDir() + s + "graph" + s + "filter.json");
		try {
			filterFile.getParentFile().mkdirs();
			filterFile.createNewFile();
			FileWriter FW = new FileWriter(filterFile.getAbsolutePath());
			FW.write(filterText);
			FW.close();
			File idk = getProject().file(getProject().getBuildDir()+s+"graph"+s+"gui"+s+"analyzed.js");
			idk.getParentFile().mkdirs();
			idk.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.main(new String[]{
			"-i", getProject().getBuildDir().getAbsolutePath() + "/graph/output",
			"-o", getProject().getBuildDir().getAbsolutePath() + "/graph/gui/analyzed.js",
			"-f", filterFile.getAbsolutePath(),
			"-d", extension.showInnerClasses ? "true" : "false",
			"-a", path
		});
	}
}
