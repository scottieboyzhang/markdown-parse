import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks()throws IOException{
        List<String> expect = List.of("https://something.com","some-page.html");
        Path fileName = Path.of("test-file2.md");
        String contents = Files.readString(fileName);
        assertEquals(expect, MarkdownParse.getLinks(contents));     
   
    }
}