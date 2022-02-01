package com.TMachinery;

import net.minecraft.util.IStringSerializable;

public enum TBlockState implements IStringSerializable {
    OFF("off"),
    WORKING("working"),
    NOPOWER("nopower");

    // Optimization
    public static final TBlockState[] VALUES = TBlockState.values();

    private final String name;

    TBlockState(String name) {
        this.name = name;
    }

	@Override
	public String getSerializedName() {
		// TODO Auto-generated method stub
		return name;
	}
}
