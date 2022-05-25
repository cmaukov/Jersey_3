package com.pluralsight.repository;

import com.pluralsight.model.Speaker;
import com.pluralsight.model.SpeakerSearch;

import java.util.ArrayList;
import java.util.List;

public class SpeakerRepositoryStub implements SpeakerRepository {

    private static List<Speaker> speakers = new ArrayList<>();

    static {
        Speaker speaker1 = new Speaker();
        speaker1.setId(1L);
        speaker1.setName("Bryan");
        speaker1.setCompany("Pluralsight");

        speakers.add(speaker1);

        Speaker speaker2 = new Speaker();
        speaker2.setId(2L);
        speaker2.setName("Roger");
        speaker2.setCompany("Wilco");

        speakers.add(speaker2);
    }

    public SpeakerRepositoryStub() {

    }

    @Override
    public List<Speaker> findAll() {
        return speakers;
    }

    @Override
    public Speaker findById(Long id) {
        return findSpeakerById(speakers, id);
    }

    @Override
    public Speaker create(Speaker speaker) {
        speaker.setId(speakers.size() + 1L);
        speakers.add(speaker);

        return speaker;
    }

    @Override
    public Speaker update(Speaker speaker) {
        Speaker storedSpeaker = findSpeakerById(speakers, speaker.getId());

        storedSpeaker.setName(speaker.getName());
        storedSpeaker.setCompany(speaker.getCompany());

        return storedSpeaker;
    }

    @Override
    public void delete(Long id) {
        Speaker speaker = findSpeakerById(speakers, id);

        speakers.remove(speaker);
    }

    @Override
    public List<Speaker> findByCompany(List<String> companies, int ageFromVal, int ageToVal) {
        //select * from speakers where company in [?,?] and age > ? and age < ?

//        List<Speaker> speakers = new ArrayList<>();
//
//        Speaker speaker = new Speaker();
//        speaker.setName("Randy");
//        speaker.setCompany("Snowbird");
//        speaker.setId(78L);
//
//        speakers.add(speaker);
//
//        return speakers;
        return speakers.stream().filter(s -> companies.contains(s.getCompany())).toList();
    }

    @Override
    public List<Speaker> findByConstraints(SpeakerSearch speakerSearch) {
        System.out.println(speakerSearch.getSearchType());

        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setName("Randy");
        speaker.setCompany("Snowbird");
        speaker.setId(78L);

        speakers.add(speaker);

        return speakers;
    }

    private Speaker findSpeakerById(List<Speaker> speakers, Long id) {
        return speakers.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
}
