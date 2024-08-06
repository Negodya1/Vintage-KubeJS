# Links

[![GitHub](https://cdn.modrinth.com/data/cached_images/ceeb2af61953a1741b4cc0a9ed98302e93e5f7e1.png)](https://github.com/Negodya1/Vintage-KubeJS)
[![CurseForge](https://cdn.modrinth.com/data/cached_images/742719616d0e8ce6fc10fbdae2b1eb0a24ea6ff2.png)](https://www.curseforge.com/minecraft/mc-mods/vintage-kubejs)
[![Modrinth](https://cdn.modrinth.com/data/cached_images/a78e162b7b8065d2a35409066cd61e82ccc9e4fb.png)](https://modrinth.com/mod/vintage-kubejs)
[![Discord](https://cdn.modrinth.com/data/cached_images/d293dd00bfd49134e3336d9137b4e5f858be2bd2.png)](https://discord.gg/u6TjVXGT3w)

# Another mods

[![VintageIcon](https://cdn.modrinth.com/data/cached_images/911ea6bfd3d09755f02da33eab9309bbd11b4576.png)](https://github.com/Negodya1/Create-Vintage-Improvements/issues)

# About

[Create: Vintage Improvements](https://modrinth.com/mod/create-vintage-improvements) integration for [KubeJS](https://modrinth.com/mod/kubejs). This mod allows you to add and properly edit recipes of Create: Vintage Improvements mod in KubeJS scripts. All supported recipe types and examples are below.

Supported recipe types:
- vintageimprovementsCentrifugation
- vintageimprovementsCoiling
- vintageimprovementsCurving
- vintageimprovementsHammering
- vintageimprovementsLaserCutting
- vintageimprovementsPolishing
- vintageimprovementsPressurizing (supports .heated() and .superheated())
- vintageimprovementsVacuumizing (supports .heated() and .superheated())
- vintageimprovementsVibrating
- vintageimprovementsTurning

Supported item types:
- vintageimprovements:spring (with setStiffness(int) method)

# Examples

> The example scripts are only here to demonstrate the recipes. They are not meant to be used with the items shown.

### Centrifugation

Syntax: `centrifugation(output[], input[], processing_time, minimal_rpm_requirements)`

> Centrifugation uses the **Centrifuge** with installed **Basins**.

Features:
- supports multiple chance-based outputs
- supports fluid inputs and outputs
- supports `.processingTime()` and `.minimalRPM()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.centrifugation(Fluid.of('create:honey', 1000), 'minecraft:honey_block', 100, 64)
  event.recipes.vintageimprovements.centrifugation(Fluid.of('create:honey', 1000), 'minecraft:honey_block').processingTime(100).minimalRPM(64)
  event.recipes.vintageimprovements.centrifugation([Item.of('minecraft:stick').withChance(0.5), 'minecraft:dead_bush'], '#minecraft:saplings').minimalRPM(128)
})
```

### Coiling

Syntax: `coiling(output[], input, processing_time, spring_color)`

> Coiling uses the **Spring Coiling Machine**

Features:
- supports multiple chance-based outputs
- supports `.processingTime()` and `.springColor()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.coiling('vintageimprovements:iron_spring', 'minecraft:iron_ingot')
  event.recipes.vintageimprovements.coiling('vintageimprovements:steel_spring', 'vintageimprovements:steel_rod').springColor("5D595E")
})
```

### Curving

Syntax: `curving(output[], input)`

> Curving uses the **Curving Press** with **Curving Heads**

Features:
- supports multiple chance-based outputs
- supports `.mode()` and `.head()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.curving('vintageimprovements:vanadium_rod', 'vintageimprovements:vanadium_sheet').mode(3)
  event.recipes.vintageimprovements.curving('minecraft:prismarine_crystals', 'minecraft:lapis_lazuli').head("minecraft:heart_of_the_sea")
})
```

> Item used in .head() must be tagged with `vintageimprovements:curving_heads`

### Hammering

Syntax: `hammering(output[], input[], hammer_blows)`

> Hammering uses the **Helve Hammer** with **Anvil**

Features:
- supports multiple chance-based outputs

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovementsHammering(Item.of('create:iron_sheet', 9), 'minecraft:iron_block', 5)
})
```

### Laser Cutting

Syntax: `laser_cutting(output[], input)`

> Laser Cutting uses the **Laser**

Features:
- supports multiple chance-based outputs
- supports `.energyCost()` and `.maxChargeRate()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.laser_cutting(Item.of('minecraft:iron_bars', 24), 'minecraft:iron_block').energyCost(5000).maxChargeRate(500)
})
```

### Grinder Polishing

Syntax: `polishing(output[], input)`

> Grinder Polishing uses the **Belt Grinder**

Features:
- supports multiple chance-based outputs
- supports `.processingTime()`, `.fragile()` and `.speedLimits()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.polishing('minecraft:diamond', 'minecraft:coal_block').speedLimits(1).fragile()
  event.recipes.vintageimprovements.polishing('minecraft:diamond', 'minecraft:coal_block').processingTime(500)
  event.recipes.vintageimprovements.polishing(['minecraft:diamond', Item.of('minecraft:diamond').withChance(0.5)], 'minecraft:coal_block')
})
```

### Pressurizing

Syntax: `pressurizing(output[], input[])`

> Pressurizing uses the **Compressor**, **Basin**, and optionally a **Blaze Burner**

Features:
- supports multiple chance-based outputs
- supports fluid inputs and outputs
- supports `.heated()` and `.superheated()`
- supports `.processingTime()`, `.secondaryFluidInput()` and `.secondaryFluidOutput()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.pressurizing(Fluid.of('vintageimprovements:sulfur_dioxide', 1000), '#forge:gems/sulfur').heated().secondaryFluidOutput(0)
  event.recipes.vintageimprovements.pressurizing(Fluid.of('vintageimprovements:sulfuric_acid', 1000), [Fluid.of('vintageimprovements:sulfur_trioxide', 1000), Fluid.of('minecraft:water', 1000)]).secondaryFluidInput(1)
})
```

### Turning

Syntax: `turning(output[], input)`

> Turning uses the **Lathe**

Features:
- supports multiple chance-based outputs
- supports `.processingTime()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.turning(Item.of('create:fluid_pipe', 12), 'minecraft:copper_block').processingTime(300)
})
```

### Vacuumizing

Syntax: `vacuumizing(output[], input)`

> Vacuumizing uses the **Compressor**, **Basin**, and optionally a **Blaze Burner**

Features:
- supports multiple chance-based outputs
- supports fluid inputs and outputs
- supports `.heated()` and `.superheated()`
- supports `.processingTime()`, `.secondaryFluidInput()` and `.secondaryFluidOutput()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.vacuumizing('minecraft:powder_snow_bucket', ['minecraft:bucket', 'minecraft:snow_block']).processingTime(500)
})
```

### Vibrating

Syntax: `vibrating(output[], input)`
> Vibrating uses the **Vibrating Table**

Features:
- supports multiple chance-based outputs
- supports `.processingTime()`

```js
ServerEvents.recipes(event => {
  event.recipes.vintageimprovements.vibrating('minecraft:flint', 'minecraft:gravel')
  event.recipes.vintageimprovements.vibrating(['minecraft:flint', Item.of('minecraft:gravel').withChance(0.1)], 'minecraft:gravel')
})
```

### Spring Item

Item type: `'vintageimprovements:spring'`

Features:
- supports `.setStiffness()`

```js
ServerEvents.recipes(event => {
  event.create("small_spring", 'vintageimprovements:spring').texture("example:item/small_spring").tag("vintageimprovements:small_springs")
  event.create("spring", 'vintageimprovements:spring').texture("example:item/spring").tag("vintageimprovements:springs").setStiffness(150)
})
```
