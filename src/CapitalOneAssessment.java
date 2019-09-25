import java.io.*;
import java.util.*;

public class CapitalOneAssessment {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("resources/inputFiles/invalidFile3.");

            if(!file.getName().matches("^\\w+\\.\\w+")){
                System.out.println("Invalid filename");
                return;
            }

            // File extensions can be uppercase
            String extension = file.getName().substring(file.getName().lastIndexOf('.')+1).toLowerCase();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            CodeParseInterface codeParser;

            CodeFileMetrics fileMetrics = new CodeFileMetrics();

            // Python and Ruby have the same logic for identifying single-line and multi-line comment
            if(extension.equals(("py")) || extension.equals(("rb"))){
                codeParser = new PythonRubyLineCounter();
            }
            else {
                // Assuming other languages are Java, C++, C, JavaScript
                codeParser = new GenericLineCounter();
            }

            codeParser.CodeFileParser(reader, fileMetrics);

            System.out.println("Total # of lines: "+fileMetrics.getLineCount());
            System.out.println("Total # of comment lines: "+fileMetrics.getCommentLines());
            System.out.println("Total # of single line comments: "+fileMetrics.getSingleCommentLines());
            System.out.println("Total # of comment lines within block comments: "+fileMetrics.getCommentsInBlock());
            System.out.println("Total # of block line comments: "+fileMetrics.getCommentBlocks());
            System.out.println("Total # of TODO’s: "+fileMetrics.getTodoCount());
            reader.close();

        } catch (Exception e)
        {
            System.out.println("Unexpected Error: "+e);
        }
    }

}
