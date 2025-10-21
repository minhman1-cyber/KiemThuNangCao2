import org.example.ArraySumService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArraySumTest {

    private ArraySumService arraySumService;
    @BeforeEach
    public void setUp(){
        arraySumService = new ArraySumService();
    }

    @Test
    public void testCase1(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(55, arraySumService.sumArray(arr));
    }

    @Test
    public void testCase2(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10000};
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->{
            arraySumService.sumArray(arr);
        });
        assertEquals("Phan tu nam trong khoang tu 0 den 1000", ex.getMessage());
    }
}
