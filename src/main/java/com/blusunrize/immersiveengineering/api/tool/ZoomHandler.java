/*
 * BluSunrize
 * Copyright (c) 2017
 *
 * This code is licensed under "Blu's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package blusunrize.immersiveengineering.api.tool;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * @author BluSunrize - 25.12.2015
 * <p>
 * A handler for IZoomTool fucntionality, allowing items to function as providers for zooming in
 */
public class ZoomHandler
{
	public static float fovZoom = 1;
	public static boolean isZooming = false;

	public static int getCurrentZoomStep(float[] steps)
	{
		int curStep = -1;
		float dist = 0;
		for(int i = 0; i < steps.length; i++)
			if(curStep==-1||Math.abs(steps[i]-ZoomHandler.fovZoom) < dist)
			{
				curStep = i;
				dist = Math.abs(steps[i]-ZoomHandler.fovZoom);
			}
		return curStep;
	}

	/**
	 * @author BluSunrize - 25.12.2015
	 * <p>
	 * An interface to be implemented by items to allow zooming in
	 */
	public interface IZoomTool
	{

		/**
		 * @return whether this item is valid for zooming in
		 */
		boolean canZoom(ItemStack stack, Player player);

		/**
		 * @return the different steps of zoom the item has, sorted from low to high
		 */
		float[] getZoomSteps(ItemStack stack, Player player);
	}
}
