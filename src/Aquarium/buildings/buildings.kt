package Aquarium.buildings

open class BaseBuildingMaterial() {
    open val numberNeeded = 1
}

class Wood: BaseBuildingMaterial(4)
class Brick: BaseBuildingMaterial(8)

class Building(val buildingMaterial: BaseBuildingMaterial){
    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = 100/this.buildingMaterial.numberNeeded
}
