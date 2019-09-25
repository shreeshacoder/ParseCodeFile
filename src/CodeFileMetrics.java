public class CodeFileMetrics {
    private int lineCount, commentLines, singleCommentLines, todoCount, commentsInBlock, commentBlocks;

    public CodeFileMetrics() {
        this.lineCount = 0;
        this.commentLines = 0;
        this.singleCommentLines = 0;
        this.todoCount = 0;
        this.commentsInBlock = 0;
        this.commentBlocks = 0;

    }

    //  Setters and Getters for

    public int getLineCount() {
        return this.lineCount;
    }

    public void incrementLineCount() {
        this.lineCount++;
    }

    public int getCommentLines() {
        return this.commentLines;
    }

    public void incrementCommentLines() {
        this.commentLines++;
    }

    public int getSingleCommentLines() {
        return this.singleCommentLines;
    }

    public void incrementSingleCommentLines() {
        this.singleCommentLines++;
    }

    public void decrementSingleCommentLines() {
        this.singleCommentLines--;
    }

    public int getTodoCount() {
        return this.todoCount;
    }

    public void incrementTodoCount() {
        this.todoCount++;
    }

    public int getCommentsInBlock() {
        return this.commentsInBlock;
    }

    public void incrementCommentsInBlock() {
        this.commentsInBlock++;
    }

    public int getCommentBlocks() {
        return this.commentBlocks;
    }

    public void incrementCommentBlocks() {
        this.commentBlocks++;
    }


}
