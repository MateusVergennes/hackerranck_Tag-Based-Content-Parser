# Tag-Based Content Parser

The solution is illustrated in the flowchart below:

![Flowchart] ![diagram](https://github.com/user-attachments/assets/ae6084b1-f42c-450c-a36d-eb5ba00e4bf3)

## Test Results

The following are the results of the tests conducted:

![Test Results](![solutionResult](https://github.com/user-attachments/assets/f582967b-c1a4-4940-b2a1-f4dbfc369e82))


## Problem Statement

In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag like `<tag>contents</tag>`. Note that the corresponding end tag starts with a `/`.

Given a string of text in a tag-based language, the task is to parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting the following criterion:

- The name of the start and end tags must be the same. The HTML code `<h1>Hello World</h2>` is not valid because the text starts with an `h1` tag and ends with a non-matching `h2` tag.
- Tags can be nested, but content between nested tags is considered not valid. For example, in `<h1><a>contents</a>invalid</h1>`, `contents` is valid but `invalid` is not valid.
- Tags can consist of any printable characters.

### Input Format

- The first line contains a single integer, \( n \) (the number of lines).
- The subsequent lines each contain a line of text.

### Constraints

- Each line contains a maximum of 10,000 printable characters.
- The total number of characters in all test cases will not exceed 1,000,000.

### Output Format

For each line, print the content enclosed within valid tags. If a line contains multiple instances of valid content, print out each instance of valid content on a new line; if no valid content is found, print `None`.

### Sample Input
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush

## Solution Approach

The solution to the problem was implemented as illustrated in the flowchart. The main steps are as follows:

1. **Read Input**: Read the number of test cases and each line of text.
2. **Validate Input**: Check for the constraints on line length and total character count.
3. **Parse Tags**:
   - Locate opening tags.
   - Match them with corresponding closing tags.
   - Retrieve content that is not nested within other tags.
4. **Output Results**: Print valid content or `None` if no valid content is found.
