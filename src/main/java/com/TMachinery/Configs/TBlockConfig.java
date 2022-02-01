package com.TMachinery.Configs;

import com.TMachinery.*;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class TBlockConfig {
	
	   public static final String CATEGORY_GENERAL = "general";
	    public static final String CATEGORY_POWER = "power";
	    public static final String SUBCATEGORY_TBLOCK = "TBlock";

	    public static ForgeConfigSpec SERVER_CONFIG;
	    public static ForgeConfigSpec CLIENT_CONFIG;

	    public static ForgeConfigSpec.IntValue TBLOCK_MAXPOWER;
	    public static ForgeConfigSpec.IntValue TBLOCK_GENERATE; //If this was a generator
	    public static ForgeConfigSpec.IntValue TBLOCK_SEND; //Energy sent to the network
	    public static ForgeConfigSpec.IntValue TBLOCK_TICKS;
	    
	    static {

	        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
	        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

	        CLIENT_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
	        //ROTATION_SPEED = CLIENT_BUILDER.comment("Rotation speed of the magic block").defineInRange("rotationSpeed", 100.0, 0.0, 1000000.0);
	        CLIENT_BUILDER.pop();

	        SERVER_BUILDER.comment("Power settings").push(CATEGORY_POWER);

	        setupFirstBlockConfig(SERVER_BUILDER, CLIENT_BUILDER);

	        SERVER_BUILDER.pop();


	        SERVER_CONFIG = SERVER_BUILDER.build();
	        CLIENT_CONFIG = CLIENT_BUILDER.build();
	    }

	    private static void setupFirstBlockConfig(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
	        SERVER_BUILDER.comment("TMachinery settings").push(SUBCATEGORY_TBLOCK);

	        TBLOCK_MAXPOWER = SERVER_BUILDER.comment("Maximum stored power for the Transmutation Machine")
	                .defineInRange("maxPower", 1000000, 0, Integer.MAX_VALUE);
	        TBLOCK_GENERATE = SERVER_BUILDER.comment("Power generation per %Insert Mat%")
	                .defineInRange("generate", 1000, 0, Integer.MAX_VALUE);
	        TBLOCK_SEND = SERVER_BUILDER.comment("Power generation to send per tick")
	                .defineInRange("send", 100, 0, Integer.MAX_VALUE);
	        TBLOCK_TICKS = SERVER_BUILDER.comment("Ticks per diamond")
	                .defineInRange("ticks", 20, 0, Integer.MAX_VALUE);

	        SERVER_BUILDER.pop();
	    }

	    @SubscribeEvent
	    public static void onLoad(final ModConfig.Loading configEvent) {

	    }

	    @SubscribeEvent
	    public static void onReload(final ModConfig.Reloading configEvent) {
	    }

}
