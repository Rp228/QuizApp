package com.rishabh.quizapp.controller;

import com.rishabh.quizapp.model.Questions;
import com.rishabh.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        System.out.println("getting all questions");
        return questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions> >getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);


    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }
    @DeleteMapping("delete")
    public String deleteQuestion(@RequestBody Questions question){
        return questionService.deleteQuestion(question);
    }
    @PutMapping("update")
    public String updateQuestion(@RequestBody Questions question){
        return questionService.updateQuestion(question);

    }
}
