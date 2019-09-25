import java.io.BufferedReader;
import java.io.IOException;

// Class to give file metrics for Python or Ruby code
public class PythonRubyLineCounter implements CodeParseInterface {
    @Override
    public void CodeFileParser(BufferedReader reader, CodeFileMetrics fileMetrics) throws IOException {
        String line;
        boolean previousLineIsComment = false, currentlyInCommentBlock = false;
        while ((line = reader.readLine()) != null) {
            fileMetrics.incrementLineCount();
            //  Check for comments
            if (line.contains("#")) {  // single-line comment
                fileMetrics.incrementCommentLines();
                if(previousLineIsComment){
                    if(!currentlyInCommentBlock){
                        fileMetrics.incrementCommentsInBlock();
                        fileMetrics.incrementCommentBlocks();
                        fileMetrics.decrementSingleCommentLines();
                        currentlyInCommentBlock = true;
                    }
                    fileMetrics.incrementCommentsInBlock();
                }
                 else {
                    fileMetrics.incrementSingleCommentLines();
                }
                previousLineIsComment = true;
                if (line.contains("TODO")) {
                    fileMetrics.incrementTodoCount();
                }
            }
            else{
                previousLineIsComment = false;
                currentlyInCommentBlock = false;
            }

        }
    }
}
