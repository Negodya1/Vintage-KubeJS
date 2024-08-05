package com.negodya1.kubejs.vintageimprovements;

import com.negodya1.kubejs.vintageimprovements.custom.SpringItemBuilder;
import com.negodya1.vintageimprovements.VintageRecipes;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.create.ProcessingRecipeSchema;
import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.recipe.schema.minecraft.ShapedRecipeSchema;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.MapJS;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.util.wrap.TypeWrappers;

import java.util.Map;

/**
 * @author LatvianModder
 */
public class KubeJSVintagePlugin extends KubeJSPlugin {

	private static final Map<VintageRecipes, RecipeSchema> recipeSchemas = Map.of(
			VintageRecipes.VIBRATING, ProcessingRecipeSchema.PROCESSING_WITH_TIME,
			VintageRecipes.POLISHING, PolishingRecipeSchema.POLISHING_PROCESSING,
			VintageRecipes.PRESSURIZING, CompressorRecipeSchema.COMPRESSOR_PROCESSING,
			VintageRecipes.VACUUMIZING, CompressorRecipeSchema.COMPRESSOR_PROCESSING,
			VintageRecipes.COILING, CoilingRecipeSchema.COILING_PROCESSING,
			VintageRecipes.CENTRIFUGATION, CentrifugationRecipeSchema.CENTRIFUGATION_PROCESSING,
			VintageRecipes.CURVING, CurvingRecipeSchema.CURVING_PROCESSING,
			VintageRecipes.HAMMERING, HammeringRecipeSchema.HAMMERING_PROCESSING,
			VintageRecipes.LASER_CUTTING, LaserRecipeSchema.LASER_PROCESSING,
			VintageRecipes.TURNING, ProcessingRecipeSchema.PROCESSING_WITH_TIME
	);


	@Override
	public void init() {
		RegistryInfo.ITEM.addType("vintageimprovements:spring", SpringItemBuilder.class, SpringItemBuilder::new);
	}

	@Override
	public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
		for (var vintageRecipeType : VintageRecipes.values()) {
			if (vintageRecipeType.getSerializer() instanceof ProcessingRecipeSerializer<?>) {
				var schema = recipeSchemas.getOrDefault(vintageRecipeType, ProcessingRecipeSchema.PROCESSING_DEFAULT);
				event.register(vintageRecipeType.getId(), schema);
			}
		}
	}
}