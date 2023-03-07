package game;

public class all_questions {
    // level 1 questions
    public static Question [] level_1() {
        int score = 2;
        // 1st question
        String question_1 = "What is the capital of Germany?";
        String [] answers_1 = new String [4];
        answers_1[0] = "Bonn";
        answers_1[1] = "Bremen";
        answers_1[2] = "Berlin";
        answers_1[3] = "Oslo";
        int rightOptionInd_1 = 3;
        // 2nd question
        String question_2 = "In which country is Amsterdam situated?";
        String [] answers_2 = new String [4];
        answers_2[0] = "The Netherlands";
        answers_2[1] = "Norway";
        answers_2[2] = "France";
        answers_2[3] = "Sweden";
        int rightOptionInd_2 = 1;
        // 3rd question
        String question_3 = "What is the capital of England?";
        String [] answers_3 = new String [4];
        answers_3[0] = "London";
        answers_3[1] = "New York";
        answers_3[2] = "Edinburgh";
        answers_3[3] = "Stockholm";
        int rightOptionInd_3 = 1;
        // creating questions
        Question q1 = new Question(1, question_1, answers_1, rightOptionInd_1, score);
        Question q2 = new Question(2, question_2, answers_2, rightOptionInd_2, score);
        Question q3 = new Question(3, question_3, answers_3, rightOptionInd_3, score);
        // array of questions
        Question [] questions = new Question [3];
        questions[0] = q1;
        questions[1] = q2;
        questions[2] = q3;
        return questions;
    }

    // level 2 questions
    public static Question [] level_2() {
        int score = 4;
        // 1st question
        String question_1 = "How many official languages does Switzerland have?";
        String [] answers_1 = new String [4];
        answers_1[0] = "1";
        answers_1[1] = "3";
        answers_1[2] = "4";
        answers_1[3] = "2";
        int rightOptionInd_1 = 3;
        // 2nd question
        String question_2 = "In which year did WW2 end?";
        String [] answers_2 = new String [4];
        answers_2[0] = "1944";
        answers_2[1] = "1945";
        answers_2[2] = "1946";
        answers_2[3] = "1947";
        int rightOptionInd_2 = 2;
        // 3rd question
        String question_3 = "In which year did WW2 start?";
        String [] answers_3 = new String [4];
        answers_3[0] = "1939";
        answers_3[1] = "1940";
        answers_3[2] = "1938";
        answers_3[3] = "1941";
        int rightOptionInd_3 = 1;
        // creating questions
        Question q1 = new Question(1, question_1, answers_1, rightOptionInd_1, score);
        Question q2 = new Question(2, question_2, answers_2, rightOptionInd_2, score);
        Question q3 = new Question(3, question_3, answers_3, rightOptionInd_3, score);
        // array of questions
        Question [] questions = new Question [3];
        questions[0] = q1;
        questions[1] = q2;
        questions[2] = q3;
        return questions;
    }

    // level 3 questions
    public static Question [] level_3() {
        int score = 6;
        // 1st question
        String question_1 = "In which year did WW1 start?";
        String [] answers_1 = new String [4];
        answers_1[0] = "1912";
        answers_1[1] = "1913";
        answers_1[2] = "1915";
        answers_1[3] = "1914";
        int rightOptionInd_1 = 4;
        // 2nd question
        String question_2 = "In which year did WW1 end?";
        String [] answers_2 = new String [4];
        answers_2[0] = "1917";
        answers_2[1] = "1918";
        answers_2[2] = "1920";
        answers_2[3] = "1919";
        int rightOptionInd_2 = 2;
        // 3rd question
        String question_3 = "In which year did America gain independence?";
        String [] answers_3 = new String [4];
        answers_3[0] = "1775";
        answers_3[1] = "1778";
        answers_3[2] = "1776";
        answers_3[3] = "1774";
        int rightOptionInd_3 = 3;
        // creating questions
        Question q1 = new Question(1, question_1, answers_1, rightOptionInd_1, score);
        Question q2 = new Question(2, question_2, answers_2, rightOptionInd_2, score);
        Question q3 = new Question(3, question_3, answers_3, rightOptionInd_3, score);
        // array of questions
        Question [] questions = new Question [3];
        questions[0] = q1;
        questions[1] = q2;
        questions[2] = q3;
        return questions;
    }

    // level 4 questions
    public static Question [] level_4() {
        int score = 8;
        // 1st question
        String question_1 = "In which year did Ireland gain independence?";
        String [] answers_1 = new String [4];
        answers_1[0] = "1921";
        answers_1[1] = "1920";
        answers_1[2] = "1922";
        answers_1[3] = "1919";
        int rightOptionInd_1 = 1;
        // 2nd question
        String question_2 = "Which of the following languages is not of the Indo-european origin?";
        String [] answers_2 = new String [4];
        answers_2[0] = "English";
        answers_2[1] = "Italian";
        answers_2[2] = "German";
        answers_2[3] = "Hungarian";
        int rightOptionInd_2 = 4;
        // 3rd question
        String question_3 = "In which year was Beethoven born?";
        String [] answers_3 = new String [4];
        answers_3[0] = "1771";
        answers_3[1] = "1770";
        answers_3[2] = "1773";
        answers_3[3] = "1772";
        int rightOptionInd_3 = 2;
        // creating questions
        Question q1 = new Question(1, question_1, answers_1, rightOptionInd_1, score);
        Question q2 = new Question(2, question_2, answers_2, rightOptionInd_2, score);
        Question q3 = new Question(3, question_3, answers_3, rightOptionInd_3, score);
        // array of questions
        Question [] questions = new Question [3];
        questions[0] = q1;
        questions[1] = q2;
        questions[2] = q3;
        return questions;
    }

    // level 5 questions
    public static Question [] level_5() {
        int score = 10;
        // 1st question
        String question_1 = "Which city is the capital of Lichtenstein?";
        String [] answers_1 = new String [4];
        answers_1[0] = "Bern";
        answers_1[1] = "Salzburg";
        answers_1[2] = "Vaduz";
        answers_1[3] = "Triesen";
        int rightOptionInd_1 = 3;
        // 2nd question
        String question_2 = "In which year Edward VII became king of UK?";
        String [] answers_2 = new String [4];
        answers_2[0] = "1900";
        answers_2[1] = "1901";
        answers_2[2] = "1903";
        answers_2[3] = "1902";
        int rightOptionInd_2 = 4;
        // 3rd question
        String question_3 = "In which year Harald V became king of Norway?";
        String [] answers_3 = new String [4];
        answers_3[0] = "1992";
        answers_3[1] = "1990";
        answers_3[2] = "1991";
        answers_3[3] = "1989";
        int rightOptionInd_3 = 3;
        // creating questions
        Question q1 = new Question(1, question_1, answers_1, rightOptionInd_1, score);
        Question q2 = new Question(2, question_2, answers_2, rightOptionInd_2, score);
        Question q3 = new Question(3, question_3, answers_3, rightOptionInd_3, score);
        // array of questions
        Question [] questions = new Question [3];
        questions[0] = q1;
        questions[1] = q2;
        questions[2] = q3;
        return questions;
    }
}
