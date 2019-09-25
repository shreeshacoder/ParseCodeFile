import java.io.BufferedReader;
import java.io.IOException;

public interface CodeParseInterface {
    void CodeFileParser(BufferedReader reader, CodeFileMetrics fileMetrics) throws IOException;
}
