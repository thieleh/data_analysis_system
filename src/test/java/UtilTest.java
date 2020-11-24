import com.datasystem.controller.Controller;
import com.datasystem.util.Directory;
import com.datasystem.util.FileParser;
import com.datasystem.util.Reader;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    @Test
    public void readAllLines(){
        File file = new File("/home/ilegra/data/in/test.dat");

        Assertions.assertEquals("002ç2345675434544345çJose da SilvaçRural", Reader.fileReader(file).get(2));
    }

    @Test
    public void createDirectory(){

        Directory.newDirectory("dataTest");

        File file = new File( "/home/ilegra/dataTest");
        File file1 = new File( "/home/ilegra/dataTest/in");
        File file2 = new File( "/home/ilegra/dataTest/out");

        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file1.exists());
        Assertions.assertTrue(file2.exists());
    }

    @Test
    public void parserTest(){

        List<String> list = new ArrayList<>();
        list.add("001ç1234567891234çPedroç50000");
        list.add("002ç2345675433444345çEduardo PereiraçRural");
        list.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");

        Assertions.assertEquals(1, FileParser.fileParser(list).getCostumers().size());
        Assertions.assertEquals(1, FileParser.fileParser(list).getSalemen().size());
        Assertions.assertEquals(8, FileParser.fileParser(list).getSales().get(0).getId());
    }

}
