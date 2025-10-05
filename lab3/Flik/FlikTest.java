import static org.junit.Assert.*;
import org.junit.Test;
public class FlikTest {
    @Test (timeout = 1000)
    public void flikLibraryTest(){
        for (int i=0, j=0 ;i<500; j++,i++){
            System.out.println("i:"+i+" j:"+j+ Flik.isSameNumber(i,j));
            assertTrue(Flik.isSameNumber(i,j));
        }
    }
}
