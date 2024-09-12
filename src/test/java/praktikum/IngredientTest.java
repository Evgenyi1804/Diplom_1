package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Random;
import  static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final static Random random = new Random();
    private Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] Ingredient() {
        return new Object[][]{
                {IngredientType.FILLING, randomAlphabetic(10), random.nextFloat()},
                {IngredientType.SAUCE, randomAlphabetic(10), random.nextFloat()}
        };
    }

    @Test
    public void TEstGetIngredientType() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void TestGetName() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void TestGetPrice() {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }
}