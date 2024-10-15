package Mod7PA2;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class assign38_14 extends HttpServlet {
    private static final int NUMBER_OF_QUESTIONS = 5;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Generate random numbers for the addition questions
        Random random = new Random();
        int[] num1 = new int[NUMBER_OF_QUESTIONS];
        int[] num2 = new int[NUMBER_OF_QUESTIONS];

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            num1[i] = random.nextInt(10) + 1; // Random numbers between 1 and 10
            num2[i] = random.nextInt(10) + 1;
        }

        // Store the numbers in session attributes
        HttpSession session = request.getSession();
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);

        // Forward to the quiz JSP page to display the questions
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the numbers from the session
        HttpSession session = request.getSession();
        int[] num1 = (int[]) session.getAttribute("num1");
        int[] num2 = (int[]) session.getAttribute("num2");

        // Initialize variables for tracking correct answers
        int correctCount = 0;
        int[] userAnswers = new int[NUMBER_OF_QUESTIONS];
        int[] correctAnswers = new int[NUMBER_OF_QUESTIONS];

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
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

        // Store results in the request attributes to display on the result page
        request.setAttribute("correctCount", correctCount);
        request.setAttribute("numberOfQuestions", NUMBER_OF_QUESTIONS);
        request.setAttribute("userAnswers", userAnswers);
        request.setAttribute("correctAnswers", correctAnswers);

        // Forward to the result JSP page to display the results
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
