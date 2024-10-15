<%@ page import="java.util.*" %>
<%
    // Retrieve the numbers from the session
    int[] num1 = (int[]) session.getAttribute("num1");
    int[] num2 = (int[]) session.getAttribute("num2");
    int numberOfQuestions = num1.length;

    // Initialize variables for tracking correct answers
    int correctCount = 0;

    // Store user's answers and calculate correct answers
    int[] userAnswers = new int[numberOfQuestions];
    int[] correctAnswers = new int[numberOfQuestions];

    for (int i = 0; i < numberOfQuestions; i++) {
        // Parse the user's answers from the request
        String userAnswerStr = request.getParameter("answer" + i);
        userAnswers[i] = userAnswerStr != null ? Integer.parseInt(userAnswerStr) : 0;

        // Calculate the correct answer
        correctAnswers[i] = num1[i] + num2[i];

        // Check if the user's answer is correct
        if (userAnswers[i] == correctAnswers[i]) {
            correctCount++;
        }
    }
%>

<html>
<head>
    <title>Quiz Results</title>
</head>
<body>
    <h2>Quiz Results</h2>
    <p>You answered <%= correctCount %> out of <%= numberOfQuestions %> questions correctly.</p>
    <h3>Details:</h3>
    <ul>
        <%
            for (int i = 0; i < numberOfQuestions; i++) {
        %>
            <li>
                <%= num1[i] %> + <%= num2[i] %> = <%= correctAnswers[i] %>, 
                Your answer: <%= userAnswers[i] %> 
                <%= (userAnswers[i] == correctAnswers[i] ? "(Correct)" : "(Incorrect)") %>
            </li>
        <%
            }
        %>
    </ul>
    <a href="quiz.jsp">Try again</a>
</body>
</html>
