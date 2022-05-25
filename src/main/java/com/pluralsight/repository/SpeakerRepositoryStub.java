package com.pluralsight.repository;
/* conference-service
 * @created 05/20/2022
 * @author Konstantin Staykov
 */

import com.pluralsight.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class SpeakerRepositoryStub implements SpeakerRepository {
    private static List<Speaker> speakers = new ArrayList<>();

    public SpeakerRepositoryStub() {

        speakers.add(new Speaker(1L, "bob", "pluralsight"));
        speakers.add(new Speaker(2L, "ivan", "school"));
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
        Speaker storedSpeaker = findById(speaker.getId());

        storedSpeaker.setName(speaker.getName());
        storedSpeaker.setCompany(speaker.getCompany());
        return storedSpeaker;
    }

    @Override
    public void delete(Long id) {
        Speaker speaker = findSpeakerById(speakers, id);
        if (speaker == null) return;
        speakers.remove(speaker);
    }

    @Override
    public List<Speaker> findSpeakerByCompany(List<String> companies) {
        return speakers.stream().filter(s -> companies.contains(s.getCompany())).toList();

    }

    private Speaker findSpeakerById(List<Speaker> speakers, Long id) {
        return speakers.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
}
