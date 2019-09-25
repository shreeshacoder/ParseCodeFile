import java.io.BufferedReader;
import java.io.IOException;

// Class to give you file metrics for a generic programming languages: Java, JavaScript, C, C++
public class GenericLineCounter implements CodeParseInterface {
    @Override
    public void CodeFileParser(BufferedReader reader, CodeFileMetrics fileMetrics) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            fileMetrics.incrementLineCount();
            //  Check for comments
            if (line.contains("//")) {  // single-line comment
                fileMetrics.incrementCommentLines();
                fileMetrics.incrementSingleCommentLines();
                if (line.contains("TODO")) {
                    fileMetrics.incrementTodoCount();
                }
            } else if (line.contains("/*")) { // Multi-line comment
                fileMetrics.incrementCommentLines();
                fileMetrics.incrementCommentBlocks();
                fileMetrics.incrementCommentsInBlock();

                // Check if multi-line comment ends in the same line
                if(!line.contains(("*/"))){
                    while ((line = reader.readLine()) != null) {
                        fileMetrics.incrementLineCount();
                        fileMetrics.incrementCommentLines();
                        fileMetrics.incrementCommentsInBlock();
                        if (line.contains("TODO")) {
                            fileMetrics.incrementTodoCount();
                        }
                        if(line.contains("*/")){
                            break;
                        }
                    }
                }
            }

        }
    }
}