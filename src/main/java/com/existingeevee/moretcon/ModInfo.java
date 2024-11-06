package com.existingeevee.moretcon;

public class ModInfo {
    public static final String MODID = "moretcon";
    public static final String NAME = "Moar TCon";
    public static final String VERSION = "V14b2";
    public static final boolean BETA = VERSION.contains("b") || VERSION.contains("rc");
    public static final String DEPENDANCY =
    		"required-after:tconstruct;" +
    		"after:twilightforest;" +
    		"after:thebetweenlands;" +
    		"after:aether_legacy;" +
    		"after:iceandfire;" +
    		"after:plustic;" +
    		"after:crafttweaker";

    public static final String ISSUE_TRACKER = "https://github.com/DabbingEevee/Moar-TCon/issues";

}
