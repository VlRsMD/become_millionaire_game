package game;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuestionsBank {
    public List<Question> createQuestions() throws IOException {
        List<Question> list = new ArrayList<Question>();
        String file = "questions.txt";
        Scanner scanner = new Scanner(new File(file));
        ObjectMapper mapper = new ObjectMapper();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                Question question = mapper.readValue(line, Question.class);
                list.add(question);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
        return list;
    }

    public int getNumberOfLevels() throws IOException {
        int max = createQuestions().get(0).getLevel();
        for (int i = 1; i < createQuestions().size(); i ++) {
            if (createQuestions().get(i).getLevel() > max) {
                max = createQuestions().get(i).getLevel();
            }
        }
        return max;
    }
}
