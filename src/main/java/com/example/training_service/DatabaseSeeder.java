package com.example.training_service;

import com.example.training_service.model.Exercise;
import com.example.training_service.repository.ExerciseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private ExerciseRepository repository;

    @Value("${EXERCISEDB_API_KEY:}")
    private String apiKey;
    @Value("${EXERCISEDB_API_URL:}")
    private String apiUrl;

    @Override
    public void run(String... args){
        if (repository.count() == 0) {
            System.out.println("Database empty, importing exercises.");
            importExercises();
        }
    }

    private void importExercises(){
        int offset = 0;
        boolean more = true;
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper om = new ObjectMapper();
        File file = new File("ExerciseData.json");
        List<Exercise> allExercises = new ArrayList<>();

        while (more) {
            URI uri = UriComponentsBuilder.fromUriString(apiUrl)
                    .queryParam("rapidapi-key", apiKey)
                    .queryParam("offset", offset)
                    .build()
                    .toUri();

            Exercise[] response = restTemplate.getForObject(uri, Exercise[].class);

            if (response != null && response.length > 0) {
                repository.saveAll(Arrays.asList(response));
                for (Exercise exercise : response) {
                    allExercises.add(exercise);
                }
                offset += 10;
                if (offset >= 400) more = false;
            } else {
                more = false;
            }
        }

        try{
            om.writeValue(file, allExercises);
            System.out.println("Filed saved to: " + file.getAbsolutePath());
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println("Import finished, imported " + repository.count() + " exercises");
    }
}
