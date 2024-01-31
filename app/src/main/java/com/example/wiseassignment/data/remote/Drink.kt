package com.example.wiseassignment.data.remote

//import com.example.wiseassignment.domain.model.ingredient
//import com.example.wiseassignment.domain.model.instruction
//import com.example.wiseassignment.domain.model.measure
import com.example.wiseassignment.domain.model.ingredient
import com.example.wiseassignment.domain.model.instruction
import com.example.wiseassignment.domain.model.measure
import com.example.wiseassignment.domain.model.product

data class Drink(
    val dateModified: String,
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrink: String,
    val strDrinkAlternate: Any,
    val strDrinkThumb: String,
    val strGlass: String,
    val strIBA: String,
    val strImageAttribution: String,
    val strImageSource: String,
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strIngredient7: Any,
    val strIngredient8: Any,
    val strIngredient9: Any,
    val strIngredient10: Any,
    val strIngredient11: Any,
    val strIngredient12: Any,
    val strIngredient13: Any,
    val strIngredient14: Any,
    val strIngredient15: Any,
    val strInstructions: String,
    val strInstructionsDE: String,
    val strInstructionsES: String,
    val strInstructionsFR: Any,
    val strInstructionsIT: String,
    val strInstructionsZH_HANS: Any,
    val strInstructionsZH_HANT: Any,
    val strMeasure1: String,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: String,
    val strMeasure6: Any,
    val strMeasure7: Any,
    val strMeasure8: Any,
    val strMeasure9: Any,
    val strMeasure10: Any,
    val strMeasure11: Any,
    val strMeasure12: Any,
    val strMeasure13: Any,
    val strMeasure14: Any,
    val strMeasure15: Any,
    val strTags: String,
    val strVideo: String
)

fun Drink.toproduct() : product {
    return product(strDrinkThumb,strDrink,strCategory)
}
fun Drink.tomeasures() : measure {
    return measure(arrayListOf(strMeasure1,strMeasure2,strMeasure3,strMeasure4,strMeasure5,strMeasure6, strMeasure7, strMeasure8,strMeasure9,strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15))
}
fun Drink.toingredient() : ingredient {
    return ingredient(arrayListOf(strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10, strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15))
}
fun Drink.toinstruction() : instruction {
    return instruction(arrayListOf(strInstructions, strInstructionsDE, strInstructionsES, strInstructionsFR, strInstructionsIT, strInstructionsZH_HANS, strInstructionsZH_HANT))
}
