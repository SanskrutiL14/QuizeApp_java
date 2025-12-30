import java.util.*;

class Question {
    String question;
    String[] options;
    int correctOption; 

    Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"1. super", "2. this", "3. extends", "4. implements"},
                3
        ));
        questions.add(new Question(
                "Which language runs in a web browser?",
                new String[]{"1. Java", "2. C", "3. Python", "4. JavaScript"},
                4
        ));
        questions.add(new Question(
                "Which company developed Java?",
                new String[]{"1. Microsoft", "2. Sun Microsystems", "3. Google", "4. Oracle"},
                2
        ));
        questions.add(new Question(
                "Which data structure uses FIFO order?",
                new String[]{"1. Stack", "2. Queue", "3. Array", "4. LinkedList"},
                2
        ));
        questions.add(new Question(
                "Which of these is not a primitive data type in Java?",
                new String[]{"1. int", "2. boolean", "3. String", "4. double"},
                3
        ));

        System.out.println("Welcome to the Online Quiz!");
        System.out.println("You will get 10 seconds to answer each question.");
        System.out.println("--------------------------------------------");

        int score = 0;
        int qNo = 1;

        for (Question q : questions) {
            System.out.println("\nQ" + qNo + ": " + q.question);
            for (String opt : q.options) {
                System.out.println(opt);
            }

            long startTime = System.currentTimeMillis();
            int answer = 0;

            while ((System.currentTimeMillis() - startTime) < 10000 && answer == 0) {
                System.out.print("Your answer (1-4): ");
                if (sc.hasNextInt()) {
                    answer = sc.nextInt();
                } else {
                    sc.next(); 
                }
            }

            if (answer == 0) {
                System.out.println("Time's up! Moving to next question.");
            } else if (answer == q.correctOption) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.correctOption);
            }

            qNo++;
        }

        System.out.println("\nQuiz Over! Your score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("Excellent! Perfect score!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Good job! Keep practicing.");
        } else {
            System.out.println("📚 Keep learning and try again!");
        }
    }
}
