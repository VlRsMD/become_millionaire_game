package game;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;

public class QuestionsBank {
    public List<Question> allQuestions;
    public int numberOfLevels;

    public QuestionsBank() {
        QuestionsCollector questionsCollector = new QuestionsCollector();
        try {
            this.allQuestions = questionsCollector.collectQuestions();
            this.numberOfLevels = questionsCollector.findNumberOfLevels();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getAllQuestions() {
        return allQuestions;
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }
}
