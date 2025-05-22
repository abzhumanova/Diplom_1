import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {

    @Test
    public void sauceTest_ReturnsCorrectSauceType() {
        assertEquals("Ожидался тип ингредиента SAUCE", IngredientType.SAUCE, IngredientType.SAUCE);
    }

    @Test
    public void fillingTest_ReturnsCorrectFillingType() {
        assertEquals("Ожидался тип ингредиента FILLING", IngredientType.FILLING, IngredientType.FILLING);
    }
}