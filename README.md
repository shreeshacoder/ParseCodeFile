# Technical Assessment - Show metrics for a code file

## Gotchas

1. Show metrics like lines of code, total comments, multi-line comments, single-line comments.
2. Currently works for code files written in Java, C, C++, JavaScript, Python and Ruby

## Other Key Points

1. Change in the input file in `src/CapitalOneAssessment.java:Line 7`
2. `GenericLineCounter.java` and `PythonRubyLineCounter.java` implement the `CodeParseInterface.java` interface because each of them have a different implementation to count single-line and multi-line comments. 
3. `GenericLineCounter.java` cannot count comments for HTML files.
