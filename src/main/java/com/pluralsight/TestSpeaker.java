package com.pluralsight;


import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.repository.SpeakerRepositoryStub;

import java.util.Arrays;
import java.util.List;

public class TestSpeaker {
    public static void main(String[] args) {
        SpeakerRepository repository = new SpeakerRepositoryStub();
        List<Speaker> company = repository.findSpeakerByCompany(Arrays.asList("school", "pluralsight"));
        System.out.println(company.size());
    }
}
