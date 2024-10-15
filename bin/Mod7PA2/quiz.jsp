<%@ page import="java.util.Random" %>
<%
    // Define the number of questions
    int numberOfQuestions = 5;
    Random random = new Random();

    // Generate random numbers for the addition questions
    int[] num1 = new int[numberOfQuestions];
    int[] num2 = new int[numberOfQuestions];

    for (int i = 0; i < numberOfQuestions; i++) {
        num1[i] = random.nextInt(10) + 1; // Random numbers between 1 and 10
        num2[i] = random.nextInt(10) + 1;
    }

    // Store the numbers in session attributes to access them on the result page
    session.setAttribute("num1", num1);
    session.setAttribute("num2", num2);
%>

<html>
<head>
    <title>Addition Quiz</title>
</head>
<body>
    <h2>Addition Quiz</h2>
    <form action="result.jsp" method="post">
        <%
            for (int i = 0; i < numberOfQuestions; i++) {
        %>
            <p>
                <%= num1[i] %> + <%= num2[i] %> = 
                <input type="text" name="answer<%= i %>" size="5">
            </p>
        <%
            }
        %>
        <input type="submit" value="Submit Answers">
    </form>
</body>
</html>
