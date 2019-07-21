package com.supinepandora43.graph_plugin;

public class GraphExtension {
	enum Type {
		DEBUG,
		RELEASE
	}

	boolean test = false;
	Type type = Type.DEBUG;
	String packageName = "";
	String[] ignoredClasses = new String[]{".*Dagger.*", ".*Inject.*", ".*ViewBinding$", ".*Factory$", ".*_.*", "^R$", "^R\\$.*"};
	boolean showInnerClasses = false;
}
