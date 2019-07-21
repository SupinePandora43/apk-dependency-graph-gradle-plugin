package com.supinepandora43.graph_plugin;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

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

	@Test
	public void GraphTask() {
		try {
			ReadableByteChannel rbc = Channels.newChannel(new URL("https://github.com/SupinePandora43/Russian/releases/download/untagged-fe60576ceefbd6fd674b/app-debug.apk").openStream());
			String s = File.separator;
			String path = this.project.getBuildDir().getAbsolutePath() + s + "outputs" + s + "apk" + s + "debug" + s + "app-debug.apk";
			this.project.file(path).getParentFile().mkdirs();
			this.project.file(path).createNewFile();
			FileOutputStream fos = new FileOutputStream(path);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.project.getTasks().getByName("graph").getActions().get(0).execute(this.project.getTasks().getByName("graph"));
	}
}
